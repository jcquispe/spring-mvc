<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Edit Student</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
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
            <div class="row">
                <div class="col s6 offset-s3">
                    <h2 class="center-align">Edit Student</h2>
                    <div class="card horizontal">
                        <div class="card-stacked">
                            <div class="card-content">
                                <form:form action="save" method="post" modelAttribute="student">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <form:input id="id" path="id" readonly="true"/>
                                            <label for="id">ID</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <form:input id="first_name" path="firstName" />
                                            <label for="first_name">First Name</label>
                                        </div>
                                        <div class="input-field col s6">
                                            <form:input id="last_name" path="lastName" />
                                            <label for="last_name">Last Name</label>
                                        </div>
                                    </div>
                                    <div class="row center-align">
                                        <button class="btn waves-effect waves-light" type="submit">Save</button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>