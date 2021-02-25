package se.iths.weblab2;

public class FishDto {
    private int id;
    private String name;
    private String type;
    private String gender;

    public FishDto(int id, String name, String type, String gender) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
