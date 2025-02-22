package com.ipa.dev.harrypottercompose.ui.screens.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipa.dev.harrypottercompose.domain.entities.Character
import com.ipa.dev.harrypottercompose.usecase.FetchAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val useCase: FetchAllCharacterUseCase
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> get() = _uiState

    data class UiState(
        val isLoading: Boolean = false,
        val characters: List<Character> = emptyList()
    )

    init {
        getCharacters()
    }

    private fun getCharacters() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch {
            val characters = useCase.invoke()
            println(characters)
            _uiState.value = UiState(characters = characters, isLoading = false)
        }
    }
}