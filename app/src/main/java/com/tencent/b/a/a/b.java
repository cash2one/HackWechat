package com.tencent.b.a.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;

final class b {
    static a bpb;
    Integer bpc = null;
    String bpd = null;

    static class a {
        String ael;
        String bpe;
        String bpf;
        DisplayMetrics bpg;
        int bph;
        String bpi;
        String bpj;
        String bpk;
        String bpl;
        int bpm;
        String bpn;
        String bpo;
        Context ctx;
        String imsi;
        String model;
        String packageName;
        String timezone;

        private a(Context context) {
            this.bpf = "2.21";
            this.bph = VERSION.SDK_INT;
            this.model = Build.MODEL;
            this.bpi = Build.MANUFACTURER;
            this.ael = Locale.getDefault().getLanguage();
            this.bpj = "WX";
            this.bpm = 0;
            this.packageName = null;
            this.ctx = null;
            this.bpn = null;
            this.bpo = null;
            this.ctx = context.getApplicationContext();
            try {
                this.bpe = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
            }
            this.bpg = new DisplayMetrics();
            ((WindowManager) this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.bpg);
            if (s.j(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.bpk = telephonyManager.getSimOperator();
                    this.imsi = telephonyManager.getSubscriberId();
                }
            }
            this.timezone = TimeZone.getDefault().getID();
            this.bpl = s.ag(this.ctx);
            this.packageName = this.ctx.getPackageName();
            this.bpo = s.sR();
        }
    }

    private static synchronized a W(Context context) {
        a aVar;
        synchronized (b.class) {
            if (bpb == null) {
                bpb = new a(context.getApplicationContext());
            }
            aVar = bpb;
        }
        return aVar;
    }

    public b(Context context) {
        try {
            W(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                this.bpc = Integer.valueOf(telephonyManager.getNetworkType());
            }
            this.bpd = s.ah(context);
        } catch (Throwable th) {
        }
    }
}
