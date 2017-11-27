package com.mindster.DTO.JiraDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class JiraIssueType {
    private String subtask;

    private String id;

    private String avatarId;

    private String description;

    private String name;

    private String iconUrl;

    private String self;

    public String getSubtask ()
    {
        return subtask;
    }

    public void setSubtask (String subtask)
    {
        this.subtask = subtask;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAvatarId ()
    {
        return avatarId;
    }

    public void setAvatarId (String avatarId)
    {
        this.avatarId = avatarId;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
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
