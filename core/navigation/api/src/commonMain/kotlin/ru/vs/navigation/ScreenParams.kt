package ru.vs.navigation

/**
 * Параметры для запуска экрана.
 *
 * При этом [ScreenParams::class] является ключом экрана, с его помощью можно регистрировать хосты навигации, а так же
 * регистрировать экран в хостах навигации.
 *
 * Объект [ScreenParams] напротив является ключом конкретного инстанса экрана и может использоваться для передачи
 * конфигурации. Если экран не требует параметров конфигурации, то его [ScreenParams] могут быть `data object`.
 */
interface ScreenParams
