import androidx.compose.ui.window.ComposeUIViewController
import network.chaintech.cmptoastdemo.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
