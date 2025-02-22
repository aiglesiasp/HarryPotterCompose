package com.ipa.dev.harrypottercompose.ui.screens.spells

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipa.dev.harrypottercompose.domain.entities.Spell
import com.ipa.dev.harrypottercompose.usecase.FetchAllSpellsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpellsViewModel @Inject constructor(
    private val fetchAllSpellsUseCase: FetchAllSpellsUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> get() = _uiState

    data class UiState(
        val isLoading: Boolean = false,
        val spells: List<Spell> = emptyList()
    )
    init {
        getSpells()
    }
    private fun getSpells() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch {
            val spells = fetchAllSpellsUseCase()
            _uiState.value = UiState(spells = spells, isLoading = false)
        }
    }
}