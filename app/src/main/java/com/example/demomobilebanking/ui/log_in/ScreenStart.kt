package com.example.demomobilebanking.ui.log_in

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object OnBoarding: NavKey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenStart(
    onStartLoginClick: () -> Unit,
    onEnrollmentClick : () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Spacer(modifier = Modifier.height(height = 48.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding(),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_english),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(width = 16.dp))
                Text(
                    text = "English",
                    color = colorResource(id = R.color.white)

                )
            }

            Spacer(modifier = Modifier.height(height = 120.dp))

           Icon(
               modifier = Modifier,
               painter = painterResource(id = R.drawable.ic_demo),
               contentDescription = "Demo",
               tint = Color.Unspecified

           )

            Spacer(modifier = Modifier.weight(weight = 1f))

            // Buttons

            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 59.dp)
                        .background(
                            color = colorResource(id = R.color.green),
                            shape = RoundedCornerShape(size = 16.dp)
                        )
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            },
                            indication = ripple(),
                            onClick = onStartLoginClick
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier
                            .padding(all = 16.dp),
                        painter = painterResource(id = R.drawable.ic_wallet),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Column (
                        modifier = Modifier
                            .width(width = 139.dp)
                            .padding(
                                all = 4.dp
                            )
                    ){
                        Text(
                            text = "Start Login",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.White

                        )
                        Text(
                            text = "For existing CCU mobile user",
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W400,
                            fontSize = 10.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.weight(weight = 1f))
                    Icon(
                        modifier = Modifier
                            .padding(
                                end = 10.dp
                            ),
                        painter = painterResource(id = R.drawable.ic_arrowforward),
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(height = 16.dp))

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 59.dp)
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            },
                            indication = ripple(),
                            onClick = onEnrollmentClick
                        )
                        .border(
                            border = BorderStroke(
                                width = 1.dp, color = Color.White
                            ),
                            shape = RoundedCornerShape(size = 16.dp)
                        )
                    ,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier
                            .padding(all = 16.dp),
                        painter = painterResource(id = R.drawable.ic_mobile),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Column (
                        modifier = Modifier
                            .width(width = 221.dp)
                            .padding(
                                all = 4.dp
                            )
                    ){
                        Text(
                            text = "Enrollment",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.White

                        )
                        Text(
                            text = "For existing CCU mobile saving account holder",
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W400,
                            fontSize = 10.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.weight(weight = 1f))
                    Icon(
                        modifier = Modifier
                            .padding(
                                end = 10.dp
                            ),
                        painter = painterResource(id = R.drawable.ic_arrowforward),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(height = 8.dp))

                Text(
                    text = "Don't have an account yet?",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(height = 8.dp))

                Row (
                    modifier = Modifier
                        .navigationBarsPadding()
                        .fillMaxWidth()
                        .height(height = 59.dp)
                        .border(
                            border = BorderStroke(
                                width = 1.dp, color = Color.White
                            ),
                            shape = RoundedCornerShape(size = 16.dp)
                        )
                    ,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier
                            .padding(all = 16.dp),
                        painter = painterResource(id = R.drawable.ic_mobile),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Column (
                        modifier = Modifier
                            .width(width = 209.dp)
                            .padding(
                                all = 4.dp
                            )

                    ){
                        Text(
                            text = "Opening First CCU Account",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.White

                        )
                        Text(
                            text = "For existing CCU mobile user",
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W400,
                            fontSize = 10.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.weight(weight = 1f))
                    Icon(
                        modifier = Modifier
                            .padding(
                                end = 10.dp
                            ),
                        painter = painterResource(id = R.drawable.ic_arrowforward),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun ScreenStartPreview(){
    ScreenStart(
        onStartLoginClick = {},
        onEnrollmentClick = {},
    )
}
