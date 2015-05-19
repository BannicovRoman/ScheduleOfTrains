package Project.essence;

public class Train {
    private int id;
    private String name;
    private String machinist;
    private int numberOfCoach;

    public Train() {
    }

    public Train(int id, String name, String machinist, int numberOfCoach) {
        this.id = id;
        this.name = name;
        this.machinist = machinist;
        this.numberOfCoach = numberOfCoach;
    }

    public String getMachinist() {
        return machinist;
    }

    public void setMachinist(String machinist) {
        this.machinist = machinist;
    }

    public int getNumberOfCoach() {
        return numberOfCoach;
    }

    public void setNumberOfCoach(int numberOfCoach) {
        this.numberOfCoach = numberOfCoach;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Train train = (Train) obj;
        if (name == null) {
            if (train.name != null)
                return false;
        } else if (!name.equals(train.name))
            return false;
        return true;
    }
}