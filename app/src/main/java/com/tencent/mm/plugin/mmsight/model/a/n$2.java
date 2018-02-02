package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.b.1;
import com.tencent.mm.plugin.mmsight.model.a.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class n$2 extends af {
    final /* synthetic */ n ovP;

    n$2(n nVar, Looper looper) {
        this.ovP = nVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                n nVar = this.ovP;
                if (nVar.ovG != null) {
                    int i;
                    boolean z;
                    int i2;
                    int i3;
                    int i4;
                    boolean z2;
                    boolean z3;
                    b bVar;
                    a aVar;
                    Looper looper;
                    a aVar2;
                    Object obj;
                    nVar.ovL.dN(1);
                    long Wq = bh.Wq();
                    r rVar = nVar.ovG;
                    int i5 = nVar.ova;
                    int i6 = nVar.ovb;
                    bh.Wq();
                    int i7 = rVar.ovW;
                    boolean z4 = rVar.oth;
                    if (z4) {
                        i = rVar.ovX == -1 ? rVar.ovW : rVar.ovX;
                    } else if (rVar.ovX == -1 || rVar.ovX == rVar.ovW) {
                        z = false;
                        i2 = (rVar.ovX != -1 || rVar.ovX == rVar.ovW) ? rVar.ovW : rVar.ovX;
                        i3 = (i2 != 0 || i2 == 180) ? i5 : i6;
                        i4 = (i2 != 0 || i2 == 180) ? i6 : i5;
                        z2 = i3 == rVar.nUr || i4 != rVar.mvv;
                        z3 = (rVar.ovY != -1 || rVar.ovZ == -1 || (rVar.ovY == rVar.nUr && rVar.ovZ == rVar.mvv)) ? z2 : true;
                        x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(rVar.oth), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                        bVar = new b(i3, i4, rVar.otT, rVar.nUr, rVar.mvv, z3, z, i7, bArr);
                        aVar = rVar.owa;
                        if (!aVar.otH) {
                            if (aVar.handler == null) {
                                aVar.handler = new af(Looper.myLooper());
                            }
                            i4 = aVar.otD % a.otB;
                            if (aVar.otC[i4] != null) {
                                i5 = aVar.otD;
                                looper = aVar.otC[i4].getLooper();
                                aVar2 = aVar.otI;
                                bVar.otP = i5;
                                bVar.otU = i4;
                                bVar.otQ = bh.Wq();
                                x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.otM.length), Integer.valueOf(bVar.otP)});
                                new af(looper).post(new 1(bVar, aVar2));
                                aVar.otD++;
                            }
                        }
                        x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
                        if (!nVar.ovj && nVar.ovq) {
                            nVar.ovj = true;
                            obj = new byte[bArr.length];
                            System.arraycopy(bArr, 0, obj, 0, bArr.length);
                            e.post(new n$9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                        }
                        nVar.ovm = true;
                    } else {
                        z4 = true;
                        i = rVar.ovX;
                        i7 = Math.max(0, rVar.ovW <= 180 ? i - rVar.ovW : i + (360 - rVar.ovW));
                        if (i7 >= 360) {
                            i = 0;
                        } else {
                            z = true;
                            if (rVar.ovX != -1) {
                            }
                            if (i2 != 0) {
                            }
                            if (i2 != 0) {
                            }
                            if (i3 == rVar.nUr) {
                            }
                            if (rVar.ovY != -1) {
                            }
                            x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(rVar.oth), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                            bVar = new b(i3, i4, rVar.otT, rVar.nUr, rVar.mvv, z3, z, i7, bArr);
                            aVar = rVar.owa;
                            if (aVar.otH) {
                                if (aVar.handler == null) {
                                    aVar.handler = new af(Looper.myLooper());
                                }
                                i4 = aVar.otD % a.otB;
                                if (aVar.otC[i4] != null) {
                                    i5 = aVar.otD;
                                    looper = aVar.otC[i4].getLooper();
                                    aVar2 = aVar.otI;
                                    bVar.otP = i5;
                                    bVar.otU = i4;
                                    bVar.otQ = bh.Wq();
                                    x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.otM.length), Integer.valueOf(bVar.otP)});
                                    new af(looper).post(new 1(bVar, aVar2));
                                    aVar.otD++;
                                }
                            }
                            x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
                            nVar.ovj = true;
                            obj = new byte[bArr.length];
                            System.arraycopy(bArr, 0, obj, 0, bArr.length);
                            e.post(new n$9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                            nVar.ovm = true;
                        }
                    }
                    z = z4;
                    i7 = i;
                    if (rVar.ovX != -1) {
                    }
                    if (i2 != 0) {
                    }
                    if (i2 != 0) {
                    }
                    if (i3 == rVar.nUr) {
                    }
                    if (rVar.ovY != -1) {
                    }
                    x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(rVar.oth), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                    bVar = new b(i3, i4, rVar.otT, rVar.nUr, rVar.mvv, z3, z, i7, bArr);
                    aVar = rVar.owa;
                    if (aVar.otH) {
                        if (aVar.handler == null) {
                            aVar.handler = new af(Looper.myLooper());
                        }
                        i4 = aVar.otD % a.otB;
                        if (aVar.otC[i4] != null) {
                            i5 = aVar.otD;
                            looper = aVar.otC[i4].getLooper();
                            aVar2 = aVar.otI;
                            bVar.otP = i5;
                            bVar.otU = i4;
                            bVar.otQ = bh.Wq();
                            x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.otM.length), Integer.valueOf(bVar.otP)});
                            new af(looper).post(new 1(bVar, aVar2));
                            aVar.otD++;
                        }
                    }
                    x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
                    nVar.ovj = true;
                    obj = new byte[bArr.length];
                    System.arraycopy(bArr, 0, obj, 0, bArr.length);
                    e.post(new n$9(nVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                    nVar.ovm = true;
                }
            }
        }
    }
}
