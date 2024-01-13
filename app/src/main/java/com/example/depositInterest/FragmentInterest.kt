package com.example.depositInterest
import android.annotation.SuppressLint
import android.icu.text.NumberFormat
import android.text.Editable
import android.text.TextWatcher
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.depositInterest.databinding.FragmentInterestBinding
import java.util.Locale


class FragmentInterest : Fragment() {
    private  var binding:FragmentInterestBinding?= null
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentInterestBinding.inflate(layoutInflater)
        val view = binding?.root
        binding?.btn?.setOnClickListener {

            val p= binding?.rupeesid?.text.toString().toDouble()
            val peryear = binding?.irateid?.text.toString().toDouble()
            val n = binding?.mothsid?.text.toString().toDouble()
            val r = (peryear/100/12)

            binding?.principalid?.text = "Rs. ${NumberFormat.getInstance(Locale("en", "IN")).format(String.format("%.2f",p).toDouble())}"
            val x = (p*n*r)
            binding?.inpayableid?.text = "Rs. ${NumberFormat.getInstance(Locale("en", "IN")).format(String.format("%.2f",x).toDouble())}"

            binding?.tapid?.text = "Rs. ${NumberFormat.getInstance(Locale("en", "IN")).format(String.format("%.2f",(x+p)).toDouble())}"

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