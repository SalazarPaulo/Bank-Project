# 🏦 Bank Project

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-5382A1?style=for-the-badge)
![FXML](https://img.shields.io/badge/FXML-5C32B7?style=for-the-badge)
![CSS](https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/Status-En%20desarrollo-5C32B7?style=for-the-badge)

**Bank Project** es una aplicación bancaria de escritorio desarrollada en **JavaFX**, con interfaces construidas mediante **FXML**, estilos personalizados con **CSS** y almacenamiento local utilizando **SQLite**. El proyecto esta en la rama master

El proyecto simula un sistema bancario con dos tipos de usuario: **cliente** y **administrador**.  
Desde el lado del cliente se plantea el acceso a un panel bancario con resumen de cuentas, transacciones, envío de dinero y consulta de cuentas. Desde el lado administrativo se plantea la gestión de clientes, creación de cuentas y depósitos.

<p align="center">
  <img src="https://github.com/SalazarPaulo/SalazarPaulo/blob/main/Assets/LoginBank.png?raw=true" width="650px" alt="Bank Project Login"/>
</p>

---

## 📌 Tabla de contenido

- [Descripción](#-descripción)
- [Características principales](#-características-principales)
- [Tecnologías utilizadas](#-tecnologías-utilizadas)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Arquitectura interna](#-arquitectura-interna)
- [Módulos principales](#-módulos-principales)
- [Modelo de datos](#-modelo-de-datos)
- [Base de datos SQLite](#-base-de-datos-sqlite)
- [Flujo de ejecución](#-flujo-de-ejecución)
- [Patrones y conceptos aplicados](#-patrones-y-conceptos-aplicados)
- [Diseño de interfaz](#-diseño-de-interfaz)
- [Cómo ejecutar el proyecto](#-cómo-ejecutar-el-proyecto)
- [Credenciales de prueba](#-credenciales-de-prueba)
- [Estado actual del proyecto](#-estado-actual-del-proyecto)
- [Mejoras futuras](#-mejoras-futuras)
- [Posibles mejoras técnicas](#-posibles-mejoras-técnicas)
- [Autor](#-autor)

---

## 📖 Descripción

Este proyecto consiste en una aplicación bancaria de escritorio desarrollada con **JavaFX**. Su objetivo es simular el funcionamiento básico de una plataforma bancaria, separando la experiencia de usuario en dos perfiles principales:

- **Cliente**
- **Administrador**

El cliente puede iniciar sesión mediante su dirección de pago o `Payee Address` y una contraseña. Una vez validado, accede a una interfaz bancaria donde se visualizan secciones como dashboard, cuentas, transacciones y envío de dinero.

El administrador accede a una interfaz diferente, orientada a tareas de gestión como creación de clientes, visualización de clientes y depósitos.

El proyecto está desarrollado bajo una estructura modular con paquetes separados para:

- Controladores
- Modelos
- Vistas
- Recursos FXML
- Estilos CSS
- Base de datos SQLite

---

## ✨ Características principales

- Interfaz gráfica desarrollada con **JavaFX**.
- Vistas separadas mediante archivos **FXML**.
- Estilos personalizados mediante archivos **CSS**.
- Arquitectura organizada por paquetes.
- Login con selección de tipo de cuenta.
- Soporte para usuario tipo **CLIENT**.
- Soporte visual para usuario tipo **ADMIN**.
- Base de datos local con **SQLite**.
- Modelo de datos para clientes, cuentas y transacciones.
- Separación entre lógica de interfaz, modelo y acceso a datos.
- Uso de propiedades JavaFX como `StringProperty`, `DoubleProperty` y `ObjectProperty`.
- Navegación dinámica entre vistas mediante `BorderPane`.
- Menús laterales para cliente y administrador.
- Uso de `ListView` con celdas personalizadas.
- Carga de interfaces mediante `FXMLLoader`.
- Proyecto gestionado con **Maven**.
- Configuración modular mediante `module-info.java`.

---

## 🛠️ Tecnologías utilizadas

- **Java**
- **JavaFX**
- **FXML**
- **CSS**
- **SQLite**
- **JDBC**
- **Maven**
- **FontAwesomeFX**
- **Scene Builder**
- **IntelliJ IDEA**

---

## 📁 Estructura del proyecto

```text
Bank-Project/
│
├── README.md
│
└── Bank/
    │
    ├── pom.xml
    ├── mvnw
    ├── mvnw.cmd
    ├── mazebank.db
    │
    └── src/
        └── main/
            ├── java/
            │   ├── module-info.java
            │   │
            │   └── com/javafx/demofx/
            │       ├── App.java
            │       │
            │       ├── Controllers/
            │       │   ├── LoginController.java
            │       │   │
            │       │   ├── Admin/
            │       │   │   ├── AdminController.java
            │       │   │   ├── AdminMenuController.java
            │       │   │   ├── ClientCellController.java
            │       │   │   ├── ClientsController.java
            │       │   │   ├── CreateClientController.java
            │       │   │   └── DepositController.java
            │       │   │
            │       │   └── Client/
            │       │       ├── AccountsController.java
            │       │       ├── ClientController.java
            │       │       ├── ClientMenuController.java
            │       │       ├── DashboardController.java
            │       │       ├── TransactionCellController.java
            │       │       └── TransactionsController.java
            │       │
            │       ├── Models/
            │       │   ├── Account.java
            │       │   ├── CheckingAccount.java
            │       │   ├── Client.java
            │       │   ├── DatabaseDriver.java
            │       │   ├── Model.java
            │       │   ├── SavingsAccount.java
            │       │   └── Transaction.java
            │       │
            │       └── Views/
            │           ├── AccountType.java
            │           ├── AdminMenuOptions.java
            │           ├── ClientCellFactory.java
            │           ├── ClientMenuOptions.java
            │           ├── TransactionCellFactory.java
            │           └── ViewFactory.java
            │
            └── resources/
                ├── Fxml/
                │   ├── Login.fxml
                │   │
                │   ├── Admin/
                │   │   ├── Admin.fxml
                │   │   ├── AdminMenu.fxml
                │   │   ├── ClientCell.fxml
                │   │   ├── Clients.fxml
                │   │   ├── CreateClient.fxml
                │   │   └── Deposit.fxml
                │   │
                │   └── Client/
                │       ├── Accounts.fxml
                │       ├── Client.fxml
                │       ├── ClientMenu.fxml
                │       ├── Dashboard.fxml
                │       ├── TransactionCell.fxml
                │       └── Transactions.fxml
                │
                ├── Images/
                │   └── Icon_dollar.png
                │
                └── Styles/
                    ├── Accounts.css
                    ├── ClientCell.css
                    ├── ClientMenu.css
                    ├── Clients.css
                    ├── CreateClient.css
                    ├── Dashboard.css
                    ├── Deposit.css
                    ├── TransactionCell.css
                    ├── Transactions.css
                    └── login.css
```

---

## 🧩 Arquitectura interna

El proyecto sigue una organización inspirada en el patrón **MVC**, separando responsabilidades entre modelos, vistas y controladores.

```text
FXML + CSS
   │
   ▼
Controllers
   │
   ▼
Model
   │
   ▼
DatabaseDriver
   │
   ▼
SQLite Database
```

La aplicación se divide en tres capas principales:

### 1. Capa de vista

Está formada por archivos `.fxml` y `.css`.

Los archivos FXML definen la estructura visual de las pantallas:

- Login
- Dashboard del cliente
- Menú del cliente
- Cuentas
- Transacciones
- Menú administrativo
- Creación de clientes
- Depósitos
- Lista de clientes

Los archivos CSS definen la apariencia visual de cada pantalla.

---

### 2. Capa de controlador

Está formada por las clases ubicadas dentro del paquete `Controllers`.

Los controladores reciben eventos de la interfaz, como clics en botones, selección de opciones y navegación entre pantallas.

Ejemplos:

```java
login_btn.setOnAction(event -> onLogin());
```

```java
dashboard_btn.setOnAction(event -> onDashboard());
transaction_btn.setOnAction(event -> onTransaction());
accounts_btn.setOnAction(event -> onAccounts());
```

---

### 3. Capa de modelo

Está formada por las clases ubicadas en el paquete `Models`.

Esta capa representa los datos del sistema bancario:

- Cliente
- Cuenta
- Cuenta corriente
- Cuenta de ahorro
- Transacción
- Conexión a base de datos
- Estado global de la aplicación

---

## 📦 Módulos principales

### `App.java`

Es el punto de entrada de la aplicación JavaFX.

```java
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
```

La aplicación inicia mostrando la ventana de login mediante `ViewFactory`.

---

### `Model.java`

La clase `Model` funciona como una clase central de estado global.

Implementa una estructura tipo **Singleton**, ya que solo existe una instancia compartida durante toda la ejecución:

```java
public static synchronized Model getInstance() {
    if (model == null) {
        model = new Model();
    }
    return model;
}
```

Esta clase centraliza:

- La instancia de `ViewFactory`.
- La instancia de `DatabaseDriver`.
- El tipo de cuenta seleccionada.
- Los datos del cliente autenticado.
- El estado de autenticación del cliente.

También evalúa las credenciales del cliente:

```java
public void evaluateClientCred(String pAddress, String password) {
    ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
}
```

---

### `ViewFactory.java`

La clase `ViewFactory` se encarga de cargar, construir y mostrar las ventanas de la aplicación.

Sus responsabilidades principales son:

- Mostrar la ventana de login.
- Mostrar la ventana del cliente.
- Mostrar la ventana del administrador.
- Cargar vistas internas del cliente.
- Cargar vistas internas del administrador.
- Administrar la navegación entre pantallas.
- Crear escenarios JavaFX mediante `FXMLLoader`.

Ejemplo de carga de la ventana de login:

```java
public void showLoginWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
    createStage(loader);
}
```

Ejemplo de creación de ventana:

```java
private void createStage(FXMLLoader loader) {
    Scene scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.setTitle("Bank");
    stage.show();
}
```

---

### `DatabaseDriver.java`

Esta clase administra la conexión con la base de datos SQLite.

La conexión se realiza mediante JDBC:

```java
this.conn = DriverManager.getConnection("jdbc:sqlite:mazebank.db");
```

Actualmente, el método principal implementado es la consulta de datos del cliente:

```java
public ResultSet getClientData(String pAddress, String password) {
    resultSet = statement.executeQuery(
        "SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"'AND Password='"+password+"';"
    );
    return resultSet;
}
```

Este método permite validar las credenciales del cliente usando la tabla `Clients`.

---

### `LoginController.java`

Controla la pantalla de inicio de sesión.

Permite seleccionar el tipo de cuenta:

```java
acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
```

Si el usuario selecciona `CLIENT`, se validan las credenciales con la base de datos:

```java
Model.getInstance().evaluateClientCred(payee_address_fid.getText(), password_fid.getText());
```

Si la autenticación es correcta:

```java
Model.getInstance().getViewFactory().closeStage(stage);
Model.getInstance().getViewFactory().showClientWindow();
```

Si las credenciales no existen:

```java
error_lbl.setText("No Such Login Credentials.");
```

Si el usuario selecciona `ADMIN`, se abre la ventana administrativa.

---

### `ClientController.java`

Administra la ventana principal del cliente.

Utiliza un `BorderPane` y cambia el contenido central según la opción seleccionada en el menú:

```java
switch (newValue) {
    case TRANSACTIONS -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
    case ACCOUNTS -> client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
    default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
}
```

---

### `ClientMenuController.java`

Controla el menú lateral del cliente.

Permite navegar entre:

- Dashboard
- Transactions
- Accounts

```java
dashboard_btn.setOnAction(event -> onDashboard());
transaction_btn.setOnAction(event -> onTransaction());
accounts_btn.setOnAction(event -> onAccounts());
```

---

### `AdminController.java`

Administra la ventana principal del administrador.

Cambia el contenido central según la opción seleccionada:

```java
switch (newValue) {
    case CLIENTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsViews());
    case DEPOSIT -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDepositView());
    default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
}
```

---

### `AdminMenuController.java`

Controla el menú lateral del administrador.

Permite cambiar entre:

- Crear cliente
- Ver clientes
- Depósitos

```java
create_client_btn.setOnAction(event -> onCreateClient());
clients_btn.setOnAction(event -> onClients());
deposit_btn.setOnAction(event -> onDeposit());
```

---

## 🧮 Modelo de datos

El proyecto utiliza clases de modelo para representar las entidades principales del sistema bancario.

---

### `Account.java`

Representa una cuenta bancaria general.

Atributos principales:

```java
private final StringProperty owner;
private final StringProperty accountNumber;
private final DoubleProperty balance;
```

Esta clase usa propiedades JavaFX para facilitar la vinculación de datos con la interfaz.

---

### `CheckingAccount.java`

Representa una cuenta corriente.

Hereda de `Account` y agrega un límite de transacciones:

```java
private final IntegerProperty transactionLimit;
```

Esto permite modelar una cuenta con restricciones operativas por día.

---

### `SavingsAccount.java`

Representa una cuenta de ahorros.

Hereda de `Account` y agrega un límite de retiro:

```java
private final DoubleProperty withdrawalLimit;
```

Esto permite diferenciar el comportamiento de una cuenta de ahorro frente a una cuenta corriente.

---

### `Client.java`

Representa a un cliente del banco.

Atributos principales:

```java
private final StringProperty firstName;
private final StringProperty lastName;
private final StringProperty payeeAddress;
private final ObjectProperty<Account> checkingAccount;
private final ObjectProperty<Account> savingAccount;
private final ObjectProperty<LocalDate> dateCreated;
```

El cliente puede tener una cuenta corriente y una cuenta de ahorro.

---

### `Transaction.java`

Representa una transacción bancaria.

Atributos principales:

```java
private final StringProperty sender;
private final StringProperty receiver;
private final DoubleProperty amount;
private final ObjectProperty<LocalDate> date;
private final StringProperty message;
```

Permite modelar transferencias entre usuarios, incluyendo emisor, receptor, monto, fecha y mensaje opcional.

---

## 🗄️ Base de datos SQLite

El proyecto incluye una base de datos local llamada:

```text
mazebank.db
```

La base de datos contiene tablas relacionadas con clientes, cuentas, administradores y transacciones.

Tablas principales:

| Tabla | Descripción |
|------|-------------|
| `Clients` | Almacena los datos de los clientes. |
| `Admins` | Almacena usuarios administrativos. |
| `CheckingAccounts` | Almacena cuentas corrientes. |
| `SavingsAccounts` | Almacena cuentas de ahorro. |
| `Transactions` | Almacena transacciones entre usuarios. |

---

### Tabla `Clients`

Campos principales:

```text
ID
FirstName
LastName
PayeeAddress
Password
Date
```

Esta tabla se usa para validar el login del cliente.

---

### Tabla `Admins`

Campos principales:

```text
ID
Username
Password
```

Contiene credenciales administrativas de prueba.

---

### Tabla `CheckingAccounts`

Campos principales:

```text
ID
Owner
AccountNumber
TransactionLimit
Balance
```

Representa las cuentas corrientes asociadas a clientes.

---

### Tabla `SavingsAccounts`

Campos principales:

```text
ID
Owner
AccountNumber
WithdrawalLimit
Balance
```

Representa las cuentas de ahorro asociadas a clientes.

---

### Tabla `Transactions`

Campos principales:

```text
ID
Sender
Receiver
Amount
Date
Message
```

Representa movimientos o transferencias entre cuentas.

---

## 🔄 Flujo de ejecución

El flujo general de la aplicación es el siguiente:

```text
App.java
   │
   ▼
Model.getInstance()
   │
   ▼
ViewFactory.showLoginWindow()
   │
   ▼
Login.fxml + LoginController
   │
   ├── Si el usuario es CLIENT:
   │       ├── DatabaseDriver consulta SQLite
   │       ├── Model carga datos del cliente
   │       └── ViewFactory.showClientWindow()
   │
   └── Si el usuario es ADMIN:
           └── ViewFactory.showAdminWindow()
```

---

## 🧭 Flujo del cliente

```text
Login
  │
  ▼
Client Window
  │
  ├── Dashboard
  ├── Transactions
  └── Accounts
```

El cliente puede navegar mediante un menú lateral.  
Cada opción cambia el contenido central del `BorderPane`.

---

## 🧭 Flujo del administrador

```text
Login
  │
  ▼
Admin Window
  │
  ├── Create Client
  ├── Clients
  └── Deposit
```

El administrador puede navegar entre vistas administrativas mediante su menú lateral.

---

## 🎨 Diseño de interfaz

La interfaz está construida usando archivos FXML separados por módulo.

Ejemplos:

```text
Login.fxml
Dashboard.fxml
Accounts.fxml
Transactions.fxml
Admin.fxml
CreateClient.fxml
Deposit.fxml
```

Los estilos están separados en archivos CSS:

```text
login.css
Dashboard.css
Accounts.css
ClientMenu.css
CreateClient.css
Deposit.css
Transactions.css
```

Esta separación permite modificar el diseño visual sin alterar directamente la lógica Java.

---

---

## 🖼️ Capturas del sistema

Las siguientes capturas muestran las pantallas principales del sistema bancario. Se utilizan rutas `raw.githubusercontent.com` apuntando a la rama `master`, de forma que las imágenes puedan visualizarse correctamente aunque el README se edite desde otra rama.

### Login

<p align="center">
  <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/Bank/login.png" width="650px" alt="Login Bank Project"/>
</p>

La pantalla de login permite seleccionar el tipo de usuario, ingresar credenciales y acceder al sistema como cliente o administrador.

---

### Dashboard del cliente

<p align="center">
  <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/dashboard.png" width="650px" alt="Dashboard Bank Project"/>
</p>

El dashboard presenta una vista general del sistema bancario, mostrando información relevante del cliente y accesos principales a las funciones disponibles.

---

### Cuentas bancarias

<p align="center">
  <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/accounts.png" width="650px" alt="Accounts Bank Project"/>
</p>

La vista de cuentas permite representar la información bancaria asociada al cliente, como cuentas corrientes, cuentas de ahorro y balances.

---

### Creación de cliente

<p align="center">
  <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/CreateClient.png" width="650px" alt="Create Client Bank Project"/>
</p>

La vista administrativa de creación de cliente está orientada al registro de nuevos usuarios dentro del sistema bancario.

---

### Vista compacta de pantallas

| Login | Dashboard |
|------|-----------|
| <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/Bank/login.png" width="420px" alt="Login Bank Project"/> | <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/dashboard.png" width="420px" alt="Dashboard Bank Project"/> |

| Cuentas | Crear cliente |
|---------|---------------|
| <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/accounts.png" width="420px" alt="Accounts Bank Project"/> | <img src="https://raw.githubusercontent.com/SalazarPaulo/Bank-Project/master/CreateClient.png" width="420px" alt="Create Client Bank Project"/> |

---

## 🧠 Patrones y conceptos aplicados

Este proyecto aplica varios conceptos importantes de desarrollo de software:

- Programación orientada a objetos.
- Separación de responsabilidades.
- Patrón Singleton en `Model`.
- Organización tipo MVC.
- Navegación dinámica con JavaFX.
- Uso de `FXMLLoader`.
- Uso de `BorderPane` para cambiar vistas internas.
- Uso de propiedades JavaFX.
- Conexión a base de datos mediante JDBC.
- Persistencia local con SQLite.
- Uso de Maven para dependencias.
- Modularización con `module-info.java`.
- Estilización con CSS.
- Uso de enums para controlar opciones de menú.

---

## 📦 Dependencias principales

El proyecto utiliza Maven para gestionar dependencias.

Dependencias principales:

```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>19-ea+7</version>
</dependency>

<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>19-ea+7</version>
</dependency>

<dependency>
    <groupId>de.jensd</groupId>
    <artifactId>fontawesomefx-fontawesome</artifactId>
    <version>4.7.0-9.1.2</version>
</dependency>

<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.40.0.0</version>
</dependency>
```

---

## ▶️ Cómo ejecutar el proyecto

El código ejecutable se encuentra dentro de la carpeta:

```text
Bank/
```

Por eso, antes de ejecutar el proyecto desde terminal, debes entrar a esa carpeta.

---

### Opción 1: Ejecutar desde IntelliJ IDEA

1. Clona el repositorio:

```bash
git clone https://github.com/SalazarPaulo/Bank-Project.git
```

2. Abre IntelliJ IDEA.

3. Selecciona la carpeta:

```text
Bank-Project/Bank
```

4. Espera a que IntelliJ cargue el proyecto Maven.

5. Verifica que tengas un JDK compatible.

6. Ejecuta la clase:

```text
src/main/java/com/javafx/demofx/App.java
```

---

### Opción 2: Ejecutar con Maven Wrapper en Windows

Desde la raíz del repositorio:

```powershell
cd Bank
.\mvnw.cmd clean javafx:run
```

---

### Opción 3: Ejecutar con Maven Wrapper en Linux/macOS

Desde la raíz del repositorio:

```bash
cd Bank
./mvnw clean javafx:run
```

Si el archivo `mvnw` no tiene permisos de ejecución:

```bash
chmod +x mvnw
./mvnw clean javafx:run
```

---

### Opción 4: Ejecutar con Maven instalado

Desde la carpeta `Bank`:

```bash
mvn clean javafx:run
```

---

## 🔐 Credenciales de prueba

La base de datos incluida contiene usuarios de prueba.

### Cliente de prueba

```text
Payee Address: @bBaker1
Password: 123456
```

### Administrador de prueba

```text
Username: Admin
Password: 123456
```

---

## 📌 Estado actual del proyecto

El proyecto se encuentra en desarrollo.

Actualmente incluye:

- Estructura JavaFX funcional.
- Pantalla de login.
- Selección entre cliente y administrador.
- Validación básica de cliente contra SQLite.
- Vistas FXML para cliente y administrador.
- Menús laterales para navegación.
- Modelos para cuentas, clientes y transacciones.
- Base de datos SQLite con datos de prueba.
- Estilos CSS personalizados.

Algunas funcionalidades visuales ya están diseñadas, pero todavía pueden requerir implementación completa en los controladores, como:

- Registro completo de nuevos clientes.
- Depósitos reales en base de datos.
- Transferencias entre usuarios.
- Visualización dinámica de transacciones.
- Carga completa de cuentas del cliente autenticado.
- Validación real de administrador.

---

## 🚧 Mejoras futuras

Algunas mejoras que se pueden implementar son:

- Implementar validación completa del administrador.
- Agregar CRUD completo de clientes.
- Implementar creación real de cuentas en SQLite.
- Implementar depósitos reales.
- Implementar transferencias entre clientes.
- Actualizar saldos después de cada transacción.
- Mostrar historial dinámico de transacciones.
- Mostrar datos reales en el dashboard.
- Agregar pantalla de perfil del cliente.
- Agregar cierre de sesión funcional.
- Agregar validaciones de formularios.
- Agregar alertas o mensajes de confirmación.
- Agregar pruebas unitarias.
- Crear empaquetado ejecutable.
- Migrar o integrar una futura versión con Spring Boot.
- Implementar autenticación más segura.

---

## 🔍 Posibles mejoras técnicas

Además de las mejoras funcionales, se pueden mejorar algunos aspectos internos del código:

- Usar `PreparedStatement` en lugar de concatenar valores directamente en SQL.
- Evitar guardar contraseñas en texto plano.
- Implementar hashing de contraseñas.
- Separar mejor la lógica de base de datos por repositorios o DAOs.
- Agregar una capa de servicios entre controladores y base de datos.
- Cerrar correctamente conexiones, statements y result sets.
- Corregir rutas FXML sensibles a mayúsculas/minúsculas.
- Revisar rutas como `/FXML/Client/Transactions.fxml` frente a `/Fxml/Client/Transactions.fxml`.
- Implementar validación para campos numéricos.
- Manejar errores con mensajes amigables para el usuario.
- Agregar archivos de configuración para la ruta de la base de datos.
- Evitar depender de una base SQLite fija en la raíz del proyecto.
- Agregar logs para depuración.
- Aplicar patrón DAO o Repository.
- Agregar pruebas con JUnit.

---

## 🧪 Ejemplo de flujo de login de cliente

1. El usuario abre la aplicación.
2. Se muestra `Login.fxml`.
3. El usuario selecciona `CLIENT`.
4. Ingresa su `Payee Address`.
5. Ingresa su contraseña.
6. `LoginController` envía los datos a `Model`.
7. `Model` consulta la base de datos mediante `DatabaseDriver`.
8. Si las credenciales existen, se carga la información del cliente.
9. Se cierra la ventana de login.
10. Se abre la ventana principal del cliente.

Representación simplificada:

```text
LoginController
   │
   ▼
Model.evaluateClientCred()
   │
   ▼
DatabaseDriver.getClientData()
   │
   ▼
SQLite: Clients
   │
   ▼
Client Window
```

---

## 🧪 Ejemplo de navegación del cliente

Cuando el cliente presiona una opción del menú lateral:

```java
dashboard_btn.setOnAction(event -> onDashboard());
transaction_btn.setOnAction(event -> onTransaction());
accounts_btn.setOnAction(event -> onAccounts());
```

Se actualiza la opción seleccionada:

```java
Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
```

Luego `ClientController` detecta el cambio y actualiza el centro del `BorderPane`:

```java
client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
```

---

## 🧪 Ejemplo de navegación del administrador

El administrador tiene un flujo similar:

```java
create_client_btn.setOnAction(event -> onCreateClient());
clients_btn.setOnAction(event -> onClients());
deposit_btn.setOnAction(event -> onDeposit());
```

Cuando cambia la opción seleccionada, `AdminController` actualiza la vista central:

```java
admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
```

---

## 👨‍💻 Autor

**Paulo Salazar**

- GitHub: [@SalazarPaulo](https://github.com/SalazarPaulo)
- Repositorio: [Bank-Project](https://github.com/SalazarPaulo/Bank-Project)

---

## 📄 Licencia

Este proyecto fue desarrollado con fines de aprendizaje y práctica.  

---

## 📌 Estado del proyecto

Proyecto personal en desarrollo, creado con fines de aprendizaje en JavaFX, interfaces gráficas, FXML, CSS, SQLite, JDBC, Maven y arquitectura básica de aplicaciones de escritorio.
