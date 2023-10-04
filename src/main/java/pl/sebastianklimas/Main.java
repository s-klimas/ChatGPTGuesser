package pl.sebastianklimas;

import pl.sebastianklimas.chatGPT.Engine;
import pl.sebastianklimas.chatGPT.Message;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Witamy w ChatGPTGuesser!\nGra jest oparta o techonolgię ChatGPT\nPromptujemy chat by wybrał losowy rzeczownik a Twoim zadaniem jest zadawanie pytań i odgadnięcie tego rzeczownika!\nPowodzenia ;)\n(Jeżeli odpowiedź chatu nie ma sensu klawisz \"r\" resetuje historie pytań, a klawisz \"q\" wyłącza rozgrywkę)");

        String fp = "Rozpocznij grę w zgadywanie. Wymyśl słowo, a ja spróbuje odgadnąć, co to jest, zadając Ci pytania. Odpowiadaj 'tak' lub 'nie'.";
        Message firstPrompt = new Message("user", fp);
        String answer = Engine.askChatGPT(firstPrompt);
        System.out.println(answer);

        Scanner sc = new Scanner(System.in);

        while(true) {
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("r")) {
                System.out.println("Zaczynamy od nowa");
                Engine.reset();
                System.out.println(Engine.askChatGPT(firstPrompt));
            }
            if (userInput.equalsIgnoreCase("q")) {
                break;
            }
            Message message = new Message("user", userInput);
            String response = Engine.askChatGPT(message);
            System.out.println(response);
        }
    }
}
