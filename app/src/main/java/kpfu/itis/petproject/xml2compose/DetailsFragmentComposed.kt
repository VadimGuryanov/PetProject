package kpfu.itis.petproject.xml2compose

import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import kpfu.itis.petproject.R

@Preview(showBackground = true)
@Composable
fun PreviewDetailsFragmentComposed() {
    MaterialTheme {
       DetailsFragmentComposed() 
    }
}

@Composable
fun DetailsFragmentComposed() {
Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
    Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Column {
            Image(painterResource(R.drawable.ic_android), "", modifier = Modifier.width(48.dp).height(48.dp))
            Text(text = "Android", color = colorResource(id = R.color.black), fontSize = 14.sp)
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(colorResource(id = R.color.black)))
            Row {
                Row() {
                    RadioButton(selected = false, onClick = {})
                    Text("Android", modifier = Modifier.align(Alignment.CenterVertically))
                }
                Row() {
                    RadioButton(selected = false, onClick = {})
                    Text("IOS", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(colorResource(id = R.color.black)))
            Row {
                Row() {
                    Checkbox(checked = false, onCheckedChange = {})
                    Text("Yes", modifier = Modifier.align(Alignment.CenterVertically))
                }
                Row() {
                    RadioButton(selected = false, onClick = {})
                    Text("No", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(colorResource(id = R.color.black)))
        }
    }
}
}
