<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>RobocupBet</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black">
	<main
		class="container h-100 d-flex flex-column justify-content-center align-items-center">
		<article
<<<<<<< HEAD
			class="bg-robocup d-flex justify-content-center align-items-center">

			<div class="crime">
				<h1 class="title-cup">RoboCup BET</h1>
			</div>

			<form class="form-usuario w-50 bg-black">
=======
			class="row bg-robocup d-flex justify-content-center align-items-center">
			<form class="form-usuario w-50 bg-black" action="criaConta" method="post"> 
>>>>>>> 87ae0582650eb2e65431be7863315c32312e70cd
				<h2 class="text-center text-light fs-3">Crie uma conta</h2>
				<div class="p-4">
					<div class="mb-3">
						<label for="exampleInputNome1" class="form-label text-light">Nome
							de usuário</label> <input type="text" class="form-control" name="usuarioNome" id="exampleInputNome1">
					</div>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label text-light">E-mail</label>
						<input type="email" class="form-control" id="exampleInputEmail1" name="usuarioEmail" aria-describedby="emailHelp">
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label text-light">Senha</label>
						<input type="password" class="form-control" name="usuarioSenha" id="exampleInputPassword1">
					</div>
					<div class="mt-3">
						<button type="submit"
							class="btn btn-style w-100 text-light fw-bold mt-3">Criar
							conta</button>
					</div>
					<div class="mt-3 d-flex justify-content-center">
						<a class="link-conta"
							href="http://localhost:8080/robocupbet/login.jsp">Login</a>
					</div>
				</div>
			</form>
		</article>
	</main>
</body>
</html>