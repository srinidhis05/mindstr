package com.mindster.DTO.MindsterDto;

import com.google.common.base.Joiner;
import com.mindster.DTO.JiraDto.Comment;
import com.mindster.DTO.MoztrapDto.MoztrapResponseMainDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shreyas on 17/12/16.
 */
public class MindstrResponseMainDto {

    public String jiraId ;
    public String Summary;

    public String getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    public String issuetype;

    public MindstrDescriptionDto mindstrDescriptionDto;

    public String mindstrStatus;

    public MindstrResources mindstrResources;

    public MindstrReleaseDto mindstrReleaseDto ;

    public Map<String,String> mindStrPeople;

    public List<MindstrLinkedIssues> mindstrLinkedIssues;

    public List<Comment> mindstrComments;

    public MindstrScenariosDto mindstrScenariosDto;

    public String featureRecordings;



    public MindstrScenariosDto getMindstrScenariosDto() {
        return mindstrScenariosDto;
    }

    public void setMindstrScenariosDto(MindstrScenariosDto mindstrScenariosDto) {
        this.mindstrScenariosDto = mindstrScenariosDto;
    }

    public List<Comment> getMindstrComments() {
        return mindstrComments;
    }

    public void setMindstrComments(List<Comment> mindstrComments) {
        this.mindstrComments = mindstrComments;
    }

    public String getJiraId() {
        return jiraId;
    }

    public void setJiraId(String jiraId) {
        this.jiraId = jiraId;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public MindstrDescriptionDto getMindstrDescriptionDto() {
        return mindstrDescriptionDto;
    }

    public void setMindstrDescriptionDto(MindstrDescriptionDto mindstrDescriptionDto) {
        this.mindstrDescriptionDto = mindstrDescriptionDto;
    }

    public String getMindstrStatus() {
        return mindstrStatus;
    }

    public void setMindstrStatus(String mindstrStatus) {
        this.mindstrStatus = mindstrStatus;
    }

    public MindstrResources getMindstrResources() {
        return mindstrResources;
    }

    public void setMindstrResources(MindstrResources mindstrResources) {
        this.mindstrResources = mindstrResources;
    }

    public MindstrReleaseDto getMindstrReleaseDto() {
        return mindstrReleaseDto;
    }

    public void setMindstrReleaseDto(MindstrReleaseDto mindstrReleaseDto) {
        this.mindstrReleaseDto = mindstrReleaseDto;
    }

    public Map<String, String> getMindStrPeople() {
        if(mindStrPeople==null)
        {
            return new HashMap<>();
        }
        return mindStrPeople;
    }

    public void setMindStrPeople(Map<String, String> mindStrPeople) {
        this.mindStrPeople = mindStrPeople;
    }

    public List<MindstrLinkedIssues> getMindstrLinkedIssuesList() {
        return mindstrLinkedIssues;
    }

    public void setMindstrLinkedIssuesList(List<MindstrLinkedIssues> mindstrLinkedIssues) {
        this.mindstrLinkedIssues = mindstrLinkedIssues;
    }

    public MoztrapResponseMainDto getMindMoztrapMainDto() {
        return mindMoztrapMainDto;
    }

    public void setMindMoztrapMainDto(MoztrapResponseMainDto mindMoztrapMainDto) {
        this.mindMoztrapMainDto = mindMoztrapMainDto;
    }

    public MoztrapResponseMainDto mindMoztrapMainDto;

    public String getFeatureRecordings() {
        return featureRecordings;
    }

    public void setFeatureRecordings(String featureRecordings) {
        this.featureRecordings = featureRecordings;
    }


    @Override
    public String toString() {
        return  "mindstrResponseMainDto:{"+
                "jiraId:"+jiraId+
                ",Summary:"+Summary+
                ",issuetype:"+issuetype+
                ",mindstrDescriptionDto:{"+mindstrDescriptionDto.toString()+"}"+
                ",mindstrStatus:"+mindstrStatus+
                ",mindstrResources:{"+mindstrResources.toString()+"}"+
                ",mindstrReleaseDto:{"+mindstrReleaseDto.toString()+"}"+
                ",mindStrPeople:"+ Joiner.on(",").withKeyValueSeparator(":").join(mindStrPeople)+
                ",mindstrLinkedIssues:["+convertToString(mindstrLinkedIssues)+"]"+
                ",mindstrComments"+convertCommentsToString(mindstrComments)+
                ",mindstrScenariosDto"+mindstrScenariosDto.toString();
    }

    private String convertToString(List<MindstrLinkedIssues> mindstrLinkedIssues) {
        String obtainedStr="";
        for (MindstrLinkedIssues mindstrLinkedIssue : mindstrLinkedIssues){
            obtainedStr+=mindstrLinkedIssue.toString()+",";
        }
        obtainedStr = obtainedStr.substring(0,obtainedStr.length()-1);
        return obtainedStr;
    }

    private String convertCommentsToString(List<Comment> comments) {
        String obtainedStr="";
        for (Comment comment : comments){
            obtainedStr+=comment.toString()+",";
        }
        obtainedStr = obtainedStr.substring(0,obtainedStr.length()-1);
        return obtainedStr;
    }




}
