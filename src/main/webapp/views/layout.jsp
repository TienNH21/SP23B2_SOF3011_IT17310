<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/17/23
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/SP23B2_SOF3011_IT17310_war_exploded/css/bootstrap.min.css" />

</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="row mt-3" style="min-height: 500px;">
    <div class="col-3 bg-warning">Side bar</div>
    <div class="col-9 bg-light">
        <jsp:include page="${ view }" />
    </div>
</div>

<div class="bg-dark text-white">Footer</div>

<script src="/SP23B2_SOF3011_IT17310_war_exploded/js/bootstrap.min.js"></script>

</body>
</html>
