package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

public final class e extends k implements com.tencent.mm.network.k {
    int fCR = 0;
    private boolean fmO = false;
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    private oa pPX = null;
    private a pPY = new a();

    public e(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data must not be null");
        }
        this.fCR = i;
        g.Dh();
        this.fmO = a.Cx();
        if (i == 1) {
            try {
                i iVar = new i();
                iVar.aF(bArr);
                this.pPX = SmcProtoBufUtil.toMMReportKvReq(iVar);
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.Dk();
                g.Dm().F(new 1(this));
            }
        } else if (i == 2) {
            try {
                com.tencent.mm.protocal.a.a.g gVar = new com.tencent.mm.protocal.a.a.g();
                gVar.aF(bArr);
                this.pPX = SmcProtoBufUtil.toMMReportIdkeyReq(gVar);
            } catch (Exception e2) {
                x.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.Dk();
                g.Dm().F(new Runnable(this) {
                    final /* synthetic */ e pPZ;

                    {
                        this.pPZ = r1;
                    }

                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, this.pPZ.fCR);
                    }
                });
            }
        }
        if (this.pPX != null) {
            this.pPX.vWQ = new akc();
            this.pPX.vWQ.wrm = this.pPY.vx(this.fCR);
            return;
        }
        x.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", bh.cgy());
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (g.Di().gPJ == null || g.Di().gPJ.hmV == null) {
            x.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.gJT.a(i2, i3, str, this);
        } else if (i2 != 0) {
            x.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnReportResp(i2, i3, null, this.fCR);
            this.gJT.a(i2, i3, str, this);
        } else {
            x.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.fCR);
            ob obVar = (ob) this.gJQ.hmh.hmo;
            this.pPY.a(obVar.vXa, this.fCR);
            try {
                if (this.fCR == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(obVar).toByteArray(), this.fCR);
                } else if (this.fCR == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(obVar).toByteArray(), this.fCR);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bh.i(e));
            }
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return !this.fmO ? 1 == this.fCR ? TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR : 987 : 1 == this.fCR ? TbsLog.TBSLOG_CODE_SDK_SELF_MODE : 986;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        if (this.pPX == null) {
            x.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
            return -2;
        }
        if (!this.fmO) {
            this.pPX.vWP = com.tencent.mm.bq.b.bc(bh.cgp());
        }
        b.a aVar = new b.a();
        aVar.hmn = false;
        aVar.hmj = this.pPX;
        aVar.hmk = new ob();
        String str = 1 == this.fCR ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.fCR ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.fmO) {
            str = str2;
        }
        aVar.uri = str;
        aVar.hmi = getType();
        this.gJQ = aVar.JZ();
        if (!this.fmO) {
            this.gJQ.a(ac.cdM());
            this.gJQ.fJZ = 1;
        }
        int a = a(eVar, this.gJQ, this);
        if (a >= 0) {
            return a;
        }
        x.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", Integer.valueOf(a));
        try {
            SmcLogic.OnReportResp(3, -1, null, this.fCR);
            return a;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bh.i(e));
            return a;
        }
    }
}
