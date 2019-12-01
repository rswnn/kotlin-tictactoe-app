package com.riswan.startup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buExit.setOnClickListener { System.exit(404) }

    }

    fun buClick(view: View) {

        val buSelected = view as Button

        var cellID = 0

        when(buSelected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }

//        Toast.makeText(this, "ID " + cellID, Toast.LENGTH_LONG).show()
        PlayGame(cellID, buSelected)

    }

    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivePlayer = 1


    fun PlayGame (cellID:Int, buSelected: Button) {

        if (ActivePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.colorLeson)
            Player1.add(cellID)
            ActivePlayer = 2
            AutoPlay()
        } else {
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.colorDumbways)
            Player2.add(cellID)
            ActivePlayer = 1
        }
        buSelected.isEnabled = false
        CheckWinner(buSelected)
    }

    fun CheckWinner (buSelected: Button) {
        var winner = -1
        var scored:Int = 0
        // row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2
        }

        // row 2

        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2
        }

        // row 3

        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2
        }

        // col 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2
        }

        //
        // col 2

        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2
        }

        // col 3

        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2
        }


        // samping

        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9)) {
            winner = 2
        }

        //
        // col 2

        if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                scored++
                score.text = scored.toString()
                Toast.makeText(this, "ID Player 1 win" , Toast.LENGTH_LONG).show()
                Player1.removeAll(Player1)
                Player2.removeAll(Player2)
                println(buSelected)

                return
            } else {
                Toast.makeText(this, "ID Player 2 win" , Toast.LENGTH_LONG).show()
            }
        }

    }

    fun AutoPlay () {

        var empetyCell = ArrayList<Int>()
        for ( cellID in 1..9) {
            if (! (Player1.contains(cellID) || Player2.contains(cellID))) {
                empetyCell.add(cellID)
            }
        }

        val r = Random()
        val randomIndex = r.nextInt(empetyCell.size - 0) + 0
        val cellID = empetyCell[randomIndex]

        var buSelect:Button?
        when(cellID) {
            1 -> buSelect = bu1
            2 -> buSelect = bu2
            3 -> buSelect = bu3
            4 -> buSelect = bu4
            5 -> buSelect = bu5
            6 -> buSelect = bu6
            7 -> buSelect = bu7
            8 -> buSelect = bu8
            9 -> buSelect = bu9
            else -> {
                buSelect = bu1
            }
        }
        PlayGame(cellID, buSelect)
    }

//    fun buReset (view: View){
//        var a = findViewById(R.id.bu1)
//    }


}
