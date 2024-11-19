package paterrx.com.github.GabrielPaterra_RM93688

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel : ViewModel() {
    private val items = mutableListOf<ItemModel>()
    private val _itemsLiveData = MutableLiveData<List<ItemModel>>()
    val itemsLiveData: LiveData<List<ItemModel>> get() = _itemsLiveData

    fun addItem(name: String) {
        val item = ItemModel(
            id = items.size + 1,
            name = name,
            description = "Descricao padrao da dica ",
            onRemove = ::removeItem
        )
        items.add(item)
        _itemsLiveData.value = items
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
        _itemsLiveData.value = items
    }
}
