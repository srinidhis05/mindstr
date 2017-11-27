package com.mindster.service;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.mindster.DTO.JiraDto.Comment;
import com.mindster.DTO.JiraDto.CustomFieldMapping;
import com.mindster.DTO.JiraDto.JiraResponseDTO;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by srinidhis on 17/12/16.
 */
@Configuration
public class JiraService {
    private static final String JIRA_ISSUE_DATA_PATH ="/src/main/testData/JIRA/";
    private static final String CUSTOM_FIELDS_PATH =  "/src/main/testData/CustomFieldData.json";
    private static final String COMMENTS_FILE_PATH = "/src/main/testData/JIRA/";
    private static Gson gson = new Gson();
    private static Map<String,String> customField;

    public static JiraResponseDTO getJiraDTOFromJson(String jiraId) throws Exception{
//        String path=Thread.currentThread().getContextClassLoader().getResource(JIRA_ISSUE_DATA_PATH+jiraId+".json").getPath();
//        FileReader fileReader = new FileReader(path);
//        JSONParser jsonParser = new JSONParser();
//        Object jsonObject1 = jsonParser.parse(fileReader);
        String json = "{\n" +
                "  \"expand\": \"renderedFields,names,schema,operations,editmeta,changelog,versionedRepresentations\",\n" +
                "  \"id\": \"77529\",\n" +
                "  \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529\",\n" +
                "  \"key\": \"SPR-17535\",\n" +
                "  \"fields\": {\n" +
                "    \"customfield_16570\": null,\n" +
                "    \"customfield_16171\": null,\n" +
                "    \"customfield_16970\": null,\n" +
                "    \"customfield_12370\": null,\n" +
                "    \"customfield_14670\": null,\n" +
                "    \"customfield_17300\": null,\n" +
                "    \"fixVersions\": [\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/version/12860\",\n" +
                "        \"id\": \"12860\",\n" +
                "        \"name\": \"8.6\",\n" +
                "        \"archived\": false,\n" +
                "        \"released\": false\n" +
                "      }\n" +
                "    ],\n" +
                "    \"customfield_10870\": null,\n" +
                "    \"resolution\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/resolution/11400\",\n" +
                "      \"id\": \"11400\",\n" +
                "      \"description\": \"\",\n" +
                "      \"name\": \"Not Resolved\"\n" +
                "    },\n" +
                "    \"customfield_13976\": null,\n" +
                "    \"lastViewed\": \"2016-12-18T04:34:36.970-0600\",\n" +
                "    \"customfield_15870\": \"#4292\",\n" +
                "    \"customfield_13971\": [\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/customFieldOption/15957\",\n" +
                "        \"value\": \"JPMorgan Chase\",\n" +
                "        \"id\": \"15957\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"customfield_13970\": null,\n" +
                "    \"priority\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/priority/3\",\n" +
                "      \"iconUrl\": \"https://test.atlassian.net/images/icons/priorities/major.svg\",\n" +
                "      \"name\": \"Major\",\n" +
                "      \"id\": \"3\"\n" +
                "    },\n" +
                "    \"customfield_13973\": null,\n" +
                "    \"customfield_13972\": [\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/customFieldOption/16066\",\n" +
                "        \"value\": \"Trunk\",\n" +
                "        \"id\": \"16066\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/customFieldOption/16067\",\n" +
                "        \"value\": \"Branch\",\n" +
                "        \"id\": \"16067\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"customfield_13975\": null,\n" +
                "    \"customfield_13974\": null,\n" +
                "    \"labels\": [\n" +
                "      \"8.6.2\",\n" +
                "      \"VZ\"\n" +
                "    ],\n" +
                "    \"timeestimate\": null,\n" +
                "    \"aggregatetimeoriginalestimate\": null,\n" +
                "    \"versions\": [],\n" +
                "    \"issuelinks\": [\n" +
                "      {\n" +
                "        \"id\": \"48758\",\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/issueLink/48758\",\n" +
                "        \"type\": {\n" +
                "          \"id\": \"12042\",\n" +
                "          \"name\": \"Relates\",\n" +
                "          \"inward\": \"relates to\",\n" +
                "          \"outward\": \"relates to\",\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issueLinkType/12042\"\n" +
                "        },\n" +
                "        \"inwardIssue\": {\n" +
                "          \"id\": \"81852\",\n" +
                "          \"key\": \"SPR-18953\",\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/81852\",\n" +
                "          \"fields\": {\n" +
                "            \"summary\": \"Reporting V6 -> SLA dashboard shows Create SLA Preset screen after navigating from Stage SLA\",\n" +
                "            \"status\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/status/11428\",\n" +
                "              \"description\": \"QA Has Rejected the Issue\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/images/icons/statuses/generic.png\",\n" +
                "              \"name\": \"QA Rejected\",\n" +
                "              \"id\": \"11428\",\n" +
                "              \"statusCategory\": {\n" +
                "                \"self\": \"https://test.atlassian.net/rest/api/2/statuscategory/1\",\n" +
                "                \"id\": 1,\n" +
                "                \"key\": \"undefined\",\n" +
                "                \"colorName\": \"medium-gray\",\n" +
                "                \"name\": \"No Category\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"priority\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/priority/3\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/images/icons/priorities/major.svg\",\n" +
                "              \"name\": \"Major\",\n" +
                "              \"id\": \"3\"\n" +
                "            },\n" +
                "            \"issuetype\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/issuetype/28\",\n" +
                "              \"id\": \"28\",\n" +
                "              \"description\": \"A problem which impairs or prevents the functions of the product.\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/secure/viewavatar?size=xsmall&avatarId=14253&avatarType=issuetype\",\n" +
                "              \"name\": \"Bug\",\n" +
                "              \"subtask\": false,\n" +
                "              \"avatarId\": 14253\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"49622\",\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/issueLink/49622\",\n" +
                "        \"type\": {\n" +
                "          \"id\": \"12042\",\n" +
                "          \"name\": \"Relates\",\n" +
                "          \"inward\": \"relates to\",\n" +
                "          \"outward\": \"relates to\",\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issueLinkType/12042\"\n" +
                "        },\n" +
                "        \"inwardIssue\": {\n" +
                "          \"id\": \"84078\",\n" +
                "          \"key\": \"SPR-19704\",\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/84078\",\n" +
                "          \"fields\": {\n" +
                "            \"summary\": \"Reporting V6: Capturing stage sla rules in audit log\",\n" +
                "            \"status\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/status/11525\",\n" +
                "              \"description\": \"Dev Backlog is the state when work item is assigned to Development.\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/images/icons/statuses/generic.png\",\n" +
                "              \"name\": \"Backlog(Dev)\",\n" +
                "              \"id\": \"11525\",\n" +
                "              \"statusCategory\": {\n" +
                "                \"self\": \"https://test.atlassian.net/rest/api/2/statuscategory/2\",\n" +
                "                \"id\": 2,\n" +
                "                \"key\": \"new\",\n" +
                "                \"colorName\": \"blue-gray\",\n" +
                "                \"name\": \"To Do\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"priority\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/priority/3\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/images/icons/priorities/major.svg\",\n" +
                "              \"name\": \"Major\",\n" +
                "              \"id\": \"3\"\n" +
                "            },\n" +
                "            \"issuetype\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/issuetype/28\",\n" +
                "              \"id\": \"28\",\n" +
                "              \"description\": \"A problem which impairs or prevents the functions of the product.\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/secure/viewavatar?size=xsmall&avatarId=14253&avatarType=issuetype\",\n" +
                "              \"name\": \"Bug\",\n" +
                "              \"subtask\": false,\n" +
                "              \"avatarId\": 14253\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"48743\",\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/issueLink/48743\",\n" +
                "        \"type\": {\n" +
                "          \"id\": \"12042\",\n" +
                "          \"name\": \"Relates\",\n" +
                "          \"inward\": \"relates to\",\n" +
                "          \"outward\": \"relates to\",\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issueLinkType/12042\"\n" +
                "        },\n" +
                "        \"inwardIssue\": {\n" +
                "          \"id\": \"81826\",\n" +
                "          \"key\": \"SPR-18945\",\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/81826\",\n" +
                "          \"fields\": {\n" +
                "            \"summary\": \"Reporting V6 -> Stage SLA -> Hovering on pie chart in Stage SLA db shows SLA metric name with some ID\",\n" +
                "            \"status\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/status/11525\",\n" +
                "              \"description\": \"Dev Backlog is the state when work item is assigned to Development.\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/images/icons/statuses/generic.png\",\n" +
                "              \"name\": \"Backlog(Dev)\",\n" +
                "              \"id\": \"11525\",\n" +
                "              \"statusCategory\": {\n" +
                "                \"self\": \"https://test.atlassian.net/rest/api/2/statuscategory/2\",\n" +
                "                \"id\": 2,\n" +
                "                \"key\": \"new\",\n" +
                "                \"colorName\": \"blue-gray\",\n" +
                "                \"name\": \"To Do\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"priority\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/priority/4\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/images/icons/priorities/minor.svg\",\n" +
                "              \"name\": \"Minor\",\n" +
                "              \"id\": \"4\"\n" +
                "            },\n" +
                "            \"issuetype\": {\n" +
                "              \"self\": \"https://test.atlassian.net/rest/api/2/issuetype/28\",\n" +
                "              \"id\": \"28\",\n" +
                "              \"description\": \"A problem which impairs or prevents the functions of the product.\",\n" +
                "              \"iconUrl\": \"https://test.atlassian.net/secure/viewavatar?size=xsmall&avatarId=14253&avatarType=issuetype\",\n" +
                "              \"name\": \"Bug\",\n" +
                "              \"subtask\": false,\n" +
                "              \"avatarId\": 14253\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"assignee\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "      \"name\": \"areddy\",\n" +
                "      \"key\": \"areddy\",\n" +
                "      \"emailAddress\": \"areddy@test.com\",\n" +
                "      \"avatarUrls\": {\n" +
                "        \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "        \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "        \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "        \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "      },\n" +
                "      \"displayName\": \"Avinash Reddy\",\n" +
                "      \"active\": true,\n" +
                "      \"timeZone\": \"Asia/Kolkata\"\n" +
                "    },\n" +
                "    \"customfield_15070\": null,\n" +
                "    \"status\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/status/6\",\n" +
                "      \"description\": \"The issue is considered finished, the resolution is correct. Issues which are closed can be reopened.\",\n" +
                "      \"iconUrl\": \"https://test.atlassian.net/images/icons/statuses/closed.png\",\n" +
                "      \"name\": \"Closed\",\n" +
                "      \"id\": \"6\",\n" +
                "      \"statusCategory\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/statuscategory/3\",\n" +
                "        \"id\": 3,\n" +
                "        \"key\": \"done\",\n" +
                "        \"colorName\": \"green\",\n" +
                "        \"name\": \"Done\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"customfield_14370\": [\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/customFieldOption/16565\",\n" +
                "        \"value\": \"Client Commitment\",\n" +
                "        \"id\": \"16565\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/customFieldOption/16567\",\n" +
                "        \"value\": \"Roadmap Item\",\n" +
                "        \"id\": \"16567\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/customFieldOption/16581\",\n" +
                "        \"value\": \"Live with QA verification pending\",\n" +
                "        \"id\": \"16581\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"components\": [\n" +
                "      {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/component/12540\",\n" +
                "        \"id\": \"12540\",\n" +
                "        \"name\": \"Reporting\",\n" +
                "        \"description\": \"All reporting related requests should go here\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"customfield_16270\": null,\n" +
                "    \"customfield_10170\": null,\n" +
                "    \"customfield_14371\": null,\n" +
                "    \"customfield_16670\": null,\n" +
                "    \"customfield_10970\": null,\n" +
                "    \"customfield_10971\": null,\n" +
                "    \"aggregatetimeestimate\": null,\n" +
                "    \"customfield_15170\": null,\n" +
                "    \"creator\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/user?username=asaurabh\",\n" +
                "      \"name\": \"asaurabh\",\n" +
                "      \"key\": \"asaurabh\",\n" +
                "      \"emailAddress\": \"asaurabh@test.com\",\n" +
                "      \"avatarUrls\": {\n" +
                "        \"48x48\": \"https://test.atlassian.net/secure/useravatar?ownerId=asaurabh&avatarId=12752\",\n" +
                "        \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&ownerId=asaurabh&avatarId=12752\",\n" +
                "        \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&ownerId=asaurabh&avatarId=12752\",\n" +
                "        \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&ownerId=asaurabh&avatarId=12752\"\n" +
                "      },\n" +
                "      \"displayName\": \"Anand Saurabh\",\n" +
                "      \"active\": true,\n" +
                "      \"timeZone\": \"America/Chicago\"\n" +
                "    },\n" +
                "    \"customfield_15050\": null,\n" +
                "    \"subtasks\": [],\n" +
                "    \"customfield_10040\": null,\n" +
                "    \"customfield_11370\": \"Not started\",\n" +
                "    \"customfield_15972\": null,\n" +
                "    \"reporter\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/user?username=amoon\",\n" +
                "      \"name\": \"amoon\",\n" +
                "      \"key\": \"amoon\",\n" +
                "      \"emailAddress\": \"amoon@test.com\",\n" +
                "      \"avatarUrls\": {\n" +
                "        \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "        \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "        \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "        \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "      },\n" +
                "      \"displayName\": \"Aeryung Moon\",\n" +
                "      \"active\": true,\n" +
                "      \"timeZone\": \"America/New_York\"\n" +
                "    },\n" +
                "    \"customfield_11771\": null,\n" +
                "    \"customfield_15970\": null,\n" +
                "    \"customfield_15971\": null,\n" +
                "    \"aggregateprogress\": {\n" +
                "      \"progress\": 0,\n" +
                "      \"total\": 0\n" +
                "    },\n" +
                "    \"customfield_11772\": \"SPR-14377\",\n" +
                "    \"progress\": {\n" +
                "      \"progress\": 0,\n" +
                "      \"total\": 0\n" +
                "    },\n" +
                "    \"worklog\": {\n" +
                "      \"startAt\": 0,\n" +
                "      \"maxResults\": 20,\n" +
                "      \"total\": 0,\n" +
                "      \"worklogs\": []\n" +
                "    },\n" +
                "    \"customfield_17070\": \"{}\",\n" +
                "    \"customfield_15040\": null,\n" +
                "    \"issuetype\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issuetype/2\",\n" +
                "      \"id\": \"2\",\n" +
                "      \"description\": \"A new feature of the product, which has yet to be developed.\",\n" +
                "      \"iconUrl\": \"https://test.atlassian.net/secure/viewavatar?size=xsmall&avatarId=14261&avatarType=issuetype\",\n" +
                "      \"name\": \"New Feature\",\n" +
                "      \"subtask\": false,\n" +
                "      \"avatarId\": 14261\n" +
                "    },\n" +
                "    \"customfield_16370\": null,\n" +
                "    \"customfield_16772\": null,\n" +
                "    \"customfield_14473\": null,\n" +
                "    \"customfield_15045\": null,\n" +
                "    \"customfield_16771\": null,\n" +
                "    \"customfield_12570\": \"2|hzl7fr:\",\n" +
                "    \"customfield_15042\": null,\n" +
                "    \"customfield_16770\": null,\n" +
                "    \"customfield_17100\": null,\n" +
                "    \"timespent\": null,\n" +
                "    \"customfield_10030\": null,\n" +
                "    \"customfield_15048\": \"2015-04-02T14:42:45.000-0500\",\n" +
                "    \"customfield_10031\": null,\n" +
                "    \"customfield_15049\": \"3_*:*_1_*:*_872810000_*|*_10000_*:*_1_*:*_2313403000_*|*_11427_*:*_1_*:*_1048160000_*|*_6_*:*_1_*:*_0_*|*_11429_*:*_1_*:*_890000_*|*_11524_*:*_1_*:*_6000_*|*_11525_*:*_1_*:*_10000_*|*_11433_*:*_1_*:*_3000\",\n" +
                "    \"customfield_16775\": null,\n" +
                "    \"project\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/project/13666\",\n" +
                "      \"id\": \"13666\",\n" +
                "      \"key\": \"SPR\",\n" +
                "      \"name\": \"Social Engagement\",\n" +
                "      \"avatarUrls\": {\n" +
                "        \"48x48\": \"https://test.atlassian.net/secure/projectavatar?pid=13666&avatarId=10011\",\n" +
                "        \"24x24\": \"https://test.atlassian.net/secure/projectavatar?size=small&pid=13666&avatarId=10011\",\n" +
                "        \"16x16\": \"https://test.atlassian.net/secure/projectavatar?size=xsmall&pid=13666&avatarId=10011\",\n" +
                "        \"32x32\": \"https://test.atlassian.net/secure/projectavatar?size=medium&pid=13666&avatarId=10011\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"customfield_10670\": null,\n" +
                "    \"customfield_15046\": null,\n" +
                "    \"customfield_16774\": null,\n" +
                "    \"customfield_16773\": null,\n" +
                "    \"aggregatetimespent\": null,\n" +
                "    \"resolutiondate\": \"2015-02-25T16:32:33.000-0600\",\n" +
                "    \"workratio\": -1,\n" +
                "    \"watches\": {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/SPR-17535/watchers\",\n" +
                "      \"watchCount\": 5,\n" +
                "      \"isWatching\": false\n" +
                "    },\n" +
                "    \"customfield_11070\": null,\n" +
                "    \"customfield_11071\": null,\n" +
                "    \"customfield_11072\": null,\n" +
                "    \"customfield_11073\": null,\n" +
                "    \"created\": \"2015-02-25T16:32:33.000-0600\",\n" +
                "    \"customfield_11074\": null,\n" +
                "    \"customfield_15032\": null,\n" +
                "    \"customfield_15670\": null,\n" +
                "    \"customfield_11075\": null,\n" +
                "    \"customfield_10021\": null,\n" +
                "    \"customfield_15039\": null,\n" +
                "    \"updated\": \"2016-12-18T04:34:36.020-0600\",\n" +
                "    \"customfield_14572\": null,\n" +
                "    \"customfield_16870\": null,\n" +
                "    \"customfield_17200\": null,\n" +
                "    \"customfield_14570\": null,\n" +
                "    \"timeoriginalestimate\": null,\n" +
                "    \"description\": \"\\nThe following set of events must be tracked with Stage SLA tracking \\nEvent 1: Message posted on the channel\\nEvent 2: The first time the message is added to a CS queue\\nEvent 3: The first time the message is assigned to a CS user\\nEvent 4: The first time the message is closed\\n\",\n" +
                "    \"customfield_10010\": null,\n" +
                "    \"customfield_14573\": \"Minor UI Impact.\",\n" +
                "    \"customfield_15024\": null,\n" +
                "    \"customfield_10011\": null,\n" +
                "    \"customfield_10012\": null,\n" +
                "    \"customfield_10771\": null,\n" +
                "    \"customfield_10013\": null,\n" +
                "    \"timetracking\": {},\n" +
                "    \"attachment\": [],\n" +
                "    \"summary\": \"Stage SLA Tracking \",\n" +
                "    \"customfield_11170\": null,\n" +
                "    \"customfield_15771\": null,\n" +
                "    \"customfield_15010\": null,\n" +
                "    \"customfield_15774\": null,\n" +
                "    \"customfield_15013\": null,\n" +
                "    \"customfield_15772\": null,\n" +
                "    \"customfield_10000\": null,\n" +
                "    \"customfield_15773\": null,\n" +
                "    \"customfield_15019\": null,\n" +
                "    \"customfield_10002\": 10,\n" +
                "    \"customfield_15018\": null,\n" +
                "    \"environment\": null,\n" +
                "    \"duedate\": \"2015-02-28\",\n" +
                "    \"comment\": {\n" +
                "      \"comments\": [\n" +
                "        {\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/128863\",\n" +
                "          \"id\": \"128863\",\n" +
                "          \"author\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "            \"name\": \"vsajjan\",\n" +
                "            \"key\": \"vsajjan\",\n" +
                "            \"emailAddress\": \"vsajjan@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Vikranth Sajjan\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"body\": \"[mysql> select * from SCHEDULABLE_JOB_TBL where JOB_CLASS_NAME = 'com.spr.scheduler.jobs.reporting.ruleengine.SLARuleEngineJob' \\\\G'\\n*\",\n" +
                "          \"updateAuthor\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "            \"name\": \"vsajjan\",\n" +
                "            \"key\": \"vsajjan\",\n" +
                "            \"emailAddress\": \"vsajjan@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Vikranth Sajjan\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"created\": \"2015-04-02T14:42:45.000-0500\",\n" +
                "          \"updated\": \"2015-04-02T14:42:56.000-0500\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/128864\",\n" +
                "          \"id\": \"128864\",\n" +
                "          \"author\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "            \"name\": \"vsajjan\",\n" +
                "            \"key\": \"vsajjan\",\n" +
                "            \"emailAddress\": \"vsajjan@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Vikranth Sajjan\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"body\": \"Dynamic Property - rule.engine.sla.enabled\\n\\nRULE.ENGINE.SLA.ENABLED\\tBOOLEAN\\tPARTNER\\trule.engine.sla.enabled.5\",\n" +
                "          \"updateAuthor\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "            \"name\": \"areddy\",\n" +
                "            \"key\": \"areddy\",\n" +
                "            \"emailAddress\": \"areddy@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Avinash Reddy\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"created\": \"2015-04-02T14:46:10.000-0500\",\n" +
                "          \"updated\": \"2015-04-02T18:45:11.000-0500\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/132042\",\n" +
                "          \"id\": \"132042\",\n" +
                "          \"author\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "            \"name\": \"areddy\",\n" +
                "            \"key\": \"areddy\",\n" +
                "            \"emailAddress\": \"areddy@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Avinash Reddy\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"body\": \"Child tickets will be tracked separately, Closing this ticket\",\n" +
                "          \"updateAuthor\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "            \"name\": \"areddy\",\n" +
                "            \"key\": \"areddy\",\n" +
                "            \"emailAddress\": \"areddy@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Avinash Reddy\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"created\": \"2015-04-15T17:00:35.000-0500\",\n" +
                "          \"updated\": \"2015-04-15T17:00:35.000-0500\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/138772\",\n" +
                "          \"id\": \"138772\",\n" +
                "          \"author\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "            \"name\": \"lbagley\",\n" +
                "            \"key\": \"lbagley\",\n" +
                "            \"emailAddress\": \"lbagley@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Leann Bagley\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"America/Chicago\"\n" +
                "          },\n" +
                "          \"body\": \"Has this been released to app.test.com?\",\n" +
                "          \"updateAuthor\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "            \"name\": \"lbagley\",\n" +
                "            \"key\": \"lbagley\",\n" +
                "            \"emailAddress\": \"lbagley@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Leann Bagley\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"America/Chicago\"\n" +
                "          },\n" +
                "          \"created\": \"2015-05-11T19:27:32.000-0500\",\n" +
                "          \"updated\": \"2015-05-11T19:27:32.000-0500\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/295097\",\n" +
                "          \"id\": \"295097\",\n" +
                "          \"author\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "            \"name\": \"lbagley\",\n" +
                "            \"key\": \"lbagley\",\n" +
                "            \"emailAddress\": \"lbagley@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Leann Bagley\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"America/Chicago\"\n" +
                "          },\n" +
                "          \"body\": \"https://docs.google.com/a/test.com/document/d/1TtH75c6ClKTrDxjT8vuJVLla87o0XxniTpHovKNeh30/edit#heading=h.t8qbvt2elo6y\",\n" +
                "          \"updateAuthor\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "            \"name\": \"lbagley\",\n" +
                "            \"key\": \"lbagley\",\n" +
                "            \"emailAddress\": \"lbagley@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Leann Bagley\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"America/Chicago\"\n" +
                "          },\n" +
                "          \"created\": \"2015-06-03T17:04:38.000-0500\",\n" +
                "          \"updated\": \"2015-06-03T17:04:38.000-0500\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/336781\",\n" +
                "          \"id\": \"336781\",\n" +
                "          \"author\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "            \"name\": \"vsajjan\",\n" +
                "            \"key\": \"vsajjan\",\n" +
                "            \"emailAddress\": \"vsajjan@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Vikranth Sajjan\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"body\": \"curl -XPOST -H \\\"Content-Type: application/json\\\" \\\"http://restricted-ext.test.com/restricted/v1/rac/core/DynamicPropertiesRAC\\\" -d '{\\\"opName\\\": \\\"upsert-partner-property\\\",\\\"partnerId\\\":\\\"207\\\",\\\"propertyName\\\":\\\"SLA_RULE_ENGINE_ENABLED\\\",\\\"value\\\":\\\"true\\\"}'\\r\\n{\\r\\n  \\\"type\\\": \\\"SUCCESS\\\",\\r\\n  \\\"result\\\": {\\r\\n    \\\"type\\\": \\\"SUCCESS\\\",\\r\\n    \\\"result\\\": \\\"Inserted new property: rule.engine.sla.enabled.207-\\\\u003etrue\\\"\\r\\n  }\",\n" +
                "          \"updateAuthor\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "            \"name\": \"vsajjan\",\n" +
                "            \"key\": \"vsajjan\",\n" +
                "            \"emailAddress\": \"vsajjan@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Vikranth Sajjan\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"created\": \"2015-11-19T00:52:26.138-0600\",\n" +
                "          \"updated\": \"2015-11-19T00:52:26.138-0600\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/355004\",\n" +
                "          \"id\": \"355004\",\n" +
                "          \"author\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "            \"name\": \"areddy\",\n" +
                "            \"key\": \"areddy\",\n" +
                "            \"emailAddress\": \"areddy@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Avinash Reddy\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"body\": \"[~lbagley], This feature is already in production\\r\\n\\r\\nIf we need to enable for new partner then the below mentioned Job and Dynamic Property has to be enabled\\r\\n\\r\\nJOB_CLASS_NAME: com.spr.scheduler.jobs.reporting.ruleengine.SLARuleEngineJob\\r\\nRULE.ENGINE.SLA.ENABLED\\tBOOLEAN\\tPARTNER\\trule.engine.sla.enabled.5\\r\\n\\r\\n+ [~ijain], [~vsajjan]\",\n" +
                "          \"updateAuthor\": {\n" +
                "            \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "            \"name\": \"areddy\",\n" +
                "            \"key\": \"areddy\",\n" +
                "            \"emailAddress\": \"areddy@test.com\",\n" +
                "            \"avatarUrls\": {\n" +
                "              \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "              \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "              \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "              \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "            },\n" +
                "            \"displayName\": \"Avinash Reddy\",\n" +
                "            \"active\": true,\n" +
                "            \"timeZone\": \"Asia/Kolkata\"\n" +
                "          },\n" +
                "          \"created\": \"2016-01-26T03:38:22.576-0600\",\n" +
                "          \"updated\": \"2016-01-26T03:38:22.576-0600\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"maxResults\": 9,\n" +
                "      \"total\": 9,\n" +
                "      \"startAt\": 0\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return  (JiraResponseDTO)convertJsonToDTO(json,JiraResponseDTO.class.getName());

    }

    public static List<CustomFieldMapping> getCustomFieldMapping()throws Exception{
//        FileReader fileReader = new FileReader(CUSTOM_FIELDS_PATH);
//        JSONParser jsonParser = new JSONParser();
//        JSONArray jsonObject1 = (JSONArray) jsonParser.parse(fileReader);
        String cField="[\n" +
                "  {\n" +
                "    \"id\": \"customfield_16570\",\n" +
                "    \"key\": \"customfield_16570\",\n" +
                "    \"name\": \"Assigned Designer\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Assigned Designer\",\n" +
                "      \"cf[16570]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:userpicker\",\n" +
                "      \"customId\": 16570\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16172\",\n" +
                "    \"key\": \"customfield_16172\",\n" +
                "    \"name\": \"BA Owner\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"BA Owner\",\n" +
                "      \"cf[16172]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:userpicker\",\n" +
                "      \"customId\": 16172\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16171\",\n" +
                "    \"key\": \"customfield_16171\",\n" +
                "    \"name\": \"DEV Ticket Size\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16171]\",\n" +
                "      \"DEV Ticket Size\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons\",\n" +
                "      \"customId\": 16171\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_12370\",\n" +
                "    \"key\": \"customfield_12370\",\n" +
                "    \"name\": \"Build Found\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Build Found\",\n" +
                "      \"cf[12370]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 12370\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14670\",\n" +
                "    \"key\": \"customfield_14670\",\n" +
                "    \"name\": \"Kanban-Cleanup-Status\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14670]\",\n" +
                "      \"Kanban-Cleanup-Status\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes\",\n" +
                "      \"customId\": 14670\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_17300\",\n" +
                "    \"key\": \"customfield_17300\",\n" +
                "    \"name\": \"Organizations\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[17300]\",\n" +
                "      \"Organizations\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.atlassian.servicedesk:sd-customer-organizations\",\n" +
                "      \"customId\": 17300\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16970\",\n" +
                "    \"key\": \"customfield_16970\",\n" +
                "    \"name\": \"Parent Link\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16970]\",\n" +
                "      \"Parent Link\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.atlassian.jpo:jpo-custom-field-parent\",\n" +
                "      \"customId\": 16970\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"fixVersions\",\n" +
                "    \"key\": \"fixVersions\",\n" +
                "    \"name\": \"Fix Version/s\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"fixVersion\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"version\",\n" +
                "      \"system\": \"fixVersions\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10870\",\n" +
                "    \"key\": \"customfield_10870\",\n" +
                "    \"name\": \"Bonfire URL\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Bonfire URL\",\n" +
                "      \"cf[10870]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-url\",\n" +
                "      \"customId\": 10870\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"resolution\",\n" +
                "    \"key\": \"resolution\",\n" +
                "    \"name\": \"Resolution\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"resolution\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"resolution\",\n" +
                "      \"system\": \"resolution\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_13976\",\n" +
                "    \"key\": \"customfield_13976\",\n" +
                "    \"name\": \"Root Cause Detail\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[13976]\",\n" +
                "      \"Root Cause Detail\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 13976\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16170\",\n" +
                "    \"key\": \"customfield_16170\",\n" +
                "    \"name\": \"Product Manager\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16170]\",\n" +
                "      \"Product Manager\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:userpicker\",\n" +
                "      \"customId\": 16170\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"lastViewed\",\n" +
                "    \"key\": \"lastViewed\",\n" +
                "    \"name\": \"Last Viewed\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"lastViewed\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"datetime\",\n" +
                "      \"system\": \"lastViewed\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15470\",\n" +
                "    \"key\": \"customfield_15470\",\n" +
                "    \"name\": \"Planning Bucket\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15470]\",\n" +
                "      \"Planning Bucket\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"date\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:datepicker\",\n" +
                "      \"customId\": 15470\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11270\",\n" +
                "    \"key\": \"customfield_11270\",\n" +
                "    \"name\": \"Caught By\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Caught By\",\n" +
                "      \"cf[11270]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 11270\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15870\",\n" +
                "    \"key\": \"customfield_15870\",\n" +
                "    \"name\": \"Test Case ID\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15870]\",\n" +
                "      \"Test Case ID\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15870\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10060\",\n" +
                "    \"key\": \"customfield_10060\",\n" +
                "    \"name\": \"Type of Test\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10060]\",\n" +
                "      \"Type of Test\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 10060\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11271\",\n" +
                "    \"key\": \"customfield_11271\",\n" +
                "    \"name\": \"Regression\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11271]\",\n" +
                "      \"Regression\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 11271\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_13971\",\n" +
                "    \"key\": \"customfield_13971\",\n" +
                "    \"name\": \"Partner\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[13971]\",\n" +
                "      \"Partner\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiselect\",\n" +
                "      \"customId\": 13971\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_13970\",\n" +
                "    \"key\": \"customfield_13970\",\n" +
                "    \"name\": \"Test Sessions\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[13970]\",\n" +
                "      \"Test Sessions\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-multi-session-cft\",\n" +
                "      \"customId\": 13970\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"priority\",\n" +
                "    \"key\": \"priority\",\n" +
                "    \"name\": \"Priority\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"priority\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"priority\",\n" +
                "      \"system\": \"priority\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_13973\",\n" +
                "    \"key\": \"customfield_13973\",\n" +
                "    \"name\": \"Dev Bug Quality Score\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[13973]\",\n" +
                "      \"Dev Bug Quality Score\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 13973\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_13972\",\n" +
                "    \"key\": \"customfield_13972\",\n" +
                "    \"name\": \"Verified In\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[13972]\",\n" +
                "      \"Verified In\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiselect\",\n" +
                "      \"customId\": 13972\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_13975\",\n" +
                "    \"key\": \"customfield_13975\",\n" +
                "    \"name\": \"Root Cause Category\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[13975]\",\n" +
                "      \"Root Cause Category\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 13975\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"labels\",\n" +
                "    \"key\": \"labels\",\n" +
                "    \"name\": \"Labels\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"labels\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"string\",\n" +
                "      \"system\": \"labels\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_13974\",\n" +
                "    \"key\": \"customfield_13974\",\n" +
                "    \"name\": \"Section\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[13974]\",\n" +
                "      \"Section\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 13974\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"timeestimate\",\n" +
                "    \"key\": \"timeestimate\",\n" +
                "    \"name\": \"Remaining Estimate\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"remainingEstimate\",\n" +
                "      \"timeestimate\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"system\": \"timeestimate\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"aggregatetimeoriginalestimate\",\n" +
                "    \"key\": \"aggregatetimeoriginalestimate\",\n" +
                "    \"name\": \"Σ Original Estimate\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"system\": \"aggregatetimeoriginalestimate\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"versions\",\n" +
                "    \"key\": \"versions\",\n" +
                "    \"name\": \"Affects Version/s\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"affectedVersion\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"version\",\n" +
                "      \"system\": \"versions\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"issuelinks\",\n" +
                "    \"key\": \"issuelinks\",\n" +
                "    \"name\": \"Linked Issues\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"issuelinks\",\n" +
                "      \"system\": \"issuelinks\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"assignee\",\n" +
                "    \"key\": \"assignee\",\n" +
                "    \"name\": \"Assignee\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"assignee\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"system\": \"assignee\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15070\",\n" +
                "    \"key\": \"customfield_15070\",\n" +
                "    \"name\": \"Get Satisfaction Feature\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15070]\",\n" +
                "      \"Get Satisfaction Feature\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiselect\",\n" +
                "      \"customId\": 15070\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"status\",\n" +
                "    \"key\": \"status\",\n" +
                "    \"name\": \"Status\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"status\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"status\",\n" +
                "      \"system\": \"status\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14370\",\n" +
                "    \"key\": \"customfield_14370\",\n" +
                "    \"name\": \"Details\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14370]\",\n" +
                "      \"Details\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes\",\n" +
                "      \"customId\": 14370\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"components\",\n" +
                "    \"key\": \"components\",\n" +
                "    \"name\": \"Component/s\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"component\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"component\",\n" +
                "      \"system\": \"components\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"issuekey\",\n" +
                "    \"key\": \"issuekey\",\n" +
                "    \"name\": \"Key\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"id\",\n" +
                "      \"issue\",\n" +
                "      \"issuekey\",\n" +
                "      \"key\"\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16270\",\n" +
                "    \"key\": \"customfield_16270\",\n" +
                "    \"name\": \"Design Ticket Size\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16270]\",\n" +
                "      \"Design Ticket Size\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons\",\n" +
                "      \"customId\": 16270\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10170\",\n" +
                "    \"key\": \"customfield_10170\",\n" +
                "    \"name\": \"Bonfire Url\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Bonfire Url\",\n" +
                "      \"cf[10170]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:url\",\n" +
                "      \"customId\": 10170\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14770\",\n" +
                "    \"key\": \"customfield_14770\",\n" +
                "    \"name\": \"Listening Bucket\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14770]\",\n" +
                "      \"Listening Bucket\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 14770\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14371\",\n" +
                "    \"key\": \"customfield_14371\",\n" +
                "    \"name\": \"Environment - Ops\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14371]\",\n" +
                "      \"Environment - Ops\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 14371\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10050\",\n" +
                "    \"key\": \"customfield_10050\",\n" +
                "    \"name\": \"Tester\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10050]\",\n" +
                "      \"Tester\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:userpicker\",\n" +
                "      \"customId\": 10050\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_12470\",\n" +
                "    \"key\": \"customfield_12470\",\n" +
                "    \"name\": \"Business Notes\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Business Notes\",\n" +
                "      \"cf[12470]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 12470\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16670\",\n" +
                "    \"key\": \"customfield_16670\",\n" +
                "    \"name\": \"Design Spec Required\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16670]\",\n" +
                "      \"Design Spec Required\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes\",\n" +
                "      \"customId\": 16670\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10051\",\n" +
                "    \"key\": \"customfield_10051\",\n" +
                "    \"name\": \"Test Status\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10051]\",\n" +
                "      \"Test Status\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 10051\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10052\",\n" +
                "    \"key\": \"customfield_10052\",\n" +
                "    \"name\": \"Product\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10052]\",\n" +
                "      \"Product\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 10052\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10570\",\n" +
                "    \"key\": \"customfield_10570\",\n" +
                "    \"name\": \"Module\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10570]\",\n" +
                "      \"Module\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 10570\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10970\",\n" +
                "    \"key\": \"customfield_10970\",\n" +
                "    \"name\": \"Test Session(s)\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10970]\",\n" +
                "      \"Test Session(s)\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-multi-session-cft\",\n" +
                "      \"customId\": 10970\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10971\",\n" +
                "    \"key\": \"customfield_10971\",\n" +
                "    \"name\": \"Raised During\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10971]\",\n" +
                "      \"Raised During\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-session-cft\",\n" +
                "      \"customId\": 10971\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"aggregatetimeestimate\",\n" +
                "    \"key\": \"aggregatetimeestimate\",\n" +
                "    \"name\": \"Σ Remaining Estimate\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"system\": \"aggregatetimeestimate\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"creator\",\n" +
                "    \"key\": \"creator\",\n" +
                "    \"name\": \"Creator\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"creator\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"system\": \"creator\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15170\",\n" +
                "    \"key\": \"customfield_15170\",\n" +
                "    \"name\": \"Merged In\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15170]\",\n" +
                "      \"Merged In\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes\",\n" +
                "      \"customId\": 15170\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15050\",\n" +
                "    \"key\": \"customfield_15050\",\n" +
                "    \"name\": \"Issue Type selector\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15050]\",\n" +
                "      \"Issue Type selector\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 15050\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"subtasks\",\n" +
                "    \"key\": \"subtasks\",\n" +
                "    \"name\": \"Sub-tasks\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"subtasks\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"issuelinks\",\n" +
                "      \"system\": \"subtasks\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15053\",\n" +
                "    \"key\": \"customfield_15053\",\n" +
                "    \"name\": \"Epic Color\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15053]\",\n" +
                "      \"Epic Color\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.pyxis.greenhopper.jira:gh-epic-color\",\n" +
                "      \"customId\": 15053\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10040\",\n" +
                "    \"key\": \"customfield_10040\",\n" +
                "    \"name\": \"ConfluenceURL\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10040]\",\n" +
                "      \"ConfluenceURL\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:url\",\n" +
                "      \"customId\": 10040\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11370\",\n" +
                "    \"key\": \"customfield_11370\",\n" +
                "    \"name\": \"Testing Status\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11370]\",\n" +
                "      \"Testing Status\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-testing-status-cft\",\n" +
                "      \"customId\": 11370\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15972\",\n" +
                "    \"key\": \"customfield_15972\",\n" +
                "    \"name\": \"Who Needs To Know?\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15972]\",\n" +
                "      \"Who Needs To Know?\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 15972\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"reporter\",\n" +
                "    \"key\": \"reporter\",\n" +
                "    \"name\": \"Reporter\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"reporter\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"system\": \"reporter\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15970\",\n" +
                "    \"key\": \"customfield_15970\",\n" +
                "    \"name\": \"External Title\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15970]\",\n" +
                "      \"External Title\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15970\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11771\",\n" +
                "    \"key\": \"customfield_11771\",\n" +
                "    \"name\": \"JIRA Capture Document Mode\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11771]\",\n" +
                "      \"JIRA Capture Document Mode\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-text\",\n" +
                "      \"customId\": 11771\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"aggregateprogress\",\n" +
                "    \"key\": \"aggregateprogress\",\n" +
                "    \"name\": \"Σ Progress\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"progress\",\n" +
                "      \"system\": \"aggregateprogress\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15971\",\n" +
                "    \"key\": \"customfield_15971\",\n" +
                "    \"name\": \"External Description\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15971]\",\n" +
                "      \"External Description\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 15971\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11773\",\n" +
                "    \"key\": \"customfield_11773\",\n" +
                "    \"name\": \"Epic Name\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11773]\",\n" +
                "      \"Epic Name\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.pyxis.greenhopper.jira:gh-epic-label\",\n" +
                "      \"customId\": 11773\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11772\",\n" +
                "    \"key\": \"customfield_11772\",\n" +
                "    \"name\": \"Epic Link\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11772]\",\n" +
                "      \"Epic Link\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.pyxis.greenhopper.jira:gh-epic-link\",\n" +
                "      \"customId\": 11772\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11775\",\n" +
                "    \"key\": \"customfield_11775\",\n" +
                "    \"name\": \"Epic Colour\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11775]\",\n" +
                "      \"Epic Colour\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.pyxis.greenhopper.jira:gh-epic-color\",\n" +
                "      \"customId\": 11775\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11774\",\n" +
                "    \"key\": \"customfield_11774\",\n" +
                "    \"name\": \"Epic Status\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11774]\",\n" +
                "      \"Epic Status\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.pyxis.greenhopper.jira:gh-epic-status\",\n" +
                "      \"customId\": 11774\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"progress\",\n" +
                "    \"key\": \"progress\",\n" +
                "    \"name\": \"Progress\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"progress\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"progress\",\n" +
                "      \"system\": \"progress\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"worklog\",\n" +
                "    \"key\": \"worklog\",\n" +
                "    \"name\": \"Log Work\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": false,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"worklog\",\n" +
                "      \"system\": \"worklog\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_17070\",\n" +
                "    \"key\": \"customfield_17070\",\n" +
                "    \"name\": \"Development\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[17070]\",\n" +
                "      \"development\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugins.jira-development-integration-plugin:devsummarycf\",\n" +
                "      \"customId\": 17070\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15040\",\n" +
                "    \"key\": \"customfield_15040\",\n" +
                "    \"name\": \"Customer Target Release\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15040]\",\n" +
                "      \"Customer Target Release\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 15040\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"issuetype\",\n" +
                "    \"key\": \"issuetype\",\n" +
                "    \"name\": \"Issue Type\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"issuetype\",\n" +
                "      \"type\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"issuetype\",\n" +
                "      \"system\": \"issuetype\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16370\",\n" +
                "    \"key\": \"customfield_16370\",\n" +
                "    \"name\": \"Approvals\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Approvals\",\n" +
                "      \"cf[16370]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"sd-approvals\",\n" +
                "      \"custom\": \"com.atlassian.servicedesk.approvals-plugin:sd-approvals\",\n" +
                "      \"customId\": 16370\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16772\",\n" +
                "    \"key\": \"customfield_16772\",\n" +
                "    \"name\": \"Pending reason\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16772]\",\n" +
                "      \"Pending reason\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 16772\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15044\",\n" +
                "    \"key\": \"customfield_15044\",\n" +
                "    \"name\": \"Severity\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15044]\",\n" +
                "      \"Severity\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 15044\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15045\",\n" +
                "    \"key\": \"customfield_15045\",\n" +
                "    \"name\": \"Feedback\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15045]\",\n" +
                "      \"Feedback\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 15045\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16771\",\n" +
                "    \"key\": \"customfield_16771\",\n" +
                "    \"name\": \"Group assignee\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16771]\",\n" +
                "      \"Group assignee\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"group\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multigrouppicker\",\n" +
                "      \"customId\": 16771\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14473\",\n" +
                "    \"key\": \"customfield_14473\",\n" +
                "    \"name\": \"Visibility of Feature\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14473]\",\n" +
                "      \"Visibility of Feature\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons\",\n" +
                "      \"customId\": 14473\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"timespent\",\n" +
                "    \"key\": \"timespent\",\n" +
                "    \"name\": \"Time Spent\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"timespent\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"system\": \"timespent\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10270\",\n" +
                "    \"key\": \"customfield_10270\",\n" +
                "    \"name\": \"Feature Permission\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10270]\",\n" +
                "      \"Feature Permission\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 10270\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16770\",\n" +
                "    \"key\": \"customfield_16770\",\n" +
                "    \"name\": \"Impact\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16770]\",\n" +
                "      \"Impact\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 16770\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15042\",\n" +
                "    \"key\": \"customfield_15042\",\n" +
                "    \"name\": \"Overall Rating\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15042]\",\n" +
                "      \"Overall Rating\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 15042\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_12570\",\n" +
                "    \"key\": \"customfield_12570\",\n" +
                "    \"name\": \"Rank\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[12570]\",\n" +
                "      \"Rank\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.pyxis.greenhopper.jira:gh-lexo-rank\",\n" +
                "      \"customId\": 12570\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_17100\",\n" +
                "    \"key\": \"customfield_17100\",\n" +
                "    \"name\": \"Team\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[17100]\",\n" +
                "      \"Team\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.atlassian.teams:rm-teams-custom-field-team\",\n" +
                "      \"customId\": 17100\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10271\",\n" +
                "    \"key\": \"customfield_10271\",\n" +
                "    \"name\": \"Permission Version\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10271]\",\n" +
                "      \"Permission Version\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 10271\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15048\",\n" +
                "    \"key\": \"customfield_15048\",\n" +
                "    \"name\": \"Date of First Response\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15048]\",\n" +
                "      \"Date of First Response\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"datetime\",\n" +
                "      \"custom\": \"com.atlassian.jira.ext.charting:firstresponsedate\",\n" +
                "      \"customId\": 15048\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10030\",\n" +
                "    \"key\": \"customfield_10030\",\n" +
                "    \"name\": \"Points Estimated\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10030]\",\n" +
                "      \"Points Estimated\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 10030\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"project\",\n" +
                "    \"key\": \"project\",\n" +
                "    \"name\": \"Project\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"project\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"project\",\n" +
                "      \"system\": \"project\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10031\",\n" +
                "    \"key\": \"customfield_10031\",\n" +
                "    \"name\": \"Actual Points\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Actual Points\",\n" +
                "      \"cf[10031]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 10031\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16775\",\n" +
                "    \"key\": \"customfield_16775\",\n" +
                "    \"name\": \"Check Name\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16775]\",\n" +
                "      \"Check Name\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 16775\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15049\",\n" +
                "    \"key\": \"customfield_15049\",\n" +
                "    \"name\": \"Time in Status\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15049]\",\n" +
                "      \"Time in Status\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"any\",\n" +
                "      \"custom\": \"com.atlassian.jira.ext.charting:timeinstatus\",\n" +
                "      \"customId\": 15049\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15046\",\n" +
                "    \"key\": \"customfield_15046\",\n" +
                "    \"name\": \"Release Note\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15046]\",\n" +
                "      \"Release Note\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 15046\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16774\",\n" +
                "    \"key\": \"customfield_16774\",\n" +
                "    \"name\": \"Server Name\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16774]\",\n" +
                "      \"Server Name\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 16774\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10670\",\n" +
                "    \"key\": \"customfield_10670\",\n" +
                "    \"name\": \"Sprint\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10670]\",\n" +
                "      \"Sprint\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"string\",\n" +
                "      \"custom\": \"com.pyxis.greenhopper.jira:gh-sprint\",\n" +
                "      \"customId\": 10670\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15047\",\n" +
                "    \"key\": \"customfield_15047\",\n" +
                "    \"name\": \"Location of Problem\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15047]\",\n" +
                "      \"Location of Problem\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:url\",\n" +
                "      \"customId\": 15047\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16773\",\n" +
                "    \"key\": \"customfield_16773\",\n" +
                "    \"name\": \"Urgency\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16773]\",\n" +
                "      \"Urgency\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 16773\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"aggregatetimespent\",\n" +
                "    \"key\": \"aggregatetimespent\",\n" +
                "    \"name\": \"Σ Time Spent\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"system\": \"aggregatetimespent\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"resolutiondate\",\n" +
                "    \"key\": \"resolutiondate\",\n" +
                "    \"name\": \"Resolved\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"resolutiondate\",\n" +
                "      \"resolved\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"datetime\",\n" +
                "      \"system\": \"resolutiondate\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"workratio\",\n" +
                "    \"key\": \"workratio\",\n" +
                "    \"name\": \"Work Ratio\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"workratio\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"system\": \"workratio\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"watches\",\n" +
                "    \"key\": \"watches\",\n" +
                "    \"name\": \"Watchers\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"watchers\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"watches\",\n" +
                "      \"system\": \"watches\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"thumbnail\",\n" +
                "    \"key\": \"thumbnail\",\n" +
                "    \"name\": \"Images\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11070\",\n" +
                "    \"key\": \"customfield_11070\",\n" +
                "    \"name\": \"JIRA Capture User Agent\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11070]\",\n" +
                "      \"JIRA Capture User Agent\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-text\",\n" +
                "      \"customId\": 11070\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11071\",\n" +
                "    \"key\": \"customfield_11071\",\n" +
                "    \"name\": \"JIRA Capture Browser\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11071]\",\n" +
                "      \"JIRA Capture Browser\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-text\",\n" +
                "      \"customId\": 11071\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11072\",\n" +
                "    \"key\": \"customfield_11072\",\n" +
                "    \"name\": \"JIRA Capture Operating System\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11072]\",\n" +
                "      \"JIRA Capture Operating System\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-text\",\n" +
                "      \"customId\": 11072\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"created\",\n" +
                "    \"key\": \"created\",\n" +
                "    \"name\": \"Created\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"created\",\n" +
                "      \"createdDate\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"datetime\",\n" +
                "      \"system\": \"created\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11073\",\n" +
                "    \"key\": \"customfield_11073\",\n" +
                "    \"name\": \"JIRA Capture URL\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11073]\",\n" +
                "      \"JIRA Capture URL\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-text\",\n" +
                "      \"customId\": 11073\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15670\",\n" +
                "    \"key\": \"customfield_15670\",\n" +
                "    \"name\": \"Aha! Reference\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Aha! Reference\",\n" +
                "      \"cf[15670]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:url\",\n" +
                "      \"customId\": 15670\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11074\",\n" +
                "    \"key\": \"customfield_11074\",\n" +
                "    \"name\": \"JIRA Capture Screen Resolution\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11074]\",\n" +
                "      \"JIRA Capture Screen Resolution\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-text\",\n" +
                "      \"customId\": 11074\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15032\",\n" +
                "    \"key\": \"customfield_15032\",\n" +
                "    \"name\": \"Migrators associated\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15032]\",\n" +
                "      \"Migrators associated\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15032\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11075\",\n" +
                "    \"key\": \"customfield_11075\",\n" +
                "    \"name\": \"JIRA Capture jQuery Version\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[11075]\",\n" +
                "      \"JIRA Capture jQuery Version\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.bonfire.plugin:bonfire-text\",\n" +
                "      \"customId\": 11075\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10021\",\n" +
                "    \"key\": \"customfield_10021\",\n" +
                "    \"name\": \"Data Type\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10021]\",\n" +
                "      \"Data Type\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 10021\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15039\",\n" +
                "    \"key\": \"customfield_15039\",\n" +
                "    \"name\": \"Customer Rank \",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15039]\",\n" +
                "      \"Customer Rank \"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 15039\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"updated\",\n" +
                "    \"key\": \"updated\",\n" +
                "    \"name\": \"Updated\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"updated\",\n" +
                "      \"updatedDate\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"datetime\",\n" +
                "      \"system\": \"updated\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16470\",\n" +
                "    \"key\": \"customfield_16470\",\n" +
                "    \"name\": \"test solution\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16470]\",\n" +
                "      \"test solution\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 16470\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14571\",\n" +
                "    \"key\": \"customfield_14571\",\n" +
                "    \"name\": \"PercentDone\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14571]\",\n" +
                "      \"PercentDone\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 14571\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14572\",\n" +
                "    \"key\": \"customfield_14572\",\n" +
                "    \"name\": \"DueTime\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14572]\",\n" +
                "      \"DueTime\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 14572\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_17200\",\n" +
                "    \"key\": \"customfield_17200\",\n" +
                "    \"name\": \"QA Estimate\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[17200]\",\n" +
                "      \"QA Estimate\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:radiobuttons\",\n" +
                "      \"customId\": 17200\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16870\",\n" +
                "    \"key\": \"customfield_16870\",\n" +
                "    \"name\": \"Release Note Link\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16870]\",\n" +
                "      \"Release Note Link\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:url\",\n" +
                "      \"customId\": 16870\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15020\",\n" +
                "    \"key\": \"customfield_15020\",\n" +
                "    \"name\": \"Expected First Year Data Size Max\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15020]\",\n" +
                "      \"Expected First Year Data Size Max\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15020\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"timeoriginalestimate\",\n" +
                "    \"key\": \"timeoriginalestimate\",\n" +
                "    \"name\": \"Original Estimate\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": false,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": false,\n" +
                "    \"clauseNames\": [\n" +
                "      \"originalEstimate\",\n" +
                "      \"timeoriginalestimate\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"system\": \"timeoriginalestimate\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15021\",\n" +
                "    \"key\": \"customfield_15021\",\n" +
                "    \"name\": \"Import Size\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15021]\",\n" +
                "      \"Import Size\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15021\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14570\",\n" +
                "    \"key\": \"customfield_14570\",\n" +
                "    \"name\": \"Units\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14570]\",\n" +
                "      \"Units\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 14570\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"description\",\n" +
                "    \"key\": \"description\",\n" +
                "    \"name\": \"Description\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"description\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"system\": \"description\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10010\",\n" +
                "    \"key\": \"customfield_10010\",\n" +
                "    \"name\": \"Epic/Theme\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10010]\",\n" +
                "      \"Epic/Theme\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:labels\",\n" +
                "      \"customId\": 10010\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_14573\",\n" +
                "    \"key\": \"customfield_14573\",\n" +
                "    \"name\": \"Impact of Feature\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[14573]\",\n" +
                "      \"Impact of Feature\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 14573\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15024\",\n" +
                "    \"key\": \"customfield_15024\",\n" +
                "    \"name\": \"QA automation candidate\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15024]\",\n" +
                "      \"QA automation candidate\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 15024\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10011\",\n" +
                "    \"key\": \"customfield_10011\",\n" +
                "    \"name\": \"Release Version History\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10011]\",\n" +
                "      \"Release Version History\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"version\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiversion\",\n" +
                "      \"customId\": 10011\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10771\",\n" +
                "    \"key\": \"customfield_10771\",\n" +
                "    \"name\": \"Acceptance Status\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Acceptance Status\",\n" +
                "      \"cf[10771]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 10771\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10012\",\n" +
                "    \"key\": \"customfield_10012\",\n" +
                "    \"name\": \"SLA\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10012]\",\n" +
                "      \"SLA\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:select\",\n" +
                "      \"customId\": 10012\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10013\",\n" +
                "    \"key\": \"customfield_10013\",\n" +
                "    \"name\": \"Acceptance  Criteria\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Acceptance  Criteria\",\n" +
                "      \"cf[10013]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 10013\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"timetracking\",\n" +
                "    \"key\": \"timetracking\",\n" +
                "    \"name\": \"Time Tracking\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": false,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"timetracking\",\n" +
                "      \"system\": \"timetracking\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"security\",\n" +
                "    \"key\": \"security\",\n" +
                "    \"name\": \"Security Level\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"level\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"securitylevel\",\n" +
                "      \"system\": \"security\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"attachment\",\n" +
                "    \"key\": \"attachment\",\n" +
                "    \"name\": \"Attachment\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": false,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"attachments\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"attachment\",\n" +
                "      \"system\": \"attachment\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16071\",\n" +
                "    \"key\": \"customfield_16071\",\n" +
                "    \"name\": \"QA Analysis Detail\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16071]\",\n" +
                "      \"QA Analysis Detail\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textarea\",\n" +
                "      \"customId\": 16071\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_16070\",\n" +
                "    \"key\": \"customfield_16070\",\n" +
                "    \"name\": \"QA Analysis\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[16070]\",\n" +
                "      \"QA Analysis\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiselect\",\n" +
                "      \"customId\": 16070\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"summary\",\n" +
                "    \"key\": \"summary\",\n" +
                "    \"name\": \"Summary\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"summary\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"system\": \"summary\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_11170\",\n" +
                "    \"key\": \"customfield_11170\",\n" +
                "    \"name\": \"Build Tested\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Build Tested\",\n" +
                "      \"cf[11170]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 11170\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15771\",\n" +
                "    \"key\": \"customfield_15771\",\n" +
                "    \"name\": \"Master Commit #\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15771]\",\n" +
                "      \"Master Commit #\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15771\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15010\",\n" +
                "    \"key\": \"customfield_15010\",\n" +
                "    \"name\": \"Assigned Product Manager\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Assigned Product Manager\",\n" +
                "      \"cf[15010]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:userpicker\",\n" +
                "      \"customId\": 15010\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15774\",\n" +
                "    \"key\": \"customfield_15774\",\n" +
                "    \"name\": \"Prod0 Commit #\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15774]\",\n" +
                "      \"Prod0 Commit #\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15774\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15013\",\n" +
                "    \"key\": \"customfield_15013\",\n" +
                "    \"name\": \"Assigned QA\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Assigned QA\",\n" +
                "      \"cf[15013]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:userpicker\",\n" +
                "      \"customId\": 15013\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15772\",\n" +
                "    \"key\": \"customfield_15772\",\n" +
                "    \"name\": \"Release Commit #\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15772]\",\n" +
                "      \"Release Commit #\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15772\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15014\",\n" +
                "    \"key\": \"customfield_15014\",\n" +
                "    \"name\": \"Affected Browsers\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Affected Browsers\",\n" +
                "      \"cf[15014]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiselect\",\n" +
                "      \"customId\": 15014\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10000\",\n" +
                "    \"key\": \"customfield_10000\",\n" +
                "    \"name\": \"Flagged\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10000]\",\n" +
                "      \"Flagged\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"option\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multicheckboxes\",\n" +
                "      \"customId\": 10000\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15773\",\n" +
                "    \"key\": \"customfield_15773\",\n" +
                "    \"name\": \"Live Commit #\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[15773]\",\n" +
                "      \"Live Commit #\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:textfield\",\n" +
                "      \"customId\": 15773\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15019\",\n" +
                "    \"key\": \"customfield_15019\",\n" +
                "    \"name\": \"Assigned Code Reviewer(s)\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Assigned Code Reviewer(s)\",\n" +
                "      \"cf[15019]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiuserpicker\",\n" +
                "      \"customId\": 15019\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10001\",\n" +
                "    \"key\": \"customfield_10001\",\n" +
                "    \"name\": \"Rank (Obsolete)\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10001]\",\n" +
                "      \"Rank (Obsolete)\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 10001\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10002\",\n" +
                "    \"key\": \"customfield_10002\",\n" +
                "    \"name\": \"Story Points\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"cf[10002]\",\n" +
                "      \"Story Points\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 10002\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_10003\",\n" +
                "    \"key\": \"customfield_10003\",\n" +
                "    \"name\": \"Business Value\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Business Value\",\n" +
                "      \"cf[10003]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:float\",\n" +
                "      \"customId\": 10003\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"customfield_15018\",\n" +
                "    \"key\": \"customfield_15018\",\n" +
                "    \"name\": \"Assigned Developer(s)\",\n" +
                "    \"custom\": true,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"Assigned Developer(s)\",\n" +
                "      \"cf[15018]\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"array\",\n" +
                "      \"items\": \"user\",\n" +
                "      \"custom\": \"com.atlassian.jira.plugin.system.customfieldtypes:multiuserpicker\",\n" +
                "      \"customId\": 15018\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"environment\",\n" +
                "    \"key\": \"environment\",\n" +
                "    \"name\": \"Environment\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"environment\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"system\": \"environment\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"duedate\",\n" +
                "    \"key\": \"duedate\",\n" +
                "    \"name\": \"Due Date\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": true,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"due\",\n" +
                "      \"duedate\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"date\",\n" +
                "      \"system\": \"duedate\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"comment\",\n" +
                "    \"key\": \"comment\",\n" +
                "    \"name\": \"Comment\",\n" +
                "    \"custom\": false,\n" +
                "    \"orderable\": true,\n" +
                "    \"navigable\": false,\n" +
                "    \"searchable\": true,\n" +
                "    \"clauseNames\": [\n" +
                "      \"comment\"\n" +
                "    ],\n" +
                "    \"schema\": {\n" +
                "      \"type\": \"comments-page\",\n" +
                "      \"system\": \"comment\"\n" +
                "    }\n" +
                "  }\n" +
                "]\n";
        return Lists.newArrayList((CustomFieldMapping[]) convertJsonToDTO(cField, CustomFieldMapping[].class));
    }

    public static Map<String,Object> getCustomFields(JiraResponseDTO jiraResponseDTO,List<CustomFieldMapping> customFieldMappings){

        Map<String,String> cfMap = new HashMap<>();
        for(int i=0;i<customFieldMappings.size();i++){
            cfMap.put(customFieldMappings.get(i).getId(),customFieldMappings.get(i).getKey());
        }

        Map<String,Object> jiraMap = jiraResponseDTO.getFields();

        Map<String,Object> finalMap = new HashMap<>();
        for(String cfName: jiraMap.keySet()){
            finalMap.put(cfMap.get(cfName),jiraMap.get(cfName));
        }
        return finalMap;
    }

    public List<Comment> getCommentsForJira(String jiraId) throws Exception{
//        FileReader fileReader = new FileReader(COMMENTS_FILE_PATH+jiraId+"-comment.json");
//        JSONParser jsonParser = new JSONParser();
//        JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
//        JSONArray jsonArray = (JSONArray) jsonObject.get("comments");
        String comments="[\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/128863\",\n" +
                "      \"id\": \"128863\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "        \"name\": \"vsajjan\",\n" +
                "        \"key\": \"vsajjan\",\n" +
                "        \"emailAddress\": \"vsajjan@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Vikranth Sajjan\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"body\": \"[mysql> select * from SCHEDULABLE_JOB_TBL where JOB_CLASS_NAME = 'com.spr.scheduler.jobs.reporting.ruleengine.SLARuleEngineJob' \\\\G'\\n*****************************************************\\nSCHEDULABLE_JOB_TBL_ID: 5391251\\n        JOB_CLASS_NAME: com.spr.scheduler.jobs.reporting.ruleengine.SLARuleEngineJob\\n            PARTNER_ID: 5\\n             CLIENT_ID: -1\\n            ACCOUNT_ID: -1\\n              JOB_DATA: {}\\n       CRON_EXPRESSION: 0 0/1 * 1/1 * ? *\\n          IS_SCHEDULED: 1\\n            IS_ENABLED: 1\\n            CREATED_TM: 2015-03-20 00:00:00\\n           MODIFIED_TM: 2015-03-20 21:23:30\\n               DEL_FLG: 0\\n          SCHEDULE_KEY: SLARuleEngineJobTName-1-15391251,SLARuleEngineJobTGroup5\\n MISS_FIRE_INSTRUCTION: NULL\\n          JOB_START_TM: NULL\\n1 row in set (0.00 sec)\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "        \"name\": \"vsajjan\",\n" +
                "        \"key\": \"vsajjan\",\n" +
                "        \"emailAddress\": \"vsajjan@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Vikranth Sajjan\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"created\": \"2015-04-02T14:42:45.000-0500\",\n" +
                "      \"updated\": \"2015-04-02T14:42:56.000-0500\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/128864\",\n" +
                "      \"id\": \"128864\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "        \"name\": \"vsajjan\",\n" +
                "        \"key\": \"vsajjan\",\n" +
                "        \"emailAddress\": \"vsajjan@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Vikranth Sajjan\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"body\": \"Dynamic Property - rule.engine.sla.enabled\\n\\nRULE.ENGINE.SLA.ENABLED\\tBOOLEAN\\tPARTNER\\trule.engine.sla.enabled.5\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "        \"name\": \"areddy\",\n" +
                "        \"key\": \"areddy\",\n" +
                "        \"emailAddress\": \"areddy@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Avinash Reddy\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"created\": \"2015-04-02T14:46:10.000-0500\",\n" +
                "      \"updated\": \"2015-04-02T18:45:11.000-0500\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/132042\",\n" +
                "      \"id\": \"132042\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "        \"name\": \"areddy\",\n" +
                "        \"key\": \"areddy\",\n" +
                "        \"emailAddress\": \"areddy@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Avinash Reddy\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"body\": \"Child tickets will be tracked separately, Closing this ticket\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "        \"name\": \"areddy\",\n" +
                "        \"key\": \"areddy\",\n" +
                "        \"emailAddress\": \"areddy@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Avinash Reddy\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"created\": \"2015-04-15T17:00:35.000-0500\",\n" +
                "      \"updated\": \"2015-04-15T17:00:35.000-0500\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/138772\",\n" +
                "      \"id\": \"138772\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "        \"name\": \"lbagley\",\n" +
                "        \"key\": \"lbagley\",\n" +
                "        \"emailAddress\": \"lbagley@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Leann Bagley\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"America/Chicago\"\n" +
                "      },\n" +
                "      \"body\": \"Has this been released to app.test.com?\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "        \"name\": \"lbagley\",\n" +
                "        \"key\": \"lbagley\",\n" +
                "        \"emailAddress\": \"lbagley@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Leann Bagley\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"America/Chicago\"\n" +
                "      },\n" +
                "      \"created\": \"2015-05-11T19:27:32.000-0500\",\n" +
                "      \"updated\": \"2015-05-11T19:27:32.000-0500\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/295097\",\n" +
                "      \"id\": \"295097\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "        \"name\": \"lbagley\",\n" +
                "        \"key\": \"lbagley\",\n" +
                "        \"emailAddress\": \"lbagley@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Leann Bagley\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"America/Chicago\"\n" +
                "      },\n" +
                "      \"body\": \"Hi folks.  Was this ever released?  It does not appear to have been.  Wells Fargo is very interested in this one.\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "        \"name\": \"lbagley\",\n" +
                "        \"key\": \"lbagley\",\n" +
                "        \"emailAddress\": \"lbagley@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Leann Bagley\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"America/Chicago\"\n" +
                "      },\n" +
                "      \"created\": \"2015-06-03T17:04:38.000-0500\",\n" +
                "      \"updated\": \"2015-06-03T17:04:38.000-0500\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/336781\",\n" +
                "      \"id\": \"336781\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "        \"name\": \"vsajjan\",\n" +
                "        \"key\": \"vsajjan\",\n" +
                "        \"emailAddress\": \"vsajjan@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Vikranth Sajjan\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"body\": \"curl-XPOST -H \\\"Content-Type: application/json\\\" \\\"http://restricted-ext.test.com/restricted/v1/rac/core/DynamicPropertiesRAC\\\" -d '{\\\"opName\\\": \\\"upsert-partner-property\\\",\\\"partnerId\\\":\\\"207\\\",\\\"propertyName\\\":\\\"SLA_RULE_ENGINE_ENABLED\\\",\\\"value\\\":\\\"true\\\"}'\\r\\n{\\r\\n  \\\"type\\\": \\\"SUCCESS\\\",\\r\\n  \\\"result\\\": {\\r\\n    \\\"type\\\": \\\"SUCCESS\\\",\\r\\n    \\\"result\\\": \\\"Inserted new property: rule.engine.sla.enabled.207-\\\\u003etrue\\\"\\r\\n  }\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=vsajjan\",\n" +
                "        \"name\": \"vsajjan\",\n" +
                "        \"key\": \"vsajjan\",\n" +
                "        \"emailAddress\": \"vsajjan@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Vikranth Sajjan\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"created\": \"2015-11-19T00:52:26.138-0600\",\n" +
                "      \"updated\": \"2015-11-19T00:52:26.138-0600\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/354947\",\n" +
                "      \"id\": \"354947\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "        \"name\": \"lbagley\",\n" +
                "        \"key\": \"lbagley\",\n" +
                "        \"emailAddress\": \"lbagley@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Leann Bagley\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"America/Chicago\"\n" +
                "      },\n" +
                "      \"body\": \"https://test.atlassian.net/wiki/display/QA/Accessing+test+backend+using+ElasticSearch\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=lbagley\",\n" +
                "        \"name\": \"lbagley\",\n" +
                "        \"key\": \"lbagley\",\n" +
                "        \"emailAddress\": \"lbagley@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Leann Bagley\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"America/Chicago\"\n" +
                "      },\n" +
                "      \"created\": \"2016-01-25T15:28:35.583-0600\",\n" +
                "      \"updated\": \"2016-01-25T15:28:35.583-0600\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"self\": \"https://test.atlassian.net/rest/api/2/issue/77529/comment/355004\",\n" +
                "      \"id\": \"355004\",\n" +
                "      \"author\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "        \"name\": \"areddy\",\n" +
                "        \"key\": \"areddy\",\n" +
                "        \"emailAddress\": \"areddy@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Avinash Reddy\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"body\": \"[~lbagley], This feature is already in production\\r\\n\\r\\nIf we need to enable for new partner then the below mentioned Job and Dynamic Property has to be enabled\\r\\n\\r\\nJOB_CLASS_NAME: com.spr.scheduler.jobs.reporting.ruleengine.SLARuleEngineJob\\r\\nRULE.ENGINE.SLA.ENABLED\\tBOOLEAN\\tPARTNER\\trule.engine.sla.enabled.5\\r\\n\\r\\n+ [~ijain], [~vsajjan]\",\n" +
                "      \"updateAuthor\": {\n" +
                "        \"self\": \"https://test.atlassian.net/rest/api/2/user?username=areddy\",\n" +
                "        \"name\": \"areddy\",\n" +
                "        \"key\": \"areddy\",\n" +
                "        \"emailAddress\": \"areddy@test.com\",\n" +
                "        \"avatarUrls\": {\n" +
                "          \"48x48\": \"https://test.atlassian.net/secure/useravatar?avatarId=10072\",\n" +
                "          \"24x24\": \"https://test.atlassian.net/secure/useravatar?size=small&avatarId=10072\",\n" +
                "          \"16x16\": \"https://test.atlassian.net/secure/useravatar?size=xsmall&avatarId=10072\",\n" +
                "          \"32x32\": \"https://test.atlassian.net/secure/useravatar?size=medium&avatarId=10072\"\n" +
                "        },\n" +
                "        \"displayName\": \"Avinash Reddy\",\n" +
                "        \"active\": true,\n" +
                "        \"timeZone\": \"Asia/Kolkata\"\n" +
                "      },\n" +
                "      \"created\": \"2016-01-26T03:38:22.576-0600\",\n" +
                "      \"updated\": \"2016-01-26T03:38:22.576-0600\"\n" +
                "    }\n" +
                "  ]";
        return Lists.newArrayList((Comment[]) convertJsonToDTO(comments, Comment[].class));
    }

    public static Object convertJsonToDTO(String json , String dtoClassName){
        Object containerObject = null;
        try {
            containerObject = Class.forName(dtoClassName).newInstance();
            containerObject = gson.fromJson(json, containerObject.getClass());
        }
        catch (Exception ex)
        {
            System.out.println("Failed to covert JSON to " + dtoClassName);
            ex.printStackTrace();
        }
        return containerObject;
    }

    public static Object convertJsonToDTO(String json , Type type){
        Object containerObject = null;
        try {
            containerObject = gson.fromJson(json, type);
        }
        catch (Exception ex)
        {
            System.out.println("Failed to covert JSON to " + type.getClass().getCanonicalName());
            ex.printStackTrace();
        }
        return containerObject;
    }



    public static void main(String[] args) throws Exception{
        JiraService jiraService = new JiraService();
        System.out.println(jiraService.JIRA_ISSUE_DATA_PATH);
        System.out.println(jiraService.getCommentsForJira("SPR-38314").get(0).getBody());
        System.out.println(getCustomFields(jiraService.getJiraDTOFromJson("SPR-38314"),jiraService.getCustomFieldMapping()));

        MindstrService mindstrService = new MindstrService();
        mindstrService.extractMindstrLinkedIssues(getCustomFields(jiraService.getJiraDTOFromJson("SPR-30998"),jiraService.getCustomFieldMapping()));
    }

}
