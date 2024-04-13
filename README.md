# Object Proxy

## Structural pattern design

<p>The proposition of this application is to understand the pattern design ObjectProxy.</p>

<p>At the end of the execution of the program and analyzing the log we can see the advantage of use this pattern.</p>

## Architecture

![Architecture diagram.](https://raw.githubusercontent.com/DeyvidGar/assets/master/Proxy.png)

## Description

- If we use the service layer with the object remote directly, we can see that the application have a considerable duration.

> Example of time in milliseconds of completion the simulation to use by the user without Object Proxy:
>> currentTimeNoProxy = 2288

- If we use the service layer with the Object Proxy pattern the application reduce considerably the finalization of a method.

> Example of time in milliseconds of completion the simulation to use by the user with Object Proxy:
>> currentTimeProxy = 1310

<p>This occurs because the use of remote service is only call when the user not yet a petition with remote real service in database.</p>

<p>If the user realize the second petition, the first petition is storage in cache simulation and the call of remote service is skip.</p>

## What i need?

<p>You need to have installed:<p>

- Java 1.8 or >
- Maven.
- Intellij IDE.
- Eclipse or STS IDE.

## What run the application?

### For windows console

<p>We can run the application in console following the next steps:</p>

```console
1. mvn clean install
```

```console
2. mvn compile
```

```console
3. mvn exec:java -Dexec.mainClass="com.midominio.proxy.Proxy"
```

### For Intellij IDE

<p>We can run the application in intellij following the next steps:</p>

```console
1. Find the main class in com.midominio.proxy.Proxy.java
```

```console
2. Right click and Run 'Proxy.main()'
```

### For Eclipse or STS IDE

<p>We can run the application in Eclipse following the next steps:</p>

```console
1. Find in the package explorer this proyect
```

```console
2. Right click and Run as -> java proyect.
```