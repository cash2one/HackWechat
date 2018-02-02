package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import c.t.m.g.dz.a;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;

class de$a extends Handler {
    private long a = 0;
    private boolean b = false;
    private boolean c = false;
    private int d = 0;
    private /* synthetic */ de e;

    de$a(de deVar, Looper looper) {
        this.e = deVar;
        super(looper);
    }

    public final void a() {
        this.d = 0;
        removeCallbacksAndMessages(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(Message message) {
        Object obj = 1;
        synchronized (de.b(this.e)) {
            if (de.c(this.e) == null && de.d(this.e) == de$b.Normal) {
                return;
            }
            TencentLocationListener c = de.c(this.e);
        }
        boolean z;
        de.b(this.e, System.currentTimeMillis());
        if (TextUtils.isEmpty(r3.getIndoorBuildingId())) {
            z = false;
        } else {
            z = true;
        }
        if (z && de.t(this.e) == 1) {
            de.s(this.e).a(0);
            de.s(this.e).j = 4000;
            if (de.e(this.e).getInterval() > 4000) {
                de.c(this.e, 4000);
            }
            de.a(this.e, 2);
            this.d = 0;
        }
        if (de.t(this.e) == 2) {
            if (z) {
                de.a(this.e, r3, 0, 3101);
            } else {
                this.d++;
            }
            if (this.d >= 5) {
                de.s(this.e).j = de.u(this.e).l;
                new StringBuilder("indoor stop,").append(de.e(this.e).getInterval());
                de.c(this.e, de.e(this.e).getInterval());
                de.a(this.e, 1);
                this.d = 0;
            }
        }
        dz.a(r3, z);
        de.a(this.e, 0, r3);
        a(0);
        de.b(this.e, r3);
        if (de.d(this.e) == de$b.Normal && !de.v(this.e)) {
            ck.a().b();
            de.w(this.e);
        }
    }

    private void a(int i) {
        if (de.y(this.e) != null) {
            if (de.i(this.e) == 0) {
                de.a(this.e, de.g(this.e), de.i(this.e), 3103);
            } else {
                de.a(this.e, dz.a, i, 3103);
            }
            de.z(this.e);
            if (de.d(this.e) == de$b.Single) {
                this.e.a();
            }
        }
    }

    private void b(int i) {
        double d = 0.0d;
        Location a = de.A(this.e).a();
        if (a != db.a && de.k(this.e) == 0 && System.currentTimeMillis() - a.getTime() <= 120000) {
            double d2;
            Location location = new Location(a);
            Bundle extras = location.getExtras();
            if (extras != null) {
                d2 = extras.getDouble("lat");
                d = extras.getDouble("lng");
            } else {
                d2 = 0.0d;
            }
            a aVar = new a();
            aVar.d = TencentLocation.NETWORK_PROVIDER;
            dz a2 = aVar.a(a).a();
            if (de.m(this.e) == 1) {
                location.setLatitude(d2);
                location.setLongitude(d);
                a2.a(location);
            }
            if (!de.h(this.e)) {
                de.a(this.e, 0, a2);
            }
            a(0);
        } else if (de.i(this.e) != 0 || de.g(this.e) == null || System.currentTimeMillis() - de.g(this.e).getTime() >= 60000) {
            de.a(this.e, i, dz.a);
            a(i);
        } else {
            a(0);
        }
    }

    private static void a(dz dzVar, String str) {
        String.format("%s,%.6f,%.6f,%.1f", new Object[]{str, Double.valueOf(dzVar.getLatitude()), Double.valueOf(dzVar.getLongitude()), Float.valueOf(dzVar.getAccuracy())});
    }
}
