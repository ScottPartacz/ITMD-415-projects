<!-- TOC depthFrom:1 depthTo:4 withLinks:1 updateOnSave:1 orderedList:0 -->

- [ITMD415 - Lab 1](#itmd415-lab-1)
	- [Classes](#classes)
		- [HLib](#hlib)
		- [IntHolder](#intholder)
		- [MathClient](#mathclient)
		- [MathE](#mathe)
		- [MathLib](#mathlib)
		- [MathServer](#mathserver)
		- [MathServerThread](#mathserverthread)
		- [Message](#message)
		- [Statement](#statement)
		- [Tests](#tests)
			- [`testClientConnectivity(int n)`](#testclientconnectivityint-n)
			- [`testClientMassUse(int clients, int ops)`](#testclientmassuseint-clients-int-ops)
	- [Suggested Testing](#suggested-testing)

<!-- /TOC -->

# ITMD415 - Lab 1

By Dennis Chase and Henry Post.

## Classes

### HLib
- Helper string functions
- Other helper methods

### IntHolder
- Used to pass integers by reference.

### MathClient
- Acts as the client, running the main will invoke a REPL loop.

### MathE
- Enum that keeps variables used throughout all classes.

### MathLib 
- Create random sets of queries for ease in testing.
- Validate queries and produce numbers

### MathServer
- Running the `main()` will start the server
- Only serves to invoke MathServerThread objects' asynchronous `run()` method

### MathServerThread
- Acts as the go between for MathClient and MathServer aka implements the threading.

### Message
- A wrapper class for synchronous communication between the client and the server.
- Used by the Client's and Server's `Object(In/Out)putStream` variables.

### Statement
- Represents a mathematical statement with two operands and one operation.

### Tests 
- Used for many tests as we made all classes.

#### `testClientConnectivity(int n)`
- Initiate as many clients as wanted and connect them to the server

#### `testClientMassUse(int clients, int ops)`
- Initiate as many clients as wanted and have each client made request as many operations as wanted to the server.

## Suggested Testing

- Method 1:
  - Run MathServer.java
  - Run MathClient.java (Can run as many as wanted)

- Method 2:
  - Run MathServer.java
  - Run Tests.java

Note: Tests is currently set to create 100 Clients and have each client send 50 random operations to the server. This can be changed to any number of clients and operations by simply changing the parameters of `Tests.testClientMassUse(100, 50);` inside the main method of Tests.java
