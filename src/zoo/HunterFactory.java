package zoo;

public class HunterFactory extends AnimalFactory {

    @Override
    public Animal getAnimal(String shapeType) {
        if (shapeType.equalsIgnoreCase("Hunter")) {
            return new Hunter();
        }
        return null;
    }

}
