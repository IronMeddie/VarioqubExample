package com.example.handlefirstactivationasupdate.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.handlefirstactivationasupdate.ui.screens.main.MainScreen
import com.example.handlefirstactivationasupdate.ui.screens.purchase.Purchase_A1
import com.yandex.varioqub.config.Varioqub

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MainScreen) {
        composable(route = Screens.MainScreen) {
            MainScreen(){
                val flag = Varioqub.getString("PurchaseVariant", "first")  // получаем флаг какой из вариантов показывать
                Log.d("VARIOQUB flag buttonPosition ", flag)
                when(flag){
                    "first" -> {navController.navigateToPurchase1()} // переносим пользователя на нужный экран в зависимости от флага
                    "second" -> {navController.navigateToPurchase2()}
                }
            }
        }


        composable(Screens.RegistrationScreen) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "this is the RegistrationScreen")
            }
        }


        navigation(startDestination = Screens.PurchaseA1, route = Screens.PurchaseScreen1) {// есть две вложенные навигации по экранам оплаты
            composable(route = Screens.PurchaseA1) {                                         // будет показываться одна из них в зависимости от полученого флага Varioqub
                Purchase_A1 {
                    navController.toA2()
                }
            }
            composable(route = Screens.PurchaseA2) {
                Purchase_A1 {
                    navController.navigateToMainScreen()
                }
            }

        }
        navigation(startDestination = Screens.PurchaseB1, route = Screens.PurchaseScreen2) {// есть две вложенные навигации по экранам оплаты
            composable(route = Screens.PurchaseA1) {
                Purchase_A1 {
                    navController.toB2()
                }
            }
            composable(route = Screens.PurchaseB2) {
                Purchase_A1 {
                    navController.navigateToMainScreen()
                }
            }
        }


    }

}