package com.example.fabinails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fabinails.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Evento de click para logar
        binding.Acessar.setOnClickListener {
            val email = binding.emailLogin.text.toString()
            val senha = binding.SenhaLogin.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            } else {
                //login do usuario
                auth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { autenticacao ->
                        //Se a autenticação der certo navega para a tela de home
                        if (autenticacao.isSuccessful) {
                            TelaHome()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(this, "Erro ao logar-se", Toast.LENGTH_LONG).show()
                    }
            }
        }

        //Entrar na tela de registro
        binding.textCriarconta.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

    //verificar login
    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if(usuarioAtual != null){
            TelaHome()
        }
    }


    // Iniciar a tela de home
    private fun TelaHome() {
        startActivity(Intent(this, home::class.java))
        finish()
    }
}