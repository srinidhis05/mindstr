package com.mindster.DTO.JiraDto;

/**
 * Created by priyasarkar on 17/12/16.
 */
public class Schema {
    private String type;
    private String custom;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
    }

    private int customId;

}
