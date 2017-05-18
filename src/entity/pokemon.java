package entity;

import dao.pokemonDAO;
import java.util.List;

public class pokemon {
//ID	Name	HP	Atk	Def	SA	SD	Spd	Total	Type

    private int id;
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int sa;
    private int sd;
    private int spd;
    private int total;
    private String type;
    private List<habilidade> habilidade;
    
    public pokemon() {
    }

    public pokemon(int id, String name, int hp, int atk, int def, int sa, int sd, int spd, int total, String type, List<habilidade> habilidade) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.sa = sa;
        this.sd = sd;
        this.spd = spd;
        this.total = total;
        this.type = type;
        this.habilidade = habilidade;
    }
    
    

    public List<habilidade> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(List<habilidade> habilidade) {
        this.habilidade = habilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSa() {
        return sa;
    }

    public void setSa(int sa) {
        this.sa = sa;
    }

    public int getSd() {
        return sd;
    }

    public void setSd(int sd) {
        this.sd = sd;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public List<pokemon> findAll(){
        pokemonDAO pokemon = new pokemonDAO();
        return  pokemon.findAll();
    }

}
