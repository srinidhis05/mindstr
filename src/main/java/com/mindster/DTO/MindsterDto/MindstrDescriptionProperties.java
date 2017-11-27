package com.mindster.DTO.MindsterDto;

/**
 * Created by shreyas on 17/12/16.
 */
public class MindstrDescriptionProperties {

    public String dynamicProperty, jobs, clientProperties ,database, restricted,  impactedModules;




    public String getDynamicProperty() {
        if(dynamicProperty == null){
            dynamicProperty="";
        }
        return dynamicProperty;
    }

    public void setDynamicProperty(String dynamicProperty) {
        this.dynamicProperty = dynamicProperty;
    }

    public String getJobs() {
        if(jobs == null){
            jobs="";
        }
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getClientProperties() {
        if(clientProperties == null){
            clientProperties="";
        }
        return clientProperties;
    }

    public void setClientProperties(String clientProperties) {
        this.clientProperties = clientProperties;
    }

    public String getDatabase() {
        if(database == null )
        {
            database="";
        }
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getRestricted() {
        if(restricted == null){
            restricted="";
        }
        return restricted;
    }

    public void setRestricted(String restricted) {
        this.restricted = restricted;
    }

    public String getImpactedModules() {
       if(impactedModules == null){
           impactedModules="";
       }
        return impactedModules;
    }

    public void setImpactedModules(String impactedModules) {
        this.impactedModules = impactedModules;
    }

    @Override
    public String toString(){
        return "dynamicProperty:"+dynamicProperty+
                ",jobs:"+jobs+
                ",clientProperties:"+clientProperties+
                ",database:"+database+
                ",restricted:"+restricted+
                ",impactedModules:"+impactedModules;
    }


}
