package com.tencent.mm.wallet_core.c;

import java.util.UUID;

public final class o {
    private static boolean zHC = false;
    private static int zHD = -1;
    private static String zHE = "";

    public static boolean cBs() {
        return zHC;
    }

    public static int cBt() {
        return zHD;
    }

    public static String cBu() {
        return zHE;
    }

    public static void Hz(int i) {
        if (!zHC) {
            zHC = true;
            zHD = i;
            zHE = UUID.randomUUID().toString();
        }
    }

    public static void cBv() {
        zHC = false;
        zHD = -1;
        zHE = "";
    }
}
