# 🏟️ CodeWave - Módulo de Reservas Deportivas

Este proyecto es un módulo funcional para gestionar **reservas de canchas** en centros deportivos comunitarios. Fue desarrollado aplicando buenas prácticas de desarrollo:

- ✅ TDD (Test-Driven Development)
- ✅ Principios SOLID
- ✅ Pruebas unitarias con JUnit 5
- ✅ Simulación de dependencias con Mockito
- ✅ Medición de cobertura con JaCoCo

---

## 👨‍💻 Autor

### Equipo 4 - Proyecto: Módulo Reservas – CodeWave

- Felipe Lobos  
- Fabiola Díaz  
- Eduardo Arellano  
- Carlos Vasquez  

Desarrollado como práctica de TDD y principios de ingeniería de software profesional.

---

## 🔁 Ciclo TDD

### 🔴 Prueba Red

> Comenzamos escribiendo una prueba que falla porque la funcionalidad aún no está implementada.

![Test Red](assets/red.png)

### ✅ Pruebas Exitosas (Green)

> Implementamos el código necesario para que la prueba pase.

![Test Green](assets/green.png)  
![Código Green](assets/CodigoGreen.png)

### ♻️ Refactor

> Refactorizamos el código manteniendo la funcionalidad y las pruebas exitosas.

![Refactor](assets/refactor.png)

---

## 📊 Cobertura de Código (JaCoCo)

> Usamos **JaCoCo** para visualizar y mejorar la cobertura de pruebas.

![Reporte JaCoCo](assets/jacoco.png)

---

## 🧠 Diseño SOLID

Aplicamos los principios SOLID para mantener un diseño limpio, escalable y mantenible:

### ✅ 1. SRP - Single Responsibility Principle  
> Cada clase tiene una única responsabilidad.

![SRP](assets/s.png)

---

### ✅ 2. OCP - Open/Closed Principle  
> Las clases están abiertas a extensión, pero cerradas a modificación.

![OCP](assets/o.png)

---

### ✅ 3. LSP - Liskov Substitution Principle  
> Las clases hijas pueden sustituir a sus padres sin alterar el comportamiento esperado.

![LSP](assets/l.png)  
🧠 Cumple LSP porque puedes reemplazar cualquier implementación sin que el sistema falle.

---

### ✅ 4. ISP - Interface Segregation Principle  
> No se obliga a implementar métodos innecesarios.

![ISP](assets/l.png)  
🧠 Cumple ISP porque solo expone lo necesario para las reservas, sin métodos como `eliminarTodo()` o `reset()`.

---

### ✅ 5. DIP - Dependency Inversion Principle  
> Se depende de abstracciones, no de implementaciones concretas.

![DIP](assets/d.png)  
🧠 Cumple DIP porque `GestorReservas` depende de una interfaz (abstracción), lo que facilita la prueba con Mockito.

---

## 🧪 Pruebas con Mockito

> Se usa Mockito para simular dependencias y probar unidades de forma aislada.

![Uso de Mockito](assets/mock.png)  
📌 **Declaración y uso en test:**


---

## ⚙️ Tecnologías Usadas

| Tecnología | Descripción |
|------------|-------------|
| Java 17 | Lenguaje principal |
| JUnit 5 | Framework de pruebas unitarias |
| Mockito | Librería para mocks en pruebas |
| JaCoCo | Herramienta de cobertura de código |
| Maven | Gestor de dependencias y build |

---

## 🚀 Cómo Ejecutar el Proyecto

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/tuusuario/modulo-reservas.git
   cd modulo-reservas


2. Compila y ejecuta las pruebas con cobertura:
    ```bash    
    mvn clean verify

3. Windows:
    ```bash  
    open target/site/jacoco/index.html

