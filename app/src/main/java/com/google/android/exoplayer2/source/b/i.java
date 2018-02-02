package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.b;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.k$a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.a.a.5;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

final class i implements com.google.android.exoplayer2.source.i {
    public final int atY;
    private final j atZ;

    public i(j jVar, int i) {
        this.atZ = jVar;
        this.atY = i;
    }

    public final boolean is() {
        j jVar = this.atZ;
        return jVar.auv || (!jVar.kE() && jVar.auh[this.atY].asl.kg());
    }

    public final void kc() {
        this.atZ.kc();
    }

    public final int b(k kVar, e eVar, boolean z) {
        j jVar = this.atZ;
        int i = this.atY;
        if (jVar.kE()) {
            return -3;
        }
        int i2;
        int i3;
        Object obj;
        int i4;
        if (!jVar.auf.isEmpty()) {
            while (jVar.auf.size() > 1) {
                i2 = ((f) jVar.auf.getFirst()).uid;
                for (i3 = 0; i3 < jVar.auh.length; i3++) {
                    if (jVar.aup[i3]) {
                        g gVar = jVar.auh[i3].asl;
                        if ((gVar.kg() ? gVar.arW[gVar.cD(gVar.asc)] : gVar.asi) == i2) {
                            obj = null;
                            break;
                        }
                    }
                }
                obj = 1;
                if (obj == null) {
                    break;
                }
                jVar.auf.removeFirst();
            }
            f fVar = (f) jVar.auf.getFirst();
            Format format = fVar.asI;
            if (!format.equals(jVar.aul)) {
                a aVar = jVar.atO;
                i2 = jVar.ach;
                i4 = fVar.asJ;
                Object obj2 = fVar.asK;
                long j = fVar.asL;
                if (aVar.ars != null) {
                    aVar.handler.post(new 5(aVar, i2, format, i4, obj2, j));
                }
            }
            jVar.aul = format;
        }
        h hVar = jVar.auh[i];
        boolean z2 = jVar.auv;
        long j2 = jVar.aur;
        switch (hVar.asl.a(kVar, eVar, z, z2, hVar.asq, hVar.asm)) {
            case -5:
                hVar.asq = kVar.aeo;
                return -5;
            case -4:
                if (!eVar.iY()) {
                    long j3;
                    if (eVar.aig < j2) {
                        eVar.ca(Integer.MIN_VALUE);
                    }
                    if (eVar.jd()) {
                        g.a aVar2 = hVar.asm;
                        j3 = aVar2.oJ;
                        hVar.aiY.reset(1);
                        hVar.a(j3, hVar.aiY.data, 1);
                        long j4 = 1 + j3;
                        byte b = hVar.aiY.data[0];
                        obj = (b & FileUtils.S_IWUSR) != 0 ? 1 : null;
                        int i5 = b & 127;
                        if (eVar.aie.iv == null) {
                            eVar.aie.iv = new byte[16];
                        }
                        hVar.a(j4, eVar.aie.iv, i5);
                        j4 += (long) i5;
                        if (obj != null) {
                            hVar.aiY.reset(2);
                            hVar.a(j4, hVar.aiY.data, 2);
                            j4 += 2;
                            i5 = hVar.aiY.readUnsignedShort();
                        } else {
                            i5 = 1;
                        }
                        int[] iArr = eVar.aie.numBytesOfClearData;
                        if (iArr == null || iArr.length < i5) {
                            iArr = new int[i5];
                        }
                        int[] iArr2 = eVar.aie.numBytesOfEncryptedData;
                        if (iArr2 == null || iArr2.length < i5) {
                            iArr2 = new int[i5];
                        }
                        if (obj != null) {
                            i3 = i5 * 6;
                            hVar.aiY.reset(i3);
                            hVar.a(j4, hVar.aiY.data, i3);
                            j4 += (long) i3;
                            hVar.aiY.cR(0);
                            for (i3 = 0; i3 < i5; i3++) {
                                iArr[i3] = hVar.aiY.readUnsignedShort();
                                iArr2[i3] = hVar.aiY.lI();
                            }
                        } else {
                            iArr[0] = 0;
                            iArr2[0] = aVar2.size - ((int) (j4 - aVar2.oJ));
                        }
                        k$a com_google_android_exoplayer2_c_k_a = aVar2.amk;
                        b bVar = eVar.aie;
                        byte[] bArr = com_google_android_exoplayer2_c_k_a.aiR;
                        byte[] bArr2 = eVar.aie.iv;
                        int i6 = com_google_android_exoplayer2_c_k_a.aiQ;
                        int i7 = com_google_android_exoplayer2_c_k_a.ahS;
                        i3 = com_google_android_exoplayer2_c_k_a.ahT;
                        bVar.numSubSamples = i5;
                        bVar.numBytesOfClearData = iArr;
                        bVar.numBytesOfEncryptedData = iArr2;
                        bVar.key = bArr;
                        bVar.iv = bArr2;
                        bVar.mode = i6;
                        bVar.ahS = i7;
                        bVar.ahT = i3;
                        if (t.SDK_INT >= 16) {
                            bVar.ahU.numSubSamples = bVar.numSubSamples;
                            bVar.ahU.numBytesOfClearData = bVar.numBytesOfClearData;
                            bVar.ahU.numBytesOfEncryptedData = bVar.numBytesOfEncryptedData;
                            bVar.ahU.key = bVar.key;
                            bVar.ahU.iv = bVar.iv;
                            bVar.ahU.mode = bVar.mode;
                            if (t.SDK_INT >= 24) {
                                b.a aVar3 = bVar.ahV;
                                aVar3.ahW.set(bVar.ahS, bVar.ahT);
                                aVar3.ahU.setPattern(aVar3.ahW);
                            }
                        }
                        i3 = (int) (j4 - aVar2.oJ);
                        aVar2.oJ += (long) i3;
                        aVar2.size -= i3;
                    }
                    eVar.cc(hVar.asm.size);
                    j3 = hVar.asm.oJ;
                    ByteBuffer byteBuffer = eVar.aif;
                    i2 = hVar.asm.size;
                    hVar.G(j3);
                    while (i2 > 0) {
                        i4 = Math.min(i2, (int) (hVar.aso.alc - j3));
                        byteBuffer.put(hVar.aso.asy.data, hVar.aso.I(j3), i4);
                        i2 -= i4;
                        j3 += (long) i4;
                        if (j3 == hVar.aso.alc) {
                            hVar.aso = hVar.aso.asz;
                        }
                    }
                }
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    public final void D(long j) {
        j jVar = this.atZ;
        h hVar = jVar.auh[this.atY];
        if (!jVar.auv || j <= hVar.asl.ki()) {
            hVar.d(j, true);
        } else {
            hVar.asl.kj();
        }
    }
}
