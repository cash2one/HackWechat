package com.tencent.mm.booter.notification.a;

import android.media.AudioManager;
import android.text.format.Time;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.k.a;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> gAt;
    public boolean gAu;

    static {
        Set hashSet = new HashSet();
        gAt = hashSet;
        hashSet.add("readerapp");
        gAt.add("blogapp");
        gAt.add("newsapp");
    }

    public static boolean et(String str) {
        if (ae.Ve("keep_chatting_silent" + str)) {
            x.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            return true;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        return false;
    }

    public static boolean a(boolean[] zArr, boolean z, boolean z2) {
        boolean z3;
        if (z || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z2;
        return z3;
    }

    public static boolean a(boolean[] zArr, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z;
        return z2;
    }

    public static boolean eu(String str) {
        boolean z = true;
        boolean contains = gAt.contains(str);
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Siler User: %B";
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        return contains;
    }

    public static boolean xn() {
        Time time = new Time();
        time.setToNow();
        if (a.aN(time.hour, time.minute)) {
            return false;
        }
        x.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
        return true;
    }

    public static boolean xo() {
        x.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", new Object[]{Boolean.valueOf(f.zr())});
        return f.zr();
    }

    public static boolean fs(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static boolean a(String str, au auVar) {
        boolean z;
        boolean z2 = true;
        if (!f.eW(str) || f.e(auVar)) {
            z = false;
        } else {
            z = true;
        }
        String str2 = "MicroMsg.Notification.Silent.Handle";
        String str3 = "check is NOT Must Mute: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        x.i(str2, str3, objArr);
        return z;
    }

    public static boolean xp() {
        boolean z;
        boolean z2 = true;
        try {
            b spVar = new sp();
            spVar.fKq.fuL = 2;
            com.tencent.mm.sdk.b.a.xef.m(spVar);
            z = spVar.fKr.fKs;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Notification.Silent.Handle", e, "", new Object[0]);
            z = false;
        }
        String str = "MicroMsg.Notification.Silent.Handle";
        String str2 = "check is Voip NOT Calling: %B";
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        x.d(str, str2, objArr);
        return z;
    }

    public static boolean o(int i, String str) {
        boolean zW;
        if (f.fS(i)) {
            if (f.eR(str)) {
                zW = f.zW();
            } else if (f.eS(str)) {
                zW = f.zX();
            }
            x.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[]{Boolean.valueOf(zW)});
            return zW;
        }
        zW = true;
        x.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", new Object[]{Boolean.valueOf(zW)});
        return zW;
    }

    public static boolean xq() {
        boolean zt = f.zt();
        if (xr() == 0) {
            zt = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", new Object[]{Boolean.valueOf(zt), Integer.valueOf(xr())});
        return zt;
    }

    public static int xr() {
        return ((AudioManager) ac.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getRingerMode();
    }

    public static boolean ft(int i) {
        boolean z;
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }
}
