package com.mindster.DTO.JiraDto;

/**
 * Created by priyasarkar on 17/12/16.
 */
public class CustomFieldMapping {
    private Schema schema;

    private String id;

    private String orderable;

    private String[] clauseNames;

    private String name;

    private String navigable;

    private String searchable;

    private String key;

    private String custom;



    public Schema getSchema ()
    {
        return schema;
    }

    public void setSchema (Schema schema)
    {
        this.schema = schema;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getOrderable ()
    {
        return orderable;
    }

    public void setOrderable (String orderable)
    {
        this.orderable = orderable;
    }

    public String[] getClauseNames ()
    {
        return clauseNames;
    }

    public void setClauseNames (String[] clauseNames)
    {
        this.clauseNames = clauseNames;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getNavigable ()
    {
        return navigable;
    }

    public void setNavigable (String navigable)
    {
        this.navigable = navigable;
    }

    public String getSearchable ()
    {
        return searchable;
    }

    public void setSearchable (String searchable)
    {
        this.searchable = searchable;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getCustom ()
    {
        return custom;
    }

    public void setCustom (String custom)
    {
        this.custom = custom;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [schema = "+schema+", id = "+id+", orderable = "+orderable+", clauseNames = "+clauseNames+", name = "+name+", navigable = "+navigable+", searchable = "+searchable+", key = "+key+", custom = "+custom+"]";
    }
}
