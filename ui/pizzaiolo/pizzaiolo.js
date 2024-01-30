// pizzaiolo.js

document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/new-order/find-all')
        .then(response => response.json())
        .then(data => {
            data.forEach(order => {
                const accordionItem = document.createElement('div');
                accordionItem.className = 'accordion-item';

                const accordionHeader = document.createElement('h2');
                accordionHeader.className = 'accordion-header';

                const accordionButton = document.createElement('button');
                accordionButton.className = 'accordion-button';
                accordionButton.setAttribute('type', 'button');
                accordionButton.setAttribute('data-bs-toggle', 'collapse');
                accordionButton.setAttribute('data-bs-target', `#collapse${order.id}`);
                accordionButton.setAttribute('aria-expanded', 'true');
                accordionButton.setAttribute('aria-controls', `collapse${order.id}`);
                accordionButton.innerText = `# Commande ${order.orderNumber}`;

                accordionHeader.appendChild(accordionButton);

                const accordionCollapse = document.createElement('div');
                accordionCollapse.id = `collapse${order.id}`;
                accordionCollapse.className = 'accordion-collapse collapse';
                accordionCollapse.setAttribute('data-bs-parent', '#accordionExample');

                const accordionBody = document.createElement('div');
                accordionBody.className = 'accordion-body';

                const orderDetails = document.createElement('ul');
                orderDetails.className = 'list-group';

                const sizeItem = document.createElement('li');
                sizeItem.className = 'list-group-item';
                sizeItem.innerText = `Taille: ${order.size}`;

                const shapeItem = document.createElement('li');
                shapeItem.className = 'list-group-item';
                shapeItem.innerText = `Forme: ${order.shape}`;

                const baseItem = document.createElement('li');
                baseItem.className = 'list-group-item';
                baseItem.innerText = `Bases: ${order.base}`;

                const ingredientsItem = document.createElement('li');
                ingredientsItem.className = 'list-group-item';
                ingredientsItem.innerText = `Ingrédients: ${order.ingredients.join(', ')}`;

                orderDetails.appendChild(sizeItem);
                orderDetails.appendChild(shapeItem);
                orderDetails.appendChild(baseItem);
                orderDetails.appendChild(ingredientsItem);

                const prepButton = document.createElement('button');
                prepButton.className = 'commande_button';
                prepButton.innerText = 'En préparation';

                const readyButton = document.createElement('button');
                readyButton.className = 'pret_button';
                readyButton.innerText = 'Prête';

                accordionBody.appendChild(orderDetails);
                accordionBody.appendChild(prepButton);
                accordionBody.appendChild(readyButton);

                accordionCollapse.appendChild(accordionBody);
                accordionItem.appendChild(accordionHeader);
                accordionItem.appendChild(accordionCollapse);

                document.getElementById('accordionExample').appendChild(accordionItem);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});
