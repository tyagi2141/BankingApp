package com.example.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.model.FinanceModel
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleStart


val financeList = listOf(
    FinanceModel(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),

    FinanceModel(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),

    FinanceModel(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),

    FinanceModel(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    ),
)

@Preview
@Composable
fun FinanceSection() {
    Column {

        LazyRow() {
            items(financeList.size) { index ->
                FinanceItem(index)

            }
        }
    }

}

@Composable
fun FinanceItem(index: Int) {

    val finance = financeList[index]
    var lastIndexPadding = 0.dp
    if (index == financeList.size - 1) {
        lastIndexPadding = 16.dp
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastIndexPadding)) {
        Column(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(13.dp)
        ) {

            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = null,
                    modifier = Modifier
                        .background(finance.background)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = finance.name, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)


        }
    }


}

