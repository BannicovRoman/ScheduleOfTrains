package Project.essence;

public class Train {
    private int id;
    private String name;

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