package kpfu.itis.petproject.xml2compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

val AppThemeLight = AppThemeClass(
    colorPrimary = ColorPrimary,
    colorPrimaryVariant = ColorPrimaryVariant,
    colorOnPrimary = ColorOnPrimary,
    colorSecondary = Black,
    colorSecondaryVariant = Black,
    colorOnSecondary = Black,
)
val AppThemeNight = AppThemeClass(
    colorPrimary = BlackThemeColorPrimary,
    colorPrimaryVariant = BlackThemeColorPrimaryVariant,
    colorOnPrimary = BlackThemeColorOnPrimary,
    colorSecondary = BlackThemeColorSecondary,
    colorSecondaryVariant = BlackThemeColorSecondaryVariant,
    colorOnSecondary = Black,
)
data class AppThemeClass(
    val colorPrimary: Color,
    val colorPrimaryVariant: Color,
    val colorOnPrimary: Color,
    val colorSecondary: Color,
    val colorSecondaryVariant: Color,
    val colorOnSecondary: Color,
)

val LocalAppTheme = staticCompositionLocalOf<AppThemeClass> {
    error("No value provides")
}

data class ToolbarStyle(
    val androidBackground: Color = MainBackground,
)

val LocalToolbarStyle = staticCompositionLocalOf<ToolbarStyle> {
    error("No value provides")
}

data class BottomNavigationStyle(
    val androidBackground: Color = MainBackground,
)

val LocalBottomNavigationStyle = staticCompositionLocalOf<BottomNavigationStyle> {
    error("No value provides")
}

data class ItemStyle(
    val androidBackground: String? = null,
)

val LocalItemStyle = staticCompositionLocalOf<ItemStyle> {
    error("No value provides")
}

object AppTheme {
    val colors: AppThemeClass
    @Composable
    get() = LocalAppTheme.current

    val toolbarstyle: ToolbarStyle
    @Composable
    get() = LocalToolbarStyle.current

    val bottomnavigationstyle: BottomNavigationStyle
    @Composable
    get() = LocalBottomNavigationStyle.current

    val itemstyle: ItemStyle
    @Composable
    get() = LocalItemStyle.current
}
