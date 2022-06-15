package kpfu.itis.petproject.xml2compose

import kpfu.itis.petproject.R

sealed class MenuForTopComposed(var icon: Int, var title: String) {
    object Favorite:  MenuForTopComposed(R.drawable.ic_tools, "favorite")
    object Menu:  MenuForTopComposed(R.drawable.ic_menu, "menu")
}
fun getMenuForTopComposedList(): List<MenuForTopComposed> = listOf(
    MenuForTopComposed.Favorite,
    MenuForTopComposed.Menu,
)
