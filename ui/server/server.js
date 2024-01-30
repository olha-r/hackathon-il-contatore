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

        /**
         * Function to calculate total price for one pizza
         */
        function calculatePizza() {
            let total = 0.00;
            const sizePrice = parseFloat(document.querySelector('input[name="size"]:checked').getAttribute('data-price'));
            const basePrice = parseFloat(document.querySelector('input[name="base"]:checked').getAttribute('data-price'));
            let ingredientsPrice = 0.00;

            document.querySelectorAll('input[name="ingredients"]').forEach(function (ingredientInput) {
                const quantity = parseInt(ingredientInput.value) || 0;
                const pricePerUnit = parseFloat(ingredientInput.getAttribute('data-price')) || 0;
                ingredientsPrice += quantity * pricePerUnit;
            });

             total = (sizePrice + basePrice + ingredientsPrice).toFixed(2);
             return total;
        }
        const price = calculatePizza();

        /**
         * Function to calculate total price for one order
         */
        /*
        function calculateOrder(ordersArray, price){
           console.log(price);
            let orderTotal = 0.00;
            console.log(ordersArray.length);
            console.log(ordersArray);
            for(let i = 0; i < ordersArray.length[-1]; i++){
                orderTotal += price;
                console.log(orderTotal);
            };
            console.log(orderTotal);
            return orderTotal;
            
        }
        const totalPrice = calculateOrder(ordersArray, price);*/

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
            //const priceCard = document.createElement(`p`);
            //priceCard.classList.add('price-card');
           //priceCard.textContent = `Total : ${totalPrice} €`;


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
            <p><strong>Prix:</strong> ${price} €</p>`;

            pizzaCard.appendChild(pizzaDetails);
            const orderCards = document.getElementsByClassName("order-cards")[0];
            orderCards.appendChild(pizzaCard);
            //orderCards.appendChild(priceCard);
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
