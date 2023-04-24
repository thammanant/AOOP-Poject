package Resources;

public class ClothesType {
    private final String name;
    private final String colour;

    public static ClothesType CottonWhite = new ClothesType("Cotton", "White");
    public static ClothesType CottonColoured = new ClothesType("Cotton", "Coloured");
    public static ClothesType WoolWhite = new ClothesType("Wool", "White");
    public static ClothesType WoolColoured = new ClothesType("Wool", "Coloured");
    public static ClothesType MixedWhite = new ClothesType("Mixed", "White");
    public static ClothesType MixedColoured = new ClothesType("Mixed", "Coloured");
    public static ClothesType LeatherWhite = new ClothesType("Leather", "White");
    public static ClothesType LeatherColoured = new ClothesType("Leather", "Coloured");
    public static ClothesType Baby_wearWhite = new ClothesType("Baby_wear", "White");
    public static ClothesType Baby_wearColoured = new ClothesType("Baby_wear", "Coloured");
    public static ClothesType DelicatesWhite = new ClothesType("Delicates", "White");
    public static ClothesType DelicatesColoured = new ClothesType("Delicates", "Coloured");
    public static ClothesType BeddingWhite = new ClothesType("Bedding", "White");
    public static ClothesType BeddingColoured = new ClothesType("Bedding", "Coloured");

    private ClothesType(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

}
