<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Students by Class</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
    </head>
    <body>
        <nav>
            <div class="nav-wrapper teal">
                <a href="#" class="brand-logo">DH</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="../student">Students</a></li>
                    <li><a href="../class">Classes</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h2 class="center-align">Students from Class</h2>
            <div class="row">
                <div class="col s4 offset-s4">
                    <div class="card horizontal">
                        <div class="card-stacked">
                            <div class="card-content">
                                <p>COD: ${grade.cod}</p>
                                <p>TITLE: ${grade.title}</p>
                                <p>DESCRIPTION: ${grade.description}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table class="display" style="width:100%" id="assignments">
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Student First Name</th>
                        <th>Student Last Name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
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
                $('#assignments').DataTable();
            } );
        </script>
    </body>
</html>