<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SarataTech Servlet</title>
        <link rel="stylesheet" href="webjars/bootstrap/4.6.1/css/bootstrap.min.css">
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/welcome.do">STS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/welcome.do">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/student.do">Students</a>
                </li>
            </ul>
            <span class="navbar-text">
              <a href="/logout.do" class="btn btn-danger text-white">Logout</a>
            </span>
        </div>
    </nav>
        <div class="container">
            <div class="jumbotron">
                <% String username = (String) request.getSession().getAttribute("username"); %>
                <h1 class="display-4">Welcome back, <%=username%></h1>
                <p class="lead">
                    Welcome to our Todo application where you can manage all your task!
                </p>
                <hr class="my-4"/>
                <p>
                    Get the list of our Todos
                </p>
                <a class="btn btn-lg btn-outline-primary" href="/student.do">Click here</a>
            </div>
        </div>

        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        <script src="webjars/popper.js/2.9.3/umd/popper.js"></script>
        <script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
    </body>
</html>

