package com.example.bankingapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import com.example.bankingapp.model.BottomNavigation

val items = listOf(
BottomNavigation("Home",Icons.Rounded.Home),
BottomNavigation("Wallet",Icons.Rounded.Wallet),
BottomNavigation("Notification",Icons.Rounded.Notifications),
BottomNavigation("Account",Icons.Rounded.AccountCircle),
)