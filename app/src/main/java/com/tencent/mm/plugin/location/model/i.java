package com.tencent.mm.plugin.location.model;

import android.hardware.SensorManager;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i {
    private SensorManager bgR = ((SensorManager) ac.getContext().getSystemService("sensor"));
    private a gyF = new 1(this);
    private c hpO;
    HashSet<WeakReference<a>> jSI = new HashSet();
    private b nQQ = new b(this);
    double nQR = 900.0d;
    double nQS = 900.0d;
    double nQT = -1000.0d;
    double nQU = -1000.0d;
    double nQV = 0.0d;
    boolean nQW = false;

    public final double aVn() {
        if (this.nQW) {
            x.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", new Object[]{Double.valueOf(this.nQR)});
            return this.nQR;
        }
        x.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", new Object[]{Double.valueOf(this.nQV)});
        return this.nQV;
    }

    private void aVo() {
        x.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
        if (this.hpO == null) {
            this.hpO = c.OP();
        }
        this.hpO.b(this.gyF, true);
        this.bgR.registerListener(this.nQQ, this.bgR.getDefaultSensor(3), 1);
    }

    final void aVp() {
        x.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
        this.bgR.unregisterListener(this.nQQ);
        c.OP().c(this.gyF);
    }

    public final void a(a aVar) {
        Iterator it = this.jSI.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return;
            }
        }
        this.jSI.add(new WeakReference(aVar));
        x.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", new Object[]{Integer.valueOf(this.jSI.size())});
        if (this.jSI.size() == 1) {
            aVo();
        }
    }

    public final void b(a aVar) {
        if (this.jSI != null && aVar != null) {
            Iterator it = this.jSI.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                    this.jSI.remove(weakReference);
                    break;
                }
            }
            x.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", new Object[]{Integer.valueOf(this.jSI.size())});
            if (this.jSI.size() == 0) {
                aVp();
            }
        }
    }
}
