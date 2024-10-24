/**
 * StyleExample serves as an example of recommended Java coding style.
 *
 * @author Anne Author, axa1234@rit.edu
 * @author Sumhel Per, spp1234@rit.edu
 */
public class EncapsulationDriver {

    public static void main(String[] args) {
        Car2 e = new Car2();

        // This be an error
//        System.out.println(e.name);

        // This is right
        e.setName("BWV");
        System.out.println(e.getName());
    }
}
