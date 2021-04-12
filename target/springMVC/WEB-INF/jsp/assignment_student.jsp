<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Classes by Student</title>
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
            <h2 class="center-align">Student Assignments</h2>
            <div class="row">
                <div class="col s4 offset-s4">
                    <div class="card horizontal">
                        <div class="card-stacked">
                            <div class="card-content">
                                <p>ID: ${student.id}</p>
                                <p>FIRST NAME: ${student.firstName}</p>
                                <p>LAST NAME: ${student.lastName}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a href="new?id=${student.id}" class="waves-effect waves-light btn">New Assignment</a>

            <table class="display" style="width:100%" id="assignments">
                <thead>
                    <tr>
                        <th>Class code</th>
                        <th>Class title</th>
                        <th>Class description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${grades}" var="grade">
                    <tr>
                        <td>${grade.cod}</td>
                        <td>${grade.title}</td>
                        <td>${grade.description}</td>
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