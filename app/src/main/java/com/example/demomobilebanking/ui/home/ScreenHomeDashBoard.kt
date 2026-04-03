package com.example.demomobilebanking.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.example.demomobilebanking.Brand
import com.example.demomobilebanking.Contact
import com.example.demomobilebanking.DashBoardModel
import com.example.demomobilebanking.Promotion
import com.example.demomobilebanking.R
import kotlinx.serialization.Serializable

@Serializable
data object DashBoard: NavKey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHomeDashBoard(
    modifier: Modifier = Modifier,
    onTransferClicked : (DashBoardModel) -> Unit
    ){
    var showSheet by remember { mutableStateOf(value = false) }
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        LazyColumn(
            contentPadding = WindowInsets.systemBars.asPaddingValues(),
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                MainCard()
            }
            item {
                DashBoardMenu(
                    onTransferClicked = onTransferClicked
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Recent Transaction",
                        fontWeight = FontWeight.W700,
                        fontSize = 16.sp,
                        color = Color(0xFFF5F9FF)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "View All",
                            color = Color(0xFFF5F9FF),
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrowforward),
                            contentDescription = null,
                            tint = Color(0xFFF5F9FF)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                RecentTransaction(
                    contacts = listOf(
                        Contact(initials = "HC", name = "Hean C...", Color(0xFF2D9CDB)),
                        Contact("SS", "Sok Sok...", Color(0xFFFF2D7A)),
                        Contact("DK", "Dy Kosal", Color(0xFFFFB800)),
                        Contact("SP", "Seng Ph...", Color(0xFF6C2DFF)),
                        Contact("LK", "Leang K...", Color(0xFF2DB7D8)),
                        Contact("J", "Jack", Color(0xFF2DB7D8))
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Explore Services",
                        fontWeight = FontWeight.W700,
                        fontSize = 16.sp,
                        color = Color(0xFFF5F9FF)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "View All",
                            color = Color(0xFFF5F9FF),
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrowforward),
                            contentDescription = null,
                            tint = Color(0xFFF5F9FF)
                        )
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))
                ExploreService()
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Promotion",
                        fontWeight = FontWeight.W700,
                        fontSize = 16.sp,
                        color = Color(0xFFF5F9FF)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_option),
                        contentDescription = "option",
                        tint = Color.Unspecified
                    )

                }
                Spacer(modifier = Modifier.height(16.dp))
                Promotion()
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "News And Offer",
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    color = Color(0xFFF5F9FF)
                )
                Spacer(modifier = Modifier.height(16.dp))
                NewAndOffer()
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Appearance",
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    color = Color(0xFFF5F9FF)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Appearance(
                    onCustomizeClick = {
                        showSheet = true
                    }
                )
                if (showSheet){
                    ModalBottomSheet(
                        onDismissRequest = { showSheet = false},
                        dragHandle = {

                        }
                    ) {
                        AppearanceBottomSheet()
                    }
                }

            }

        }
    }
}

@Composable
fun DashBoardMenu(
    modifier: Modifier = Modifier,
    onTransferClicked: (DashBoardModel) -> Unit
){
    val items = remember {
        mutableStateListOf(
            DashBoardModel(
                id = "001",
                label = "Account",
                iconRes = R.drawable.ic_account
            ),
            DashBoardModel(
                id = "002",
                label = "Transfer",
                iconRes = R.drawable.ic_transfer
            ),
            DashBoardModel(
                id = "003",
                label = "Payment",
                iconRes = R.drawable.ic_payment
            ),
            DashBoardModel(
                id = "004",
                label = "Deposit",
                iconRes = R.drawable.ic_deposit
            ), DashBoardModel(
                id = "005",
                label = "Loan",
                iconRes = R.drawable.ic_loan
            ), DashBoardModel(
                id = "006",
                label = "Card",
                iconRes = R.drawable.ic_card
            ),
        )
    }
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items.chunked(size = 3).forEach { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { item ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .then(
                                other = if (item.label == "Transfer") {
                                    Modifier.clickable(
                                        interactionSource = remember {
                                            MutableInteractionSource()
                                        },
                                        indication = ripple(),
                                        onClick = { onTransferClicked(item) }
                                    )
                                } else {
                                    Modifier
                                }
                            )
                            .aspectRatio(ratio = 1f)
                            .border(
                                border = BorderStroke(
                                    width = 1.dp, color = Color.White
                                ),
                                shape = RoundedCornerShape(size = 20.dp)
                            )
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.iconRes),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .padding(horizontal = 28.17.dp)
                                .padding(top = 16.dp)
                                .size(
                                    size = 50.dp
                                )
                        )
                        Text(
                            modifier = Modifier.padding(top = 6.dp),
                            text = item.label,
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Color(0xFFF5F9FF),
                            )
                    }
                }
            }
        }
    }
}
@Composable
fun MainCard (){
    Box(
        modifier = Modifier
    ){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
                .height(150.dp)
                .border(
                    border = BorderStroke(
                        width = 1.dp, color = Color.White
                    ),
                    shape = RoundedCornerShape(size = 20.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_small_demo),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier.padding(),
                    painter = painterResource(id = R.drawable.ic_phone_call),
                    contentDescription = "phone",
                    tint = Color.Unspecified
                )
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.ic_bakong),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier= Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(horizontal = 16.dp),
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Row(
                        modifier = Modifier
                            .height(24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total Available Balance",
                            fontWeight = FontWeight.W500,
                            fontSize = 12.sp,
                            color = Color(0xFFF5F9FF),
                        )
                        Icon(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .border(
                                    border = BorderStroke(
                                        width = 1.dp, Color.White
                                    ),
                                    shape = RoundedCornerShape(4.dp)
                                ),
                            painter = painterResource(R.drawable.ic_showicon),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.ic_riel),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "250,200.00",
                            fontWeight = FontWeight.W700,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 6.dp)
                        )
                    }
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.ic_currency_dollar),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "250,200.00",
                            fontWeight = FontWeight.W700,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 6.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                SimpleDonutChart(
                    values = listOf(3000f, 3000f),
                    colors = listOf(Color(0xFFFF1477), Color(0xFFFFBD14))
                )
            }
        }
    }
}

@Composable
fun SimpleDonutChart(
    values: List<Float>,
    colors: List<Color>,
    modifier: Modifier = Modifier
) {
    val total = values.sum()

    Canvas(
        modifier = modifier.size(50.dp)
    ) {
        var startAngle = -90f

        values.forEachIndexed { index, value ->
            val sweepAngle = (value / total) * 360f

            drawArc(
                color = colors[index],
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(
                    width = 20f, // thickness
                    cap = StrokeCap.Round // smooth edges
                )
            )

            startAngle += sweepAngle
        }
    }
}

@Composable
fun RecentTransaction(
    contacts: List<Contact>
){
    Box(
        modifier = Modifier
            .height(97.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(
                    width = 1.dp, color = Color.White
                ),
                shape = RoundedCornerShape(size = 20.dp)
            )
    ){
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(count = contacts.size) { index ->
                val contact = contacts[index]

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 14.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(contact.color),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = contact.initials,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = contact.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun ExploreService(){
    val brands = listOf(
        Brand(id = "001", name = "VET Express", iconRes = R.drawable.img_vet),
        Brand(id = "002", name = "Smart Axiata", iconRes = R.drawable.img_smart),
        Brand(id = "003", name = "Louis Vuitton", iconRes = R.drawable.img_lv),
        Brand(id = "004", name = "Christian Dior", iconRes = R.drawable.img_dior),
        Brand(id = "005", name = "VET Express", iconRes = R.drawable.ic_check_circle),
        Brand(id = "006", name = "VET Express", iconRes = R.drawable.ic_check_circle),
        Brand(id = "007", name = "VET Express", iconRes = R.drawable.ic_check_circle),

    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp, color = Color.White

                ),
                shape = RoundedCornerShape(size = 20.dp)
            )
    ){
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(count = brands.size){ index ->
               val  brand = brands[index]

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(top = 14.dp, bottom = 14.dp)
                        .width(60.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                    ){
                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = brand.iconRes),
                            contentDescription = null
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = brand.name,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
fun Promotion(){
    val promotions = listOf(
        Promotion(id = "001", img = R.drawable.img_promotion),
        Promotion(id = "001", img = R.drawable.img_promotion),
        Promotion(id = "001", img = R.drawable.img_promotion),
        Promotion(id = "001", img = R.drawable.img_promotion),
        Promotion(id = "001", img = R.drawable.img_promotion),
        Promotion(id = "001", img = R.drawable.img_promotion),
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(count = promotions.size){ index ->
            val promotion = promotions[index]

            Box(
                modifier = Modifier
                    .height(104.dp)
                    .width(104.dp)
            ){
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = promotion.img),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun NewAndOffer(){
    val pagerState = rememberPagerState(pageCount = { 4 })
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(
                ratio = 343f / 124f
            )
    ){
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(
                horizontal = 16.dp
            ),
            modifier = Modifier
                .fillMaxSize()
        ) { _ ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.img_new),
                contentDescription = null
            )
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(times = pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(all = 2.dp)
                        .clip(CircleShape)
                        .background(
                            color
                        )
                        .size(4.dp)
                )
            }
        }

        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Appearance (
    onCustomizeClick : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp, color = Color.White
                ),
                shape = RoundedCornerShape(size = 20.dp)
            )
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 22.dp,
                    end = 18.dp
                )
                .padding(top = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_apearance),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(
                        ratio = 120f / 104.5f
                    )
                    .weight(weight = 1f)
            )
            Row(
                modifier = Modifier
                    .weight(weight = 1.5f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_text),
                    contentDescription = null,
                    modifier = Modifier
                        .size(
                            height = 69.dp,
                            width = 63.dp
                        )
                        .padding(
                            top = 16.dp
                        )
                        .weight(1f)
                )
                Box (
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .border(
                            border = BorderStroke(
                                width = 1.dp, color = Color.White
                            ),
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                        .weight(1f)
                        .clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            },
                            indication = ripple(),
                            onClick = onCustomizeClick
                        )
                ){
                    Text(
                        modifier = Modifier.padding(
                            top = 8.dp,
                            start = 16.dp,
                            bottom = 8.dp,
                            end = 16.dp
                        ),
                        text = "Customize",
                        color = Color.White
                    )
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppearanceBottomSheet() {
    var checked by remember { mutableStateOf(value = true) }
    Column(
        modifier = Modifier
            .background(
                color = Color(0xFFF5F9FF),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(354.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Text(
            text = "Appearance",
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(all = 16.dp)
        )
        Row(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .padding(all = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(35.5.dp, alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_defult_theme),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        width = 53.dp,
                        height = 121.dp
                    )
            )
            Image(
                painter = painterResource(R.drawable.img_angkor_theme),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        width = 53.dp,
                        height = 121.dp
                    )
            )
            Image(
                painter = painterResource(R.drawable.img_golden_theme),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        width = 53.dp,
                        height = 121.dp
                    )
            )
            Image(
                painter = painterResource(R.drawable.img_chinese_theme),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        width = 53.dp,
                        height = 121.dp
                    )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .padding()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_text_aa),
                    contentDescription = null,
                    tint = Color.Unspecified,

                )
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    text = "Text Size"
                )
            }
            Icon(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(end = 16.dp)

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .padding()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_nav_history),
                    contentDescription = null,
                    tint = Color.Unspecified,

                    )
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    text = "Recent Transaction"
                )
            }
            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color.Blue,
                    uncheckedThumbColor = Color.White,
                    checkedBorderColor = Color.Transparent,
                    uncheckedBorderColor = Color.Transparent

                ),
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenHomeDashBoardPreview(){
    ScreenHomeDashBoard(
        onTransferClicked = { _ -> }
    )
}