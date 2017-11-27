package com.mindster.DTO.MindsterDto;

import java.util.List;

/**
 * Created by shreyas on 17/12/16.
 */
public class MindstrResources {

    public List<String> resourcesLinks ;


    public List<String> getResourcesLinks() {
        for(String resourceLink:resourcesLinks) {
           resourceLink="";
        }
        return resourcesLinks;
    }

    public void setResourcesLinks(List<String> resourcesLinks) {
        this.resourcesLinks = resourcesLinks;
    }

}
