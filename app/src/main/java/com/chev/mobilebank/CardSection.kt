package com.chev.mobilebank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.chev.mobilebank.data.Card
import com.chev.mobilebank.ui.theme.BlueEnd
import com.chev.mobilebank.ui.theme.BlueStart
import com.chev.mobilebank.ui.theme.PurpleEnd
import com.chev.mobilebank.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "5624 8787 0987 8765",
        cardName = "Business",
        balance = 10000000,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "7765 5656 0987 8765",
        cardName = "Savings",
        balance = 20000000,
        color = getGradient(BlueStart, BlueEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color,
):Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardSection(){
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size-1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    
    Box(
        modifier = Modifier
            .padding(16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Text(text = card.cardName, color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
            Text(text = "Rp ${card.balance}", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = card.cardNumber, color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        }
    }
}