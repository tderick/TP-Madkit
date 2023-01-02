package ors.uds.tpmadkit;

import java.util.HashMap;

import madkit.kernel.Agent;
import madkit.kernel.Message;

public class ResponderAgent extends Agent {

    protected void activate() {
    	// créer le groupe "questioners" et la communauté "qna"
        this.createGroup("qna", "questioners");
        // rejoindre le groupe "questioners"
        this.requestRole("qna", "questioners", "questioner");
                
        // créer le groupe "responders" et la communauté "qna"
        this.createGroup("qna", "responders");
        // rejoindre le groupe "responders"
        this.requestRole("qna", "responders", "responder");
    }

    protected void live() {
        while(true) {
            // attendre une question
            Message question = waitNextMessage();
                  
            if (question instanceof QuestionMessage) {
                // répondre à la question
                QuestionMessage q = (QuestionMessage)question;
                String answer = generateAnswer(q.question);
                sendReply(q, new AnswerMessage(answer, this));
            }
        }
    }

    private String generateAnswer(String question) {
        // générer une réponse à la question
    	HashMap<String, String> questions = new HashMap<>();
		questions.put("Quel est le plus long fleuve du monde?", "Le Nil");
		questions.put("Combien de pays arabes y a-t-il sur le continent africain?", "Neuf pays");
		questions.put("Quelle est la plus haute montagne du continent africain?", "Le Mont Kilimanjaro");
		questions.put("Combien de muscles dans le corps humain?", "620 muscles du corps humain");
		questions.put("Combien de dents un humain adulte a-t-il?", "Le nombre de dents est de 32 ans");
		questions.put("Quel est le métal le plus cher?", "Radium métal");
		questions.put("Quel est l’animal à mémoire le plus puissant au monde?", "Chameau");
		questions.put("Quel est le plus grand animal sur Terre?", "la girafe");
		questions.put("Quel est le nombre d’yeux d’une abeille?", "Cinq yeux");
		questions.put("Quel pays occupe la plus grande superficie du continent africain?", "Soudan");
		questions.put("Quel est l’insecte le plus rapide du monde?", "Libellule");
		questions.put("Combien de couleurs l’œil humain distingue-t-il?", "10 millions de couleurs");
		questions.put("Quel est le muscle le plus flexible du corps humain?", "la langue");
		questions.put(" Quelle est la glande responsable de la régulation du métabolisme dans le corps humain?", "Thyroïde");
		questions.put("Combien y a-t-il de dizaines dans 10 000 ?", "1000 dizaines");
		questions.put("Quel est le périmètre d’un triangle dont deux côtés mesurent 3 et 5 centimètres et dont le troisième côté est le triple du plus petit ?", "17 centimètres");
		questions.put("Quel est le quart de 5 + 41 × 3 ?", "32");
		questions.put("Quel est le plus grand nombre divisible par 4 avant 159 ?", "156");
		questions.put("Combien y a-t-il de mois qui ont au moins 4 jeudis dans un trimestre ?", "3 mois");
		questions.put("Un nombre additionné à son quart donne 35. Quel est ce nombre ?", "28");
		questions.put("Si le 5 mars d’une année est un jeudi. Quel est le jour de la semaine du 5 avril suivant ?", "Dimanche");
		questions.put("Quel est le deuxième plus petit nombre qui est divisible à la fois par 4 et par 5 ?", "40");
		questions.put("Combien y a-t-il de centaines dans un million ?", "10 000 centaines");
		questions.put("De quel nombre 24 est-il le tiers ?", "72");

        if (questions.containsKey(question)) {
            return questions.get(question);
        } else {
            return "Oops. Je n'ai pas la réponse";
        }
    }

}
