package com.tencent.mm.modelgeo;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements a {
    public static c hpO;
    List<WeakReference<a>> avD = new ArrayList();
    double bhF = 0.0d;
    private af hae = new af(Looper.getMainLooper());
    public boolean hxP = false;
    g hxQ;
    long hxR = 0;
    public long hxS = 0;
    boolean hxT = false;
    public boolean hxU = false;
    double hxV = 23.0d;
    double hxW = 100.0d;
    int hxX = 0;
    double hxY = 0.0d;
    double hxZ = 0.0d;
    String hya;
    String hyb;
    int hyc;
    private boolean hyd = false;
    private boolean hye = false;
    private e hyf = new 1(this);
    private f hyg = new 2(this);
    private Context mContext;

    static /* synthetic */ void a(c cVar, int i) {
        if (g.Dh().Cy()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((int) cVar.hxZ);
            stringBuffer.append(",");
            stringBuffer.append(cVar.hxX);
            stringBuffer.append(",");
            stringBuffer.append((int) (cVar.hxV * 1000000.0d));
            stringBuffer.append(",");
            stringBuffer.append((int) (cVar.hxW * 1000000.0d));
            g.Dj().CU().set(i, stringBuffer.toString());
            x.d("MicroMsg.LocationGeo", "Save Location Success id=%d|content=%s", new Object[]{Integer.valueOf(i), stringBuffer.toString()});
        }
    }

    static /* synthetic */ void a(c cVar, boolean z) {
        int i = 10;
        if (!z || !cVar.hyd) {
            if (z || !cVar.hye) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - cVar.hxR > 500) {
                    if (currentTimeMillis - cVar.hxR <= 1000) {
                        i = 12;
                    } else if (currentTimeMillis - cVar.hxR <= 2000) {
                        i = 14;
                    } else if (currentTimeMillis - cVar.hxR <= 4000) {
                        i = 16;
                    } else if (currentTimeMillis - cVar.hxR <= 8000) {
                        i = 18;
                    }
                }
                if (!z) {
                    i++;
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(584, (long) i, 1, true);
                if (z) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(584, 30, 1, true);
                    com.tencent.mm.plugin.report.service.g.pQN.a(584, 31, currentTimeMillis - cVar.hxR, true);
                    cVar.hyd = true;
                    return;
                }
                cVar.hye = true;
            }
        }
    }

    static /* synthetic */ void a(c cVar, boolean z, double d, double d2, int i, double d3, double d4, double d5, Bundle bundle) {
        List<a> linkedList = new LinkedList();
        for (WeakReference weakReference : cVar.avD) {
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add((a) weakReference.get());
            }
        }
        if (linkedList.isEmpty()) {
            x.w("MicroMsg.LocationGeo", "no location listener weakrefers, may have leak, stop location");
            cVar.avD.clear();
            g.OT();
        }
        for (a aVar : linkedList) {
            if (r.icS && b.ceK()) {
                boolean z2 = z;
                aVar.a(z2, (float) r.lng, (float) r.lat, i, (double) ((float) d3), d4, d5);
            } else {
                aVar.a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, d5);
            }
            if (aVar instanceof a.b) {
                ((a.b) aVar).a(z, (float) d2, (float) d, i, (double) ((float) d3), d4, bundle);
            }
        }
    }

    public static c OP() {
        if (hpO == null) {
            hpO = new c(ac.getContext());
        }
        return hpO;
    }

    private c(Context context) {
        this.mContext = context;
        this.hxQ = g.bk(context);
    }

    public final void a(a aVar, boolean z) {
        x.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", new Object[]{aVar, Boolean.valueOf(z), Integer.valueOf(0)});
        if (this.hxP && this.avD.size() > 0) {
            try {
                this.hxR = System.currentTimeMillis();
                this.hyd = false;
                this.hye = false;
                g.OT();
                g.a(this.hyg, 0, Looper.getMainLooper());
            } catch (g.a e) {
                x.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.hxP = false;
        for (WeakReference weakReference : this.avD) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                Object obj = null;
                break;
            }
        }
        int i = 1;
        if (obj != null) {
            this.avD.add(new WeakReference(aVar));
        }
        x.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[]{Integer.valueOf(this.avD.size())});
        if (this.avD.size() == 1 && obj != null) {
            try {
                this.hxR = System.currentTimeMillis();
                this.hyd = false;
                this.hye = false;
                g.a(this.hyg, 0, Looper.getMainLooper());
            } catch (g.a e2) {
                x.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.hxU && System.currentTimeMillis() - this.hxS < 60000) {
            this.hyf.a(true, this.hxV, this.hxW, this.hxX, this.hxY, this.hxZ, this.bhF, this.hya, this.hyb, this.hyc);
        }
    }

    public final void b(a aVar) {
        a(aVar, true);
    }

    public final void a(a aVar) {
        b(aVar, true);
    }

    public final void b(a aVar, boolean z) {
        if (!this.hxP && this.avD.size() > 0) {
            try {
                this.hxR = System.currentTimeMillis();
                this.hyd = false;
                this.hye = false;
                g.OT();
                g.a(this.hyf, 1, Looper.getMainLooper());
            } catch (g.a e) {
                x.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.hxP = true;
        for (WeakReference weakReference : this.avD) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                Object obj = null;
                break;
            }
        }
        int i = 1;
        if (obj != null) {
            this.avD.add(new WeakReference(aVar));
        }
        x.i("MicroMsg.LocationGeo", "add listeners size %d", new Object[]{Integer.valueOf(this.avD.size())});
        if (this.avD.size() == 1 && obj != null) {
            try {
                this.hxR = System.currentTimeMillis();
                this.hyd = false;
                this.hye = false;
                g.a(this.hyf, 1, Looper.getMainLooper());
            } catch (g.a e2) {
                x.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.hxT && System.currentTimeMillis() - this.hxS < 60000) {
            this.hyf.a(true, this.hxV, this.hxW, this.hxX, this.hxY, this.hxZ, this.bhF, this.hya, this.hyb, this.hyc);
        }
    }

    public final void c(a aVar) {
        new af().post(new 3(this, aVar));
    }

    public static boolean OQ() {
        try {
            return ((LocationManager) ac.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            x.e("MicroMsg.LocationGeo", "exception:%s", new Object[]{bh.i(e)});
            return false;
        }
    }

    public static boolean OR() {
        try {
            return ((LocationManager) ac.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable e) {
            x.e("MicroMsg.LocationGeo", "exception:%s", new Object[]{bh.i(e)});
            return false;
        }
    }
}
