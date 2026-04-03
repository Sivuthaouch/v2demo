package com.example.demomobilebanking.ui.transfer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.Account
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object TransferToOwnAccount : NavKey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTransferToOwnAccount(
    modifier: Modifier = Modifier,
    onTransferSuccess : () -> Unit
) {
    var showSheet by remember { mutableStateOf(value = false) }
    rememberScrollState()
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_angle_back),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(vertical = 14.dp)
                        .padding(start = 16.dp)
                )
                Text(
                    text = "Transfer to own account",
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 72.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_transfer_big),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(150.dp)


                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                           ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SelectAccountField()
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .clickable(
                                    interactionSource = remember {
                                        MutableInteractionSource()
                                    },
                                    indication = ripple(),
                                    onClick = { showSheet = true }
                                ),
                            shape = RoundedCornerShape(size = 10.dp),
                            value = "",
                            onValueChange = {

                            },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_wallet),
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(
                                    text = "Transfer to"
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrowdown),
                                    contentDescription = null
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            enabled = false
                        )
                        if (showSheet) {
                            AccountBottomSheet(
                                onDismissRequest = {
                                    showSheet = false
                                },
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            shape = RoundedCornerShape(size = 10.dp),
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_currency_dollar__1_),
                                    contentDescription = null
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            enabled = true,
                            label = {
                                Text(
                                    text = "Amount"
                                )
                            }
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            shape = RoundedCornerShape(size = 10.dp),
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_pencil_simple_line),
                                    contentDescription = null
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            enabled = true,
                            label = {
                                Text(
                                    text = "Remark (optional)"
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrowdown),
                                    contentDescription = null
                                )
                            }
                        )
                        Text(
                            text = "Summary",
                            color = Color(0xFF999999),
                            fontWeight = FontWeight.W500,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(all = 16.dp)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 16.dp)
                                .background(
                                    color = Color(0xFFF5F5F5),
                                    shape = RoundedCornerShape(size = 6.dp)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                            ) {
                                Text(
                                    text = "Transfer Amount:"
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "--"
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .padding(top = 8.dp)
                            ) {
                                Text(
                                    text = "Amount to Receive:"
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "--"
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            HorizontalDivider(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp)
                                    .padding(horizontal = 16.dp)

                            ) {
                                Text(
                                    text = "Debit Amount:",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W500,
                                    color = Color(0xFF999999)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "--"
                                )
                            }
                        }
                    }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp)
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            },
                            indication = ripple(),
                            onClick = onTransferSuccess
                        )
                        .navigationBarsPadding()
                        .height(height = 60.dp)
                        .background(
                            shape = RoundedCornerShape(size = 16.dp),
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF1A6FFF),
                                    Color(0xFF002F80)
                                )
                            )
                        )
                ){
                    Text(
                        text = "Transfer",
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectAccountField(
    modifier: Modifier = Modifier,
){
    var showSheet by remember { mutableStateOf(value = false) }
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    indication = ripple(),
                    onClick = { showSheet = true}
                )
                ,
            shape = RoundedCornerShape(size = 10.dp),
            value = "",
            onValueChange = {

            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id =R.drawable.ic_wallet),
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "Select your account"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrowdown),
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            enabled = false
        )

        if (showSheet){
            AccountBottomSheet(
                onDismissRequest = {
                    showSheet = false
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    val accountList = listOf(
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Savings Account", labelColor = Color(0xFF004CCC)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Indiviual Internet Banking",labelColor = Color(0xFFFF1477)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
        Account(id = "001", name = "HEAN CHANTREA", accountNumber = "001 001 111", accountBalance = "200.00 USD", accountType = "Mobile Fixed Deposit",labelColor = Color(0xFFFFBD14)),
    )
    ModalBottomSheet(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = modifier
                .background(
                    color = Color(0xFFF5F9FF),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(14.dp))
            Box(
                modifier = Modifier
                    .width(34.dp)
                    .height(3.dp)
                    .background(
                        color = Color(0xFF999999)
                    )
            )

            Text(
                text = "Select your account",
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 32.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(count = accountList.size) { index ->
                    val account = accountList[index]

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                            .height(
                                intrinsicSize = IntrinsicSize.Max
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .width(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(weight = 1f)
                                    .background(
                                        color = Color(0xFFE5E5E5),
                                        shape = RoundedCornerShape(topStart = 8.dp)
                                    )
                                    .fillMaxWidth()

                            )
                            Box(
                                modifier = Modifier
                                    .weight(0.5f)
                                    .background(
                                        color = account.labelColor,
                                        shape = RoundedCornerShape(bottomStart = 8.dp)
                                    )
                                    .fillMaxWidth()
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = 8.dp
                                )
                                .padding(start = 12.dp)
                        ) {
                            Text(
                                text = account.name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                color = Color.Blue,
                                modifier = Modifier
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = account.accountNumber,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W400,
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                )
                                Text(
                                    text = account.accountBalance,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W400,
                                    color = Color.Blue,
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                )
                            }
                            Text(
                                text = account.accountType,
                                modifier = Modifier
                                    .background(
                                        color = account.labelColor,
                                        shape = RoundedCornerShape(size = 4.dp)
                                    )
                                    .padding(vertical = 4.dp)
                                    .padding(horizontal = 6.dp),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun ScreenTransferToOwnAccountPreview () {
    ScreenTransferToOwnAccount(
        onTransferSuccess = {}
    )
}