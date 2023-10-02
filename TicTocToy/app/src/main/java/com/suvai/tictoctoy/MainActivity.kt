package com.suvai.tictoctoy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.suvai.tictoctoy.databinding.ActivityMainBinding
import java.util.Random


class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private var flag: Boolean = true

    private lateinit var random: Random
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        random = Random(100)

        binding.newGame.setOnClickListener {
            startActivity(Intent(this@MainActivity, ResultActivity::class.java))
        }

        binding.tv11.setOnClickListener {
            onClick(binding.tv11)
        }
        binding.tv12.setOnClickListener {
            onClick(binding.tv12)
        }
        binding.tv13.setOnClickListener {
            onClick(binding.tv13)
        }
        binding.tv21.setOnClickListener {
            onClick(binding.tv21)
        }
        binding.tv22.setOnClickListener {
            onClick(binding.tv22)
        }
        binding.tv23.setOnClickListener {
            onClick(binding.tv23)
        }
        binding.tv31.setOnClickListener {
            onClick(binding.tv31)
        }
        binding.tv32.setOnClickListener {
            onClick(binding.tv32)
        }
        binding.tv33.setOnClickListener {
            onClick(binding.tv33)
        }

    }
    private fun onClick(v: TextView) {
        doAction(v)
        winnerLogic()
        if (!flag && isCellAvailable()) {
            computerMove()
            winnerLogic()
        }
    }
    private fun doAction(value: TextView) {
        when (value) {
             binding.tv11-> {
                binding.tv11.text = if (flag) "X" else "O"
                binding.tv11.isClickable = false
                flag = !flag
            }

            binding.tv12 -> {
                binding.tv12.text = if (flag) "X" else "O"
                binding.tv12.isClickable = false
                flag = !flag
            }

            binding.tv13 -> {
                binding.tv13.text = if (flag) "X" else "O"
                binding.tv13.isClickable = false
                flag = !flag
            }

            binding.tv21 -> {
                binding.tv21.text = if (flag) "X" else "O"
                binding.tv21.isClickable = false
                flag = !flag
            }

            binding.tv22 -> {
                binding.tv22.text = if (flag) "X" else "O"
                binding.tv22.isClickable = false
                flag = !flag
            }

            binding.tv23 -> {
                binding.tv23.text = if (flag) "X" else "O"
                binding.tv23.isClickable = false
                flag = !flag
            }

            binding.tv31 -> {
                binding.tv31.text = if (flag) "X" else "O"
                binding.tv31.isClickable = false
                flag = !flag
            }

            binding.tv32 -> {
                binding.tv32.text = if (flag) "X" else "O"
                binding.tv32.isClickable = false
                flag = !flag
            }

            binding.tv33 -> {
                binding.tv33.text = if (flag) "X" else "O"
                binding.tv33.isClickable = false
                flag = !flag
            }
        }
    }

    private fun isCellAvailable(): Boolean {
        if (binding.tv11.isClickable || binding.tv12.isClickable || binding.tv13.isClickable
            || binding.tv21.isClickable || binding.tv22.isClickable || binding.tv23.isClickable
            || binding.tv31.isClickable || binding.tv32.isClickable || binding.tv33.isClickable
        ) {
            return true
        }
        if (binding.showResult.length() <= 0) binding.showResult.text =
            getString(R.string.game_draw)
        return false
    }
    private fun computerMove() {
        val compMovePosition = random.nextInt(9 - 1 + 1) + 1
        //        Log.i(TAG, "computerMove: "+ compMovePosition);
        if (1 == compMovePosition && binding.tv11.isClickable) {
            doAction(binding.tv11)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (2 == compMovePosition && binding.tv12.isClickable) {
            doAction(binding.tv12)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (3 == compMovePosition && binding.tv13.isClickable) {
            doAction(binding.tv13)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (4 == compMovePosition && binding.tv21.isClickable) {
            doAction(binding.tv21)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (5 == compMovePosition && binding.tv22.isClickable) {
            doAction(binding.tv22)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (6 == compMovePosition && binding.tv23.isClickable) {
            doAction(binding.tv23)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (7 == compMovePosition && binding.tv31.isClickable) {
            doAction(binding.tv31)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (8 == compMovePosition && binding.tv32.isClickable) {
            doAction(binding.tv32)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else if (9 == compMovePosition && binding.tv33.isClickable) {
            doAction(binding.tv33)
            Log.i(Companion.TAG, "computerMove: $compMovePosition")
        } else {
            Log.i(Companion.TAG, "computerMove Wrong: $compMovePosition")
            computerMove()
        }
    }
    private fun winnerLogic() {
        if(
            (firstRow() || firstColumn() || firstDiagonal()) ||
            (firstRow() || secondColumn()) ||
            (firstRow() || thirdColumn() || secondDigonal()) ||
            (firstColumn() || secondRow()) ||
            (secondRow() || secondColumn() || firstDiagonal() || secondDigonal()) ||
            (thirdColumn() || secondColumn()) ||
            (firstRow() || thirdColumn() || secondDigonal()) ||
            (thirdRow() || secondColumn()) ||
            (thirdColumn() || thirdRow() || firstDiagonal())
        ){
            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
            setClickableVisibility()
        }

//        if (firstRow() || firstColumn() || firstDiagonal()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (firstRow() || secondColumn()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (firstRow() || thirdColumn() || secondDigonal()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (firstColumn() || secondRow()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (secondRow() || secondColumn() || firstDiagonal() || secondDigonal()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (thirdColumn() || secondColumn()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (firstRow() || thirdColumn() || secondDigonal()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (thirdRow() || secondColumn()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        } else if (thirdColumn() || thirdRow() || firstDiagonal()) {
//            binding.showResult.text = if (!flag) getString(R.string.you_r_winner) else getString(R.string.computer_winner)
//            setClickableVisibility()
//        }

    }
    private fun setClickableVisibility(): Boolean {
        binding.tv11.isClickable = false
        binding.tv12.isClickable = false
        binding.tv13.isClickable = false
        binding.tv21.isClickable = false
        binding.tv22.isClickable = false
        binding.tv23.isClickable = false
        binding.tv31.isClickable = false
        binding.tv32.isClickable = false
        binding.tv33.isClickable = false
        return false
    }
    private fun firstRow(): Boolean =
        binding.tv11.text === "X" && binding.tv12.text === "X" && binding.tv13.text === "X" || binding.tv11.text === "O" && binding.tv12.text === "O" && binding.tv13.text === "O"

    private fun secondRow(): Boolean =
        binding.tv21.text === "X" && binding.tv22.text === "X" && binding.tv23.text === "X" || binding.tv21.text === "O" && binding.tv22.text === "O" && binding.tv23.text === "O"

    private fun thirdRow(): Boolean =
        binding.tv31.text === "X" && binding.tv32.text === "X" && binding.tv33.text === "X" || binding.tv31.text === "O" && binding.tv32.text === "O" && binding.tv33.text === "O"

    private fun firstColumn(): Boolean =
        binding.tv11.text === "X" && binding.tv21.text === "X" && binding.tv31.text === "X" || binding.tv11.text === "O" && binding.tv21.text === "O" && binding.tv31.text === "O"

    private fun secondColumn(): Boolean =
        binding.tv12.text === "X" && binding.tv22.text === "X" && binding.tv32.text === "X" || binding.tv12.text === "O" && binding.tv22.text === "O" && binding.tv32.text === "O"

    private fun thirdColumn(): Boolean {
        return binding.tv13.text === "X" && binding.tv23.text === "X" && binding.tv33.text === "X" || binding.tv13.text === "O" && binding.tv23.text === "O" && binding.tv33.text === "O"
    }

    private fun firstDiagonal(): Boolean {
        return binding.tv11.text === "X" && binding.tv22.text === "X" && binding.tv33.text === "X" || binding.tv11.text === "O" && binding.tv22.text === "O" && binding.tv33.text === "O"
    }

    private fun secondDigonal(): Boolean {
        return binding.tv13.text === "X" && binding.tv22.text === "X" && binding.tv31.text === "X" || binding.tv13.text === "O" && binding.tv22.text === "O" && binding.tv31.text === "O"
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}