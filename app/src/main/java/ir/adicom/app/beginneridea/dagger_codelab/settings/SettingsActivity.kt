/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ir.adicom.app.beginneridea.dagger_codelab.settings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.dagger_codelab.MyApplication
import ir.adicom.app.beginneridea.dagger_codelab.login.LoginActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_dagger)

        val userManager = (application as MyApplication).userManager

        settingsViewModel = SettingsViewModel(userManager.userDataRepository!!, userManager)
        setupViews()
    }

    private fun setupViews() {
        findViewById<Button>(R.id.refresh).setOnClickListener {
            settingsViewModel.refreshNotifications()
        }
        findViewById<Button>(R.id.logout).setOnClickListener {
            settingsViewModel.logout()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
