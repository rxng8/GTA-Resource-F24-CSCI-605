/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */
abstract class Animal2 {
    public abstract void animalSound();
    public void sleep() {
        System.out.println("Zzz");
    }
}

class Bee extends Animal2 {
    @Override
    public void animalSound() {
        System.out.println("beeez beeez!");
    }
}

public class Abstraction {

    public static void main(String[] args) {
        // This will not work
        //    Animal2 a2 = new Animal2();

        //    => override the abstract method first
        Animal2 a2 = new Animal2() {
            @Override
            public void animalSound() {
                System.out.println("Do something!");
            }
        };
        a2.animalSound();
        a2.sleep();

        // Work just fine
        Animal2 smallBee = new Bee();
        smallBee.animalSound();
    }

}


