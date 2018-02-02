package com.tencent.mm.plugin.g.a.b;

import java.util.HashMap;

public final class h {
    public static String kxU = "00002902-0000-1000-8000-00805f9b34fb";
    public static String kxV = "0000fee7-0000-1000-8000-00805f9b34fb";
    public static String kxW = "0000fec7-0000-1000-8000-00805f9b34fb";
    public static String kxX = "0000fec8-0000-1000-8000-00805f9b34fb";
    public static String kxY = "0000fea1-0000-1000-8000-00805f9b34fb";
    public static String kxZ = "0000fea2-0000-1000-8000-00805f9b34fb";
    public static String kya = "0000feb1-0000-1000-8000-00805f9b34fb";
    public static String kyb = "0000feb2-0000-1000-8000-00805f9b34fb";
    public static String kyc = "0000feb3-0000-1000-8000-00805f9b34fb";
    public static String kyd = "0000feb4-0000-1000-8000-00805f9b34fb";
    public static String kye = "0000181d-0000-1000-8000-00805f9b34fb";
    public static String kyf = "00002a9e-0000-1000-8000-00805f9b34fb";
    public static String kyg = "00002a9d-0000-1000-8000-00805f9b34fb";
    public static String kyh = "0000180d-0000-1000-8000-00805f9b34fb";
    public static String kyi = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String kyj = "00002a38-0000-1000-8000-00805f9b34fb";
    public static String kyk = "00002a39-0000-1000-8000-00805f9b34fb";
    public static String kyl = "00001810-0000-1000-8000-00805f9b34fb";
    public static String kym = "00002a35-0000-1000-8000-00805f9b34fb";
    public static String kyn = "00002a36-0000-1000-8000-00805f9b34fb";
    public static String kyo = "00002a49-0000-1000-8000-00805f9b34fb";
    public static HashMap<String, String> kyp;

    static {
        HashMap hashMap = new HashMap();
        kyp = hashMap;
        hashMap.put(kxW, "airsync send characteristic. permission: (write)");
        kyp.put(kxX, "airsync recv characteristic. permission: (indicate)");
        kyp.put(kxY, "simple step measurement characteristic. permission: ((read)(indicate|notify))");
        kyp.put(kxZ, "airsync recv characteristic. permission: [(read)[write][indicate]]");
    }
}
