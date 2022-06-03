<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Student" %>
<%@ page import="model.Student" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SarataTech Servlet</title>
        <link rel="stylesheet" href="webjars/bootstrap/4.6.1/css/bootstrap.min.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <style>
            i.bx {
                font-size: 24px;
            }
            i.bx-check-double {
                color: green;
            }
            i.bx-x {
                color: red;
            }
        </style>
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
                    <a class="nav-link" href="/student.do">Students</a>
                </li>
            </ul>
            <span class="navbar-text">
              <a href="/logout.do" class="btn btn-danger text-white">Logout</a>
            </span>
        </div>
    </nav>
    <br>
        <div class="container">
            <%--New Todo form --%>
            <form action="/student.do" method="post">
                <div class="row">
                    <div class="form-group col">
                        <label>FirstName</label>
                        <input type="text" class="form-control" name="firstname"/>
                    </div>
                    <div class="form-group col">
                        <label>LastName</label>
                        <input type="text" class="form-control" name="lastName"/>
                    </div>
                    <div class="form-group col">
                        <label>Date of Birth</label>
                        <input type="date" class="form-control" name="dateofbirth"/>
                    </div>
                    <div class="form-group col">
                        <label>Training Duration</label>
                        <select class="form-control" name="training">
                            <option>6 months</option>
                            <option>12 months</option>
                        </select>
                    </div>
                </div>
                <button class="btn btn-success" >Save</button>
            </form>

            <% List<Student> students = (List<Student>) request.getAttribute("students"); %>
                <hr class="my-5"/>
            <div class="table-responsive">
                <table class="table table-hover table-borderless">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col" class="text-center">ID</th>
                        <th scope="col" class="text-center">First Name</th>
                        <th scope="col" class="text-center">Lsat Name</th>
                        <th scope="col" class="text-center">Date of Birth</th>
                        <th scope="col" class="text-center">Training Dur</th>
                        <th scope="col" class="text-center">Registration Date</th>
                        <th scope="col" class="text-center">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for(Student t : students) { %>
                    <tr>
                        <td class="text-center"><%= t.getId() %></td>
                        <td class="text-center"><%= t.getFirstname() %></td>
                        <td class="text-center"><%= t.getLastname() %></td>
                        <td class="text-center"><%= t.getDateOfBirth() %></td>
                        <td class="text-center"><%= t.getTrainingDuration() %></td>
                        <td class="text-center"><%= t.getRegistrationDate() %></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="/update-student.do?id=<%=t.getId()%>">Update</a>
                            <a class="btn btn-danger" href="/delete-student.do?id=<%=t.getId()%>">Delete</a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>

    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/popper.js/2.9.3/umd/popper.js"></script>
    <script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
    </body>
</html>

