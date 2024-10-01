<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black">

	<nav class="navbar navbar-expand-lg p-3 d-flex header-page">
				<a class="navbar-brand ms-5 fs-2 text-light" href="/robocupbet/">
					<span class="title-cup">RoboCup</span> BET
				</a>
				<div class="collapse navbar-collapse grid gap-0 column-gap-3"
					id="navbarNav">
					<ul class="navbar-nav ms-auto me-5 fs-5">
						<li class="nav-item p-3"><a class="nav-link text-white"
							href="/robocupbet/index">Apostas</a></li>
						<li class="nav-item p-3"><a class="nav-link text-white"
							href="/robocupbet/loja.jsp">Loja</a></li>
						<li class="nav-item p-3"><a class="nav-link text-white"
							href="/robocupbet/perfil.jsp">Perfil</a></li>
						<li class="nav-item p-3"><a class="nav-link text-white"
							href="/robocupbet/logout">Logout</a></li>
					</ul>
				</div>
			</nav>

	<main
		class="container d-flex flex-column justify-content-center align-items-center">
		<h1 class="text-light">${usuario.nome}</h1>
		<h3 class="text-light">Bem-Vindo ao seu Perfil</h3>

		<div class="d-flex flex-column align-items-start gap-5">
			<div class="container d-flex align-items-center justify-content-evenly">
				<h4 class="text-light me-3">Usuário:</h4>
				<input class="form-control w-75 mt-4 mb-4">
							 
			</div>
			<div class="container d-flex align-items-center justify-content-evenly">
				<h4 class="text-light me-3">Email:</h4>
				<input class="form-control w-75 mt-4 mb-4">
			</div>
			<div class="container d-flex align-items-center justify-content-evenly">
				<h4 class="text-light me-3">Senha:</h4>
				<input class="form-control w-75 mt-4 mb-4">
			</div>
			<div class="container d-flex align-items-center">
				<h4 class="text-light me-3">Histórico de Compras</h4>
				
			</div>
		</div>

	</main>

</body>
</html>