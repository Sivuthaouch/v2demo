package com.example.demomobilebanking.ui.log_in

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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
data object Login : NavKey
@Composable
fun ScreenLogIn(
    onLoginSuccessClick : () -> Unit,
    onBack : () -> Unit,
    onForgotPassword : () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        var username by remember { mutableStateOf(value = "") }
        var password by remember { mutableStateOf(value = "")}
        var passwordVisible by remember { mutableStateOf(value = false) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ){
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .clickable{

                    }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",

                    )
            }
        }
        Spacer(modifier = Modifier.height(height = 100.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_demo_blue),
            contentDescription = "IG Demo",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 200.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = {
                    newValue ->
                username = newValue
            },
            label = {Text(text = "Username")},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Red
            )
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(height = 16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {
                    newValue ->
                password = newValue
            },
            label = {Text(text = "Password")},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisible = !passwordVisible
                    }
                ) {
                    Icon(
                        painter = if (passwordVisible) painterResource(id = R.drawable.ic_eye_on)
                        else painterResource(id = R.drawable.ic_eye_off),
                        contentDescription = "Toggle Password"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(height = 8.dp))
        Text(
            modifier = Modifier
                .align(alignment = Alignment.End)
                .clickable(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    indication = ripple(),
                    onClick = onForgotPassword
                ),
            text = "Forgot your password",
        )
        Spacer(modifier = Modifier.height(height = 8.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    indication = ripple(),
                    onClick = onLoginSuccessClick
                )
                .fillMaxWidth()
                .height(height = 60.dp)
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
                text = "Log in ",
                fontWeight = FontWeight.W700,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.fillMaxWidth().height(height = 48.dp))
        Text(
            text = "By using this application you agree with Terms and Condition",
            textAlign = TextAlign.Center
        )
    }
}



@Preview(showBackground = true)
@Composable
fun ScreenLogInPreview(){
    ScreenLogIn(
        onLoginSuccessClick = {},
        onBack = {},
        onForgotPassword = {}
    )
}