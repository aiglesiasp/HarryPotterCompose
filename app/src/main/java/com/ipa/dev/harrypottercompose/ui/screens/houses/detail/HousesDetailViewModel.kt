package com.ipa.dev.harrypottercompose.ui.screens.houses.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipa.dev.harrypottercompose.domain.entities.Character
import com.ipa.dev.harrypottercompose.usecase.FetchAllCharactersByHouseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HousesDetailViewModel @Inject constructor(
    @Named("name") private val name: String,
    private val fetchAllCharactersByHouse: FetchAllCharactersByHouseUseCase
): ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> get() = _uiState

    data class UiState(
        val isLoading: Boolean = false,
        val characters: List<Character> = emptyList()
    )

    init {
        getHouses()
    }

    private fun getHouses() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch {
            val characters = fetchAllCharactersByHouse(name)
            _uiState.value = UiState(characters = characters, isLoading = false)
        }
    }
}