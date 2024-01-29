# Logger

Данные модули описывают core logging framework - основной логер используемый везде в проекте. Данный логер не является
логером в прямом смысле, а лишь делегирует свои функции другому логеру и предназначен для отвязки модулей проекта от
внешних логеров (к сожалению под kmp только какой-то треш, вообще ничего не юзабельное).

Для фреймворка логирования сделано исключение из общих правил, так как логирование нужно практически везде и при этом не
влияет ни на unit тесты ни на основной функционал, поэтому инициализация логера отвязана от DI. Вместо этого состояние
логера хранится в global singleton объекте.

## Использование.

### Инициализация.

```kotlin
// Логер может быть инициализирован лишь единожды.
LoggerManager.init(
    externalLoggerFactory = TODO(), // передайте реализацию фабрики внешнего логера тут.
    rootLogLevel = LogLevel.TRACE // опционально, TRACE по умолчанию, уровень логирования.
)
// Или (при использовании default модуля)
LoggerManager.initDefault(
    rootLogLevel = LogLevel.TRACE // опционально, TRACE по умолчанию, уровень логирования.
)
```

### Использование

```kotlin
// Создание логеров до инициализации не допускается.
val logger = logger(
    tag = "tag",
    logLevel = LogLevel.TRACE // опционально, TRACE по умолчанию, уровень логирования.
)
logger.i { "Hello" }
```

## Предназначение модулей.

* `api` модуль содержит api для работы с логером, подключается везде, где требуется логирование.
* `manager` модуль содержит api для настройки логирования, данный модуль следует подключать только в основном модуле где
  будут происходить настройки параметров логирования.
* `default` предоставляет реализацию логера по умолчанию для всех поддерживаемых платформ.
* `common` модуль содержит общую для api и manager часть, которая так же экспортируется как api, поэтому подключать этот
  модуль отдельно не нужно.
* `internal` модуль используется для внутренних нужд фреймворка логирования (конкретно из-за невозможности шарить
  что-либо в рамках нескольких модулей при этом не выставляя это наружу). Данный модуль не следует нигде подключать.