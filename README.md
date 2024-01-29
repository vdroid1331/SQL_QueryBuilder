# Assignment: Implement a Custom Query Builder

## Background

In many applications, especially those involving databases, constructing complex queries dynamically is a common requirement. Your task is to implement a Query Builder class for a SQL-like database using the Builder pattern. This Query Builder should be flexible enough to handle various types of queries with different selections, conditions, joins, and other SQL features.

## Requirements

        1.        Basic Query Structure:
        •        The Query Builder should at least support SELECT, FROM, WHERE, JOIN (INNER and LEFT), ORDER BY, and GROUP BY clauses.
        •        It should allow chaining methods in any order to build the query.
        2.        Type Safety and Validation:
        •        Include validation to ensure that essential parts of the query (like SELECT and FROM) are present.
        •        If a part of the query is missing or invalid (e.g., ordering by a column not in select), the builder should throw an error or handle it gracefully.
        3.        Flexibility:
        •        The builder should be flexible enough to allow for different kinds of inputs (e.g., multiple columns in select, various conditions in where).
        4.        Immutability:
        •        Ensure that once a query is built, it cannot be modified.
        5.        Test Cases:
        •        Write test cases demonstrating the use of the Query Builder for different scenarios (e.g., a simple query, a complex query with joins and aggregations).
        6.        Documentation:
        •        Document the usage of your Query Builder with examples.
        7.        Bonus - Fluent API:
        •        Implement the builder with a fluent API style, allowing calls to be chained in a readable manner.


## My Implementation:
- Have created interfaces with SQLSelectQuery, SQLUpdateQuery and SQLDeleteQuery, SQLCreateQuery, SQLInserQuery and SQLDropQuery.
- GenericSelectQuery, GenericUpdateQuery GenericDeleteQuery, GenericCreateQuery, GenericInsertQuery and GenericDropQuery classes implement SQLSelectQuery, SQLUpdateQuery, SQLDeleteQuery, SQLCreateQuery, SQLInsertQuery and SQLDropQuery Respectively.
- Each of these GenericQuery classes further are extended by a PostgreSQL and MySQL Query classes for each type of query.
- There is a DB class that takes in database type and return a database object that has query object for that database type for each of the types of query and the db object can be used to build SQL queries for the selected database.

## Usage

if you use the following code
```java
DB pgsql = new DB("PGSQL");

System.out.println(pgsql.createQuery.create("users").addIntField("age").addVariableCharField("name", 20).build());
System.out.println(pgsql.insertQuery.insert("users").insertFields("(name, age)").insertValues("('Vinayak', '22')").build());
System.out.println(pgsql.selectQuery.select(new String[]{"user.name", "courses.title"})
                .from("user")
                .where("age > 10")
                .orderBy("name")
                .groupBy("user.name")
                .joinOn("courses", "id", "user_id").build());
System.out.println(pgsql.selectQuery.select(new String[]{"user.name", "courses.title"})
                .from("user")
                .orderBy("name")
                .groupBy("user.name")
                .joinOn("courses", "id", "user_id").build());
System.out.println(pgsql.selectQuery.select(new String[]{"user.name", "courses.title"})
                .from("user")
                .where("age < 10")
                .orderBy("name")
                .groupBy("user.name")
                .leftJoinOn("courses", "id", "user_id").build());

System.out.println(pgsql.updateQuery.update("users").set("name='VINAYAK'").where("name='Vinayak'").build());
System.out.println(pgsql.deleteQuery.delete("users").where("name='VINAYAK'").build());
System.out.println(pgsql.dropQuery.dropTable().drop("users").build());
```
you'll get the following output
```
Initializing PostgreSQL database
CREATE TABLE users (
	id SERIAL PRIMARY KEY,
    age INT,
    name VARCHAR(20),
);
INSERT INTO users (name, age) VALUES ('Vinayak', '22');
SELECT user.name, courses.title FROM user JOIN courses ON user.id = courses.user_id WHERE age > 10 GROUP BY user.name ORDER BY name;
SELECT user.name, courses.title FROM user JOIN courses ON user.id = courses.user_id GROUP BY user.name ORDER BY name;
SELECT user.name, courses.title FROM user LEFT JOIN courses ON user.id = courses.user_id WHERE age < 10 GROUP BY user.name ORDER BY name;
UPDATE users SET name='VINAYAK' WHERE name='Vinayak';
DELETE FROM users WHERE name='VINAYAK';
DROP TABLE users;
```