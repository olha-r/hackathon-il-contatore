# Hackathon - Il Contatore

Il Contatore stands as the premium pizza counter chain, offering customized, wood-fired pizzas.

The primary focus of this application is to streamline the overall order processing time, from initial entry to customer pickup. Additionally, it aims to enhance the customer experience throughout the entire ordering process, including wait times, by leveraging the use of smartphones.


## Installation

1. **Clone the Project**

   - Use the following command in your CLI (Command Line Interface) to clone the project locally on your machine:

   ```bash
   git clone https://github.com/olha-r/hackathon-il-contatore.git
   ```
   
2. **Import the Project**

   - Import the project in Eclipse (IDE for Enterprise Java and Web Developers)

	File > Open Projects from File System... > choose the directory api-hackaton-il-contatore from the directory of your cloned project

3. **Create Local Database**

   - Return to your CLI in hackathon-il-contatore et change directory in db

 ```bash 
   cd hackathon-il-contatore/db 
   ```

   - Connect to your Database and enter your password

 ```bash 
   psql -U postgres 
   ```

   - Create your database with name `` hackathon24``

 ```bash 
   create database hackathon24;
   ```

  -- Optional : to watch your database, use : \l 

   - Switch to your new table (example : hackathon24) and  import :

 ```bash 
   \c hackathon24; 
   \i schema.ddl.sql;
   ```

   - Anytime you can quit the program with the following command : \q


4. **Add in hackaton-il-contatore/src/main/resources/application.properties**
```
spring.datasource.url=jdbc:postgresql://localhost:5432/ilcontatore_new
spring.datasource.username=postgres
spring.datasource.password=<YOUR-DATABASE-ADMIN-PASSWORD>
```

5. **Run the Project API in Eclipse**
    Right click on the project API 
    > **Run as** > **Spring Boot App**

6. **Run Front**
Open the folder ``ui``  in VsCode
Right click on the index.html 
    > **Open with LiveServer**

The page will be opened in your browser? Choice the page Server to make your order.
Choice the page PIZZAIOLO to see the order pages for Pizzaiolo.


## Usage

1. **Order Entry**
   - The server accesses the Il Contatore application on their touchscreen.
   - The customer chooses how to customize their pizza(s) by selecting size, shape, base, and ingredients.

2. **Order Validation**

   - Add the customized pizza to the initial order.
   - Option to add a new pizza.
   - Verify the order with the client and proceed to validation.
   - After validation, a QR Code is generated on the customer's side, enabling real-time tracking of their order.

3. **Real-time Order Tracking**

   - Countdown of the preparation time.
   - Check the estimated preparation time at any moment.

4. **Order Pickup**

   - Once the order is ready, the server observes the change in the order status to "validated" in their application.
   - The customer retrieves their order at the counter, and the pizzas are ready to be savored.

