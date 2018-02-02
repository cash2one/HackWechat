package c.t.m.g;

import android.os.Build;
import android.os.Build.VERSION;

public final class bj {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public bj() {
        try {
            this.a = Build.MODEL;
            this.b = VERSION.RELEASE;
            this.c = cg.a();
            this.d = cg.b();
            cg.e();
            this.e = cg.f();
        } catch (Throwable th) {
        }
    }
}
