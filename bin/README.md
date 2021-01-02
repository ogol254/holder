# Devops Project

This webapp allows you to display a list of the 100 best movies of all time.

It works as follows:
- at initialization:
  - it gets the JDBC Datasource via the JNDI resources `jdbc / devopsdblocal`
  - she populates a table with the list of the 100 best films
- when the servlet is called, it returns HTML content.

The only library needed is the servlet library which is normally provided by the application server.

To build the war: `mvn clean package`