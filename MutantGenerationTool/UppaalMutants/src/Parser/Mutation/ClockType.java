package Parser.Mutation;

public class ClockType {
    private String name;
    public ClockType (String nameIn){
        this.name = nameIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        // Object compared to itself
        if (o == this) {
            return true;
        }

        /* Object could be an instance of ClockType
          "null instanceof [type]" also returns false */
        if (!(o instanceof ClockType)) {
            return false;
        }

        // typecast o to ClockType in order to compare their names
        ClockType c = (ClockType) o;

        // Compare the data members and return accordingly
        return this.name.equals(c.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
