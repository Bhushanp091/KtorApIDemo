package Modules

import org.koin.dsl.module
import viewModel.HomeViewModel

val provideviewModelModule = module {
    single {
        HomeViewModel(get())
    }
}

//This module create koin view-modelModule