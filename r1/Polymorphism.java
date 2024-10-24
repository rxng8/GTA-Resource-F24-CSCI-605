/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */

class Animal {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }
}

class Dog extends Animal {
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Pig();
        Animal c = new Dog();
        Animal[] arr = {a, b, c};
        for (Animal something: arr) {
            something.animalSound();
        }
    }
}

