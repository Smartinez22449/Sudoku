package src.model;
public class SudokuField{
    
    //2d array that has all the values of the Sudoku field 
    private Cell[][] field = new Cell[9][9];
  
    public SudokuField(byte[][] f){
        
        if(f.length != 9){ System.err.println("The playing field isn't valid"); System.exit(2); }
        
        for(int i = 0; i < 9; i++) 
            if(f[i].length != 9){ System.err.println("The playing field isn't valid"); System.exit(2); }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.field[i][j] = new Cell(i,j); 
                this.field[i][j].setValue(f[i][j]); 
            }
        }        
    }

    public boolean setCellVal(int x, int y, int value){
        if(isValid(x, y, value)){
            this.field[x][y].setValue(value);
            return true;
        }
        
        System.out.println("Invalid entry.");    
        return false;
    }

    
    public int getCellVal(int x, int y){
        return this.field[x][y].getValue();
    }


    private boolean isValid(int x, int y, int value){
        if (value < 1 || value > 9) return false;
        for(int i = 0; i < 9; i++){ 
            if(field[x][i].getValue() == value || field[i][y].getValue() == value) return false;
        }
        if(!isValidInSquare(x, y, value)) return false; 
        return true;
    }

    

    private boolean isValidInSquare(int x, int y, int value){ 
        int rows = -1; 
        int cols = -1; 
        
        if (x < 3) rows = 0; 
        else if(x < 6) rows = 3;
        else if(x < 9) rows = 6;

        if (y < 3) cols = 0;
        else if(y < 6) cols = 3;
        else if(y < 9) cols = 6;
       
        int limitCols = cols+3; 
        int holdCols = cols;    
        for(int limitRows = rows+3; rows < limitRows; rows++){
            for(cols = holdCols; cols < limitCols; cols++){
                if (field[rows][cols].getValue() == value) return false;
            }    
        }        
        
        return true;
    }


    public boolean mark(int x, int y, int value){
        if(this.field[x][y].markValue(value)){
            System.out.printf("Marked Value %d for (%d: %d)\n", value, x, y);
            return true;
        } 
         
        System.out.printf("Value %d was already marked for (%d: %d)\n", value, x, y);
        return false;
    }

   
    public boolean unmark(int x, int y, int value){
        if(this.field[x][y].unmarkValue(value)){
            System.out.printf("Unmarked Value %d for (%d: %d)\n", value, x, y);
            return true;
        }    

        System.out.printf("Value %d doesn't exist for (%d: %d)\n", value, x, y);
        return false;
    }

   
    public void viewMarks(int x, int y){
        System.out.println(field[x][y].printMarkArr()); 
    }

   
    @Override
    public String toString(){
        String s = "   **SUDOKU GAME**\n";

        s += " |0 1 2|3 4 5|6 7 8|";
        s += "\n-+-----+-----+-----+\n";
        
        for(int i = 0; i < 9; i++){
            s += String.valueOf(i) + "|";

            for(int j = 0, count = 1; j < 9; j++,count++){
                if (this.field[i][j].getValue() == -1) s += " ";
                else s +=  String.valueOf(this.field[i][j].getValue());
                if (count == 3){
                    s += "|";
                    count = 0;
                }else s += " ";
            }
            s += "\n";
            
            if(i+1 == 3 || i+1 == 6 || i+1 == 9) s += "-+-----+-----+-----+\n"; 
            else s += " |     |     |     |\n";
        }
        return s;
    }
}
