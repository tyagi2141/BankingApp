package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.ui.theme.BankingAppTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {
                setBarColor(color = MaterialTheme.colorScheme.background)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun setBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color = color)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    Scaffold(bottomBar = {
        BottomNavigationBar()
    }) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            WalletSection()
            Spacer(modifier = Modifier.height(8.dp))
            CardSection()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Finance" , Modifier.padding(start = 20.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            FinanceSection()
            Spacer(modifier = Modifier.height(8.dp))
            CurrencySection()
        }

    }
}



@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(selected = index == 0, onClick = {  }, icon = { Icon(
                    imageVector = item.icon,
                    contentDescription = null, tint = MaterialTheme.colorScheme.onBackground
                ) }, label = { Text(
                    text = item.title,
                    color = MaterialTheme.colorScheme.onBackground
                )})
            }
        }
    }
}

