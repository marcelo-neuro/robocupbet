<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>

<body class="container-fluid ">

	<main class="bg-hero-img shadow">

		<c:if test="${not empty usuario}">
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
		</c:if>

		<c:if test="${empty usuario}">
			<nav class="navbar navbar-expand-lg p-3 d-flex header-page">
				<a class="navbar-brand ms-5 fs-2 text-light" href="/robocupbet/">
					<span class="title-cup">RoboCup</span> BET
				</a>
				<div class="collapse navbar-collapse grid gap-0 column-gap-3"
					id="navbarNav">
					<ul class="navbar-nav ms-auto me-5 fs-5 ">
						<li class="nav-item p-3 g-col-6"><a
							class="nav-link text-white" href="/robocupbet/login.jsp">Login</a></li>
						<li class="nav-item p-3 g-col-6"><a
							class="nav-link text-white" href="/robocupbet/criarConta.jsp">Criar
								conta</a></li>
					</ul>
				</div>
			</nav>
		</c:if>

		<div class="container-home-page">
			<div class="text-white d-flex flex-column align-items-center">
				<h1 class="fw-normal">Seja bem-vindo ao Robocup Bet</h1>
				<p class="fs-5">Aqui você pode apostar nos melhores robôs do
					NEXT</p>
			</div>
		</div>

	</main>

	<footer
		class=" footer bg-grey d-flex flex-column justify-content-center align-items-center p-5">

		<img class="git-icon mb-3" alt="" src="assets/icones/github.svg">

		<div class="row justify-content-evenly w-100 text-center fs-5">
			<h4 class="text-white fw-normal mb-4">Desenvolvedores</h4>
			<div class="col-2">
				<a class="link-nomes" href="https://github.com/DerickPederzini">Derick
					Pederzini</a>
			</div>

			<div class="col-2">
				<a target="_blank" class="link-nomes"
					href="https://github.com/KinderEnge">Felipe Enge</a>
			</div>

			<div class="col-2">
				<a target="_blank" class="link-nomes"
					href="https://github.com/dev-earaujo">Eduardo Araújo</a>
			</div>

			<div class="col-2">
				<a target="_blank" class="link-nomes"
					href="https://github.com/marcelo-neuro">Marcelo Furlanetto</a>
			</div>

			<div class="col-2">
				<a target="_blank" class="link-nomes"
					href="https://github.com/NicolasVPagliari">Nicolas Pagliari</a>
			</div>
		</div>
	</footer>

</body>

</html>