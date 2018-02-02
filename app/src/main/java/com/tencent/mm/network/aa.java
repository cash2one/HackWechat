package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;

public final class aa {
    private static boolean hasInit = false;
    private static aa iaM;
    private static boolean iaV = false;
    private t gxO;
    private af handler;
    private ab iaN;
    private ac iaO;
    private Context iaP;
    private a iaQ;
    private z iaR;
    private y iaS;
    private Looper iaT;
    private w iaU;

    private aa() {
    }

    private static aa VH() {
        if (iaM == null) {
            iaM = new aa();
        }
        return iaM;
    }

    private static SharedPreferences VI() {
        return ac.getContext().getSharedPreferences("notify_key_pref_no_account", 4);
    }

    public static SharedPreferences VJ() {
        String string = VI().getString("login_weixin_username", "");
        if (bh.ov(string)) {
            string = aq.hfP.H("login_weixin_username", "");
            if (!bh.ov(string)) {
                VI().edit().putString("login_weixin_username", string).commit();
            }
        }
        if (string != null) {
            string = string.replace("[\\/\\\\]", "#").trim();
        }
        return ac.getContext().getSharedPreferences("notify_key_pref" + string, 4);
    }

    public static void VK() {
        if (!hasInit) {
            SharedPreferences VJ = VJ();
            long j = VJ.getLong("wakeup_alarm_last_tick", 0);
            int i = VJ.getInt("wakeup_alarm_last_cnt", 0);
            if (j == 0 || j > bh.Wp()) {
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", Integer.valueOf(i));
                VJ.edit().putLong("wakeup_alarm_last_tick", bh.Wp()).commit();
                VJ.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                return;
            } else if (bh.bz(j) > 86400000) {
                VJ.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
                VJ.edit().putLong("wakeup_alarm_last_tick", bh.Wp()).commit();
                VJ.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", Integer.valueOf(i));
            } else {
                VJ.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
                x.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", Integer.valueOf(i + 1));
            }
        }
        hasInit = true;
    }

    public static boolean VL() {
        String H = aq.hfP.H("login_user_name", "");
        if (H != null) {
            H = H.replaceAll("[/\\\\]", "#").trim();
        }
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("notify_key_pref" + H, 4);
        x.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0)), Integer.valueOf(sharedPreferences.getInt("wakeup_alarm_last_cnt", 0)));
        return (r0 > 10 ? 1 : 0) | (sharedPreferences.getInt("wakeup_alarm_launch_cnt", 0) > 10 ? 1 : 0);
    }

    public static ab VM() {
        return VH().iaN;
    }

    public static void a(ab abVar) {
        VH().iaN = abVar;
    }

    public static ac VN() {
        return VH().iaO;
    }

    public static void a(ac acVar) {
        VH().iaO = acVar;
    }

    public static Context getContext() {
        return VH().iaP;
    }

    public static void setContext(Context context) {
        VH().iaP = context;
    }

    public static af VO() {
        return VH().handler;
    }

    public static void a(af afVar) {
        VH().handler = afVar;
    }

    public static a VP() {
        return VH().iaQ;
    }

    public static void a(a aVar) {
        VH().iaQ = aVar;
    }

    public static t VQ() {
        return VH().gxO;
    }

    public static void b(t tVar) {
        VH().gxO = tVar;
    }

    public static z VR() {
        return VH().iaR;
    }

    public static void a(z zVar) {
        VH().iaR = zVar;
    }

    public static y VS() {
        return VH().iaS;
    }

    public static void a(y yVar) {
        VH().iaS = yVar;
    }

    public static Looper VT() {
        if (VH().iaT == null) {
            HandlerThread Wf = e.Wf("MMPushCore_handlerThread");
            Wf.start();
            VH().iaT = Wf.getLooper();
        }
        return VH().iaT;
    }

    public static w VU() {
        return VH().iaU;
    }

    public static void a(w wVar) {
        VH().iaU = wVar;
    }

    public static void cf(boolean z) {
        VH();
        iaV = z;
    }

    public static boolean VV() {
        VH();
        return iaV;
    }
}
