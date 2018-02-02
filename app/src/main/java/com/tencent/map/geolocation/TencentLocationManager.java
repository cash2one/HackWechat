package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import c.t.m.g.cr;
import c.t.m.g.cs;
import c.t.m.g.de;
import c.t.m.g.de.b;

public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    private static TencentLocationManager d;
    private final byte[] a = new byte[0];
    private final cr b;
    private final de c;

    private TencentLocationManager(Context context) {
        this.b = cr.a(context);
        this.c = new de(this.b);
    }

    public static synchronized TencentLocationManager getInstance(Context context) {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            if (d == null) {
                if (context == null) {
                    throw new NullPointerException("context is null");
                } else if (context.getApplicationContext() == null) {
                    throw new NullPointerException("application context is null");
                } else {
                    d = new TencentLocationManager(context.getApplicationContext());
                }
            }
            tencentLocationManager = d;
        }
        return tencentLocationManager;
    }

    public final void setCoordinateType(int i) {
        if (i == 1 || i == 0) {
            synchronized (this.a) {
                de deVar = this.c;
                if (deVar.b != i) {
                    deVar.b = i;
                }
            }
            return;
        }
        throw new IllegalArgumentException("unknown coordinate type: " + i);
    }

    public final int getCoordinateType() {
        return this.c.b;
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        return requestLocationUpdates(tencentLocationRequest, tencentLocationListener, Looper.myLooper());
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (tencentLocationRequest == null) {
            throw new NullPointerException("request is null");
        } else if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        } else if (looper == null) {
            throw new NullPointerException("looper is null");
        } else {
            int a;
            synchronized (this.a) {
                a = this.c.a(tencentLocationRequest, tencentLocationListener, looper);
            }
            return a;
        }
    }

    public final int requestSingleFreshLocation(TencentLocationListener tencentLocationListener, Looper looper) {
        int i = 0;
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        } else if (looper == null) {
            throw new NullPointerException("looper is null");
        } else {
            synchronized (this.a) {
                de deVar = this.c;
                if (deVar.d != 0) {
                    i = deVar.d;
                } else {
                    if (!(tencentLocationListener == null || deVar.f == null)) {
                        deVar.f.add(tencentLocationListener);
                    }
                    if (System.currentTimeMillis() - deVar.g >= 2000) {
                        deVar.g = System.currentTimeMillis();
                        if (deVar.f != null && deVar.l == 0 && deVar.k != null && ((deVar.k.getProvider().equals("gps") && System.currentTimeMillis() - deVar.k.getTime() <= 90000) || (deVar.k.getProvider().equals(TencentLocation.NETWORK_PROVIDER) && System.currentTimeMillis() - deVar.k.getTime() <= 30000))) {
                            deVar.a(deVar.k, deVar.l, 3103);
                            deVar.g = 0;
                        } else if (deVar.m == b.a) {
                            deVar.a(3997);
                        } else {
                            i = deVar.a(TencentLocationRequest.create().setInterval(0), de.a, looper);
                            deVar.m = b.c;
                        }
                    }
                }
            }
            return i;
        }
    }

    public final boolean startIndoorLocation() {
        this.c.i = 1;
        return true;
    }

    public final boolean stopIndoorLocation() {
        de deVar = this.c;
        if (deVar.i > 0) {
            boolean z;
            if (deVar.c != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                deVar.c.j = deVar.e.l;
            }
            if (Long.valueOf(deVar.h) != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                deVar.h = deVar.j.getInterval();
            }
            deVar.i = 0;
        }
        return true;
    }

    public final TencentLocation getLastKnownLocation() {
        de deVar = this.c;
        if (deVar.l != 0) {
            return null;
        }
        deVar.a(deVar.k);
        return deVar.k;
    }

    public final void removeUpdates(TencentLocationListener tencentLocationListener) {
        synchronized (this.a) {
            this.c.a();
        }
    }

    public final String getBuild() {
        cs c = this.b.c();
        return c != null ? c.e() : "None";
    }

    public final String getVersion() {
        cs c = this.b.c();
        return c != null ? c.d() : "None";
    }
}
