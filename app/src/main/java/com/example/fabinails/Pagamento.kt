package com.example.fabinails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.fabinails.databinding.ActivityFidelidadeBinding
import com.example.fabinails.databinding.ActivityPagamentoBinding
import com.google.firebase.auth.FirebaseAuth

class Pagamento : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPagamentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        binding.agenda.setOnClickListener(this)
        binding.home.setOnClickListener(this)
        binding.fidelidade.setOnClickListener(this)
        binding.favorite.setOnClickListener(this)
        binding.pixButton.setOnClickListener(this)
        binding.Perfil.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val TelaLogin = Intent(this, Login::class.java)
            startActivity(TelaLogin)
            finish()
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.home){
            MoverHome()
        }else if (v.id == R.id.agenda){
            MoverAgendados()
        }else if (v.id== R.id.fidelidade){
            MoverFidelidade()
        }else if (v.id == R.id.favorite){
            MoverFavorito()
        }else if (v.id == R.id.pix_Button){
            Toast.makeText(this, "Código Pix copiado!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun MoverHome(){
        startActivity(Intent(this, home::class.java))
        finish()
        finishAffinity()
    }

    private fun MoverAgendados(){
        startActivity(Intent(this, Agendados::class.java))
        finish()
    }

    private fun MoverFidelidade(){
        startActivity(Intent(this, Fidelidade::class.java))
        finish()
    }

    private fun MoverFavorito(){
        startActivity(Intent(this, Favorito::class.java))
        finish()
    }
}