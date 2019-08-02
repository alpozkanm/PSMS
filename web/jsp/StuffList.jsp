<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<%@include file="sp"%>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <%@include file="sp"%>
    <main class="mdl-layout__content">
        <div class="page-content">
            <div class="mdl-grid center-items">
                <div class="mdl-cell mdl-cell-4-col">
                    <div>
                        <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                            <thead>
                            <tr>
                                <th class="mdl-data-table__cell--non-numeric">NO</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Quantity</th>
                                <th>Location</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="count" value="0" scope="page"/>
                            <c:forEach var="stuff" items="${listStuff}"/>
                            <c:set var="count" value="${count+1}" scope="page"/>
                        <tr>
                            <td class="mdl-data-table___cell--non-numeric"><c:out value="${count}"/></td>
                            <td><c:out value="${stuff.name}"/> </td>
                            <td><c:out value="${stuff.description}"/> </td>
                            <td><c:out value="${stuff.quantity}"/> </td>
                            <td><c:out value="${stuff.location}"/> </td>
                            <td><a href="/PSMS/edit?id=<c:out value='${stuff.id}'/>">Edit</a></td>&nbsp;&nbsp;&nbsp;&nbsp;
                            <td><a href="/PSMS/delete?id=<c:out value='${stuff.id}'/>">Delete</a></td>

                        </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>