import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import multiplatform.network.cmptoast.ToastHost
import network.chaintech.cmptoastdemo.App

fun main() = application {
    Window(
        title = "CMPToast Demo",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(150, 150)
        App()

        ToastHost() // *** Important : Include this line to show the ToastHost
    }
}