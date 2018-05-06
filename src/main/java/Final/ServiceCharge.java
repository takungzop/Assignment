package Final;
import java.util.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
class ServiceCharge {
    public static void main(String [] zzz) throws IOException {
        FileReader freader = new FileReader("C:\\Users\\Garu\\Documents\\NetBeansProjects\\Final\\src\\main\\java\\Final\\promotion1.log");
        BufferedReader inputFile = new BufferedReader(freader);
        List data  = new ArrayList();
        String line;
        while ((line = inputFile.readLine()) !=null){
            data.add(line);
        }
        inputFile.close();
            String[] raw = new String[data.size()]; 
            String[] date = new String[data.size()];
            int[] hourS = new int[data.size()];
            int[] minS = new int[data.size()];
            int[] secS = new int[data.size()];
            int[] hourF = new int[data.size()];
            int[] minF = new int[data.size()];
            int[] secF = new int[data.size()];
            String[] phone = new String[data.size()];
            String[] promo = new String[data.size()];
            Customer [] c = new Customer[data.size()];
            data.toArray(raw);
           int i=0;
            while(i<raw.length){
                date[i]=raw[i].substring(0, 10);
                hourS[i]=Integer.parseInt(raw[i].substring(11,13));
                minS[i]=Integer.parseInt(raw[i].substring(14,16));
                secS[i]=Integer.parseInt(raw[i].substring(17,19));
                hourF[i]=Integer.parseInt(raw[i].substring(20,22));
                minF[i]=Integer.parseInt(raw[i].substring(23,25));
                secF[i]=Integer.parseInt(raw[i].substring(26,28));
                phone[i]=raw[i].substring(29, 39);
                promo[i]=raw[i].substring(40, 42);
                i++;
            }
        for (int j=0;j<data.size();j++){
         c[j] = new Customer(date[j],hourS[j],minS[j],secS[j],hourF[j],minF[j],secF[j],phone[j],promo[j]);
        }

        JSONArray arr = new JSONArray();
        
        
        for(int k=0;k<c.length;k++){
               JSONObject obj = new JSONObject();
               obj.put("Phone number",c[k].telnum);
               obj.put("Service Charge",c[k].price());
                arr.add(obj);
        }
        
        try (FileWriter file = new FileWriter("C:\\Users\\Garu\\Documents\\NetBeansProjects\\Final\\src\\main\\webapp\\ServiceCharge.json")) {
			file.write(arr.toJSONString());
        }
    } 
}

class Customer{
    String date;int hour1,min1,sec1,hour2,min2,sec2;String telnum,promotion;
    Customer(String a,int b,int c,int d,int e,int f,int g,String h,String i){
        date=a;hour1=b;min1=c;sec1=d;hour2=e;min2=f;sec2=g;telnum=h;promotion=i;
    } 
    int totalsec(){return (hour2*3600+min2*60+sec2)-(hour1*3600+min1*60+sec1);}
     double price(){
        if(totalsec()<=60){
            return 3.00;
        } else {return Math.round((3.00+(totalsec()-60.00)/60.0)*100.0)/100.0;}
    }
}
