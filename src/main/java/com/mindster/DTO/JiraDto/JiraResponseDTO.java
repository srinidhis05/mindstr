package com.mindster.DTO.JiraDto;

import java.util.List;
import java.util.Map;

/**
 * Created by srinidhis on 17/12/16.
 */

public class JiraResponseDTO {

    private String id;

    private String expand;

    private String self;

    private String key;

    public Map<String, Object> getFields() {
        return fields;
    }



    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    private Map<String,Object> fields;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getExpand ()
    {
        return expand;
    }

    public void setExpand (String expand)
    {
        this.expand = expand;
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

}


