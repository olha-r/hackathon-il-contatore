document.addEventListener('DOMContentLoaded', function () {
    const ordersArray = [];
    const ingredientsArray = [];

    // Initialize variables for the Roman alphabet letters
    const ROMAN_LETTERS = createRomanAlphabetList();
    let currentIndex = 0;

    // Function to create an array of Roman alphabet letters
    function createRomanAlphabetList() {
        const alphabet = [];
        for (let letter = 'A'.charCodeAt(0); letter <= 'Z'.charCodeAt(0); letter++) {
            alphabet.push(String.fromCharCode(letter));
        }
        return alphabet;
    }

    // Function to get the next Roman alphabet letter
    function getNextRomanLetter() {
        const nextLetter = ROMAN_LETTERS[currentIndex];
        currentIndex = (currentIndex + 1) % 26; // Reset to 0 if end is reached
        return nextLetter;
    }

    // Function to generate the commandeNumber with only letters
    function generateCommandeNumber() {
        return getNextRomanLetter();
    }
    function createOrder(payload) {
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
                console.log('Order created successfully');
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
            
    }

    function resetFormAndShowCard() {
        const size = document.querySelector('input[name="size"]:checked').value;
        const base = document.querySelector('input[name="base"]:checked').value;
        const type = document.querySelector('input[name="type"]:checked').value;

        ingredientsArray.length = 0;

        document.querySelectorAll('input[name="ingredients"]').forEach(function (ingredientInput) {
            const quantity = ingredientInput.value;
            const name = ingredientInput.id;

            if (quantity > 0) {
                const ingredientString = `${name}: ${quantity}`;
                ingredientsArray.push(ingredientString);
            }
        });

        const oil = document.getElementById('saucePimentee').checked;
        const price = 10;

        const orderNumber = generateCommandeNumber();
            const orderPayload = {
            size: size,
            base: base,
            shape: type,
            ingredients: ingredientsArray,
            oil: oil,
            price: price,
            orderNumber: orderNumber,
        };

        // Store the order payload in the array
        ordersArray.push(orderPayload);
        
        const pizzaCard = document.createElement('div');
        pizzaCard.classList.add('pizza-card');

        // Display the orderNumber at the top of the card
        const orderNumberElement = document.createElement('p');
        orderNumberElement.classList.add('order-number');
        orderNumberElement.textContent = `Commande #${orderNumber}`;
        pizzaCard.appendChild(orderNumberElement);

        const pizzaDetails = document.createElement('div');
        pizzaDetails.classList.add('pizza-details');

        pizzaDetails.innerHTML = `
            <p><strong>Taille:</strong> ${size}</p>
            <p><strong>Base:</strong> ${base}</p>
            <p><strong>Type:</strong> ${type}</p>
            <p><strong>Ingrédients:</strong> ${ingredientsArray.join(', ')}</p>
            <p><strong>Sauce pimentée:</strong> ${oil ? 'Oui' : 'Non'}</p>
            <p><strong>Prix:</strong> ${price} €</p>
        `;

        pizzaCard.appendChild(pizzaDetails);
const orderCards = document.getElementsByClassName("order-cards")[0];
        orderCards.appendChild(pizzaCard);

        const removeButton = document.createElement('button');
        console.log(ordersArray);
    removeButton.textContent = 'Remove Pizza';
    removeButton.addEventListener('click', function () {
        // Remove the card from the DOM
        pizzaCard.remove();

        // Find and remove the corresponding payload from ordersArray
        const indexToRemove = ordersArray.findIndex(order => order.orderNumber === orderNumber);
        if (indexToRemove !== -1) {
            ordersArray.splice(indexToRemove, 1);
        }
        console.log(ordersArray);
    });
const updateButton = document.createElement('button');
    updateButton.textContent = 'Update Pizza';
    updateButton.addEventListener('click', function () {
        // Populate the form with values from the card
        document.querySelector('input[name="size"][value="' + size.trim() + '"]').checked = true;
document.querySelector('input[name="base"][value="' + base.trim() + '"]').checked = true;
document.querySelector('input[name="type"][value="' + type.trim() + '"]').checked = true;


        // Populate ingredients in the form
        ingredientsArray.forEach(ingredientString => {
    const [name, quantity] = ingredientString.split(':');
    const ingredientInput = document.getElementById(name.trim());
    if (ingredientInput) {
        ingredientInput.value = quantity.trim();
    }
});

        // Set the saucePimentee checkbox
        document.getElementById('saucePimentee').checked = oil;

        // Remove the card from the DOM
        pizzaCard.remove();

        // Find and remove the corresponding payload from ordersArray
        const indexToRemove = ordersArray.findIndex(order => order.orderNumber === orderNumber);
        if (indexToRemove !== -1) {
            ordersArray.splice(indexToRemove, 1);
        }
    });

    pizzaCard.appendChild(removeButton);
    pizzaCard.appendChild(updateButton);
    }
    document.getElementById('newPizza').addEventListener('click', function (event) {
        event.preventDefault();
        resetFormAndShowCard();
        document.querySelector('form').reset();
    });
    document.querySelector('#submit').addEventListener('click', function (event) {
                event.preventDefault();
                ordersArray.forEach(order => {
                    createOrder(order);
                });
                const orderCardsContainer = document.getElementsByClassName("order-cards")[0];
                orderCardsContainer.innerHTML = "";
                ordersArray.length = 0;
            });


});
