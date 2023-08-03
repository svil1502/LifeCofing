class Base {
    static {
        System.out.println("Статический блок инициализации базового класса");
    }

    Base() {
        System.out.println("Конструктор базового класса");
    }

    {
        System.out.println("Блок инициализации базового класса");
    }
}

class Derived extends Base {
    static {
        System.out.println("Статический блок инициализации наследуемого класса");
    }

    Derived() {
        System.out.println("Конструктор наследуемого класса");
    }

    {
        System.out.println("Блок инициализации наследуемого класса");
    }
}

public class Main {
    public static void main(String[] args) {
        Derived obj = new Derived();
    }
}