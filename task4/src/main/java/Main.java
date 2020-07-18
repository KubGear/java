
public class Main {

    public static void main(String[] args)
    {
        String a = args[0];
        String b = args[1];

        char meta = '*';
        int chek = 0;
        int srav = 0;

        int indexB = b.indexOf(meta);

        char[] srtToArrayA = a.toCharArray();
        char[] strToArratB = b.toCharArray();

        //заменяет * на букву
        for (int i = 0; i < strToArratB.length; i++)
        {
            if (strToArratB[0] == '*')
            {
                break;
            }

            if (strToArratB[i] == '*')
            {
                strToArratB[i] = strToArratB[i - 1];
            }
        }

        //определяет по какому пути пойти
        if (srtToArrayA.length < strToArratB.length)
        {
            srav = srtToArrayA.length;
        }
        else
        {
            srav = strToArratB.length;
        }

        //счетчик сравнения
        for (int j = 0; j < srav; j++)
        {
            if (srtToArrayA[j] == strToArratB[j])
            {
                chek++;
            }
        }
        if (b == "" || a == "")
        {
        chek++;
        }

        //блок условий
        if (((chek == srav) || strToArratB[0] == '*' ) && indexB != -1){System.out.println("OK");}
        else if (indexB == -1 && a.equals(b)){System.out.println("OK");}
        else {System.out.println("KO");}
    }
}
