package com.example.youtubeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.youtubeui.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Allfun()
        }
    }
}

@Preview
@Composable
fun Allfun(){
    Column{
        UITube()
        Chipsection(chips = listOf("All","Gojo","Game","CS","Android","Development","DBZ","Death Note","Haikyuu!!"))
        ContentBox(title = listOf("Total Fool","Real Gamble","Crazy Fart","Real Toddler","Leave it now","Antique455","Total Conquest 35","Egg Burji"))
        BottomButton()
    }
}


@Composable
fun UITube(){

    val fontFamily = FontFamily(
        Font(R.font.bebasneue_regular,FontWeight.Bold)
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
//        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.padding(start = 10.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_vectorytube),
                    contentDescription = "This is the null utube UI",
                    modifier = Modifier.size(40.dp,27.dp)
                )
                Text(text = "UITube", color = Color.White, modifier = Modifier.padding(start = 10.dp),fontFamily = fontFamily,fontWeight = FontWeight.Bold,fontSize = 24.sp)
            }
        }

        Box{
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_baseline_cast_24), contentDescription = "Lets do some casting",modifier = Modifier.padding(start = 10.dp,end = 10.dp))
                Image(painter = painterResource(id = R.drawable.ic_baseline_notifications_24), contentDescription = "Notification",modifier = Modifier.padding(start = 10.dp,end = 10.dp))
                Image(painter = painterResource(id = R.drawable.ic_baseline_search_24), contentDescription = "Search",modifier = Modifier.padding(start = 10.dp,end = 10.dp))
                Image(painter = painterResource(id = R.drawable.ic_twotone_account_circle_24), contentDescription = "Search",modifier = Modifier.padding(start = 10.dp,end = 10.dp))
            }
        }
    }
}

@Composable
fun Chipsection(chips: List<String>) {
    var selectedChipindex by remember {
        mutableStateOf(0)
    }
    val scrollState = rememberScrollState()

    Row(modifier = Modifier.verticalScroll(scrollState)) {

        Box(modifier = Modifier
            .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 10.dp)
            .clickable { }
            .background(Color.DarkGray)
            .clip(RoundedCornerShape(4.dp))
            .padding(5.dp)
        )
            {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_twotone_explore_24), contentDescription = "Explore")
                Text(text = "Explore",color = Color.White)
            }
        }

        LazyRow{
            items(chips.size){
                Box(modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp, end = 5.dp)
                    .clickable {
                        selectedChipindex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipindex == it) Color.LightGray
                        else Color.DarkGray
                    )
                    .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
                ){
                    Text(text = chips[it], color = Color.White,fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
fun ContentBox(title: List<String>){
    //state for click
    var selectbox by remember{
        mutableStateOf(0)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.87f)
    ){
        items(title.size){
            Box(modifier = Modifier
                .clickable {
                    selectbox = it
                }
                .background(
                    if (selectbox == it) Color.LightGray
                    else Color.DarkGray
                )
            ) {
                Column() {
                    Image(painter = painterResource(id = R.drawable.imagen), contentDescription = "Repeat this no logo thing")
                    Box(modifier = Modifier
                        .background(color = Color.DarkGray)
                        .fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Row() {
                                Image(painter = painterResource(id = R.drawable.ic_baseline_account_circle_24), contentDescription = "logo of the person",Modifier.width(35.dp))
                                Text(text = title[it],color = Color.LightGray,fontSize = 20.sp,modifier = Modifier.padding(start = 5.dp))
                            }
                            Row(){
                                Like()
                                Image(painter = painterResource(id = R.drawable.ic_baseline_view_headline_24), contentDescription = "menu",modifier = Modifier.padding(start = 5.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Like(){
    var i by remember {
        mutableStateOf(0)
    }
    var j by remember {
        mutableStateOf(0)
    }
    @DrawableRes val paint1 = R.drawable.ic_outline_thumb_down_alt_24
    @DrawableRes val pain1 = R.drawable.ic_baseline_thumb_down_alt_24
    @DrawableRes val paint2 = R.drawable.ic_outline_thumb_up_alt_24
    @DrawableRes val pain2 = R.drawable.ic_baseline_thumb_up_alt_24


    Box(Modifier.clickable { if(i == 0
    )i = 1 else i = 0}) {
        if (i == 0){
            Image(painter = painterResource(id = paint1), contentDescription = "thumb down", Modifier.padding(start = 10.dp))
        }
        else{
            Image(painter = painterResource(id = pain1), contentDescription = "thumb downed", Modifier.padding(start = 10.dp))
        }

    }
    Box(
        Modifier
            .clickable {
                if (j == 0
                ) j = 1 else j = 0
            }
            .padding(start = 10.dp)) {
        if (j == 0){
            Image(painter = painterResource(id = paint2), contentDescription = "thumb down", Modifier.padding(start = 10.dp))
        }
        else{
            Image(painter = painterResource(id = pain2), contentDescription = "thumb downed", Modifier.padding(start = 10.dp))
        }

    }
}



@Composable
fun BottomButton(){
    BottomMenu(items = listOf(
        BottomMenuContent("Home", R.drawable.ic_outline_home_24),
        BottomMenuContent("Shorts", R.drawable.ic_baseline_play_circle_filled_24),
        BottomMenuContent("Create", R.drawable.ic_baseline_add_circle_24),
        BottomMenuContent("Subscription", R.drawable.ic_baseline_video_library_24),
        BottomMenuContent("Library", R.drawable.ic_baseline_video_settings_24),
    ))
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = LightRed,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(bg)
            .padding(10.dp)
            .height(60.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = LightRed,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.draw),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}