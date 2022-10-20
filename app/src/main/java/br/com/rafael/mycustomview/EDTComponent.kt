package br.com.rafael.mycustomview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.rafael.mycustomview.databinding.EdtComponentBinding


class EDTComponent(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    var label: String? = null
        set(value) {
            field = value
            // Atualiza a variável do data binding
            binding.label = field
        }
    var text: String? = null
        set(value) {
            field = value
            // Atualiza a variável do data binding
            binding.text = field
        }
    private var hint: String? = null
        set(value) {
            field = value
            // Atualiza a variável do data binding
            binding.hint = field
        }
    lateinit var binding: EdtComponentBinding
    private var clearCallback: () -> Unit = {}

    private fun init(context: Context, attrs: AttributeSet?) {

        //Instanciando o arquivo de Layout e o binding
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = EdtComponentBinding.inflate(layoutInflater, this, true)

        //Obtendo a lista de atributos personalizados
        val array: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.EDTComponent, 0, 0)

        try {
            //Inicializando os variáveis com os valores dos atributos personalizados
            label = array.getString(R.styleable.EDTComponent_label)
            text = array.getString(R.styleable.EDTComponent_text)
            hint = array.getString(R.styleable.EDTComponent_hint)
        } finally {
            // Limpando a memória alocada
            array.recycle()
        }
        // Adicionando um ouvinte para o evento de clique
        binding.btClearText.setOnClickListener {
            binding.edtText.setText("")
            clearCallback()
        }
    }

    fun setOnClearCallback(callback: () -> Unit) {
        clearCallback = { callback() }
    }

    init {
        init(context, attrs)
    }
}