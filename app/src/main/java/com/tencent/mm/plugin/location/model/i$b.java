package com.tencent.mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.location.model.i.a;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;

protected class i$b implements SensorEventListener {
    private float jmn = 0.0f;
    final /* synthetic */ i nQX;
    private long timestamp = 200;

    protected i$b(i iVar) {
        this.nQX = iVar;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        if (sensorEvent.sensor.getType() == 3) {
            long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
            float aA = r.aA(sensorEvent.values[0]);
            if (currentTimeMillis > 200 && Math.abs(aA - this.jmn) > 3.0f) {
                i iVar = this.nQX;
                float f = this.jmn;
                iVar.nQV = (double) aA;
                String str = "MicroMsg.OrientationSensorMgr";
                String str2 = "onOrientationChanged %f %f, mListenerList.size = %d";
                Object[] objArr = new Object[3];
                objArr[0] = Float.valueOf(f);
                objArr[1] = Float.valueOf(aA);
                if (iVar.jSI != null) {
                    i = iVar.jSI.size();
                }
                objArr[2] = Integer.valueOf(i);
                x.d(str, str2, objArr);
                if (iVar.jSI != null) {
                    Iterator it = iVar.jSI.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((a) weakReference.get()).n(iVar.aVn());
                        }
                    }
                }
                this.jmn = aA;
                this.timestamp = System.currentTimeMillis();
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
