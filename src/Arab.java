public  class Arab {


    public static void cal(String st) {
        try {

            int a = Integer.parseInt(st.split(" ")[0]);
            int b = Integer.parseInt(st.split(" ")[2]);
            if (a < 0 || a > 10 || b < 0 || b > 10) {
                try {
                    throw new Exception("Калькулятор работает с значениями от 1 до 10");
                } catch (Exception e) {

                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            }

            switch (st.split(" ")[1]) {
                case ("+"):
                    plus(a, b);
                    break;
                case ("-"):
                    minus(a, b);
                    break;
                case ("*"):
                    multiply(a, b);
                    break;
                case ("/"):
                    division(a, b);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Неверный формат записи");
        }

    }

    private static void division(int a, int b) {
        System.out.println(a / b);
    }

    private static void minus(int a, int b) {
        System.out.println(a - b);
    }

    private static void plus(int a, int b) {
        System.out.println(a + b);
    }

    private static void multiply(int a, int b) {
        System.out.println(a * b);

    }
}