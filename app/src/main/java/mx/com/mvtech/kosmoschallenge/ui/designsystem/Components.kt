package mx.com.mvtech.kosmoschallenge.ui.designsystem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar(
    title: String,
    leftIcon: ImageVector? = null,
    rightIcon: ImageVector? = null,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {}

){
    Surface(
        shadowElevation = 8.dp
    ) {
        TopAppBar(
            title = {
                Text(title)
            },
            navigationIcon = {
                leftIcon?.let {
                    IconButton(onClick = onLeftIconClick) {
                        Icon(imageVector = it, contentDescription = "Ir hacia atras")
                    }
                }
                //Icons.Filled.ArrowBack
            },
            actions = {
                rightIcon?.let {
                    IconButton(onClick = onRightIconClick) {
                        Icon(
                            imageVector = it,
                            contentDescription = ""
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun CustomLoader(){
    Surface(
        shadowElevation = 8.dp
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
                .height(8.dp),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun EmptyResults(
    modifier: Modifier = Modifier,
    message: String = "SIN RESULTADOS"
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = message,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}