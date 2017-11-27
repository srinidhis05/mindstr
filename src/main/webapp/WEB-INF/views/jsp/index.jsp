<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.mindster.DTO.MindsterDto.MindstrResponseMainDto" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: srinidhis
  Date: 17/08/16
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.15/jquery-ui.min.js"></script>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/core/js/js-mindmap.js" var="mindMapJS" />
    <spring:url value="/resources/core/js/raphael-min.js" var="raphaelJS"/>
    <spring:url value="/resources/core/js/script.js" var="scriptJS"/>
    <spring:url value="/resources/core/css/style.css" var="styleCSS" />

    <spring:url value="/resources/core/css/js-mindmap.css" var="mindMapCSS" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${styleCSS}" rel="stylesheet"/>
    <link href="${mindMapCSS}" rel="stylesheet"/>
    <script type="text/javascript" src="${raphaelJS}"></script>
    <script type="text/javascript" src="${mindMapJS}"></script>
    <script type="text/javascript" src="${scriptJS}"></script>
    <title>Mindster</title>
  </head>
  <body>
   <ul>
     <li><a href="" >${issueType} : ${jiraId} : ${summary}</a>
     <ul>
     <li><a>Implementation Details</a>
     <ul>
       <li><a title="${DP}" rel="circle">Dynamic Properties</a></li>
       <li><a title="${jobs}"rel="circle">Jobs</a></li>
       <li><a title="${CP}"rel="circle">Custom Properties</a></li>
       <li><a title="${database}"rel="circle">Database Info</a></li>
       <li><a title="${restricted}"rel="circle">Restricted Calls</a></li>
       <li><a title="${impactedModule}"rel="circle">Impacted Modules</a></li>
     </ul>
     </li>
     <li><a href="" rel="square">Linked Jira's</a>
     <ul>
       <li><a >${issueLink1}</a></li>
       <li><a >${issueLink2}</a></li>
       <li><a >${issueLink3}</a></li>
     </ul>
     </li>
     <li><a href="" rel="square">References</a>
       <ul>
         <li><a>${resource1}</a></li>
       </ul>
     </li>
     <li><a href="" rel="square">Release Version: ${labels}</a></li>
     <li><a href="" rel="square">Status: ${status}</a></li>
     <li><a>Collaborators</a>
     <ul>
       <li><a>Assigne:"${Assignee}"</a></li>
       <li><a>Assigned QA :"${Assigned_QA}"</a></li>
       <li><a>Reporter :"${Reporter}</a></li>
     </ul>
     </li>
     <li><a>Moztrap Scenarios</a>
     <ul>
       <li><a title="${moztrap}">Test Cases</a></li>
     </ul>
     <li><a title="${demoRecording}">Hand Off Recording</a></li>
       <li><a >Description</a>
       <ul><li><a>${description}</a></li></ul></li>
     </ul>
     </li>
   </ul>
  </body>
</html>
