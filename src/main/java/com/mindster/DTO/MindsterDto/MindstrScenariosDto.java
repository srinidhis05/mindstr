package com.mindster.DTO.MindsterDto;

import com.mindster.DTO.JiraDto.Comment;
import com.mindster.DTO.MoztrapDto.MoztrapResponseMainDto;
import com.mindster.DTO.MoztrapDto.MoztrapStepsDto;

import java.util.List;

/**
 * Created by shreyas on 17/12/16.
 */
public class MindstrScenariosDto {


    private String created_by;

    private String[] tags;

    private String priority;

    private String name;

    private List<MoztrapStepsDto> steps;

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

    public List<MoztrapStepsDto> getSteps ()
    {
        return steps;
    }

    public void setSteps (List<MoztrapStepsDto> steps)
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

    @Override
    public String toString(){
        return "created_by:"+created_by+
                ",tags:["+convertTagsToString(tags)+"]"+
                ",priority:"+priority+
                ",name:"+name+
                ",steps:["+convertStepsToString(steps)+"]"+
                ",suites:["+convertSuitesToString(suites)+"]"+
                ",id:"+id;
    }

    private String convertSuitesToString(String[] suites) {
        String obtainedStr="";
        for (String suite : suites){
            obtainedStr+=suite+",";
        }
        obtainedStr = obtainedStr.substring(0,obtainedStr.length()-1);
        return obtainedStr;
    }

    private String convertStepsToString(List<MoztrapStepsDto> steps) {
        String obtainedStr="";
        for (MoztrapStepsDto moztrapStepsDto : steps){
            obtainedStr+=moztrapStepsDto.toString()+",";
        }
        obtainedStr = obtainedStr.substring(0,obtainedStr.length()-1);
        return obtainedStr;
    }

    private String convertTagsToString(String[] tags) {
        String obtainedStr="";
        for (String tag : tags){
            obtainedStr+=tag+",";
        }
        obtainedStr = obtainedStr.substring(0,obtainedStr.length()-1);
        return obtainedStr;

    }



}
