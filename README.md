Monitor de Hardware y Prueba de Estrés de CPU

Una sencilla aplicación de escritorio Java (Swing) que muestra información clave del hardware del sistema y ejecuta una prueba de estrés para comparar visualmente el rendimiento del procesamiento en serie (un solo núcleo) vs. en paralelo (multi-núcleo).

Características

Monitor de Hardware: Muestra información detallada del sistema obtenida a través de la biblioteca OSHI:

CPU: Nombre del procesador, núcleos físicos, hilos lógicos, frecuencia base y microarquitectura.

RAM: Cantidad total de memoria (en GB).

Placa Madre: Fabricante y modelo.

GPU: Nombre de la tarjeta gráfica y cantidad de VRAM (en GB).
<img width="652" height="298" alt="Captura de pantalla 2025-11-12 203949" src="https://github.com/user-attachments/assets/abaa22cd-9660-4a72-b209-29749c196b07" />


Prueba de Estrés (Stress Test):

Ejecuta un cálculo matemático intensivo (cálculo de 5 mil millones de raíces cuadradas) para medir el rendimiento del procesador.

Modo Serie: Ejecuta la tarea usando un solo hilo, simulando una carga de trabajo secuencial.

Modo Paralelo: Divide la tarea entre todos los hilos (núcleos lógicos) disponibles en la CPU para una ejecución concurrente.

Visualización de Resultados:

Muestra los tiempos de ejecución de ambas pruebas en minutos.

Genera un gráfico de barras simple (rojo para serie, verde para paralelo) que compara visualmente la drástica diferencia de rendimiento.

<img width="629" height="340" alt="Captura de pantalla 2025-11-12 204036" src="https://github.com/user-attachments/assets/7ea97ddd-4d84-4ce2-a798-10f195a175a7" />

Tecnologías Utilizadas

Java 17

Java Swing (para la interfaz gráfica)

Maven (para la gestión de dependencias)

OSHI (oshi-core 6.6.1) (para obtener la información del hardware)

Cómo Ejecutar

Este es un proyecto Maven estándar.

Clona el repositorio:

git clone [https://github.com/CarlosAlbertoGR/hardware-monitor.git](https://github.com/CarlosAlbertoGR/hardware-monitor.git)


(Reemplaza 'hardware-monitor' si tu repositorio se llama diferente)

Abre el proyecto en tu IDE favorito (como NetBeans, IntelliJ IDEA, o Eclipse).

El IDE deberá detectar el archivo pom.xml y descargar automáticamente las dependencias (principalmente oshi-core).

Ejecuta la clase principal monitor.Main.java.

Autor

@CarlosAlbertoGR
