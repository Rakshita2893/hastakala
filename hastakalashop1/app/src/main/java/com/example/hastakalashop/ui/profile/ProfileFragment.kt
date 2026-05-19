package com.example.hastakalashop.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        
        setupProfile()
        
        return binding.root
    }

    private fun setupProfile() {
        // Set sample data
        binding.tvUsername.text = "Rakshita"
        binding.tvUserEmail.text = "rakshita@hastakala.com"

        // Setup click listeners
        binding.llOrders.setOnClickListener {
            // Navigate to orders (future feature)
            android.widget.Toast.makeText(context, "My Orders clicked", android.widget.Toast.LENGTH_SHORT).show()
        }

        binding.llWishlist.setOnClickListener {
            androidx.navigation.fragment.NavHostFragment.findNavController(this).navigate(com.example.hastakalashop.R.id.navigation_wishlist)
        }

        binding.llAddress.setOnClickListener {
            android.widget.Toast.makeText(context, "Shipping Address clicked", android.widget.Toast.LENGTH_SHORT).show()
        }

        binding.llSupport.setOnClickListener {
            android.widget.Toast.makeText(context, "Support clicked", android.widget.Toast.LENGTH_SHORT).show()
        }

        binding.llLogout.setOnClickListener {
            // Handle logout
            val intent = android.content.Intent(requireContext(), com.example.hastakalashop.ui.auth.AuthActivity::class.java)
            intent.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK or android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
