package com.d.a.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.d.a.a.n.c;
import com.tencent.map.geolocation.TencentLocation;
import java.lang.ref.WeakReference;

public final class t {
    private static boolean bgH = false;
    private static Context bks;
    private static WeakReference<b> bkt;
    private static WeakReference<d> bku;
    private static WeakReference<c> bkv;
    private static WeakReference<e> bkw;
    private static final a bkx = new a((byte) 0);
    private static String imei;

    public static void a(Context context, q qVar) {
        bks = context.getApplicationContext();
        try {
            w.sy().a(context, new m[]{bkx});
            r.sc().bjL = qVar;
            r.sc().bjM = imei;
        } catch (Exception e) {
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static boolean a(Handler handler, long j, b bVar, d dVar) {
        if (bks == null) {
            return false;
        }
        if (bgH) {
            return true;
        }
        bkt = new WeakReference(bVar);
        bku = new WeakReference(dVar);
        bkv = new WeakReference(null);
        try {
            w sy = w.sy();
            if (handler == null) {
                handler = new Handler(bks.getMainLooper());
            }
            sy.a(handler, new c(j, 5000));
            if (y.bmL) {
                y.bmS = o.sb();
                o.o("filter_input_log_" + y.bmS, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                o.o("filter_output_log_" + y.bmS, "time,lat,lng,err,speed");
                o.o("gps_log_" + y.bmS, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                o.o("post_processing_log_" + y.bmS, "tag,lat,lng");
            }
            if (!(bkw == null || ((e) bkw.get()) == null)) {
                boolean isProviderEnabled;
                LocationManager locationManager = (LocationManager) bks.getSystemService("location");
                try {
                    isProviderEnabled = locationManager.isProviderEnabled("gps");
                } catch (SecurityException e) {
                    isProviderEnabled = false;
                }
                if (!isProviderEnabled) {
                    try {
                        locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                    } catch (SecurityException e2) {
                    }
                }
            }
            bgH = true;
            return true;
        } catch (Exception e3) {
            bgH = false;
            return false;
        }
    }

    public static void sp() {
        try {
            w.sy().stop();
        } catch (Exception e) {
        } finally {
            bgH = false;
        }
    }

    public static void finish() {
        try {
            w.sy().rU();
        } catch (Exception e) {
        }
    }
}
