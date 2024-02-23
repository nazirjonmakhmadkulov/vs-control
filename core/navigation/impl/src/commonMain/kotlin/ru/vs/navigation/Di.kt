package ru.vs.navigation

import org.kodein.di.DI
import org.kodein.di.bindSet
import org.kodein.di.bindSingleton
import ru.vs.core.di.Modules
import ru.vs.core.di.i

fun Modules.coreNavigation() = DI.Module("core-navigation") {
    // Декларируем множество в которое будут собраны все регистраторы навигации в приложении.
    bindSet<NavigationRegistrar>()

    bindSingleton<NavigationRegistry> { NavigationRegistryImpl(i()) }
}