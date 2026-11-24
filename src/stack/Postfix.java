package stack;

import javax.swing.JOptionPane;

public abstract class Postfix {

    
    public static String infix2PostfixByTwoStacks(String infix){
        
        Stack s1 = new Stack(infix.length());
        Stack s2 = new Stack(infix.length());
        
        
        String pri[] = {"^","*/%", "+-"};
        
        for(int i = 0; i < infix.length(); i++){
            
            if(Character.isAlphabetic(infix.charAt(i)) || Character.isDigit(infix.charAt(i)))
                s1.stringPush(infix.charAt(i)+"");
            
            else if(!s2.isEmpty()){
                while(!s2.isEmpty()){
                    String temp = s2.stringPop();
                    
                    if(temp.equals("(") && infix.charAt(i) == ')'){
                        break;
                    }
                    else if(temp.equals("(")){
                        s2.stringPush(temp);
                        break;                        
                    }
                    else if(infix.charAt(i) == ')'){
                        s1.stringPush(temp);
                        continue;
                    }
                    
                    int priTemp = -1, priInfix = -1;
                    for(int p = 0; p < pri.length; p++){
                        if(pri[p].contains(temp))
                            priTemp = p;
                        if(pri[p].contains(infix.charAt(i)+""))
                            priInfix = p;
                    }
                    
                    if(priTemp <= priInfix){
                        s1.stringPush(temp);
                    }
                    else{
                        s2.stringPush( temp );
                        break;
                    }
                }
                
                if(infix.charAt(i) != ')')
                    s2.stringPush(infix.charAt(i)+"");
            }
            else{
                s2.stringPush(infix.charAt(i)+"");
            }
//            JOptionPane.showMessageDialog(null, "S1 : " + s1.getStringDataAsString() + "\nS2 : " + s2.getStringDataAsString());
        }
 
        while(!s2.isEmpty())
            s1.stringPush( s2.stringPop() );
        while(!s1.isEmpty())
            s2.stringPush( s1.stringPop() );

        return s2.getStringDataAsString();
    }
    
    
    public static String infix2PostfixByOneStack(String infix){
        
        Stack s = new Stack(infix.length());
        String postFix = ""; 
        String pri[] = {"^","*/%", "+-"};
        
        for(int i = 0; i < infix.length(); i++){
            if(Character.isAlphabetic(infix.charAt(i)) || Character.isDigit(infix.charAt(i)))
                postFix += infix.charAt(i);
            
            else if(!s.isEmpty()){
                while(!s.isEmpty()){
                    String temp = s.stringPop();
                    
                    if(temp.equals("(") && infix.charAt(i) == ')')
                        break;
                    
                    else if(temp.equals("(")){
                        s.stringPush(temp);
                        break;
                    }
                    else if(infix.charAt(i) == ')'){
                        postFix += temp;
                        continue;
                    }
                    
                    int priTemp = -1, priInfix = -1;
                    for(int p = 0; p < pri.length; p++){
                        if(pri[p].contains(temp))
                            priTemp = p;
                        if(pri[p].contains(infix.charAt(i)+""))
                            priInfix = p;
                    }
                    
                    if(priTemp <= priInfix){
                        postFix += temp;
                    }
                    else{
                        s.stringPush( temp );
                        break;
                    }
                    
                                
                }
                if(infix.charAt(i) != ')')
                    s.stringPush(infix.charAt(i)+"");
                
            }
            else{
                s.stringPush(infix.charAt(i)+"");
            }
//            JOptionPane.showMessageDialog(null, "postFix = " + postFix + "\nStack = " + s.getStringDataAsString());
        }
        
        while(!s.isEmpty())
            postFix += s.stringPop();
        
        return postFix;
    }
    
    
    public static String solvePostfixSyntax(String postfix){
        
        Stack res = new Stack(postfix.length());
        
        for(int i = 0; i < postfix.length(); i++){
            
            if(Character.isAlphabetic(postfix.charAt(i)) || Character.isDigit(postfix.charAt(i)))
                res.stringPush(postfix.charAt(i)+"");                            
            
            else{                
                int a,b;
                switch(postfix.charAt(i)){
                    case '+':
                        b = Integer.parseInt(res.stringPop()+"");
                        a = Integer.parseInt(res.stringPop()+"");
                        a += b;                        
                        res.stringPush(a+"");                        
                        break;
                        
                    case '-':
                        b = Integer.parseInt(res.stringPop()+"");
                        a = Integer.parseInt(res.stringPop()+"");
                        a -= b;                        
                        res.stringPush(a+"");
                        break;
                        
                    case '*':                        
                        b = Integer.parseInt(res.stringPop()+"");
                        a = Integer.parseInt(res.stringPop()+"");
                        a *= b;                        
                        res.stringPush(a+"");
                        break;
                        
                    case '/':                        
                        b = Integer.parseInt(res.stringPop()+"");
                        a = Integer.parseInt(res.stringPop()+"");
                        a /= b;                        
                        res.stringPush(a+"");
                        break;
                        
                    case '%':                        
                        b = Integer.parseInt(res.stringPop()+"");
                        a = Integer.parseInt(res.stringPop()+"");
                        a %= b;                        
                        res.stringPush(a+"");
                        break;
                        
                    case '^':                        
                        b = Integer.parseInt(res.stringPop()+"");
                        a = Integer.parseInt(res.stringPop()+"");
                        a = (int)Math.pow(a, b);                                    
                        res.stringPush(a+"");
                        break;
                }
            }
        }        
        return  res.getStringDataAsString();
    }
    
}
