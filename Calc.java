import java.util.Scanner;

public class Calc {
    @FunctionalInterface
    interface MathOperation {
        int operation(int x, int y);
    }
Scanner scanner = new Scanner(System.in);

    public int operate(  int a,  int b,MathOperation mathOperation) {


        return mathOperation.operation(a, b);
    }

    void calc() {
        System.out.println("Enter x:");
        int aa=scanner.nextInt();
        System.out.println("Enter y:");
        int bb = scanner.nextInt();
        MathOperation additionOp = (x, y) -> x + y;
        System.out.println( operate(aa, bb, additionOp));

        MathOperation subtractionOp = (x, y) -> x - y;
        System.out.println(operate(aa, bb, subtractionOp));



        MathOperation multiplicationOp = (x, y) -> x * y;
        System.out.println(operate(aa, bb, multiplicationOp));



        MathOperation divisionOp = (x, y) -> x / y;
        System.out.println(operate(aa, bb, divisionOp) );

}}

