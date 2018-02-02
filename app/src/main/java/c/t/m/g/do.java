package c.t.m.g;

import android.location.Location;

public final class do extends dq {
    public final Location a;
    public final long b;
    public final int c;
    public final int d;
    private int e;
    private int f;

    public do(Location location, long j, int i, int i2, int i3, int i4) {
        this.a = location;
        this.b = j;
        this.e = i;
        this.c = i2;
        this.f = i3;
        this.d = i4;
    }

    public final String toString() {
        return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.e + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.f + "]";
    }
}
