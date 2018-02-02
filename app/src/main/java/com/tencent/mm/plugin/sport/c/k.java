package com.tencent.mm.plugin.sport.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class k implements SensorEventListener {
    private static long rTX = 0;
    private static long rTY = 0;
    private static long rTZ = 0;
    private static long rUa = 0;
    private static long rUb = 0;
    private static long rUc = 0;
    private static long rUd = 0;
    private static long rUe = 0;
    public c rUf;

    public static long bDw() {
        return rTZ;
    }

    public static long bDx() {
        return rUb;
    }

    public k() {
        rUb = 0;
        rUc = 0;
        rUd = 0;
        rUe = 0;
        rTX = 0;
        rTY = 0;
        rTZ = 0;
        rUa = 0;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        JSONObject bDr = g.bDr();
        if (bDr.optInt("deviceStepSwitch") != 1) {
            if (this.rUf != null) {
                this.rUf.bDp();
            }
            x.i("MicroMsg.Sport.SportStepDetector", "device step switch off");
            return;
        }
        int optInt = bDr.optInt("stepCounterMaxStep5m", 3000);
        String str;
        String str2;
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            x.i("MicroMsg.Sport.SportStepDetector", "Step change %f, accuracy %s, %s", new Object[]{Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
            long cgt = bh.cgt() / 10000;
            if (rUb == 0) {
                rUb = i.yd(202);
            }
            if (rTY == 0) {
                rTY = i.yd(203);
            }
            if (rTZ == 0) {
                rTZ = i.yd(201);
            }
            if (rUa == 0) {
                rUa = rTZ;
            }
            if (rUc == 0) {
                rUc = i.yd(d.CTRL_INDEX);
            }
            if (rUd == 0) {
                rUd = rUc;
            }
            if (rUe == 0) {
                rUe = i.yd(c.CTRL_INDEX);
            }
            x.i("MicroMsg.Sport.SportStepDetector", "currentVar: beginOfToday %d saveTodayTime %d preSensorStep %d currentTodayStep %d lastSaveSensorStep %d lastSaveStepTime %d preSysStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(cgt), Long.valueOf(rUb), Long.valueOf(rTY), Long.valueOf(rTZ), Long.valueOf(rUa), Long.valueOf(rUc), Long.valueOf(rUd), Long.valueOf(rUe)});
            long j = (long) sensorEvent.values[0];
            rTX = j;
            if (j >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = sensorEvent.timestamp;
                if (rUb != cgt) {
                    x.i("MicroMsg.Sport.SportStepDetector", "new day beginOfToday: %s saveTodayTime: %s, ", new Object[]{n.bp(10000 * cgt), n.bp(rUb * 10000)});
                    i.M(202, cgt);
                    i.M(201, 0);
                    i.M(d.CTRL_INDEX, currentTimeMillis);
                    i.M(c.CTRL_INDEX, sensorEvent.timestamp);
                    i.M(203, (long) ((int) rTX));
                    rTY = rTX;
                    rTZ = 0;
                    rUa = 0;
                    rUb = cgt;
                    rUc = currentTimeMillis;
                    rUd = currentTimeMillis;
                    rUe = j2;
                    return;
                }
                boolean z;
                long j3 = ((currentTimeMillis - rUd) / 300000) + ((long) ((currentTimeMillis - rUd) % 300000 > 0 ? 1 : 0));
                long j4 = (((j2 / 1000000) - (rUe / 1000000)) / 300000) + ((long) (((j2 / 1000000) - (rUe / 1000000)) % 300000 > 0 ? 1 : 0));
                x.i("MicroMsg.Sport.SportStepDetector", "timesOf5Minute(%d, %d). rebootTime: %d %s", new Object[]{Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(i.yd(g.CTRL_INDEX)), n.bp(i.yd(g.CTRL_INDEX))});
                boolean z2 = false;
                str = "";
                long j5;
                if (i.yd(g.CTRL_INDEX) > rUc) {
                    j5 = rTX - rUa;
                    if (j5 <= 0 || (j5 >= ((long) optInt) * j4 && j5 >= ((long) optInt) * j3)) {
                        str2 = str;
                        cgt = 0;
                    } else {
                        str2 = "rebootIncrease Valid Step diffStep > 0";
                        cgt = j5;
                    }
                    if (j5 < 0 && (rTX < j4 * ((long) optInt) || rTX < j3 * ((long) optInt))) {
                        cgt = rTX;
                        str2 = "rebootIncrease Valid Step diffStep < 0";
                    }
                    i.M(g.CTRL_INDEX, 0);
                    z = true;
                } else {
                    if (rTX < rTY) {
                        x.i("MicroMsg.Sport.SportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[]{Long.valueOf(rTX), Long.valueOf(rTY), Long.valueOf(rUa)});
                        j5 = rTX;
                        rTY = j5;
                        rUa = j5;
                        z2 = true;
                    }
                    if (rTX - rTY < j4 * ((long) optInt) || rTX - rTY < j3 * ((long) optInt)) {
                        str2 = "normalIncrease Valid Step";
                        z = z2;
                        cgt = rTX - rTY;
                    } else {
                        str2 = str;
                        z = z2;
                        cgt = 0;
                    }
                }
                x.i("MicroMsg.Sport.SportStepDetector", "increase step %s %d %b", new Object[]{str2, Long.valueOf(cgt), Boolean.valueOf(z)});
                rTZ = cgt + rTZ;
                if (currentTimeMillis - rUc > ((long) bDr.optInt("stepCounterSaveInterval", 60000)) || rTX - rUa > ((long) bDr.optInt("stepCounterSaveStep")) || z) {
                    i.M(201, rTZ);
                    i.M(203, rTX);
                    i.M(d.CTRL_INDEX, currentTimeMillis);
                    i.M(c.CTRL_INDEX, j2);
                    x.i("MicroMsg.Sport.SportStepDetector", "save to [file] currentTodayStep %d lastSaveSensorStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(rTZ), Long.valueOf(rUa), Long.valueOf(rUd), Long.valueOf(rUc), Long.valueOf(rUe)});
                    rUc = currentTimeMillis;
                    rUa = rTX;
                } else {
                    x.i("MicroMsg.Sport.SportStepDetector", "save to cache currentTodayStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(rTZ), Long.valueOf(rUd), Long.valueOf(rUc), Long.valueOf(rUe)});
                }
                rTY = rTX;
                rUd = currentTimeMillis;
                rUe = j2;
            }
        } else if (sensorEvent == null || sensorEvent.values == null) {
            str = "MicroMsg.Sport.SportStepDetector";
            str2 = "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(sensorEvent == null);
            objArr[1] = Boolean.valueOf(sensorEvent != null);
            x.e(str, str2, objArr);
        } else {
            x.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[]{Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
            int i = 0;
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i2 = 0;
            while (i2 < length) {
                float f = fArr[i2];
                r10 = new Object[2];
                int i3 = i + 1;
                r10[0] = Integer.valueOf(i);
                r10[1] = Float.valueOf(f);
                x.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i2++;
                i = i3;
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
