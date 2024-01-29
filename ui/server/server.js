// script.js
document.addEventListener('DOMContentLoaded', function () {
     const ingredientsArray = [];
    document.querySelector('form').addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        // Get the selected values from checkboxes
        const size = document.querySelector('input[name="size"]:checked').value;
        const base = document.querySelector('input[name="base"]:checked').value;

        // Get the selected type
        const type = document.querySelector('input[name="type"]:checked').value;

       
        document.querySelectorAll('input[name="ingredients"]').forEach(function (ingredientInput) {
            const quantity = ingredientInput.value;
            const name = ingredientInput.id; 

            // Check if the quantity is greater than 0
            if (quantity > 0) {
                const ingredientString = `${name}: ${quantity}`;
                ingredientsArray.push(ingredientString);
            }
        });

        // Get the selected sauce
        const oil = document.getElementById('saucePimentee').checked;
        const price = 10;

        // Create the payload to send to the server
        const payload = {
            size: size,
            base: base,
            shape: type,
            ingredients: ingredientsArray ,
            oil: oil,
            price: price
        };
        console.log("Payload", payload);

        // Make a POST request to the server
        fetch('http://localhost:8080/new-order', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            // Handle successful response (if needed)
            console.log('Order created successfully');
        })
        .catch(error => {
            // Handle errors
            console.error('There was a problem with the fetch operation:', error);
        });
    });
});
