package buchen.physics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    @Test
    public void getLocationAfter3Seconds() {
        // given
        Projectile p = new Projectile(67, 48);

        // when
        p.addTime(3);

        //then
        double x = p.getX();
        double y = p.getY();
        assertEquals(134.4952518781305, x, .01);
        assertEquals(105.2721099209562, y, .01);
    }
}