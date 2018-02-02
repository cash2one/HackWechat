package c.t.m.g;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.util.List;
import org.eclipse.jdt.annotation.Nullable;

public final class cq {
    final cr a;
    public final File b;
    public boolean c;
    public HandlerThread d;
    public Handler e;
    volatile List<dn> f;
    volatile dr g;
    volatile do h;
    public long i;

    public cq(cr crVar, @Nullable String str) {
        this(crVar, new File(str + "/d_c"));
    }

    private cq(cr crVar, @Nullable File file) {
        this.i = 0;
        this.a = crVar;
        this.b = file;
    }

    public final boolean a() {
        return this.c && this.e != null;
    }

    @SuppressLint({"NewApi"})
    public final void a(boolean z) {
        if (z || System.currentTimeMillis() - this.i >= 60000) {
            a(1007);
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.a.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || 1 != activeNetworkInfo.getType()) {
                    return;
                }
                if ((VERSION.SDK_INT < 16 || !connectivityManager.isActiveNetworkMetered()) && a()) {
                    a(1003);
                    this.i = System.currentTimeMillis();
                    if (!z && this.e != null && this.d != null) {
                        this.e.sendMessageDelayed(this.e.obtainMessage(1004), 1800000);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public final synchronized void a(do doVar, dr drVar, List<dn> list) {
        if (doVar != null) {
            if (System.currentTimeMillis() - doVar.b <= 10000) {
                this.h = doVar;
                this.g = drVar;
                this.f = list;
                if (a()) {
                    if (drVar != null) {
                        a(1001);
                    } else if (list != null && list.size() > 0) {
                        a(1002);
                    }
                }
            }
        }
    }

    public final void a(int i) {
        if (this.e != null && this.d != null) {
            this.e.obtainMessage(i).sendToTarget();
        }
    }
}
