package zoo;

public class CowFactory extends AnimalFactory {

    @Override
    public Animal getAnimal(String shapeType) {
        if (shapeType.equalsIgnoreCase("Cow")) {
            return new Cow();
        } else if (shapeType.equalsIgnoreCase("Bull")) {
            return new Bull();
        }
        return null;
    }
}
