package com.khoofiya.realnews.base.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khoofiya.realnews.base.datamanager.DataManager
import javax.inject.Inject

internal class DIViewModelFactory @Inject constructor(
    private val dataManager: DataManager
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return try {
            modelClass.getConstructor(DataManager::class.java)
                .newInstance(dataManager)
        } catch (e: IllegalArgumentException) {
            throw e
        } catch (e: Exception) {
            throw e
        }
    }

}