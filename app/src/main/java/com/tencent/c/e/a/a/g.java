package com.tencent.c.e.a.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class g {
    private static final int[] zUb = new int[]{1, 4, 9};
    private final SensorManager bgR;
    private final HashSet<Sensor> zTZ = new HashSet();
    public final SparseArray<i> zUa = new SparseArray();
    public a zUc = new a(this);

    public g(Context context) {
        this.bgR = (SensorManager) context.getSystemService("sensor");
    }

    public final synchronized boolean gu(long j) {
        boolean z = false;
        synchronized (this) {
            if (this.bgR != null) {
                a aVar = this.zUc;
                synchronized (aVar.zUd) {
                    if (aVar.zUd.get()) {
                    } else {
                        aVar.zUd.set(true);
                        aVar.zTS = System.currentTimeMillis();
                        aVar.zUe = (int) Math.ceil(((double) j) / ((double) f.zTW));
                    }
                }
                synchronized (this.zTZ) {
                    this.zTZ.clear();
                }
                synchronized (this.zTZ) {
                    for (int defaultSensor : zUb) {
                        Sensor defaultSensor2 = this.bgR.getDefaultSensor(defaultSensor);
                        if (defaultSensor2 != null && this.bgR.registerListener(this.zUc, defaultSensor2, 0)) {
                            this.zTZ.add(defaultSensor2);
                            z = true;
                        }
                    }
                }
                if (!z) {
                    cDB();
                }
            }
        }
        return z;
    }

    public final synchronized void cDB() {
        if (this.bgR != null) {
            synchronized (this.zTZ) {
                Iterator it = this.zTZ.iterator();
                while (it.hasNext()) {
                    this.bgR.unregisterListener(this.zUc, (Sensor) it.next());
                }
                this.zTZ.clear();
            }
            a aVar = this.zUc;
            synchronized (aVar.zUd) {
                if (aVar.zUd.get()) {
                    aVar.zUd.set(false);
                    aVar.zUf = System.currentTimeMillis() - aVar.zTS;
                    if (aVar.zUf < 0) {
                        aVar.zUf = 0;
                    }
                    aVar.zTS = 0;
                }
            }
        }
    }

    public final SparseArray<i> cDC() {
        synchronized (this.zUa) {
            SparseArray<i> sparseArray = new SparseArray();
            for (int i = 0; i < this.zUa.size(); i++) {
                sparseArray.append(this.zUa.keyAt(i), (i) this.zUa.valueAt(i));
            }
            if (c(sparseArray)) {
                return sparseArray;
            }
            SparseArray<i> sparseArray2 = new SparseArray();
            return sparseArray2;
        }
    }

    private static boolean c(SparseArray<i> sparseArray) {
        if (sparseArray.size() == 0) {
            return false;
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            i iVar = (i) sparseArray.valueAt(i);
            if (iVar != null) {
                Object[] cDH = iVar.cDH();
                if (!(cDH == null || cDH.length == 0)) {
                    int i2 = 0;
                    for (Object obj : iVar.wj) {
                        if (((List) obj) != null) {
                            i2++;
                        }
                    }
                    if (i2 < 3) {
                        return false;
                    }
                    for (Object obj2 : cDH) {
                        List list = (List) obj2;
                        if (list != null && list.size() < f.zTX / 2) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        return true;
    }
}
