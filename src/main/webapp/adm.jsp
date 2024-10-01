<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADM RBet</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black">
	<main
		class="container d-flex flex-column justify-content-center align-items-center">
		<h1 class="title-cup mt-2">Administrador de Apostas</h1>

		<form action="criaPartida" method="post"
			class="d-flex flex-column container align-items-center bg-fiap-grey form-usuario p-5 mb-5">
			<h2 class="text-light">Criar nova partida:</h2>
			<div class="d-flex justify-content-around w-100 text-light">
				<h3>RoboA</h3>
				<span></span>
				<h3>RoboB</h3>
			</div>
			<div class="d-flex justify-content-around w-100">
				<div
					class="d-flex flex-column align-items-center justify-content-center">
					<c:forEach items="${robos}" var="roboA">
						<div class="d-flex align-items-center mb-2 container-fluid">
							<div class=" d-flex justify-content-start align-items-start">
								<input class="form-check-input mt-0" type="radio" name="apostaA"
									value="${roboA.id}"
									aria-label="Checkbox for following text input">
							</div>
							<div class=" d-flex justify-content-start align-items-start">
								<label class="ms-2 text-light">${roboA.nome}</label>
							</div>
						</div>
					</c:forEach>
				</div>

				<h1 class="fs-1 title-cup">VS</h1>

				<div class="d-flex flex-column align-items-center">
					<c:forEach items="${robos}" var="roboB">
						<div class="d-flex align-items-center mb-2 container-fluid">
							<div class=" d-flex justify-content-start align-items-start ">
								<input class="form-check-input mt-0" type="radio" name="apostaB"
									value="${roboB.id}" 
									aria-label="Checkbox for following text input">
									
							</div>
							<div class=" d-flex justify-content-start align-items-start">
								<label class="ms-2 text-light">${roboB.nome}</label>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
			<button type="submit"
				class="button-aposta p-2 d-flex align-items-center justify-content-center text-decoration-none">
				Confirmar aposta</button>
		</form>
		
		<form action="criaPartida" method="post"
			class="d-flex flex-column container align-items-center bg-fiap-grey form-usuario p-5 mt-5">
			<h2 class="text-light">Remover partida existente:</h2>
			<div class="d-flex justify-content-around w-100 text-light">
				<h3>RoboA</h3>
				<span></span>
				<h3>RoboB</h3>
			</div>
			<div class="d-flex justify-content-around w-100">
				<div
					class="d-flex flex-column align-items-center justify-content-center">
					<c:forEach items="${robos}" var="roboA">
						<div class="d-flex align-items-center mb-2 container-fluid">
							<div class=" d-flex justify-content-start align-items-start">
								<input class="form-check-input mt-0" type="radio" name="apostaA"
									value="${roboA.id}"
									aria-label="Checkbox for following text input">
							</div>
							<div class=" d-flex justify-content-start align-items-start">
								<label class="ms-2 text-light">${roboA.nome}</label>
							</div>
						</div>
					</c:forEach>
				</div>

				<h1 class="fs-1 title-cup">VS</h1>

				<div class="d-flex flex-column align-items-center">
					<c:forEach items="${robos}" var="roboB">
						<div class="d-flex align-items-center mb-2 container-fluid">
							<div class=" d-flex justify-content-start align-items-start ">
								<input class="form-check-input mt-0" type="radio" name="apostaB"
									value="${roboB.id}" 
									aria-label="Checkbox for following text input">
									
							</div>
							<div class=" d-flex justify-content-start align-items-start">
								<label class="ms-2 text-light">${roboB.nome}</label>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
			<button type="submit"
				class="button-aposta p-2 d-flex align-items-center justify-content-center text-decoration-none">
				Confirmar aposta</button>
		</form>
	</main>
</body>
</html>