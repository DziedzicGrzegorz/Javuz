package UZ.Lab1_P.Grzeg;
public class Zad5 {
    private double result;
    public static void main(String[] args) {}

    public void add(double number){
        this.result += number;
    }
    public void subtract(double number){
        this.result -= number;
    }
    public void multiply(double number){
        this.result *= number;
    }
    public void divide(double number) throws Exception {
        if(number == 0){
            throw new Exception("You can't divide by 0");
        }
        this.result /= number;
    }
    public void clear(){
        this.result = 0;
    }
    public void display(){
        System.out.println(this.result);
    }
}