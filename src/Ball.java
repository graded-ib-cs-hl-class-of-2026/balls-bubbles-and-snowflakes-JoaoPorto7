class Ball {

    /*
     * In Processing, the Sketch works a lot like the World in the turtles. You
     * can't
     * draw a ball without knowing which sketch to draw it on, so you always need to
     * specify the sketch for a Ball object.
     */

    /** The sketch that the ball is inside */
    private Sketch s;
    /** the radius of the ball */
    private float radius;
    private float x;
    private float y;
    /** The number of pixels the ball moves right per frame */
    private float xSpeed;
    /** The number of pixels the ball moves down per frame */
    private float ySpeed;
    /** The color of the inside of the ball */
    private int fillColor;
    /** The color of the outside of the ball */
    private int borderColor;

    /** Empty constructor to keep the defaults. Only sets up our link. */
    public Ball(Sketch sketch) {
        s = sketch;
        radius = 20;
        x = 100;
        y = 100;
        xSpeed = 2;
        ySpeed = -1;
        fillColor = s.color(255, 100, 100);
        borderColor = s.color(0, 0, 0);
    }

    /** Fully specified constructor to allow changes to size, position, speed */
    /** Does NOT allow changing color! Need to use setColors() for that. */
    public Ball(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;

    }

    // Accessors (getters) go here

    public float getRadius() {
        return radius;
    }

    public float getDiameter() {
        return radius * 2;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // Setters that you need go here - by default, only colors

    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }

    /**
     * Draws the ball on the given sketch
     */
    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor);
        s.circle(x, y, radius * 2);
    }

    /**
     * Moves the ball so that the next time it draws it will be in a different place
     */
    public void move() {

        /* For this code I uesed logic and hel from mr Griswold */
        double distanceToMouse = Sketch.dist(x, y, s.mouseX, s.mouseY);
        /*
         * this if statements says that when the distance to mouse is greater then the
         * radius the code for the balls to move doen't run so they stop
         */
        if (distanceToMouse > radius) {
            x = x + xSpeed;
            y = y + ySpeed;
            if (x > s.width - radius || x < radius) {
                xSpeed = -xSpeed;
            }
            if (y > s.height - radius || y < radius) {
                ySpeed = -ySpeed;
            }
        }

    }

    public boolean colliding(Ball secondBall) {
        /*this code sets a value to the distance and then checks if the ball is colliding or not */
        /*mr.Griswold teached me how to use the sketch.dist code in the code above */
        double distance = Sketch.dist(this.x, this.y, secondBall.x, secondBall.y);
        return distance < (this.radius + secondBall.radius);
    }

    /*I created this method to handle the collision */
    /*It sets the original speed to a temporary varible so it can be restored later
     * I belive I learnt this in class but I don't remember exactly when I just know it does what I need it to do
     */
    public void handleCollision(Ball secondBall) {

        if (colliding(secondBall)) {

//over here I wanted to set these to temp values because I wanted to change the ball speeds as they transfered per collision so in order the original value is not lost I created thes temp values
            float tXSpeed = this.xSpeed;
            float tYSpeed = this.ySpeed;

//this just sets the ball speed to the other ball speed
            this.xSpeed = secondBall.xSpeed;
            this.ySpeed = secondBall.ySpeed;
//this sets the other ball speed to the first ball speed
            secondBall.xSpeed = tXSpeed;
            secondBall.ySpeed = tYSpeed;
        }

    }
}
