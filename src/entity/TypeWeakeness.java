package entity;

import dao.typeWeakenessDAO;

public class TypeWeakeness {

    private int id;
    private int typeAtk;
    private int typeDef;
    private int power;

    public TypeWeakeness() {

    }

    public TypeWeakeness(int id, int typeAtk, int typeDef, int power) {
        this.id = id;
        this.typeAtk = typeAtk;
        this.typeDef = typeDef;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeAtk() {
        return typeAtk;
    }

    public void setTypeAtk(int typeAtk) {
        this.typeAtk = typeAtk;
    }

    public int getTypeDef() {
        return typeDef;
    }

    public void setTypeDef(int typeDef) {
        this.typeDef = typeDef;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double findWeakeness(int typeAtk, int typeDef) {
        typeWeakenessDAO typeWeakeness = new typeWeakenessDAO();
        return typeWeakeness.findPower(typeAtk, typeDef);
    }
}
