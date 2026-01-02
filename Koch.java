/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        //// Uncomment the first code block to test the curve function.
        //// Uncomment the second code block to test the snowflake function.
        //// Uncomment only one block in each test, and remember to compile
        //// the class whenever you change the test.

        
        // Tests the curve function:
        // Gets n, x1, y1, x2, y2,
        // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
        if (args.length == 5) {
            curve(Integer.parseInt(args[0]),
                  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
                  Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        }
        

        
        // Tests the snowflake function:
        // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
        if (args.length == 1) {
            snowFlake(Integer.parseInt(args[0]));
        }
        
    }

    /** Gets n, x1, y1, x2, y2,
     * and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
        } else {
            // Calculate midpoints and the triangle vertex p3
            double x_b = x1 + (x2 - x1) / 3.0;
            double y_b = y1 + (y2 - y1) / 3.0;
            
            double x_d = x1 + 2.0 * (x2 - x1) / 3.0;
            double y_d = y1 + 2.0 * (y2 - y1) / 3.0;
            
            // Formula for p3: tip of the equilateral triangle
            double x_c = (Math.sqrt(3) / 6.0) * (y1 - y2) + 0.5 * (x1 + x2);
            double y_c = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);

            // Recursive calls for the 4 segments
            curve(n - 1, x1, y1, x_b, y_b);
            curve(n - 1, x_b, y_b, x_c, y_c);
            curve(n - 1, x_c, y_c, x_d, y_d);
            curve(n - 1, x_d, y_d, x2, y2);
        }
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        
        // Define vertices for an initial equilateral triangle
        double x1 = 0.1, y1 = 0.3;
        double x2 = 1.0, y2 = 0.3;
        double x3 = 0.55, y3 = 0.3 + (Math.sqrt(3) / 2.0) * 0.9;
        
        // Draws a Koch snowflake of depth n using three curves
        curve(n, x1, y1, x3, y3);
        curve(n, x3, y3, x2, y2);
        curve(n, x2, y2, x1, y1);
    }
}