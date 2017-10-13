package variance.covariant;

import kingdom.animalia.Animal;
import kingdom.animalia.invertebrate.Invertebrate;
import kingdom.animalia.vertebrate.mammal.primate.Primate;
import org.junit.*;

public class JavaHeapPollutionInArrayTest {

    /*
     * This one will throw an exception at runtime:
     *
     * java.lang.ArrayStoreException: kingdom.animalia.invertebrate.Invertebrate
     * at variance.covariant.JavaHeapPollutionInArrayTest.canNotStoreAnInvertebrateInAnArrayOfPrimates
     *
     * But compiles fine
     */
    @Test(expected = ArrayStoreException.class)
    public void canNotStoreAnInvertebrateInAnArrayOfPrimates() {

        Primate[] primates = new Primate[5];

        Animal[] animals =  primates;

        animals[0] = new Invertebrate();
    }

}