package co.adrianblan.predictivebackbug

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.adrianblan.predictivebackbug.ui.theme.PredictivebackbugTheme
import co.adrianblan.predictivebackbug.ui.theme.Typography

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "first",
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                initialOffset = { it }
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                targetOffset = { -it / 3 }
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                initialOffset = { -it / 3 }
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                targetOffset = { it }
            )
        },
        modifier = modifier
    ) {
        composable("first") {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Green)
                    .clickable { navController.navigate("second") }
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .padding(20.dp)
                        .align(Alignment.Center)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "First",
                            style = Typography.displayMedium,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }

        composable("second") {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Blue)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .padding(20.dp)
                        .align(Alignment.Center)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Second",
                            style = Typography.displayMedium,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PredictivebackbugTheme {
        AppNavHost()
    }
}