import java.util.Stack;
import java.util.*;
import java.lang.Character;

public class InPrePos {
    private static boolean letterOrDigit(char c)
    {
        if (Character.isLetterOrDigit(c))
            return true;
        else
            return false;
    }

    static int getPrecedence(char ch)
    {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else
            return -1;
    }
      static boolean hasLeftAssociativity(char ch) {
        if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            return true;
        } else {
            return false;
        }
    }

    static String infixToPos(String expression)
    {
        Stack<Character> stack = new Stack<>();

        String output = new String("");
 
        for (int i = 0; i < expression.length(); ++i) {

            char c = expression.charAt(i);

            if (letterOrDigit(c))
                output += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')') {
                while (!stack.isEmpty()
                       && stack.peek() != '(')
                    output += stack.pop();
 
                stack.pop();
            }
 
            else {
                while (
                    !stack.isEmpty()
                    && getPrecedence(c)
                           <= getPrecedence(stack.peek())
                    && hasLeftAssociativity(c)) {
 
                    output += stack.pop();
                }
                stack.push(c);
            }
        }
 
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "This expression is invalid";
            output += stack.pop();
        }
        
        return output;
    }
    static boolean isOperator(char x)
    {
 
        switch (x) {
        case '+':
        case '-':
        case '/':
        case '*':
            return true;
        }
        return false;
    }

    static String postToPre(String post_exp)
    {
        Stack<String> s = new Stack<String>();
        int length = post_exp.length();

        for (int i = 0; i < length; i++) {
            if (isOperator(post_exp.charAt(i))) {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                String temp
                    = post_exp.charAt(i) + op2 + op1;
                s.push(temp);
            }
            else {
                s.push(post_exp.charAt(i) + "");
            }
        }

        String ans = "";
        for (String i : s)
            ans += i ;
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String q = sc.nextLine();
        String expression = q.replace(" ", "");;
        sc.close();
        System.out.println("Infix  : " + expression);
        System.out.println("Posfix : " + infixToPos(expression));
        String post = infixToPos(expression);
 
        System.out.println("Prefix : " + postToPre(post));

        tree(post, post.length());
    }
    static void tree(String a , int len){
        ArrayList<Character> r = new ArrayList<Character>();
        ArrayList<Character> nextline = new ArrayList<Character>();
        Boolean isone = true;
        for(int i = 0; i < len; i++){
            r.add(a.charAt(i));
        }
        System.out.println(r);
        while(!(r.isEmpty())){
            Character w = r.get(len-1);
            if ((w == '+' || w == '-' || w == '*' || w == '/') && isone){
                for(int i = 0; i < len; i++){
                    System.out.print(" ");
                }
                nextline.add(w);
                for(int i = 0; i < nextline.size(); i++){
                    System.out.print(nextline.get(nextline.size()-1-i) + "  ");
                }
                nextline.clear();
                System.out.println();
                isone = false;
            }
            else if ((w == '+' || w == '-' || w == '*' || w == '/') && !(isone)){
                for(int i = 0; i < len - 2; i++){
                    System.out.print(" ");
                }
                for(int j = 0; j < 2; j++){
                    for(int k = 1; k < len-1; k++){
                        Character p = r.get(r.size()-k);
                        int delet = r.size()-k;
                        if(p == '+' || p == '-' || p == '*' || p == '/'){
                            // System.out.print(p+"    ");
                            nextline.add(p);
                            r.remove(delet);
                            len--;
                            break;
                        }
                    }
                }
                isone = true;
                // System.out.println();
                for(int i = 0; i < nextline.size(); i++){
                    System.out.print(nextline.get(nextline.size()-1-i) + "    ");
                }
                nextline.clear();
                System.out.println();
                continue;
            }
            else{
                
                nextline.add(w);
                isone = true;
            }
            int index = r.size() -1;
            r.remove(index);
            len--;
        }
        for(int i = 0; i < nextline.size(); i++){
            System.out.print(nextline.get(nextline.size()-1-i) + "   ");
        }
        
    }
}
