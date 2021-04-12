<%@ page contentType="text/html; charset=UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <title>Digital Harbor</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col s4 offset-s4">
                    <h2 class="center-align">${message}</h2>
                    <div class="card horizontal">
                        <div class="card-stacked">
                            <div class="card-content">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="user" type="text" class="validate" value="admin">
                                        <label for="user">User</label>
                                    </div>
                                    <div class="input-field col s12">
                                        <input id="password" type="password" class="validate" value="admin">
                                        <label for="password">Password</label>
                                    </div>
                                </div>
                                <div class="row center-align">
                                    <a href="student" class="waves-effect waves-light btn">LOGIN</a>
                                </div>
                            </div
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>