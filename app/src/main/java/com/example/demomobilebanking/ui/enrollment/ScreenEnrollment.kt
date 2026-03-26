package com.example.demomobilebanking.ui.enrollment

import android.R
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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object ScreenEnrollment : NavKey

@Composable
fun ScreenEnrollment(
    onEnrollConfirm : () -> Unit
){
    var phonenumber by remember { mutableStateOf(value = "") }
    var checked by remember { mutableStateOf(value = true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .navigationBarsPadding()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Registration",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,

                )

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp

                ),
            text = "Welcome to ",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp

                ),
            text = "Please enter your mobile phone number to continue",
            fontSize = 16.sp,


        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = phonenumber,
            onValueChange = {
                    newValue ->
                phonenumber = newValue
            },
            label = {Text(text = "Phone Number")},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 63.dp)
        ){
            Text(
                modifier = Modifier.padding(all = 16.dp),
                text = "I agree with Terms and Condition",
                fontWeight = FontWeight.W500,
                fontSize = 16.sp
            )
            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color.Blue,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.Gray,
                )
            )
        }
        TextButton(
            onClick = {}
        ) {
            Text(
                text = "Terms and Condition"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    indication = ripple(),
                    onClick = onEnrollConfirm
                )
                .height(height = 60.dp)
                .padding(horizontal = 16.dp)
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
fun ScreenEnrollmentPreview(){
    ScreenEnrollment(
        onEnrollConfirm = {}
    )
}