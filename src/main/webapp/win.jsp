<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Robocup BET</title>
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
					href="/robocupbet/loja">Loja</a></li>
				<li class="nav-item p-3"><a class="nav-link text-white"
					href="/robocupbet/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<main
		class="container d-flex flex-column justify-content-center align-items-center">

		<h1 class="title-cup">Parabéns pela conquista!</h1>
		<h2 class="text-light mb-5"> Escaneie o QRCode abaixo para resgatar a recompensa!</h2>
		<img src="assets/icones/qrcodeRick.png" class="w-50">	
		
		<a href="/robocupbet/loja" class="btn btn-style text-light fw-bold m-3 px-5" >
			Voltar
		</a>

	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>