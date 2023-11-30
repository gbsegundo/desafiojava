<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Desafio Java</title>
    <link href="../webjars/bootstrap/5.3.0/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="../webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.min.css"
          rel="stylesheet">
</head>
<body>

 <div class="container">
     <form action="/salvarProjeto" method="post" name="formProjeto" id="formProjeto" >
      <div class="card" style="margin-top: 10px">
         <div class="card-body">
             <h5 class="card-title" style="margin-bottom: 25px;">Cadastro de Projeto</h5>


                 <div class="row g-3" style="margin-bottom: 15px;">
                     <div class="col-md-9">
                         <label for="nome" class="form-label">Nome do projeto</label>
                         <input autofocus type="text" class="form-control" id="nome" name="nome">
                     </div>
                 </div>

                 <div class="row g-3"  style="margin-bottom: 15px;">
                     <div class="col-md-3">
                         <label for="dataInicio" class="form-label">Data início</label>
                         <input type="text" class="form-control datepicker" name="dataInicio" id="dataInicio">
                     </div>
                     <div class="col-md-3">
                         <label for="dataPrevisaoFim" class="form-label">Data previsão término</label>
                         <input type="text" class="form-control" name="dataPrevisaoFim" id="dataPrevisaoFim">
                     </div>
                     <div class="col-md-3">
                         <label for="dataFim" class="form-label">Data real término</label>
                         <input type="text" class="form-control" name="dataFim" id="dataFim">
                     </div>
                 </div>

                 <div class="row g-3"  style="margin-bottom: 15px;">
                     <div class="col-md-3">
                         <label for="orcamento" class="form-label">Orçamento total</label>
                         <input type="text" id="orcamento" name="orcamento" class="form-control" data-thousands="." data-decimal="," data-prefix="R$ " />
                     </div>
                     <div class="col-md-3">
                         <label for="risco" class="form-label">Classificação de risco</label>
                         <select class="form-select" aria-label="Default select example" id="risco" name="risco">
                             <option value="" selected></option>
                             <option value="Baixo risco">Baixo risco</option>
                             <option value="Médio risco">Médio risco</option>
                             <option value="Alto risco">Alto risco</option>
                         </select>
                     </div>

                     <div class="col-md-3">
                         <label for="status" class="form-label">Status do projeto</label>
                         <select class="form-select" aria-label="Default select example" id="status" name="status">
                             <option value="" selected></option>
                             <option value="Em análise">Em análise</option>
                             <option value="Análise realizada">Análise realizada</option>
                             <option value="Análise aprovada">Análise aprovada</option>
                             <option value="Iniciado">Iniciado</option>
                             <option value="Planejado">Planejado</option>
                             <option value="Em andamento">Em andamento</option>
                             <option value="Encerrado">Encerrado</option>
                             <option value="Cancelado">Cancelado</option>
                         </select>
                     </div>

                 </div>

                 <div class="row g-3"  style="margin-bottom: 15px;">
                     <div class="col-md-3">
                         <label for="idgerente" class="form-label">Gerente responsavel</label>
                         <select class="form-select" aria-label="Default select example" id="idgerente" name="idgerente">
                             <option value="" selected></option>
                             <c:forEach items="${gerentes}" var="gerente">
                                 <option value="${gerente.id}">${gerente.nome}</option>
                             </c:forEach>
                         </select>
                     </div>
                     <div class="col-md-6">
                         <label for="descricao" class="form-label">Descrição do projeto</label>
                         <textarea class="form-control" id="descricao" name="descricao" rows="4"></textarea>
                     </div>
                 </div>



         </div>
         <div class="card-footer">
             <button type="button" class="btn btn-primary"  style="float: right; margin-left: 10px;" onclick="validaCampos()" >Salvar Projeto</button>
             <a class="btn btn-secondary" href="/listarProjeto" style="float: right;">Cancelar</a>
         </div>
     </div>

     </form>
 </div>
</body>

<script src="../webjars/jquery/3.6.4/jquery.min.js"></script>
<script src="../webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
<script src="../webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
<script src="../webjars/bootstrap-datepicker/1.10.0/locales/bootstrap-datepicker.pt-BR.min.js"></script>
<script src="../webjars/jquery-maskmoney/3.0.2/dist/jquery.maskMoney.min.js"></script>
<script src="../webjars/jquery-mask-plugin/1.14.16/dist/jquery.mask.min.js"></script>

<script type="text/javascript">
    $(function () {
        $('#dataInicio').datepicker({
            language: 'pt-BR',
            autoclose: true,
            format: "dd/mm/yyyy"
        });

        $('#dataPrevisaoFim').datepicker({
            language: 'pt-BR',
            autoclose: true,
            format: "dd/mm/yyyy"
        });

        $('#dataFim').datepicker({
            language: 'pt-BR',
            autoclose: true,
            format: "dd/mm/yyyy"
        });

        $("#orcamento").maskMoney();

        $('#dataInicio').mask("99/99/9999");
        $('#dataFim').mask("99/99/9999");
        $('#dataPrevisaoFim').mask("99/99/9999");
    });

    function validaCampos() {
        if(document.getElementById("nome").value == '') {
            alert("Informe o nome do projeto!");
            document.getElementById("nome").focus();
        }else if(document.getElementById("dataInicio").value == '') {
            alert("Informe a data início do projeto!");
            document.getElementById("dataInicio").focus();
        }else if(document.getElementById("dataPrevisaoFim").value == '') {
            alert("Informe a data de previsão de término do projeto!");
            document.getElementById("dataPrevisaoFim").focus();
        }else if(document.getElementById("dataFim").value == '') {
            alert("Informe a data de término real do projeto!");
            document.getElementById("dataFim").focus();
        }else if(document.getElementById("orcamento").value == '') {
            alert("Informe o orçamento total do projeto!");
            document.getElementById("orcamento").focus();
        }
        else if(document.getElementById("risco").value == '') {
            alert("Informe a classificação de risco do projeto!");
            document.getElementById("risco").focus();
        }
        else if(document.getElementById("status").value == '') {
            alert("Informe o status do projeto!");
            document.getElementById("status").focus();
        }
        else if(document.getElementById("idgerente").value == '') {
            alert("Informe o gerente resonsável do projeto!");
            document.getElementById("idgerente").focus();
        }else{
            document.getElementById("formProjeto").submit();
        }


    }
</script>

</html>