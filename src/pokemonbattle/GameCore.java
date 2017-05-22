package pokemonbattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.habilidade;
import entity.pokemon;
import dao.pokemonDAO;

public class GameCore {

    public static void Menu() {
        pokemon pok = new pokemon();
        //Arrumar esta lista.
        List<pokemon> timePokemon = new ArrayList<>();
        List<pokemon> listPokemon = pok.findAll();
        BoasVindas();

        if (Inicio(listPokemon) == false) {
            System.exit(0);
        }
        //Lista todos os Pokemons na tela.
        System.out.println("\n*** Lista Pokemon ***");
        ListarPokemon(listPokemon);
        System.out.println("\nOlá, Inicialmente Escolha o Seu Time de 6 Pokemon's. Boa Sorte!\n");
        
        //Lista o Time Pokemon Escolhido
        timePokemon = TimePokemon(listPokemon);
        System.out.printf("\n *** Time Pokemon ***\n");
        ListarPokemon(timePokemon);
        System.out.println("\nParabéns! Este é o Seu Time Pokémon Escolhido.");
    }

    public static boolean Inicio(List<pokemon> listPokemon) {
        Scanner console = new Scanner(System.in);
        System.out.println("ESTA PREPARADO PARA ESTA AVENTURA?");
        System.out.println(" ---------        ---------");
        System.out.println("| 1 - SIM |      | 2 - NÃO |");
        System.out.println(" ---------        ---------");
        System.out.print("RESPOSTA: ");

        if (console.nextInt() == 1) {
            return true;
        } else {
            System.out.println("\nQue Pena... Até a Próxima!");
            return false;
        }
    }

    public static void ListarPokemon(List<pokemon> listPokemon) {
        int cont = 0;
        String concat = "", indent = "                    ", formatPokemon = "";
        //SE QUISER MOSTRAR MAIS INFORMAÇÕES DO POKEMON PARA O USUÁRIO MEXER AQUI.
        //lista todos os pokemons.
        for (pokemon object : listPokemon) {
            if (cont%7 == 0 && cont != 0){
                System.out.println(concat);
                concat = "";
            }
            formatPokemon = object.getId() + " - " + object.getName();
            concat += (formatPokemon + indent.substring(0, indent.length() - formatPokemon.length()));
            cont++;
        }
        //Imprime caso sobre registros fora da quantidade de colunas.
        System.out.println(concat);
    }

    public static void BoasVindas() {
        System.out.println("   _____      _                   ____                         _           _                           _____      _                                ____        _   _   _        _ \n"
                + "  / ____|    (_)                 |  _ \\                       (_)         | |                         |  __ \\    | |                              |  _ \\      | | | | | |      | |\n"
                + " | (___   ___ _  __ _ _ __ ___   | |_) | ___ _ __ ___   __   ___ _ __   __| | ___  ___    __ _  ___   | |__) |__ | | _____ _ __ ___   ___  _ __   | |_) | __ _| |_| |_| | ___  | |\n"
                + "  \\___ \\ / _ \\ |/ _` | '_ ` _ \\  |  _ < / _ \\ '_ ` _ \\  \\ \\ / / | '_ \\ / _` |/ _ \\/ __|  / _` |/ _ \\  |  ___/ _ \\| |/ / _ \\ '_ ` _ \\ / _ \\| '_ \\  |  _ < / _` | __| __| |/ _ \\ | |\n"
                + "  ____) |  __/ | (_| | | | | | | | |_) |  __/ | | | | |  \\ V /| | | | | (_| | (_) \\__ \\ | (_| | (_) | | |  | (_) |   <  __/ | | | | | (_) | | | | | |_) | (_| | |_| |_| |  __/ |_|\n"
                + " |_____/ \\___| |\\__,_|_| |_| |_| |____/ \\___|_| |_| |_|   \\_/ |_|_| |_|\\__,_|\\___/|___/  \\__,_|\\___/  |_|   \\___/|_|\\_\\___|_| |_| |_|\\___/|_| |_| |____/ \\__,_|\\__|\\__|_|\\___| (_)\n"
                + "            _/ |                                                                                                                                                                  \n"
                + "           |__/                                                                                                                                                                   \n");
    }

    public static List<pokemon> TimePokemon(List<pokemon> listPokemon) {
        Scanner console = new Scanner(System.in);
        boolean timeCompleto = false;
        int cont = 0, idPokemon = 0;

        List<pokemon> timePokemon = new ArrayList<>();

        while (!timeCompleto) {
            pokemonDAO pokemon = new pokemonDAO();
            System.out.println("Escolha o Seu Pokémon de Número " + (cont + 1) + ": ");
            idPokemon = console.nextInt();

            if (validaIdPokemon(listPokemon, idPokemon) == true) {
                timePokemon.add(pokemon.findPokemon(idPokemon));
                cont += 1;
            } else {
                System.out.println("POKEMON ESCOLHIDO NÃO EXISTE. DIGITE CONFORME O ID DA TABELA APRESENTADA.");
            }

            if (cont == 6) {
                timeCompleto = true;
            }
        }

        return timePokemon;
    }

    public static boolean validaIdPokemon(List<pokemon> listPokemon, int idPokemon) {
        //verifica se o id do pokemon escolhido está na lista de pokemons.
        return listPokemon.stream().anyMatch((object) -> (object.getId() == idPokemon));
    }
    
    public static String DesenharHp(int hpInicial, int hpAtual) {
        int perc = ((hpAtual*100)/hpInicial);
        int preto = (int) perc/10;
        int branco = (10 - preto);
        String desenhoPreto = "", desenhoBranco = "";
        
        for (int i = 1; i <= preto; i++) {
            desenhoPreto += "▮";
        }
        
        for (int i = 1; i <= branco; i++) {
            desenhoBranco += "▯";
        }
        
        return desenhoPreto + desenhoBranco;
    }
}
