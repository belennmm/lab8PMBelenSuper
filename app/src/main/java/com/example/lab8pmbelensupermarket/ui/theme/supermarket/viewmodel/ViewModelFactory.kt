

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab8pmbelensupermarket.dataBase.SupermarketItemDao
import com.uvg.laboratorio8supermarket.ui.supermarket.viewmodel.SupermarketViewModel


class SupermarketViewModelFactory(
    private val dao: SupermarketItemDao
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SupermarketViewModel::class.java)) {
            return SupermarketViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
