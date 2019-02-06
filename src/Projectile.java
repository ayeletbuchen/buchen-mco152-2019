public class Projectile {

    private final double degrees, velocity;
    private double time;

    public Projectile(double velocity, double degrees) {
        this.velocity = velocity;
        this.degrees = degrees;
    }

    public void addTime(double deltaTime) {
        time += deltaTime;
    }

    public double getX() {
        return Math.cos(Math.toRadians(degrees)) * velocity * time;
    }

    public double getY() {
        return Math.sin(Math.toRadians(degrees)) * velocity * time - 9.8 * 0.5 * time * time;
    }

    @Override
    public String toString() {
        return time + " " + getX() + " " + getY();
    }
}