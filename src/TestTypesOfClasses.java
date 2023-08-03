import java.util.ArrayList;
import java.util.List;

interface AbleToEat {
    public void eat();
}
class Animal implements AbleToEat {

    @Override
    public void eat() {
        System.out.println("Eat");

    }
}
public class TestTypesOfClasses {
    public static void main(String[] args) {
        AbleToEat ableToEat = new Animal();
        ableToEat.eat();

        AbleToEat ableToEat2 = new Animal() {
            @Override
            public void eat() {
                System.out.println("Eat2");
            }
        };

        System.out.println(DAys.values());
        System.out.println();
        List<Color> colors = new ArrayList<>(List.of(Color.BLUE,Color.RED));

    }
}