package zoo;

public class ChickenFactory extends AnimalFactory {

    @Override
    public Animal getAnimal(String shapeType) {
        if (shapeType.equalsIgnoreCase("Hen")) {
            return new Hen();
        } else if (shapeType.equalsIgnoreCase("Rooster")) {
            return new Rooster();
        }
        return null;
    }
}
