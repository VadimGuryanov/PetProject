package kpfu.itis.petproject.xml2compose

import kpfu.itis.petproject.R

sealed class BottomMenuMainComposed(var icon: Int, var title: String) {
    object Home:  BottomMenuMainComposed(R.drawable.ic_home, "Home")
    object Learn:  BottomMenuMainComposed(R.drawable.ic_learn, "Learn")
    object Events:  BottomMenuMainComposed(R.drawable.ic_events, "Events")
}
fun getBottomMenuMainComposedList(): List<BottomMenuMainComposed> = listOf(
    BottomMenuMainComposed.Home,
    BottomMenuMainComposed.Learn,
    BottomMenuMainComposed.Events,
)
