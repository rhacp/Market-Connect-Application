# Course Project

* Project diagram:
[MCA Diagram](https://trello.com/1/cards/6598430155a589f269538c92/attachments/659853044272c80fdf6bc53c/previews/659853054272c80fdf6bc5b5/download/image.png)

* API Doccumentation (Swagger):
[MCA API Doccumentation]()

* Trello:
[Trello MCA](https://trello.com/b/JFYpH3sy/mk-trello)

MarketConnect is a dynamic web application designed to bridge the gap between customers and a diverse range of products. It serves as a virtual marketplace where multiple customers can interact with, select, and purchase various products offered by different vendors.

# Core Functionalities

### Customer Accounts:

- Users can create personal accounts with details such as name, email, and password.
- Each customer account should have the ability to follow or bookmark favorite products.
- Customers can leave reviews and ratings for products they have purchased.

### Product Catalog:

- A comprehensive listing of products categorized by type, vendor, and price.
- Each product entry includes a description, price, vendor information, and customer reviews.
- Products can be searched and filtered based on various attributes.
- A single product can be purchased by multiple customers.

### Vendor Profiles:

- Vendors can register and create profiles showcasing their company, product range, and special offers.
- They can manage their product listings, track sales, and interact with customers.
- Vendors can analyze customer interest through followers and product engagement metrics.

### Shopping Cart and Checkout System:

- Customers can add multiple products from different vendors to a unified shopping cart.
- The checkout process will handle transactions, including payment processing and order confirmation (TBD).
- A history of purchases and transactions is maintained for customers.

### Push Notification System:

- Notifications for customers about new product launches, special offers, and status updates on their purchases or followed vendors.
- The push notification system can be customized by users to receive alerts for specific categories or events of interest (nice to have).

### AI-Powered Recommendation System

- The application can integrate an AI-powered recommendation engine using OpenAI's capabilities.
- This engine would analyze customer behavior, purchase history, and product preferences to suggest personalized product recommendations.
- It would also leverage natural language processing to understand customer reviews and ratings, enhancing the recommendation's accuracy.
- Vendors could use this feature to target specific customer segments with products that match their historical preferences and search patterns.
- The recommendation system would be capable of learning and evolving over time, refining suggestions to align with changing trends and customer feedback.
- Send this suggestion to the client via email, once a month.

### Prompt to OpenAI

```
"We have a user with the following profile and activity on our marketplace application 'MarketConnect': 

User Profile:

- Name: Alex Doe
- Age: 30
- Interests: Technology, Fitness, Books, Gardening

### Recent Activity:

- Searched for 'smartwatches' and 'fitness trackers'
- Viewed products related to home gardening kits
- Purchased a sci-fi adventure novel last month
- Followed vendors that sell tech gadgets and fitness equipment

Based on this data, what products would you recommend for this user?"

// Expected response from AI
"Based on Alex Doe's interests and recent activity, I would recommend the following products:

- High-tech smartwatches with health-tracking features, suitable for someone interested in both technology and fitness.
- Advanced home gardening kits that come with smart soil sensors, offering a blend of gardening and technology.
- The latest arrivals in sci-fi and adventure novels, especially those that are trending in the tech community.
- Fitness equipment that pairs with smart devices to track performance, catering to the intersection of tech and fitness.
eBooks or audiobooks on gardening techniques for tech-savvy individuals who enjoy blending their hobbies with technology.

Additionally, you might want to alert Alex to upcoming webinars or virtual events focusing on the intersection of technology with fitness and gardening."
```
