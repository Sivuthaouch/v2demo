package com.example.demomobilebanking.ui.forgetpassword

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object ResetPWSuccess : NavKey

@Composable
fun ScreenResult(){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 14.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(weight = 1f)
                    .fillMaxSize()

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check_circle),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_thankyou),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = "You can now login using your new password.",
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .height(height = 52.dp)
                    .background(
                        shape = RoundedCornerShape(size = 10.dp),
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
                    text = "Confirm",
                    fontWeight = FontWeight.W700,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
}
@Preview(showBackground = true)
@Composable
fun ScreenResultPreview(){
    ScreenResult()
}