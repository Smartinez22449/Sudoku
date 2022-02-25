package src.start;
import java.util.Scanner;

//Play inherits the SudokuField checks so that it can do logic. :P
public class Play extends src.model.SudokuField{
   
    
    private int row, column, value;
    private String command; 
    private String oldLayout; 
    private Scanner scan = new Scanner(System.in); 
    
   
    public Play(byte[][] f){
        super(f);
    }
    
    private void getData(){
        this.command = scan.next();
        this.row = scan.nextInt();
        this.column = scan.nextInt();
        this.value = scan.nextInt();  
    }    

    
    private boolean isfieldfull(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.getCellVal(i, j) == -1) return false; 
            }
        }
        return true;
    }

    
    private void printWithInstructions(){
        System.out.println("\nenter your command in one of the following forms:");
        System.out.println( 
                            "enter <row> <column> <value> /or\n"+
                            "mark <row> <column> <value> /or\n"+
                            "unmark <row> <column> <value> /or\n"+
                            "viewmarks <row> <column> 0 /or\n"+
                            "exit 0 0 0"
        );
        System.out.println(this); 
    }

    
    public void start(){
        printWithInstructions();

        boolean execute = true;
        this.oldLayout = this.toString();
        
        while(!isfieldfull() && execute){
            this.getData();
            switch(command){
                case "enter": this.setCellVal(row, column, value);  break;
                case "mark": this.mark(row, column, value);         break;
                case "unmark":  this.unmark(row, column, value);    break;
                case "viewmarks": this.viewMarks(row, column);      break;
                case "exit" : execute = false;                      break;
                default : System.out.println("your command isn't valid");   
            }

            if(!this.oldLayout.equals(this.toString())) {
                printWithInstructions();
                this.oldLayout = this.toString();
            }

        }
        if(isfieldfull()) System.out.println("YOU WIN!! :) YAHOO :)");
        
    }

    
}