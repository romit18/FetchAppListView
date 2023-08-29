import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetch.fetchlist.dto.Item
import com.fetch.fetchlist.retrofit.ItemServiceInstance
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val _itemList = mutableStateListOf<Item>()
    var errorMessage: String by mutableStateOf("")
    val itemList: List<Item>
        get() = _itemList

    fun getItems() {
        viewModelScope.launch {
            val itemService = ItemServiceInstance.itemService
            val items = filterAndSort(itemService.getItems())
            try {
                _itemList.clear()
                _itemList.addAll(items)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    private fun filterAndSort(items: List<Item>): List<Item> {
        return items.filter { v -> !v.name.isNullOrBlank() }.sortedWith((Comparator.comparing(Item::listId).thenComparing(Item::name)))
    }
}