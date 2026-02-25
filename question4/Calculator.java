
public class Calculator {

    //Part b: Create the method to pass the tests created in Part a
    // Integer division
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero not accepted.");
        }
        return (double) a / (double) b;
    }

    //Part e: Create the method to pass the tests created in Part d
    // Double division
    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException("Division by zero not accepted.");
        }
        return a / b;
    }
    
}

