package com.tencent.mm.modelvoice;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.am;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e extends k implements com.tencent.mm.network.k {
    private static am hWw = null;
    private static List<c> hWx = new ArrayList();
    private String fDC;
    public String fileName;
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    private String hWv;
    private boolean hWy = false;
    private boolean hWz = false;
    private ak hkO = new ak(new 2(this), false);
    public int retCode = 0;

    public static void a(am amVar) {
        if (hWw == null) {
            hWw = amVar;
        }
    }

    public static void a(c cVar) {
        if (!hWx.contains(cVar)) {
            hWx.add(cVar);
        }
    }

    public static void b(c cVar) {
        hWx.remove(cVar);
    }

    private void doNotify() {
        final au ob = q.ob(this.fileName);
        if (ob != null) {
            if (hWw != null) {
                hWw.a(ob);
            }
            for (final c cVar : hWx) {
                ag.y(new Runnable(this) {
                    final /* synthetic */ e hWB;

                    public final void run() {
                        cVar.A(ob);
                    }
                });
            }
        }
    }

    public e(p pVar) {
        boolean z;
        Assert.assertTrue(pVar != null);
        this.fileName = pVar.fileName;
        if (this.fileName != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.hWv = pVar.hWv;
        this.fDC = pVar.fDC;
        x.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", new Object[]{this.fileName, this.hWv, this.fDC});
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        if (this.fileName == null) {
            x.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        p oc = q.oc(this.fileName);
        if (oc == null || !oc.UG()) {
            x.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
            this.retCode = g.getLine() + 10000;
            return -1;
        }
        x.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + oc.hVJ);
        if (q.nS(this.fileName)) {
            int i = oc.hUp - oc.hVB;
            if (i > 0) {
                if (oc.hlp == oc.hUp) {
                    this.hWy = true;
                }
                a aVar = new a();
                aVar.hmj = new rm();
                aVar.hmk = new rn();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvoice";
                aVar.hmi = FileUtils.S_IWUSR;
                aVar.hml = 20;
                aVar.hmm = 1000000020;
                this.gJQ = aVar.JZ();
                rm rmVar = (rm) this.gJQ.hmg.hmo;
                rmVar.vHU = oc.clientId;
                rmVar.vHe = oc.fFo;
                rmVar.vZw = i;
                rmVar.vNW = oc.hVB;
                if (s.eV(this.fDC)) {
                    rmVar.vYJ = this.fDC;
                    rmVar.vZx = oc.hXD;
                }
                x.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[]{rmVar.vHU, Integer.valueOf(rmVar.vGW), Long.valueOf(rmVar.vHe), Integer.valueOf(rmVar.vZw), Integer.valueOf(rmVar.vNW), rmVar.vYJ, Long.valueOf(rmVar.vZx)});
                return a(eVar, this.gJQ, this);
            } else if (oc.status == 5) {
                this.hWz = true;
                x.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + oc.hUp + " Local:" + oc.hVB);
                this.retCode = g.getLine() + 10000;
                return -1;
            } else {
                q.a(this.fileName, oc.hVB, null);
                this.retCode = g.getLine() + 10000;
                return -1;
            }
        }
        x.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
        q.ny(this.fileName);
        this.retCode = g.getLine() + 10000;
        return -1;
    }

    protected final int a(q qVar) {
        rm rmVar = (rm) ((b) qVar).hmg.hmo;
        if (rmVar.vHe != 0 && rmVar.vHU != null && rmVar.vHU.length() != 0 && rmVar.vZw > 0 && rmVar.vNW >= 0) {
            return k.b.hmP;
        }
        q.ny(this.fileName);
        return k.b.hmQ;
    }

    protected final int Bh() {
        return 100;
    }

    protected final void a(k.a aVar) {
        com.tencent.mm.plugin.report.service.g.pQN.a(111, 233, 1, false);
        q.ny(this.fileName);
    }

    public final boolean Ke() {
        boolean Ke = super.Ke();
        if (Ke) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 232, 1, false);
        }
        return Ke;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        rn rnVar = (rn) ((b) qVar).hmh.hmo;
        if (rnVar.vZz == 1) {
            x.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
            q.nX(this.fileName);
        } else if (i3 == -22) {
            q.ny(this.fileName);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 231, 1, false);
            q.ny(this.fileName);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + rnVar.vXz.wJB + " fileOff:" + rnVar.vNW);
            if (rnVar.vXz.wJD == null) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                q.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
                return;
            }
            byte[] toByteArray = rnVar.vXz.wJD.toByteArray();
            if (toByteArray.length == 0) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                q.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
                return;
            }
            int write = q.ay(this.hWv, this.fileName).write(toByteArray, toByteArray.length, rnVar.vNW);
            if (write < 0) {
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + write);
                q.ny(this.fileName);
                this.gJT.a(i2, i3, str, this);
                return;
            }
            q.c(this.fileName, toByteArray, toByteArray.length);
            x.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + write + " voiceFormat:" + this.hWv);
            write = q.a(this.fileName, write, null);
            if (write < 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(111, 229, 1, false);
                x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + write);
                this.gJT.a(i2, i3, str, this);
            } else if (write == 1) {
                doNotify();
                this.gJT.a(i2, i3, str, this);
            } else {
                long j = 1000;
                if (this.hWy) {
                    j = 0;
                }
                this.hkO.J(j, j);
            }
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(111, 230, 1, false);
            x.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " resp:" + qVar.Hp().vBp);
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return FileUtils.S_IWUSR;
    }
}
