package com.f8fit.stores.common.utils

import com.f8fit.stores.common.entities.StoreEntity

interface MainAux {
    fun hideFab(isVisible: Boolean = false)

    fun addStore(storeEntity: StoreEntity)
    fun updateStore(storeEntity: StoreEntity)
}