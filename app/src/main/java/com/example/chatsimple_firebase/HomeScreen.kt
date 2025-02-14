package com.example.chatsimple_firebase

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(navController: NavController){
    var list = mutableListOf<User>()
    list.add(User("abc@gmail.com","123456","Hoang Tien"))
    list.add(User("xyz@gmail.com","654321","Tien Hoang"))

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Danh sách")},
                actions = {
                    IconButton(
                        onClick = { },
                    ){
                        Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "", tint = Color.White)
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if(list.count() > 0){
                items(list){
                    CardInfo(user = it)
                }
            }
            else{
                item{ Text(text = "Không có danh sách")}
            }
        }
    }
}