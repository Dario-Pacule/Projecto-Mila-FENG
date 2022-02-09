package com.dariopacule.mila.data

import com.dariopacule.mila.R
import com.dariopacule.mila.model.CondicionedConfig
import com.dariopacule.mila.model.ControlerData
import com.dariopacule.mila.model.Relatory_data

class DataSource {
    //private lateinit var condicionedConfig: MutableList<CondicionedConfig>

    fun loadControlerData(): ControlerData {

        return ControlerData(65, 96, "16:23")
    }

    fun loadRelatory(): List<Relatory_data> {
        return listOf<Relatory_data>(
            Relatory_data(
                R.drawable.ic_time,
                "Irrigação Padrão",
                "25.12.2021",
                "12:23",
                "15 min"
            ),
            Relatory_data(
                R.drawable.ic_outline_settings_ethernet_80,
                "Irrigação Programada",
                "25.12.2021",
                "12:23",
                "15 min"
            ),
            Relatory_data(
                R.drawable.ic_time,
                "Irrigação Programada",
                "02.01.2021",
                "06:23",
                "9 min"
            ),
            Relatory_data(
                R.drawable.ic_time,
                "Irrigação Programada",
                "02.01.2021",
                "06:23",
                "9 min"
            ),
            Relatory_data(
                R.drawable.ic_time,
                "Irrigação Programada",
                "02.01.2021",
                "06:23",
                "9 min"
            )
        )
    }

    fun loadCondicionedConfig(): List<CondicionedConfig> {
        return listOf<CondicionedConfig>(
            CondicionedConfig("Temperatura", 15f, "Irrigar"),
            CondicionedConfig("Humidade", 16f, "Irrigar"),
            CondicionedConfig("Temperatura", 13f, "Irrigar"),
            CondicionedConfig("Humidade", 15.9f, "Irrigar"),
            CondicionedConfig("Temperatura", 8f, "Irrigar")
        )

    }

}