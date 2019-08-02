package evgenyt.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Scopes demonstration, musicPlayer defined in @Prototype scope,
 * musicBean - in singleton by default
 */

public class TestSpring {
    public static void main(String[] args) {
        // Get app context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // Singleton scope
        Music music1 = context.getBean("musicBean", ClassicalMusic.class);
        Music music2 = context.getBean("musicBean", ClassicalMusic.class);
        System.out.println("Singleton scope: the same object? " + (music1 == music2));
        // Prototype scope
        MusicPlayer musicPlayer3 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer4 = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println("Prototype scope: the same object? " + (musicPlayer3 == musicPlayer4));
        context.close();
    }
}
