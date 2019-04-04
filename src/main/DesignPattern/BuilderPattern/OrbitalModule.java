package BuilderPattern;

/**
 * Created by LD on 2019/4/4.
 */
class OrbitalModule {
    private String name;
    //省略get，set，构造器


    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
