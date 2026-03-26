package com.example.demomobilebanking.ui.log_in

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object ConfirmOTP : NavKey
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDeviceBinding(
    confirmOTP : () -> Unit,
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            println("You click Navigation Icon")
                        }
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Menu Icon"
                        )
                    }
                }
            )
        }
    ) {
        innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
                .padding(top = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text (
                text = "Confirm OTP",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    ),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(height = 8.dp))
            Text (
                text = "Type the code that we sent you by SMS",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    ),

                fontSize = 16.sp
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(height = 32.dp))
            Text (
                text = "Device name",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    ),
                fontSize = 12.sp
            )
            TextField(
                enabled = false,
                value = "IPhone 13 Pro Max",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    disabledContainerColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(height = 8.dp))

            OtpInputField(
                onOtpComplete = {
                    confirmOTP()
                }
            )
        }
    }
}
@Composable
fun OtpInputField(
    otpLength: Int = 6,
    onOtpComplete: () -> Unit
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
                        onOtpComplete()
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
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier

                        .weight(weight = 1f)
                        .aspectRatio(ratio = 1f)
                ) {
                    Text(
                        text = digit,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                        fontSize = 24.sp,
                    )
                    Spacer(modifier = Modifier.height(height = 4.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 2.dp)
                            .background(
                                color = Color.LightGray,
                                shape = RoundedCornerShape(size = 1.dp)
                            )
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ScreenDeviceBindingPreview(){
    ScreenDeviceBinding(
        confirmOTP = {}
    )
}