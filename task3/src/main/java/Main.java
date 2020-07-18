
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Main {

    public static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args){
       doSomeone();
    }

    //добавляет воду
    public static void doTopUp(Integer upLiters, String username, Barrel barrel)
    {
            if (barrel.getCurrentValue() + upLiters <= barrel.getValue())
            {
                barrel.setCurrentValue(barrel.getCurrentValue() + upLiters);
                log.info(username + "-" + "wanna top up " + upLiters + "l " + "(успех)" );
            }
                else
                {
                log.info(username + "-" + "wanna top up " + upLiters + "l " + "(фейл)");
                }
    }
    //черпает
    public static void doScoop(Integer scoop, String username, Barrel barrel)
    {
            if (barrel.getCurrentValue() - scoop >= 0)
            {
                barrel.setCurrentValue(barrel.getCurrentValue() - scoop);
                log.info(username + "-" + "wanna scoop " + scoop + "l " + "(успех)" );
            }
                else
                {
                log.info(username + "-" + "wanna scoop " + scoop + "l " + "(фейл)");
                }
    }
    //Делание
    public static void doSomeone()
    {
        Barrel barrel = new Barrel(200, 50);
        Users users1 = new Users("user1");
        Users users2 = new Users("user2");
        log.info(barrel.getValue() + " (Объем бочки)");
        log.info(barrel.getCurrentValue() + " (Текущий объем воды в бочке)");
        for (int i = 0; i<16700; i++){
            int random =  (int) (Math.random() * 7);
            if (random == 0){ doTopUp(20, users1.getUsername(), barrel);}
            if (random == 1){ doTopUp(40, users2.getUsername(), barrel); }
            if (random == 2){ doScoop(20, users1.getUsername(), barrel);}
            if (random == 3) {doScoop(50, users2.getUsername(), barrel);}
            if (random == 4){doTopUp(30, users1.getUsername(), barrel);}
            if (random == 5){doScoop(10, users1.getUsername(), barrel);}
            if (random == 6){doTopUp(20, users2.getUsername(), barrel);}
        }
    }

    public static ArrayList<String> makeArrayListLog() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\KubGear\\Documents\\GitHub\\java\\task3\\log\\log.log"));
        String lineArg;

        ArrayList<String> list = new ArrayList<String>();
        while((lineArg = reader.readLine()) != null )
        {
            if(!lineArg.isEmpty())
            {
                list.add(lineArg);
            }
        }
        reader.close();
        return list;
    }
}

