package com.f8fit.stores.editModule.model

import com.f8fit.stores.StoreApplication
import com.f8fit.stores.common.entities.StoreEntity
import java.util.concurrent.LinkedBlockingQueue

class EditStoreInteractor {

    fun saveStore(storeEntity: StoreEntity, callback: (Long) -> Unit){
        val queue = LinkedBlockingQueue<Long>()
        Thread{
            val newId = StoreApplication.database.storeDao().addStore(storeEntity)
            StoreApplication.database.storeDao().deleteStore(storeEntity)
            queue.add(newId)
        }.start()
        callback(queue.take())
    }

    fun updateStore(storeEntity: StoreEntity, callback: (StoreEntity) -> Unit){
        val queue = LinkedBlockingQueue<StoreEntity>()
        Thread{
            StoreApplication.database.storeDao().updateStore(storeEntity)
            queue.add(storeEntity)
        }.start()
        callback(queue.take())
    }
}