package kpfu.itis.petproject.xml2compose

import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.*
import androidx.navigation.NavController
import kpfu.itis.petproject.R

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewItemLayoutComposed() {
    MaterialTheme {
       ItemLayoutComposed() 
    }
}

@ExperimentalMaterialApi
@Composable
fun ItemLayoutComposed(navController: NavController? = null) {
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp), onClick = {
        navController?.navigate(MainGraphComposedScreen.DetailsFragment.route)
    }) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (iv_test, tv_test) = createRefs()

            Text(text = "Android", color = colorResource(id = R.color.black), fontSize = 14.sp, modifier = Modifier.constrainAs(tv_test) {
                bottom.linkTo(parent.bottom)
                start.linkTo(iv_test.end)
                top.linkTo(parent.top)
            })
            Image(painterResource(R.drawable.ic_android), "", modifier = Modifier.width(48.dp).height(48.dp).constrainAs(iv_test) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }.padding(4.dp))
        }
    }
}
