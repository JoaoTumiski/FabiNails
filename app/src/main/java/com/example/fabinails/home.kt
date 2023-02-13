package com.example.fabinails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.fabinails.Adapter.MyAdapter
import com.example.fabinails.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth

class home : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        //tab layout

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.ViewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Trabalhos"))
        tabLayout.addTab(tabLayout.newTab().setText("Adesivos"))
        tabLayout.addTab(tabLayout.newTab().setText("Esmaltes"))
        tabLayout.addTab(tabLayout.newTab().setText("Agendar"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(
            this, supportFragmentManager,
            tabLayout.tabCount
        )
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        //trocar de telas
        binding.agenda.setOnClickListener(this)
        binding.pagamento.setOnClickListener(this)
        binding.fidelidade.setOnClickListener(this)
        binding.favorite.setOnClickListener(this)
        binding.Perfil.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val TelaLogin = Intent(this, Login::class.java)
            startActivity(TelaLogin)
            finish()
        }
    }

    //funções de click

    override fun onClick(v: View) {
        if (v.id == R.id.agenda) {
            MoverAgenda()
        } else if (v.id == R.id.pagamento) {
            MoverPagamento()
        } else if (v.id == R.id.fidelidade) {
            MoverFidelidade()
        } else if (v.id == R.id.favorite) {
            MoverFavorito()
        }
    }

    private fun MoverAgenda() {
        startActivity(Intent(this, Agendados::class.java))
    }

    private fun MoverPagamento() {
        startActivity(Intent(this, Pagamento::class.java))
    }

    private fun MoverFidelidade() {
        startActivity(Intent(this, Fidelidade::class.java))
    }

    private fun MoverFavorito() {
        startActivity(Intent(this, Favorito::class.java))
    }

}