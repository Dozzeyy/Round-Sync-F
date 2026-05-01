package ca.pkay.rcloneexplorer.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ca.pkay.rcloneexplorer.notifications.support.StatusObject
import java.util.concurrent.ConcurrentHashMap

data class TransferStatus(val title: String, val status: StatusObject)

object TransferTracker {
    private val transfersMap = ConcurrentHashMap<String, TransferStatus>()
    private val _ongoingTransfers = MutableLiveData<Map<String, TransferStatus>>(emptyMap())
    val ongoingTransfers: LiveData<Map<String, TransferStatus>> = _ongoingTransfers

    fun updateTransfer(id: String, title: String, status: StatusObject) {
        transfersMap[id] = TransferStatus(title, status)
        _ongoingTransfers.postValue(HashMap(transfersMap))
    }

    fun removeTransfer(id: String) {
        transfersMap.remove(id)
        _ongoingTransfers.postValue(HashMap(transfersMap))
    }
}
