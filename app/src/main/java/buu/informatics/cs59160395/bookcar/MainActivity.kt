package buu.informatics.cs59160395.bookcar

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.cs59160395.bookcar.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var slotValue: Int = 0
    private var slot0: Slot = Slot(0, "", "", "")
    private var slot1: Slot = Slot(1, "", "", "")
    private var slot2: Slot = Slot(2, "", "", "")
    private var slot3: Slot = Slot(3, "", "", "")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            // click slot
            slotOneText.setOnClickListener {
                slotValue = 1
                checkSlot(it)
            }
            slotTwoText.setOnClickListener {
                slotValue = 2
                checkSlot(it)
            }
            slotThreeText.setOnClickListener {
                slotValue = 3
                checkSlot(it)
            }
            // click update
            updateButton.setOnClickListener {
                addSlot(it)
            }
            // click home
            homeButton.setOnClickListener {
                showHome(it)
            }
            // click edit
            editButton.setOnClickListener {
                showEdit(it, false)
            }
            // click delete
            deleteButton.setOnClickListener {
                deleteSlot(it)
            }

            slot = this@MainActivity.slot1
            slot = this@MainActivity.slot2
            slot = this@MainActivity.slot3
            slot = this@MainActivity.slot0
        }
    }

    private fun checkSlot(view: View){
        binding.apply {
            when (slotValue) {
                1 -> {
                    if (slot1.numberCar == ""){
                        showEdit(view, true)
                    } else {
                        showSlot(view)
                    }
                }
                2 -> {
                    if (slot2.numberCar == ""){
                        showEdit(view, true)
                    } else {
                        showSlot(view)
                    }
                }
                3 -> {
                    if (slot3.numberCar == ""){
                        showEdit(view, true)
                    } else {
                        showSlot(view)
                    }
                }
            }
        }
    }

    private fun showSlot(view: View){
        binding.apply{
            // hide
            numberCarEdit.visibility = View.GONE
            brandCarEdit.visibility = View.GONE
            nameOwnerEdit.visibility = View.GONE
            updateButton.visibility = View.GONE
            nullColorText.visibility = View.GONE
            nullText.visibility = View.GONE
            unullColorText.visibility = View.GONE
            unullText.visibility = View.GONE

            // show
            numberCarText.visibility = View.VISIBLE
            brandCarText.visibility = View.VISIBLE
            nameOwnerText.visibility = View.VISIBLE
            homeButton.visibility = View.VISIBLE
            editButton.visibility = View.VISIBLE
            deleteButton.visibility = View.VISIBLE

            // show slot and hide slot
            when (slotValue) {
                1 -> {
                    slotOneText.visibility = View.VISIBLE
                    slotTwoText.visibility = View.GONE
                    slotThreeText.visibility = View.GONE

                    numberCarText.text = slot1.numberCar
                    brandCarText.text = slot1.brandCar
                    nameOwnerText.text = slot1.nameOwner
                }
                2 -> {
                    slotOneText.visibility = View.GONE
                    slotTwoText.visibility = View.VISIBLE
                    slotThreeText.visibility = View.GONE

                    numberCarText.text = slot2.numberCar
                    brandCarText.text = slot2.brandCar
                    nameOwnerText.text = slot2.nameOwner
                }
                3 -> {
                    slotOneText.visibility = View.GONE
                    slotTwoText.visibility = View.GONE
                    slotThreeText.visibility = View.VISIBLE

                    numberCarText.text = slot3.numberCar
                    brandCarText.text = slot3.brandCar
                    nameOwnerText.text = slot3.nameOwner
                }
            }
            invalidateAll()
        }
    }

    private fun addSlot(view: View){
        binding.apply {
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

            // add slot
            when (slotValue) {
                1 -> {
                    // add slot num brand and name to data  &  set text slot
                    slot1.numberCar = numberCarEdit.text.toString()
                    slot1.brandCar = brandCarEdit.text.toString()
                    slot1.nameOwner = nameOwnerEdit.text.toString()
                    slotOneText.text = numberCarEdit.text.toString()
                }
                2 -> {
                    // add slot num brand and name to data  &  set text slot
                    slot2.numberCar = numberCarEdit.text.toString()
                    slot2.brandCar = brandCarEdit.text.toString()
                    slot2.nameOwner = nameOwnerEdit.text.toString()
                    slotTwoText.text = numberCarEdit.text.toString()
                }
                3 -> {
                    // add slot num brand and name to data  &  set text slot
                    slot3.numberCar = numberCarEdit.text.toString()
                    slot3.brandCar = brandCarEdit.text.toString()
                    slot3.nameOwner = nameOwnerEdit.text.toString()
                    slotThreeText.text = numberCarEdit.text.toString()
                }
            }

            invalidateAll()

            // hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun showEdit(view: View, checkNull: Boolean){
        binding.apply {
            if(checkNull == true){
                // clean editText
                numberCarEdit.text.clear()
                brandCarEdit.text.clear()
                nameOwnerEdit.text.clear()
            }

            // hide label textView and button
            nullColorText.visibility = View.GONE
            nullText.visibility = View.GONE
            unullColorText.visibility = View.GONE
            unullText.visibility = View.GONE
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
            homeButton.visibility = View.VISIBLE

            // show slot and hide slot
            when (slotValue) {
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

            invalidateAll()

            numberCarEdit.requestFocus()
            // show the keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(numberCarEdit, 0)
        }
    }

    private fun showHome(view: View){
        binding.apply {
            // check color and show color
            if(slot1.numberCar != ""){
                slotOneText.setBackgroundResource(R.color.unull_background)
            }
            if(slot1.numberCar == "" ) {
                slotOneText.setBackgroundResource(R.color.slot_background)
            }
            if(slot2.numberCar != ""){
                slotTwoText.setBackgroundResource(R.color.unull_background)
            }
            if(slot2.numberCar == "" ) {
                slotTwoText.setBackgroundResource(R.color.slot_background)
            }
            if(slot3.numberCar != ""){
                slotThreeText.setBackgroundResource(R.color.unull_background)
            }
            if(slot3.numberCar == "" ) {
                slotThreeText.setBackgroundResource(R.color.slot_background)
            }

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
            numberCarEdit.visibility = View.GONE
            brandCarEdit.visibility = View.GONE
            nameOwnerEdit.visibility = View.GONE
            updateButton.visibility = View.GONE

            invalidateAll()
        }


    }

    private fun deleteSlot(view: View){
        binding.apply{
            // change value slot
            when (slotValue) {
                1 -> {
                    slot1.numberCar = ""
                    slot1.brandCar = ""
                    slot1.nameOwner = ""
                    slotOneText.text = ""
                }
                2 -> {
                    slot2.numberCar = ""
                    slot2.brandCar = ""
                    slot2.nameOwner = ""
                    slotTwoText.text = ""
                }
                3 -> {
                    slot3.numberCar = ""
                    slot3.brandCar = ""
                    slot3.nameOwner = ""
                    slotThreeText.text = ""
                }
            }

            showHome(view)
        }

    }
}
