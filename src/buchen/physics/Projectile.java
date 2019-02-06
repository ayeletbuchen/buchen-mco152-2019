package buchen.physics;

public class Projectile {

    private final double DEGREES;
    private final double VELOCITY;
    private double time;

    public Projectile(double velocity, double degrees) {
        VELOCITY = velocity;
        DEGREES = degrees;
    }

    public void addTime(double deltaTime) {
        time += deltaTime;
    }

    public double getX() {
        return Math.cos(Math.toRadians(DEGREES)) * VELOCITY * time;
    }

    public double getY() {
        return Math.sin(Math.toRadians(DEGREES)) * VELOCITY * time - 9.8 * 0.5 * time * time;
    }

    @Override
    public String toString() {
        return time + " " + getX() + " " + getY();
    }
}