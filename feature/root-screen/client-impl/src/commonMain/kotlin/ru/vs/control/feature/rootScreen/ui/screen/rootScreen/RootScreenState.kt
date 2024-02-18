package ru.vs.control.feature.rootScreen.ui.screen.rootScreen

internal sealed interface RootScreenState {
    /**
     * Приложение инициализируется, показываем splashscreen.
     */
    data object Splash : RootScreenState

    /**
     * Приложение проинициализировалось, показываем контент
     */
    data object Content : RootScreenState
}
