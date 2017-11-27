package com.mindster.DTO.JiraDto.JiraLinkedIssuesDto;

import com.mindster.DTO.JiraDto.JiraIssueType;
import com.mindster.DTO.JiraDto.JiraStatusDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class JiraLinkedFieldsDto {
    private String summary;

    private JiraIssueType issuetype;

    private JiraStatusDto status;

    private JiraLinkedPriority priority;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public JiraIssueType getIssuetype ()
    {
        return issuetype;
    }

    public void setIssuetype (JiraIssueType issuetype)
    {
        this.issuetype = issuetype;
    }

    public JiraStatusDto getStatus ()
    {
        return status;
    }

    public void setStatus (JiraStatusDto status)
    {
        this.status = status;
    }

    public JiraLinkedPriority getPriority ()
    {
        return priority;
    }

    public void setPriority (JiraLinkedPriority priority)
    {
        this.priority = priority;
    }
}
