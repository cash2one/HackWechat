package com.tencent.mm.k;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.k;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import java.util.List;
import java.util.Map;

public final class f extends a {
    private static String TAG = "MicroMsg.NotificationConfig";

    public static void bj(boolean z) {
        ac.cft().edit().putBoolean("settings_new_msg_notification", z).commit();
        a.Cw().edit().putBoolean("settings_new_msg_notification", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bk(boolean z) {
        ac.cft().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        a.Cw().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bl(boolean z) {
        ac.cft().edit().putBoolean("settings_show_detail", z).commit();
        a.Cw().edit().putBoolean("settings_show_detail", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bm(boolean z) {
        a.Cw().edit().putBoolean("command_notification_status", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]is notification by system: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bn(boolean z) {
        ac.cft().edit().putBoolean("settings_sound", z).commit();
        a.Cw().edit().putBoolean("settings_sound", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void bo(boolean z) {
        ac.cft().edit().putBoolean("settings_shake", z).commit();
        a.Cw().edit().putBoolean("settings_shake", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void eO(String str) {
        a.eO(str);
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[]{str});
    }

    public static void bp(boolean z) {
        ac.cft().edit().putBoolean("settings_active_time_full", z).commit();
        a.Cw().edit().putBoolean("settings_active_time_full", z).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[]{Boolean.valueOf(z)});
    }

    public static void aO(int i, int i2) {
        SharedPreferences cft = ac.cft();
        cft.edit().putInt("settings_active_begin_time_hour", i).commit();
        cft.edit().putInt("settings_active_begin_time_min", i2).commit();
        cft = a.Cw();
        cft.edit().putInt("settings_active_begin_time_hour", i).commit();
        cft.edit().putInt("settings_active_begin_time_min", i2).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void aP(int i, int i2) {
        SharedPreferences cft = ac.cft();
        cft.edit().putInt("settings_active_end_time_hour", i).commit();
        cft.edit().putInt("settings_active_end_time_min", i2).commit();
        cft = a.Cw();
        cft.edit().putInt("settings_active_end_time_hour", i).commit();
        cft.edit().putInt("settings_active_end_time_min", i2).commit();
        x.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static boolean zP() {
        return c.gB(a.Cv());
    }

    public static void fR(int i) {
        a.Cw().edit().putInt("notification.status.webonline.push.open", i).commit();
    }

    public static boolean zQ() {
        return q.gL(a.Cw().getInt("notification.status.webonline.push.open", 0));
    }

    public static void zR() {
        SharedPreferences cft = ac.cft();
        Editor edit = a.Cw().edit();
        edit.putBoolean("settings_new_msg_notification", cft.getBoolean("settings_new_msg_notification", true));
        edit.putBoolean("settings_new_voip_msg_notification", cft.getBoolean("settings_new_voip_msg_notification", true));
        edit.putBoolean("settings_show_detail", cft.getBoolean("settings_show_detail", true));
        edit.putBoolean("settings_sound", cft.getBoolean("settings_sound", true));
        edit.putString("settings.ringtone", cft.getString("settings.ringtone", gHY));
        edit.putBoolean("settings_shake", cft.getBoolean("settings_shake", true));
        edit.putBoolean("settings_active_time_full", cft.getBoolean("settings_active_time_full", true));
        edit.putInt("settings_active_begin_time_hour", cft.getInt("settings_active_begin_time_hour", 8));
        edit.putInt("settings_active_begin_time_min", cft.getInt("settings_active_begin_time_min", 0));
        edit.putInt("settings_active_end_time_hour", cft.getInt("settings_active_end_time_hour", 23));
        edit.putInt("settings_active_end_time_min", cft.getInt("settings_active_end_time_min", 0));
        edit.commit();
        x.i(TAG, "notification config copyDefault, newMsgNotification: %B, showDetail: %B, isSound: %B, ringTone: %s, isShake: %B, isActiveTime: %B, begin: %d:%d, end: %d:Td", new Object[]{Boolean.valueOf(r2), Boolean.valueOf(r3), Boolean.valueOf(r4), r5, Boolean.valueOf(r6), Boolean.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r0)});
    }

    public static boolean fS(int i) {
        return i == 50 || i == 53;
    }

    public static boolean eR(String str) {
        b spVar = new sp();
        spVar.fKq.fuL = 1;
        spVar.fKq.content = str;
        com.tencent.mm.sdk.b.a.xef.m(spVar);
        if (spVar.fKr.type == 2 || str.equals(au.xzd)) {
            return true;
        }
        return false;
    }

    public static boolean eS(String str) {
        b spVar = new sp();
        spVar.fKq.fuL = 1;
        spVar.fKq.content = str;
        com.tencent.mm.sdk.b.a.xef.m(spVar);
        if (spVar.fKr.type == 3 || str.equals(au.xzc)) {
            return true;
        }
        return false;
    }

    public static int d(au auVar) {
        int i = 0;
        int i2 = s.gF(auVar.field_talker) ? 0 : 3;
        if (auVar.field_bizChatId != -1 && com.tencent.mm.ag.f.eE(auVar.field_talker)) {
            com.tencent.mm.ag.a.c ag = y.Mh().ag(auVar.field_bizChatId);
            if (!ag.Mt() && ag.ho(1)) {
                return i2;
            }
        }
        String str = auVar.gjF;
        if (bh.ov(str)) {
            return i2;
        }
        Map y = bi.y(str, "msgsource");
        if (y == null || y.isEmpty()) {
            return i2;
        }
        try {
            int parseInt = Integer.parseInt((String) y.get(".msgsource.tips"));
            if ((parseInt & 1) != 0 || (parseInt & 2) == 0) {
                i = parseInt;
            }
            return i;
        } catch (Exception e) {
            return i2;
        }
    }

    public static int zS() {
        if (ar.Hj()) {
            return t.hw(s.hfk);
        }
        x.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
        return 0;
    }

    public static List<String> zT() {
        return t.G(s.hfk, -1);
    }

    public static int zU() {
        if (ar.Hj()) {
            return t.hv(s.hfk);
        }
        x.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
        return 0;
    }

    public static int eT(String str) {
        return t.M(str, null);
    }

    public static boolean eU(String str) {
        return com.tencent.mm.storage.x.gy(str);
    }

    public static boolean eV(String str) {
        return str.toLowerCase().endsWith("@chatroom");
    }

    public static int zV() {
        return k.FO();
    }

    public static boolean eW(String str) {
        return s.hs(str) || (s.eV(str) && !s.hr(str));
    }

    public static int eX(String str) {
        ar.Hg();
        return c.Fd().Xl(str);
    }

    public static boolean e(au auVar) {
        if (auVar == null) {
            return false;
        }
        return auVar.Xq(q.FS());
    }

    public static boolean zW() {
        ar.Hg();
        return ((Boolean) c.CU().get(73217, Boolean.valueOf(true))).booleanValue();
    }

    public static boolean zX() {
        ar.Hg();
        return ((Boolean) c.CU().get(73218, Boolean.valueOf(true))).booleanValue();
    }
}
