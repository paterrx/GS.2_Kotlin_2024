package paterrx.com.github.GabrielPaterra_RM93688

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "EcoDicas "

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<android.widget.EditText>(R.id.editText)

        button.setOnClickListener {
            val inputText = editText.text.trim().toString()
            if (inputText.isEmpty()) {
                editText.error = "Preencha um valor "
                return@setOnClickListener
            }
            viewModel.addItem(inputText)
            editText.text.clear()
        }

        // Botão para ir para a tela de componentes da equipe
        val buttonTeam = findViewById<Button>(R.id.button_team)
        buttonTeam.setOnClickListener {
            val intent = Intent(this, TeamActivity::class.java)
            startActivity(intent)
        }

        // Observa o LiveData e atualiza o RecyclerView
        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }
    }
}
