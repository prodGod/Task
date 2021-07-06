import java.util.Scanner;

class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();

        if (st.matches("^\\d{1,2}[ ][\\+\\-\\*\\/][ ]\\d{1,2}$")) {
            Arab.cal(st);

        }else if (st.matches("^[IVX]{1,4}[ ][\\+\\-\\*\\/][ ][IVX]{1,4}$")){
            Roam.Calculate(st);

        }else {
            System.err.println("Неверный формат строки");
        }
    }
}