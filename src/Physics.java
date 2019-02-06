import java.util.ArrayList;
import java.util.Random;

public class Physics {

    public static void main(String[] args) {

        /*Projectile p1 = new Projectile(50, 67);

        for (int i = 0; i <= 10; ++i) {
            System.out.println(p1);
            p1.addTime(1);
        }*/
        final int velocityMin = 50, velocityMax = 120, degreesMin = 30, degreesMax = 150, seconds = 120, projectileBound = 6;
        Random random = new Random();
        ArrayList<Projectile> projectiles = new ArrayList<>();

        for (int i = 0; i < seconds; i++) {
            for (Projectile p : projectiles) {
                p.addTime(1);
            }
            int nrProjectiles = random.nextInt(projectileBound);
            for (int j = 0; j < nrProjectiles; j++) {
                double velocity = (velocityMax - velocityMin) * random.nextDouble() + velocityMin;
                double degrees = (degreesMax - degreesMin) * random.nextDouble() + degreesMin;
                projectiles.add(new Projectile(velocity, degrees));
            }
        }

        for (Projectile p : projectiles) {
            if (p.getY() > 0) System.out.println(p);
        }
    }
}
