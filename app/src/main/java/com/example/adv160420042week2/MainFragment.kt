package com.example.adv160420042week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.adv160420042week2.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding = FragmentMainBinding.inflate(
        inflater,
        container, false
    )
    return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.btnStart.setOnClickListener {
//            val playerName = binding.txtName.text.toString()
//            val action = MainFragmentDirections.actionGameFragment(playerName)  //pas btn start di klik nanti actionGameFragment akan berpindah
//            Navigation.findNavController(it).navigate(action)
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtAnswer = view.findViewById<EditText>(R.id.txtAnswer)
        var txtNum1 = (0..100).random()
        var txtNum2 = (0..100).random()
        var num1 = view.findViewById<TextView>(R.id.txtNum1)
        var num2 = view.findViewById<TextView>(R.id.txtNum2)
        num1.text = txtNum1.toString()
        num2.text = txtNum2.toString()

//        if(arguments != null) {
//            val playerScore = binding.txtAnswer.text.toString()
//            playerScore = GameFragmentArgs.fromBundle(requireArguments()).playerScore
//            playerScore = GameFragmentArgs.fromBundle(requireArguments()).playerScore
//        }

        binding.btnSubmit.setOnClickListener {
            var playerScore = binding.txtAnswer.text.toString()
            val action = MainFragmentDirections.actionGameFragment(playerScore)
            Navigation.findNavController(it).navigate(action)

            var result: Int = txtNum1 + txtNum2

            if(txtAnswer.text.toString() == ""){
                Snackbar.make(view, "Answer cannot be empty", Snackbar.LENGTH_SHORT).show()
            }else{
                var answer = txtAnswer.text.toString().toInt()
                if(answer == result){
                    txtNum1 = (0..100).random()
                    txtNum2 = (0..100).random()
                    num1.text = txtNum1.toString()
                    num2.text = txtNum2.toString()
                    playerScore += 1
                    val action = MainFragmentDirections.actionGameFragment(playerScore)
                    Navigation.findNavController(it).navigate(action)
                }else{
                    val action = MainFragmentDirections.actionGameFragment(playerScore)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

}