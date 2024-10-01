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
				class="button-aposta p-2 d-flex align-items-center justify-content-center w-25 text-decoration-none">
				Confirmar aposta</button>
		</form>

		<div class="d-flex flex-column container align-items-center bg-fiap-grey form-usuario p-5 mt-5">

			<div class="d-flex flex-column align-items-center w-100">
				<c:forEach items="${lutas}" var="luta">
					<form
						class="d-flex form-usuario flex-column justify-content-center align-items-center p-5 mt-5  mb-5 w-100"
						id="luta-${luta[0].id}-${luta[1].id} method="">
						<div class="d-flex w-100 justify-content-between align-items-center">
							<div
								class="d-flex justify-content-center align-items-center w-100">
								<div class="d-flex align-items-center flex-column w-50">
									<h4 class="text-center text-light fs-4">${luta[0].nome}</h4>
								</div>

								<div class="d-flex align-items-center justify-content-center">
									<h5 class="text-center text-light fs-3">VS</h5>
								</div>

								<div class="d-flex align-items-center flex-column w-50">
									<h4 class="text-center text-light fs-4">${luta[1].nome}</h4>
								</div>
							</div>
						</div>


						<button type="submit"
						class="button-aposta p-2 text-decoration-none w-25 mt-5">
						Remover Partida</button>
					</form>
				</c:forEach>
			</div>


		</div>
	</main>
</body>
</html>