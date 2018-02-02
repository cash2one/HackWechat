package com.tinkerboots.sdk.b;

import java.util.HashSet;

public final class c {
    private static String Auv;
    private static HashSet<String> Auw = new HashSet();

    public static String cJp() {
        if (Auv == null) {
            return "";
        }
        return Auv;
    }

    public static boolean cJq() {
        if (Auv == null) {
            return false;
        }
        return Auw.contains(Auv);
    }
}
