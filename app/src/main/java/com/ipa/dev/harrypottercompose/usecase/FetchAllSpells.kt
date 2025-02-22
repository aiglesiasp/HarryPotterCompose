package com.ipa.dev.harrypottercompose.usecase

import com.ipa.dev.harrypottercompose.domain.SpellsRepository
import com.ipa.dev.harrypottercompose.domain.entities.Spell
import javax.inject.Inject

class FetchAllSpellsUseCase @Inject constructor(
    private val repository: SpellsRepository
) {
    suspend operator fun invoke(): List<Spell> = repository.fetchAllSpells()
}