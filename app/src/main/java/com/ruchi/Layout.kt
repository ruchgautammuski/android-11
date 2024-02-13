data class LayoutSections(
    val sections: List<Section>,
    val variant: String,
    val version: String
)

data class Section(
    val cards: List<Card>,
    val number_of_columns: Int,
    val subtitle: String,
    val title: String,
    val type: Int
)

data class Card(
    val deeplink: String = "",
    val image_url: String = "",
    val type: String = ""
)