# SpringCMS
## Content Management Application

This application is a content management system built using the Spring Web MVC framework. It allows users to manage articles, authors, and categories.

## Main Features:
- **CRUD Operations**: Facilitates creating, reading, updating, and deleting articles, authors, and categories.
- **Database Integration**: Integrated with a MySQL database to ensure persistent data management.
- **Latest Articles Feature**: Fetches the five most recent articles.

## Models:
- **Article**: Embodies articles with various attributes such as title, author, and content.
  - JSP Files:
    - `add-article.jsp`: Facilitates the addition of new articles.
    - `edit-article.jsp`: Allows users to edit existing articles.
    - `list-articles.jsp`: Displays a list of all articles.
- **Author**: Defines authors with their first and last names.
  - JSP Files:
    - `add-author.jsp`: Facilitates the addition of new authors.
    - `edit-author.jsp`: Allows users to edit existing authors.
    - `list-authors.jsp`: Displays a list of all authors.
- **Category**: Illustrates categories with name and description attributes.
  - JSP Files:
    - `add-category.jsp`: Facilitates the addition of new categories.
    - `edit-category.jsp`: Allows users to edit existing categories.
    - `list-categories.jsp`: Displays a list of all categories.

## DAO (Data Access Objects):
Detailed description of the DAO layer with various methods facilitating data persistence and retrieval. It contains the following DAO classes:
- **ArticleDao**: Manages CRUD operations for the Article entity.
- **AuthorDao**: Manages CRUD operations for the Author entity.
- **CategoryDao**: Manages CRUD operations for the Category entity.

## View Controllers:
These controllers mediate the data flow between the DAO layer and the views represented by Thymeleaf templates.
- **HomePageViewController**: Controls the home page view, displaying the latest articles.
- **ArticleViewController**: Manages views related to articles, including listing, adding, editing, and deleting articles.
- **AuthorViewController**: Manages views related to authors, including listing, adding, editing, and deleting authors.
- **CategoryViewController**: Manages views related to categories, including listing, adding, editing, and deleting categories.

## Converters:
Custom converters that help in converting string type parameters to entity objects:
- **AuthorConverter**: Converts a string ID to an Author object, aiding in resolving author entities from the view to the controller.
- **CategoryConverter**: Converts a string ID to a Category object, aiding in resolving category entities from the view to the controller.

## Technical Details:
- **Java Version**: 11
- **Packaging**: WAR
- **Frameworks & Libraries**:
  - **Spring Web MVC**: 5.3.19
  - **Hibernate**: 5.4.4.Final
  - **JUnit**: 3.8.1 (for testing)
  - **Servlet API**: 4.0.1
  - **Lombok**: 1.18.28 (for simplified getter, setter, and toString methods)
  - **Logback**: 1.2.11 (for logging)
  - **MySQL Connector**: 8.0.17

## Technologies and Tools:
- **Spring Web MVC**: Utilized to create and manage REST endpoints.
- **Hibernate**: Employed for object-relational mapping to facilitate data persistence in a relational database.
- **Java**: The primary programming language used in the application.
- **Maven**: A tool utilized for dependency management and project building.

Ensure to update the version numbers and add any other necessary details pertaining to the technology stack and tools employed in the project.
