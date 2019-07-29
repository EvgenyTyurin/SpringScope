package evgenyt.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Scopes demonstration
 */

public class TestSpring {
    public static void main(String[] args) {
        // Get app context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // Singleton scope
        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println("Singleton scope: the same object? " + (musicPlayer1 == musicPlayer2));
        // Prototype scope
        MusicPlayer musicPlayer3 = context.getBean("musicPlayerPrototype", MusicPlayer.class);
        MusicPlayer musicPlayer4 = context.getBean("musicPlayerPrototype", MusicPlayer.class);
        System.out.println("Prototype scope: the same object? " + (musicPlayer3 == musicPlayer4));
        context.close();
    }
}
