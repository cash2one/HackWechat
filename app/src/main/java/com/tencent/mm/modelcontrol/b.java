package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b {
    public static boolean kK(String str) {
        if (bh.ov(str)) {
            return false;
        }
        try {
            int MP = MP();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(":");
                int VI = bh.VI(split4[1]) + (bh.VI(split4[0]) * 60);
                split3 = split3[1].split(":");
                if (y(VI, bh.VI(split3[1]) + (bh.VI(split3[0]) * 60), MP)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            x.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
            return false;
        }
    }

    public static boolean L(String str, int i) {
        if (bh.ov(str)) {
            return false;
        }
        try {
            int MP = MP();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(":");
                int VI = bh.VI(split4[1]) + (bh.VI(split4[0]) * 60);
                split3 = split3[1].split(":");
                if (y(VI, (bh.VI(split3[1]) + (bh.VI(split3[0]) * 60)) + i, MP)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            x.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
            return false;
        }
    }

    private static int MP() {
        String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
        int VI = (bh.VI(split[1]) + (bh.VI(split[0]) * 60)) - ((((int) MQ()) - 8) * 60);
        if (VI < 0) {
            return VI + 1440;
        }
        if (VI >= 1440) {
            return VI - 1440;
        }
        return VI;
    }

    public static long MQ() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }

    private static boolean y(int i, int i2, int i3) {
        if (i < i2) {
            if (i3 >= i2 || i3 < i) {
                return false;
            }
            return true;
        } else if (i3 <= 1440 && i3 >= i) {
            return true;
        } else {
            if (i3 >= i2 || i3 < 0) {
                return false;
            }
            return true;
        }
    }
}
