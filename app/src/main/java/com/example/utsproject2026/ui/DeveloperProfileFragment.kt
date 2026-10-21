package com.example.utsproject2026.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.utsproject2026.R
import com.example.utsproject2026.databinding.FragmentDeveloperProfileBinding

class DeveloperProfileFragment : Fragment() {

    private var _binding: FragmentDeveloperProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeveloperProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvDevName.text = getString(R.string.profile_name)
        binding.tvDevEmail.text = getString(R.string.profile_email)
        binding.tvDevPhone.text = "No. HP: ${getString(R.string.profile_phone)}"
        binding.tvDevNim.text = "NIM: ${getString(R.string.profile_nim)}"
        binding.tvDevProdi.text = "Program Studi: ${getString(R.string.profile_prodi)}"
        binding.tvDevDepartment.text = "Jurusan: ${getString(R.string.profile_department)}"
        binding.tvDevUniversity.text = "Perguruan Tinggi: ${getString(R.string.profile_university)}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}