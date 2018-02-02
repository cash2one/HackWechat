package com.tencent.mm.plugin.music.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a {
    public String album;
    public String jeC;
    private int mjz = 0;
    public long oJ;
    public ArrayList<a> oJl = new ArrayList();
    public LinkedList<Long> oJm = new LinkedList();
    public String oJn;
    public String oJo;
    public String oJp;
    private boolean oJq = false;
    public String title;

    public static String dt(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return str;
        }
        if (str2.length() >= str.length() - 1) {
            return "";
        }
        x.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[]{str, str2, str.substring(str2.length(), str.length() - 1)});
        return str.substring(str2.length(), str.length() - 1);
    }

    public static long FJ(String str) {
        int i = 0;
        try {
            int ck;
            String[] split = str.split(":");
            int ck2 = g.ck(split[0]);
            if (split.length > 1) {
                String[] split2 = split[1].split("\\.");
                ck = g.ck(split2[0]);
                if (split2.length > 1) {
                    i = g.ck(split2[1]);
                }
            } else {
                ck = 0;
            }
            return ((long) (i * 10)) + (((((long) ck2) * 60) * 1000) + ((long) (ck * 1000)));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.LyricObj", e, "", new Object[0]);
            x.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[]{e.getLocalizedMessage()});
            return 0;
        }
    }

    public final a tm(int i) {
        if (i < 0 || i >= this.oJl.size()) {
            return null;
        }
        return (a) this.oJl.get(i);
    }
}
