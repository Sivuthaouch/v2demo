package com.example.demomobilebanking.ui.transfer

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object ConfirmTransfer : NavKey

@Composable
fun ScreenConfirmTransfer(
    modifier: Modifier = Modifier,
    onConfirmSuccess : () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_angle_back),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(all = 16.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(start = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pf_demo),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                   Column(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(start = 60.dp)
                   ) {
                       Text(
                           text = "Jack",
                           fontWeight = FontWeight.W700,
                           fontSize = 16.sp,
                           color = Color.White
                       )
                       Text(
                           text = "ID : 12345",
                           fontWeight = FontWeight.W400,
                           fontSize = 14.sp,
                           color = Color.White
                       )
                   }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Amount",
                        fontWeight = FontWeight.W500,
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 20.dp)
                    )
                    Text(
                        text = "4,000,000.00",
                        fontWeight = FontWeight.W700,
                        fontSize = 24.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 80.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "USD",
                        fontWeight = FontWeight.W700,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(start = 20.dp)
                ) {
                    DisplayText(
                        type = "Transfer from",
                        credential = "Albert Flores \n 0000 000 000 (USD)",
                        modifier = Modifier
                    )
                }
                HorizontalDivider()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    DisplayText(
                        type = "Fee",
                        credential = "0.00 USD",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 16.dp)
                    )
                    DisplayText(
                        type = "Exchange Rate",
                        credential = "4,100 KHR",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 16.dp)
                    )
                    DisplayText(
                        type = "Approx.Amount",
                        credential = "4,000,001.00 USD",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 16.dp)
                    )
                    DisplayText(
                        type = "Debit Amount",
                        credential = "200 USD",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider()
                DisplayText(
                    type = "Remark",
                    credential = "Buy Food",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .padding(vertical = 16.dp)
                )
                HorizontalDivider()
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(horizontal = 16.dp)
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            },
                            indication = ripple(),
                            onClick = onConfirmSuccess
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 10.dp)
                        ),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "CONFIRM",
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        color = Color(0xFF004CCC),
                        modifier = Modifier
                            .padding(vertical = 14.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun DisplayText(
    modifier: Modifier = Modifier,
    type : String,
    credential : String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = type,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = credential,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier
                .weight(1.7f)
        )
    }
}
@Preview
@Composable
private fun ScreenConfirmTransferPreview() {
    ScreenConfirmTransfer(
        onConfirmSuccess = {}
    )
}