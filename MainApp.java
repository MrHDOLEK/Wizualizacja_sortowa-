package sortvisualiser;

import sortvisualiser.screens.MainMenuScreen;
import sortvisualiser.screens.Screen;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Projekt Wizualizacja wybranych algorytmów sortujących
 * Autor: Aleksander Kowalski "MrHDOLEK"
 *Główny plik wykonywalny sortowania
 * Jest w nim zadeklarowany cały gui dla użytkownika i wywołania innych obiektów
 *
 */
public class MainApp {
    private final JFrame window;
    /**
     * Deklaracja rozmiarów okna i logiki jego
     */
    public static final int WIN_WIDTH = 1200;
    public static final int WIN_HEIGHT = 600;
    
    private final ArrayList<Screen> screens;
    
    public MainApp() {
        screens = new ArrayList<>();
        window = new JFrame ("Wizualizacja");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
    public Screen getCurrentScreen() {
        return screens.get(screens.size() - 1);
    }
    
    public void pushScreen(Screen screen) {
        if (!screens.isEmpty()) {
        	window.remove(getCurrentScreen());
        }
        screens.add(screen);
        window.setContentPane(screen);
        window.validate();
        screen.onOpen();
    }
    
    public void popScreen() {
        if (!screens.isEmpty()) {
            Screen prev = getCurrentScreen();
            screens.remove(prev);
            window.remove(prev);
            if (!screens.isEmpty()) {
            	Screen current = getCurrentScreen();
            	window.setContentPane(current);
            	window.validate();
                current.onOpen();
            }
            else {
                window.dispose();
            }
        }
    }
    
    public void start() {
        pushScreen(new MainMenuScreen(this));
        window.pack();
    }
    
    public static void main(String... args) {
        System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(() -> {
            new MainApp().start();
        });
    }
}
