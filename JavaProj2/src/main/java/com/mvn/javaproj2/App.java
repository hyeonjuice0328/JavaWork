package com.mvn.javaproj2;

/**
 * Hello world!
 *
 */
public class App
{
	
	public String getWelcome(){
		return "welcome";
	}
	public String getHello(){
		return "hello";
	}
	public String getBye(){
		return "bye";
	}
    public static void main( String[] args )
    {
        System.out.println( "안농아나농" );
        
        App app = new App();
        String welcome = app.getWelcome();
        String hello = app.getHello();
        String bye = app.getBye();
    }
}
