package edu.vcu.jpedal;

/* Uncomment your import and main call when you add your package! */
import chioudj.DerekSaysHello;
import westrykj.KennedySaysHello;
import douttl.LucaSaysHello;
// import gqasimi.QasimiSaysHello;

import com.github.javaparser.ast.Node;


public class ImportTest {
    public static void main(String[] args) {
        /* Test everyone's imports */
        DerekSaysHello.main(new String[]{});
        LucaSaysHello.main(new String[]{});
        // QasimiSaysHello.main(new String[]{});
        KennedySaysHello.main(new String[]{});

        /* Test CAIT methods */
        Node parsed = CAIT.parseSource(
                "public class SuperAwesome { public static void main(String[] args) { int x = 3; } }");
        System.out.println(parsed.getChildNodes());
    }
}