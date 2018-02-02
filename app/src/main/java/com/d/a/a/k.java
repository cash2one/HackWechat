package com.d.a.a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import com.d.a.a.d.a;

final class k extends c implements Listener, LocationListener {
    private static k biy;
    private LocationManager Ih;
    private GpsStatus biA;
    private a biB;
    private final l biC = new l();
    private boolean biz;
    private Looper mLooper;
    private Context tI;

    private k() {
    }

    static k rY() {
        if (biy == null) {
            biy = new k();
        }
        return biy;
    }

    final synchronized void a(Handler handler, a aVar) {
        if (aVar == null) {
            aVar = new a(30000);
        } else if (aVar instanceof a) {
            a aVar2 = (a) aVar;
        } else {
            aVar = new a(aVar.bgK);
        }
        super.a(handler, aVar);
    }

    final void U(Context context) {
        this.tI = context;
        this.Ih = (LocationManager) context.getSystemService("location");
        boolean z = (this.Ih == null || this.Ih.getProvider("gps") == null) ? false : true;
        this.biz = z;
    }

    final void a(Context context, Handler handler, a aVar) {
        if (this.biz) {
            this.biB = (a) aVar;
            this.mLooper = handler != null ? handler.getLooper() : null;
            a(this.biB.bgK, (float) this.biB.biD);
            this.Ih.addGpsStatusListener(this);
            this.biC.biK = Math.max(5000, Math.min(this.biB.bgK + 5000, 65000));
        }
    }

    final void V(Context context) {
        if (this.biz) {
            this.Ih.removeUpdates(this);
            this.Ih.removeGpsStatusListener(this);
        }
    }

    final void rR() {
    }

    public final void onLocationChanged(Location location) {
        int i;
        int i2;
        if (!y.bmL) {
            Object obj;
            if (Secure.getString(this.tI.getContentResolver(), "mock_location").equals("0")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return;
            }
        }
        if (this.biA != null) {
            int i3 = 0;
            int i4 = 0;
            for (GpsSatellite usedInFix : this.biA.getSatellites()) {
                i3++;
                if (usedInFix.usedInFix()) {
                    i4++;
                }
            }
            i = i4;
            i2 = i3;
        } else {
            i = 0;
            i2 = 0;
        }
        this.biC.a(location.getAccuracy(), i, location.getTime());
        c(new b(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy(), location.getSpeed(), i2, i, this.biC.biG, this.biC.biO / 1000, (byte) 0));
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onGpsStatusChanged(int i) {
        if (i != 4) {
            return;
        }
        if (this.biA == null) {
            this.biA = this.Ih.getGpsStatus(null);
        } else {
            this.Ih.getGpsStatus(this.biA);
        }
    }

    private void a(long j, float f) {
        this.Ih.requestLocationUpdates("gps", j, f, this, this.mLooper);
    }

    final void rS() {
        if (this.biz && this.bgH && this.biB.bgK < 300000) {
            a(300000, (float) this.biB.biD);
        }
    }

    final void rT() {
        if (this.biz && this.bgH && this.biB.bgK < 300000) {
            a(this.biB.bgK, (float) this.biB.biD);
        }
    }
}
