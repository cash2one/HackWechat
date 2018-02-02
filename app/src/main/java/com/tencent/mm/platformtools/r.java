package com.tencent.mm.platformtools;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class r {
    public static boolean icH = false;
    public static boolean icI = false;
    public static boolean icJ = false;
    public static boolean icK = false;
    public static boolean icL = false;
    public static boolean icM = false;
    public static boolean icN = false;
    public static boolean icO = false;
    public static boolean icP = false;
    public static boolean icQ = false;
    public static boolean icR = false;
    public static boolean icS = false;
    public static String icT = "";
    public static boolean icU = false;
    public static boolean icV = false;
    public static boolean icW = false;
    public static boolean icX = false;
    public static int icY = 0;
    public static boolean icZ = false;
    public static boolean idA = false;
    public static boolean idB = false;
    public static boolean idC = false;
    public static String idD = "";
    public static String idE = "";
    public static String idF = "";
    public static String idG = "";
    public static String idH = "";
    public static boolean idI = false;
    public static boolean idJ = false;
    public static boolean idK = false;
    public static int idL = 0;
    public static boolean idM = false;
    public static boolean idN = false;
    public static boolean idO = false;
    public static boolean idP = false;
    public static boolean idQ = false;
    public static boolean idR = false;
    public static boolean idS = true;
    public static boolean idT = false;
    public static boolean idU = false;
    public static String idV = "";
    public static int idW = 0;
    public static boolean idX = false;
    public static boolean idY = false;
    public static int idZ = -1;
    public static boolean ida = false;
    public static boolean idb = false;
    public static String idc = "";
    public static String idd = "";
    public static boolean ide = false;
    public static boolean idf = false;
    public static boolean idg = false;
    public static boolean idh = false;
    public static boolean idi = false;
    public static boolean idj = false;
    public static boolean idk = false;
    public static int idl = 0;
    public static int idm = 0;
    public static boolean idn = false;
    public static String ido = null;
    public static String idp = null;
    public static boolean idq = false;
    public static boolean idr = false;
    public static int ids = 0;
    public static int idt = 0;
    public static int idu = 0;
    public static String idv = "";
    public static String idw = "";
    public static String idx = null;
    public static String idy = null;
    public static boolean idz = false;
    public static boolean iea = false;
    public static String ieb = "";
    public static float iec = 0.4f;
    public static float ied = 0.7f;
    public static boolean iee = false;
    public static String ief = "";
    public static String ieg = "";
    public static boolean ieh = false;
    public static boolean iei = false;
    public static String iej = "";
    public static String iek = "";
    public static boolean iel = false;
    public static boolean iem = false;
    public static boolean ien = false;
    public static boolean ieo = false;
    public static boolean iep = false;
    public static boolean ieq = false;
    private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> ier = new HashMap();
    public static boolean ies = false;
    public static boolean iet = false;
    public static boolean ieu = false;
    public static double lat = 0.0d;
    public static double lng = 0.0d;

    public static void br(int i, int i2) {
        synchronized (ier) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) ier.get(Integer.valueOf(i));
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                ier.put(Integer.valueOf(i), concurrentLinkedQueue);
            }
            concurrentLinkedQueue.add(Integer.valueOf(i2));
        }
    }
}
