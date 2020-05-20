Step 1: Create an user for invoke kfp api
SQL> create user palvin default tablespace KLCUX_TS_TX_DATA quota unlimited on KLCUX_TS_TX_DATA identified by *******;
SQL> grant connect,create session,create table,create procedure to palvin;
SQL> exec dbms_java.grant_permission( 'PALVIN', 'SYS:java.net.SocketPermission', 'yourhost:port', 'connect,resolve' );
Step 2: Create java program implement the invocation
$ORACLE_HOME/jdk/bin/javac OraRestApiInvoker.java
Step 3: Load the java class to database
loadjava -user palvin/****** OraRestApiInvoker.class
#dropjava -user palvin/******* OraRestApiInvoker.class
Step 4: Create SP to invoke the java class
CREATE FUNCTION f_java_test(p1 varchar2) RETURN VARCHAR2
AS LANGUAGE JAVA
NAME 'OraRestApiInvoker.requestGet(java.lang.String) return java.lang.String';
