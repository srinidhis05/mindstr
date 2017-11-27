package com.mindster.DTO.JiraDto;


import java.util.List;

/**
 * Created by shreyas on 17/12/16.
 */
public class JiraFields {
    private String summary;

    private JiraIssueType issuetype;

    private String timespent;

    private People reporter;

    private String created;

    private Project project;

    private String lastViewed;

    private Components[] components;

    private Comment comment;

    private String resolutiondate;

    private String duedate;

    private String timeestimate;

    private String timetracking;

    private String updated;

    private String description;

    private String[] issuelinks;

    private String[] subtasks;

    private JiraStatusDto jiraStatusDto;

    private String[] labels;

    private String workratio;

    private String environment;

    private People creator;

    private String aggregatetimeoriginalestimate;

    private People assignee;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public JiraIssueType getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(JiraIssueType issuetype) {
        this.issuetype = issuetype;
    }

    public String getTimespent() {
        return timespent;
    }

    public void setTimespent(String timespent) {
        this.timespent = timespent;
    }

    public People getReporter() {
        return reporter;
    }

    public void setReporter(People reporter) {
        this.reporter = reporter;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getLastViewed() {
        return lastViewed;
    }

    public void setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    }

    public Components[] getComponents() {
        return components;
    }

    public void setComponents(Components[] components) {
        this.components = components;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getResolutiondate() {
        return resolutiondate;
    }

    public void setResolutiondate(String resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getTimeestimate() {
        return timeestimate;
    }

    public void setTimeestimate(String timeestimate) {
        this.timeestimate = timeestimate;
    }

    public String getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(String timetracking) {
        this.timetracking = timetracking;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIssuelinks() {
        return issuelinks;
    }

    public void setIssuelinks(String[] issuelinks) {
        this.issuelinks = issuelinks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(String[] subtasks) {
        this.subtasks = subtasks;
    }

    public JiraStatusDto getJiraStatusDto() {
        return jiraStatusDto;
    }

    public void setJiraStatusDto(JiraStatusDto jiraStatusDto) {
        this.jiraStatusDto = jiraStatusDto;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String getWorkratio() {
        return workratio;
    }

    public void setWorkratio(String workratio) {
        this.workratio = workratio;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public People getCreator() {
        return creator;
    }

    public void setCreator(People creator) {
        this.creator = creator;
    }

    public String getAggregatetimeoriginalestimate() {
        return aggregatetimeoriginalestimate;
    }

    public void setAggregatetimeoriginalestimate(String aggregatetimeoriginalestimate) {
        this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    public People getAssignee() {
        return assignee;
    }

    public void setAssignee(People assignee) {
        this.assignee = assignee;
    }

    public Attachment[] getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment[] attachment) {
        this.attachment = attachment;
    }

    public String getAggregatetimeestimate() {
        return aggregatetimeestimate;
    }

    public void setAggregatetimeestimate(String aggregatetimeestimate) {
        this.aggregatetimeestimate = aggregatetimeestimate;
    }

    public String[] getVersions() {
        return versions;
    }

    public void setVersions(String[] versions) {
        this.versions = versions;
    }

    public List<CustomFieldMapping> getCustomfield() {
        return customfield;
    }

    public void setCustomfield(List<CustomFieldMapping> customfield) {
        this.customfield = customfield;
    }

    private Attachment[] attachment;

    private String aggregatetimeestimate;

    private String[] versions;

    private List<CustomFieldMapping> customfield ;

}
