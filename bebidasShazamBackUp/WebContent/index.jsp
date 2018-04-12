<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>
<body>

	<form name="endereco" method="post"
		action="ControlePessoa?acao=cadastrarPF">

		<h4>Dados Gerais:</h4>
		<hr>

		<label>Nome: 
			<input name="nome" placeholder="Digite aqui" />
		</label> <br/><br/>
		
		<label>Telefone: 
			<input name="telefone" placeholder="Digite aqui" />
		</label> <br/><br/>
		
		<label>CPF: 
			<input name="cpf" placeholder="Digite aqui" />
		</label> <br/><br/>

		<h4>Endereço:</h4>
		<hr>

		<label>Logradouro: 
			<input name="logradouro" placeholder="Digite aqui" />
		</label> <br/><br/>
		
		<label>Bairro: 
			<input name="bairro" placeholder="Digite aqui" />
		</label> <br/><br/>
		
		<label>Cep: 
			<input name="cep" placeholder="Digite aqui" />
		</label> <br/><br/>
		
		<label>Cidade: 
			<input name="cidade" placeholder="Digite aqui" />
		</label> <br/><br/>
		
		<label>Estado: 
			<input name="estado" placeholder="Digite aqui" />
		</label> <br/><br/>

		<input type="submit" value="Cadastrar" id="cadastrar"/>

	</form>

</body>
</html>