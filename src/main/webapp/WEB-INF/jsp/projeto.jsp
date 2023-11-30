<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="pt_BR" scope="session"/>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Desafio Java</title>
    <link href="../webjars/bootstrap/5.3.0/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">

    <nav aria-label="breadcrumb" style="margin-top: 10px;">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">
                <a href="/">Voltar</a></li>
        </ol>
    </nav>
    <div class="card" style="margin-top: 10px">
       <div class="card-body">
            <h5 class="card-title">Listagem dos Projetos</h5>
            <table class="table table-striped" style="font-size: 14px;">
             <thead>
               <tr>
                   <th>Nome Projeto</th>
                   <th>Data Início</th>
                   <th>Data Previsão Fim</th>
                   <th>Data Fim</th>
                   <th>Orçamento</th>
                   <th>Risco</th>
                   <th>Gerente</th>
                   <th>Status</th>
                   <th colspan="2">Ações</th>
               </tr>
               </thead>
               <tbody>
               <c:forEach items="${projetos}" var="projeto">
                   <tr>
                       <td>${projeto.nome}</td>
                       <td><fmt:formatDate value="${projeto.dataInicio}" pattern="dd/MM/yyyy"/></td>
                       <td><fmt:formatDate value="${projeto.dataPrevisaoFim}" pattern="dd/MM/yyyy"/></td>
                       <td><fmt:formatDate value="${projeto.dataFim}" pattern="dd/MM/yyyy"/></td>
                       <td><fmt:formatNumber value="${projeto.orcamento}" type="currency" /></td>
                       <td>${projeto.risco}</td>
                       <td>${projeto.pessoa.nome}</td>
                       <td>${projeto.status}</td>
                       <td><a href="/editarProjeto/${projeto.id}">
                           <img src="/static/images/ico_alterar.png" style="width: 22px;" class="card-img-top" alt="Alterar"></a></td>

                       <c:if test="${projeto.status == 'Iniciado' || projeto.status == 'Em andamento' || projeto.status == 'Encerrado'}"  >
                          <td></td>
                       </c:if>

                       <c:if test="${projeto.status != 'Iniciado' && projeto.status != 'Em andamento' && projeto.status != 'Encerrado'}"  >
                           <td><a href="/removerProjeto/${projeto.id}">
                               <img src="/static/images/ico_remove.png" style="width: 22px;" class="card-img-top" alt="Remover"></a></td>
                       </c:if>

                   </tr>
               </c:forEach>
               </tbody>
           </table>

        </div>

        <div class="card-footer">
            <a class="btn btn-primary" href="/novoProjeto">Novo Projeto</a>
        </div>
    </div>


 </div>

</body>

<script src="../webjars/jquery/3.6.4/jquery.min.js"></script>
<script src="../webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</html>