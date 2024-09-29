



document.addEventListener("DOMContentLoaded", function() {

    const partidas = document.querySelectorAll('[id-partida]');

    partidas.forEach(partida => {

        const apostaA = partida.querySelector('input[name="betOnA"]');  
        const apostaB = partida.querySelector('input[name="betOnB"]');  

        apostaA.addEventListener('input', function() {
            if (apostaA.value && apostaA.value > 0) {
                apostaB.value = 0;  
                apostaB.disabled = true; 
            } else {
                apostaB.disabled = false;
            }
        });

        // Event listener for Aposta Robo B
        apostaB.addEventListener('input', function() {
            if (apostaB.value && apostaB.value > 0) {
                apostaA.value = 0; 
                apostaA.disabled = true;
            } else {
                apostaA.disabled = false;
            }
        });

    });

});