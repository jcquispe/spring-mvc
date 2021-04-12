<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Students</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
    </head>
    <body>
        <nav>
            <div class="nav-wrapper teal">
                <a href="#" class="brand-logo">DH</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="student">Students</a></li>
                    <li><a href="class">Classes</a></li>
                    <li><a href="assignment">Assignments</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h2 class="center-align">Students Manager</h2>
            <a class="waves-effect waves-light btn" href="student/new">New Student</a>
            <table class="display" style="width:100%" id="students">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listStudent}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>
                            <a href="student/edit?id=${student.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="student/delete?id=${student.id}">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#students').DataTable();
            } );
        </script>
    </body>
</html>