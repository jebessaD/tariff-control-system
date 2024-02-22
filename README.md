# Tariff Control System
## Introduction
The problem of transportation is common in our country. We dare to say we all face this in our daily life activities, especially those related to tariffs. In one way or another, we see people ruggedly speaking about tariff increases every day. This problem is not just a government problem; it is also a problem with the drivers, especially when the passenger onboard is a stranger. As a group, we have thought and come up with a solution: a software that controls this problem.

## Business Features
This software system is a web application which:

- Will enable a passenger to check the tariff.
- Allows users to create an account, change their profile, and delete their account.
- Allows registered users to report when they face illegal tax increases.
- Allows authorized personnel to check the number of records.
- For persisting the data, we will use MySQL. It will contain:

- A list of stations with their tariffs.
- A list of cities in Ethiopia with their tariffs from Addis Ababa.
- A list of registered users' names and passwords.
- A list of traffic officers' names and IDs.
- We have two interfaces: one for the user to log in and another for traffic officers to log in, so we need both authentication and authorization:

## Authentication:

- The identity of the user has to be verified using a password and email.
- The identity of authorized users, for example, traffic officers, is checked using an identity number (ID) in addition to a password and email.

##Authorization:

- All users of the system have the privilege to check tariffs. In addition, registered users have the privilege to report illegal tariff increase scenarios.
- The system gives permission to authorized users to check drivers' records.
- The system grants permission to authorized users to create, read, update, and delete databases.

#Group Members
- Liban Abduba - UGR/3781/12 - Section 1
- Jebessa Dejene - UGR/0459/12 - Section 1
- Naol Kecha - UGR/6903/12 - Section 1
- Abel Mekonen - UGR/7784/12 - Section 1
- Mestnanat Asfaw - UGR/7631/12 - Section 1
