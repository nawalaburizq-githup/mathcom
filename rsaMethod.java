
import java.util.Scanner;

public class rsaMethod {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // إدخال المفتاح
        System.out.print("Enter p: ");
        int p = s.nextInt();

        System.out.print("Enter q: ");
        int q = s.nextInt();

        System.out.print("Enter e: ");
        int e = s.nextInt();
        s.nextLine();

        // إدخال النص
        System.out.print("Enter text: ");
        String text = s.nextLine();

        // حساب n و phi
                // المتغير phi: بنحتاجه عشان نعرف إذا قيمة e صالحة للاستخدام في RSA

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        // التحقق من e
      //  بنفحص يعني العددان e وphi ما عندهم قاسم مشترك غير 1.
        int a = e, b = phi;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        if (e <= 1 || a != 1) {
            System.out.println("Invalid e");
            return;
        }

        // تخزين النص المشفر
        String encrypted = "";

        // تشفير كل حرف
        for (int i = 0; i < text.length(); i++) {

            int m = text.charAt(i);

            if (m >= n) {
                System.out.println("n is too small");
                return;
            }

            int c = 1;

            for (int j = 0; j < e; j++) {
                c = (int)((long)c * m % n);
            }

            // تحويل الرقم المشفر إلى نص
            encrypted += c + " ";
        }

        // طباعة النص المشفر
        System.out.println("Encrypted Message: " + encrypted);

        s.close();
    }
}
