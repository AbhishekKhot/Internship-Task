package com.example.internshiptask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.internshiptask.R
import com.example.internshiptask.databinding.FragmentXyPlotBinding
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.GridLabelRenderer


class XYPlotFragment : Fragment() {

    private var _binding: FragmentXyPlotBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentXyPlotBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.spFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                when (position) {
                    0 -> setUpGraph(31)
                    1 -> setUpGraph(28)
                    2 -> setUpGraph(31)
                    3 -> setUpGraph(30)
                    4 -> setUpGraph(31)
                    5 -> setUpGraph(30)
                    6 -> setUpGraph(31)
                    7 -> setUpGraph(31)
                    8 -> setUpGraph(30)
                    9 -> setUpGraph(31)
                    10 -> setUpGraph(30)
                    11 -> setUpGraph(31)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }

    private fun setUpGraph(end:Int){
        lateinit var series: LineGraphSeries<DataPoint>
        var x : Double = 0.0;  var y : Double = 0.0

        series = LineGraphSeries<DataPoint>()

        for (i in 1..end)
        {
            x += 1
            y= Math.sqrt(x)
            series.appendData(DataPoint(x,y), true, end)
        }

        val gridLabel: GridLabelRenderer = binding.idGraphView.getGridLabelRenderer()
        gridLabel.horizontalAxisTitle = "Days of the months"
        gridLabel.verticalAxisTitle = "Square root of x value"

        binding.idGraphView.title="Graph View"
        binding.idGraphView.titleColor=R.color.ap_black
        binding.idGraphView.titleTextSize= 30F
        binding.idGraphView.addSeries(series)
        binding.idGraphView.viewport.isScalable=true
        binding.idGraphView.viewport.isScrollable=true
        binding.idGraphView.viewport.setScalableY(true)
        binding.idGraphView.viewport.setScrollableY(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}