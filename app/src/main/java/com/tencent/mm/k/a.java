package com.tencent.mm.k;

import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public class a {
    public static final String gHY = null;
    private static SharedPreferences gHZ = null;
    private static SharedPreferences gIa = null;
    private static String gIb = gHY;

    public static SharedPreferences zm() {
        SharedPreferences VJ = aa.VJ();
        gIa = VJ;
        return VJ;
    }

    public static boolean zn() {
        return com.tencent.mm.kernel.a.Cw().getBoolean("command_notification_status", false);
    }

    public static boolean zo() {
        return com.tencent.mm.kernel.a.Cw().getBoolean("settings_new_msg_notification", true);
    }

    public static boolean zp() {
        return com.tencent.mm.kernel.a.Cw().getBoolean("settings_new_voip_msg_notification", true);
    }

    public static boolean zq() {
        return com.tencent.mm.kernel.a.Cw().getBoolean("settings_show_detail", true);
    }

    public static boolean zr() {
        return com.tencent.mm.kernel.a.Cw().getBoolean("settings_sound", true);
    }

    public static String zs() {
        String string = com.tencent.mm.kernel.a.Cw().getString("settings.ringtone", gHY);
        if (!(string == gHY || string.equals(gIb))) {
            RingtoneManager ringtoneManager = new RingtoneManager(ac.getContext());
            ringtoneManager.setType(2);
            if (ringtoneManager.getRingtonePosition(Uri.parse(string)) < 0) {
                string = gHY;
                eO(string);
                x.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
            }
            gIb = string;
        }
        return string;
    }

    static void eO(String str) {
        ac.cft().edit().putString("settings.ringtone", str).commit();
        com.tencent.mm.kernel.a.Cw().edit().putString("settings.ringtone", str).commit();
    }

    public static boolean zt() {
        return com.tencent.mm.kernel.a.Cw().getBoolean("settings_shake", true);
    }

    public static boolean zu() {
        return com.tencent.mm.kernel.a.Cw().getBoolean("settings_active_time_full", true);
    }

    public static int zv() {
        return com.tencent.mm.kernel.a.Cw().getInt("settings_active_begin_time_hour", 8);
    }

    public static int zw() {
        return com.tencent.mm.kernel.a.Cw().getInt("settings_active_end_time_hour", 23);
    }

    public static int zx() {
        return com.tencent.mm.kernel.a.Cw().getInt("settings_active_begin_time_min", 0);
    }

    public static int zy() {
        return com.tencent.mm.kernel.a.Cw().getInt("settings_active_end_time_min", 0);
    }

    public static boolean aN(int i, int i2) {
        if (zu()) {
            return true;
        }
        int zv = zv();
        int zx = zx();
        int zw = zw();
        int zy = zy();
        if (zv == zw && zx == zy) {
            return false;
        }
        if (zv != zw || zx >= zy) {
            if (zw > zv) {
                if (i > zv && i < zw) {
                    return true;
                }
                if (i == zv && i2 > zx) {
                    return true;
                }
                if (i != zw || i2 >= zy) {
                    return false;
                }
                return true;
            } else if (zw >= zv && (zv != zw || zx <= zy)) {
                return true;
            } else {
                if (i > zv && i <= 23) {
                    return true;
                }
                if (i == zv && i2 > zx) {
                    return true;
                }
                if (i == zw && i2 < zy) {
                    return true;
                }
                if (i <= 0 || i >= zw) {
                    return false;
                }
                return true;
            }
        } else if (i != zv || i2 <= zx || i2 >= zy) {
            return false;
        } else {
            return true;
        }
    }
}
