package zoo;

public class AnimalProducer {

    public static AnimalFactory getFactory(String animalType) {
        if (animalType == "SheepFactory") {
            return new SheepFactory();
        } else if (animalType == "ChickenFactory") {
            return new ChickenFactory();
        } else if (animalType == "WolfFactory") {
            return new WolfFactory();
        } else if (animalType == "LionFactory") {
            return new LionFactory();
        } else if (animalType == "CowFactory") {
            return new CowFactory();
        } else if (animalType == "HunterFactory") {
            return new HunterFactory();
        }
        return null;
    }
}
