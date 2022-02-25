package src.model;

class Cell extends Position{
   
    private int value; 
    private int[] markArr = new int[5]; 
    
    public Cell(int x, int y) {
        super(x, y); 
        this.value = -1; 
        for(int i = 0; i < markArr.length; i++)
            this.markArr[i] = -1; 
    }

    

    public void setValue(int value) {
        this.value = value;
    }
    

    public int getValue() {
        return value;
    }
    
    protected boolean markValue(int value){
        for(int i = 0; i < markArr.length; i++){
            if(markArr[i] == value)  break;
            if (markArr[i] == -1) {
                this.markArr[i] = value;
                return true;
            }
        }   
        return false; 
    }

    
    protected boolean unmarkValue(int value){
        for(int i = 0; i < markArr.length; i++){
            if(markArr[i] == value) {
                markArr[i] = -1; 
                this.fixIndices();
                return true;
            }    
        }
        return false;
    }

    
    private void fixIndices(){ 
        for(int i = 0; i < markArr.length-1; i++){
            int next = i+1;
            if (markArr[i] == -1 && markArr[next] != -1){ //swap 
                markArr[i] = markArr[next];
                markArr[next] = -1;
            }
        }
    }

    protected String printMarkArr(){
        String s = "[";
        
        if (markArr[0] == -1) {
            s += "]";
            return s;
        }

        for(int i = 0; i < markArr.length; i++)
            if (markArr[i] != -1) s += String.valueOf(markArr[i]) + ", "; 
        s += "\b\b]"; 
            
        return s;
    }

}
