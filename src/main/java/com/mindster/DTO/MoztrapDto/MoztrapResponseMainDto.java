package com.mindster.DTO.MoztrapDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class MoztrapResponseMainDto {
    private String created_by;

    private String[] tags;

    private String priority;

    private String name;

    private MoztrapStepsDto[] steps;

    private String[] suites;

    private String id;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_by ()
    {
        return created_by;
    }

    public void setCreated_by (String created_by)
    {
        this.created_by = created_by;
    }

    public String[] getTags ()
    {
        return tags;
    }

    public void setTags (String[] tags)
    {
        this.tags = tags;
    }

    public String getPriority ()
    {
        return priority;
    }

    public void setPriority (String priority)
    {
        this.priority = priority;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public MoztrapStepsDto[] getSteps ()
    {
        return steps;
    }

    public void setSteps (MoztrapStepsDto[] steps)
    {
        this.steps = steps;
    }

    public String[] getSuites ()
    {
        return suites;
    }

    public void setSuites (String[] suites)
    {
        this.suites = suites;
    }
}
