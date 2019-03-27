package buchen.golf;


public class Clouds {

    private Cloud[] clouds = new Cloud[12];

    public Clouds() {
        generateClouds();
    }

    private void generateClouds() {
        double[] cloudX = new double[] {0, 130, 30, 170, 350, 570, 650, 800, 1075, 950, 1125, 1225};
        int[] cloudWidth = new int[] {130, 150, 150, 195, 200, 145, 175, 160, 150, 225, 187, 145};
        int[] cloudHeight = new int[] {55, 75, 75, 120, 125, 70, 100, 85, 75, 150, 112, 70};
        int[] cloudY = new int[] {470, 230, 200, 445, 340, 460, 240, 235, 490, 470, 455, 290};

        for (int i = 0; i < clouds.length; i++) {
            clouds[i] = new Cloud(cloudX[i], cloudY[i], cloudWidth[i], cloudHeight[i]);
        }
    }

    public Cloud[] getClouds() {
        return clouds;
    }
}
