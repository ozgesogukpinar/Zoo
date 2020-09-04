package zoo;

public class WolfFactory extends AnimalFactory {

    @Override
    public Animal getAnimal(String shapeType) {
        if (shapeType.equalsIgnoreCase("FemaleWolf")) {
            return new FemaleWolf();
        } else if (shapeType.equalsIgnoreCase("MaleWolf")) {
            return new MaleWolf();
        }
        return null;
    }
}
