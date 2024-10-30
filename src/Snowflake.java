

class Snowflake {
    // ONLY THE DRAW METHOD IS INCLUDED. YOU MUST FINISH THE REST.
      private Sketch s;
      private float radius;
      private float x;
      private float y;
      private float xSpeed;
      private float ySpeed;
      private int fillColor; 
      private int borderColor;

      public Snowflake(Sketch sketch){
        s = sketch;
        radius = 20;
        x = 250;
        y = 200;
        xSpeed = 0;
        ySpeed = 3;
        fillColor = s.color(255, 255, 255);
        borderColor = s.color(255, 255, 255);
    }




    public Snowflake(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
        fillColor = s.color(255, 255, 255);
        borderColor = s.color(255, 255, 255);
    }


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
  
    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }


    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor);
        s.line(x+radius,y,x-radius,y);
        s.line(x,y+radius,x,y-radius);
        s.line(x+radius*.707f,y+radius*.707f,x-radius*.707f,y-radius*.707f);
        s.line(x+radius*.707f,y-radius*.707f,x-radius*.707f,y+radius*.707f);
       
    }


    public void move() {
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
    }

}


