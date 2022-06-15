package kpfu.itis.petproject.xml2compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ThemesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) AppThemeLight else AppThemeNight
    val toolbarstyle = ToolbarStyle()
    val bottomnavigationstyle = BottomNavigationStyle()
    val itemstyle = ItemStyle()

    CompositionLocalProvider(
        LocalAppTheme provides colors,
        LocalToolbarStyle provides toolbarstyle,
        LocalBottomNavigationStyle provides bottomnavigationstyle,
        LocalItemStyle provides itemstyle,
        content = content
    )
}
