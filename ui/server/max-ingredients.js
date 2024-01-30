        document.querySelectorAll('.moins').forEach(function (moinsButton) {
            moinsButton.addEventListener('click', function () {
                updateQuantity(this, -1); // Decrease quantity by 1
                validateIngredients();
            });
        });

        document.querySelectorAll('.plus').forEach(function (plusButton) {
            plusButton.addEventListener('click', function () {
                updateQuantity(this, 1); // Increase quantity by 1
                validateIngredients();
            });
        });

        function updateQuantity(button, delta) {
            const ingredientInput = button.parentNode.querySelector('.quantity');
            let quantity = parseInt(ingredientInput.value) + delta;

            // Ensure quantity is within the range [0, 2]
            quantity = Math.max(0, Math.min(2, quantity));

            ingredientInput.value = quantity;
        }

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

                // Check if the quantity is within the range [0, 2]
                if (!isNaN(quantity) && quantity >= 0 && quantity <= 2) {
                    totalIngredients += quantity;
                }
            });

            // Check if the total number of ingredients exceeds 6
            if (totalIngredients > 6) {
                alert('You can select a maximum of 6 ingredients.');
                // Disable the submit button or take other actions to prevent form submission
            }
        }