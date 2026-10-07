// =====================================================
// SEGURANÇA DIGITAL PARA TODOS
// JavaScript principal do site
// =====================================================

document.addEventListener("DOMContentLoaded", () => {

    console.log("Segurança Digital para Todos carregado com sucesso.");

    // Navegação suave para os links internos
    const links = document.querySelectorAll('a[href^="#"]');

    links.forEach(link => {

        link.addEventListener("click", (event) => {

            const destino = link.getAttribute("href");

            if (destino === "#") {
                event.preventDefault();
                return;
            }

            const elemento = document.querySelector(destino);

            if (elemento) {
                event.preventDefault();

                elemento.scrollIntoView({
                    behavior: "smooth",
                    block: "start"
                });
            }

        });

    });

});/* =========================
   QUIZ EDUCATIVO
   ========================= */

const perguntasQuiz = [
    {
        pergunta: "É seguro clicar em links desconhecidos enviados por SMS?",
        resposta: "Não"
    },
    {
        pergunta: "Golpistas podem clonar contas do WhatsApp?",
        resposta: "Sim"
    },
    {
        pergunta: "Usar senha fraca aumenta o risco de invasão?",
        resposta: "Sim"
    },
    {
        pergunta: "Wi-Fi público é totalmente seguro para acessar banco?",
        resposta: "Não"
    },
    {
        pergunta: "Atualizar o celular ajuda na segurança?",
        resposta: "Sim"
    }
];

let perguntaAtual = 0;
let pontuacao = 0;
let respostaSelecionada = false;

const perguntaElemento = document.getElementById("quiz-question");
const numeroPerguntaElemento = document.getElementById("quiz-current");
const feedbackElemento = document.getElementById("quiz-feedback");
const botoesResposta = document.querySelectorAll(".quiz-option");
const botaoProxima = document.getElementById("quiz-next");
const quizCard = document.querySelector(".quiz-card");
const quizResult = document.getElementById("quiz-result");
const pontuacaoElemento = document.getElementById("quiz-score");
const botaoReiniciar = document.getElementById("quiz-restart");


function carregarPergunta() {

    const pergunta = perguntasQuiz[perguntaAtual];

    perguntaElemento.textContent = pergunta.pergunta;

    numeroPerguntaElemento.textContent = perguntaAtual + 1;

    feedbackElemento.textContent = "";

    respostaSelecionada = false;

    botoesResposta.forEach(botao => {
        botao.disabled = false;
        botao.style.opacity = "1";
    });

    botaoProxima.style.display = "none";
}


botoesResposta.forEach(botao => {

    botao.addEventListener("click", () => {

        if (respostaSelecionada) {
            return;
        }

        respostaSelecionada = true;

        const resposta = botao.dataset.answer;
        const respostaCorreta = perguntasQuiz[perguntaAtual].resposta;

        botoesResposta.forEach(item => {
            item.disabled = true;
            item.style.opacity = "0.7";
        });

        if (resposta === respostaCorreta) {

            pontuacao++;

            feedbackElemento.textContent = "✅ Resposta correta!";

        } else {

            feedbackElemento.textContent = "❌ Resposta incorreta!";

        }

        botaoProxima.style.display = "block";

    });

});


botaoProxima.addEventListener("click", () => {

    perguntaAtual++;

    if (perguntaAtual < perguntasQuiz.length) {

        carregarPergunta();

    } else {

        quizCard.style.display = "none";

        quizResult.style.display = "block";

        pontuacaoElemento.textContent = pontuacao;

    }

});


botaoReiniciar.addEventListener("click", () => {

    perguntaAtual = 0;

    pontuacao = 0;

    quizResult.style.display = "none";

    quizCard.style.display = "block";

    carregarPergunta();

});


carregarPergunta();