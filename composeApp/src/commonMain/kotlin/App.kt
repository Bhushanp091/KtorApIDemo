
import Model.Products
import Modules.appModule
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.getKoin
import viewModel.HomeViewModel

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {

        MaterialTheme {

            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = getKoin().get()
    val homeScreenState by viewModel.homeViewState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getProducts()
    }
    when (homeScreenState) {
        is HomeViewModel.HomeScreenState.Loading -> {
            println("loading")
            CircularProgressIndicator()
        }

        is HomeViewModel.HomeScreenState.Success -> {
            val products =
                (homeScreenState as HomeViewModel.HomeScreenState.Success).responseData.list
            ProductCard(products)
        }

        is HomeViewModel.HomeScreenState.Error -> {
            println("Error")
        }
    }
}

@Composable
fun ProductCard(list: List<Products>) {

    LazyColumn {
        items(list) {
            ProductItem(
                it.title,
                it.description,
                it.price.toString(),
                it.thumbnail
            )
        }
    }

}


@Composable
fun ProductItem(name: String, description: String, price: String, image: String) {
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {

        Column(modifier = Modifier.height(380.dp).padding(10.dp)) {
            KamelImage(
                resource = asyncPainterResource(data = image),
                contentDescription = null,
                modifier = Modifier.height(150.dp).fillMaxWidth().clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = name,
                    maxLines = 3,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = description,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "$$price",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.button,
                )
                Spacer(modifier = Modifier.height(3.dp))
            }
        }
    }
}