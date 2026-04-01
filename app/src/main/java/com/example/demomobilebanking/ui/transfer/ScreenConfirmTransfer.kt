package com.example.demomobilebanking.ui.transfer

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object ConfirmTransfer : NavKey

@Composable
fun ScreenConfirmTransfer(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.img_background),
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
                    painter = painterResource(R.drawable.ic_angle_back),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(16.dp)
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
                        painter = painterResource(R.drawable.ic_pf_demo),
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
                    Text(
                        text = "Transfer from",
                        fontWeight = FontWeight.W500,
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1.7f)
                    ) {
                        Text(
                            text = "Jack",
                            fontWeight = FontWeight.W700,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                        Text(
                            text = "0011 111 111 (USD)",
                            fontWeight = FontWeight.W400,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 10.dp)
                        )
                    }
                }
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Fee",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )
                        Text(
                            text = "Exchange Rate",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )
                        Text(
                            text = "Approx.Amount",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )
                        Text(
                            text = "Debit Amount",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1.7f)
                    ) {
                        Text(
                            text = "0.00 USD",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )
                        Text(
                            text = "4,100 KHR",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )
                        Text(
                            text = "4,000,001.00 USD",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )
                        Text(
                            text = "196.89 USD",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .padding(top = 16.dp),
                        )

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Text(
                        text = "Remark",
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .weight(1f)
                    )
                    Text(
                        text = "Buy Food",
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.weight(1.7f)
                    )
                }
                HorizontalDivider()
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(horizontal = 16.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
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

@Preview
@Composable
private fun ScreenConfirmTransferPreview() {
    ScreenConfirmTransfer()
}