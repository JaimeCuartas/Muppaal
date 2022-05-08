package Parser.Mutation;

public class ChanType {
    private String name;
    private int dimension;
    public ChanType(String nameIn, int dimensionIn){
        this.name = nameIn;
        this.dimension = dimensionIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
