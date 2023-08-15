package com.example.handlefirstactivationasupdate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.handlefirstactivationasupdate.ui.navigation.MainNavHost
import com.example.handlefirstactivationasupdate.ui.theme.HandleFirstActivationAsUpdateTheme
import com.yandex.metrica.YandexMetrica
import com.yandex.varioqub.config.FetchError
import com.yandex.varioqub.config.OnFetchCompleteListener
import com.yandex.varioqub.config.Varioqub


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        fetch()  // обновляем флаги из Varioqub при старте приложения.
        // в приложении будет навигация на различные экраны в зависимотсти от полученого флага
        //

        YandexMetrica.reportEvent("wrongDateTime")
        setContent {
            HandleFirstActivationAsUpdateTheme {
                MainNavHost()
            }
        }
    }

    private fun fetch() {
        Varioqub.fetchConfig(object : OnFetchCompleteListener {
            override fun onSuccess() {
                Log.i("VARIOQUB", "FETCH SUCCESS")
            }

            override fun onError(message: String, error: FetchError) {
                Log.i("VARIOQUB", "FETCH ERROR: $message")
                YandexMetrica.reportError("VARIOQUB FETCH ERROR:", message)
            }
        })
        Varioqub.activateConfig()
    }
}




