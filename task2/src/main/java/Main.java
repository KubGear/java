import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException
    {
        if (args.length == 1) {
            srav(args[0]);
        }
        else
            {
                System.out.println("pls use one args");
            }

    }

    //закачка файла
    public static ArrayList<Integer> Buffered(String args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args));

        ArrayList<Integer> arrayList = new ArrayList<>();

        String line = reader.readLine();
        Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()){
            arrayList.add(Integer.parseInt(matcher.group()));
        }
        reader.close();

        System.out.println(arrayList);
        return arrayList;
    }

    //создание массива точек
    public static int[][] createMassive(String args) throws IOException
    {
        ArrayList<Integer> list = Buffered(args);
        int[][] mass = new int[6][3];
        int k = 0;
        int j = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (j == 3)
            {
                j = 0;
                k++;
            }
            mass[k][j] = list.get(i);
            j++;
        }
        System.out.println(Arrays.deepToString(mass));
        return mass;
    }

    //магия сравнения
    public static void srav(String args) throws IOException
    {
        int[][] mass = createMassive(args);

        int[] ab = new int[3];
        ab[0] = Math.abs(mass[0][0] - mass[1][0]);
        ab[1] = Math.abs(mass[0][1] - mass[1][1]);
        ab[2] = Math.abs(mass[0][2] - mass[1][2]);

        int[] ac = new int[3];
        ac[0] = Math.abs(mass[0][0] - mass[2][0]);
        ac[1] = Math.abs(mass[0][1] - mass[2][1]);
        ac[2] = Math.abs(mass[0][2] - mass[2][2]);

        int[] bc = new int[3];
        bc[0] = Math.abs(mass[1][0] - mass[2][0]);
        bc[1] = Math.abs(mass[1][1] - mass[2][1]);
        bc[2] = Math.abs(mass[1][2] - mass[2][2]);
        //

        int[] ab1 = new int[3];
        ab1[0] = Math.abs(mass[3][0] - mass[4][0]);
        ab1[1] = Math.abs(mass[3][1] - mass[4][1]);
        ab1[2] = Math.abs(mass[3][2] - mass[4][2]);

        int[] ac1 = new int[3];
        ac1[0] = Math.abs(mass[3][0] - mass[5][0]);
        ac1[1] = Math.abs(mass[3][1] - mass[5][1]);
        ac1[2] = Math.abs(mass[3][2] - mass[5][2]);

        int[] bc1 = new int[3];
        bc1[0] = Math.abs(mass[4][0] - mass[5][0]);
        bc1[1] = Math.abs(mass[4][1] - mass[5][1]);
        bc1[2] = Math.abs(mass[4][2] - mass[5][2]);


        double lengsAB = Math.sqrt(ab[0]*ab[0] + ab[1]*ab[1]+ ab[2]*ab[2]);
        double lengsAC = Math.sqrt(ac[0]*ac[0] + ac[1]*ac[1]+ ac[2]*ac[2]);
        double lengsBC = Math.sqrt(bc[0]*bc[0] + bc[1]*bc[1]+ bc[2]*bc[2]);

        double lengsAB1 = Math.sqrt(ab1[0]*ab1[0] + ab1[1]*ab1[1]+ ab1[2]*ab1[2]);
        double lengsAC1 = Math.sqrt(ac1[0]*ac1[0] + ac1[1]*ac1[1]+ ac1[2]*ac1[2]);
        double lengsBC1 = Math.sqrt(bc1[0]*bc1[0] + bc1[1]*bc1[1]+ bc1[2]*bc1[2]);

        System.out.println(lengsAB);
        System.out.println(lengsAC);
        System.out.println(lengsBC);
        System.out.println(lengsAB1);
        System.out.println(lengsAC1);
        System.out.println(lengsBC1);

        double angeAB_AC = (ab[0]*ac[0] + ab[1]*ac[1] + ab[2]*ab[2])/(lengsAB*lengsAC);
        double angelAB_BC = (ab[0]*bc[0] + ab[1]*bc[1] + ab[2]*bc[2])/(lengsAB*lengsBC);
        double angelAC_BC = (ac[0]*bc[0] + ac[1]*bc[1] + ac[2]*bc[2])/(lengsAC*lengsBC);

        double angeAB_AC1 = (ab1[0]*ac1[0] + ab1[1]*ac1[1] + ab1[2]*ab1[2])/(lengsAB1*lengsAC1);
        double angelAB_BC1 = (ab1[0]*bc1[0] + ab1[1]*bc1[1] + ab1[2]*bc1[2])/(lengsAB1*lengsBC1);
        double angelAC_BC1 = (ac1[0]*bc1[0] + ac1[1]*bc1[1] + ac1[2]*bc1[2])/(lengsAC1*lengsBC1);

        System.out.println("______________________-");
        System.out.println(angeAB_AC);
        System.out.println(angelAB_BC);
        System.out.println(angelAC_BC);
        System.out.println(angeAB_AC1);
        System.out.println(angelAB_BC1);
        System.out.println(angelAC_BC1);

       ArrayList<Double> re = new ArrayList<>();
       re.add(lengsAB);
       re.add(lengsAC);
       re.add(lengsBC);

       ArrayList<Double> re1 = new ArrayList<>();
       re1.add(lengsAB1);
       re1.add(lengsAC1);
       re1.add(lengsBC1);

        Collections.sort(re);
        Collections.sort(re1);

        double sravAB = re.get(0)/re1.get(0);
        double sravAC = re.get(1)/re1.get(1);
        double sravBC = re.get(2)/re1.get(2);

        if (sravAB == sravAC && sravAB == sravBC && sravBC == sravAC){
            System.out.println("Similar in the first/yes");
        } else if ( (angeAB_AC == angeAB_AC1 && angelAB_BC == angelAB_BC1) ||
                (angeAB_AC == angeAB_AC1 && angelAC_BC == angelAC_BC1) ||
                (angelAB_BC == angelAB_BC1 && angelAC_BC == angelAC_BC1)){
            System.out.println("Similar in the second/yes");
        }else if ((sravAB == sravAC && angeAB_AC == angeAB_AC1) ||
                (sravAB == sravBC && angelAB_BC == angelAB_BC1) ||
                (sravBC == sravAC && angelAC_BC == angelAC_BC1)){
            System.out.println("Similar in the third/yes ");
        }else {
            System.out.println("Noup");
        }


    }
}
