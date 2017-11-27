package com.mindster.DTO.MindsterDto;

import com.mindster.DTO.JiraDto.JiraStatusDto;
import com.mindster.enums.MindstrStatusEnum;

/**
 * Created by shreyas on 17/12/16.
 */
public class MindstrLinkedIssues {

    public String mindstrStatus;

    public String getMindstrStatus() {
        return mindstrStatus;
    }

    public void setMindstrStatus(String mindstrStatus) {
        this.mindstrStatus = mindstrStatus;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLinkedJiraId() {
        return linkedJiraId;
    }

    public void setLinkedJiraId(String linkedJiraId) {
        this.linkedJiraId = linkedJiraId;
    }

    public String summary;
    private String  linkedJiraId;

    @Override
    public String toString() {
        return "mindstrStatus:"+mindstrStatus+
                ",summary:"+summary+
                ",linkedJiraId:"+linkedJiraId;
    }

}
