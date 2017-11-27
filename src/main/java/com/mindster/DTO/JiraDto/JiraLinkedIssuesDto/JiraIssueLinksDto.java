package com.mindster.DTO.JiraDto.JiraLinkedIssuesDto;

/**
 * Created by shreyas on 18/12/16.
 */
public class JiraIssueLinksDto {




    private String id;

    private JiraLinkedInwardDto inwardIssue;

    private String self;

    private JiraLinkedTypeDto type;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public JiraLinkedInwardDto getInwardIssue ()
    {
        return inwardIssue;
    }

    public void setInwardIssue (JiraLinkedInwardDto inwardIssue)
    {
        this.inwardIssue = inwardIssue;
    }

    public String getSelf ()
    {
        return self;
    }

    public void setSelf (String self)
    {
        this.self = self;
    }

    public JiraLinkedTypeDto getType ()
    {
        return type;
    }

    public void setType (JiraLinkedTypeDto type)
    {
        this.type = type;
    }
}
