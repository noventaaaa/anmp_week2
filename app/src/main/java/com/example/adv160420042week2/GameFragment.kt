package com.example.adv160420042week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.adv160420042week2.databinding.FragmentGameBinding
import org.w3c.dom.Text

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val txtScore = view.findViewById<TextView>(R.id.txtScore)
        if(arguments != null) {
            var playerScore = view.findViewById<TextView>(R.id.txtAnswer)
            playerScore = GameFragmentArgs.fromBundle(requireArguments())
            val score =
                GameFragmentArgs.fromBundle(requireArguments()).playerScore
            txtScore.text = "Your Score is $score"
        }
        btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}