package yoocraft;

public class Main {

    public static void main(String[] args) {
    	try{
            new MyBotModule().run();   		
    	}
    	catch(Exception e) {
    		System.out.println(e.toString());
    		e.printStackTrace();
    	}
    }
}