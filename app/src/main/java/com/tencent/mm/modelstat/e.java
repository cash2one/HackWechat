package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.bd.b.1;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import junit.framework.Assert;

public class e {
    private static e hQG;
    private int hQH = -1;
    private int hQI = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;
    private int hQJ = 3000;
    private int hQK = 1000;
    private int hQL = 20;
    private ArrayList<Pair<Float, Float>> hQM = new ArrayList();
    private ArrayList<Pair<Float, Float>> hQN = new ArrayList();
    private long startTime = 0;

    class b {
        final /* synthetic */ e hQT;
        private SensorManager hRa;
        long hRb = 0;
        a hRc = null;
        a hRd = null;
        a hRe = null;
        private Long hRf = null;
        ArrayList<Long> hRg = new ArrayList();
        ArrayList<a> hRh = new ArrayList();
        ArrayList<a> hRi = new ArrayList();
        ArrayList<a> hRj = new ArrayList();
        ArrayList<float[]> hRk = new ArrayList();
        private SensorEventListener hRl = new SensorEventListener(this) {
            final /* synthetic */ b hRm;

            {
                this.hRm = r1;
            }

            public final void onAccuracyChanged(Sensor sensor, int i) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    long Wp = bh.Wp();
                    if (sensorEvent.sensor.getType() == 1) {
                        this.hRm.hRc = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 2) {
                        this.hRm.hRd = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 4) {
                        this.hRm.hRe = new a(sensorEvent);
                    }
                    long j = Wp - this.hRm.hhB;
                    if (this.hRm.hRc != null && this.hRm.hRd != null && this.hRm.hRe != null) {
                        if (j > this.hRm.hRb || j < 0) {
                            float[] fArr = new float[9];
                            SensorManager.getRotationMatrix(fArr, null, this.hRm.hRc.values, this.hRm.hRd.values);
                            Object obj = new float[3];
                            SensorManager.getOrientation(fArr, obj);
                            this.hRm.hhB = Wp;
                            this.hRm.hRg.add(Long.valueOf(Wp));
                            this.hRm.hRh.add(this.hRm.hRc);
                            this.hRm.hRi.add(this.hRm.hRd);
                            this.hRm.hRj.add(this.hRm.hRe);
                            this.hRm.hRk.add(obj);
                            int size = this.hRm.hRh.size() - 1;
                            x.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[]{Integer.valueOf(this.hRm.hRh.size()), Integer.valueOf(((a) this.hRm.hRh.get(size)).accuracy), Float.valueOf(((a) this.hRm.hRh.get(size)).values[0]), Float.valueOf(((a) this.hRm.hRh.get(size)).values[1]), Float.valueOf(((a) this.hRm.hRh.get(size)).values[2])});
                            x.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[]{Long.valueOf(j), Integer.valueOf(this.hRm.hRc.accuracy), Float.valueOf(this.hRm.hRc.values[0]), Float.valueOf(this.hRm.hRc.values[1]), Float.valueOf(this.hRm.hRc.values[2]), Integer.valueOf(this.hRm.hRd.accuracy), Float.valueOf(this.hRm.hRd.values[0]), Float.valueOf(this.hRm.hRd.values[1]), Float.valueOf(this.hRm.hRd.values[2]), Integer.valueOf(this.hRm.hRe.accuracy), Float.valueOf(this.hRm.hRe.values[0]), Float.valueOf(this.hRm.hRe.values[1]), Float.valueOf(this.hRm.hRe.values[2]), Float.valueOf(obj[0]), Float.valueOf(obj[1]), Float.valueOf(obj[2])});
                        }
                    }
                }
            }
        };
        private HandlerThread handlerThread = null;
        long hhB = 0;

        b(e eVar) {
            this.hQT = eVar;
        }

        public final boolean u(Context context, int i) {
            boolean z;
            try {
                if (this.hRa == null) {
                    this.hRa = (SensorManager) context.getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = com.tencent.mm.sdk.f.e.cZ("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.hRa.registerListener(this.hRl, this.hRa.getDefaultSensor(1), 3, handler) && this.hRa.registerListener(this.hRl, this.hRa.getDefaultSensor(4), 3, handler) && this.hRa.registerListener(this.hRl, this.hRa.getDefaultSensor(2), 3, handler);
            } catch (Exception e) {
                x.e("MicroMsg.IndoorReporter", "start except:%s", new Object[]{e.getMessage()});
                z = false;
            }
            if (!z) {
                try {
                    if (this.hRa != null) {
                        this.hRa.unregisterListener(this.hRl);
                        this.hRa = null;
                    }
                } catch (Exception e2) {
                }
                try {
                    if (this.handlerThread != null) {
                        this.handlerThread.quit();
                        this.handlerThread = null;
                    }
                } catch (Exception e3) {
                }
            }
            this.hRb = (long) i;
            this.hRf = Long.valueOf(bh.Wp());
            return z;
        }

        public final String ST() {
            try {
                if (this.hRa != null) {
                    this.hRa.unregisterListener(this.hRl);
                    this.hRa = null;
                }
            } catch (Exception e) {
            }
            try {
                if (this.handlerThread != null) {
                    this.handlerThread.quit();
                    this.handlerThread = null;
                }
            } catch (Exception e2) {
            }
            x.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[]{Integer.valueOf(this.hRg.size())});
            String str = this.hRf + ";" + this.hRg.size() + ";#";
            int i = 0;
            while (i < this.hRg.size()) {
                String str2 = (str + (((Long) this.hRg.get(i)).longValue() - this.hRf.longValue()) + ";") + a((a) this.hRh.get(i));
                x.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[]{Integer.valueOf(i), Integer.valueOf(((a) this.hRh.get(i)).accuracy), Float.valueOf(((a) this.hRh.get(i)).values[0]), Float.valueOf(((a) this.hRh.get(i)).values[1]), Float.valueOf(((a) this.hRh.get(i)).values[2]), a((a) this.hRh.get(i))});
                i++;
                str = ((str2 + a((a) this.hRj.get(i))) + a((a) this.hRi.get(i))) + String.format("%.3f;%.3f;%.3f;#", new Object[]{Float.valueOf(((float[]) this.hRk.get(i))[0]), Float.valueOf(((float[]) this.hRk.get(i))[1]), Float.valueOf(((float[]) this.hRk.get(i))[2])});
            }
            x.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[]{Integer.valueOf(str.length()), str});
            return str;
        }

        private static String a(a aVar) {
            try {
                String str = new String();
                return String.format("%d;%.3f;%.3f;%.3f;", new Object[]{Integer.valueOf(aVar.accuracy), Float.valueOf(aVar.values[0]), Float.valueOf(aVar.values[1]), Float.valueOf(aVar.values[2])});
            } catch (Exception e) {
                return "0;0;0;0;";
            }
        }
    }

    static /* synthetic */ boolean o(float f, float f2) {
        return ((double) Math.abs(f - f2)) < Math.pow(0.1d, 2.0d);
    }

    public static e SS() {
        if (hQG == null) {
            synchronized (e.class) {
                if (hQG == null) {
                    hQG = new e();
                }
            }
        }
        return hQG;
    }

    public final void a(int i, boolean z, boolean z2, float f, float f2, int i2) {
        x.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2)});
        if (g.Dh().Cy()) {
            g.Dh();
            if (!a.Cs()) {
                com.tencent.mm.bd.b Rk = com.tencent.mm.bd.b.Rk();
                String str = "";
                String str2 = "";
                int i3 = z2 ? 1 : 0;
                if (g.Dh().Cy()) {
                    g.Dh();
                    if (!a.Cs()) {
                        g.Dk();
                        g.Dm().F(new 1(Rk, i3, f, f2, i, i2, 0, str, str2));
                    }
                }
                if (this.hQN.size() != 0 || this.hQM.size() != 0 || mL(com.tencent.mm.k.g.zY().getValue("AndroidIndoorSensorReport"))) {
                    if (!com.tencent.mm.sdk.a.b.ceK()) {
                        g.Dh();
                        int aJ = h.aJ(a.Cg() + 5, 100);
                        if (aJ > this.hQH) {
                            r3 = new Object[3];
                            g.Dh();
                            r3[0] = Long.valueOf(new o(a.Cg()).longValue());
                            r3[1] = Integer.valueOf(aJ);
                            r3[2] = Integer.valueOf(this.hQH);
                            x.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", r3);
                            return;
                        }
                    }
                    g.Dk();
                    g.Dm().F(new 1(this, z2, f, f2, i, z, i2));
                }
            }
        }
    }

    public final boolean mL(String str) {
        if (bh.ov(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.hQH = bh.getInt(split[0], -1);
            if (this.hQH > 101) {
                Assert.assertTrue(false);
            }
            this.hQI = bh.getInt(split[1], HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            this.hQJ = bh.getInt(split[2], 3000);
            this.hQK = bh.getInt(split[3], 1000);
            this.hQL = bh.getInt(split[4], 20);
            int i = bh.getInt(split[5], 0);
            for (int i2 = 0; i2 < i; i2++) {
                String[] split2 = split[i2 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.hQM.add(new Pair(Float.valueOf(bh.VL(split2[1])), Float.valueOf(bh.VL(split2[2]))));
                } else {
                    this.hQN.add(new Pair(Float.valueOf(bh.VL(split2[1])), Float.valueOf(bh.VL(split2[2]))));
                }
            }
            x.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[]{Integer.valueOf(this.hQI), Integer.valueOf(this.hQJ), Integer.valueOf(this.hQK), Integer.valueOf(this.hQL), Integer.valueOf(i), Integer.valueOf(this.hQM.size()), Integer.valueOf(this.hQN.size())});
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[]{e.getMessage(), str});
            return false;
        }
    }
}
