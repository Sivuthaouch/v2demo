package com.example.demomobilebanking.ui.log_in

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
data object SetPIN : NavKey
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSetPin(
    completedSetPIN : () -> Unit
){
    var pin by remember {mutableStateOf(value = "")}
    var navigated by remember { mutableStateOf(value = false) }
    LaunchedEffect(key1 = pin) {
        if (pin.length == 4 && !navigated){
            navigated = true
            completedSetPIN()
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(height = 14.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",

            )
        }
        Spacer(modifier = Modifier.height(height = 30.dp))
        Text(
            text = "Set a PIN for quick access to the application",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W700,
            fontSize = 18.sp,
            modifier = Modifier.padding(
                bottom = 40.dp,
            ),
            color = Color.Black

        )
        Spacer(modifier = Modifier.height(height = 66.dp))

        Row (
            horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
            modifier = Modifier.padding(bottom = 40.dp)
        ){
            repeat(times = 4){
                index ->
                val filled = index < pin.length

                Box(
                    modifier = Modifier
                        .size(size = 16.dp)
                        .clip(CircleShape)
                        .background(
                            color = if(filled) Color(color = 0xFF253B84) else
                            Color(color = 0xFFEAEAEA)
                        )
                )
            }
        }
        Spacer(modifier = Modifier.height(height = 66.dp))

        val buttons = listOf(
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "", "0", "del"
        )
        Column (
            verticalArrangement = Arrangement.spacedBy(space = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            buttons.chunked(size = 3).forEach {
                row ->
                Row (
                    horizontalArrangement = Arrangement.spacedBy(space = 40.dp)
                ){
                    row.forEach { label ->
                        when (label) {
                            "del" -> {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_delete_text),
                                    contentDescription = "Delete",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(size = 66.dp)
                                        .clip(CircleShape)
                                        .clickable{
                                            if (pin.isNotEmpty()){
                                                pin= pin.dropLast(n = 1)
                                            }
                                        }
                                        .padding(all = 16.dp)
                                )
                            }
                            " " -> {
                                Spacer(modifier = Modifier.size(size = 16.dp))
                            }
                            else -> {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(size = 66.dp)
                                        .clip(CircleShape)
                                        .background(Color(color = 0xFFF5F5F5))
                                        .clickable{
                                            if (pin.length<4){
                                                pin += label
                                            }
                                        }
                                ){
                                    Text(
                                        text = label,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(height = 16.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Forget PIN?",
                fontSize = 14.sp,
                color = Color(color = 0xFF203B8F),
                fontWeight = FontWeight.W500,
                modifier = Modifier.clickable{}
            )
            Spacer(modifier = Modifier.height(height = 32.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenSetPINPreview(){
    ScreenSetPin(
        completedSetPIN = {}
    )
}