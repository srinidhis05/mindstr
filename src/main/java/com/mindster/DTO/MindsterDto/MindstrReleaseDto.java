package com.mindster.DTO.MindsterDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class MindstrReleaseDto {

    //make release label a single comma separated string
    public String releaseLabel ;


    public String getReleaseLabel() {
        return releaseLabel;
    }

    public void setReleaseLabel(String releaseLabel) {
        this.releaseLabel = releaseLabel;
    }

    @Override
    public String toString() {
        return "releaseLabel:"+releaseLabel;
    }

}
