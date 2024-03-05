package ru.vs.customDetektRules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider
import ru.vs.customDetektRules.rules.NavigationRegistrarImpl

/**
 * Предоставляет конфигурацию и список правил для detekt
 */
class CustomDetektRuleSetProvider : RuleSetProvider {
    override val ruleSetId: String
        get() = "control"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(NavigationRegistrarImpl(config)),
        )
    }
}
