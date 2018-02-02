package com.d.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.d.a.a.d.a;
import com.d.a.a.u.e;
import java.util.List;

abstract class b extends a {
    private z bgD;

    abstract void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2);

    abstract void a(float f, float f2, int i, float f3, float f4, float f5, long j);

    abstract void a(int i, String str, long j, long j2);

    abstract void a(x xVar, long j, long j2);

    abstract void a(List<ScanResult> list, long j, long j2);

    b() {
        super(new d[]{ab.sz(), r.sc(), u.st(), k.rY()});
    }

    synchronized void a(Handler handler, a aVar) {
        if (handler == null) {
            throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
        }
        this.bgD = z.a(handler);
        super.a(handler, aVar);
    }

    final void a(Handler handler, Handler[] handlerArr) {
        handlerArr[0] = handler;
        handlerArr[1] = null;
        handlerArr[2] = handler;
        handlerArr[3] = handler;
    }

    final void a(a aVar, a[] aVarArr) {
        aVarArr[0] = aVar;
        aVarArr[1] = null;
        aVarArr[2] = null;
        aVarArr[3] = a(aVar);
    }

    public void a(p pVar) {
        switch (pVar.what) {
            case 101:
                a(((ab.a) pVar).bnh, pVar.bjx, pVar.bjy);
                return;
            case 201:
                b(pVar);
                return;
            case 202:
                b(pVar);
                return;
            case 301:
                e eVar = (e) pVar;
                a(eVar.x, eVar.y, eVar.blZ, eVar.blX, eVar.blY, eVar.aew, eVar.bjy);
                return;
            case 401:
                com.d.a.a.k.b bVar = (com.d.a.a.k.b) pVar;
                a(bVar.lat, bVar.lng, Double.valueOf(bVar.biE).intValue(), Math.round(bVar.biF), Math.round(bVar.aew), bVar.biH, bVar.biI, bVar.biG, bVar.biJ, bVar.bjy);
                return;
            default:
                return;
        }
    }

    k.a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new k.a(Math.max(aVar.bgK, 10000));
    }

    private void b(p pVar) {
        if (this.bgD != null) {
            try {
                this.bgD.execute(new a(this, pVar, (byte) 0));
            } catch (Exception e) {
            }
        }
    }
}
