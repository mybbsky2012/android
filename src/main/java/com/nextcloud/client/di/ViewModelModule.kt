package com.nextcloud.client.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nextcloud.client.etm.EtmViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule
{
    @Binds @IntoMap @ViewModelKey(EtmViewModel::class)     abstract fun etmViewModel(vm: EtmViewModel) : ViewModel
    @Binds abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}
