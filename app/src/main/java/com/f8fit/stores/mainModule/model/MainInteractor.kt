package com.f8fit.stores.mainModule.model

import com.f8fit.stores.StoreApplication
import com.f8fit.stores.common.entities.StoreEntity
import java.util.concurrent.LinkedBlockingQueue

class MainInteractor {

    fun getStores(callback: (MutableList<StoreEntity>) -> Unit){
        val queue = LinkedBlockingQueue<MutableList<StoreEntity>>()
        Thread{
            val storeList = StoreApplication.database.storeDao().getAllStores()
            queue.add(storeList)
        }.start()
        callback(queue.take())
    }

    fun deleteStore(storeEntity: StoreEntity, callback: (StoreEntity) -> Unit){
        val queue = LinkedBlockingQueue<StoreEntity>()
        Thread{
            StoreApplication.database.storeDao().deleteStore(storeEntity)
            queue.add(storeEntity)
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