
import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab8pmbelensupermarket.dataBase.AppDatabase
import com.example.lab8pmbelensupermarket.networking.datac.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application): AndroidViewModel(application) {
    val categoriesState: MutableState<List<Category>> = mutableStateOf(emptyList())

    private val repository: CategoryRepository

    init {
        val categoryDao = AppDatabase.getDatabase(application).categoryDao()
        repository = CategoryRepository(categoryDao = categoryDao)

        viewModelScope.launch(Dispatchers.IO) {
            val categories = repository.getCategories()
            categoriesState.value = categories
        }
    }
}
