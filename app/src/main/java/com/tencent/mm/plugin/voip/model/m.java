package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.bq.b;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.model.i.a;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bmy;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.bue;
import com.tencent.mm.protocal.c.buf;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.bve;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static final f<Integer, a> hdO = new f(5);
    public boolean fju;
    public ak oGv;
    private n pUH;
    public n smS;
    public j smT;
    public boolean smU;
    public boolean smV;
    private long smW;
    public Map<Integer, Long> smX;
    public int smY;
    public long smZ;
    public String smq;
    public long sna;
    public Point snb;
    public boolean snc;
    public boolean snd;
    public boolean sne;
    public buj snf;
    public long sng;
    List<a> snh;
    public String talker;

    public m() {
        this.fju = false;
        this.smU = false;
        this.smV = false;
        this.talker = null;
        this.smW = 0;
        this.smX = new HashMap();
        this.smY = -1;
        this.smZ = 0;
        this.sna = 0;
        this.snc = false;
        this.snd = false;
        this.sne = false;
        this.snf = null;
        this.sng = 0;
        this.smq = null;
        this.pUH = new n.a(this) {
            final /* synthetic */ m sni;

            {
                this.sni = r1;
            }

            public final void eq(int i) {
                x.d("MicroMsg.Voip.VoipService", "network status change from " + i);
                if (this.sni.fju && i == 4) {
                    e eVar = this.sni.smS.siL;
                    if (eVar.sko == 0) {
                        eVar.sko = eVar.ske.sob;
                    }
                    int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext());
                    if (netType != eVar.sko) {
                        com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + eVar.sko + " to " + netType);
                        try {
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) netType;
                            int appCmd = eVar.ske.setAppCmd(301, bArr, 4);
                            if (appCmd < 0) {
                                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + eVar.ske.nDF + ", roomkey=" + eVar.ske.nDy + "]");
                            }
                            brt com_tencent_mm_protocal_c_brt = new brt();
                            com_tencent_mm_protocal_c_brt.wTq = 3;
                            com_tencent_mm_protocal_c_brt.wTr = new b(bArr, 0, 1);
                            eVar.ske.SendRUDP(com_tencent_mm_protocal_c_brt.toByteArray(), com_tencent_mm_protocal_c_brt.toByteArray().length);
                        } catch (Exception e) {
                            com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                        }
                        eVar.sko = netType;
                    }
                    n nVar = this.sni.smS;
                    new h(nVar.siL.ske.nDx, nVar.siL.ske.nDy, nVar.siL.ske.nDF, 0, 0, null).bHM();
                }
            }
        };
        this.oGv = new ak(Looper.getMainLooper(), new 3(this), true);
        this.snh = null;
        this.smS = new n();
        this.fju = false;
        this.smU = false;
        this.smV = false;
        this.talker = null;
        this.smq = null;
        ar.a(this.pUH);
    }

    protected final void finalize() {
        this.smS.stop();
        this.smS = null;
        ar.b(this.pUH);
        super.finalize();
    }

    public final void a(boolean z, boolean z2, String str) {
        x.i("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2);
        this.fju = z;
        if (z2) {
            this.smU = z;
            this.smS.siL.ske.soo = 0;
        } else {
            this.smS.siL.ske.soo = 1;
            this.smV = z;
        }
        this.talker = str;
    }

    public final void B(boolean z, boolean z2) {
        this.snd = z;
        this.sne = z2;
        x.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final void aF(Context context, String str) {
        x.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:" + str);
        if (!bh.ov(str) && System.currentTimeMillis() - this.smW >= 2000) {
            if (System.currentTimeMillis() - this.smZ < this.sna) {
                x.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.h.a(context, R.l.eVJ, R.l.eWc, null);
                return;
            }
            this.smW = System.currentTimeMillis();
            ar.Hg();
            if (c.EY().WO(str) != null) {
                a(context, str, true, false, false);
                bHn();
            }
        }
    }

    public final void aG(Context context, String str) {
        x.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:" + str);
        if (!bh.ov(str) && System.currentTimeMillis() - this.smW >= 2000) {
            if (System.currentTimeMillis() - this.smZ < this.sna) {
                x.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.h.a(context, R.l.eVJ, R.l.eWc, null);
                return;
            }
            this.smW = System.currentTimeMillis();
            ar.Hg();
            if (c.EY().WO(str) != null) {
                a(context, str, true, true, false);
                bHn();
            }
        }
    }

    private static void bHn() {
        com.tencent.mm.sdk.b.b spVar = new sp();
        spVar.fKq.fuL = 7;
        com.tencent.mm.sdk.b.a.xef.m(spVar);
    }

    public final void N(int i, long j) {
        ag.y(new 2(this, i, j));
    }

    public final void a(buj com_tencent_mm_protocal_c_buj) {
        if (com.tencent.mm.k.f.zp() || df(ac.getContext())) {
            String str = com_tencent_mm_protocal_c_buj.wVt;
            String FS = q.FS();
            int i = com_tencent_mm_protocal_c_buj.wVl;
            x.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", new Object[]{FS, str, Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh)});
            if (this.smS.bGq()) {
                n.a(com_tencent_mm_protocal_c_buj.wbh, com_tencent_mm_protocal_c_buj.wbi, 2, null, null, str);
                x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + com_tencent_mm_protocal_c_buj.wbh);
                g.pQN.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj.wVl), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext())), Long.valueOf(System.currentTimeMillis())});
                g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(7)});
                return;
            } else if (n.bHB()) {
                n.a(com_tencent_mm_protocal_c_buj.wbh, com_tencent_mm_protocal_c_buj.wbi, 3, null, null, str);
                x.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + com_tencent_mm_protocal_c_buj.wbh);
                g.pQN.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj.wVl), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext())), Long.valueOf(System.currentTimeMillis())});
                g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(7)});
                return;
            } else {
                Object obj;
                this.smS.bHC();
                n nVar = this.smS;
                if (nVar.siL.bGq()) {
                    com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + nVar.siL.mStatus);
                    obj = null;
                } else if (com_tencent_mm_protocal_c_buj == null) {
                    obj = null;
                } else {
                    nVar.siL.ske.spH.slc = com_tencent_mm_protocal_c_buj.wVl;
                    x.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + nVar.siL.ske.spH.slc);
                    if (nVar.siL.ske.oxo) {
                        com.tencent.mm.plugin.voip.b.a.ev("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zh() + "v2protocal already init.");
                        nVar.siL.ske.jl(false);
                        nVar.siL.ske.reset();
                    }
                    e eVar = nVar.siL;
                    eVar.skj = com_tencent_mm_protocal_c_buj;
                    eVar.ske.nTr = eVar.skj.wVt;
                    eVar.ske.nDx = eVar.skj.wbh;
                    eVar.ske.nDy = eVar.skj.wbi;
                    eVar.ske.nDF = 1;
                    eVar.ske.soc = 0;
                    eVar.mStatus = 3;
                    if (d.bIp() || com.tencent.mm.p.a.AW() || d.bIs()) {
                        x.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                        if (d.bIp()) {
                            n.a(com_tencent_mm_protocal_c_buj.wbh, com_tencent_mm_protocal_c_buj.wbi, 2, null, null, com_tencent_mm_protocal_c_buj.wVt);
                        } else {
                            nVar.bHE();
                            l.a(com_tencent_mm_protocal_c_buj.wVt, (com_tencent_mm_protocal_c_buj.wVl == 0 ? 1 : null) != null ? au.xzd : au.xzc, 0, 6, ac.getContext().getString(R.l.eUo));
                        }
                        obj = null;
                    } else if (nVar.siL.ske.bEv() < 0) {
                        com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                        obj = null;
                    } else {
                        g.pQN.a(11524, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj.wVl), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                        nVar.siL.skf.bGU();
                        obj = 1;
                    }
                }
                if (obj == null) {
                    x.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
                    g.pQN.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj.wVl), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext())), Long.valueOf(System.currentTimeMillis())});
                    g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(7)});
                    return;
                }
                Context context = ac.getContext();
                ar.Hg();
                if (c.EY().WO(str) == null) {
                    n.a(com_tencent_mm_protocal_c_buj.wbh, com_tencent_mm_protocal_c_buj.wbi, 4, null, null, str);
                    x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + com_tencent_mm_protocal_c_buj.wbh);
                    g.pQN.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj.wVl), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext())), Long.valueOf(System.currentTimeMillis())});
                    g.pQN.a(11526, true, true, new Object[]{Integer.valueOf(d.bGj().smS.siL.ske.nDx), Long.valueOf(d.bGj().bHq()), Long.valueOf(d.bGj().bHr()), Integer.valueOf(7)});
                    return;
                }
                if (1 == i || i == 0) {
                    a(context, str, false, i == 0, true);
                    if (this.smS != null) {
                        nVar = this.smS;
                        nVar.snm = com_tencent_mm_protocal_c_buj.wbh;
                        if (!nVar.snx.cfK()) {
                            nVar.snx.TG();
                        }
                        nVar.snx.J(70000, 70000);
                    }
                    x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
                }
                n.a(com_tencent_mm_protocal_c_buj.wbh, com_tencent_mm_protocal_c_buj.wbi, 1, this.smS.siL.ske.field_peerId, this.smS.siL.ske.field_capInfo, str);
                g.pQN.a(11525, true, true, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_buj.wbh), Long.valueOf(com_tencent_mm_protocal_c_buj.wbi), Integer.valueOf(com_tencent_mm_protocal_c_buj.wVl), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ac.getContext())), Long.valueOf(System.currentTimeMillis())});
                return;
            }
        }
        x.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.snf == null && this.oGv.cfK()) {
            x.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
            this.snf = com_tencent_mm_protocal_c_buj;
            this.oGv.J(2000, 2000);
            this.sng = System.currentTimeMillis();
            g.pQN.a(500, 4, 1, false);
        }
    }

    public final void yG(int i) {
        if (this.snh != null && !this.snh.isEmpty()) {
            for (a aVar : this.snh) {
                if (aVar != null && aVar.snj != null && aVar.snj.wbh == i) {
                    aVar.jwl = true;
                    return;
                }
            }
        }
    }

    public static a MC(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int hashCode = str.hashCode();
        a aVar = (a) hdO.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            return aVar;
        }
        aVar = new a();
        if (!aVar.parse(str)) {
            return null;
        }
        hdO.l(Integer.valueOf(hashCode), aVar);
        return aVar;
    }

    private static Map<Integer, Long> aN(byte[] bArr) {
        if (bh.bw(bArr)) {
            return null;
        }
        try {
            bmy com_tencent_mm_protocal_c_bmy = (bmy) new bmy().aF(bArr);
            if (com_tencent_mm_protocal_c_bmy == null) {
                return null;
            }
            x.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + com_tencent_mm_protocal_c_bmy.wLX);
            LinkedList linkedList = com_tencent_mm_protocal_c_bmy.wLY;
            if (linkedList.size() != com_tencent_mm_protocal_c_bmy.wLX) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            for (int i = 0; i < com_tencent_mm_protocal_c_bmy.wLX; i++) {
                hashMap.put(Integer.valueOf(((ans) linkedList.get(i)).pQj), Long.valueOf(4294967295L & ((long) ((ans) linkedList.get(i)).wuF)));
            }
            if (hashMap.size() != com_tencent_mm_protocal_c_bmy.wLX) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] R(Map<Integer, Long> map) {
        bmy com_tencent_mm_protocal_c_bmy = new bmy();
        LinkedList linkedList = new LinkedList();
        for (Integer num : map.keySet()) {
            ans com_tencent_mm_protocal_c_ans = new ans();
            com_tencent_mm_protocal_c_ans.pQj = num.intValue();
            com_tencent_mm_protocal_c_ans.wuF = ((Long) map.get(num)).intValue();
            linkedList.push(com_tencent_mm_protocal_c_ans);
        }
        com_tencent_mm_protocal_c_bmy.wLY = linkedList;
        com_tencent_mm_protocal_c_bmy.wLX = linkedList.size();
        try {
            return com_tencent_mm_protocal_c_bmy.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
            return null;
        }
    }

    private static String aO(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString.toUpperCase();
        }
        return str;
    }

    public final int b(byte[] bArr, int i, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        x.i("MicroMsg.Voip.VoipService", "__parse voip notify begin");
        Map aN = aN(this.smS.siL.ski);
        if (aN == null) {
            x.i("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
            j2 = 0;
            j3 = 0;
            j4 = 0;
        } else {
            j2 = 0;
            j4 = 0;
            j5 = 0;
            for (Integer num : aN.keySet()) {
                Long l = (Long) aN.get(num);
                switch (num.intValue()) {
                    case 1:
                        j2 = l.longValue();
                        break;
                    case 2:
                        j4 = l.longValue();
                        break;
                    case 3:
                        j5 = l.longValue();
                        break;
                    default:
                        String str = "MicroMsg.Voip.VoipService";
                        x.i(str, "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j3 = j2;
            j2 = j4;
            j4 = j5;
        }
        x.i("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j3 + " relayData key:" + j2 + " connectingStatusKey:" + j4);
        try {
            buf com_tencent_mm_protocal_c_buf = (buf) new buf().aF(bArr);
            for (int i2 = 0; i2 < com_tencent_mm_protocal_c_buf.wVm.size(); i2++) {
                bue com_tencent_mm_protocal_c_bue = (bue) com_tencent_mm_protocal_c_buf.wVm.get(i2);
                x.i("MicroMsg.Voip.VoipService", "__parse voip notify, item cmdid:" + com_tencent_mm_protocal_c_bue.vXp);
                if (com_tencent_mm_protocal_c_bue.vXp == 1) {
                    bve com_tencent_mm_protocal_c_bve;
                    try {
                        com_tencent_mm_protocal_c_bve = (bve) new bve().aF(com_tencent_mm_protocal_c_bue.vKf.wJD.oz);
                    } catch (Throwable e) {
                        x.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                        x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                        com_tencent_mm_protocal_c_bve = null;
                    }
                    if (com_tencent_mm_protocal_c_bve != null) {
                        x.i("MicroMsg.Voip.VoipService", "voip notify status:" + com_tencent_mm_protocal_c_bve.ktm);
                        if (j6 < ((long) com_tencent_mm_protocal_c_bue.pQj)) {
                            j5 = (long) com_tencent_mm_protocal_c_bue.pQj;
                        } else {
                            j5 = j6;
                        }
                        if (((long) com_tencent_mm_protocal_c_bue.pQj) > j3) {
                            x.i("MicroMsg.Voip.VoipService", "voiop notify status key[" + com_tencent_mm_protocal_c_bue.pQj + "] > local status key[" + j3 + "] status[" + com_tencent_mm_protocal_c_bve.ktm + "]");
                            this.smS.siL.skh.a(com_tencent_mm_protocal_c_bve, 1);
                            j6 = j5;
                        }
                    } else {
                        x.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                        j5 = j6;
                    }
                    j6 = j5;
                } else if (com_tencent_mm_protocal_c_bue.vXp == 2) {
                    but com_tencent_mm_protocal_c_but;
                    try {
                        com_tencent_mm_protocal_c_but = (but) new but().aF(com_tencent_mm_protocal_c_bue.vKf.wJD.oz);
                    } catch (Throwable e2) {
                        x.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        x.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                        com_tencent_mm_protocal_c_but = null;
                    }
                    if (com_tencent_mm_protocal_c_but != null) {
                        x.i("MicroMsg.Voip.VoipService", "notify relay data type:" + com_tencent_mm_protocal_c_but.ktN);
                        if (j7 < ((long) com_tencent_mm_protocal_c_bue.pQj)) {
                            j5 = (long) com_tencent_mm_protocal_c_bue.pQj;
                        } else {
                            j5 = j7;
                        }
                        if (((long) com_tencent_mm_protocal_c_bue.pQj) > j2) {
                            r0 = new StringBuilder("notify relaydata key:[");
                            x.i("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bue.pQj).append("] > local relaydata key[").append(j2).append("]").toString());
                            if (com_tencent_mm_protocal_c_but.ktN == 5) {
                                this.smS.siL.skh.a(com_tencent_mm_protocal_c_but);
                                j7 = j5;
                            } else if (com_tencent_mm_protocal_c_but.ktN == 1) {
                                this.smS.siL.skh.b(com_tencent_mm_protocal_c_but);
                                j7 = j5;
                            } else {
                                x.i("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + com_tencent_mm_protocal_c_but.ktN);
                                j7 = j5;
                            }
                        } else {
                            r0 = new StringBuilder("notify relaydata item key[");
                            x.i("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bue.pQj).append("] <=local relaydatakey[").append(j2).append("]").toString());
                            j7 = j5;
                        }
                    } else {
                        x.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                    }
                } else if (com_tencent_mm_protocal_c_bue.vXp == 3) {
                    bdn bk;
                    try {
                        bk = new bdn().bk(com_tencent_mm_protocal_c_bue.vKf.wJD.oz);
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Voip.VoipService", e22, "", new Object[0]);
                        bk = null;
                    }
                    if (bk != null) {
                        if (j8 < ((long) com_tencent_mm_protocal_c_bue.pQj)) {
                            j5 = (long) com_tencent_mm_protocal_c_bue.pQj;
                        } else {
                            j5 = j8;
                        }
                        if (((long) com_tencent_mm_protocal_c_bue.pQj) > j4) {
                            r0 = new StringBuilder("notify connectingStatkey[");
                            x.i("MicroMsg.Voip.VoipService", r0.append(com_tencent_mm_protocal_c_bue.pQj).append("]> local connectingstatus key[").append(j4).append("]").toString());
                            this.smS.siL.skh.c(bk);
                            if (this.snf != null && (com.tencent.mm.plugin.voip.b.a.aQ(bk.wJD.toByteArray()) & 255) == 1) {
                                this.snf.wVl = 1;
                            }
                        }
                        j8 = j5;
                    }
                }
            }
            if (j6 <= j3) {
                j6 = j3;
            }
            if (j7 <= j2) {
                j7 = j2;
            }
            if (j8 <= j4) {
                j8 = j4;
            }
            Map hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), Long.valueOf(j6));
            hashMap.put(Integer.valueOf(2), Long.valueOf(j7));
            hashMap.put(Integer.valueOf(3), Long.valueOf(j8));
            byte[] R = R(hashMap);
            if (i == this.smS.siL.ske.nDx && j == this.smS.siL.ske.nDy) {
                this.smS.siL.ski = R;
                x.i("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j6 + ", " + j7 + ", " + j8);
            }
            x.i("MicroMsg.Voip.VoipService", "__parse voip notify end");
            return 0;
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
            x.i("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + aO(bArr));
            return 0;
        }
    }

    public static byte[] M(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 12; i2 < i + 12; i2++) {
            bArr2[i2 - 12] = bArr[i2];
        }
        return bArr2;
    }

    public final int C(boolean z, boolean z2) {
        n nVar = this.smS;
        nVar.bHH();
        if (!nVar.snx.cfK()) {
            nVar.snx.TG();
        }
        h hVar = nVar.siL.ske.spH;
        hVar.sly = System.currentTimeMillis();
        com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + hVar.sly);
        x.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:" + z);
        if (!nVar.siL.bGp()) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + nVar.siL.mStatus);
            return -1;
        } else if (nVar.siL.ske.nDx == 0) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            return -1;
        } else {
            com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zh() + "accept invite, roomid:" + nVar.siL.ske.nDx);
            nVar.snw.J(50000, 50000);
            nVar.siL.ske.spH.bGF();
            new com.tencent.mm.plugin.voip.model.a.b(1, nVar.siL.ske.netType, nVar.siL.ske.nDx, nVar.siL.ske.field_peerId, nVar.siL.ske.field_capInfo, nVar.siL.ske.nDy, z, z2).bHM();
            nVar.siL.eQ(4);
            nVar.siL.skg.skA = 1;
            nVar.siL.fDV = true;
            return 0;
        }
    }

    public final int bHo() {
        n nVar = this.smS;
        x.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (nVar.siL.ske.nDx == 0) {
            nVar.siL.skg.bGE();
            nVar.reset();
            return 0;
        }
        nVar.siL.ske.spH.skR = nVar.siL.bGo();
        return nVar.bHF();
    }

    public final void yw(int i) {
        this.smS.siL.yw(i);
    }

    public final int bHp() {
        return this.smS.siL.ske.nDx;
    }

    public final long bHq() {
        return this.smS.siL.ske.nDy;
    }

    public final long bHr() {
        return (long) this.smS.siL.ske.soo;
    }

    public final boolean bHs() {
        return this.smS.siL.bGv();
    }

    public final boolean bHt() {
        return this.smS.siL.bGw();
    }

    public final int bGh() {
        g gVar = this.smS.siL.skg;
        return gVar.sky != null ? gVar.sky.bGh() : 0;
    }

    public final void yH(int i) {
        x.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[]{Integer.valueOf(i)});
        this.smS.siL.ske.sop = Math.abs(i);
    }

    public final void bHu() {
        x.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[]{Integer.valueOf(1)});
        this.smS.siL.ske.spH.sld = 1;
    }

    public final int a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, boolean z) {
        g gVar = this.smS.siL.skg;
        if (((!z ? 1 : 0) & (gVar.skA == g.skz ? 1 : 0)) != 0) {
            return -1;
        }
        return !gVar.siL.ske.oxo ? -1 : gVar.siL.ske.videoEncodeToLocal(bArr, i, i3, i4, i2, 0, 75, iArr);
    }

    public final boolean jd(boolean z) {
        g gVar = this.smS.siL.skg;
        return gVar.sky != null ? gVar.sky.jd(z) : false;
    }

    public final int ji(boolean z) {
        e eVar = this.smS.siL;
        int td = z ? eVar.ske.td(412) : eVar.ske.td(413);
        if (td < 0) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:" + td);
        }
        return td;
    }

    public final int jj(boolean z) {
        e eVar = this.smS.siL;
        int td = z ? eVar.ske.td(401) : eVar.ske.td(e.CTRL_INDEX);
        if (td < 0) {
            com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:" + td);
        }
        return td;
    }

    public final void k(int i, int i2, boolean z) {
        n nVar = this.smS;
        if (nVar.snl != null && i > 0) {
            nVar.snl.m(i, i2, z);
        }
    }

    public final void dO(int i, int i2) {
        n nVar = this.smS;
        if (nVar.snl != null && i > 0) {
            nVar.snl.e(i, false, i2);
        }
    }

    public final void yI(int i) {
        n nVar = this.smS;
        if (nVar.snl != null && i > 0) {
            nVar.snl.b(i, false, 0, false);
        }
    }

    public final void stopRing() {
        n nVar = this.smS;
        if (nVar.snl != null) {
            nVar.snl.stop();
        }
    }

    public final boolean bHv() {
        n nVar = this.smS;
        return nVar.snl != null ? nVar.snl.aip() : true;
    }

    public static void bHw() {
    }

    public static void bHx() {
    }

    public static void a(Context context, String str, boolean z, boolean z2, boolean z3) {
        if (context == null) {
            context = ac.getContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.b.b igVar = new ig();
        igVar.fyJ.fyM = false;
        igVar.fyJ.fyL = currentTimeMillis;
        igVar.fyJ.fyK = context;
        com.tencent.mm.sdk.b.a.xef.m(igVar);
        x.i("MicroMsg.Voip.VoipService", "start VideoActivity");
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("Voip_User", str);
        intent.putExtra("Voip_Outcall", z);
        intent.putExtra("Voip_VideoCall", z2);
        intent.putExtra("Voip_LastPage_Hash", currentTimeMillis);
        if (z3) {
            intent.setFlags(603979776);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public static float jk(boolean z) {
        float f = 0.74766356f;
        try {
            byte[] bArr;
            m bGj = d.bGj();
            if (z) {
                bArr = bGj.smS.siL.ske.field_capInfo;
            } else {
                bArr = bGj.smS.siL.ske.sof;
            }
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() > 65535) {
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                }
                wrap.getShort();
                wrap.getShort();
                float f2 = ((float) wrap.getInt()) / 100.0f;
                if (f2 != 0.0f) {
                    f = f2;
                }
                x.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
            }
        } catch (Exception e) {
            x.e("MicroMsg.Voip.VoipService", "update failed: " + e.getMessage());
        }
        return f;
    }

    public final void bHy() {
        this.smS.snv.J(1000, 1000);
    }

    private static boolean df(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.Voip.VoipService", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.Voip.VoipService", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ac.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipService", "is in foreGround.");
        return true;
    }

    public final void yJ(int i) {
        e eVar = this.smS.siL;
        com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i;
            eVar.ske.setJNIAppCmd(2, bArr, 4);
            btk com_tencent_mm_protocal_c_btk = new btk();
            com_tencent_mm_protocal_c_btk.wUR = i;
            com_tencent_mm_protocal_c_btk.wUS = 1;
            brt com_tencent_mm_protocal_c_brt = new brt();
            com_tencent_mm_protocal_c_brt.wTq = 4;
            com_tencent_mm_protocal_c_brt.wTr = new b(com_tencent_mm_protocal_c_btk.toByteArray(), 0, 1);
            eVar.ske.SendRUDP(com_tencent_mm_protocal_c_brt.toByteArray(), com_tencent_mm_protocal_c_brt.toByteArray().length);
        } catch (Exception e) {
            com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
        }
    }

    public final void MD(String str) {
        for (int i = 0; i < 2; i++) {
            ag.h(new 4(this, str), 1000);
        }
    }

    public final void bHz() {
        g gVar = this.smS.siL.skg;
        x.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[]{gVar.oFS});
        synchronized (gVar.skK) {
            if (gVar.oFS != null) {
                x.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                gVar.oFS.vi();
                gVar.oFS = null;
            }
        }
    }
}
