package paterrx.com.github.GabrielPaterra_RM93688

data class ItemModel(
    val id: Int,
    val name: String,
    val description: String,
    val onRemove: (ItemModel) -> Unit
)
