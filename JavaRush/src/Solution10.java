
    /*
������ � �������� ������ �������
*/

    public class Solution10 {
        public static final String ODD = "��������";
        public static final String EVEN = "׸����";
        public static String[] strings = new String[5];

        public static void main(String[] args) {
            //�������� ��� ��� ���
            //String[] array = new String[5];

            int i = 0;

            for (i = 0; i < 5; i++) {
                if (i % 2 == 0) {
                    strings[i] = EVEN;
                } else strings[i] = ODD;
            }


            System.out.print("index = 0");
            System.out.println(" value = " + strings[0]);
            System.out.print("index = 1");
            System.out.println(" value = " + strings[1]);
            System.out.print("index = 2");
            System.out.println(" value = " + strings[2]);
            System.out.print("index = 3");
            System.out.println(" value = " + strings[3]);
            System.out.print("index = 4");
            System.out.println(" value = " + strings[4]);


        }
}
