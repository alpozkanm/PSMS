<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Calendar" %>
<header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
        <span class="mdl-layout-title">Personal Stuff Management System</span>
        <div class="mdl-layout-spacer"></div>
        <tag:formatDate value="<%@=Calendar.getInstance().getTime()%>"></tag:formatDate>
    <nav class="mdl-navigation mdl-layout--large-screen-only">
        <a class="mdl-navigation__link" href="/PSMS/new/">Add New Stuff</a>
        <a class="mdl-navigation__link" href="/PSMS/list/">List All Stuff</a>
    </nav>
    </div>
</header>
<div class="mdl-layout__drawer">
    <span class="mdl-layout-title">PSMS</span>
    <nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="/PSMS/new/">Add New Stuff</a>
        <a class="mdl-navigation__link" href="/PSMS/list/">List All Stuff</a>
    </nav>
</div>