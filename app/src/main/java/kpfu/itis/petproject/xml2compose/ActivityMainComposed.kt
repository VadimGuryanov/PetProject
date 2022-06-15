package kpfu.itis.petproject.xml2compose

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import kpfu.itis.petproject.R

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewActivityMainComposed() {
    MaterialTheme {
       ActivityMainComposed() 
    }
}

@ExperimentalMaterialApi
@Composable
fun ActivityMainComposed() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        val (toolbar, bnv_main, host_fragment) = createRefs()

        val menu_for_top_list = getMenuForTopComposedList()
        TopAppBar(
            modifier = Modifier.fillMaxWidth().constrainAs(toolbar) {
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        },
            backgroundColor = colorResource(id = R.color.colorOnPrimary),
            navigationIcon =  {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(R.drawable.ic_android), contentDescription = null,tint = Color.Unspecified)
                }
        },
            title =  { Text(text = "Test Plugin Project", color = colorResource(id = R.color.white)) },
            actions =  { }
        )

        Box(Modifier.padding(top = 56.dp, bottom = 56.dp)
            .constrainAs(host_fragment) {
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                top.linkTo(toolbar.bottom)
                bottom.linkTo(bnv_main.top)
            }
        ) { NavGraph() }

        val bottom_menu_main_list = getBottomMenuMainComposedList()
        BottomNavigation(modifier = Modifier.fillMaxWidth().constrainAs(bnv_main) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        }, backgroundColor = colorResource(id = R.color.colorOnPrimary)) {
            bottom_menu_main_list.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon), contentDescription = item.title, tint = colorResource(id = R.color.white)) },
                    selectedContentColor = colorResource(id = R.color.white),
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {
                        /* Add code later */
                    }
                )

            }
        }
    }
}
