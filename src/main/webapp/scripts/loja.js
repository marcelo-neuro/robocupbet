/**
 * 
 */
document.addEventListener("DOMContentLoaded", function() {
	


	console.log("a");
	
	const t = document.querySelectorAll('[id^="form-loja-"]');
	
	
	t.forEach((item) => {
	
		document.getElementById("butao").addEventListener(("click"),function() {
			alert("Item adquirido!")
		})				
		
	})
	
	
});