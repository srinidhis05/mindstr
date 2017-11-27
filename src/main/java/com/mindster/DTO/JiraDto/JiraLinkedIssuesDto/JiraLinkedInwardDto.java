package com.mindster.DTO.JiraDto.JiraLinkedIssuesDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class JiraLinkedInwardDto {
    private String id;

    private String self;

    private String key;

    private JiraLinkedFieldsDto fields;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSelf ()
    {
        return self;
    }

    public void setSelf (String self)
    {
        this.self = self;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public JiraLinkedFieldsDto getFields ()
    {
        return fields;
    }

    public void setFields (JiraLinkedFieldsDto fields)
    {
        this.fields = fields;
    }
}
