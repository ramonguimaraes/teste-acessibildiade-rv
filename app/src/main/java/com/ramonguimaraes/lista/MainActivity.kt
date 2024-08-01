package com.ramonguimaraes.lista

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramonguimaraes.lista.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.rv.adapter = TesteAdapter(listOf(
            Triple("Banco do Brasil", "em andamento", "07/09/2024"),
            Triple("Itaú Unibanco", "concluído", "12/08/2024"),
            Triple("Bradesco", "em andamento", "15/09/2024"),
            Triple("Caixa Econômica Federal", "pendente", "20/10/2024"),
            Triple("Santander", "em andamento", "25/11/2024"),
            Triple("Banco Safra", "concluído", "01/12/2024"),
            Triple("Banco Inter", "pendente", "05/01/2025"),
            Triple("Nubank", "em andamento", "10/02/2025"),
            Triple("Banco Pan", "concluído", "15/03/2025"),
            Triple("Banco Original", "pendente", "20/04/2025")
        ))

        binding.rv.layoutManager = LinearLayoutManager(this)
    }
}