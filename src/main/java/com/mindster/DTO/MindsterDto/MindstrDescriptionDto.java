package com.mindster.DTO.MindsterDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class MindstrDescriptionDto {

    /**
     * We'll pasrse JIRA description and comments and show in mindstr description info
     */

    public String descriptionInfo;

    public String getDescriptionInfo() {
        return descriptionInfo;
    }

    public void setDescriptionInfo(String descriptionInfo) {
        this.descriptionInfo = descriptionInfo;
    }

    public MindstrDescriptionProperties getMindstrDescriptionProperties() {
        return mindstrDescriptionProperties;
    }

    public void setMindstrDescriptionProperties(MindstrDescriptionProperties mindstrDescriptionProperties) {
        this.mindstrDescriptionProperties = mindstrDescriptionProperties;
    }

    public MindstrDescriptionProperties mindstrDescriptionProperties;

    @Override
    public  String toString(){
        return "descriptionInfo:"+descriptionInfo+
                ",mindstrDescriptionProperties:{"+mindstrDescriptionProperties.toString()+"}";
    }

}
