package com.example.fabinails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fabinails.databinding.ActivityFavoritoBinding
import com.example.fabinails.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class Favorito : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFavoritoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        binding.agenda.setOnClickListener(this)
        binding.pagamento.setOnClickListener(this)
        binding.fidelidade.setOnClickListener(this)
        binding.favorite.setOnClickListener(this)
        binding.home.setOnClickListener(this)
        binding.Perfil.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val TelaLogin = Intent(this, Login::class.java)
            startActivity(TelaLogin)
            finish()
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.agenda){
            MoverAgenda()
        }else if (v.id == R.id.pagamento){
            MoverPagamento()
        }else if (v.id == R.id.fidelidade){
            MoverFidelidade()
        }else if (v.id == R.id.home){
            MoverHome()
        }
    }

    private fun MoverAgenda(){
        startActivity(Intent(this, Agendados::class.java))
        finish()
    }

    private fun MoverPagamento(){
        startActivity(Intent(this, Pagamento::class.java))
        finish()
    }

    private fun MoverFidelidade(){
        startActivity(Intent(this, Fidelidade::class.java))
        finish()
    }

    private fun MoverHome(){
        startActivity(Intent(this, home::class.java))
        finish()
    }
}