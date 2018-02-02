package com.tencent.mm.ae;

import android.os.Looper;
import com.tencent.mm.network.j;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.as;

public final class s extends a {
    af handler;
    g hnC;
    h hnD;
    private q hnp;

    public s(q qVar) {
        this(qVar, Looper.myLooper() == null ? new af(Looper.getMainLooper()) : new af());
    }

    public s(q qVar, af afVar) {
        this.hnp = qVar;
        this.hnC = new r(qVar.Kb(), qVar.getType());
        this.hnD = new t(qVar.Hp(), qVar.getType());
        this.handler = afVar;
    }

    public final boolean Kc() {
        return this.hnp.Kc();
    }

    public final int Kh() {
        return this.hnp.hashCode();
    }

    public final int JY() {
        return this.hnp.JY();
    }

    public final g KI() {
        return this.hnC;
    }

    public final h KJ() {
        return this.hnD;
    }

    public final int getType() {
        return this.hnp.getType();
    }

    public final String getUri() {
        return this.hnp.getUri();
    }

    public final void ju(String str) {
    }

    public final void a(j jVar, final int i, final int i2, final String str) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s hnE;

            public final void run() {
                x.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(this.hnE.hnp.getType()), bh.cgy());
                f fVar = (f) this.hnE.hnp.Kb();
                i.g gVar = (i.g) this.hnE.hnp.Hp();
                if (gVar == null) {
                    x.f("MicroMsg.RemoteReqResp", "null auth.resp");
                } else {
                    c.a.vAV.a(fVar, gVar, i, i2, str);
                }
            }
        });
    }

    public final void a(final j jVar, final int i, final int i2) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s hnE;

            public final void run() {
                int i;
                int i2 = as.Hn().getInt("key_auth_update_version", 0);
                int i3 = i2 <= 637665332 ? 701 : 702;
                if (i2 == 0) {
                    if (bh.ov(ac.getContext().getSharedPreferences("ticket_prefs", 4).getString("_auth_ticket", ""))) {
                        x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
                        d.pPH.a(148, 50, 1, true);
                        i3 = 702;
                    } else {
                        d.pPH.a(148, 49, 1, true);
                        x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", bh.VT(r13.getString("_auth_ticket", "")));
                    }
                }
                x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.vAz), Integer.valueOf(637665332), Integer.valueOf(i3));
                if (i3 == 701) {
                    d.pPH.a(148, 48, 1, true);
                }
                if ((this.hnE.hnp.getType() == 702 || this.hnE.hnp.getType() == 701) && ((i.g) this.hnE.hnp.Hp()).vBb == 2) {
                    i = 1;
                } else {
                    i = 0;
                }
                x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(this.hnE.hnp.getType()), Integer.valueOf(i3), Integer.valueOf(i));
                q aW = c.a.vAV.aW(i3, i);
                try {
                    jVar.a(aW == null ? null : new s(aW, this.hnE.handler), i, i2, "");
                } catch (Throwable e) {
                    x.e("MicroMsg.RemoteReqResp", "exception:%s", bh.i(e));
                }
            }
        });
    }

    public final void a(com.tencent.mm.network.d dVar, final j jVar, final int i, final int i2) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s hnE;

            public final void run() {
                try {
                    jVar.a(new s(new j(), this.hnE.handler), i, i2, "");
                } catch (Throwable e) {
                    x.e("MicroMsg.RemoteReqResp", "exception:%s", bh.i(e));
                }
            }
        });
    }

    public final int KK() {
        int i = -1;
        x.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(getType()));
        switch (getType()) {
            case 126:
                q qVar = this.hnp;
                y.a aVar = (y.a) qVar.Kb();
                b bVar = (b) qVar.Hp();
                x.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(126), bh.cgy());
                if (bVar.vBb != 0) {
                    x.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(bVar.vBb));
                } else {
                    bfl com_tencent_mm_protocal_c_bfl = bVar.vBT.wBn;
                    if (com_tencent_mm_protocal_c_bfl != null) {
                        int i2 = com_tencent_mm_protocal_c_bfl.vJo;
                        rt rtVar = com_tencent_mm_protocal_c_bfl.vIY;
                        byte[] a = n.a(com_tencent_mm_protocal_c_bfl.vIZ);
                        String str = "MicroMsg.MMReqRespReg2";
                        String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(rtVar.vJC.wJB);
                        objArr[1] = Integer.valueOf(rtVar.vZG);
                        objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
                        objArr[3] = bh.VT(bh.bv(a));
                        x.d(str, str2, objArr);
                        byte[] a2 = n.a(rtVar.vJC);
                        byte[] bArr = aVar.vAY;
                        byte[] bArr2 = null;
                        if (bh.bw(a2)) {
                            x.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        } else {
                            String str3 = "MicroMsg.MMReqRespReg2";
                            String str4 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a2.length);
                            objArr2[1] = bh.VT(bh.bv(a2));
                            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr2[3] = bh.VT(bh.bv(bArr));
                            x.d(str3, str4, objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(rtVar.vZG, a2, bArr, pByteArray, 0);
                            bArr2 = pByteArray.value;
                            str = "MicroMsg.MMReqRespReg2";
                            str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                            objArr[1] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr[2] = bh.VT(bh.bv(bArr2));
                            x.i(str, str2, objArr);
                        }
                        bVar.vBa = bArr2 != null ? bArr2 : new byte[0];
                        if ((i2 & 4) != 0) {
                            x.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (bh.bw(bArr2)) {
                                x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                bVar.be(new byte[0]);
                                bVar.vBb = 2;
                            } else {
                                bArr2 = MMProtocalJni.aesDecrypt(a, bArr2);
                                String str5 = "MicroMsg.MMReqRespReg2";
                                String str6 = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                                Object[] objArr3 = new Object[4];
                                objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                                objArr3[1] = bh.bv(a);
                                if (bArr2 != null) {
                                    i = bArr2.length;
                                }
                                objArr3[2] = Integer.valueOf(i);
                                objArr3[3] = bh.VT(bh.bv(bArr2));
                                x.d(str5, str6, objArr3);
                                if (bh.bw(bArr2)) {
                                    x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    bVar.be(new byte[0]);
                                    bVar.vBb = 2;
                                } else {
                                    x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", bh.VT(bh.bv(bArr2)));
                                    bVar.be(bArr2);
                                    bVar.vBb = 1;
                                }
                            }
                        } else {
                            x.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            bVar.be(a);
                            bVar.vBb = 1;
                        }
                    } else {
                        x.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        bVar.be(new byte[0]);
                        bVar.vBb = 2;
                    }
                }
                return bVar.vBb;
            case 701:
            case 702:
                return as.b(this.hnp);
            default:
                return -1;
        }
    }
}
