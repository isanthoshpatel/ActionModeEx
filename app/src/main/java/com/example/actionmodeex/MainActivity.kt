package com.example.actionmodeex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1.setOnClickListener {

            if (actionMode != null) {
                return@setOnClickListener
            } else {
                actionMode = startActionMode(getActionModeCallback())
            }
        }
    }

    fun getActionModeCallback(): ActionMode.Callback {
        return object : ActionMode.Callback {
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.delete -> {
                        Toast.makeText(this@MainActivity, "deleted", Toast.LENGTH_LONG).show()
                        actionMode = null
                    }
                    R.id.share -> {
                        Toast.makeText(this@MainActivity, "Sharing..", Toast.LENGTH_LONG).show()
                        actionMode = null
                    }
                }
                return true
            }

            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.menu, menu)
                setTitle("ActionMode") //actionbar title
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                actionMode = null
            }

        }
    }
}
