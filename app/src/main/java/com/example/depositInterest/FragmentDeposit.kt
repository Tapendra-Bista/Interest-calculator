package com.example.depositInterest
import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.depositInterest.databinding.FragmentDepositBinding
import java.util.Locale


class FragmentDeposit : Fragment() {
    private  var binding:FragmentDepositBinding?= null
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDepositBinding.inflate(layoutInflater)
        val view = binding?.root
        binding?.btn?.setOnClickListener {
            val da = binding?.rupeesid?.text.toString().toDouble()
            val ir = binding?.irateid?.text.toString().toDouble()
            val mths = binding?.mothsid?.text.toString().toDouble()

// String.format("%.2f",).toDouble()

            binding?.pppriceid?.text = "Rs. ${
                NumberFormat.getInstance(Locale("en", "IN")).format( String.format("%.2f",da).toDouble()
                )}"
            val ir2 = da.times(ir).times(mths / 12).div(100)
            binding?.irpriceid?.text = "Rs. ${NumberFormat.getInstance(Locale("en", "IN")).format(
                String.format("%.2f",ir2).toDouble())
    }"
            val tax = ir2.times(5).div(100)
            binding?.tapriceid?.text = "Rs. ${NumberFormat.getInstance(Locale("en", "IN")).format( String.format("%.2f",tax).toDouble())}"
         val xx = da.plus(ir2).minus(tax)
            binding?.tarpriceid?.text = "Rs. ${NumberFormat.getInstance(Locale("en", "IN")).format(String.format("%.2f",xx).toDouble())}"
        }

        val spinner: Spinner = binding!!.spinnerid
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.depositTypeList,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)

            spinner.adapter = adapter
        }

        binding?.rupeesid?.addTextChangedListener(textWatcher())
        binding?.irateid?.addTextChangedListener(textWatcher())
        binding?.mothsid?.addTextChangedListener(textWatcher())
        return  view
    }

    private fun textWatcher() = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (binding?.rupeesid?.text.toString().isNotEmpty() && binding?.irateid?.text.toString()
                    .isNotEmpty() && binding?.mothsid?.text.toString().isNotEmpty()
            ) binding?.btn?.isEnabled = true
        }
        override fun afterTextChanged(p0: Editable?) {

        }
    }
}