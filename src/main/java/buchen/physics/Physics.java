package buchen.physics;

import java.util.ArrayList;
import java.util.Random;

public class Physics {

    public static void main(String[] args) {

        final int VELOCITY_MIN = 50;
        final int VELOCITY_MAX = 120;
        final int DEGREES_MIN = 30;
        final int DEGREES_MAX = 150;
        final int SECONDS = 120;
        final int PROJECTILE_BOUND = 6;
        Random random = new Random();
        ArrayList<Projectile> projectiles = new ArrayList<>();

        for (int i = 0; i < SECONDS; i++) {
            for (Projectile p : projectiles) {
                p.addTime(1);
            }
            int nrProjectiles = random.nextInt(PROJECTILE_BOUND);
            for (int j = 0; j < nrProjectiles; j++) {
                double velocity = (VELOCITY_MAX - VELOCITY_MIN) * random.nextDouble() + VELOCITY_MIN;
                double degrees = (DEGREES_MAX - DEGREES_MIN) * random.nextDouble() + DEGREES_MIN;
                projectiles.add(new Projectile(velocity, degrees));
            }
        }

        for (Projectile p : projectiles) {
            if (p.getY() > 0) {
                System.out.println(p);
            }
        }
    }
}
