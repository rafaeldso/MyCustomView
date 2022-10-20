package br.com.rafael.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.rafael.mycustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Exemplo de alteração do atributo programaticamente
        binding.edtSample.text = "Exemplo"
        // ou
        binding.text = "Exemplo123"


        //Exemplo de como adicionar um callback
        binding.callback = this
        // ou
        binding.edtSample.onClearCallback {
            Toast.makeText(this, "Clicou em Limpar", Toast.LENGTH_LONG).show()
        }
    }

    fun showSampleCallback() {
        Toast.makeText(this, "Clicou em Limpar 2", Toast.LENGTH_LONG).show()
    }
}