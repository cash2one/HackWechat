package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class n {
    static final a Ig = new a();
    private final LocationManager Ih;
    final Context mContext;

    private static class a {
        boolean Ii;
        long Ij;
        long Ik;
        long Il;
        long Im;
        long In;

        private a() {
        }
    }

    n(Context context) {
        this.mContext = context;
        this.Ih = (LocationManager) context.getSystemService("location");
    }

    final Location t(String str) {
        if (this.Ih != null) {
            try {
                if (this.Ih.isProviderEnabled(str)) {
                    return this.Ih.getLastKnownLocation(str);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    static boolean a(a aVar) {
        return aVar != null && aVar.In > System.currentTimeMillis();
    }

    static void d(Location location) {
        long j;
        a aVar = Ig;
        long currentTimeMillis = System.currentTimeMillis();
        if (m.Id == null) {
            m.Id = new m();
        }
        m mVar = m.Id;
        mVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = mVar.Ie;
        mVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = mVar.state == 1;
        long j3 = mVar.If;
        long j4 = mVar.Ie;
        mVar.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = mVar.If;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        aVar.Ii = z;
        aVar.Ij = j2;
        aVar.Ik = j3;
        aVar.Il = j4;
        aVar.Im = j5;
        aVar.In = j;
    }
}
