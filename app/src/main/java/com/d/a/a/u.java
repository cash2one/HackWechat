package com.d.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u extends d implements SensorEventListener {
    private static u bkS;
    private static final int bky;
    private static final int bkz;
    private SensorManager bgR = null;
    private Sensor bkA;
    private Sensor bkB;
    private Sensor bkC;
    private Sensor bkD;
    private Sensor bkE = null;
    private long bkF = 0;
    private boolean bkG = true;
    private float[][] bkH = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bkI = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bkJ = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9}));
    private float[][] bkK = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkL = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkM = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkN = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[] bkO = new float[4];
    private float[][] bkP = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkQ = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    private float[][] bkR = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3}));
    boolean bkT;
    private c bkU;
    private boolean[] bkV = new boolean[6];
    private int[] bkW = new int[6];
    private float[] bkX = new float[6];
    private float[] bkY = new float[6];
    private float[] bkZ = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    private float[][] bla = ((float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20}));
    private final d blb = new d((byte) 0);
    private final f blc = new f();
    private final a bld = new a();

    private static class a {
        int ble;
        float blf;
        long blg;
        float blh;
        boolean bli;
        long blj;
        float[] blk;
        float[] bll;
        float[] blm;
        float[] bln;
        float[] blo;
        float[] blp;
        float[] blq;
        float[] blr;
        float[] bls;
        float blt;
        float blu;
        float blv;
        boolean blw;

        private a() {
            this.ble = 0;
            this.blf = 0.0f;
            this.blg = 0;
            this.blh = 0.0f;
            this.bli = false;
            this.blj = 0;
            this.blk = new float[6];
            this.bll = new float[6];
            this.blm = new float[6];
            this.bln = new float[6];
            this.blo = new float[6];
            this.blp = new float[6];
            this.blq = new float[6];
            this.blr = new float[6];
            this.bls = new float[6];
            this.blt = 0.0f;
            this.blu = Float.NEGATIVE_INFINITY;
            this.blv = Float.POSITIVE_INFINITY;
            this.blw = false;
        }

        final void reset() {
            this.ble = 0;
            this.blf = 0.0f;
            this.blg = 0;
            this.blh = 0.0f;
            this.bli = false;
            this.blj = 0;
            this.blk = new float[6];
            this.bll = new float[6];
            this.blm = new float[6];
            this.blt = 0.0f;
            this.blu = Float.NEGATIVE_INFINITY;
            this.blv = Float.POSITIVE_INFINITY;
        }
    }

    private class f {
        final /* synthetic */ u blN;
        private ArrayList<b> bma;
        private a[] bmb;
        private int bmc;
        private float[][] bmd;
        private float[][] bme;
        private float[][] bmf;
        private int[] bmg;
        private int bmh;
        private int bmi;
        private int bmj;

        private f(u uVar) {
            this.blN = uVar;
            this.bma = new ArrayList();
            this.bmb = new a[5];
            this.bmc = 0;
            this.bmd = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bme = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bmf = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.bmg = new int[6];
            this.bmh = 5;
            this.bmi = -1;
            this.bmj = 0;
        }

        final synchronized void reset() {
            this.bma.clear();
            this.bmb = new a[5];
            this.bmc = 0;
            this.bmd = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bme = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
            this.bmf = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
            this.bmg = new int[6];
            this.bmh = 5;
        }

        private synchronized boolean su() {
            boolean z;
            if (this.bmc >= 20) {
                float[] fArr = this.bmd[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bmd[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bmd[2];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bme[0];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bme[1];
                fArr[2] = fArr[2] / 20.0f;
                fArr = this.bme[2];
                fArr[2] = fArr[2] / 20.0f;
                float f = this.bme[0][2];
                float f2 = this.bmd[0][0] - this.bmd[0][2];
                float f3 = this.bmd[0][2] - this.bmd[0][1];
                float f4 = this.bme[1][2];
                float f5 = this.bmd[1][0] - this.bmd[1][2];
                float f6 = this.bmd[1][2] - this.bmd[1][1];
                float f7 = this.bme[2][2];
                float f8 = this.bmd[2][0] - this.bmd[2][2];
                float f9 = this.bmd[2][2] - this.bmd[2][1];
                this.bmf[0][0] = (f * 0.32999998f) + (0.67f * this.bmf[0][0]);
                this.bmf[0][1] = (f2 * 0.32999998f) + (0.67f * this.bmf[0][1]);
                this.bmf[0][2] = (f3 * 0.32999998f) + (0.67f * this.bmf[0][2]);
                this.bmf[1][0] = (0.67f * this.bmf[1][0]) + (f4 * 0.32999998f);
                this.bmf[1][1] = (0.67f * this.bmf[1][1]) + (0.32999998f * f5);
                this.bmf[1][2] = (0.67f * this.bmf[1][2]) + (0.32999998f * f6);
                this.bmf[2][0] = (0.67f * this.bmf[2][0]) + (0.32999998f * f7);
                this.bmf[2][1] = (0.67f * this.bmf[2][1]) + (0.32999998f * f8);
                this.bmf[2][2] = (0.67f * this.bmf[2][2]) + (0.32999998f * f9);
                a(sv());
                this.bmc = 0;
                this.bmd = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                this.bme = new float[][]{new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}, new float[]{Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0f}};
                if (this.bma.size() >= 100) {
                    this.bma.subList(0, 20).clear();
                    this.bma.trimToSize();
                }
                z = true;
            } else {
                z = false;
            }
            return z;
        }

        private synchronized a sv() {
            a aVar;
            Object obj;
            float abs;
            float abs2;
            float abs3;
            float f;
            int i;
            int i2;
            Object obj2 = this.bmj == 0 ? 1 : null;
            if (obj2 != null) {
                this.bmh = ((double) Math.abs(this.bmf[2][0])) < 9.3d ? 5 : 2;
                this.bmg = new int[6];
                obj = null;
            } else {
                Object obj3 = (Math.abs(this.bmf[0][0]) < 7.0f || (this.bmf[1][1] < 2.3f && this.bmf[1][2] < 2.3f)) ? null : 1;
                if (obj3 != null) {
                    this.bmh = 2;
                    this.bmg = new int[6];
                    obj = obj3;
                } else {
                    int i3;
                    abs = Math.abs(this.bmf[0][0]);
                    abs2 = Math.abs(this.bmf[1][0]);
                    abs3 = Math.abs(this.bmf[2][0]);
                    if (abs > abs2) {
                        if (abs > abs3) {
                            i3 = 0;
                        } else {
                            i3 = 2;
                        }
                    } else if (abs2 > abs3) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    f = 0.0f;
                    int i4 = 0;
                    i = 0;
                    for (i2 = 0; i2 < 3; i2++) {
                        if (i2 != i3) {
                            for (int i5 = 1; i5 < 3; i5++) {
                                if (this.bmf[i2][i5] > f) {
                                    i4 = i2;
                                    f = this.bmf[i2][i5];
                                    i = i5;
                                }
                            }
                        }
                    }
                    i3 = ((i4 * 2) + i) - 1;
                    int[] iArr = this.bmg;
                    iArr[i3] = iArr[i3] + 1;
                    i3 = 0;
                    while (i3 <= 5) {
                        if (i3 != this.bmh && this.bmg[i3] > this.bmg[this.bmh]) {
                            this.bmh = i3;
                        }
                        i3++;
                    }
                    obj = obj3;
                }
            }
            if (this.bmi >= 0 && this.bmi <= 5) {
                this.bmh = this.bmi;
            }
            aVar = new a(this, (byte) 0);
            aVar = new a(this, (byte) 0);
            if (this.bmb[0] != null) {
                aVar.bmo = this.bmb[0].bmo;
                aVar.bml = this.bmb[0].bml;
            }
            if (this.bmb[4] != null) {
                aVar.bmo = this.bmb[4].bmo;
                aVar.bml = this.bmb[4].bml;
            }
            if (!this.bma.isEmpty()) {
                b bVar;
                i2 = this.bma.size();
                float[] fArr = new float[6];
                float[] fArr2 = new float[6];
                Iterator it = this.bma.iterator();
                abs3 = 0.0f;
                float f2 = 0.0f;
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    f2 += obj == null ? bVar.blz : bVar.blC;
                    if (obj == null) {
                        abs2 = bVar.blH;
                    } else {
                        abs2 = (float) Math.sqrt((double) (((bVar.blA * bVar.blA) + (bVar.blB * bVar.blB)) + (bVar.blC * bVar.blC)));
                        bVar.blG = abs2;
                    }
                    abs3 += abs2;
                    for (i = 0; i <= 5; i++) {
                        fArr[i] = fArr[i] + bVar.blL[i];
                        fArr2[i] = fArr2[i] + bVar.blM[i];
                    }
                }
                float f3 = f2 / ((float) i2);
                float f4 = abs3 / ((float) i2);
                float f5 = obj == null ? f3 : f4;
                float[] fArr3 = new float[]{(float) Math.atan2((double) fArr[0], (double) fArr2[0]), (float) Math.atan2((double) fArr[1], (double) fArr2[1]), (float) Math.atan2((double) fArr[2], (double) fArr2[2]), (float) Math.atan2((double) fArr[3], (double) fArr2[3]), (float) Math.atan2((double) fArr[4], (double) fArr2[4]), (float) Math.atan2((double) fArr[5], (double) fArr2[5])};
                f = obj == null ? f3 : f4;
                abs2 = 0.0f;
                float f6 = obj == null ? 1.2f : 1.0f;
                float f7 = obj2 != null ? 0.08726647f : 0.2617994f;
                Iterator it2 = this.bma.iterator();
                float f8 = 0.0f;
                float f9 = 0.0f;
                int i6 = 0;
                f2 = f4;
                while (it2.hasNext()) {
                    float f10;
                    bVar = (b) it2.next();
                    float f11 = obj == null ? bVar.blz : bVar.blG;
                    abs3 = obj == null ? bVar.blH : bVar.blG;
                    if (obj == null) {
                        f10 = f3;
                    } else {
                        f10 = f4;
                    }
                    if (i6 > 0) {
                        float f12;
                        float f13;
                        if (f < f11) {
                            if (obj2 == null) {
                                f = f11 - f10;
                                if (f > 2.0f * f6) {
                                    f12 = f / 2.0f;
                                    f13 = f11;
                                }
                            }
                            f12 = f6;
                            f13 = f11;
                        } else {
                            f12 = f6;
                            f13 = f;
                        }
                        if (f2 < abs3) {
                            f = abs3;
                        } else {
                            f = f2;
                        }
                        if (f11 > f10) {
                            f6 = f12;
                            f2 = f;
                            i6++;
                            f = f13;
                        } else {
                            if (i6 <= 10) {
                                Object obj4 = 1;
                                if (aVar.bmo != 0 && bVar.time - aVar.bmo < 250) {
                                    obj4 = null;
                                }
                                if (obj4 != null && f - f4 < 0.3f) {
                                    obj4 = null;
                                }
                                if (obj4 != null) {
                                    aVar.bmk++;
                                    abs2 += f13;
                                    f2 = (float) Math.atan2((double) (bVar.blL[this.bmh] + f9), (double) (bVar.blM[this.bmh] + f8));
                                    abs3 = Math.abs(f2 - fArr3[this.bmh]);
                                    if (abs3 > 3.1415927f) {
                                        abs3 = 6.2831855f - abs3;
                                    }
                                    Object obj5 = abs3 >= f7 ? 1 : null;
                                    abs3 = 1.0f;
                                    if (obj5 != null) {
                                        abs3 = 0.93f;
                                    } else {
                                        f2 = fArr3[this.bmh];
                                    }
                                    f6 = (float) (Math.sin((double) f2) * ((double) abs3));
                                    abs3 = (float) (((double) abs3) * Math.cos((double) f2));
                                    aVar.x += f6;
                                    aVar.y += abs3;
                                    if (bVar.time - aVar.bmo > 250) {
                                        aVar.x -= f6;
                                        aVar.y -= abs3;
                                        aVar.bmk++;
                                    }
                                }
                                aVar.bmo = bVar.time;
                            }
                            abs3 = bVar.blL[this.bmh];
                            f6 = f12;
                            f8 = bVar.blM[this.bmh];
                            f9 = abs3;
                            i6 = 0;
                            f2 = f;
                            f = f13;
                        }
                    } else if (f11 <= f10) {
                        abs3 = bVar.blL[this.bmh];
                        f8 = bVar.blM[this.bmh];
                        f9 = abs3;
                    } else if (f11 - f10 >= f6) {
                        f2 = abs3;
                        f = f11;
                        i6 = 1;
                    }
                }
                if (aVar.bmk > 0) {
                    abs = obj == null ? 0.0f : 0.08f;
                    abs2 /= (float) aVar.bmk;
                    abs3 = aVar.bml;
                    abs += ((abs2 - f5) / 15.0f) + 0.537f;
                    if (abs3 != 0.0f) {
                        abs = (abs * 0.67f) + (0.33f * abs3);
                    }
                    aVar.bml = abs;
                    aVar.x *= aVar.bml;
                    aVar.y *= aVar.bml;
                    aVar.bmm = ((float) aVar.bmk) * aVar.bml;
                }
            }
            aVar.bmn = aVar.bmm / ((float) (this.bma.size() / 20));
            if (this.bmb[0] != null) {
                aVar.x += this.bmb[0].x;
                aVar.y += this.bmb[0].y;
                aVar.z += this.bmb[0].z;
                aVar.bmk += this.bmb[0].bmk;
                aVar.bmm += this.bmb[0].bmm;
            }
            if (this.bmb[4] != null && aVar.bmk > 0) {
                this.bmb[4].x = ((this.bmb[4].x + aVar.x) + (aVar.x * aVar.bml)) / 2.0f;
                this.bmb[4].y = ((this.bmb[4].y + aVar.y) + (aVar.y * aVar.bml)) / 2.0f;
            }
            return aVar;
        }

        private synchronized void a(a aVar) {
            System.arraycopy(this.bmb, 1, this.bmb, 0, 4);
            if (this.bmb[4] == null || SystemClock.elapsedRealtime() - aVar.bmo <= 1000) {
                this.bmb[4] = aVar;
            } else {
                a aVar2 = this.bmb[4];
                aVar2.x = (aVar2.x + aVar.x) / 2.0f;
                aVar2.y = (aVar2.y + aVar.y) / 2.0f;
                aVar2.z = (aVar2.z + aVar.z) / 2.0f;
                aVar2.bmk = Math.round(((float) (aVar2.bmk + aVar.bmk)) / 2.0f);
                aVar2.bml = (aVar2.bml + aVar.bml) / 2.0f;
                aVar2.bmm = (aVar2.bmm + aVar.bmm) / 2.0f;
                aVar2.bmo = aVar.bmo;
                aVar2.bmn = aVar.bmn;
            }
        }

        final synchronized void a(b bVar) {
            if (this.bmj > 0 && this.bmj < 101) {
                this.bmj--;
            }
            this.bma.add(bVar);
            this.bmc++;
            if (bVar.blA > this.bmd[0][0]) {
                this.bmd[0][0] = bVar.blA;
            }
            if (bVar.blA < this.bmd[0][1]) {
                this.bmd[0][1] = bVar.blA;
            }
            float[] fArr = this.bmd[0];
            fArr[2] = fArr[2] + bVar.blA;
            if (bVar.blB > this.bmd[1][0]) {
                this.bmd[1][0] = bVar.blB;
            }
            if (bVar.blB < this.bmd[1][1]) {
                this.bmd[1][1] = bVar.blB;
            }
            fArr = this.bmd[1];
            fArr[2] = fArr[2] + bVar.blB;
            if (bVar.blC > this.bmd[2][0]) {
                this.bmd[2][0] = bVar.blC;
            }
            if (bVar.blC < this.bmd[2][1]) {
                this.bmd[2][1] = bVar.blC;
            }
            fArr = this.bmd[2];
            fArr[2] = fArr[2] + bVar.blC;
            if (bVar.blD > this.bme[0][0]) {
                this.bme[0][0] = bVar.blD;
            }
            if (bVar.blD < this.bme[0][1]) {
                this.bme[0][1] = bVar.blD;
            }
            fArr = this.bme[0];
            fArr[2] = fArr[2] + bVar.blD;
            if (bVar.blE > this.bme[1][0]) {
                this.bme[1][0] = bVar.blE;
            }
            if (bVar.blE < this.bme[1][1]) {
                this.bme[1][1] = bVar.blE;
            }
            fArr = this.bme[1];
            fArr[2] = fArr[2] + bVar.blE;
            if (bVar.blF > this.bme[2][0]) {
                this.bme[2][0] = bVar.blF;
            }
            if (bVar.blF < this.bme[2][1]) {
                this.bme[2][1] = bVar.blF;
            }
            fArr = this.bme[2];
            fArr[2] = fArr[2] + bVar.blF;
            if (su()) {
                u.b(this.blN);
            }
        }

        final synchronized a sw() {
            return this.bmb[4] != null ? this.bmb[4].sx() : null;
        }
    }

    static {
        int round = Math.round(50000.0f);
        bky = round;
        bkz = round;
    }

    static u st() {
        if (bkS == null) {
            bkS = new u();
        }
        return bkS;
    }

    private u() {
    }

    private static void a(float[][] fArr, float[][] fArr2) {
        for (int i = 0; i <= 5; i++) {
            SensorManager.getOrientation(fArr[i], fArr2[i]);
        }
    }

    private static float[] b(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[6]), ((fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4])) + (fArr[2] * fArr2[7]), ((fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5])) + (fArr[2] * fArr2[8]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3])) + (fArr[5] * fArr2[6]), ((fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4])) + (fArr[5] * fArr2[7]), ((fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5])) + (fArr[5] * fArr2[8]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3])) + (fArr[8] * fArr2[6]), ((fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4])) + (fArr[8] * fArr2[7]), ((fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5])) + (fArr[8] * fArr2[8])};
    }

    final void U(Context context) {
    }

    final void a(Context context, Handler handler, com.d.a.a.d.a aVar) {
        if (context == null) {
            try {
                throw new Exception("SensorModule: register with null context");
            } catch (Exception e) {
                this.bkT = false;
                return;
            }
        }
        boolean a;
        for (int i = 0; i <= 5; i++) {
            this.bkI[i][0] = 1.0f;
            this.bkI[i][1] = 0.0f;
            this.bkI[i][2] = 0.0f;
            this.bkI[i][3] = 0.0f;
            this.bkI[i][4] = 1.0f;
            this.bkI[i][5] = 0.0f;
            this.bkI[i][6] = 0.0f;
            this.bkI[i][7] = 0.0f;
            this.bkI[i][8] = 1.0f;
        }
        this.bgR = (SensorManager) context.getSystemService("sensor");
        this.bkA = this.bgR.getDefaultSensor(10);
        this.bkD = this.bgR.getDefaultSensor(9);
        if (!(this.bkA == null || this.bkD == null)) {
            this.bkE = this.bgR.getDefaultSensor(11);
            if (this.bkE != null) {
                a = a(this.bgR, this, bky, bkz, handler, this.bkA, this.bkD, this.bkE);
            } else {
                this.bkB = this.bgR.getDefaultSensor(4);
                this.bkC = this.bgR.getDefaultSensor(2);
                if (!(this.bkB == null || this.bkC == null)) {
                    a = a(this.bgR, this, bky, bkz, handler, this.bkA, this.bkD, this.bkB, this.bkC);
                }
            }
            if (a) {
                this.bkT = true;
                this.bkU = new c(this, handler);
                if (this.bkU != null) {
                    this.bkU.f((long) Math.round(50.0f), 1000);
                }
            }
        }
        a = false;
        if (a) {
            this.bkT = true;
            this.bkU = new c(this, handler);
            if (this.bkU != null) {
                this.bkU.f((long) Math.round(50.0f), 1000);
            }
        }
    }

    final void V(Context context) {
        if (this.bkU != null) {
            this.bkU.stop();
        }
        if (this.bgR != null) {
            try {
                this.bgR.unregisterListener(this);
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
        this.bgR = null;
        this.bkE = null;
        this.bkD = null;
        this.bkC = null;
        this.bkB = null;
        this.bkA = null;
        this.bkF = 0;
        this.bkG = true;
        this.bkH = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.bkI = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 9});
        this.bkK = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bkL = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bkM = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 3});
        this.bkV = new boolean[6];
        this.bkW = new int[6];
        this.bkX = new float[6];
        this.bkY = new float[6];
        this.bkZ = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        this.bla = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 20});
        this.bld.reset();
        this.blb.reset();
        this.blc.reset();
    }

    final void rR() {
    }

    final synchronized void a(Handler handler, com.d.a.a.d.a aVar) {
        super.a(handler, aVar);
    }

    static /* synthetic */ void b(u uVar) {
        a sw = uVar.blc.sw();
        if (sw != null) {
            uVar.c(new e(sw.x, sw.y, sw.bmk, sw.bml, sw.bmm, sw.bmn, (byte) 0));
        }
    }

    @TargetApi(19)
    private static boolean a(SensorManager sensorManager, SensorEventListener sensorEventListener, int i, int i2, Handler handler, Sensor... sensorArr) {
        try {
            Object obj = VERSION.SDK_INT >= 19 ? 1 : null;
            int length = sensorArr.length;
            int i3 = 0;
            while (i3 < length) {
                Sensor sensor = sensorArr[i3];
                if (obj != null ? sensorManager.registerListener(sensorEventListener, sensor, i, i2, handler) : sensorManager.registerListener(sensorEventListener, sensor, i, handler)) {
                    i3++;
                } else {
                    sensorManager.unregisterListener(sensorEventListener);
                    return false;
                }
            }
            return true;
        } catch (Error e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    static /* synthetic */ void a(u uVar) {
        if (!(uVar.bkA == null || uVar.bkB == null || uVar.bkC == null || uVar.bkD == null)) {
            for (int i = 0; i <= 5; i++) {
                float f;
                float[] fArr;
                float[] fArr2;
                float f2;
                float f3;
                float abs;
                Object obj = null;
                if (Float.isNaN(uVar.bkZ[i])) {
                    uVar.bkZ[i] = uVar.bkL[i][0];
                } else {
                    f = uVar.bkL[i][0] - uVar.bkM[i][0];
                    if (f < -3.1415927f) {
                        f += 6.2831855f;
                    } else if (f > 3.1415927f) {
                        f -= 6.2831855f;
                    }
                    fArr = uVar.bla[i];
                    int[] iArr = uVar.bkW;
                    int i2 = iArr[i];
                    iArr[i] = i2 + 1;
                    fArr[i2] = f;
                    if (uVar.bkW[i] == 20) {
                        uVar.bkW[i] = 0;
                        if (!uVar.bkV[i]) {
                            uVar.bkV[i] = true;
                        }
                    }
                    fArr = uVar.bkY;
                    fArr[i] = fArr[i] + f;
                    fArr = uVar.bkX;
                    fArr[i] = f + fArr[i];
                    if (uVar.bkV[i]) {
                        Object obj2;
                        if (Math.abs(uVar.bkX[i]) < 0.08726647f) {
                            if (Math.abs(uVar.bkY[i]) < 0.08726647f) {
                                f = uVar.bkL[i][0] - uVar.bkZ[i];
                                if (f < -3.1415927f) {
                                    f += 6.2831855f;
                                } else if (f > 3.1415927f) {
                                    f -= 6.2831855f;
                                }
                                uVar.bkL[i][0] = (f / 2.0f) + uVar.bkZ[i];
                                if (uVar.bkL[i][0] < -3.1415927f) {
                                    uVar.bkL[i][0] = 6.2831855f + uVar.bkL[i][0];
                                } else if (uVar.bkL[i][0] > 3.1415927f) {
                                    uVar.bkL[i][0] = uVar.bkL[i][0] - 6.2831855f;
                                }
                                uVar.bkZ[i] = uVar.bkL[i][0];
                                obj2 = 1;
                                fArr2 = uVar.bkX;
                                fArr2[i] = fArr2[i] - uVar.bla[i][uVar.bkW[i]];
                                obj = obj2;
                            } else {
                                f = uVar.bkY[i] % 1.5707964f;
                                float abs2 = Math.abs(f);
                                if (abs2 < 0.08726647f) {
                                    fArr = uVar.bkY;
                                    fArr[i] = fArr[i] - f;
                                    uVar.bkZ[i] = (uVar.bkZ[i] + uVar.bkY[i]) % 6.2831855f;
                                    if (uVar.bkZ[i] < -3.1415927f) {
                                        uVar.bkZ[i] = 6.2831855f + uVar.bkZ[i];
                                    } else if (uVar.bkZ[i] > 3.1415927f) {
                                        uVar.bkZ[i] = uVar.bkZ[i] - 6.2831855f;
                                    }
                                } else if (abs2 > 1.4835299f) {
                                    if (uVar.bkY[i] > 0.0f) {
                                        uVar.bkY[i] = (uVar.bkY[i] - f) + 1.5707964f;
                                    } else {
                                        uVar.bkY[i] = (uVar.bkY[i] - f) - 1.5707964f;
                                    }
                                    uVar.bkZ[i] = (uVar.bkZ[i] + uVar.bkY[i]) % 6.2831855f;
                                    if (uVar.bkZ[i] < -3.1415927f) {
                                        uVar.bkZ[i] = 6.2831855f + uVar.bkZ[i];
                                    } else if (uVar.bkZ[i] > 3.1415927f) {
                                        uVar.bkZ[i] = uVar.bkZ[i] - 6.2831855f;
                                    }
                                } else {
                                    uVar.bkZ[i] = uVar.bkL[i][0];
                                }
                                uVar.bkY[i] = 0.0f;
                            }
                        }
                        obj2 = null;
                        fArr2 = uVar.bkX;
                        fArr2[i] = fArr2[i] - uVar.bla[i][uVar.bkW[i]];
                        obj = obj2;
                    }
                }
                a aVar = uVar.bld;
                float[] fArr3 = uVar.bkL[i];
                float[] fArr4 = uVar.bkK[i];
                float[] fArr5 = uVar.bkM[i];
                if (i == 0 && aVar.ble != 0) {
                    aVar.blg++;
                    aVar.blt = aVar.blf / ((float) aVar.ble);
                    f2 = aVar.blt - aVar.blh;
                    f = Math.abs(f2);
                    f3 = aVar.blh;
                    f = (aVar.blh == 0.0f || aVar.blg <= 20 || f <= 1.25f) ? 1.0f : 1.25f / f;
                    aVar.blh = (f * (f2 / ((float) aVar.blg))) + f3;
                    aVar.bli = Math.abs(aVar.blt - aVar.blh) >= 1.25f;
                    if (aVar.bli) {
                        if (aVar.blj < 1200) {
                            aVar.blj++;
                        }
                    } else if (aVar.blj > 0) {
                        aVar.blj--;
                    }
                    aVar.ble = 0;
                    aVar.blf = 0.0f;
                    if (aVar.blt < aVar.blv) {
                        aVar.blv = aVar.blt;
                    }
                    if (aVar.blt > aVar.blu) {
                        aVar.blu = aVar.blt;
                    }
                    if (aVar.blg == 20 && Math.max(aVar.blu - aVar.blh, aVar.blh - aVar.blv) > 5.0f) {
                        aVar.reset();
                    }
                }
                float[] fArr6;
                if (aVar.blg <= 20) {
                    fArr6 = aVar.blq;
                    fArr2 = aVar.blr;
                    aVar.bls[i] = 1.0f;
                    fArr2[i] = 1.0f;
                    fArr6[i] = 1.0f;
                    fArr6 = aVar.bln;
                    fArr2 = aVar.blo;
                    aVar.blp[i] = 0.0f;
                    fArr2[i] = 0.0f;
                    fArr6[i] = 0.0f;
                } else if (aVar.bli || aVar.blw || r1 != null) {
                    fArr6 = aVar.bln;
                    fArr2 = aVar.blo;
                    aVar.blp[i] = 1.0f;
                    fArr2[i] = 1.0f;
                    fArr6[i] = 1.0f;
                    fArr6 = aVar.blq;
                    fArr2 = aVar.blr;
                    aVar.bls[i] = 0.0f;
                    fArr2[i] = 0.0f;
                    fArr6[i] = 0.0f;
                } else {
                    if (aVar.blj > 0) {
                        aVar.blk[i] = fArr5[0];
                        aVar.bll[i] = fArr5[1];
                        aVar.blm[i] = fArr5[2];
                    }
                    f = Math.abs(fArr5[0] - fArr3[0]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.blk[i] - fArr4[0]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    aVar.bln[i] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.bln[i]) / 2.0f;
                    aVar.blq[i] = 1.0f - aVar.bln[i];
                    f = Math.abs(fArr5[1] - fArr3[1]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.bll[i] - fArr4[1]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    f2 = Math.max(abs, f);
                    aVar.blo[i] = ((f2 != 0.0f ? (((abs - f) / f2) + 1.0f) * 0.5f : 1.0f) + aVar.blo[i]) / 2.0f;
                    aVar.blr[i] = 1.0f - aVar.blo[i];
                    f = Math.abs(fArr5[2] - fArr3[2]);
                    if (f > 3.1415927f) {
                        f = 6.2831855f - f;
                    }
                    abs = Math.abs(aVar.blm[i] - fArr4[2]);
                    if (abs > 3.1415927f) {
                        abs = 6.2831855f - abs;
                    }
                    float max = Math.max(abs, f);
                    aVar.blp[i] = ((max != 0.0f ? (((abs - f) / max) + 1.0f) * 0.5f : 1.0f) + aVar.blp[i]) / 2.0f;
                    aVar.bls[i] = 1.0f - aVar.blp[i];
                }
                aVar.blk[i] = fArr4[0];
                aVar.bll[i] = fArr4[1];
                aVar.blm[i] = fArr4[2];
                f = uVar.bkK[i][0] - uVar.bkL[i][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bld.blq[i]) + uVar.bkL[i][0];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bkM[i][0] = f;
                f = uVar.bkK[i][1] - uVar.bkL[i][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bld.blr[i]) + uVar.bkL[i][1];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bkM[i][1] = f;
                f = uVar.bkK[i][2] - uVar.bkL[i][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                f = (f * uVar.bld.bls[i]) + uVar.bkL[i][2];
                if (f < -3.1415927f) {
                    f += 6.2831855f;
                } else if (f > 3.1415927f) {
                    f -= 6.2831855f;
                }
                uVar.bkM[i][2] = f;
                float[][] fArr7 = uVar.bkI;
                fArr2 = uVar.bkM[i];
                fArr = new float[9];
                fArr3 = new float[9];
                fArr4 = new float[9];
                float sin = (float) Math.sin((double) fArr2[1]);
                f2 = (float) Math.cos((double) fArr2[1]);
                f3 = (float) Math.sin((double) fArr2[2]);
                float cos = (float) Math.cos((double) fArr2[2]);
                float sin2 = (float) Math.sin((double) fArr2[0]);
                abs = (float) Math.cos((double) fArr2[0]);
                fArr[0] = 1.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = f2;
                fArr[5] = sin;
                fArr[6] = 0.0f;
                fArr[7] = -sin;
                fArr[8] = f2;
                fArr3[0] = cos;
                fArr3[1] = 0.0f;
                fArr3[2] = f3;
                fArr3[3] = 0.0f;
                fArr3[4] = 1.0f;
                fArr3[5] = 0.0f;
                fArr3[6] = -f3;
                fArr3[7] = 0.0f;
                fArr3[8] = cos;
                fArr4[0] = abs;
                fArr4[1] = sin2;
                fArr4[2] = 0.0f;
                fArr4[3] = -sin2;
                fArr4[4] = abs;
                fArr4[5] = 0.0f;
                fArr4[6] = 0.0f;
                fArr4[7] = 0.0f;
                fArr4[8] = 1.0f;
                fArr7[i] = b(fArr4, b(fArr, fArr3));
                System.arraycopy(uVar.bkM[i], 0, uVar.bkL[i], 0, 3);
            }
        }
        b a = uVar.blb.a(uVar.bkE != null ? uVar.bkN : uVar.bkM);
        if (a != null) {
            uVar.blc.a(a);
        }
    }

    private static void a(float[] fArr, float[][] fArr2) {
        fArr2[0][0] = -fArr[1];
        fArr2[0][1] = fArr[0];
        fArr2[0][2] = fArr[2];
        fArr2[1][0] = fArr[1];
        fArr2[1][1] = -fArr[0];
        fArr2[1][2] = fArr[2];
        System.arraycopy(fArr, 0, fArr2[2], 0, 3);
        fArr2[3][0] = -fArr[0];
        fArr2[3][1] = -fArr[1];
        fArr2[3][2] = fArr[2];
        fArr2[4][0] = fArr[0];
        fArr2[4][1] = fArr[2];
        fArr2[4][2] = -fArr[1];
        fArr2[5][0] = fArr[0];
        fArr2[5][1] = -fArr[2];
        fArr2[5][2] = fArr[1];
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        float[] fArr;
        int i2;
        float[][] fArr2;
        switch (sensorEvent.sensor.getType()) {
            case 2:
                a(sensorEvent.values, this.bkQ);
                a aVar = this.bld;
                fArr = sensorEvent.values;
                if (fArr.length >= 3) {
                    aVar.ble++;
                    aVar.blf = (float) (Math.sqrt((double) (((fArr[0] * fArr[0]) + (fArr[1] * fArr[1])) + (fArr[2] * fArr[2]))) + ((double) aVar.blf));
                    return;
                }
                return;
            case 4:
                if (this.bkK[2][0] != 0.0f || this.bkK[2][1] != 0.0f || this.bkK[2][2] != 0.0f) {
                    if (this.bkG) {
                        for (i2 = 0; i2 <= 5; i2++) {
                            this.bkI[i2] = b(this.bkI[i2], this.bkH[i2]);
                        }
                        this.bkG = false;
                    }
                    fArr2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 4});
                    if (this.bkF != 0) {
                        float f = 1.0E-9f * ((float) (sensorEvent.timestamp - this.bkF));
                        a(sensorEvent.values, this.bkP);
                        for (int i3 = 0; i3 <= 5; i3++) {
                            float[] fArr3 = this.bkP[i3];
                            float[] fArr4 = fArr2[i3];
                            float f2 = f / 2.0f;
                            float[] fArr5 = new float[3];
                            float sqrt = (float) Math.sqrt((double) (((fArr3[0] * fArr3[0]) + (fArr3[1] * fArr3[1])) + (fArr3[2] * fArr3[2])));
                            if (sqrt > 1.0E-9f) {
                                fArr5[0] = fArr3[0] / sqrt;
                                fArr5[1] = fArr3[1] / sqrt;
                                fArr5[2] = fArr3[2] / sqrt;
                            }
                            float f3 = sqrt * f2;
                            f2 = (float) Math.sin((double) f3);
                            f3 = (float) Math.cos((double) f3);
                            fArr4[0] = fArr5[0] * f2;
                            fArr4[1] = fArr5[1] * f2;
                            fArr4[2] = f2 * fArr5[2];
                            fArr4[3] = f3;
                        }
                    }
                    this.bkF = sensorEvent.timestamp;
                    while (i <= 5) {
                        fArr = new float[9];
                        try {
                            SensorManager.getRotationMatrixFromVector(fArr, fArr2[i]);
                        } catch (Exception e) {
                        }
                        this.bkI[i] = b(this.bkI[i], fArr);
                        i++;
                    }
                    a(this.bkI, this.bkL);
                    return;
                }
                return;
            case 9:
                a(sensorEvent.values, this.bkR);
                if (this.bkQ[2][0] != 0.0f || this.bkQ[2][1] != 0.0f || this.bkQ[2][2] != 0.0f) {
                    fArr2 = this.bkH;
                    float[][] fArr6 = this.bkR;
                    float[][] fArr7 = this.bkQ;
                    i2 = (SensorManager.getRotationMatrix(fArr2[0], null, fArr6[0], fArr7[0]) && SensorManager.getRotationMatrix(fArr2[1], null, fArr6[1], fArr7[1]) && SensorManager.getRotationMatrix(fArr2[2], null, fArr6[2], fArr7[2]) && SensorManager.getRotationMatrix(fArr2[3], null, fArr6[3], fArr7[3]) && SensorManager.getRotationMatrix(fArr2[4], null, fArr6[4], fArr7[4]) && SensorManager.getRotationMatrix(fArr2[5], null, fArr6[5], fArr7[5])) ? 1 : 0;
                    if (i2 != 0) {
                        a(this.bkH, this.bkK);
                        if (this.bkL[2][0] == 0.0f && this.bkL[2][1] == 0.0f && this.bkL[2][2] == 0.0f) {
                            fArr6 = this.bkK;
                            float[][] fArr8 = this.bkL;
                            for (i2 = 0; i2 <= 5; i2++) {
                                System.arraycopy(fArr6[i2], 0, fArr8[i2], 0, 3);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 10:
                fArr = new float[16];
                float[] fArr9 = (this.bkE != null ? this.bkJ : this.bkI)[2];
                float[] fArr10 = new float[16];
                if (fArr9.length == 9) {
                    fArr10[0] = fArr9[0];
                    fArr10[1] = fArr9[1];
                    fArr10[2] = fArr9[2];
                    fArr10[3] = 0.0f;
                    fArr10[4] = fArr9[3];
                    fArr10[5] = fArr9[4];
                    fArr10[6] = fArr9[5];
                    fArr10[7] = 0.0f;
                    fArr10[8] = fArr9[6];
                    fArr10[9] = fArr9[7];
                    fArr10[10] = fArr9[8];
                    fArr10[11] = 0.0f;
                    fArr10[12] = 0.0f;
                    fArr10[13] = 0.0f;
                    fArr10[14] = 0.0f;
                    fArr10[15] = 1.0f;
                }
                Matrix.invertM(fArr, 0, fArr10, 0);
                Matrix.multiplyMV(this.bkO, 0, fArr, 0, new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2], 0.0f}, 0);
                this.blb.a(this.bkO, sensorEvent.values, this.bkR[2]);
                return;
            case 11:
                try {
                    SensorManager.getRotationMatrixFromVector(this.bkJ[2], sensorEvent.values);
                } catch (IllegalArgumentException e2) {
                    if (sensorEvent.values.length > 3) {
                        SensorManager.getRotationMatrixFromVector(this.bkJ[2], new float[]{sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]});
                    }
                }
                SensorManager.remapCoordinateSystem(this.bkJ[2], 2, 129, this.bkJ[0]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 130, 1, this.bkJ[1]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 129, 130, this.bkJ[3]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 129, 3, this.bkJ[4]);
                SensorManager.remapCoordinateSystem(this.bkJ[2], 1, 3, this.bkJ[5]);
                while (i <= 5) {
                    SensorManager.getOrientation(this.bkJ[i], this.bkN[i]);
                    i++;
                }
                return;
            default:
                return;
        }
    }
}
