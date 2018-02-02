package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static a gLc = null;

    public interface a {
        void a(int i, int i2, int i3, int i4, long j, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10, int i11, long j2, int[] iArr2, int[] iArr3);

        void a(int i, long j, int i2, int i3, int i4);

        void reportIDKey(boolean z, int i, int i2, boolean z2);
    }

    public static void a(a aVar) {
        int i;
        int i2 = (int) (aVar.gKD - aVar.gKn);
        int i3 = HardCoderJNI.isHCEnable() ? 1 : 0;
        int i4 = i2 - aVar.delay <= 0 ? 1 : 0;
        int i5 = aVar.scene;
        long j = aVar.gKm;
        int i6 = aVar.gKj;
        int i7 = aVar.gKk;
        int[] iArr = aVar.gKu;
        int i8 = (int) (aVar.gKo - aVar.startTime);
        int i9 = aVar.gKy;
        int i10 = 0;
        if (aVar.gKA != null) {
            i10 = (int) (0 + aVar.gKA.gLj);
        }
        if (aVar.gKB != null) {
            i = (int) (((long) i10) + aVar.gKB.gLj);
        } else {
            i = i10;
        }
        int i11 = HardCoderJNI.TICK_RATE;
        long j2 = aVar.gKz;
        int[] iArr2 = aVar.gKs;
        int[] iArr3 = aVar.gKt;
        StringBuilder stringBuilder = new StringBuilder();
        if (iArr != null) {
            for (int i12 : iArr) {
                stringBuilder.append(i12 + "#");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (iArr2 != null) {
            for (int i13 : iArr2) {
                stringBuilder2.append(i13 + "#");
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        if (iArr3 != null) {
            for (int i14 : iArr3) {
                stringBuilder3.append(i14 + "#");
            }
        }
        if (aVar.gKl != 0 && HardCoderJNI.hcDebug) {
            x.i("MicroMsg.HardCoderReporter", "[oneliang]performance report,hash:%s,threadId:%s,speedUp:%s,cancelInDelay:%s,scene:%s,action:%s,lastCpuLevel:%s,cpuLevel:%s,lastIoLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", Integer.valueOf(aVar.hashCode()), Integer.valueOf(aVar.gKl), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j), Integer.valueOf(aVar.gKq), Integer.valueOf(i6), Integer.valueOf(aVar.gKr), Integer.valueOf(i7), stringBuilder.toString(), Integer.valueOf(i8), Integer.valueOf(i2), Integer.valueOf(i9), Integer.valueOf(i), Integer.valueOf(i11), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder3.toString());
        }
        if (gLc != null) {
            gLc.a(aVar.gKl, i3, i4, i5, j, i6, i7, iArr, i8, i2, i9, i, i11, j2, iArr2, iArr3);
        }
    }

    public static void a(int i, long j, int i2, int i3, int i4) {
        if (gLc != null) {
            gLc.a(i, j, i2, i3, i4);
        }
    }

    public static void reportIDKey(boolean z, int i, int i2, boolean z2) {
        if (gLc != null) {
            gLc.reportIDKey(z, i, i2, z2);
        }
    }

    public static void a(a aVar) {
        if (gLc == null) {
            x.i("MicroMsg.HardCoderReporter", "hardcoder setReporter[%s], stack[%s]", aVar, bh.cgy());
            gLc = aVar;
        }
    }
}
