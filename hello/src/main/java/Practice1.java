import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;

public class Practice1 {
    public static void main(String[] args) {
        Random random = new Random();

        int ran = random.nextInt(100) +1;
        System.out.println("java.util.Random 사용");
        System.out.println("ran = " + ran);

        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

        System.out.println("org.apache.commons.math3.random.RandomDataGenerator 사용");
        int rand =randomDataGenerator.nextInt(1, 100);
        System.out.println("rand = " + rand);

    }
}
