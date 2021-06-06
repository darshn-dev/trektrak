package dev.darshn.trektrak.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.darshn.trektrak.R
import dev.darshn.trektrak.ui.viewModels.MainViewModel
import dev.darshn.trektrak.ui.viewModels.StatisticViewModel

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {
    private val viewModel : StatisticViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}