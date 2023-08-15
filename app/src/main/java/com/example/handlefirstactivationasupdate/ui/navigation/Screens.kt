package com.example.handlefirstactivationasupdate.ui.navigation

import androidx.navigation.NavController

object Screens{
    const val MainScreen: String = "mainScreenRoute"
    const val RegistrationScreen: String = "registrationScreenRoute"
    const val PurchaseScreen1: String = "PurchaseScreen1"
    const val PurchaseScreen2: String = "PurchaseScreen2"
    const val PurchaseA1: String = "A1"
    const val PurchaseA2: String = "A2"
    const val PurchaseB1: String = "B1"
    const val PurchaseB2: String = "B2"
}

fun NavController.navigateToMainScreen(){
    this.navigate(Screens.MainScreen)
}

fun NavController.navigateToRegistration(){
    this.navigate(Screens.RegistrationScreen)
}

fun NavController.navigateToPurchase1(){
    this.navigate(Screens.PurchaseScreen1)
}
fun NavController.navigateToPurchase2(){
    this.navigate(Screens.PurchaseScreen2)
}
fun NavController.toA2(){
    this.navigate(Screens.PurchaseA2)
}
fun NavController.toB2(){
    this.navigate(Screens.PurchaseB2)
}

