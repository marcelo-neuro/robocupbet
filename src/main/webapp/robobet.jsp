<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RobocupBet</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black">
	<main class="container d-flex flex-column justify-content-center align-items-center">

		<h1 class="text-light mt-4">
			<span class="title-cup">ROBOCUP</span> BET
		</h1>

		<div
			class="position-loja form-usuario mt-5 me-5 d-flex flex-column align-items-center">
			<p class="px-5 text-center text-light mt-2">FIAPoints: 1000</p>
			<a href="/robocupbet/loja.jsp"
				class="btn btn-style w-75 text-light fw-bold m-2"> Loja </a>
		</div>

		<c:forEach var="partida" items="${partidas}">
			<div class="d-flex flex-column form-usuario justify-content-center align-items-center p-5 w-50 mt-5 mb-5 bg-fiap-grey">
				<div class="d-flex flex-row justify-content-center align-items-center w-100">
					<div class="d-flex align-items-center flex-column w-50">
						<h3 class="text-center text-light fs-3">${partida.equipeA.robo.nome}</h3>
						<img src="${partida.equipeA.robo.urlFoto}" class="img-robos img-fluid rounded">
						<input type="text" class="form-control w-50 mt-4 mb-4" placeholder="$00.00">
						<a class="btn w-75 text-light fw-bold mb-2"
							 href=<c:url value="IntegrantesServlet">
						 		<c:param name="equipeId" value="${partida.equipeA.id}"/>						 	
						  </c:url> >Ver equipe
						</a>
					</div>
					<div class="d-flex align-items-center justify-content-center">
						<h4 class="text-center text-light fs-1">VS</h4>
					</div>
					<div class="d-flex align-items-center flex-column w-50">
						<h3 class="text-center text-light fs-3">${partida.equipeB.robo.nome}</h3>
						<img src="${partida.equipeB.robo.urlFoto}" class="img-robos img-fluid rounded">
						<input type="text" class="form-control w-50 mt-4 mb-4" placeholder="$00.00">
						<a class="btn w-75 text-light fw-bold mb-2"
						 href=<c:url value="IntegrantesServlet">
						 	<c:param name="equipeId" value="${partida.equipeB.id}"/>						 	
						  </c:url> >Ver equipe
						 </a>
					</div>
				</div>
				<div>
					<button class="button-aposta">Confirmar aposta</button>
				</div>
			</div>
		</c:forEach>
		


		<div
			class="d-flex flex-column form-usuario justify-content-center align-items-center p-5 w-50 mt-5 mb-5 bg-fiap-grey">
			<div
				class="d-flex flex-row justify-content-center align-items-center w-100">
				<div class="d-flex align-items-center flex-column w-50">
					<h3 class="text-center text-light fs-3">Robô Scooby</h3>
					<img src="assets/imagens/scooby.png"
						class="img-robos img-fluid rounded"><input type="text"
						class="form-control w-50 mt-4 mb-4" id="exampleInputNome1"
						placeholder="$00.00"> <a
						class="btn w-75 text-light fw-bold mb-2"
						href="http://localhost:8080/robocupbet/integrantes.jsp"> Ver
						Equipe </a>
				</div>
				<div class="d-flex align-items-center justify-content-center">
					<h4 class="text-center text-light fs-1">VS</h4>
				</div>

				<div class="d-flex flex-column align-items-center w-50">
					<h3 class="text-center text-light fs-3">Robô Nintendo</h3>
					<img src="assets/imagens/nintendinho.png"
						class="img-robos img-fluid rounded"> <input type="text"
						class="form-control w-50 mt-4 mb-4" id="exampleInputNome1"
						placeholder="$00.00"> <a
						class="btn w-75 text-light fw-bold mb-2"
						href="http://localhost:8080/robocupbet/integrantes.jsp"> Ver
						Equipe </a>
				</div>
			</div>

			<div>
				<button class="button-aposta">Confirmar aposta</button>
			</div>
		</div>

	</main>
</body>
</html>