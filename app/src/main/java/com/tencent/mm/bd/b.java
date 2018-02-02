package com.tencent.mm.bd;

import android.util.Base64;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.az.k;
import com.tencent.mm.c.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b {
    private static final byte[] hLp = "@wechat*weixin!!".getBytes();
    private static b hLq;
    private c hLA = new 3(this);
    private ak hLB;
    private com.tencent.map.a.a.b hLC;
    private int hLD;
    private com.tencent.map.a.a.c hLE;
    private boolean hLr = false;
    private ag hLs;
    int hLt = 5000;
    int hLu = 5000;
    int hLv = 30000;
    private int hLw = 3600;
    private c hLx;
    private List<d> hLy = new ArrayList();
    private List<d> hLz = new ArrayList();
    private long startTime = 0;

    static /* synthetic */ void a(b bVar, int i) {
        long j = (long) i;
        bVar.hLB.J(j, j);
    }

    static /* synthetic */ boolean a(b bVar, int i, float f, float f2) {
        List<d> list = i == 1 ? bVar.hLy : bVar.hLz;
        if (list == null || list.size() <= 0) {
            x.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            return false;
        }
        boolean z;
        long Wq = bh.Wq();
        for (d dVar : list) {
            x.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(dVar.latitude), Double.valueOf(dVar.longitude), Double.valueOf(TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f)), Double.valueOf(dVar.hLU)});
            if (TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f) <= dVar.hLU) {
                z = true;
                break;
            }
        }
        z = false;
        x.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f), Boolean.valueOf(z), Long.valueOf(bh.bA(Wq))});
        return z;
    }

    static /* synthetic */ void e(b bVar) {
        bVar.hLy.clear();
        bVar.hLz.clear();
        String str = (String) g.Dj().CU().get(a.xsh, "");
        if (bh.ov(str)) {
            x.i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
            return;
        }
        Map y = f.y(str, "SenseWhere");
        if (y == null) {
            x.w("MicroMsg.SenseWhereHelper", "parseLocation maps is null, xml[%s]", new Object[]{str});
            return;
        }
        int i = 0;
        while (true) {
            String str2 = ".SenseWhere.item" + (i == 0 ? "" : Integer.valueOf(i));
            str = (String) y.get(str2 + ".$gpstype");
            if (bh.ov(str)) {
                com.tencent.mm.plugin.report.service.g.pQN.a(345, 6, 1, false);
                x.i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", new Object[]{Integer.valueOf(bVar.hLz.size()), Integer.valueOf(bVar.hLy.size())});
                return;
            }
            d dVar = new d();
            dVar.hLT = str;
            dVar.longitude = bh.getDouble((String) y.get(str2 + ".$longitude"), 0.0d);
            dVar.latitude = bh.getDouble((String) y.get(str2 + ".$latitude"), 0.0d);
            dVar.hLU = bh.getDouble((String) y.get(str2 + ".$distance"), 0.0d);
            if (dVar.hLU > 5500000.0d) {
                dVar.hLU = 5500000.0d;
            }
            if ("1".equals(dVar.hLT)) {
                bVar.hLy.add(dVar);
            } else {
                bVar.hLz.add(dVar);
            }
            i++;
        }
    }

    static /* synthetic */ void l(b bVar) {
        if (bVar.hLs != null) {
            bVar.hLs.oAt.quit();
        }
        bVar.hLs = null;
    }

    static /* synthetic */ void n(b bVar) {
        if (bVar.startTime > 0) {
            x.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", new Object[]{Long.valueOf((bh.Wq() - bVar.startTime) / 1000), Integer.valueOf(bh.e((Integer) com.tencent.mm.plugin.report.service.g.a((int) ((bh.Wq() - bVar.startTime) / 1000), new int[]{5, 10, 20, 30}, 10, 14)))});
            com.tencent.mm.plugin.report.service.g.pQN.a(345, (long) r0, 1, false);
        }
    }

    static /* synthetic */ int o(b bVar) {
        int i = bVar.hLD + 1;
        bVar.hLD = i;
        return i;
    }

    public static b Rk() {
        if (hLq == null) {
            hLq = new b();
        }
        return hLq;
    }

    public b() {
        g.Dk();
        this.hLB = new ak(g.Dm().oAt.getLooper(), new 4(this), false);
        this.hLC = new com.tencent.map.a.a.b(this) {
            final /* synthetic */ b hLN;

            {
                this.hLN = r1;
            }

            public final void a(double d, double d2, int i, int i2, long j) {
                x.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
            }
        };
        this.hLD = 0;
        this.hLE = new 6(this);
    }

    private static String Rl() {
        String yE = q.yE();
        g.Dh();
        try {
            x.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new Object[]{new String(Base64.encode(new s().encrypt((yE + "_" + new o(com.tencent.mm.kernel.a.Cg()).toString()).getBytes("UTF-8"), hLp), 0), "UTF-8"), bh.VT(r1)});
            return new String(Base64.encode(new s().encrypt((yE + "_" + new o(com.tencent.mm.kernel.a.Cg()).toString()).getBytes("UTF-8"), hLp), 0), "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHelper", "create imei error: " + e.toString());
            return "";
        }
    }

    public final void Rm() {
        g.Dk();
        g.Dm().F(new 2(this));
    }

    private boolean Rn() {
        g.Dh();
        if (new o(com.tencent.mm.kernel.a.Cg()).longValue() < 1000000) {
            x.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            return false;
        }
        String value = com.tencent.mm.k.g.zY().getValue("AndroidSenseWhereArgs");
        if (bh.ov(value)) {
            x.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            return false;
        }
        try {
            x.d("MicroMsg.SenseWhereHelper", "sense where config : " + value);
            String[] split = value.split(";");
            int i = bh.getInt(split[0], 0);
            g.Dh();
            if (h.aJ(com.tencent.mm.kernel.a.Cg() + 5, 100) > i) {
                x.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", new Object[]{Integer.valueOf(h.aJ(com.tencent.mm.kernel.a.Cg() + 5, 100)), Integer.valueOf(i)});
                return false;
            }
            this.hLu = bh.getInt(split[1], 5000);
            this.hLt = bh.getInt(split[2], 5000);
            this.hLv = bh.getInt(split[3], 30000);
            this.hLw = bh.getInt(split[4], 3600);
            x.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", new Object[]{Integer.valueOf(this.hLu), Integer.valueOf(this.hLt), Integer.valueOf(this.hLv), Integer.valueOf(this.hLw)});
            if (bh.by(((Long) g.Dj().CU().get(a.xsj, Long.valueOf(0))).longValue()) > ((long) this.hLw)) {
                return true;
            }
            x.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", new Object[]{Long.valueOf(bh.by(((Long) g.Dj().CU().get(a.xsj, Long.valueOf(0))).longValue())), Integer.valueOf(this.hLw)});
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e.toString());
            x.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            return false;
        }
    }

    public static void Ro() {
        if (bh.by(bh.a((Long) g.Dj().CU().get(a.xsi, null), 0)) * 1000 > 21600000) {
            x.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            g.Di().gPJ.a(new k(36), 0);
            g.Dj().CU().a(a.xsi, Long.valueOf(bh.Wo()));
        }
    }
}
