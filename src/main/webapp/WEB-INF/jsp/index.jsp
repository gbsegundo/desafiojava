<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Desafio Java</title>
    <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="card" style="width: 50%; margin-top: 10px">
            <img src="/static/images/img-projeto.jpg" class="card-img-top" alt="Projetos">
            <div class="card-body">
                <h5 class="card-title">Portofólio de Projetos</h5>
                <p class="card-text">Conjunto de projetos da empresa, tanto em andamento como em análise de viabilidade.</p>
                <a href="/listarProjeto" class="btn btn-primary">Acessar</a>
            </div>
        </div>
    </div>
</body>

<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</html>