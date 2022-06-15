package kpfu.itis.petproject.xml2compose

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import kpfu.itis.petproject.Model

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewListFragmentComposed() {
    MaterialTheme {
       ListFragmentComposed() 
    }
}

@ExperimentalMaterialApi
@Composable
fun ListFragmentComposed(navController: NavController? = null) {
Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
    val item_layout_list = remember { Model.list }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(item_layout_list) { item ->        
        	ItemLayoutComposed(navController)
        }
    }
}
}
