import com.example.lab8pmbelensupermarket.dataBase.CategoryDao
import com.example.lab8pmbelensupermarket.networking.MealWebService
import com.example.lab8pmbelensupermarket.networking.datac.CategoriesDC
import com.example.lab8pmbelensupermarket.networking.datac.Category


class CategoryRepository(
    private val webService: MealWebService = MealWebService(),
    private val categoryDao: CategoryDao
) {


    suspend fun refreshCategories(): CategoriesDC {
        val categoriesFromApi = webService.getMealsCategories()
        categoryDao.insertAll(categoriesFromApi.categories)
        return categoriesFromApi
    }

    //
    suspend fun getCategoriesFromCache(): List<Category> {
        return categoryDao.getAllCategories()
    }


    suspend fun getCategories(): List<Category> {
        val cachedCategories = getCategoriesFromCache()
        return if (cachedCategories.isEmpty()) {
            refreshCategories().categories
        } else {
            cachedCategories
        }
    }
}
