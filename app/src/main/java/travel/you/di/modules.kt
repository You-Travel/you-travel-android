package travel.you.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import travel.you.trip.CreateNewTripViewModel

val modules = module {
    viewModel { CreateNewTripViewModel() }

}