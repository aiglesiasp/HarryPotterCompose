package com.ipa.dev.harrypottercompose.domain

import com.ipa.dev.harrypottercompose.domain.entities.Spell

interface SpellsRepository {
    suspend fun fetchAllSpells(): List<Spell>
}