package br.com.spedison.simplejavalog;

import java.util.logging.Logger;

public class OtherClass {
    private static Logger log = Logger.getLogger(OtherClass.class.getName());

    public void chamaInfo(){
        log.info("Minha mensagem de info");
    }

    public void chamaSevere(){
        log.severe("Isso é severo !!!");
    }


}
