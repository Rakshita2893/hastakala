package com.example.hastakalashop.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hastakalashop.databinding.FragmentAdminDashboardBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class AdminDashboardFragment : Fragment() {

    private var _binding: FragmentAdminDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminDashboardBinding.inflate(inflater, container, false)
        setupCharts()
        return binding.root
    }

    private fun setupCharts() {
        val entries = ArrayList<Entry>()
        entries.add(Entry(0f, 20000f))
        entries.add(Entry(1f, 30000f))
        entries.add(Entry(2f, 25000f))
        entries.add(Entry(3f, 40000f))
        entries.add(Entry(4f, 50000f))
        entries.add(Entry(5f, 45000f))

        val dataSet = LineDataSet(entries, "Total Sales")
        val lineData = LineData(dataSet)
        binding.lineChart.data = lineData
        binding.lineChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
