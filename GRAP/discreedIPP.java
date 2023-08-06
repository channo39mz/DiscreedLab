import java.util.*;
public class discreedIPP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        IPP cal = new IPP(text);
        sc.close();
    }
}

class IPP{
    private ArrayList<String> Alllist = new ArrayList<String>();
    private ArrayList<String> list1 = new ArrayList<String>();
    private ArrayList<String> list2 = new ArrayList<String>();
    private ArrayList<String> prefix = new ArrayList<String>();
    private ArrayList<String> posfix = new ArrayList<String>();
    private String str = "";
    void setstr(String a){
        this.str = a;
    }
    String getstr(){
        return this.str;
    }
    public IPP(String str){
        setstr(str);
        String[] strSplit = str.split(" ");
        for(String a : strSplit){
            Alllist.add(a);
        }
        for(String b : Alllist){
            if (b.equals("*") || b.equals("/") || b.equals("+") || b.equals("-")){
                list1.add(b);
            }
            else{
                list2.add(b);
            }
        }
        System.out.println("Infix  " + str);
        for(String a : list1){
            System.out.print(a);
        }
        System.out.println();
        for(String a : list2){
            System.out.print(a);
        }
        

    }
}
