package com.example.demomobilebanking.ui.transfer

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object MenuTransfer : NavKey

@SuppressLint("InvalidColorHexValue")
@Composable
fun ScreenMenuTransfer(
    modifier: Modifier = Modifier,
    onTransferToOwnAccountClicked: () -> Unit,
) {

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_angle_back),
                    contentDescription = null,
                    tint = Color.White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 120.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_normal_demo),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Text(
                        text = "Transfer",
                        fontWeight = FontWeight.W700,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        modifier = Modifier
                            .padding(
                                top = 43.5.dp,
                                start = 20.dp
                            ),
                        text = "Transfer",
                        color = Color.White,
                        fontWeight = FontWeight.W700,
                        fontSize = 14.sp
                        )
                    Text(
                        modifier = Modifier
                            .padding(top = 6.dp, start = 20.dp),
                        text = "Transferring money securely and simply",
                        color = Color.White,
                        fontSize = 12.sp,
                    )
                }
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .aspectRatio(
                            ratio = 160f / 160f
                        )
                        .padding(top = 30.dp, start = 18.dp),
                    painter = painterResource(id = R.drawable.img_transfer),
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFF5F9FF))
            ){
                TransferOptionItem(
                    icon = painterResource(R.drawable.ic_transfer_toown),
                    name = "Transfer to own account",
                    onClick = onTransferToOwnAccountClicked
                )
                TransferOptionItem(
                    icon = painterResource(id = R.drawable.ic_transfer_toother),
                    name = "Transfer to other account",
                    onClick = {}
                )
                TransferOptionItem(
                    icon = painterResource(id = R.drawable.ic_bakaong_icon),
                    name = "Transfer to local bank account",
                    onClick = {}
                )
                TransferOptionItem(
                    icon = painterResource(id = R.drawable.ic_bakaong_icon),
                    name = "Transfer to Bakong wallet",
                    onClick = {}
                )
                TransferOptionItem(
                    icon = painterResource(id = R.drawable.ic_ncs),
                    name = "NCS - Send to local banks",
                    onClick = {}
                )
            }
        }
    }
}
@Composable
fun TransferOptionItem(
    icon: Painter,
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
            .clickable(
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = ripple(),
                onClick = onClick
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(vertical = 24.dp)
                .padding(start = 14.dp)

        )
        Text(
            text = name,
            color = Color.Black,
            fontWeight = FontWeight.W700,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun ScreenMenuTransferPreview() {
    ScreenMenuTransfer(
        onTransferToOwnAccountClicked = {}
    )
}
