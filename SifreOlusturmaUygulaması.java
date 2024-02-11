import java.util.Scanner;
public class RekürsifFonksiyonOrnegi {
    public static void main(String[] args) {
        System.out.println(sifreOlusturma());
    }

    public static String sifreOlusturma()
    {
        boolean buyukHarfVarmi = false;
        boolean rakamVarmi = false;
        boolean uzunlukYeterlimi = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen şifrenizi belirleyiniz. Şifreniz en az 8 karakter olmalı, bir büyük harf ve bir rakam içermelidir.");
        char[] sifre = input.nextLine().toCharArray(); //Şİfreyi karakter dizisine dönüştürme amacımız hepsini teker teker değerlendireceğimizden dolayı.

        for (int j = 0; j < sifre.length; j++) {
            if (Character.isDigit(sifre[j])) {
                rakamVarmi = true;
                break;
            } else {
                rakamVarmi = false;
            }
            if (Character.isUpperCase(sifre[j])) {
                buyukHarfVarmi = true;
                break;
            } else {
                buyukHarfVarmi = false;
            }
        }
        if (sifre.length >= 8) uzunlukYeterlimi=true;
        // if ve else bloklarını tek satırlık bir ifade yazacaksak eğer bu şekilde de kullanılabilir..
        else uzunlukYeterlimi=false;

        if (buyukHarfVarmi && rakamVarmi && uzunlukYeterlimi) //Yukarıda teker teker denediğimiz kriterlerin hepsi doğru ise sıradaki işleme geçiyoruz..
        {
            System.out.println("Harika! Şifrenizi oluşturdunuz şimdi ise onaylamak için lütfen tekrar yazınız.");
            for (int i = 0; i < 3; i++) {
                char[] sifre1 = input.nextLine().toCharArray();
                if (sifre1.equals(sifre)) {
                    System.out.println("Şifreniz onaylandı.");
                    break;
                } else
                    System.out.println("Maalesef girmiş olduğunuz şifreler eşleşmiyor. Tekrar deneyiniz. Kalan hakkınız: " + (2 - i));
            }
        }
        else
        {
            System.out.println("Girdiğiniz şifre kriterlere uygun değil. Tekrar deneyiniz.");
            sifreOlusturma();
            // Bu kısım Rekürsif Fonksiyonlara bir örnektir. Rekürsif fonksiyon ise, fonksiyonun kendini tekrar tekrar çağırmasıdır.
            // Daha detaylı anlaatcak olursak, kendini çağıran fonksiyonlardır. Yani,
            // burada sifreOlusturma adı altında bir String değer döndüren bir fonksiyon tanımlamıştık,
            // bu fonksiyon kullanıcı şifreyi oluşturamadığı durumda kendini tekrar çalıştırarak programın ilk deneyişte kapanmamasını sağlayacak ve
            // kullanıcı dostu bir algoritmaya sahip olmasını sağlayacaktır. 
        }
        String ssifre=String.valueOf(sifre);
        input.close();
        System.exit(0);
        return ssifre;
    }
}