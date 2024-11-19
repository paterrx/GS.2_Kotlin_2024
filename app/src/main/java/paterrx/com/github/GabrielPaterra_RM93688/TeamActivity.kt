package paterrx.com.github.GabrielPaterra_RM93688

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        // Botão de voltar
        val buttonBack = findViewById<Button>(R.id.button_back)
        buttonBack.setOnClickListener {
            finish() // Fecha a TeamActivity e volta para a MainActivity
        }
    }
}
