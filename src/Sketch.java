import processing.core.PApplet;

/*This code allows me to load a image from the processing */
/*https://hub.jmonkeyengine.org/t/how-to-set-a-background-texture/22996, https://www.youtube.com/watch?v=tHNWIWxRDDA */
import processing.core.PImage;

public class Sketch extends PApplet {

    /** Represents one ball */
    private Ball ball1;
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;


  
    private Bubble bub1;
    private Bubble bub2;
    private Bubble bub3;
    private Bubble bub4;


    private Snowflake sf1;
    private Snowflake sf2;
    private Snowflake sf3;
    private Snowflake sf4;
    
    /*This line of code allows me to create a new varible named background Texture */
    private PImage backgroundTexture;
    /**
     * This method can only be used to change the window size. It runs before the
     * window is created.
     */
    public void settings() {
        size(500, 500);
    }

    /**
     * Runs once at the beginning of the program, after the window is created. Use
     * this to initialize the sketch.
     */
    public void setup() {

        /*This sets the background texture varible  to the loaded image from the library  */
        backgroundTexture = loadImage("texture.jpg");



        ball1 = new Ball(this);
        ball2 = new Ball(this, 30, 250, 200, 10, 10);
        ball3 = new Ball(this, 10, 150, 400, 5, 5);
        ball4 = new Ball(this, 50, 350, 100, -5, 5);
        bub1 = new Bubble(this);
        bub2 = new Bubble(this, 40, 200, 40, 0, -3);
        bub3 = new Bubble(this, 10, 400, 20, -1, -5);
        bub4 = new Bubble(this, 50, 100, 500, 1, -5);
        sf1 = new Snowflake(this);
        sf2 = new Snowflake(this, 10, 300, 200, 0, 4);
        sf3 = new Snowflake(this, 30, 200, 20, 1, 3);
        sf4 = new Snowflake(this, 45, 200, 300, -1, 2);

    
        ball3.setColors(color(0, 0, 255),0);
        ball4.setColors(color(0, 255, 0),0);
    }

    /**
     * This method runs over and over and over, approximately 60 times per second!
     * By moving objects a tiny bit each frame, you can get the appearance of
     * movement.
     */
    public void draw() {

        /* This finally aplies the background image before every new frame */
        background(backgroundTexture);

 
/*this draws the balls and then moves it according to the speeds previously defined */
        ball1.draw();
        ball1.move();
        ball1.handleCollision(ball2);
        ball1.handleCollision(ball3);
        ball1.handleCollision(ball4);

        ball2.draw();
        ball2.move();
        ball2.handleCollision(ball1);
        ball2.handleCollision(ball3);
        ball2.handleCollision(ball4);

        
        ball3.draw();
        ball3.move();
        ball3.handleCollision(ball2);
        ball3.handleCollision(ball1);
        ball3.handleCollision(ball4);

        ball4.draw();
        ball4.move();
        ball4.handleCollision(ball2);
        ball4.handleCollision(ball3);
        ball4.handleCollision(ball1);



        bub1.draw();
        bub1.move();

        bub2.draw();
        bub2.move();

        bub3.draw();
        bub3.move();

        bub4.draw();
        bub4.move();

        sf1.draw();
        sf1.move();

        sf2.draw();
        sf2.move();

        sf3.draw();
        sf3.move();

        sf4.draw();
        sf4.move();

    //I looked at Felipes code and Mr Griswold helped me with this however I don't quite understand it but it does what I need it to do 
        if (keyPressed && key == 'r') { 
        bub1.reset();
        bub2.reset();
        bub3.reset();
        bub4.reset();
    }
        
    
    }



    /** All processing sketches have to use this main method. Don't touch this! */
    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}
