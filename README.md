# solar-system

## Context

There are three planets orbiting a sun in a remote galaxy, these planets are Ferengi (500 km away from the sun), Betasoide (2000 km away from the sun) and Vulcano (1000 km away from the sun).
Their civilization accorded a plan to predict the weather condition through 10 years, their weather occur simultaniously on every planet after some conditions are meet with their planet's position relative to the sun.


The weather conditions are as follows:

- Rainy: the three planets must form a triangle with the sun in the middle. The precipitation is calculated by the perimeter that is formed with the planet's triangle formation.
- Drought: the planets experiment a day of drought only when the distance bewteen the three of them can be draw in a single line ... pointing to the sun!
- Optimal: the planets experiment a flourishing day only if they align themselves on the same line but that line is not pointing at the sun.


The Ferengis, Betasoidens and Vulcans managed to resolve predicting (calculating!) the weather forecast for the next ten years, and they had upload the Service to consult forecasts on the web, on a Heroku domain specifically, that has 2 main endpoints:

- https://mercado-libre-solar-system.herokuapp.com/api/weather : it reaches throught all the database that the three civilizations made and it returns how many days it will rain, be dry and be optimal. As a bonus it will say which day will rain the most to be prepared for that occasion.
- https://mercado-libre-solar-system.herokuapp.com/api/weather?day={day} : when given a specific date, the Service will tell you wherever that day it will be dry, rain, be ideal or just a common day.

- The creators of said Service had also hidden another Service alongside the main one, to debug the main Service.

The full extend of both services can be found here: https://mercado-libre-solar-system.herokuapp.com/swagger-ui.html#/

```

Habiendo dicho todo aquello de arriba como introduccion, dejo pequeñas notas que recompilo despues de haber hecho esta API.
El programa arranca con setear sus cosas donde corresponden, luego cuando inicializa la prediccion se va a iterar del 1 al 3650 (siendo estos los dias encontrados en diez años),
por cada iteracion, el sistema solar movera sus planetas con la formula de MCU (Movimiento Circular Uniforme) para ubicar sus posiciones, luego de eso le pasara la responsabilidad al servicio PredictionServiceImpl, apartir del estado del Sistema Solar utilizara su lista de condiciones de clima para saber en que estado de ellas se encuentra el sistema solar;
(utilizando el patron de diseño State), cuando es Seco u Optimo los planetas deberan tener el angulo (de la ecuacion de la recta que las una de a 2 puntos) iguales, pero con la diferencia es que la ecuacion de la recta que se forme entre el sol y algun punto NO debe ser el mismo si estariamos hablando del clima ideal, caso contrario seria clima seco;
El clima lluvioso fue problematico asi que acudi a Google y encontre este hallazgo https://www.youtube.com/watch?v=HYAgJN3x4GA que lo aplique a mi servicio. Como en principio no sabia que formulas utilizar para calcular las predicciones y queria tenerlo para el final, decidi crear un servicio que mocke los datos de los dias en la BBDD. Como es buen ejemplo para ver como la
base de datos se moquea y vuelve a las predicciones con solo 2 endpoints decidi dejar dicho endpoint de debug.