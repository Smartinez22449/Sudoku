
package src.model;

class Position{
   
    private int x; 
    private int y; 

   
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

  
    protected int getX() {
        return this.x;
    }

    
    protected int getY() {
        return this.y;
    }

}