package com.tencent.mm.bg;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.ae.n.AnonymousClass4;
import com.tencent.mm.bg.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b extends a implements k {
    private String filename = null;
    private e gJT;
    private int hOX = 0;
    private boolean hWy = false;
    private int hXU = 120;
    g hXV;
    private boolean hXW = false;
    private boolean hXX = false;
    private int hXY = 0;
    private bdo hXZ = null;
    private String[] hYa = new String[0];
    private int hYb = 3960;
    private af hYc = new 2(this, g.Dm().oAt.getLooper());
    private int retCode = 0;

    public final void UL() {
        this.hWy = true;
    }

    public final String[] UM() {
        return this.hYa;
    }

    public final long UN() {
        return 0;
    }

    public final Set<String> UO() {
        g gVar = this.hXV;
        Set<String> hashSet = new HashSet();
        gVar.hYI.readLock().lock();
        for (a aVar : gVar.hYH.values()) {
            if (aVar.hYL) {
                hashSet.add(aVar.hYK);
            }
        }
        gVar.hYI.readLock().unlock();
        return hashSet;
    }

    public b(String str, String str2, String str3) {
        this.filename = str;
        this.hXV = new g(str2);
        this.hXZ = new bdo().UA(str3);
        x.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s", str, str2, str3);
    }

    public final boolean UP() {
        x.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.hYc.removeMessages(JsApiCreateAudioInstance.CTRL_INDEX);
        if ((this.hXV.UZ() && this.hWy) || this.hXW) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
            return false;
        }
        a iO = this.hXV.iO(this.hOX);
        if (iO != null) {
            int min = Math.min(com.tencent.mm.a.e.bN(this.filename), iO.hYN);
            x.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", Integer.valueOf(r3), Integer.valueOf(iO.hYN), Integer.valueOf(min));
            if (min <= 0) {
                x.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", this.filename);
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.hXY = 0;
                UQ();
                this.gJT.a(3, -1, "ReadFileLengthError", null);
                return false;
            }
            this.hXY = min - this.hOX;
            if (this.hXY < 0) {
                x.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", Integer.valueOf(this.hXY));
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.hYc.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) (this.hXU * 2));
                return false;
            }
            x.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", Integer.valueOf(this.hXY), Integer.valueOf(iO.hYO), Integer.valueOf(this.hXU));
            if (this.hXY >= 500 || iO.hYO <= 5) {
                this.hYc.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) this.hXU);
            } else {
                x.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", Integer.valueOf(this.hXY));
                this.hYc.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) (this.hXU * 2));
            }
            return true;
        }
        this.hYc.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) (this.hXU * 2));
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new btb();
        aVar.hmk = new btd();
        aVar.uri = "/cgi-bin/micromsg-bin/voicetrans";
        aVar.hmi = 235;
        aVar.hml = 381;
        aVar.hmm = 1000000381;
        q JZ = aVar.JZ();
        JZ.Kb().vBk = false;
        btb com_tencent_mm_protocal_c_btb = (btb) JZ.hmg.hmo;
        a iO = this.hXV.iO(this.hOX);
        if (iO == null) {
            com_tencent_mm_protocal_c_btb.vXz = new bdn();
            com_tencent_mm_protocal_c_btb.vNW = this.hOX;
            com_tencent_mm_protocal_c_btb.wRR = "0";
            com_tencent_mm_protocal_c_btb.vLj = 1;
            com_tencent_mm_protocal_c_btb.wRT = 2;
            com_tencent_mm_protocal_c_btb.vOI = 0;
            com_tencent_mm_protocal_c_btb.wUf = this.hXV.UY();
            com_tencent_mm_protocal_c_btb.wUe = com_tencent_mm_protocal_c_btb.wUf == null ? 0 : com_tencent_mm_protocal_c_btb.wUf.size();
            com_tencent_mm_protocal_c_btb.wIS = this.hXZ;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            Iterator it = com_tencent_mm_protocal_c_btb.wUf.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((bdo) it.next()).wJF).append(", ");
            }
            stringBuilder.append("]");
            x.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
            return a(eVar, JZ, this);
        }
        int i;
        iO.hYL = true;
        if (this.hXX) {
            iO.hYM = true;
            com_tencent_mm_protocal_c_btb.vXz = new bdn();
            x.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.hXY > this.hYb) {
                this.hXY = this.hYb;
                iO.hYM = false;
            } else if (this.hXY <= this.hYb && (iO.hYN != Integer.MAX_VALUE || this.hWy)) {
                iO.hYM = true;
            }
            com_tencent_mm_protocal_c_btb.vXz = new bdn().bj(com.tencent.mm.a.e.d(this.filename, this.hOX, this.hXY));
        }
        com_tencent_mm_protocal_c_btb.vNW = this.hOX;
        com_tencent_mm_protocal_c_btb.wRR = iO.hYK;
        if (iO.hYM) {
            i = 1;
        } else {
            i = 0;
        }
        com_tencent_mm_protocal_c_btb.vLj = i;
        com_tencent_mm_protocal_c_btb.wRT = 2;
        i = iO.hYO + 1;
        iO.hYO = i;
        com_tencent_mm_protocal_c_btb.vOI = i;
        com_tencent_mm_protocal_c_btb.wUf = this.hXV.UY();
        com_tencent_mm_protocal_c_btb.wUe = com_tencent_mm_protocal_c_btb.wUf == null ? 0 : com_tencent_mm_protocal_c_btb.wUf.size();
        com_tencent_mm_protocal_c_btb.wIS = this.hXZ;
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s", com.tencent.mm.compatible.util.g.zh(), this.filename, Integer.valueOf(iO.hYN), Integer.valueOf(this.hOX), Integer.valueOf(this.hXY), Integer.valueOf(com_tencent_mm_protocal_c_btb.vXz.wJB), Boolean.valueOf(iO.hYM), Integer.valueOf(com_tencent_mm_protocal_c_btb.vOI), com_tencent_mm_protocal_c_btb.wUf, com_tencent_mm_protocal_c_btb.wIS);
        this.hOX = com_tencent_mm_protocal_c_btb.vXz.wJB + this.hOX;
        x.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", iO.hYK, Integer.valueOf(this.hOX));
        if (iO.hYO == 1) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", Long.valueOf(System.currentTimeMillis()));
        }
        x.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", Long.valueOf(System.currentTimeMillis()));
        return a(eVar, JZ, this);
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    }

    protected final void a(a aVar) {
        x.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zh() + " setSecurityCheckError e: %s", aVar);
        if (aVar == a.EReachMaxLimit) {
            UQ();
            this.gJT.a(3, -1, "SecurityCheckError", this);
        }
    }

    protected final boolean Kf() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", com.tencent.mm.compatible.util.g.zh(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 3 && i3 == -1) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", bh.cgy(), Long.valueOf(Thread.currentThread().getId()));
        }
        btb com_tencent_mm_protocal_c_btb = (btb) ((com.tencent.mm.ae.b) qVar).hmg.hmo;
        btd com_tencent_mm_protocal_c_btd = (btd) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", com_tencent_mm_protocal_c_btb.wRR, Integer.valueOf(com_tencent_mm_protocal_c_btb.vOI), Long.valueOf(System.currentTimeMillis()));
            this.hXV.X(com_tencent_mm_protocal_c_btd.wUj);
            if (this.hXV.UZ() && this.hWy) {
                x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                UR();
            }
            this.hYa = new String[]{this.hXV.getResult()};
            this.gJT.a(i2, i3, str, this);
            this.hYb = com_tencent_mm_protocal_c_btd.wUk <= 0 ? this.hYb : com_tencent_mm_protocal_c_btd.wUk;
            this.hXU = com_tencent_mm_protocal_c_btd.wHb < 0 ? 120 : com_tencent_mm_protocal_c_btd.wHb;
            x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", Integer.valueOf(this.hYb), Integer.valueOf(this.hXU));
            return;
        }
        x.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zh() + " onGYNetEnd file: %s errType:%s errCode:%s", this.filename, Integer.valueOf(i2), Integer.valueOf(i3));
        UQ();
        this.gJT.a(i2, i3, str, this);
    }

    public final void UQ() {
        x.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zh());
        if (!this.hXX) {
            this.hXX = true;
            UR();
            n CG = g.CG();
            x.k("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(hashCode()));
            CG.hmW.F(new AnonymousClass4(CG, r1));
            a iO = this.hXV.iO(this.hOX);
            if (iO != null) {
                this.hXY = 0;
                g.Dm().F(new 1(this, iO));
            }
        }
    }

    private void UR() {
        x.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zh());
        if (this.hYc != null) {
            this.hYc.removeMessages(JsApiCreateAudioInstance.CTRL_INDEX);
        }
        this.hXW = true;
    }

    public final int getType() {
        return 235;
    }

    public final void iN(int i) {
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", com.tencent.mm.compatible.util.g.zh(), Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException();
        }
        this.hXV.iN(i);
    }
}
