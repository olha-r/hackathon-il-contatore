document.addEventListener('DOMContentLoaded', function() {
    const progressBar = document.getElementById('progressBar');
    const progressText = document.getElementById('progressText');

    const messages = [
        "En préparation...",
        "Ajout des garnitures",
        "Sublimation de votre pizza",
        "Actuellement sur le feu de bois",
        "Prête à être dégustée",
    ];

    let totalSteps = (messages.length -1);
    let currentStep = 1;
    const intervalDuration = 3000; // Intervalle entre chaque étape en millisecondes

    function updateProgressBar() {
        const progress = (currentStep / totalSteps) * 100;
        progressBar.style.width = progress + '%';
        progressText.textContent = messages[currentStep];
        
        if (currentStep === 12000) {
            clearInterval(preparationInterval);
        }
        else {
            currentStep++;
        }
    }
    // Lancer la simulation avec setInterval
    const preparationInterval = setInterval(updateProgressBar, intervalDuration);
});
