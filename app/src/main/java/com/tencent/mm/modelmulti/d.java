package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.protocal.w;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map;

public final class d extends k implements com.tencent.mm.network.k {
    protected static int cLl = 7;
    private int errCode;
    private int errType;
    private String fnL;
    private e gJT;
    private int hEY;
    private a hEZ;
    private StringBuilder hFa;
    private long hFb;
    private boolean hFc;
    private ak hkO;

    public d() {
        this.errType = 0;
        this.errCode = 0;
        this.fnL = "";
        this.hEY = 0;
        this.hFa = new StringBuilder();
        this.hFb = -1;
        this.hFc = false;
        x.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
        this.hEZ = new a();
        this.hFa.append("stack:" + bh.cgy() + " time:" + bh.Wo());
    }

    public d(b bVar, int i, long j) {
        this();
        this.hEY = i;
        this.hFb = j;
        x.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.hkO = new ak(aa.VT(), new 1(this, bVar), false);
    }

    public final String getInfo() {
        return this.hFa.toString();
    }

    protected final int Bh() {
        return 500;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    public final boolean Ke() {
        return super.Ke();
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.gJT = eVar2;
        this.hFa.append(" lastd:" + this.hmB + " dotime:" + bh.Wo() + " net:" + an.getNetType(ac.getContext()));
        String str = "MicroMsg.NetPushSync";
        String str2 = "doScene[%d] selector:%d pusher:%b ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(cLl);
        if (this.hkO != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.hkO != null) {
            c(eVar);
            this.hkO.J(0, 0);
            this.hkO = null;
            return -1;
        }
        q aVar = new a();
        aVar.uin = aa.VQ().hZK.Cg();
        ati com_tencent_mm_protocal_c_ati = ((w.a) aVar.Kb()).vBQ;
        com_tencent_mm_protocal_c_ati.vRz = cLl;
        com_tencent_mm_protocal_c_ati.vRA = n.N(bh.VD(ac.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", "")));
        com_tencent_mm_protocal_c_ati.rYW = 1;
        com_tencent_mm_protocal_c_ati.wBu = new om();
        com_tencent_mm_protocal_c_ati.vJA = com.tencent.mm.protocal.d.DEVICE_TYPE;
        return a(eVar, aVar, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            String str2 = "MicroMsg.NetPushSync";
            String str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            x.e(str2, str3, objArr);
            return;
        }
        Object obj;
        this.hFa.append(" endtime:" + bh.Wo());
        x.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.hFc), Long.valueOf(this.hEZ.zi()), this.hFa});
        if (i2 == 4 && i3 == -2006) {
            i2 = 0;
            i3 = 0;
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 == 0 && i3 == 0) {
            String str4;
            String str5;
            byte[] VD;
            int size;
            int i5;
            b bVar = (b) qVar.Hp();
            if (obj == null) {
                byte[] a = n.a(((w.a) qVar.Kb()).vBQ.vRA);
                str4 = "MicroMsg.NetPushSync";
                str5 = "dkpush req Key : %d[%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(a == null ? -1 : a.length);
                objArr2[1] = bh.bv(a);
                x.d(str4, str5, objArr2);
                if (bh.bw(a)) {
                    VD = bh.VD(ac.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                    x.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[]{Integer.valueOf(VD.length), bh.bv(VD)});
                } else {
                    VD = a;
                }
                a = n.a(bVar.vBR.vRA);
                VD = ad.g(VD, a);
                if (VD == null || VD.length <= 0) {
                    x.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
                    VD = a;
                }
                bVar.vBR.vRA = n.N(VD);
                size = (bVar.vBR.vRD == null || bVar.vBR.vRD.ksP == null) ? 0 : bVar.vBR.vRD.ksP.size();
                x.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[]{Integer.valueOf(size)});
                str4 = "MicroMsg.NetPushSync";
                str5 = "newMsgSize:%d, mergeKey: %d[%s]";
                objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(size);
                objArr2[1] = Integer.valueOf(VD == null ? -1 : VD.length);
                objArr2[2] = bh.bv(VD);
                x.d(str4, str5, objArr2);
            }
            Iterator it = bVar.vBR.vRD.ksP.iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                ol olVar = (ol) it.next();
                if (olVar.vXp == 5) {
                    VD = n.a(olVar.vXq);
                    try {
                        bw bwVar = new bw();
                        bwVar.aF(VD);
                        str3 = "MicroMsg.NetPushSync";
                        str4 = "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d";
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = Integer.valueOf(bwVar.ngq);
                        objArr3[1] = bwVar.vGX.wJF;
                        objArr3[2] = Long.valueOf(bwVar.vHe);
                        objArr3[3] = Integer.valueOf(bwVar.vHd == null ? 0 : bwVar.vHd.length());
                        objArr3[4] = Integer.valueOf(bwVar.vGZ.wJF == null ? 0 : bwVar.vGZ.wJF.length());
                        x.i(str3, str4, objArr3);
                        i5 = bwVar.ngq;
                        str3 = bwVar.vGX.wJF;
                        str4 = bwVar.vGZ.wJF;
                        if (i5 == 50) {
                            x.i("MicroMsg.NetPushSync", "hit voip");
                            obj = 1;
                        } else {
                            if (bh.ov(str4) || bh.ov(str3)) {
                                x.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
                            } else if (i5 == 9998 && str3.equalsIgnoreCase("weixin")) {
                                x.i("MicroMsg.NetPushSync", "hit ipxx");
                                obj = 1;
                            } else if (i5 == 10002 && str4.contains("revokemsg")) {
                                x.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                obj = 1;
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                        } else {
                            long j = bwVar.vHe;
                            str5 = bwVar.vGX.wJF;
                            str2 = bwVar.vHd;
                            int i6 = bwVar.ngq;
                            if (bh.ov(str2)) {
                                x.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
                            } else {
                                PString pString = new PString();
                                PString pString2 = new PString();
                                str2 = bh.VH(str2);
                                int indexOf = str2.indexOf("<pushcontent");
                                if (indexOf > 0) {
                                    str2 = str2.substring(indexOf);
                                }
                                Map y = bi.y(str2, "pushcontent");
                                if (y == null) {
                                    x.e("MicroMsg.NetPushSync", "inval xml");
                                } else {
                                    pString.value = (String) y.get(".pushcontent.$content");
                                    pString2.value = (String) y.get(".pushcontent.$nickname");
                                }
                                PluginZero pluginZero = (PluginZero) g.k(PluginZero.class);
                                if (pluginZero.vaF != null) {
                                    pluginZero.vaF.a(j, str5, pString2.value, pString.value, (com.tencent.mm.compatible.util.e.bnF + com.tencent.mm.a.g.s(("mm" + aa.VQ().hZK.Cg()).getBytes())) + "/avatar/", i6);
                                }
                            }
                            if ((bwVar.ngq == 10002 ? 1 : null) != null) {
                                x.i("MicroMsg.NetPushSync", "need remove pushContent");
                                bwVar.vHd = null;
                                olVar.vXq = n.N(bwVar.toByteArray());
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.NetPushSync", e, "", new Object[0]);
                    }
                }
            }
            try {
                VD = bVar.vBR.toByteArray();
                size = aa.VQ().hZK.Cg();
                str4 = f.fj(size);
                int eh = f.eh(str4) + 1;
                String str6 = str4 + "/syncResp.bin" + eh;
                byte[] b = com.tencent.mm.a.k.b(VD, com.tencent.mm.a.g.s((com.tencent.mm.compatible.d.q.yE() + size).getBytes()).getBytes());
                x.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[]{Integer.valueOf(eh), Integer.valueOf(VD.length), Integer.valueOf(b.length), str6, f.B(VD), f.B(b), f.B(str3.getBytes())});
                if (bh.bw(b)) {
                    x.e("MicroMsg.NotifySyncMgr", "encry failed");
                } else {
                    i5 = com.tencent.mm.a.e.b(str6, b, b.length);
                    boolean bO = com.tencent.mm.a.e.bO(str6);
                    if (i5 == 0 && bO) {
                        VD = String.valueOf(eh).getBytes();
                        com.tencent.mm.a.e.b(str4 + "/syncResp.ini", VD, VD.length);
                    } else {
                        x.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[]{Integer.valueOf(i5), Boolean.valueOf(bO)});
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[]{e2});
                x.printErrStackTrace("MicroMsg.NetPushSync", e2, "", new Object[0]);
            }
            x.d("MicroMsg.NetPushSync", "onRespHandled sync");
            ac.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bh.by(n.a(bVar.vBR.vRA))).commit();
            x.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[]{Integer.valueOf(this.hEY)});
            if (obj2 == null) {
                obj = ((bVar.vBR.vPq & cLl) == 0 || super.Ke()) ? null : 1;
                x.i("MicroMsg.NetPushSync", "continue flag=" + bVar.vBR.vPq + ", selector=" + cLl + ", limit reach=" + super.Ke());
                if (obj != null) {
                    a(this.hmA, this.gJT);
                    if (obj2 != null) {
                        CoreService.wC();
                        return;
                    }
                    return;
                }
            }
            if ((this.hEY & 1) > 0) {
                x.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
                new h(this.hFb, n.a(bVar.vBR.vRA), aa.VQ().hZK.Cg()).a(aa.VQ(), new 2(this));
            }
            this.gJT.a(this.errType, this.errCode, this.fnL, this);
            if (obj2 != null) {
                CoreService.wC();
                return;
            }
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
