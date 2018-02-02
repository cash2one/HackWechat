package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import java.util.LinkedList;
import java.util.ListIterator;

public final class dj {
    private int a = 10;
    private int b = 4;
    private LinkedList<a> c = new LinkedList();
    private cz d = new cz();

    public final synchronized void a() {
        this.c.clear();
        this.d.a();
    }

    public final synchronized void a(TencentLocation tencentLocation) {
        this.c.add(a.a(tencentLocation));
        if (this.c.size() > this.a) {
            this.c.removeFirst();
        }
    }

    public final synchronized void a(dz dzVar) {
        if (!dzVar.getProvider().equalsIgnoreCase("gps") || cl.a().d("gps_kalman")) {
            if (this.c != null && (this.c == null || this.c.size() != 0)) {
                double d;
                cz czVar = this.d;
                double latitude = dzVar.getLatitude();
                double longitude = dzVar.getLongitude();
                double accuracy = (double) dzVar.getAccuracy();
                long time = dzVar.getTime();
                if (accuracy < 1.0d) {
                    d = 1.0d;
                } else {
                    d = accuracy;
                }
                new StringBuilder("lat_me:").append(latitude).append(",lng_me:").append(longitude).append(",accuracy:").append(d).append(",time:").append(time).append(",lat:").append(czVar.d).append(",lng:").append(czVar.e);
                if (time - czVar.c >= 20000) {
                    czVar.a();
                    new StringBuilder("Time:").append(time).append(",last_time:").append(czVar.c);
                }
                czVar.a = (float) (Math.abs(latitude - czVar.d) * 1000000.0d);
                czVar.b = (float) (Math.abs(longitude - czVar.e) * 1000000.0d);
                new StringBuilder("Q:").append(czVar.a).append(",QLng:").append(czVar.b);
                if (czVar.f < 0.0d) {
                    czVar.c = time;
                    czVar.d = latitude;
                    czVar.e = longitude;
                    czVar.f = d * d;
                } else {
                    long j = time - czVar.c;
                    if (j < 1000) {
                        j = 1000;
                    }
                    if (j > 0) {
                        czVar.f += (double) j;
                        czVar.g += (double) j;
                    }
                    double d2 = czVar.f / ((czVar.f + (d * d)) + ((double) (czVar.a * 5.0f)));
                    double d3 = czVar.g / ((czVar.g + (d * d)) + ((double) (czVar.b * 5.0f)));
                    new StringBuilder("K:").append(d2).append(",KLng:").append(d3);
                    if (d2 < 0.4d || d3 < 0.4d) {
                        if ((czVar.h > 0.0d && latitude - czVar.d > 0.0d) || (czVar.h < 0.0d && latitude - czVar.d < 0.0d)) {
                            czVar.d += czVar.h * ((double) (j / 1000));
                        }
                        if ((czVar.i > 0.0d && longitude - czVar.e > 0.0d) || (czVar.i < 0.0d && longitude - czVar.e < 0.0d)) {
                            czVar.e += czVar.i * ((double) (j / 1000));
                        }
                        czVar.f -= (double) j;
                        czVar.g -= (double) j;
                    } else {
                        double d4 = czVar.d;
                        if ((czVar.h > 0.0d && latitude - czVar.d > 0.0d) || (czVar.h < 0.0d && latitude - czVar.d < 0.0d)) {
                            czVar.d += czVar.h * ((double) (j / 1000));
                        }
                        czVar.d += (latitude - czVar.d) * d2;
                        new StringBuilder("lat:").append(czVar.d).append(",tmp:").append(d4).append(",timeInc:").append(j);
                        czVar.h = (czVar.d - d4) / ((double) (j / 1000));
                        d4 = czVar.e;
                        if ((czVar.i > 0.0d && longitude - czVar.e > 0.0d) || (czVar.i < 0.0d && longitude - czVar.e < 0.0d)) {
                            czVar.e += czVar.i * ((double) (j / 1000));
                        }
                        czVar.e += (longitude - czVar.e) * d3;
                        new StringBuilder("lng:").append(czVar.e).append(",tmp:").append(d4).append(",timeInc:").append(j);
                        czVar.i = (czVar.e - d4) / ((double) (j / 1000));
                        czVar.f = (1.0d - d2) * czVar.f;
                        czVar.g = (1.0d - d3) * czVar.g;
                        czVar.c = time;
                        new StringBuilder("last_metres_per_second:").append(czVar.h).append(",last_metres_per_second_lng:").append(czVar.i);
                    }
                    new StringBuilder("variance:").append(czVar.f).append(",vaLng:").append(czVar.g);
                    if (d == 30.0d && d2 >= 0.5d && d3 >= 0.5d) {
                        czVar.d = latitude;
                        czVar.e = longitude;
                        czVar.h = 0.0d;
                        czVar.i = 0.0d;
                        czVar.c = time;
                        czVar.f = d * d;
                    }
                }
                accuracy = this.d.d;
                d = this.d.e;
                dzVar.b.a = ((double) Math.round(accuracy * 1000000.0d)) / 1000000.0d;
                dzVar.b.b = ((double) Math.round(d * 1000000.0d)) / 1000000.0d;
            }
        }
    }

    public final synchronized boolean a(TencentLocation tencentLocation, cr crVar, boolean z) {
        return a(a.a(tencentLocation), crVar, z);
    }

    private synchronized boolean a(a aVar, cr crVar, boolean z) {
        boolean z2;
        if (crVar != null) {
            if (!(this.c == null || this.c.size() == 0)) {
                if (aVar.d == 3) {
                    z2 = true;
                } else if (aVar.d == 1 && !eh.a(crVar) && !eh.b(crVar) && !z) {
                    z2 = true;
                } else if (aVar.c - ((a) this.c.getLast()).c > 120000) {
                    this.c.clear();
                    z2 = true;
                } else {
                    Object obj;
                    if (this.c.size() >= this.b) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        int i;
                        int i2 = 0;
                        ListIterator listIterator = this.c.listIterator(this.c.size());
                        int i3 = 0;
                        while (listIterator.hasPrevious()) {
                            a aVar2 = (a) listIterator.previous();
                            if (eg.a(aVar2.a, aVar2.b, aVar.a, aVar.b) / (((double) (Math.abs(aVar2.c - aVar.c) + 1)) / 1000.0d) > 100.0d) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            if (obj == null) {
                                i = i2 + 1;
                            } else {
                                i = i2;
                            }
                            int i4 = i3 + 1;
                            if (i4 > this.b) {
                                break;
                            }
                            i3 = i4;
                            i2 = i;
                        }
                        i = i2;
                        if (i > 1) {
                            z2 = false;
                        }
                    }
                    z2 = true;
                }
            }
        }
        z2 = true;
        return z2;
    }
}
