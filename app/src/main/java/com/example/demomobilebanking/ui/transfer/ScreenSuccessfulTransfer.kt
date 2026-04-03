package com.example.demomobilebanking.ui.transfer

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object SuccessfulTransfer : NavKey

@Composable
fun ScreenSuccessfulTransfer(
    modifier: Modifier = Modifier,
    onBackToAccount : () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFEBEBEB)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_demobank),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .padding(start = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_checkcircle_green),
                contentDescription = null,
                tint = Color.Unspecified,
            )
            Text(
                text = "Successful",
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                color = Color(0xFF004CCC),
                modifier = Modifier
                    .padding(all = 12.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(size = 10.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 21.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_transfer_big),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(50.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Paid to",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color(0xFF004CCC)
                        )
                        Text(
                            text = "Jack",
                            fontWeight = FontWeight.W700,
                            fontSize = 16.sp,
                            color = Color(0xFF004CCC)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "200.00",
                            fontWeight = FontWeight.W700,
                            fontSize = 24.sp,
                            color = Color(0xFFDF0826)
                        )
                        Text(
                            text = "USD",
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color(0xFFDF0826)
                        )
                    }
                }
            }
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)) {
                drawLine(
                    color = Color.Black,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(10f, 10f), phase = 0f)
                )
            }

            DisplayField(
                type = "Transaction ID:",
                credential = "Jack",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Transaction Hash #:",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    color = Color(0xFF808080)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "988909295305",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    color = Color(0xFF004CCC),
                    modifier = Modifier
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_copy2),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(start = 4.dp)
                )
            }
            DisplayField(
                type = "Transaction Date:",
                credential = "08 Aug 2024 | 2:37PM",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp)
            )
            DisplayField(
                type = "Exchange Rate:",
                credential = "08 Aug 2024 | 2:37PM",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp)
            )
            DisplayField(
                type = "Transaction Date:",
                credential = "08 Aug 2024 | 2:37PM",
                modifier = Modifier
                    .padding( horizontal = 16.dp)
                    .padding(top = 10.dp)
            )
            DisplayField(
                type = "Debit amount:",
                credential = "08 Aug 2024 | 2:37PM",
                modifier = Modifier
                    .padding( horizontal = 16.dp)
                    .padding(top = 10.dp)
            )
            DisplayField(
                type = "From account:",
                credential = "08 Aug 2024 | 2:37PM",
                modifier = Modifier
                    .padding( horizontal = 16.dp)
                    .padding(top = 10.dp)
            )
            DisplayField(
                type = "To account:",
                credential = "08 Aug 2024 | 2:37PM",
                modifier = Modifier
                    .padding( horizontal = 16.dp)
                    .padding(top = 10.dp)
            )
            DisplayField(
                type = "Debit amount:",
                credential = "08 Aug 2024 | 2:37PM",
                modifier = Modifier
                    .padding( horizontal = 16.dp)
                    .padding(top = 10.dp, bottom = 16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal =16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = "Share",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    color = Color(0xFF004CCC)
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_download),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = "Download",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    color = Color(0xFF004CCC)
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_return),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = "Repeat",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    color = Color(0xFF004CCC)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding()
                .height(height = 60.dp)
                .clickable(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    indication = ripple(),
                    onClick = onBackToAccount
                )
                .background(
                    shape = RoundedCornerShape(size = 16.dp),
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(
                                color = 0xFF1A6FFF
                            ),
                            Color(
                                color = 0xFF002F80
                            ),
                        )
                    )
                )
        ){
            Text(
                text = "Back To Account",
                fontWeight = FontWeight.W700,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Composable
fun DisplayField(
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
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            color = Color(0xFF808080),
            modifier = Modifier
                .weight(weight = 1f)
        )
        Text(
            text = credential,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            color = Color(0xFF004CCC),
            textAlign = TextAlign.End,
            modifier = Modifier
                .weight(weight = 1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenSuccessfulTransferPreview() {
    ScreenSuccessfulTransfer(
        onBackToAccount = {}
    )
}