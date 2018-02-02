package c.t.m.g;

import android.content.pm.PackageInfo;

public final class bh {
    public String a = "";
    public int b = 0;
    public String c = "";
    public String d = "";
    public int e;

    public bh() {
        try {
            this.a = m.a().getPackageName();
            PackageInfo packageInfo = m.a().getPackageManager().getPackageInfo(this.a, 0);
            this.b = packageInfo.versionCode;
            this.c = packageInfo.versionName;
            this.e = m.b();
            this.d = "";
        } catch (Throwable th) {
        }
    }
}
