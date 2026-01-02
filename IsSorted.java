public class IsSorted {

    // Public function: called by the user
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0);
    }

    // Helper recursive function
    private static boolean isSorted(int[] a, int i) {
    // תנאי עצירה: מערך ריק, עם איבר אחד, או שהגענו לסוף הבדיקה בהצלחה
    if (i >= a.length - 1) {
        return true; 
    }

    // בדיקה אם הזוג הנוכחי מפר את הכלל "סדר לא יורד" (כלומר הראשון גדול מהשני)
    if (a[i] > a[i + 1]) {
        return false;
    }

    // אם הכל תקין, ממשיכים לאינדקס הבא ברקורסיה
    return isSorted(a, i + 1); 
}

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
    }
}

