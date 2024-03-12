package com.example.bankingapp

import android.provider.CalendarContract.Colors
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.model.Card
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenEnd
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart

val cardItems = listOf(
    Card(
        cardType = "Visa",
        cardNumber = "1234 5678 8765 4321",
        cardName = "Business",
        balance = 122.3,
        color = getGradiant(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "4321 5432 3456 5678",
        cardName = "SAVING",
        balance = 122.3,
        color = getGradiant(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "Visa",
        cardNumber = "0000 5678 8765 1111",
        cardName = "SCHOOL",
        balance = 122.3,
        color = getGradiant(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "2323 4545 6666 7777",
        cardName = "Business",
        balance = 23.3,
        color = getGradiant(GreenStart, GreenEnd)
    ),
)


fun getGradiant(startColor: Color, endColor: Color): Brush {

    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}


@Preview()
@Composable
fun CardSection() {
    LazyRow {
        items(cardItems.size) { index ->
            CardItem(index = index)
        }
    }
}

@Composable
fun CardItem(index: Int) {

    val card = cardItems[index]
    var lastItemPadding = 0.dp
    if (index == cardItems.size - 1) {
        lastItemPadding = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPadding)

    ) {
        Column(
            modifier = Modifier
                .width(250.dp)
                .height(160.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(brush = card.color)
                .padding(10.dp)


        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}", color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber, color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )


        }
    }

}












