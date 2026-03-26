package com.example.demomobilebanking.ui.forgetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.time.delay
import kotlinx.serialization.Serializable
import kotlin.collections.listOf

@Serializable
data object ForgetPassword : NavKey

@Composable
fun ScreenConfirmOTP(
    modifier: Modifier = Modifier,
    forgotPasswordOTP : () -> Unit
){

    Box (
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_cancel),
                    contentDescription = null,
                    tint = Color.White
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 116.dp),
                    text = "Comfirmation",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(height = 32.dp))
            Text(
                modifier = Modifier
                    .padding(
                        bottom = 40.dp
                    ),
                text = "Password Recovery",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color.White

            )
            Text(
                modifier = Modifier
                    .padding(
                        bottom = 40.dp
                    ),
                text = "Type the code we have sent by SMS",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color(color = 0xFFBCC4DD)

            )
            OtpInputField (
                forgotPasswordOTPComplete = {
                    forgotPasswordOTP()
                }
            )
            Spacer(modifier = Modifier.height(height = 24.dp))
            OTPTimeOut{

            }
            Spacer(modifier = Modifier.height(height = 24.dp))
            Text(
                modifier = Modifier
                    .padding(
                        bottom = 40.dp
                    ),
                text = "If you did not get code you can ask for it again by choosing resend code",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color(color = 0xFFBCC4DD)

            )
        }
    }
}
@Composable
fun OtpInputField(
    otpLength: Int = 6,
    forgotPasswordOTPComplete: () -> Unit
) {
    var code by remember { mutableStateOf(value = "") }
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { focusRequester.requestFocus() }
    ) {
        BasicTextField(
            value = code,
            onValueChange = {
                if (it.length <= otpLength && it.all { c -> c.isDigit() }) {
                    code = it
                    if (it.length == otpLength) {
                        forgotPasswordOTPComplete()
                    }
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .focusRequester(focusRequester)
                .alpha(alpha = 0f)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            repeat(times = otpLength) { index ->
                val digit = code.getOrNull(index)?.toString() ?: ""
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(size = 32.dp)
                        .dropShadow(
                            shadow = Shadow(
                                radius = 8.dp,
                                offset = DpOffset(
                                    x = 0.dp,
                                    y = 4.dp
                                ),
                                color = Color.Black.copy(
                                    alpha = 0.06f
                                )
                            ),
                            shape = RoundedCornerShape(
                                size = 10.dp
                            )
                        )
                        .background(
                            color = Color.White.copy(
                                alpha = 0.28f
                            ),
                            shape = RoundedCornerShape(size = 6.dp)
                        )
                        .weight(weight = 1f)
                        .aspectRatio(ratio = 1f)
                ) {
                    Text(
                        text = digit,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        fontSize = 24.sp,
                    )
                    Spacer(modifier = Modifier.height(height = 4.dp))
                    
                }
            }
        }
    }
}
@Composable
fun OTPTimeOut(
    totaltime : Int = 120,
    onTimeOut : () -> Unit
){
    var timeLeft by remember { mutableStateOf(value = totaltime) }

    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0){
            delay(timeMillis = 1000L)
            timeLeft--
        }
        else{
            onTimeOut()
        }
    }
    val minutes = timeLeft / 60
    val seconds = timeLeft % 60
    Text(
        text = if (timeLeft > 0) " ${minutes}m ${seconds}s"
        else "Resend Code",
        color = if (timeLeft > 0) Color.White else Color.White,
        modifier = Modifier.clickable(enabled = timeLeft == 0){
            timeLeft = totaltime
        }
    )
}



@Preview(showBackground = true)
@Composable
fun ScreenConfirmOTPPreview(){
    ScreenConfirmOTP(
        forgotPasswordOTP = {}
    )
}

