package com.f8fit.stores.mainModule.adapter

import com.f8fit.stores.common.entities.StoreEntity

interface OnClickListener {
    fun onClick(storeId: StoreEntity)
    fun onFavoriteStore(storeEntity: StoreEntity)
    fun onDeleteStore(storeEntity: StoreEntity)
}