package buu.informatics.cs59160395.bookcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val slot: Slot = Slot(0, "", "", "")
    var sl: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // click slot
        findViewById<TextView>(R.id.slot_one_text).setOnClickListener {
            showCreate(it, 1)
        }
        findViewById<TextView>(R.id.slot_two_text).setOnClickListener {
            showCreate(it, 2)
        }
        findViewById<TextView>(R.id.slot_three_text).setOnClickListener {
            showCreate(it, 3)
        }

        // click update
        findViewById<Button>(R.id.update_button).setOnClickListener {
            addCar(it, sl)
        }

        // click home
        findViewById<Button>(R.id.home_button).setOnClickListener {
            showHome(it)
        }

        // click edit
        findViewById<Button>(R.id.edit_button).setOnClickListener {

        }

        // click delete
        findViewById<Button>(R.id.delete_button).setOnClickListener {

        }
    }

    private fun addCar(view: View, num: Int){
        val slot1 = findViewById<TextView>(R.id.slot_one_text)
        val slot2 = findViewById<TextView>(R.id.slot_two_text)
        val slot3 = findViewById<TextView>(R.id.slot_three_text)
        val numberText = findViewById<TextView>(R.id.number_car_text)
        val brandText = findViewById<TextView>(R.id.brand_car_text)
        val nameText = findViewById<TextView>(R.id.name_owner_text)
        val numberEdit = findViewById<EditText>(R.id.number_car_edit)
        val brandEdit = findViewById<EditText>(R.id.brand_car_edit)
        val nameEdit = findViewById<EditText>(R.id.name_owner_edit)
        val updateBtn = findViewById<Button>(R.id.update_button)
        val homeBtn = findViewById<Button>(R.id.home_button)
        val editBtn = findViewById<Button>(R.id.edit_button)
        val deleteBtn = findViewById<Button>(R.id.delete_button)

        // hide editText and button
        numberEdit.visibility = View.GONE
        brandEdit.visibility = View.GONE
        nameEdit.visibility = View.GONE
        updateBtn.visibility = View.GONE

        // check slot and show slot
        when (num) {
            1 -> {
                slot1.visibility = View.VISIBLE
                slot2.visibility = View.GONE
                slot3.visibility = View.GONE
            }
            2 -> {
                slot1.visibility = View.GONE
                slot2.visibility = View.VISIBLE
                slot3.visibility = View.GONE
            }
            else -> {
                slot1.visibility = View.GONE
                slot2.visibility = View.GONE
                slot3.visibility = View.VISIBLE
            }
        }

        // show textView and button
        numberText.visibility = View.VISIBLE
        brandText.visibility = View.VISIBLE
        nameText.visibility = View.VISIBLE
        homeBtn.visibility = View.VISIBLE
        editBtn.visibility = View.VISIBLE
        deleteBtn.visibility = View.VISIBLE

    }

    private fun showCreate(view: View, num: Int){
        val slot1 = findViewById<TextView>(R.id.slot_one_text)
        val slot2 = findViewById<TextView>(R.id.slot_two_text)
        val slot3 = findViewById<TextView>(R.id.slot_three_text)
        val labelColor1 = findViewById<TextView>(R.id.null_color_text)
        val label1 = findViewById<TextView>(R.id.null_text)
        val labelColor2 = findViewById<TextView>(R.id.unull_color_text)
        val label2 = findViewById<TextView>(R.id.unull_text)
        val numberEdit = findViewById<EditText>(R.id.number_car_edit)
        val brandEdit = findViewById<EditText>(R.id.brand_car_edit)
        val nameEdit = findViewById<EditText>(R.id.name_owner_edit)
        val updateBtn = findViewById<Button>(R.id.update_button)

        // hide label
        labelColor1.visibility = View.GONE
        label1.visibility = View.GONE
        labelColor2.visibility = View.GONE
        label2.visibility = View.GONE

        // keep num slot
        sl = num

        // check slot and show slot
        when (num) {
            1 -> {
                slot1.visibility = View.VISIBLE
                slot2.visibility = View.GONE
                slot3.visibility = View.GONE
            }
            2 -> {
                slot1.visibility = View.GONE
                slot2.visibility = View.VISIBLE
                slot3.visibility = View.GONE
            }
            else -> {
                slot1.visibility = View.GONE
                slot2.visibility = View.GONE
                slot3.visibility = View.VISIBLE
            }
        }

        // show editText and button
        numberEdit.visibility = View.VISIBLE
        brandEdit.visibility = View.VISIBLE
        nameEdit.visibility = View.VISIBLE
        updateBtn.visibility = View.VISIBLE

    }

    private fun showHome(view: View){
        val slot1 = findViewById<TextView>(R.id.slot_one_text)
        val slot2 = findViewById<TextView>(R.id.slot_two_text)
        val slot3 = findViewById<TextView>(R.id.slot_three_text)
        val numberText = findViewById<TextView>(R.id.number_car_text)
        val brandText = findViewById<TextView>(R.id.brand_car_text)
        val nameText = findViewById<TextView>(R.id.name_owner_text)
        val labelColor1 = findViewById<TextView>(R.id.null_color_text)
        val label1 = findViewById<TextView>(R.id.null_text)
        val labelColor2 = findViewById<TextView>(R.id.unull_color_text)
        val label2 = findViewById<TextView>(R.id.unull_text)
        val homeBtn = findViewById<Button>(R.id.home_button)
        val editBtn = findViewById<Button>(R.id.edit_button)
        val deleteBtn = findViewById<Button>(R.id.delete_button)

        // show slot and label
        slot1.visibility = View.VISIBLE
        slot2.visibility = View.VISIBLE
        slot3.visibility = View.VISIBLE
        labelColor1.visibility = View.VISIBLE
        label1.visibility = View.VISIBLE
        labelColor2.visibility = View.VISIBLE
        label2.visibility = View.VISIBLE

        // hide button and textView
        homeBtn.visibility = View.GONE
        editBtn.visibility = View.GONE
        deleteBtn.visibility = View.GONE
        numberText.visibility = View.GONE
        brandText.visibility = View.GONE
        nameText.visibility = View.GONE

    }
}
