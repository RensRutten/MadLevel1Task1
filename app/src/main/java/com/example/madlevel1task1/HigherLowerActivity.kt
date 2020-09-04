package com.example.madlevel1task1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding


class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    /**
     * Set the initial (UI) state of the game.
     */
    private fun initViews() {
        binding.btnHigher.setOnClickListener { onHigherClick() }
        binding.btnLower.setOnClickListener { onLowerClick() }
        binding.btnEqual.setOnClickListener { onEqualClick() }
        updateUI()
    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw.
     */
    private fun updateUI() {
        when (lastThrow) {
            1 -> binding.tvLastThrow.text = ("last Throw: 1")
            2 -> binding.tvLastThrow.text = ("last Throw: 2")
            3 -> binding.tvLastThrow.text = ("last Throw: 3")
            4 -> binding.tvLastThrow.text = ("last Throw: 4")
            5 -> binding.tvLastThrow.text = ("last Throw: 5")
            6 -> binding.tvLastThrow.text = ("last Throw: 6")
        }

        when (currentThrow) {
            1 -> binding.Dice.setImageResource(R.drawable.dice1)
            2 -> binding.Dice.setImageResource(R.drawable.dice2)
            3 -> binding.Dice.setImageResource(R.drawable.dice3)
            4 -> binding.Dice.setImageResource(R.drawable.dice4)
            5 -> binding.Dice.setImageResource(R.drawable.dice5)
            6 -> binding.Dice.setImageResource(R.drawable.dice6)
        }
    }
        /**
         * Replaces the previous dice value with the current one and replaces the current dice with a new dice
         * with a random number between 1 and 6 (inclusive).
         */


        private fun rollDice() {
            lastThrow = currentThrow
            currentThrow = (1..6).random()
            updateUI()
        }

        private fun onAnswerCorrect() {
            Toast.makeText(this, getString(R.string.Correct), Toast.LENGTH_LONG).show()
        }

        private fun onAnswerIncorrect() {
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
        }
            /**
             * Calls [rollDice] and checks if the answer is correct.
             */
            private fun onHigherClick() {
                rollDice()
                if (currentThrow > lastThrow) onAnswerCorrect()
                else onAnswerIncorrect()
            }

            /**
             * Calls [rollDice] and checks if the answer is correct.
             */
            private fun onLowerClick() {
                rollDice()
                if (currentThrow < lastThrow) onAnswerCorrect()
                else onAnswerIncorrect()
            }

            /**
             * Calls [rollDice] and checks if the answer is correct.
             */
            private fun onEqualClick() {
                rollDice()
                if (currentThrow == lastThrow) onAnswerCorrect()
                else onAnswerIncorrect()
            }

        }






