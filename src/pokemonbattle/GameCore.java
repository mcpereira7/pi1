package pokemonbattle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.pokemon;
import entity.habilidade;
import entity.TypeWeakeness;
import dao.pokemonDAO;
import java.util.Random;

public class GameCore {

    static Scanner console = new Scanner(System.in);
    static Random rng = new Random();

    public static void Menu() {
        pokemon pok = new pokemon();
        List<pokemon> timePokemon = new ArrayList<>();
        List<pokemon> timePokemonIA = new ArrayList<>();
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
        timePokemon = TimePokemon(listPokemon, false);

        //ListarPokemon(timePokemon);
        //System.out.println("\nParabéns! Este é o Seu Time Pokémon Escolhido.");
        //Escolhe o Time Pokemon Do Adversário
        timePokemonIA = TimePokemon(listPokemon, true);
        //ListarPokemon(timePokemonIA);

        //Inicio da Batalha Pokemon
        batalhaPokemon(timePokemon, timePokemonIA, listPokemon);
    }

    public static boolean Inicio(List<pokemon> listPokemon) {
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
            if (cont % 7 == 0 && cont != 0) {
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

    public static List<pokemon> TimePokemon(List<pokemon> listPokemon, boolean IA) {
        boolean timeCompleto = false;
        int cont = 0, idPokemon = 0;

        List<pokemon> timePokemon = new ArrayList<>();

        while (!timeCompleto) {
            pokemonDAO pokemon = new pokemonDAO();
            if (IA) {
                idPokemon = rng.nextInt(151) + 1;
            } else {
                System.out.println("Escolha o Seu Pokémon de Número " + (cont + 1) + ": ");
                idPokemon = console.nextInt();
            }

            if (validaIdPokemon(listPokemon, idPokemon)) {
                timePokemon.add(pokemon.findPokemon(idPokemon));
                cont += 1;
            } else if (!IA) {
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
        int perc = ((hpAtual * 100) / hpInicial);
        int preto = (int) perc / 10;
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

    public static int damage(int levelPokemon, int atkPokemon, int atkGolpe, int defOponente, double stab, double efetivGolpe) {
        Random rng = new Random();
        int perc = rng.nextInt(15) + 85;
        return (int) (((((2 * levelPokemon / 5 + 2) * atkPokemon * atkGolpe / defOponente) / 50) + 2) * stab * efetivGolpe * perc / 100);

    }

    public static int hp(int hpBasePokemon, int levelPokemon) {
        return (int) (((2 * hpBasePokemon) * levelPokemon / 100) + 10 + levelPokemon);
    }

    public static void batalhaPokemon(List<pokemon> timePokemon, List<pokemon> timePokemonIA, List<pokemon> listPokemon) {
        pokemon pokemonAtual = new pokemon();
        pokemon pokemonAtualIA = new pokemon();
        habilidade hab = new habilidade();
        habilidade habIA = new habilidade();
        TypeWeakeness typeWeak = new TypeWeakeness();
        int[] dead = new int[5];
        int[] deadIA = new int[5];
        int hp = 0, hpIA = 0, hpInicial = 0, hpInicialIA = 0;
        int contHab = 0;
        int habID, habIDIA;
        int damage, damageIA;
        boolean vitoria = false, vezIA = false;
        double stab, stabIA;
        double efetiv, efetivIA;

        do {
            if (hp <= 0) {
                System.out.printf("\n *** Time Pokemon ***\n");
                ListarPokemon(timePokemon);
                System.out.println("");
                pokemonAtual = selecionarPokemon(timePokemon, dead, false);
                hp = hp(pokemonAtual.getHp(), 50);
                hpInicial = hp;
            }

            if (hpIA <= 0) {
                pokemonAtualIA = selecionarPokemon(timePokemonIA, deadIA, true);
                hpIA = hp(pokemonAtualIA.getHp(), 50);
                hpInicialIA = hpIA;
            }

            BattleLog(pokemonAtual.getName(), pokemonAtualIA.getName(), hpInicial, hp, hpInicialIA, hpIA, 0, 0);

            while (hp > 0 && hpIA > 0) {
                //Pede e guarda a habilidade escolhida pelo jogador.
                habID = escolheHabilidade(pokemonAtual.getHabilidade(), false);
                habIDIA = escolheHabilidade(pokemonAtualIA.getHabilidade(), true);

                //Seleciona a habilidade que o usuário escolheu e guarda no objeto.
                hab = selecionaHabilidade(habID, pokemonAtual.getHabilidade());
                habIA = selecionaHabilidade(habIDIA, pokemonAtualIA.getHabilidade());

                //STAB - Caso Tipo do pokemon seja igual ao tipo do golpe STAB = 1.5, se não STAB = 1
                stab = calculaStab(pokemonAtual.getType(), hab.getType());
                stabIA = calculaStab(pokemonAtualIA.getType(), habIA.getType());

                //Busca a efetivide do golpe, pelo tipo do golpe do atacante e tipo do pokemon defensor.
                efetiv = typeWeak.findWeakeness(hab.getType(), pokemonAtualIA.getType());
                efetivIA = typeWeak.findWeakeness(habIA.getType(), pokemonAtual.getType());

                // Calcula o dano que o golpe irá causar.
                damage = damage(50, pokemonAtual.getAtk(), hab.getPower(), pokemonAtualIA.getDef(), stab, efetiv);
                damageIA = damage(50, pokemonAtualIA.getAtk(), habIA.getPower(), pokemonAtual.getDef(), stabIA, efetivIA);

                if (vezIA) {
                    hp = hp - damageIA;
                    if (hp > 0) {
                        hpIA = hpIA - damage;
                    }
                } else {
                    hpIA = hpIA - damage;
                    if (hpIA > 0) {
                        hp = hp - damageIA;
                    }
                }

                BattleLog(pokemonAtual.getName(), pokemonAtualIA.getName(), hpInicial, hp, hpInicialIA, hpIA, damage, damageIA);

                if (hp <= 0) {
                    mataPokemon(pokemonAtual.getId(), dead);
                } else if (hpIA <= 0) {
                    mataPokemon(pokemonAtualIA.getId(), deadIA);
                }

                vezIA = !vezIA;
            }

            if (verificaVitoria(dead)) {
                //Mensagem dizendo que você perdeu!
                System.out.println("Não foi desta vez, mas não desista, os melhores mestres já passaram por isso!!");

                vitoria = true;
            } else if (verificaVitoria(deadIA)) {
                //Mensagem que você ganhou!
                System.out.println("Parabéns, você é um verdadeiro mestre Pokemon\nContinue treinando e se torne imbatível!!");
                vitoria = true;
            }

        } while (!vitoria);
    }

    public static habilidade selecionaHabilidade(int habililidadeID, List<habilidade> listHabPokemon) {
        habilidade hab = new habilidade();
        for (habilidade object : listHabPokemon) {
            if (object.getPosition() == habililidadeID) {
                hab = object;
            }
        }
        return hab;
    }

    public static double calculaStab(int typePokemon, int typeAtk) {
        if (typePokemon == typeAtk) {
            return 1.5;
        } else {
            return 1;
        }
    }

    public static int escolheHabilidade(List<habilidade> habList, boolean IA) {
        int habilidade;
        boolean escolhaValida = false;
        //Lista as habilidades do pokemon na tela.
        if (!IA) {
            for (habilidade i : habList) {
                System.out.printf("%d - %s \n", i.getPosition(), i.getName());
            }
        }

        do {
            if (!IA) {
                System.out.println("");
                System.out.println("Digite o ID da Habilidade: ");
                habilidade = console.nextInt();
            } else {
                habilidade = rng.nextInt(habList.size()) + 1;
            }
            escolhaValida = !(habilidade > habList.size() || habilidade < 1);
            if (!escolhaValida) {
                System.out.println("ID de Habilidade INEXISTENTE, Escolha Novamente...");
            }
        } while (!escolhaValida);
        return habilidade;
    }

    public static void BattleLog(String pokemon, String pokemonIA, int hpInicial, int hpAtual, int hpInicialIA, int hpAtualIA, int damage, int damageIA) {
        if (damage != 0 || damageIA != 0) {
            System.out.println("");
            System.out.printf("Você Causou %d de Dano e Recebeu %d de Dano!", damage, damageIA);
        }

        if (hpAtual < 0) {
            hpAtual = 0;
        }

        if (hpAtualIA < 0) {
            hpAtualIA = 0;
        }

        System.out.println("");
        System.out.println("");

        System.out.printf("%s %d HP \n", pokemon, hpAtual);
        System.out.println(DesenharHp(hpInicial, hpAtual));

        System.out.println("");

        System.out.printf("%s %d HP \n", pokemonIA, hpAtualIA);
        System.out.println(DesenharHp(hpInicialIA, hpAtualIA));

        System.out.println("");
        System.out.println("");
    }

    public static pokemon selecionarPokemon(List<pokemon> timePokemon, int[] dead, boolean ia) {
        pokemon pokemonEscolhido = new pokemon();
        boolean escolhido = false;
        int posicao = 0;
        int pokemonId;

        while (!escolhido) {
            if (!ia) {
                System.out.printf("\nEscolha um Pokemon Para a Batalha: ");
                pokemonId = console.nextInt();
            } else {
                pokemonId = timePokemon.get(posicao).getId();
                posicao++;
            }

            if (!verificaMorte(pokemonId, dead)) {
                if (validaIdPokemon(timePokemon, pokemonId)) {
                    escolhido = true;
                    for (pokemon object : timePokemon) {
                        if (object.getId() == pokemonId) {
                            pokemonEscolhido = pokemonEscolhido.findPokemon(pokemonId);
                            break;
                        }
                    }
                } else {
                    System.out.printf("\nO Pokemon Escolhido Não Faz Parte do Seu Time, Tente Novamente.\n");
                }
            } else {
                if (!ia) {
                    System.out.printf("\nEste Pokemon Já Está Morto! Escolha Outro...\n");
                }
            }

        }

        return pokemonEscolhido;
    }

    public static boolean verificaMorte(int pokemonId, int[] dead) {
        boolean morte = false;
        for (int i = 0; i < dead.length; i++) {
            if (dead[i] == pokemonId) {
                morte = true;
            }
        }
        return morte;
    }

    public static int[] mataPokemon(int pokemonMorto, int[] dead) {
        for (int i = 0; i < dead.length; i++) {
            if (dead[i] == 0) {
                dead[i] = pokemonMorto;
                break;
            }
        }
        return dead;
    }

    public static boolean verificaVitoria(int[] dead) {
        boolean vitoria = true;

        for (int i = 0; i < dead.length; i++) {
            if (dead[i] == 0) {
                vitoria = false;
                break;
            }
        }
        return vitoria;
    }
    
}
