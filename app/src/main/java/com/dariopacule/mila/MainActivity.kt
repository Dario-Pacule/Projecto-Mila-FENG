package com.dariopacule.mila

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.dariopacule.mila.ui.main.Config_Fragment
import com.dariopacule.mila.ui.main.LogicConfigFragment
import com.dariopacule.mila.ui.main.MainFragment
import com.dariopacule.mila.ui.main.helpFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val buttonHome: ImageButton = findViewById(R.id.buttom_home)
        val buttonConfig: ImageButton = findViewById(R.id.buttom_setings)
        val buttonLogic: ImageButton = findViewById(R.id.buttom_logic)
        val buttonHelp: ImageButton = findViewById(R.id.buttom_help)




        buttonHome.setOnClickListener {
            buttonHome.elevation = 3f
            buttonConfig.elevation = 0f
            buttonLogic.elevation = 0f
            buttonHelp.elevation = 0f

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.nav_host_fragment, MainFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commitAllowingStateLoss()
        }

        buttonConfig.setOnClickListener {
            buttonHome.elevation = 0f
            buttonConfig.elevation = 3f
            buttonLogic.elevation = 0f
            buttonHelp.elevation = 0f

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.nav_host_fragment, Config_Fragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commitAllowingStateLoss()
        }

        buttonLogic.setOnClickListener {
            buttonHome.elevation = 0f
            buttonConfig.elevation = 0f
            buttonLogic.elevation = 3f
            buttonHelp.elevation = 0f

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.nav_host_fragment, LogicConfigFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commitAllowingStateLoss()
        }

        buttonHelp.setOnClickListener {
            buttonHome.elevation = 0f
            buttonConfig.elevation = 0f
            buttonLogic.elevation = 0f
            buttonHelp.elevation = 3f

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.nav_host_fragment, helpFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commitAllowingStateLoss()
        }
    }
}