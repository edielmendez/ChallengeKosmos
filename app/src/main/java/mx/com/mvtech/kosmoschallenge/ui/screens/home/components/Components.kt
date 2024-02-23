package mx.com.mvtech.kosmoschallenge.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import mx.com.mvtech.kosmoschallenge.R
import mx.com.mvtech.kosmoschallenge.domain.models.CharacterModel

@Composable
fun CharactersList(
    modifier: Modifier = Modifier,
    characters: List<CharacterModel> = emptyList(),
    onItemClick: (CharacterModel) -> Unit
){
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 16.dp
        )
    ){
        items(characters){ _character ->
            CharacterRow(
                modifier = Modifier.padding(
                    vertical = 16.dp
                ),
                item = _character,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
fun CharacterRow(
    modifier: Modifier = Modifier,
    item: CharacterModel,
    onItemClick: (CharacterModel) -> Unit
){

    var showDetails by remember {
        mutableStateOf(false)
    }
    val buttonText by remember {
        derivedStateOf { if(showDetails) "Ocultar detalle" else "Ver detalle" }
    }
    Card(
        modifier = modifier.fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxWidth()
                    .height(200.dp),
                painter = rememberAsyncImagePainter(model = item.image, contentScale = ContentScale.FillBounds),
                contentDescription = null
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.name,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            if(showDetails){
                Column {
                    Row {
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = stringResource(id = R.string.status_label),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = item.status,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = stringResource(id = R.string.specie_label),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center

                        )
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = item.species,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = stringResource(id = R.string.type_label),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = item.type,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = stringResource(id = R.string.origin_label),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = item.origin,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = stringResource(id = R.string.location_label),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.weight(0.5f),
                            text = item.location,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            Button(
                onClick = { showDetails = !showDetails  }
            ) {
                Text(text = buttonText)
            }
        }
    }
}