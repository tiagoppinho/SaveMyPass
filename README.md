<!-- [![Build Status](https://travis-ci.org/tiagoppinho/SaveMyPass.svg?branch=master)](https://travis-ci.org/tiagoppinho/SaveMyPass) -->

# Password Manager - SaveMyPass

Simple offline password manager initially made for my own use and as an academic project. Developed with Java and NetBeans/Intellij IDEA.

## Features

* Low-weight application with low-weight database (SQLite).
* No internet connection needed.
* Master pin that protects all your information.
* Two security questions in case you forgot your master pin.
* AES-128 data encryption.
* Built-in virtual keyboard (every time you need to enter your master pin or create a new one).
* Built-in password generator.
* Auto-logout after a timer set by the user.
* Change your master pin anytime.
* Notes.
* Delete all database (for emergencies).

## How to use this software

* Download the [latest release](https://github.com/tiagoppinho/PasswordManager/releases/latest).
* Place it where you want and just run it.

## Setup for development

**Install** (Unix, *nix systems):

```
$ ./mvnw clean install
```

or (Batch)

```
$ ./mvnw.cmd clean install
```

**Run** (Unix, *nix systems):

```
$ ./mvnw exec:java
```

or (Batch)

```
$ ./mvnw.cmd exec:java
```

## Icons

All the icons used in this project are provided by icons8.
[Check them out](https://icons8.com).
