
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException
    {
        if (args.length == 1)
        {
            ShowResult(args[0]);
        }
        else
            {
                System.out.println("Pls use one args");
            }
    }

    //метод находит значение процентиля
    public static long Percentile(ArrayList<Integer> list, double percentile)
    {
        Collections.sort(list);
        int index = (int) Math.ceil((percentile/100) * list.size());
        return list.get(index-1);
    }
    //метод находит среднее арифмитическое
    public static double Mean(ArrayList<Integer> list)
    {
        double summ = list.stream().mapToInt( a -> a).sum();
        double mean = summ/(list.size());
        return mean;
    }

    //метод находит файл по аргументу командной строки и возвращает массив значений
    public static ArrayList<Integer> Buffered(String args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args));
        String lineArg;

        ArrayList<Integer> list = new ArrayList<Integer>();
        while((lineArg = reader.readLine()) != null )
        {
            if(!lineArg.isEmpty())
            {
                list.add(Integer.parseInt(lineArg));
            }
        }
        reader.close();
        return list;
    }

    //метод выводит результат сложения отфильтрованных элеметов массива
    public static void ShowResult(String args) throws IOException 
    {
        ArrayList<Integer> arrayList = Buffered(args);

        long percentile = Percentile(arrayList, 90);//значение процентиля
        double mean = Mean(arrayList);//среднее арифмитическое

        //фильтр на значения в диапазоне mean < x < parcentile, и сложение числе которые находятся в нем
        int summ = arrayList.stream().filter(s -> s > mean && s < percentile).mapToInt(s -> s).sum();
        System.out.println(summ);
    }
}
