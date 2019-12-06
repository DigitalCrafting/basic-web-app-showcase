# basic-web-app

## Motivation

After 6 years of developing web applications I finally decided to created a showcase application which can be used as starter or just as a look up if You find any of my solutions worth using.

## Goal

My goal is to write simple web application using Java (Spring BOOT, Mybatis, Flyway) for backend with H2 as database, and AngularX (8 at the time of writing this) for frontend. 

## Getting started

- DB setup
  - Simply install H2 database, run it, and start a database with parameters specified in **datasource.properties** file in project
- Java
  - Simply build java project, **digitalcrafting-base** first, then **basic-web-app-java**, and start spring boot app
- Angular
  - Run **npm install** from the directory with **package.json** file, and then **ng serve**
- Frontend, server and db connection should connect to each other automatically

## What and why

This is my showcase project, and as such, contains a variety of solutions I've used so far, and lacks some other things which I might add later to make it a fully fledged web application with all sorts of error handling and others bells and whistles commonly found in todays web.

Here are some things I'd like to tell more about:
- For java:
  - Command pattern - in a simple project like that, I wouldn't use it, simply because it would be an obsolete abstraction layer without any advantages. I included it, because this implementation is a nice example of how to leverage Spring capabilities to make your life easier. Each CommandExecutor is registered automatically as a Spring bean and later put into a HashMap with Command assigned to it as a key,
  - AbstractEntityManager - again, in this simple project, this implementation is pretty useless abstraction, in a large project however, it allows for easy cache and versioning implementation,
  - Mapper interface - it is specifically used for Mybatis,
  - HasBasicDbOperations interface - both Mapper and AbstractEntityManager implement it thanks to which, in a simplest case where EntityManager acts as a proxy for Mapper, we don't need to write any additional code other than what's in **MybatisEntityManager**, and event if Mapper doesn't actually has any implementation for one of the methods, exception will be thrown telling us where the problem is,
- For Angular:
  - DynamicComponentManager - it's more flexible than Routing which I tried using in an actual project. What I found out is that Routing is usefull only in a handfull of cases, for a more fine-grained control of behaviour however, manual component creation is irreplaceable.
