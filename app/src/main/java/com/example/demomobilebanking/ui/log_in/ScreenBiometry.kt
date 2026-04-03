package com.example.demomobilebanking.ui.log_in

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
data object FaceID : NavKey

@Composable
fun ScreenBiometry(
    onFaceIDCompleted : () -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(height = 240.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_face_id),
            contentDescription = "Face ID",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(height = 48.dp))
        Text(
            text = "Do you want to use FaceID to login to application?",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W700,
            fontSize = 18.sp,
            modifier = Modifier.padding(
                bottom = 40.dp,
            ),
            color = Color.Black

        )

        Text(
            text = "Biometric login is a convinient and secure way to authenticate",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(
                bottom = 40.dp,
            ),
            color = Color.Black

        )
        Spacer(modifier = Modifier.height(height = 36.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
        ){
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(size = 16.dp),
                border = BorderStroke(width = 1.dp, Color.Blue),
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp
                    )
                    .weight(weight = 1f)
                    .height(height = 64.dp)
            ) {
                Text(text = "Not Now")
            }
            Button(
                onClick = {
                    onFaceIDCompleted()
                },
                shape = RoundedCornerShape(size = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp
                    )
                    .weight(weight = 1f)
                    .height(height = 64.dp)
            ) {
                Text(text = "Yes")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ScreenBiometryPreview(){
    ScreenBiometry(
        onFaceIDCompleted = {}
    )
}