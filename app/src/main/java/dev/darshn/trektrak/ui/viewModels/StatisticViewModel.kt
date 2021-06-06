package dev.darshn.trektrak.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.darshn.trektrak.repositories.MainRepository
import javax.inject.Inject

@HiltViewModel
class StatisticViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {
}