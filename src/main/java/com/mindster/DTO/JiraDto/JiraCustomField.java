package com.mindster.DTO.JiraDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class JiraCustomField {
    private String id;

    private String value;

    private String self;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getSelf ()
    {
        return self;
    }

    public void setSelf (String self)
    {
        this.self = self;
    }
}
