package BuilderPattern;

/**
 * Created by LD on 2019/4/4.
 */
class Engine {
    private String name;
    //省略get，set，构造器

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
