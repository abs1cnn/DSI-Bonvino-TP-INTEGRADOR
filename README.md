# TRABAJO PRACTICO INTERADOR
  - MATERIA: DISEÑO DE SISTEMAS DE LA INFORMACION
  - PROPIETARIOS: ARIAS SANTIAGO - BRINGAS MATEO - CANAAN ABIGAIL - CASTRO CRISTIAN - LADUX CARLOS

DESCRIPCION: Producto de software completo y funcional para escritorio. Trabajo integrador de catedra “Diseño de sistemas”.  Partiendo de un enunciado, casos de uso y requerimientos (tanto funcionales, como no funcionales). El grupo desarrollo los diagramas UML correspondientes para el flujo de los procesos.  Scrum y Git.
Programado en Java, usando Intellij IDEA y NetBeans. La lógica del programa fue desarrollada bajo un enfoque MVC (Modelo-Vista-Controlador). .

---
### **Tecnologías Usadas**

| Tecnología  | Descripción                                                             |
|-------------|-------------------------------------------------------------------------|
| **SPREEN BOOT**   | Framework para crear aplicaciones Java, simplificando la configuración y el desarrollo, ideal para microservicios.              |
| **BD SQLITE** | Base de datos ligera y autocontenida, ideal para aplicaciones pequeñas o de desarrollo local.                       |
| **JAVAFX** | Biblioteca de Java para crear interfaces gráficas modernas y dinámicas.     |
| **POSTMAN** | Herramienta para probar y documentar APIs, enviando solicitudes HTTP fácilmente.                     |
| **JDBC ** | API de Java para conectarse y ejecutar consultas SQL directamente en bases de datos.                                    |
| **MAEVEN**  | Herramienta de gestión de proyectos y dependencias en Java, que facilita la construcción y el empaquetado.                  |
| **INTELLIJ IDEA** | Entorno de desarrollo integrado (IDE) para Java y otros lenguajes, desarrollado por JetBrains.           |
| **DBeaver** | Herramienta de gestión de bases de datos universal que permite conectarse, administrar y consultar múltiples sistemas de bases de datos           |

---
![image](https://github.com/user-attachments/assets/53fa9d67-baac-4896-bb74-5c4a37875206)
Consume la api de las bodegas y permite selecionar las que se desean actualizar
![image](https://github.com/user-attachments/assets/b75e0b05-600c-4c52-ab19-57a35d034024)
Notifica a los enofios que siguen las bodegas seleccionadas, quese ha actualizado y pueden ver los cambios
![image](https://github.com/user-attachments/assets/c0a63e22-32f9-4af7-8e03-ee24e41acd07)
Muestra por pantalla los vinos actualizados o creados y que bodegas no se pudo realizar la conexion
![image](https://github.com/user-attachments/assets/87414856-6049-4167-bd99-c79df78855e8)
Consola intellig
![image](https://github.com/user-attachments/assets/b3e5eedb-b637-4d9d-9ef6-d2cb2720106f)

---

DOCUMENTACION
- ENUNCIADO + CASO DE USO
- RQUERIMIENTOS FUNCIONALES Y NO FUNCIONALES
- DIAGRAMA DE CLASES
- DIAGRAMA DE SECUENCIA + PATRON OBSERVER
- DIAGRAMA DE PERSISTENCIA

ARQUITECTURA
- BACKEND CON SPREEN BOOT
- API DE LA QUE SE CONSULE LOS VINOS QUE REQUIEREN ACTUALIZACION O CREACION
- FRONTEND CON REACT

---
### **NOTAS**

### **API DSI**
- MOVERSE A ESA CARPETA DONDE CONTIENE EL PACKAGE.JSON cd ApiDSI (dos veces insertar el comando)
- npm i PARA INTALAR DEPENDENCIAS
- npm audit fix REPARAR VULNERABILIDADES DE VERSIONES (SI ES QUE SE PRESENTA)
- luego npm run, O NPM RUN DEV PARA MODO DESARROLLARO
- QUEDARA CORRIENDO EN EL PUERTO 8080
routes
- http://localhost:8080/Bodega-Los-Andes
- http://localhost:8080/Bodega-1
- http://localhost:8080/Bodega-2

### **EJECUTABLE**
- CORRER DESDE INTELLIJ IDEA. Ejecutable src/main/java/com/company/PantallaAB/PantallaAB.java
