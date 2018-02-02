package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;

final class dd implements Listener, LocationListener {
    final cr a;
    volatile int b = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    volatile Location c;
    volatile long d = 0;
    boolean e = false;
    boolean f = false;
    int g = 0;
    int h = 0;
    int i = 0;
    ArrayList<Float> j = new ArrayList();
    volatile boolean k;
    boolean l;
    long m;
    long n = -1;
    a o;
    Runnable p;
    Runnable q;
    Runnable r;
    final double[] s = new double[2];
    private volatile GpsStatus t;
    private dd u;
    private cx v;
    private LocationManager w;

    class a extends Handler {
        private /* synthetic */ dd a;

        public a(dd ddVar, Looper looper) {
            this.a = ddVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message != null) {
                try {
                    removeMessages(message.what);
                    switch (message.what) {
                        case TXLiveConstants.PUSH_WARNING_NET_BUSY /*1101*/:
                            Location d = this.a.c;
                            if (d != null) {
                                new StringBuilder("onLocationChanged: ").append(DateFormat.format("yyyy-MM-dd kk:mm:ss", d.getTime())).append(",").append(VERSION.SDK_INT >= 17 ? d.getElapsedRealtimeNanos() : 0).append(",").append(d.getLatitude()).append(",").append(d.getLongitude()).append(",").append(d.toString());
                                if (dd.b(d) && !this.a.c(d)) {
                                    dd.b(this.a, d);
                                    dd.e(this.a);
                                    this.a.b = this.a.b | 2;
                                    if (this.a.n == -1 || this.a.n == 0) {
                                        dd.a(this.a, true);
                                        this.a.n = System.currentTimeMillis();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case TXLiveConstants.PUSH_WARNING_RECONNECT /*1102*/:
                            dd.e(this.a);
                            dd.h(this.a);
                            if (!(this.a.t == null || this.a.j == null || this.a.j.size() <= 0)) {
                                try {
                                    z = this.a.v.a(this.a.j);
                                } catch (Throwable th) {
                                }
                            }
                            if (z) {
                                if (this.a.n == -1 || this.a.n == 0) {
                                    dd.a(this.a, z);
                                }
                                this.a.n = System.currentTimeMillis();
                                return;
                            } else if (this.a.n == -1 || (System.currentTimeMillis() - this.a.n > 40000 && this.a.n != 0)) {
                                dd.a(this.a, z);
                                this.a.n = 0;
                                return;
                            } else {
                                return;
                            }
                        case TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL /*1103*/:
                            this.a.b = 4;
                            this.a.d();
                            return;
                        case TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_FAIL /*1104*/:
                            this.a.g = this.a.h = 0;
                            this.a.b = 0;
                            this.a.e = false;
                            this.a.d();
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th2) {
                }
            }
        }
    }

    static /* synthetic */ boolean h(dd ddVar) {
        int i = ddVar.g;
        int i2 = ddVar.h;
        if (i > 0) {
            ddVar.f = true;
        }
        if (i2 > 0) {
            ddVar.e = true;
        }
        if (!ddVar.f || i > 2) {
            if (ddVar.e) {
                if (i2 >= 3 || i2 == 0) {
                    return true;
                }
            } else if (i2 == 0) {
                return true;
            }
        }
        return false;
    }

    public dd(cr crVar) {
        this.a = crVar;
        this.v = cx.a();
        this.u = this;
        this.w = this.a.g;
        this.p = new 1(this);
        this.q = new 2(this);
        this.r = new 3(this);
    }

    @SuppressLint({"MissingPermission"})
    public final Location a() {
        Location location = null;
        try {
            location = this.a.g.getLastKnownLocation(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable th) {
        }
        if (location == null) {
            return db.a;
        }
        int i = (this.l && eb.a(location.getLatitude(), location.getLongitude())) ? 1 : 0;
        if (i != 0) {
            eg.a(location, this.s);
            a(location, this.s[0], this.s[1], 0);
            return location;
        }
        a(location, location.getLatitude(), location.getLongitude(), 0);
        return location;
    }

    public final boolean b() {
        return System.currentTimeMillis() - this.d < 20000;
    }

    public final boolean c() {
        boolean z = false;
        try {
            z = this.a.g.isProviderEnabled("gps");
        } catch (Throwable th) {
        }
        return z;
    }

    private static boolean a(double d) {
        if (Math.abs(((double) Double.valueOf(d).longValue()) - d) < Double.MIN_VALUE) {
            return true;
        }
        return false;
    }

    private static boolean b(Location location) {
        try {
            if (location.getAccuracy() > 10000.0f) {
                return false;
            }
            if ((a(location.getLatitude()) && a(location.getLongitude())) || Math.abs(location.getLatitude()) < 1.0E-8d || Math.abs(location.getLongitude()) < 1.0E-8d || Math.abs(location.getLatitude() - 1.0d) < 1.0E-8d || Math.abs(location.getLongitude() - 1.0d) < 1.0E-8d || location.getLatitude() < -90.0d || location.getLatitude() > 90.0d || location.getLongitude() < -180.0d || location.getLongitude() > 180.0d) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.toString();
        }
    }

    final void d() {
        int i;
        if (this.b == 4) {
            i = 1;
        } else if (this.b == 0) {
            i = 0;
        } else {
            i = -1;
        }
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12002;
        message.arg2 = i;
        this.a.c(message);
    }

    @SuppressLint({"NewApi"})
    private boolean c(Location location) {
        if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {
            return false;
        }
        try {
            if (!this.a.g.isProviderEnabled("gps")) {
                return true;
            }
            if (VERSION.SDK_INT < 18 || !location.isFromMockProvider()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public final void onLocationChanged(Location location) {
        if (location != null) {
            try {
                if ("gps".equals(location.getProvider())) {
                    this.c = location;
                    a((int) TXLiveConstants.PUSH_WARNING_NET_BUSY);
                }
            } catch (Throwable th) {
            }
        }
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            a((int) TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL);
        }
    }

    public final void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            a((int) TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_FAIL);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void onGpsStatusChanged(int i) {
        switch (i) {
            case 1:
                this.b |= 1;
                return;
            case 2:
                this.b = 0;
                return;
            case 3:
                this.b |= 2;
                return;
            case 4:
                LocationManager locationManager = this.a.g;
                try {
                    if (this.t == null) {
                        this.t = locationManager.getGpsStatus(null);
                    } else {
                        locationManager.getGpsStatus(this.t);
                    }
                } catch (Throwable th) {
                }
                a((int) TXLiveConstants.PUSH_WARNING_RECONNECT);
                return;
            default:
                return;
        }
    }

    private void a(int i) {
        if (this.o != null) {
            this.o.obtainMessage(i).sendToTarget();
        }
    }

    private static void a(Location location, double d, double d2, int i) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putDouble("lat", d);
        extras.putDouble("lng", d2);
        extras.putInt("rssi", i);
        location.setExtras(extras);
    }

    static /* synthetic */ void b(dd ddVar, Location location) {
        int i;
        int i2;
        if (ddVar.h >= 4 && ddVar.h <= 6) {
            i = 2;
        } else if (ddVar.h >= 7) {
            i = 3;
        } else {
            i = 1;
        }
        if (ddVar.l && eb.a(location.getLatitude(), location.getLongitude())) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            eg.a(location, ddVar.s);
            a(location, ddVar.s[0], ddVar.s[1], i);
        } else {
            a(location, location.getLatitude(), location.getLongitude(), i);
        }
        ddVar.d = System.currentTimeMillis();
        ddVar.a.c(new do(location, ddVar.d, ddVar.g, ddVar.h, ddVar.b, c.t.m.g.do.a.a));
    }

    static /* synthetic */ void e(dd ddVar) {
        try {
            ddVar.i = 0;
            ddVar.h = 0;
            ddVar.g = 0;
            GpsStatus gpsStatus = ddVar.t;
            if (gpsStatus != null) {
                ddVar.j.clear();
                ddVar.i = gpsStatus.getMaxSatellites();
                Iterator it = gpsStatus.getSatellites().iterator();
                if (it != null) {
                    while (it.hasNext() && ddVar.g <= ddVar.i) {
                        GpsSatellite gpsSatellite = (GpsSatellite) it.next();
                        ddVar.g++;
                        ddVar.j.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            ddVar.h++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.toString();
        }
    }

    static /* synthetic */ void a(dd ddVar, boolean z) {
        int i = z ? 3 : 4;
        Message message = new Message();
        message.what = 12999;
        message.arg1 = TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED;
        message.arg2 = i;
        ddVar.a.c(message);
    }
}
