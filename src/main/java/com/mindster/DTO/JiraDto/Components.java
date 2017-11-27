package com.mindster.DTO.JiraDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class Components {

        private String id;

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
