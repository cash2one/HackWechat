package com.tencent.mm.plugin.gcm.modelgcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class a implements e {
    private static a nym;
    private Context context;
    private int nyj = 3;
    private int nyk = 0;
    private String nyl = "";
    private com.google.android.gms.gcm.a nyn;

    private a(Context context) {
        this.context = context;
    }

    public static a aSa() {
        x.i("GcmRegister", "GCM getInstance");
        if (nym != null) {
            return nym;
        }
        Context context = ac.getContext();
        if (context == null) {
            x.e("GcmRegister", "GCM appcontext null");
            return null;
        }
        a aVar = new a(context);
        nym = aVar;
        return aVar;
    }

    public final void aSb() {
        x.i("GcmRegister", "checkregister");
        aa.VO().postDelayed(new 1(this), 5000);
    }

    public final void aSc() {
        x.i("GcmRegister", "doRegist old regid[%s]", new Object[]{aSd()});
        if (cT(this.context)) {
            this.nyn = com.google.android.gms.gcm.a.J(this.context);
            if (bh.ov(r0) || aSe()) {
                x.i("GcmRegister", "doRegist registerInBackground as regid[%s] is null or expired", new Object[]{r0});
                new a(this).execute(new Void[]{null, null, null});
                return;
            }
            aSg();
            return;
        }
        x.i("GcmRegister", "Google Play Services Unavailable.");
        g.pQN.k(11250, new StringBuilder("2,0").toString());
        d.pPH.a(452, 0, 1, false);
        if (aSi()) {
            aSd();
            aSh();
        }
    }

    @SuppressLint({"NewApi"})
    public final String aSd() {
        SharedPreferences aSf = aSf();
        String string = aSf.getString("registration_id", "");
        if (string.length() == 0) {
            x.i("GcmRegister", "registrationId not found.");
            d.pPH.a(452, 1, 1, false);
            return "";
        } else if (aSf.getInt("appVersion", Integer.MIN_VALUE) != cS(this.context)) {
            x.i("GcmRegister", "App version changed.");
            d.pPH.a(452, 2, 1, false);
            return "";
        } else {
            d.pPH.a(452, 4, 1, false);
            return string;
        }
    }

    final boolean aSe() {
        if (bh.by(aSf().getLong("regtime", 0)) <= 259200) {
            return false;
        }
        x.i("GcmRegister", "gcm regid timeout[%d, %d]", new Object[]{Long.valueOf(bh.by(aSf().getLong("regtime", 0))), Integer.valueOf(259200)});
        d.pPH.a(452, 3, 1, false);
        return true;
    }

    private SharedPreferences aSf() {
        return this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    }

    private static int cS(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            x.e("GcmRegister", "Could not get package name.");
            return i;
        }
    }

    public final void aSg() {
        d.pPH.a(452, 11, 1, false);
        int Cg = aa.VQ().hZK.Cg();
        String aSd = aSd();
        if (bh.ov(aSd)) {
            x.i("GcmRegister", "sendRegistrationIdToBackend regid is empty.");
            d.pPH.a(452, 13, 1, false);
        } else if (this.nyk != 0 && Cg == this.nyk && aSd.equals(this.nyl)) {
            x.i("GcmRegister", "uin[%s][%s] already reg to weixin svr", new Object[]{Integer.valueOf(this.nyk), bh.VT(aSd)});
            d.pPH.a(452, 12, 1, false);
        } else {
            this.nyl = aSd;
            x.i("GcmRegister", "regToWeixinServer [%s]", new Object[]{bh.VT(this.nyl)});
            try {
                new e(aSd, Cg).a(aa.VQ(), this);
                d.pPH.a(452, 14, 1, false);
            } catch (Throwable th) {
                d.pPH.a(452, 15, 1, false);
                x.e("GcmRegister", "NetScenePushReg doScene error:" + th.toString());
            }
        }
    }

    public final void aSh() {
        x.i("GcmRegister", "unregToWeixinServer");
        d.pPH.a(452, 18, 1, false);
        String aSd = aSd();
        if (bh.ov(aSd)) {
            x.e("GcmRegister", "unregToWeixinServer regid is empty.");
            d.pPH.a(452, 19, 1, false);
        } else if (aSi()) {
            fI(false);
            try {
                new f(aSd, aa.VQ().hZK.Cg()).a(aa.VQ(), this);
                d.pPH.a(452, 21, 1, false);
            } catch (Throwable th) {
                x.e("GcmRegister", "NetScenePushUnReg doScene error:" + th.toString());
                d.pPH.a(452, 22, 1, false);
            }
        } else {
            x.e("GcmRegister", "is not reg to Svr. no need unreg.");
            d.pPH.a(452, 20, 1, false);
        }
    }

    public final void af(Context context, String str) {
        SharedPreferences aSf = aSf();
        int cS = cS(context);
        String string = aSf.getString("registration_id", "");
        x.i("GcmRegister", "Saving regId on app version[%s] regid[%s to %s] same[%b]", new Object[]{Integer.valueOf(cS), bh.VT(string), bh.VT(str), Boolean.valueOf(string.equals(str))});
        if (bh.ov(string)) {
            d.pPH.a(452, 37, 1, false);
        }
        if (bh.ov(str)) {
            d.pPH.a(452, 38, 1, false);
        }
        d.pPH.a(452, string.equals(str) ? 39 : 40, 1, false);
        Editor edit = aSf.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", cS);
        edit.putLong("regtime", bh.Wo());
        edit.commit();
    }

    private void fI(boolean z) {
        SharedPreferences aSf = aSf();
        x.i("GcmRegister", "Saving regSvrResult: " + z);
        Editor edit = aSf.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.nyk = aa.VQ().hZK.Cg();
        } else {
            this.nyk = 0;
        }
    }

    public final boolean aSi() {
        return aSf().getBoolean("isRegToSvr", false);
    }

    private static boolean cT(Context context) {
        try {
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 8) {
                return false;
            }
            int C = com.google.android.gms.common.e.C(context);
            if (C == 0) {
                return true;
            }
            x.w("GcmRegister", "device not support GCM reason = " + C);
            return false;
        } catch (Throwable th) {
            x.e("GcmRegister", th.toString());
            return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        x.i("GcmRegister", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        kVar.hmF = true;
        if (kVar != null) {
            if (kVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    x.i("GcmRegister", "NetScenePushReg success.");
                    d.pPH.a(452, 16, 1, false);
                    z = true;
                } else {
                    x.i("GcmRegister", "NetScenePushReg faild.");
                    d.pPH.a(452, 17, 1, false);
                }
                fI(z);
            } else if (kVar instanceof f) {
                if (i == 0 && i2 == 0) {
                    x.i("GcmRegister", "NetScenePushUnReg success.");
                    d.pPH.a(452, 23, 1, false);
                } else {
                    x.e("GcmRegister", "NetScenePushUnReg faild.");
                    d.pPH.a(452, 24, 1, false);
                }
                fI(false);
            }
        }
    }
}
