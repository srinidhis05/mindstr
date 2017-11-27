package com.mindster.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mindster.DTO.JiraDto.*;
import com.mindster.DTO.JiraDto.JiraLinkedIssuesDto.JiraIssueLinksDto;
import com.mindster.DTO.MindsterDto.*;
import com.mindster.DTO.MoztrapDto.MoztrapResponseMainDto;
import com.mindster.DTO.MoztrapDto.MoztrapStepsDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vinodbalasu on 17/12/16.
 */
public class MindstrService {

    @Autowired
    MoztrapService moztrapService;

    @Autowired
    JiraService jiraService;

    @Autowired
    MindstrResponseMainDto mindstrResponseMainDto;

    @Autowired
    JiraResponseDTO jiraResponseDTO;




    public MoztrapResponseMainDto getMoztrapResponseById(String caseId) throws Exception {
        return moztrapService.getMoztrapDTOFromJson(caseId);
    }

    public MindstrResponseMainDto getMindstrResponseMainDto(String jiraId) throws Exception {
        jiraResponseDTO = jiraService.getJiraDTOFromJson(jiraId);
        mindstrResponseMainDto.setJiraId(jiraResponseDTO.getKey());
        Map<String,Object> customFieldMap =  JiraService.getCustomFields(jiraResponseDTO,JiraService.getCustomFieldMapping());
        mindstrResponseMainDto.setIssuetype(extractMindstrIssueType(customFieldMap).getName());
        mindstrResponseMainDto.setSummary(customFieldMap.get("summary").toString());
        MindstrReleaseDto mindstrReleaseDto = new MindstrReleaseDto();
        mindstrReleaseDto.setReleaseLabel(customFieldMap.get("labels").toString());
        mindstrResponseMainDto.setMindstrReleaseDto(mindstrReleaseDto);
        mindstrResponseMainDto.setMindstrStatus(extractMindstrStatus(customFieldMap).getName());
//        extractMindstrResources();
//        extractmindStrPeople();
        MindstrDescriptionDto mindstrDescriptionDto = new MindstrDescriptionDto();
        mindstrDescriptionDto.setMindstrDescriptionProperties(extractDescriptionProps(jiraId));
        mindstrDescriptionDto.setDescriptionInfo(extractDescriptionInfo(customFieldMap));
        mindstrResponseMainDto.setMindstrDescriptionDto(mindstrDescriptionDto);
        mindstrResponseMainDto.setMindstrLinkedIssuesList(extractMindstrLinkedIssues(customFieldMap));
        MindstrResources mindstrResources = new MindstrResources();
        mindstrResources.setResourcesLinks(resourceURLs);
        mindstrResponseMainDto.setMindstrResources(mindstrResources);
        mindstrResponseMainDto.setMindStrPeople(extractMindstrPeople(jiraId, customFieldMap));
        mindstrResponseMainDto.setMindstrScenariosDto(extractMindstrScenarios(jiraId, customFieldMap));
        mindstrResponseMainDto.setFeatureRecordings(FEATURE_RECORDING);
        return mindstrResponseMainDto;
    }

    public MindstrScenariosDto extractMindstrScenarios(String jiraId, Map<String, Object> customFieldMap) throws Exception {
        MindstrScenariosDto mindstrScenariosDto = new MindstrScenariosDto();
        MoztrapService moztrapService = new MoztrapService();
        Object obj = customFieldMap.get("customfield_15870");
        MoztrapResponseMainDto moztrapResponseMainDto = moztrapService.getMoztrapDTOFromJson(obj.toString());
        List<MoztrapStepsDto> mindstrSteps = new ArrayList<>();
        MoztrapStepsDto[] moztrapStepsDtos = moztrapResponseMainDto.getSteps();
        for(int counter = 0 ; counter < moztrapStepsDtos.length ; counter++){
            MoztrapStepsDto moztrapStepsDtoTemp = new MoztrapStepsDto();
            moztrapStepsDtoTemp.setInstruction(moztrapStepsDtos[counter].getInstruction());
            moztrapStepsDtoTemp.setExpected(moztrapStepsDtos[counter].getExpected());
            mindstrSteps.add(moztrapStepsDtoTemp);
        }
        mindstrScenariosDto.setName(moztrapResponseMainDto.getName());
        mindstrScenariosDto.setCreated_by(moztrapResponseMainDto.getCreated_by());
        mindstrScenariosDto.setId(moztrapResponseMainDto.getId());
        mindstrScenariosDto.setPriority(moztrapResponseMainDto.getPriority());
        mindstrScenariosDto.setTags(moztrapResponseMainDto.getTags());
        mindstrScenariosDto.setSuites(moztrapResponseMainDto.getSuites());
        mindstrScenariosDto.setSteps(mindstrSteps);
        return mindstrScenariosDto;
    }

    private Map<String, String> extractMindstrPeople(String jiraId, Map<String, Object> customFieldMap) {
        Map<String, String> mindstrPeople = new HashMap<>();

        //Reporter
        Object objReporter = customFieldMap.get("creator");
        Type type = new TypeToken<People>() {
        }.getType();
        People peopleReporter = (People) JiraService.convertJsonToDTO(new Gson().toJson(objReporter), type);
        mindstrPeople.put("Reporter",peopleReporter.getName());

//        //Assigned QA
//        Object objAssignedQa = customFieldMap.get("customfield_15013");
//        People peopleAssignedQa = (People) JiraService.convertJsonToDTO(new Gson().toJson(objAssignedQa), type);
//        mindstrPeople.put("Assigned_QA",peopleAssignedQa.getName());

        //Assignee
        Object objAssignee = customFieldMap.get("assignee");
        People peopleAssignee = (People) JiraService.convertJsonToDTO(new Gson().toJson(objAssignee), type);
        mindstrPeople.put("Assignee",peopleAssignee.getName());
        return mindstrPeople;
    }

    private JiraIssueType extractMindstrIssueType(Map<String, Object> customFieldMap) {
        return (JiraIssueType) JiraService.convertJsonToDTO(new Gson().toJson(customFieldMap.get("issuetype")),JiraIssueType.class.getCanonicalName());
    }

    private String extractDescriptionInfo(Map<String, Object> customFieldMap) {
        String description = new Gson().toJson(customFieldMap.get("description"));
        for(String url : extractUrls(description)){
            resourceURLs.add(url);
        }
        return description;
    }

    private JiraStatusDto extractMindstrStatus(Map<String, Object> customFieldMap) {
        return (JiraStatusDto) JiraService.convertJsonToDTO(new Gson().toJson(customFieldMap.get("status")), JiraStatusDto.class);
    }


    public List<MindstrLinkedIssues> extractMindstrLinkedIssues(Map<String, Object> customFieldMap){
        List<MindstrLinkedIssues> mindstrLinkedIssuesList = new ArrayList<>();
        Map<String,String> linkedIssuesIdSummary = new HashMap<>();
        Object obj = customFieldMap.get("issuelinks");
        Type type = new TypeToken<JiraIssueLinksDto[]>() {
        }.getType();
        JiraIssueLinksDto[] jiraLinkedIssuesMainDto = (JiraIssueLinksDto[]) JiraService.convertJsonToDTO(new Gson().toJson(obj), type);
        int length = 3;
        if(jiraLinkedIssuesMainDto.length<=3){
            length = jiraLinkedIssuesMainDto.length;
        }
        for(int counter = 0 ; counter < length ; counter++) {
            MindstrLinkedIssues mindstrLinkedIssues = new MindstrLinkedIssues();
            String summary = jiraLinkedIssuesMainDto[counter].getInwardIssue().getFields().getSummary() ;
            String key =  jiraLinkedIssuesMainDto[counter].getInwardIssue().getKey();
            String name = jiraLinkedIssuesMainDto[counter].getInwardIssue().getFields().getStatus().getName();
            if(summary==null){summary="";}
            if(key==null){key="";}
            if(name==null){name="";}
            mindstrLinkedIssues.setLinkedJiraId(key);
            mindstrLinkedIssues.setMindstrStatus(name);
            mindstrLinkedIssuesList.add(counter,mindstrLinkedIssues);
        }
        return mindstrLinkedIssuesList;
    }





//    public List<String> dynamicProperty, jobs, clientProperties ;
//    String database, restricted,  impactedModules;

    public static final List<String> dynamicProperty=Arrays.asList("upsert-global-property", "property", "upsert-partner-property","dynamic");;
    public static final List<String> jobs = Arrays.asList("com.spr.scheduler.jobs");
    public static final List<String> restricted= Arrays.asList("localhost","restricted");
    public static List<String> resourceURLs = new ArrayList<>();
    public static final String FEATURE_RECORDING = "https://drive.google.com/file/d/0B1QUi5i8YYkgZWJDSUtVYVNGV2M/view";




    public MindstrDescriptionProperties extractDescriptionProps(String jiraId) throws Exception {
        JiraService jiraService = new JiraService();
        MindstrDescriptionProperties mindstrDescriptionProperties = new MindstrDescriptionProperties();
        List<Comment> rawComments = jiraService.getCommentsForJira(jiraId);
        String dpComment = "";
        String jobComment= "";
        String restrictedComments = "";
        for(Comment comment : rawComments){

            for(String each : dynamicProperty){
                if(comment.getBody().toLowerCase().contains(each)){
                    dpComment=dpComment.concat(comment.getBody());
                    break;
                }
            }
            for(String eachJob : jobs){
                if(comment.getBody().toLowerCase().contains(eachJob)){
                    jobComment=jobComment.concat(comment.getBody());
                    break;
                }
            }
            for(String eachRestricted : restricted){
                if(comment.getBody().toLowerCase().contains(eachRestricted)){
                    restrictedComments=restrictedComments.concat(comment.getBody());
                    break;
                }
            }
            for(String url : extractUrls(comment.getBody())){
                resourceURLs.add(url);
            }

        }
        if(!dpComment.isEmpty()) {
            mindstrDescriptionProperties.setDynamicProperty(dpComment);
        }
        if (!jobComment.isEmpty()) {
            mindstrDescriptionProperties.setJobs(jobComment);
        }
        if (!restrictedComments.isEmpty()) {
            mindstrDescriptionProperties.setRestricted(restrictedComments);
        }
        return  mindstrDescriptionProperties;
    }

    public static List<String> extractUrls(String text)
    {
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "http(.*)(wiki|docs|drive|zendesk)(.*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls;
    }


    public static void main(String[] args) throws Exception {
        MindstrService mindstrService = new MindstrService();
        JiraService jiraService = new JiraService();
        JiraIssueType jiraIssueType = (mindstrService.extractMindstrIssueType(jiraService.getCustomFields(jiraService.getJiraDTOFromJson("SPR-38314"),jiraService.getCustomFieldMapping())));
       JiraStatusDto jiraStatusDto = (mindstrService.extractMindstrStatus(jiraService.getCustomFields(jiraService.getJiraDTOFromJson("SPR-38314"),jiraService.getCustomFieldMapping())));
//        System.out.println(jiraStatusDto);
        MindstrDescriptionProperties mindstrDescriptionProperties = new MindstrDescriptionProperties();
        mindstrDescriptionProperties = mindstrService.extractDescriptionProps("SPR-38314");
        System.out.println();
        String str = mindstrService.extractDescriptionInfo(jiraService.getCustomFields(jiraService.getJiraDTOFromJson("SPR-36816"),jiraService.getCustomFieldMapping()));
        mindstrService.extractDescriptionProps("SPR-36816");
        MindstrResources mindstrResources = new MindstrResources();
        mindstrResources.setResourcesLinks(resourceURLs);

    }



}



