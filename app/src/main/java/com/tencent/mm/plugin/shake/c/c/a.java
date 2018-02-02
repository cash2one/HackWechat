package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a {
    private static SimpleDateFormat kXB = null;

    public static void brw() {
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (brx()) {
            x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
            if (!brS()) {
                x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.xmQ, Boolean.valueOf(false));
                return;
            }
            return;
        }
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
        if (brS()) {
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.xmQ, Boolean.valueOf(true));
            x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
            return;
        }
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
    }

    public static boolean brx() {
        if (ar.Hj()) {
            boolean booleanValue;
            ar.Hg();
            Object obj = c.CU().get(com.tencent.mm.storage.w.a.xmQ, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            return booleanValue;
        }
        x.e("MicroMsg.ShakeCardUtil", "acc is not ready");
        return false;
    }

    private static boolean brS() {
        ar.Hg();
        int intValue = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xmR, Integer.valueOf(0))).intValue();
        ar.Hg();
        int intValue2 = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xmS, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + intValue + " end time : " + intValue2);
        if (intValue <= 0) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + intValue + " , invalid");
            return false;
        } else if (intValue2 <= 0) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + intValue2 + " , invalid");
            return false;
        } else if (intValue >= intValue2) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : " + currentTimeMillis);
            if (currentTimeMillis < intValue || currentTimeMillis > intValue2) {
                x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                return false;
            }
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            return true;
        }
    }

    public static int brT() {
        ar.Hg();
        return ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xmX, Integer.valueOf(0))).intValue();
    }

    public static String brU() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xmW, "");
    }

    public static String brV() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xmT, "");
    }

    public static String brW() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xmZ, "");
    }

    public static String brX() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xmY, "");
    }

    public static String brY() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xnc, "");
    }

    public static String brZ() {
        ar.Hg();
        return (String) c.CU().get(com.tencent.mm.storage.w.a.xnb, "");
    }

    public static boolean wb(int i) {
        return i >= 0 && i <= 5;
    }

    public static int bsa() {
        ar.Hg();
        int currentTimeMillis = (int) (System.currentTimeMillis() % 10);
        int nextInt = (new Random((long) c.Cg()).nextInt(10) + currentTimeMillis) % 10;
        x.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:" + nextInt);
        return nextInt;
    }

    public static int wc(int i) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 120;
            case 5:
                return 240;
            default:
                return 0;
        }
    }

    public static int wd(int i) {
        switch (i) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return 150;
            case 7:
                return 180;
            case 8:
                return 240;
            case 9:
                return 300;
            default:
                return 10;
        }
    }

    public static int wO(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.ShakeCardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                x.e("MicroMsg.ShakeCardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static String bp(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (kXB == null) {
            kXB = new SimpleDateFormat("yyyy.MM.dd");
        }
        return kXB.format(new Date(j2));
    }

    public static void q(Context context, String str, String str2) {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        d.b(context, "card", ".ui.CardDetailUI", intent);
    }

    public static boolean bsb() {
        return brx() && w.cfe();
    }

    public static void bry() {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = 86400 + currentTimeMillis;
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmR, Integer.valueOf(currentTimeMillis));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmS, Integer.valueOf(i));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmT, "");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmX, Integer.valueOf(0));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmU, Integer.valueOf(1));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmV, Integer.valueOf(6));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmW, "");
        com.tencent.mm.s.c.Bq().p(262154, true);
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmY, String.valueOf(currentTimeMillis));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmZ, "hello");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xna, "shake card");
    }

    public static void brz() {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmR, Integer.valueOf(0));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmS, Integer.valueOf(0));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmT, "");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmX, Integer.valueOf(0));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmU, Integer.valueOf(0));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmV, Integer.valueOf(0));
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmW, "");
        com.tencent.mm.s.c.Bq().p(262154, false);
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmY, "");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xmZ, "");
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.xna, "");
    }
}
