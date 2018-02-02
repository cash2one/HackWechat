package c.t.m.g;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.Locale;

class cr$2 implements Runnable {
    private /* synthetic */ cr a;

    cr$2(cr crVar) {
        this.a = crVar;
    }

    public final void run() {
        cr crVar = this.a;
        try {
            String charSequence;
            cs csVar = crVar.b;
            PackageInfo e = crVar.e();
            int i = e.versionCode;
            csVar.h = e.versionName;
            CharSequence loadLabel = crVar.a.getApplicationInfo().loadLabel(crVar.d);
            if (loadLabel != null) {
                charSequence = loadLabel.toString();
            } else {
                charSequence = "unknown";
            }
            csVar.i = charSequence;
            try {
                TelephonyManager telephonyManager = crVar.e;
                if (telephonyManager != null) {
                    int[] iArr = new int[2];
                    ea.a(telephonyManager, iArr);
                    csVar.j = iArr[0];
                    csVar.k = iArr[1];
                    csVar.a = telephonyManager.getPhoneType();
                    crVar.i = ef.a(telephonyManager.getDeviceId(), ef.a).toUpperCase(Locale.ENGLISH);
                    String a = ef.a(telephonyManager.getSubscriberId(), ef.b);
                    charSequence = ef.a(telephonyManager.getLine1Number(), ef.c);
                    csVar.b = crVar.i;
                    csVar.c = a;
                    csVar.d = charSequence;
                }
            } catch (Throwable th) {
            }
            csVar.e = ef.a(crVar.f().replaceAll(":", "").toUpperCase(Locale.ENGLISH), ef.d);
            PackageManager packageManager = crVar.d;
            boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.location.gps");
            boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.wifi");
            new StringBuilder("doInBg: hasGps=").append(hasSystemFeature).append(",hasWifi=").append(hasSystemFeature2).append(",hasCell=").append(packageManager.hasSystemFeature("android.hardware.telephony"));
            new StringBuilder("os:").append(Build.MODEL).append(" ").append(VERSION.RELEASE).append(" ").append(csVar.a()).append(" net:").append(csVar.j).append(" ").append(csVar.k).append(" app:").append(e.versionCode).append(" ").append(e.versionName).append(" sdk: ").append(csVar.d()).append(" ").append(csVar.e());
        } catch (Throwable th2) {
        }
        cr.a(this.a).countDown();
    }
}
