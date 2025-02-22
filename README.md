## `Guía Completa Aplicación Android Compose`

Esta guía explicará cómo crear un proyecto desde cero en Android Studio utilizando Kotlin y Jetpack Compose. Veremos cómo separar el proyecto por capas y qué librerías utilizar en cada uno de los pasos.

## `Configuración Inicial`

Antes de iniciar con el desarrollo, asegúrate de tener instalada la última versión de Android Studio. Abre la aplicación y crea un nuevo proyecto, seleccionando la plantilla vacía de Jetpack Compose. Este será nuestro punto de partida.

Luego de crear el proyecto, es fundamental mantener todas las librerías actualizadas. Para gestionar las dependencias, abre el archivo `build.gradle` (nivel de la aplicación) y añade o actualiza las librerías esenciales.

Una vez añadidas las dependencias, sincroniza el proyecto para descargar e integrar las librerías.

## `Capas del proyecto`

- Framework
- Data
- Domain
- UseCase
- UI
- DI (Dependecy Injection)

### `Framework`
En esta capa incluiremos toda la parte de llamadas a la API utilizando Retrofit. Para el mapeo de datos, utilizaremos KotlinxSerialization. Además, para el almacenamiento en bases de datos locales, emplearemos Room.

### `Data`
La capa de Data contendrá los DataSources, responsables de acceder a la capa de Framework. Aquí tendremos los RemoteDataSource y los LocalDataSource.

### `Domain`
En esta capa se encontrarán los modelos de datos que utilizaremos en la aplicación, así como los Repositorios, que se encargarán de comunicarse con la capa de Data.

### `UseCase`
Los casos de uso de esta capa serán los encargados de comunicarse con la capa de Domain llamando a los repositorios.

### `UI`
En la capa de UI tendremos todas las Screens que serán Composables junto a sus ViewModels. También incluiremos el flujo de Navegación y las temáticas de la aplicación.

### `DI`
Una vez se hayan creado todas las capas, aplicaremos Dagger Hilt para la inyección de dependencias.


## `Enlace a Wiki`
En este enlace podras seguir paso a paso como construir una App desde Cero
https://github.com/aiglesiasp/HarryPotterCompose/wiki
