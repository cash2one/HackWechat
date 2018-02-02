package com.tencent.mm.sdk.a;

public final class b {
    public static boolean foreground = false;
    public static String xdY = "unknow";
    private static c xdZ = null;
    private static boolean xea = false;
    private static String xeb = null;
    private static boolean xec = false;
    private static boolean xed = false;

    public static void a(c cVar) {
        xdZ = cVar;
    }

    public static void z(String str, String str2) {
        if (xdZ != null) {
            xdZ.z(str, str2);
        }
    }

    public static void l(int i, String str) {
        if (xdZ != null) {
            xdZ.l(i, str);
        }
    }

    public static void bD(boolean z) {
        foreground = z;
    }

    public static void UH(String str) {
        xdY = str;
    }

    public static void a(a aVar) {
        if (xdZ != null) {
            xdZ.a(aVar);
        }
    }

    public static void ly(boolean z) {
        xec = z;
    }

    public static boolean ceI() {
        return xec;
    }

    public static void ceJ() {
        xea = true;
    }

    public static boolean ceK() {
        return xea;
    }

    public static void UI(String str) {
        xeb = str;
    }

    public static String ceL() {
        return xeb;
    }

    public static boolean ceM() {
        return xed;
    }

    public static void lz(boolean z) {
        xed = z;
    }
}
