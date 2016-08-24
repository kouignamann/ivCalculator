package fr.kouignamann.ivCalculator.core;

import com.github.axet.lookup.*;
import com.github.axet.lookup.common.*;

import java.io.*;

public class CarapuceOCRTest {

    static public void main(String[] args) {
        OCR l = new OCR(0.70f);

        File fontsFile = new File("resources/fonts");

        // will go to com/github/axet/lookup/fonts folder and load all font
        // familys (here is only fonts.font_1 family in this library)
        l.loadFontsDirectory(OCRTest.class, fontsFile);

        // example how to load only one family
        // "com/github/axet/lookup/fonts/fonts.font_1"
        l.loadFont(OCRTest.class, new File(fontsFile, "font_pokemon_go_iphone_2"));
        System.out.println("fonts loaded");

        String str = "";

        // recognize using all familys set
//        str = l.recognize(Capture.load(OCRTest.class, "resources/carapuce.png"), "font_pokemon_go_iphone");
//        System.out.println(str);

//        // recognize using only one family set
//        str = l.recognize(Capture.load(OCRTest.class, "resources/test3.png"), "font_1");
//        System.out.println(str);
//
//        // recognize using only one family set and rectangle
        ImageBinaryGrey i = new ImageBinaryGrey(Capture.load(OCRTest.class, "resources/carapuce.png"));
        str = l.recognize(i, 27, 514, 612, 573, l.getSymbols("font_pokemon_go_iphone_2"));
        System.out.println(str);
    }
}
