package ir.hoseinsa.presenter.di

import ir.hoseinsa.presenter.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel<UsersViewModel> { UsersViewModel(get()) }
}