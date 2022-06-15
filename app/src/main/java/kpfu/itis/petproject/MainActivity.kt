package kpfu.itis.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kpfu.itis.petproject.xml2compose.ActivityMainComposed
import kpfu.itis.petproject.xml2compose.AppTheme
import kpfu.itis.petproject.xml2compose.ThemesTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun Main() {
    ThemesTheme {
        Surface(modifier = Modifier.fillMaxSize(),) {
            ActivityMainComposed()
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Main()
}
