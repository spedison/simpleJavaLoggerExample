package br.com.spedison.simplejavalog;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.run(args);
    }

    public void run(String[] args) {

        InputStream is = getClass().getClassLoader().getResourceAsStream("log.properties");

        // Para ler de um arquivo externo.
        //LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
        Logger log = null;
        try {
            LogManager.getLogManager().readConfiguration(is);
            // Esta configuração leva os dados somente para System.err.
            //LogManager.getLogManager().updateConfiguration();
            log = Logger.getLogger(this.getClass().getName());
            // Aqui muda a saida, mas terá que fazer para todos.(Ou centrlizar em um único local)
            //log.setUseParentHandlers(false);
            //log.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
        } catch (IOException e) {
            System.err.println("Problemas ao ler arquivos de configuração de log. Vou parar.");
            throw new RuntimeException(e);
        }

        log.fine("Estou passando pelo log de Fine. Sem formater.");

        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        log.finest("Hi Debug Message....Hello and welcome!");
        log.severe("Teste Severo dentro do Main.");
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {
            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            log.warning("Count Warnings ::: i = " + i);
        }
        IntStream
                .range(0,100)
                .parallel()
                .mapToObj(i->"Contagem :: i = %d".formatted(i))
                .forEach(log::info);

        OtherClass o =new OtherClass();
        o.chamaInfo();
        o.chamaSevere();

    }
}