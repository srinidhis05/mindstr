package com.mindster.DTO.JiraDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class People {
    private String name;

    private String active;

    private String emailAddress;

    private String timeZone;

    private String self;

    private String displayName;


    private String key;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public String getEmailAddress ()
    {
        return emailAddress;
    }

    public void setEmailAddress (String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getTimeZone ()
    {
        return timeZone;
    }

    public void setTimeZone (String timeZone)
    {
        this.timeZone = timeZone;
    }

    public String getSelf ()
    {
        return self;
    }

    public void setSelf (String self)
    {
        this.self = self;
    }

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    @Override
    public String toString(){
        return  "name:"+name+
                ",active:"+active+
                ",emailAddress:"+emailAddress+
                ",timeZone:"+timeZone+
                ",self:"+self+
                ",displayName:"+displayName+
                ",key"+key;
    }


}
