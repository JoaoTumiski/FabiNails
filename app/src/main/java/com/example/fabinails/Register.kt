package com.example.fabinails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.fabinails.databinding.ActivityRegisterBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.*


class Register : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRegisterBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Esconde a barra de ação
        supportActionBar?.hide()

        binding.voltar.setOnClickListener(this)


        //saber o texto que o usuario digitou
        binding.CriarConta.setOnClickListener {
            val email = binding.emailRegistro.text.toString()
            val senha = binding.SenhaRegistro.text.toString()
            val RepetirSenha = binding.RepetirSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty() || RepetirSenha.isEmpty() || senha != RepetirSenha) {
                Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_LONG).show()
                } else {
                auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { cadastro ->
                        if (cadastro.isSuccessful) {
                            Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_LONG).show()
                            binding.emailRegistro.setText("")
                            binding.SenhaRegistro.setText("")
                            binding.RepetirSenha.setText("")
                        }
                    }.addOnFailureListener { exception ->

                        val mensagemErro = when (exception) {
                            is FirebaseAuthWeakPasswordException -> "Digite uma Senha com no minimo 6 caracteres!"
                            is FirebaseAuthInvalidCredentialsException -> "Digite um email válido!"
                            is FirebaseAuthUserCollisionException -> "Esta conta já está cadastrada!"
                            is FirebaseNetworkException -> "Sem Conexão com a internet!"
                            else -> "Erro ao cadastrar usuário!"
                        }
                        Toast.makeText(this, mensagemErro, Toast.LENGTH_LONG).show()
                    }
            }
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.voltar) {
            startActivity(Intent(this, Login::class.java))
        }
    }
}