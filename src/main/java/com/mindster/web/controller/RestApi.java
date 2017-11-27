package com.mindster.web.controller;

/**
 * Created by srinidhis on 17/08/16.
 */

import com.mindster.DTO.JiraDto.JiraResponseDTO;
import com.mindster.DTO.MindsterDto.MindstrResponseMainDto;
import com.mindster.service.JiraService;
import com.mindster.service.MindstrService;
import com.mindster.service.MoztrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Controller
public class RestApi {

    @Autowired
    JiraService jiraService;

    @Autowired
    MindstrService mindstrService;

    @Autowired
    MoztrapService moztrapService;

    @Autowired
    JiraResponseDTO jiraResponseDTO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(Model model) {
        model.addAttribute("message", "Mindster Hello");
        return "mapRender";
    }

    @GET
    @Path("/mindstr/{jiraId}")
    @Produces(APPLICATION_JSON)
    @RequestMapping(value = "/mindstr/{jiraId}", method = RequestMethod.GET)
    public String getMindstrResponseDTO(@ModelAttribute("jiraId") String jiraId, Model model) throws Exception {

        MindstrResponseMainDto mindstrResponseMainDto = mindstrService.getMindstrResponseMainDto(jiraId);
        model.addAttribute("jiraId",mindstrResponseMainDto.getJiraId());
        model.addAttribute("summary",mindstrResponseMainDto.getSummary());
        model.addAttribute("issueType",mindstrResponseMainDto.getIssuetype());
        model.addAttribute("status",mindstrResponseMainDto.getMindstrStatus());
        model.addAttribute("issueLink1","https://test.atlassian.net/browse/"+mindstrResponseMainDto.getMindstrLinkedIssuesList().get(0).getLinkedJiraId());
        model.addAttribute("issueLink2","https://test.atlassian.net/browse/"+mindstrResponseMainDto.getMindstrLinkedIssuesList().get(1).getLinkedJiraId());
        model.addAttribute("issueLink3","https://test.atlassian.net/browse/"+mindstrResponseMainDto.getMindstrLinkedIssuesList().get(2).getLinkedJiraId());
        model.addAttribute("labels",mindstrResponseMainDto.getMindstrReleaseDto().getReleaseLabel());
        model.addAttribute("description",mindstrResponseMainDto.getMindstrDescriptionDto().getDescriptionInfo());
        model.addAttribute("DP",mindstrResponseMainDto.getMindstrDescriptionDto().getMindstrDescriptionProperties().getDynamicProperty());
        model.addAttribute("jobs",mindstrResponseMainDto.getMindstrDescriptionDto().getMindstrDescriptionProperties().getJobs());
        model.addAttribute("CP",mindstrResponseMainDto.getMindstrDescriptionDto().getMindstrDescriptionProperties().getClientProperties());
        model.addAttribute("database",mindstrResponseMainDto.getMindstrDescriptionDto().getMindstrDescriptionProperties().getDatabase());
        model.addAttribute("restricted",mindstrResponseMainDto.getMindstrDescriptionDto().getMindstrDescriptionProperties().getRestricted());
        model.addAttribute("impactedModule","reporting,paid,lst,fpx");
        model.addAttribute("resource1",mindstrResponseMainDto.getMindstrResources().getResourcesLinks().get(0));
        model.addAttribute("resource2","https://test.atlassian.net/wiki/display/SPR/Dynamic+Property+and+Client+Property");
        for(String pplkey : mindstrResponseMainDto.getMindStrPeople().keySet()){
            model.addAttribute(pplkey,mindstrResponseMainDto.getMindStrPeople().get(pplkey));
        }
        model.addAttribute("moztrap",mindstrResponseMainDto.getMindstrScenariosDto().toString());
        model.addAttribute("demoRecording",mindstrResponseMainDto.getFeatureRecordings());
        return "index";
    }


}
