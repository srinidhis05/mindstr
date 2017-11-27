package com.mindster.DTO.JiraDto.JiraLinkedIssuesDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class JiraLinkedPriority {
    private String id;

    private String name;

    private String iconUrl;

    private String self;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getIconUrl ()
    {
        return iconUrl;
    }

    public void setIconUrl (String iconUrl)
    {
        this.iconUrl = iconUrl;
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
