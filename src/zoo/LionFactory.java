package zoo;

public class LionFactory extends AnimalFactory {

    @Override
    public Animal getAnimal(String shapeType) {
        if (shapeType.equalsIgnoreCase("FemaleLion")) {
            return new FemaleLion();
        } else if (shapeType.equalsIgnoreCase("MaleLion")) {
            return new MaleLion();
        }
        return null;
    }

}
