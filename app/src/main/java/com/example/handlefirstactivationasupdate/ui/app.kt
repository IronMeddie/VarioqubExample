package com.example.handlefirstactivationasupdate.ui

import android.app.Application
import android.util.Log
import com.example.handlefirstactivationasupdate.R
import com.yandex.metrica.YandexMetrica

import com.yandex.metrica.YandexMetricaConfig
import com.yandex.varioqub.appmetricaadapter.AppmetricaAdapter
import com.yandex.varioqub.config.Varioqub
import com.yandex.varioqub.config.VarioqubSettings


class app : Application(){
    override fun onCreate() {
        super.onCreate()


        // Creating an extended library configuration.
        val config = YandexMetricaConfig.newConfigBuilder("XXXXXXXXXXXXXXXXXXXXXXXXXX")
            .handleFirstActivationAsUpdate(true)
            .withLogs()
            .build()
        // Initializing the AppMetrica SDK.
        YandexMetrica.activate(this, config)
        // Automatic tracking of user activity.

        YandexMetrica.enableActivityAutoTracking(this)


        val settings = VarioqubSettings.Builder("appmetrica.XXXXX")
            .withThrottleInterval(100)
            .build()
        Varioqub.init(settings,AppmetricaAdapter(this), this)
//        Varioqub.setDefaults(R.xml.varioqub)

    }
}