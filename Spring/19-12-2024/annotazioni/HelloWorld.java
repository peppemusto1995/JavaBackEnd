package annotazioni;

import java.lang.reflect.Method;

public class HelloWorld {

    // Utilizzo dell'annotazione 6.
    @MyAnnotation(value = "Hello, world!") 
    public void sayHello() { 
        System.out.println("Questo metodo è annotato con @MyAnnotation"); 
    }

    public static void main(String[] args) throws Exception { 
        HelloWorld helloWorld = new HelloWorld(); 
        helloWorld.sayHello(); 
 
        // Riflettiamo sulla presenza dell'annotazione 16.
       Method method = HelloWorld.class.getMethod("sayHello"); 
 
        // Verifica se l'annotazione è presente 19.
        if (method.isAnnotationPresent(MyAnnotation.class)) { 
            // Ottieni l'annotazione 21.
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class); 
            // Stampa il valore dell'annotazione 23.
            System.out.println("Valore dell'annotazione: " + annotation.value());
        } 
    }
}