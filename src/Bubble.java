/** THE ENTIRE CLASS IS INSIDE A COMMENT RIGHT NOW. TO ENABLE THE CLASS, DELETE THIS LINE AND THE LAST ONE.
*/
class Bubble {

    //MISSING MANY INSTANCE VARIABLES

    
      private Sketch s;
      private float radius;
      private float x;
      private float y;
      private float xSpeed;
      private float ySpeed;
      private int fillColor; 
      private int borderColor;

// this is an instant variable for the original value of the radius so it can be used later

      private float originalRadius;
  

    public Bubble(Sketch sketch){
        s = sketch;
        radius = 20;
        x = 250;
        y = 200;
        xSpeed = 0;
        ySpeed = -3;
        fillColor = s.color(255, 255, 255, 0);
        borderColor = s.color(0, 0, 0);
        
    }

    public Bubble(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;

        //this code sets the instance varible to the radius
        this.originalRadius = radius;
    }

    // accessors for the radius, diameter, x, and y values 
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
    



    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor, 0);
        s.circle(x, y, radius*2);
    }

 




    public void move() {

        //same logic as the ball code
        double distBub = Sketch.dist(x, y, s.mouseX, s.mouseY);
        
        x = x + xSpeed;
        y = y + ySpeed;
        if (x > s.width - radius) {
            x = radius;
        } else if(x < radius) {
            x = s.width - radius;
        } else if (y > s.height - radius) {
            y = radius;
        } else if (y < radius) {
            y = s.height - radius;
        }

/* This code uses the same logic and thinking of the code that makes the ball stop however it also requires a mouse press in ordeer to run
 * It makes it so it sets the radius to 0 making the bubbles so tiny that they disappear so the user feels like they popped the bubble
 */
        if (s.mousePressed && distBub < radius) {    
            radius = 0;
        }
    }
// this is the reset method and it just resets the radius to its original value 
    public void reset() {
        radius = originalRadius;
    }

}
