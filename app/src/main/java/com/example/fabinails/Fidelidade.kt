package com.example.fabinails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fabinails.databinding.ActivityFidelidadeBinding

class Fidelidade : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFidelidadeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFidelidadeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        binding.agenda.setOnClickListener(this)
        binding.pagamento.setOnClickListener(this)
        binding.fidelidade.setOnClickListener(this)
        binding.home.setOnClickListener(this)
        binding.favorite.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.home){
            MoverHome()
        }else if (v.id == R.id.pagamento){
            MoverPagamento()
        }else if (v.id== R.id.agenda){
            MoverAgendados()
        }else if (v.id == R.id.favorite){
            MoverFavorito()
        }
    }

    private fun MoverHome(){
        startActivity(Intent(this, home::class.java))
        finishAffinity()
    }

    private fun MoverPagamento(){
        startActivity(Intent(this, Pagamento::class.java))
        finish()
    }

    private fun MoverAgendados(){
        startActivity(Intent(this, Agendados::class.java))
        finish()
    }

    private fun MoverFavorito(){
        startActivity(Intent(this, Favorito::class.java))
        finish()
    }
}