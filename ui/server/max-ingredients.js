document.querySelectorAll('input[name="ingredients"]').forEach(function (ingredientInput) {
        ingredientInput.addEventListener('input', function () {
            validateIngredients();
        });
    });

    function validateIngredients() {
        // Initialize a variable to track the total number of selected ingredients
        let totalIngredients = 0;

        document.querySelectorAll('input[name="ingredients"]').forEach(function (ingredientInput) {
            const quantity = parseInt(ingredientInput.value);

            // Check if the quantity is greater than 0
            if (!isNaN(quantity) && quantity > 0) {
                totalIngredients += quantity;
            }
        });

        // Check if the total number of ingredients exceeds 6
        if (totalIngredients > 6) {
            alert('You can select a maximum of 6 ingredients.');
            // Disable the submit button or take other actions to prevent form submission
        }
    }
    