package com.example.demomobilebanking.ui.forgetpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object ResetPassword : NavKey

@Composable
fun ScreenResetPassword(
    onResetSuccess : () -> Unit,
 ){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(state = scrollState)
    ){
        var newPassword by remember { mutableStateOf(value = "") }
        var confirmpassword by remember { mutableStateOf(value = "") }
        var newpasswordVisible by remember { mutableStateOf(value = false) }
        var confirmpasswordVisible by remember { mutableStateOf(value = false) }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 56.dp),
            verticalAlignment = Alignment.CenterVertically,

        ){
            Icon(
               painter = painterResource(id = R.drawable.ic_angle_back),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(start = 100.dp),
                text = "Change Password"
            )
        }
        Spacer(modifier = Modifier.height(height = 32.dp))
        Text(
            text = "Set your new password",
            fontWeight = FontWeight.W700,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(height = 32.dp))
        Text(
            text = "You will use it for access to your banking",
            fontWeight = FontWeight.W500,
            color = Color(0xFF999999),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(height = 48.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = newPassword,
            onValueChange = {
                newValue ->
                newPassword = newValue
            },
            label = { Text(text = "New Password")},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            visualTransformation = if (newpasswordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = {
                        newpasswordVisible = !newpasswordVisible
                    }
                ) {
                    Icon(
                        painter = if (newpasswordVisible) {
                            painterResource(id = R.drawable.ic_eye_on)
                        }
                        else {
                            painterResource(id = R.drawable.ic_eye_off)
                        },
                        contentDescription = "Toggle Password"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(height = 32.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = confirmpassword,
            onValueChange = { newValue ->
                confirmpassword = newValue
            },
            label = { Text(text = "Confirm Password")},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            visualTransformation = if (confirmpasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        confirmpasswordVisible = !confirmpasswordVisible
                    }
                ) {
                    Icon(
                        painter = if (confirmpasswordVisible) painterResource(id = R.drawable.ic_eye_on)
                        else painterResource(id = R.drawable.ic_eye_off),
                        contentDescription = "Toggle Password"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(height = 32.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 142.dp)
                .width(width = 343.dp)
                .background(
                    color = Color(color = 0xFFF5F5F5),
                    shape = RoundedCornerShape(size = 6.dp)
                ),

        ){
            Text(
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                text =
                    "Password must be at least 6 characters long container either : \n a. All alphabet (e.g., Tswenk); or \n b. " +
                            "All numeric (e.g., 298798); or\nc. Alphabet and Numeric or Special Characters (e.g., Smn29@",
                fontWeight = FontWeight.W500,
                color = Color(0xFF999999),
                fontSize = 14.sp

            )

        }
        Spacer(
            modifier = Modifier.weight(weight = 1f)

        )
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
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(),
                    onClick = onResetSuccess
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
fun ScreenResetPasswordPreview(){
    ScreenResetPassword(
        onResetSuccess = {}
    )
}