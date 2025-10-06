package network.chaintech.cmptoastdemo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmptoastlibdemo.composeapp.generated.resources.Aeonik_Bold
import cmptoastlibdemo.composeapp.generated.resources.Aeonik_Regular
import cmptoastlibdemo.composeapp.generated.resources.Res
import cmptoastlibdemo.composeapp.generated.resources.SF_Pro_Display
import cmptoastlibdemo.composeapp.generated.resources.ic_arrow_right
import cmptoastlibdemo.composeapp.generated.resources.ic_arrow_top
import cmptoastlibdemo.composeapp.generated.resources.ic_drawer
import cmptoastlibdemo.composeapp.generated.resources.ic_profile
import multiplatform.network.cmptoast.ToastDuration
import multiplatform.network.cmptoast.ToastGravity
import multiplatform.network.cmptoast.showToast
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
    val customToastList = listOf("Top Toast", "Center Toast", "Colored Toast", "Icon Toast", "Custom Duration Toast")
    val FontAeonik = FontFamily(
        Font(Res.font.Aeonik_Regular, FontWeight.Normal),
        Font(Res.font.Aeonik_Bold, FontWeight.Bold)
    )

    val FontSfPro = FontFamily(
        Font(Res.font.SF_Pro_Display, FontWeight.Normal)
    )

    val resource = Res.drawable.ic_profile // Profile Icon
    val iconBitmap = resource.let { imageResource(it) }


    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.safeDrawing)
                    .padding(start = 20.dp, end = 20.dp, top = 28.dp),
                horizontalAlignment = Alignment.Start
            ) {
                stickyHeader {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Black)
                            .padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .size(60.dp),
                            painter = painterResource(Res.drawable.ic_profile),
                            contentDescription = "icProfile"
                        )

                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    color = Color(0xFF2A2A2A),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .border(
                                    color = Color(0xFF353535),
                                    width = 1.dp,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(22.dp),
                                painter = painterResource(Res.drawable.ic_drawer),
                                contentDescription = "icDrawer"
                            )
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                }

                item {
                    Text(
                        text = "Welcome User,",
                        color = Color(0xFFC6C6C6),
                        textAlign = TextAlign.Start,
                        fontSize = 32.sp,
                        style = TextStyle(
                            fontFamily = FontAeonik,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                item {
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                }

                item {
                    Text(
                        text = "Customized Toast Types",
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp,
                        style = TextStyle(
                            fontFamily = FontSfPro,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }

                item {
                    Spacer(modifier = Modifier.padding(top = 28.dp))
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        CardItem(
                            title = "Short\nToast",
                            color = Color(0xFFFF6B00),
                            onClick = {
                                showToast(
                                    message = "This is Short Toast",
                                    backgroundColor = Color.White,
                                    textColor = Color.Black,
                                    duration = ToastDuration.Short,
                                    cornerRadius = if (isDesktopPlatform()) { // Corner radius based on platform
                                        10
                                    } else {
                                        null
                                    }
                                )
                            }
                        )

                        CardItem(
                            title = "Long\nToast",
                            color = Color(0xFF399B82),
                            onClick = {
                                showToast(
                                    message = "This is Long Toast",
                                    backgroundColor = Color.White,
                                    textColor = Color.Black,
                                    duration = ToastDuration.Long
                                )
                            }
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.padding(top = 24.dp))
                }

                item {
                    Text(
                        text = "Custom Toast",
                        fontWeight = FontWeight.W700,
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        fontSize = 24.sp,
                        style = TextStyle(
                            fontFamily = FontAeonik,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                item {
                    Spacer(modifier = Modifier.padding(top = 18.dp))
                }

                items(customToastList.size) { index ->
                    CustomToastListItem(
                        title = customToastList[index],
                        onClick = {
                            when(index) {
                                0 -> {
                                    showToast(
                                        message = "This is Top Toast",
                                        backgroundColor = Color.White,
                                        textColor = Color.Black,
                                        gravity = ToastGravity.Top
                                    )
                                }
                                1 -> {
                                    showToast(
                                        message = "This is Center Toast",
                                        backgroundColor = Color.White,
                                        textColor = Color.Black,
                                        gravity = ToastGravity.Center
                                    )
                                }
                                2 -> {
                                    showToast(
                                        message = "This is Colored Toast",
                                        backgroundColor = Color(0xFF27AD9D)
                                    )
                                }
                                3 -> {
                                    showToast(
                                        message = "This is Icon Toast",
                                        backgroundColor = Color.White,
                                        textColor = Color.Black,
                                        gravity = ToastGravity.Center,
                                        icon = iconBitmap,
                                        iconSizeDp = 20
                                    )
                                }
                                4 -> {
                                    showToast(
                                        message = "This is Custom Duration Toast",
                                        backgroundColor = Color.White,
                                        textColor = Color.Black,
                                        duration = ToastDuration.CustomDuration(10) // Specify duration in seconds
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

private fun isDesktopPlatform(): Boolean {
    return platformName() == "Desktop"
}

@Composable
fun RowScope.CardItem(
    title: String = "",
    color: Color,
    onClick: () -> Unit
) {
    val FontAeonik = FontFamily(
        Font(Res.font.Aeonik_Regular, FontWeight.Normal),
        Font(Res.font.Aeonik_Bold,FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .weight(0.5f)
            .background(
                color = color,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                onClick()
            }
            .padding(16.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            color = Color.White,
            textAlign = TextAlign.Start,
            lineHeight = 28.sp,
            fontSize = 26.sp,
            style = TextStyle(
                fontFamily = FontAeonik,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.padding(top = 6.dp))

        Image(
            modifier = Modifier
                .size(42.dp),
            painter = painterResource(Res.drawable.ic_arrow_top),
            contentDescription = "icArrowTop"
        )


    }
}

@Composable
fun CustomToastListItem(
    title: String = "",
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(
                color = Color(0xFF2A2A2A),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                color = Color(0xFF353535),
                width = 1.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                onClick()
            }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.W400,
            color = Color.White,
            textAlign = TextAlign.Start,
            fontSize = 20.sp
        )

        Image(
            modifier = Modifier
                .size(42.dp),
            painter = painterResource(Res.drawable.ic_arrow_right),
            contentDescription = "icArrowRight"
        )
    }
}

