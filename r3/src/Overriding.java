/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */


class Animal {
    public void makeSound() {
        System.out.println("<silence>"); // we don't know the sound of all animal
    }
}

class Bird extends Animal {
    @Override // Inform compiler -- not required
    public void makeSound() {
        System.out.println("Chirp");
    }
}

class Cat extends Animal {
    @Override // Inform compiler -- not required
    public void makeSound() {
        System.out.println("Meow");
    }
}

class PussInBoots extends Cat {
    @Override // Inform compiler -- not required
    public void makeSound() {
        super.makeSound();
        System.out.println("I am in boots!");
    }
}

public class Overriding {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.makeSound();

        // type animal, with constructor bird
        // compile time phase for type - runtime for actual function call
        Animal bird = new Bird();
        bird.makeSound();

        Animal cat = new Cat();
        cat.makeSound();

        Animal cat2 = new PussInBoots();
        cat2.makeSound();


    }
}
