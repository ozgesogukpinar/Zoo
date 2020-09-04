package zoo;

public class SheepFactory extends AnimalFactory {

    @Override
    public Animal getAnimal(String shapeType) {
        if (shapeType.equalsIgnoreCase("FemaleSheep")) {
            return new FemaleSheep();
        } else if (shapeType.equalsIgnoreCase("MaleSheep")) {
            return new MaleSheep();
        }
        return null;
    }
}
