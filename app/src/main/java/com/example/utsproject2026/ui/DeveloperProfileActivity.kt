package com.example.utsproject2026.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.utsproject2026.R
import com.example.utsproject2026.databinding.ActivityDeveloperProfileBinding

class DeveloperProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeveloperProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeveloperProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_profile)

        binding.tvDevName.text = getString(R.string.profile_name)
        binding.tvDevEmail.text = getString(R.string.profile_email)
        binding.tvDevPhone.text = "No. HP: ${getString(R.string.profile_phone)}"
        binding.tvDevNim.text = "NIM: ${getString(R.string.profile_nim)}"
        binding.tvDevProdi.text = "Program Studi: ${getString(R.string.profile_prodi)}"
        binding.tvDevDepartment.text = "Jurusan: ${getString(R.string.profile_department)}"
        binding.tvDevUniversity.text = "Perguruan Tinggi: ${getString(R.string.profile_university)}"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}