package Utilities;

import org.openqa.selenium.WebDriver;

public class SingletonDesignPattern {

    private  WebDriver driver;
    private static SingletonDesignPattern obj = null;

    private  SingletonDesignPattern(){
        System.out.println("Private constructor is been called");
    }

    public WebDriver getDriver(){
        return driver;
    }

    private  void setDriver( WebDriver driver){
        this.driver = driver;
    }

    public  static SingletonDesignPattern getInstance(){
        if (obj ==null){
            System.out.println("Creating new object");
            obj = new SingletonDesignPattern();
            return obj;
        } else {
            return  obj;
        }
}

    public static void main(String[] args) {
        getInstance();
    }
}








