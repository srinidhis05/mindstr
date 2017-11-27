package com.mindster.DTO.JiraDto.JiraLinkedIssuesDto;

/**
 * Created by shreyas on 18/12/16.
 */
public class JiraLinkedTypeDto {

    private String id;

    private String outward;

    private String inward;

    private String name;

    private String self;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getOutward ()
    {
        return outward;
    }

    public void setOutward (String outward)
    {
        this.outward = outward;
    }

    public String getInward ()
    {
        return inward;
    }

    public void setInward (String inward)
    {
        this.inward = inward;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
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
