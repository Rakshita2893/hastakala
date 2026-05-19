package com.example.hastakalashop.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.btnSignUp.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val phone = binding.etPhone.text.toString()
            val password = binding.etPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty()) {
                val newUser = com.example.hastakalashop.models.User(
                    uid = java.util.UUID.randomUUID().toString(),
                    name = name,
                    email = email,
                    phone = phone
                )
                com.example.hastakalashop.models.DataManager.addUser(newUser, password)
                
                android.widget.Toast.makeText(requireContext(), "Account Created! Please Login", android.widget.Toast.LENGTH_SHORT).show()
                androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.action_signup_to_login)
            } else {
                android.widget.Toast.makeText(requireContext(), "Please fill all fields", android.widget.Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvLogin.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.action_signup_to_login)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
