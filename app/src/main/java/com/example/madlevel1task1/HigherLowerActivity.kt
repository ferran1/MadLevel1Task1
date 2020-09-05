package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*
import kotlinx.android.synthetic.main.activity_higher_lower.view.*

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1;
    private var lastThrow: Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews();
    }

    private fun initViews() {
        binding.btnEqual.setOnClickListener {
            onEqualClick()
        }
        binding.btnHigher.setOnClickListener{
            onHigherClick()
        }
        binding.btnLower.setOnClickListener{
            onLowerClick()
        }
        updateUI();
    }

    private fun updateUI() {
        // Set the TextView with id "lastThrow" with the last throw
        binding.lastThrow.text = getString(
            R.string.last_throw,
            lastThrow
        ) // The second parameter is throwing number (%d placeholder of the string which indicates that a digit parameter has to be given to it)

        // Check the throwing number and change the dice picture
        when (currentThrow) {
            1 -> binding.imageViewDice.setImageResource(R.drawable.dice1)
            2 -> binding.imageViewDice.setImageResource(R.drawable.dice2)
            3 -> binding.imageViewDice.setImageResource(R.drawable.dice3)
            4 -> binding.imageViewDice.setImageResource(R.drawable.dice4)
            5 -> binding.imageViewDice.setImageResource(R.drawable.dice5)
            6 -> binding.imageViewDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        // Set the last throw to the current throw
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }

}