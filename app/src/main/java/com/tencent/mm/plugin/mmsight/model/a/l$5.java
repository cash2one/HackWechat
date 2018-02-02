package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class l$5 extends af {
    final /* synthetic */ l ovs;

    l$5(l lVar, Looper looper) {
        this.ovs = lVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.ovs.ovg == -1) {
            this.ovs.ovg = Process.myTid();
            x.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[]{Integer.valueOf(this.ovs.ovg)});
        }
        if (message.what == 1) {
            int length;
            int i;
            int i2;
            p pVar;
            byte[] bArr;
            this.ovs.ouP.bar();
            l lVar = this.ovs;
            byte[] bArr2 = (byte[]) message.obj;
            p pVar2;
            if (lVar.oth) {
                pVar2 = lVar.ouQ;
                length = bArr2.length;
                int i3 = lVar.ova;
                i = lVar.ovb;
                i2 = i3;
                pVar = pVar2;
                bArr = bArr2;
            } else {
                pVar2 = lVar.ouQ;
                length = bArr2.length;
                i = (lVar.ovc == 0 || lVar.ovc == 180) ? lVar.ova : lVar.ovb;
                if (lVar.ovc == 0 || lVar.ovc == 180) {
                    i2 = i;
                    pVar = pVar2;
                    i = lVar.ovb;
                    bArr = bArr2;
                } else {
                    i2 = i;
                    pVar = pVar2;
                    i = lVar.ova;
                    bArr = bArr2;
                }
            }
            pVar.otQ = bh.Wq();
            if (pVar.ovV < 0) {
                x.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
            } else {
                boolean z;
                int i4;
                int i5;
                int i6;
                boolean z2;
                synchronized (p.class) {
                    pVar.frameCount++;
                }
                int i7 = pVar.ovW;
                boolean z3 = pVar.oth;
                if (z3) {
                    i7 = pVar.ovX == -1 ? pVar.ovW : pVar.ovX;
                } else if (pVar.ovX == -1 || pVar.ovX == pVar.ovW) {
                    z = false;
                    i4 = i7;
                    SightVideoJNI.setRotateForBufId(pVar.ovV, i4);
                    i7 = z ? (i4 != 0 || i4 == 180) ? pVar.nUr : pVar.mvv : (i4 != 0 || i4 == 180) ? pVar.mvv : pVar.nUr;
                    i5 = z ? (i4 != 0 || i4 == 180) ? pVar.mvv : pVar.nUr : (i4 != 0 || i4 == 180) ? pVar.nUr : pVar.mvv;
                    i6 = z ? (i4 != 0 || i4 == 180) ? i2 : i : (i4 != 0 || i4 == 180) ? i : i2;
                    i4 = z ? (i4 != 0 || i4 == 180) ? i : i2 : (i4 != 0 || i4 == 180) ? i2 : i;
                    z2 = i6 == i7 || i4 != i5;
                    SightVideoJNI.writeYuvDataForMMSight(pVar.ovV, bArr, length, i7, i5, z, z2, i6, i4);
                    x.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bh.bA(pVar.otQ))});
                } else {
                    z3 = true;
                    i7 = pVar.ovX;
                    i7 = Math.max(0, pVar.ovW <= 180 ? i7 - pVar.ovW : i7 + (360 - pVar.ovW));
                    if (i7 >= 360) {
                        i7 = 0;
                    } else {
                        z = true;
                        i4 = i7;
                        SightVideoJNI.setRotateForBufId(pVar.ovV, i4);
                        if (z) {
                            if (i4 != 0) {
                            }
                        }
                        if (z) {
                            if (i4 != 0) {
                            }
                        }
                        if (z) {
                            if (i4 != 0) {
                            }
                        }
                        if (z) {
                            if (i4 != 0) {
                            }
                        }
                        if (i6 == i7) {
                        }
                        SightVideoJNI.writeYuvDataForMMSight(pVar.ovV, bArr, length, i7, i5, z, z2, i6, i4);
                        x.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bh.bA(pVar.otQ))});
                    }
                }
                z = z3;
                i4 = i7;
                SightVideoJNI.setRotateForBufId(pVar.ovV, i4);
                if (z) {
                    if (i4 != 0) {
                    }
                }
                if (z) {
                    if (i4 != 0) {
                    }
                }
                if (z) {
                    if (i4 != 0) {
                    }
                }
                if (z) {
                    if (i4 != 0) {
                    }
                }
                if (i6 == i7) {
                }
                SightVideoJNI.writeYuvDataForMMSight(pVar.ovV, bArr, length, i7, i5, z, z2, i6, i4);
                x.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(bh.bA(pVar.otQ))});
            }
            j.ouM.D(bArr2);
            lVar.ovm = true;
        }
    }
}
