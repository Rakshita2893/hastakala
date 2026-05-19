package com.example.hastakalashop.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.MainActivity
import com.example.hastakalashop.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (com.example.hastakalashop.models.DataManager.validateUser(email, password)) {
                android.widget.Toast.makeText(requireContext(), "Login Successful!", android.widget.Toast.LENGTH_SHORT).show()
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finish()
            } else if (email.isEmpty() || password.isEmpty()) {
                android.widget.Toast.makeText(requireContext(), "Please fill all fields", android.widget.Toast.LENGTH_SHORT).show()
            } else {
                android.widget.Toast.makeText(requireContext(), "Invalid Credentials.", android.widget.Toast.LENGTH_LONG).show()
            }
        }

        binding.tvSignUp.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.action_login_to_signup)
        }
        
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
