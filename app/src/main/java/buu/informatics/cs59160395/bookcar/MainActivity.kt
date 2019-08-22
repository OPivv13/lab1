package buu.informatics.cs59160395.bookcar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.cs59160395.bookcar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var slotValue: Int = 0
//    private val slot: Slot = Slot(slotValue, "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            // click slot
            slotOneText.setOnClickListener {
                showCreate(it, 1)
            }
            slotTwoText.setOnClickListener {
                showCreate(it, 2)
            }
            slotThreeText.setOnClickListener {
                showCreate(it, 3)
            }
            // click update
            updateButton.setOnClickListener {
                addCar(it, slotValue)
            }
            // click home
            homeButton.setOnClickListener {
                showHome(it)
            }
            // click edit
            editButton.setOnClickListener {
                showCreate(it, slotValue)
            }
            // click delete
            deleteButton.setOnClickListener {
                showHome(it)
            }

//            slot = this@MainActivity.slot
        }

    }

    private fun addCar(view: View, num: Int){
        binding.apply {
            // add slot num brand and name to data
            // ????????????????

            // hide editText and button
            numberCarEdit.visibility = View.GONE
            brandCarEdit.visibility = View.GONE
            nameOwnerEdit.visibility = View.GONE
            updateButton.visibility = View.GONE

            // show textView and button
            numberCarText.visibility = View.VISIBLE
            brandCarText.visibility = View.VISIBLE
            nameOwnerText.visibility = View.VISIBLE
            homeButton.visibility = View.VISIBLE
            editButton.visibility = View.VISIBLE
            deleteButton.visibility = View.VISIBLE

            // check slot and show slot
            when (num) {
                1 -> {
                    slotOneText.visibility = View.VISIBLE
                    slotTwoText.visibility = View.GONE
                    slotThreeText.visibility = View.GONE
                }
                2 -> {
                    slotOneText.visibility = View.GONE
                    slotTwoText.visibility = View.VISIBLE
                    slotThreeText.visibility = View.GONE
                }
                else -> {
                    slotOneText.visibility = View.GONE
                    slotTwoText.visibility = View.GONE
                    slotThreeText.visibility = View.VISIBLE
                }
            }

            invalidateAll()

            // hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun showCreate(view: View, num: Int){
        binding.apply {
            // hide label textView and button
            nullColorText.visibility = View.GONE
            nullText.visibility = View.GONE
            unullColorText.visibility = View.GONE
            unullText.visibility = View.GONE
            homeButton.visibility = View.GONE
            editButton.visibility = View.GONE
            deleteButton.visibility = View.GONE
            numberCarText.visibility = View.GONE
            brandCarText.visibility = View.GONE
            nameOwnerText.visibility = View.GONE

            // show editText and button
            updateButton.visibility = View.VISIBLE
            numberCarEdit.visibility = View.VISIBLE
            brandCarEdit.visibility = View.VISIBLE
            nameOwnerEdit.visibility = View.VISIBLE

            // keep num slot
            slotValue = num

            // check slot and show slot
            when (num) {
                1 -> {
                    slotOneText.visibility = View.VISIBLE
                    slotTwoText.visibility = View.GONE
                    slotThreeText.visibility = View.GONE
                }
                2 -> {
                    slotOneText.visibility = View.GONE
                    slotTwoText.visibility = View.VISIBLE
                    slotThreeText.visibility = View.GONE
                }
                3 -> {
                    slotOneText.visibility = View.GONE
                    slotTwoText.visibility = View.GONE
                    slotThreeText.visibility = View.VISIBLE
                }
            }

            numberCarEdit.requestFocus()
            // show the keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(numberCarEdit, 0)
        }
    }

    private fun showHome(view: View){
        binding.apply {
            // show slot and label
            slotOneText.visibility = View.VISIBLE
            slotTwoText.visibility = View.VISIBLE
            slotThreeText.visibility = View.VISIBLE
            nullColorText.visibility = View.VISIBLE
            nullText.visibility = View.VISIBLE
            unullColorText.visibility = View.VISIBLE
            unullText.visibility = View.VISIBLE

            // hide button and textView
            homeButton.visibility = View.GONE
            editButton.visibility = View.GONE
            deleteButton.visibility = View.GONE
            numberCarText.visibility = View.GONE
            brandCarText.visibility = View.GONE
            nameOwnerText.visibility = View.GONE

        }


    }
}
