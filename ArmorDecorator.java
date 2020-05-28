public abstract class ArmorDecorator extends ItemDecorator {
    protected Armor armor;
    public ArmorDecorator(Armor armor) {
        this.armor = armor;
    }

    @Override doEffect(Character c) {
        c.setDefense(armor.getDefense());
    }
}