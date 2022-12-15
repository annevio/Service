import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {
    public static <FileWrite> void main(String[] args) throws IOException {

        FileWrite fw= null;
        try{
             fw = (FileWrite) new FileWriter("./test.txt", false);
        }catch (IOException e){
            e.printStackTrace();
        }

        ArrayList<Service> list = new ArrayList<>();
        for(int i=0;i<=10;i++){
            list.add(new Service("Thread # "+i, (FileWriter) fw));
        }

        for(Service s:list){
            s.start();
            /*try{
                s.join();
            }
            catch(Exception e){
                e.getStackTrace();
            }*/
        }
    }
}
