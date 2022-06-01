package com.example.internshiptask.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter
import com.example.internshiptask.databinding.FragmentPieChartBinding

class PieChartFragment : Fragment() {

    private var _binding: FragmentPieChartBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPieChartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pieChart=binding.pieChart

        pieChart.addSegment(Segment("one",40), SegmentFormatter(Color.RED))
        pieChart.addSegment(Segment("two",30), SegmentFormatter(Color.GREEN))
        pieChart.addSegment(Segment("three",20), SegmentFormatter(Color.BLUE))
        pieChart.addSegment(Segment("four",10), SegmentFormatter(Color.YELLOW))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}