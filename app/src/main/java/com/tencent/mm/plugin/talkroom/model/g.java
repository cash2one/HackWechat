package com.tencent.mm.plugin.talkroom.model;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.talkroom.b.f;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.model.c.1;
import com.tencent.mm.plugin.talkroom.model.i.10;
import com.tencent.mm.plugin.talkroom.model.i.11;
import com.tencent.mm.plugin.talkroom.model.i.12;
import com.tencent.mm.plugin.talkroom.model.i.2;
import com.tencent.mm.plugin.talkroom.model.i.3;
import com.tencent.mm.plugin.talkroom.model.i.4;
import com.tencent.mm.plugin.talkroom.model.i.6;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.q.n;
import com.tencent.mm.pluginsdk.q.o;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bng;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.protocal.c.bni;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ad;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.smtt.sdk.QbSdk;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements e, l, n, ad {
    public static final int[] scd = new int[]{80, 8080, 16285};
    public static final byte[][] sce = new byte[][]{new byte[]{(byte) 101, (byte) -30, (byte) 76, (byte) 27}, new byte[]{(byte) 112, (byte) 64, (byte) -19, (byte) -29}, new byte[]{(byte) 120, (byte) -52, (byte) -55, (byte) -58}};
    private final ServiceConnection lrm = new 1(this);
    private int nDx;
    private long nDy;
    private int sbO = 0;
    private int sbP = 0;
    private boolean sbQ = false;
    public String sbR;
    private int sbS;
    private int sbT;
    private int sbU;
    private LinkedList<bng> sbV = new LinkedList();
    private a sbW;
    private b sbX;
    private com.tencent.mm.plugin.talkroom.component.e sbY;
    private d sbZ;
    private aa sca;
    private ak scb;
    private i scc = new i();
    public boolean scf = false;
    private int state = 0;

    public g() {
        TalkRoomReceiver.init();
    }

    public final int bEL() {
        if (this.sbO != 1) {
            return (q.a.vcw == null || !q.a.vcw.DC(this.sbR)) ? 0 : 1;
        } else {
            return 1;
        }
    }

    public final List<bnh> aVC() {
        return b.bED().Ms(this.sbR);
    }

    public final String bEM() {
        Iterator it = b.bED().Ms(this.sbR).iterator();
        while (it.hasNext()) {
            bnh com_tencent_mm_protocal_c_bnh = (bnh) it.next();
            if (com_tencent_mm_protocal_c_bnh.wQe == this.sbU) {
                return com_tencent_mm_protocal_c_bnh.ksU;
            }
        }
        return null;
    }

    public final void a(o oVar) {
        i iVar = this.scc;
        synchronized (oVar) {
            if (iVar.gxL.contains(oVar)) {
            } else {
                iVar.gxL.add(oVar);
            }
        }
        this.scc.DM(bEM());
    }

    public final void b(o oVar) {
        i iVar = this.scc;
        synchronized (oVar) {
            iVar.gxL.remove(oVar);
        }
    }

    private boolean bEN() {
        if (bEL() == 1) {
            b(b.bEB().saW);
        } else {
            a(b.bEB().saW);
        }
        if (this.sbP > 0) {
            x.i("MicroMsg.TalkRoomServer", "addListener has init before");
        } else {
            ar.CG().a(332, this);
            ar.CG().a(334, this);
            ar.CG().a(336, this);
            ar.CG().a(335, this);
            b.bED().a(this);
            ar.ux().a(this);
            this.sbP = 1;
            if (this.sbW != null) {
                try {
                    this.sbW.Close();
                    this.sbW.uninitLive();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            }
            ac.getContext().bindService(new Intent(ac.getContext(), TalkRoomService.class), this.lrm, 1);
            this.sbX = new 2(this);
        }
        return true;
    }

    public final void cl(String str, int i) {
        x.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[]{str, Integer.valueOf(i)});
        this.sbO = i;
        bEN();
        if (str.equals(this.sbR)) {
            x.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[]{str});
            if (this.state == 2) {
                this.scc.aWb();
                return;
            }
            return;
        }
        x.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[]{str});
        this.sbR = str;
        ar.CG().a(new com.tencent.mm.plugin.talkroom.b.a(this.sbR, bEL()), 0);
        b.bEB().saY = new f();
        b.bEF().sbI = bh.Wq();
        b.bEF().sbF = str;
        if (bEL() == 0) {
            b.bEB().saW.nUw = true;
        }
        i iVar = this.scc;
        Runnable 11 = new 11(iVar, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            11.run();
        } else {
            iVar.handler.post(11);
        }
    }

    public final void aWa() {
        x.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        iU(false);
        if (bh.ov(this.sbR)) {
            x.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            return;
        }
        int Close;
        f bEF = b.bEF();
        if (bEF.sbI != 0) {
            bEF.sbm = (int) (bh.bA(bEF.sbI) / 1000);
        }
        this.state = 0;
        this.sbQ = false;
        ar.CG().a(new com.tencent.mm.plugin.talkroom.b.b(this.nDx, this.nDy, this.nDx != 0 ? this.sbR : "", bEL()), 0);
        if (this.sbW != null) {
            try {
                Close = this.sbW.Close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                Close = QbSdk.EXTENSION_INIT_FAILURE;
            }
            if (Close < 0) {
                x.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[]{Integer.valueOf(Close)});
            }
            PByteArray pByteArray = new PByteArray();
            if (a(pByteArray, r.gu(this.sbR)) == 0) {
                x.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[]{Integer.valueOf(pByteArray.value.length), new String(pByteArray.value)});
                LinkedList linkedList = new LinkedList();
                bni com_tencent_mm_protocal_c_bni = new bni();
                com_tencent_mm_protocal_c_bni.wuu = 10402;
                com_tencent_mm_protocal_c_bni.wQf = new bdo().UA(r1);
                bni com_tencent_mm_protocal_c_bni2 = new bni();
                com_tencent_mm_protocal_c_bni2.wuu = 10404;
                com_tencent_mm_protocal_c_bni2.wQf = new bdo().UA(b.bEF().toString());
                linkedList.add(com_tencent_mm_protocal_c_bni);
                linkedList.add(com_tencent_mm_protocal_c_bni2);
                ar.CG().a(new com.tencent.mm.plugin.talkroom.b.g(linkedList, bEL()), 0);
            }
        }
        this.sbR = "";
        this.nDx = 0;
        this.nDy = 0;
        this.sbS = 0;
        this.sbT = 0;
        this.sbU = 0;
        this.sbV.clear();
        bEO();
        i iVar = this.scc;
        Runnable 12 = new 12(iVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            12.run();
        } else {
            iVar.handler.post(12);
        }
        c cVar = b.bEB().saW;
        cVar.mHandler.post(new 1(cVar));
        this.sbP = 0;
        ar.CG().b(332, this);
        ar.CG().b(334, this);
        ar.CG().b(336, this);
        ar.CG().b(335, this);
        b.bED().b(this);
        ar.ux().b(this);
        b(b.bEB().saW);
        if (this.sbW != null) {
            try {
                Close = this.sbW.uninitLive();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            ac.getContext().unbindService(this.lrm);
            ac.getContext().stopService(new Intent(ac.getContext(), TalkRoomService.class));
            this.sbW = null;
            if (Close < 0) {
                x.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
            }
        }
        Close = QbSdk.EXTENSION_INIT_FAILURE;
        ac.getContext().unbindService(this.lrm);
        ac.getContext().stopService(new Intent(ac.getContext(), TalkRoomService.class));
        this.sbW = null;
        if (Close < 0) {
            x.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
        }
    }

    private void bEO() {
        if (this.sbY != null) {
            try {
                this.sbY.release();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            this.sbY = null;
        }
        if (this.sbZ != null) {
            try {
                this.sbZ.release();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            this.sbZ = null;
        }
        if (this.sca != null) {
            this.sca.TG();
            this.sca = null;
        }
        if (this.scb != null) {
            this.scb.TG();
            this.scb = null;
        }
    }

    private void iU(boolean z) {
        if (!bh.ov(this.sbR)) {
            ar.Hg();
            aj WY = c.Fd().WY(this.sbR);
            if (WY != null) {
                WY.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(WY, z ? 5 : 6, WY.field_conversationTime));
                ar.Hg();
                c.Fd().a(WY, this.sbR);
            }
        }
    }

    public final boolean bEP() {
        x.i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            x.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.scc.j(3, -1, "seizeMic in outside room state");
            }
            return false;
        }
        if (this.sbY != null) {
            try {
                this.sbY.bxv();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        this.state = 3;
        ar.CG().a(new com.tencent.mm.plugin.talkroom.b.d(this.nDx, this.nDy, 1, this.sbR, bEL()), 0);
        b.bEF().sbK = bh.Wq();
        b.bEF().sbN = true;
        return true;
    }

    public final void bEQ() {
        x.i("MicroMsg.TalkRoomServer", "putAwayMic");
        f bEF = b.bEF();
        if (bEF.sbN && !bEF.sbM) {
            bEF.sbH++;
        }
        bEF.sbM = false;
        bEF.sbN = false;
        if (this.state < 3) {
            x.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            return;
        }
        if (this.scb != null) {
            this.scb.TG();
            this.scb = null;
        }
        bER();
        ar.CG().a(new com.tencent.mm.plugin.talkroom.b.d(this.nDx, this.nDy, 2, this.sbR, bEL()), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        f fVar = (f) kVar;
        if (fVar.bEY() == null || !fVar.bEY().equals(this.sbR)) {
            x.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[]{fVar.bEY(), this.sbR});
            return;
        }
        if (!(i == 0 && i2 == 0)) {
            if (kVar.getType() == 332) {
                b.bEF().yk(2);
                if (i == 4) {
                    b.bEF().sbG = i2;
                }
                this.scc.J("cgi enter failed : errType:" + i + " errCode:" + i2, i, i2);
                aWa();
                return;
            } else if (kVar.getType() == 334) {
                if (((com.tencent.mm.plugin.talkroom.b.d) kVar).actionType == 1) {
                    f bEF = b.bEF();
                    bEF.sbp++;
                    bEF.sbK = 0;
                    bER();
                    x.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                    if (i == 4 && (i2 == 311 || i2 == 340)) {
                        this.scc.rN(i2);
                        return;
                    } else {
                        this.scc.j(i, i2, "TalkMicAction failed!!");
                        return;
                    }
                }
                return;
            } else if (kVar.getType() == 336) {
                this.sbQ = false;
                this.scc.j(i, i2, "TalkGetMember failed!!");
                aWa();
                return;
            } else if (kVar.getType() == 335) {
                this.scc.j(i, i2, "TalkNoop failed!!");
                aWa();
                return;
            }
        }
        if (kVar.getType() == 332) {
            b.bEF().yk(1);
            com.tencent.mm.plugin.talkroom.b.a aVar = (com.tencent.mm.plugin.talkroom.b.a) kVar;
            this.nDx = aVar.nDx;
            this.nDy = aVar.nDy;
            this.sbS = aVar.sbS;
            this.sbT = aVar.sbT;
            this.sbV = aVar.sbV;
            bEF = b.bEF();
            int i3 = this.nDx;
            long j = this.nDy;
            bEF.nDx = i3;
            bEF.nDy = j;
            b.bED().a(this.sbR, aVar.sco, null, null, fVar.bEZ());
            yl(100);
        } else if (kVar.getType() == 334) {
            com.tencent.mm.plugin.talkroom.b.d dVar = (com.tencent.mm.plugin.talkroom.b.d) kVar;
            if (dVar.actionType == 1) {
                bEF = b.bEF();
                if (bEF.sbK != 0) {
                    bEF.sbn = (bh.bA(bEF.sbK) + (bEF.sbn * ((long) bEF.sbJ))) / ((long) (bEF.sbJ + 1));
                    bEF.sbJ++;
                    bEF.sbo++;
                    bEF.sbK = 0;
                }
                x.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (dVar.sbS < this.sbS) {
                    x.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[]{Integer.valueOf(dVar.sbS), Integer.valueOf(this.sbS)});
                    bER();
                    this.scc.rN(311);
                    return;
                }
                this.sbS = dVar.sbS;
                int i4 = QbSdk.EXTENSION_INIT_FAILURE;
                try {
                    i4 = this.sbW.SetCurrentMicId(this.sbS);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
                if (this.state != 3) {
                    x.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    return;
                }
                i iVar = this.scc;
                Runnable 6 = new 6(iVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    6.run();
                } else {
                    iVar.handler.post(6);
                }
                this.state = 4;
                if (i4 < 0) {
                    x.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[]{Integer.valueOf(i4)});
                }
                if (this.scb == null) {
                    this.scb = new ak(new 3(this), true);
                    this.scb.J(5000, 5000);
                    return;
                }
                return;
            }
            x.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
        } else {
            if (kVar.getType() == 336) {
                com.tencent.mm.plugin.talkroom.b.c cVar = (com.tencent.mm.plugin.talkroom.b.c) kVar;
                b.bED().a(this.sbR, cVar.sco, null, null, fVar.bEZ());
                ym(cVar.sbS);
                this.sbQ = false;
                this.scc.DM(bEM());
            }
            if (kVar.getType() == 335 && this.state == 0) {
                this.scc.j(3, -1, "talknoop success but in outside room state");
            }
        }
    }

    private void bER() {
        try {
            f bEF = b.bEF();
            if (bEF.sbL != 0) {
                long bA = bh.bA(bEF.sbL) / 1000;
                if (bA < 2) {
                    bEF.sbw++;
                } else if (bA < 6) {
                    bEF.sbx++;
                } else if (bA < 11) {
                    bEF.sby++;
                } else if (bA < 21) {
                    bEF.sbz++;
                } else if (bA < 31) {
                    bEF.sbA++;
                } else if (bA < 41) {
                    bEF.sbB++;
                } else if (bA < 51) {
                    bEF.sbC++;
                } else if (bA < 61) {
                    bEF.sbD++;
                } else {
                    bEF.sbE++;
                }
                bEF.sbL = 0;
            }
            if (this.sbZ != null) {
                this.sbZ.bEx();
            }
            if (this.sbY != null) {
                this.sbY.bEA();
            }
            this.state = 2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
    }

    public final void bEy() {
        x.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[]{Integer.valueOf(this.state)});
        if (this.state == 4) {
            f bEF = b.bEF();
            bEF.sbM = true;
            bEF.sbL = bh.Wq();
            try {
                this.sbZ.bEy();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
    }

    private void yl(int i) {
        if (this.sbW != null) {
            try {
                this.state = 1;
                this.sbQ = false;
                if (bES()) {
                    bEO();
                    bEU();
                    bET();
                    if (this.sca != null) {
                        x.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
                        return;
                    }
                    this.sca = new aa(new 5(this));
                    aa aaVar = this.sca;
                    aa.xfn = true;
                    aaVar.suO = 50000;
                    aaVar.hjC = bh.Wq();
                    boolean fG = aa.fG(aaVar.suO);
                    aaVar.TG();
                    aa.xfk.put(Integer.valueOf(aaVar.xfj), aaVar);
                    if (aa.gxR != null && fG) {
                        x.v("MicroMsg.MAlarmHandler", "prepare bumper");
                        aa.gxR.prepare();
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        } else if (i == 0) {
            this.scc.J("bind talkroomService timeout", 3, -1);
        } else {
            new af().postDelayed(new 4(this, i), 50);
        }
    }

    private boolean bES() {
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        try {
            i = this.sbW.bEv();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        x.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i >= 0 || i == -3) {
            return true;
        }
        this.sbW = null;
        x.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[]{Integer.valueOf(i)});
        this.scc.J("enterTalkRoom protocalInit failed", 3, -1);
        return false;
    }

    private void ym(int i) {
        if (i > this.sbS) {
            this.sbS = i;
            if (this.state >= 3) {
                this.scc.rN(311);
            }
            bER();
        }
    }

    public final void iV(boolean z) {
        x.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[]{this.sbR});
        if (!bh.ov(this.sbR) && this.state >= 2) {
            f bEF = b.bEF();
            bEF.sbs++;
            if (z) {
                if (bES()) {
                    try {
                        bET();
                    } catch (Throwable e) {
                        x.e("MicroMsg.TalkRoomServer", e.toString());
                        x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                    }
                } else {
                    return;
                }
            }
            bER();
            this.state = 1;
            try {
                if (this.sbW != null) {
                    this.sbW.Close();
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            if (this.nDx != 0) {
                bEU();
            }
            if (!z) {
                i iVar = this.scc;
                Runnable 4 = new 4(iVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    4.run();
                } else {
                    iVar.handler.post(4);
                }
            }
        }
    }

    private void bET() {
        if (this.sbW == null) {
            x.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            return;
        }
        this.sbY = this.sbW.a(new 6(this));
        this.sbY.start();
        this.sbZ = this.sbW.bEw();
        this.sbZ.start();
    }

    private static String yn(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            return null;
        }
    }

    private void bEU() {
        if (this.sbV.size() == 0) {
            x.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.scc.j(3, -1, "engine.talk relay addr list empty");
            return;
        }
        int a;
        int[] iArr = new int[this.sbV.size()];
        int[] iArr2 = new int[this.sbV.size()];
        x.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[]{Integer.valueOf(this.sbV.size())});
        for (int i = 0; i < this.sbV.size(); i++) {
            iArr[i] = ((bng) this.sbV.get(i)).wQd;
            iArr2[i] = ((bng) this.sbV.get(i)).wFo;
            x.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", new Object[]{yn(((bng) this.sbV.get(i)).wQd), Integer.valueOf(((bng) this.sbV.get(i)).wFo)});
        }
        x.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[]{Integer.valueOf(this.sbT), Integer.valueOf(this.nDx), Long.valueOf(this.nDy)});
        try {
            a aVar = this.sbW;
            b bVar = this.sbX;
            ar.Hg();
            a = aVar.a(bVar, c.Cg(), this.sbT, this.nDx, this.nDy, iArr, iArr2, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            a = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (a < 0 && a != -3) {
            x.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[]{Integer.valueOf(a)});
            this.scc.j(3, a, "engine.Open error");
        }
    }

    public final short bEV() {
        short s = (short) 0;
        if (this.sbZ == null) {
            return s;
        }
        try {
            return (short) this.sbZ.bEz();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    public final short bEW() {
        short s = (short) 0;
        if (this.sbY == null) {
            return s;
        }
        try {
            return (short) this.sbY.bEz();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    private int a(PByteArray pByteArray, String str) {
        if (this.sbW == null) {
            return -99;
        }
        int[] iArr = new int[1];
        try {
            pByteArray.value = this.sbW.d(iArr, str);
        } catch (Throwable e) {
            iArr[0] = QbSdk.EXTENSION_INIT_FAILURE;
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        return iArr[0];
    }

    public final void F(String str, String str2, String str3) {
        if (str.equals(this.sbR)) {
            i iVar = this.scc;
            Runnable 10 = new 10(iVar, str2, str3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                10.run();
            } else {
                iVar.handler.post(10);
            }
        }
    }

    public final boolean bEX() {
        return this.scf;
    }

    public final void GO() {
        x.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (bh.ov(this.sbR)) {
            x.d("MicroMsg.TalkRoomServer", "pause");
        } else {
            bER();
        }
        this.scf = false;
        i iVar = this.scc;
        Runnable 3 = new 3(iVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            3.run();
        } else {
            iVar.handler.post(3);
        }
    }

    public final void GP() {
        x.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (bh.ov(this.sbR)) {
                x.d("MicroMsg.TalkRoomServer", "pause");
            } else {
                if (this.sbZ != null) {
                    this.sbZ.bEx();
                }
                if (this.sbY != null) {
                    this.sbY.bxv();
                }
                this.state = 2;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        this.scf = true;
        i iVar = this.scc;
        Runnable 2 = new 2(iVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            2.run();
        } else {
            iVar.handler.post(2);
        }
    }
}
