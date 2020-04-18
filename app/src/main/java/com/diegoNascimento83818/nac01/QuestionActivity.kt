package com.diegoNascimento83818.nac01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question.*
import kotlin.random.Random

class QuestionActivity : AppCompatActivity() {

    var position:Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        nameButtons()
    }

    fun nameButtons(){
        val topCorrect : Boolean = Random.nextBoolean()
        val faseAtual = setTexts(topCorrect)

        //clicks dos botoes
        buttonA.setOnClickListener {
            if (topCorrect){
                if (position == 3){
                    ganhou()
                }
                else{
                    correta()
                }
            }
            else{
                gameover()
            }
        }
        buttonB.setOnClickListener {
            if (!topCorrect){
                if (position == 3){
                    ganhou()
                }
                else{
                    correta()
                }
            }
            else{
                gameover()
            }
        }
    }

    private fun setTexts(topCorrect:Boolean){
        val arrayPerguntas = resources.getStringArray(R.array.perguntas)
        val arrayRespostas = resources.getStringArray(R.array.respostas)
        val arrayErradas = resources.getStringArray(R.array.erradas)

        if (topCorrect){
            buttonA.text = arrayRespostas[position]
            buttonB.text = arrayErradas[position]
        }
        else{
            buttonA.text = arrayErradas[position]
            buttonB.text = arrayRespostas[position]
        }

        textView2.text = arrayPerguntas[position]
    }

    private fun gameover(){
        val intent = Intent(this, PerdeuActivity::class.java)
        startActivity(intent)
    }

    private fun ganhou(){
        val intent = Intent(this, GanhouActivity::class.java)
        startActivity(intent)
    }

    private fun correta(){
        position++;
        nameButtons();
    }
}
