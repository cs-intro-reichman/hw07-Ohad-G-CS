/** Draws the Sierpinski Triangle fractal. */
public class Sierpinski {
    
    public static void main(String[] args) {
        if (args.length > 0) {
            sierpinski(Integer.parseInt(args[0]));
        } else {
            sierpinski(8); 
        }
    }
    
    // Draws a Sierpinski triangle of depth n on the standard canvas.
    public static void sierpinski (int n) {
        // חישוב גובה משולש שווה צלעות שאורך צלעו 1
        double h = Math.sqrt(3) / 2; 
        
        StdDraw.setPenColor(StdDraw.BLACK);
        
        // קריאה ראשונית לפונקציה הרקורסיבית עם קודקודי המשולש הגדול
        // קודקודים: (0,0), (1,0), (0.5, h)
        sierpinski(n, 0, 1, 0.5, 0, 0, h);
    }
    
    // Does the actual drawing, recursively.
    private static void sierpinski(int n, double x1, double x2, double x3,
                                         double y1, double y2, double y3) {
        // 1. תנאי עצירה: אם הגענו לעומק 0, מפסיקים
        if (n == 0) {
            return;
        }

        // 2. ציור המשולש הנוכחי לפי הקואורדינטות שהתקבלו
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);

        // 3. חישוב נקודות האמצע של שלוש הצלעות
        double m12x = (x1 + x2) / 2.0;
        double m12y = (y1 + y2) / 2.0;
        double m23x = (x2 + x3) / 2.0;
        double m23y = (y2 + y3) / 2.0;
        double m31x = (x3 + x1) / 2.0;
        double m31y = (y3 + y1) / 2.0;

        // 4. שלוש קריאות רקורסיביות עבור שלושת המשולשים בפינות
        // בכל קריאה אנחנו יורדים ברמת העומק (n-1)
        
        // משולש בפינה התחתונה-שמאלית
        sierpinski(n - 1, x1, m12x, m31x, y1, m12y, m31y);
        
        // משולש בפינה התחתונה-ימנית
        sierpinski(n - 1, m12x, x2, m23x, m12y, y2, m23y);
        
        // משולש בפינה העליונה
        sierpinski(n - 1, m31x, m23x, x3, m31y, m23y, y3);
    }
}