# DolphinHTTP
DolphinHTTP is a webserver designed to be simple and used for development, maybe will be redesigned for production use too.

### Features
- Integrated API to use Java as backend (coming soon)
- Custom API routes using .js files (coming soon)
- Built-in support for MySQL and SQLite (coming soon)
- Built-in HTTP client, Java Socket Server and WebSocket Server (coming soon)

### Requirements
- Java 18 or above
- An internet connection

### How to install and use

1. download it from the [Releases](https://github.com/BreadEaterYT/DolphinHTTP/releases) on GitHub or clone it and compile it with the following command:
~~~bash
mvn install
~~~
2. move the downloaded / compiled jar file to a folder
3. open a terminal and execute the following command:
~~~bash
java -jar DolphinHTTP.jar --port 80
~~~

if you wish to use another port than 80 then use the --port argument, else if you use 80 you can remove it, but you'll need to run it with admin privileges, aka root if you're under linux

### Versions supported
| Version | Phase | Support |    End of Life    |
|:-------:|:-----:|:-------:|:-----------------:|
|  1.0.0  | Alpha |    ✅    | October 12th 2024 |
|  1.1.0  |   -   |    -    |         -         |

Version 1.1.0 coming near October 12th 2024 at 3:30pm

### Notes
SSL/TLS is not currently supported, use in production at your own risks !

### License
This project is licensed under [MIT License](LICENSE)

### Contribution
You can clone this project and do your own version, you just need to credit me in your code or in a README.md

You will be credited if you contribute to the development

WARNING: If something happens because you modified it, I'm not responsible and no support will be provided

### How to contribute
1. Do the modifications you want
2. Send me the source code via mail at [contact@breadeater.fr](mailto:contact@breadeater.fr)
