package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.buq;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public v2protocal nEG = new v2protocal(this.nEH);
    private af nEH = new 1(this, Looper.getMainLooper());
    private boolean nEI = false;
    public boolean nEJ = false;
    public boolean nEK = false;
    public a nEL = null;

    static /* synthetic */ void a(a aVar, int i) {
        x.d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (aVar.nEL != null) {
            aVar.nEL.rp(i);
        }
    }

    public final void aTS() {
        x.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.nEJ) {
            x.d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.nEG.setActive();
    }

    public final void aTT() {
        if (this.nEI) {
            x.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            return;
        }
        x.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        c cVar = i.aTx().nCP;
        if (cVar != null) {
            if (cVar.klN != null) {
                bth X = com.tencent.mm.plugin.ipcall.b.c.X(cVar.klN);
                bth X2 = com.tencent.mm.plugin.ipcall.b.c.X(cVar.nDV);
                buq com_tencent_mm_protocal_c_buq = new buq();
                com_tencent_mm_protocal_c_buq.wWd = 0;
                com_tencent_mm_protocal_c_buq.wWe = 0;
                com_tencent_mm_protocal_c_buq.wWf = 0;
                com_tencent_mm_protocal_c_buq.userName = "";
                com_tencent_mm_protocal_c_buq.mBX = "";
                this.nEG.a(X, X, X2, com_tencent_mm_protocal_c_buq);
            }
            x.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.nEG.soh = cVar.nDQ;
            this.nEG.spa = cVar.nDT;
            if (cVar.nDU != null) {
                this.nEG.spb = cVar.nDU.toByteArray();
            }
            if (cVar.nDR != null) {
                this.nEG.soi = cVar.nDR.toByteArray();
            }
            this.nEG.nDx = cVar.nDx;
            this.nEG.nDy = cVar.nDy;
            this.nEG.nDF = cVar.nDF;
            this.nEG.sok = cVar.nDO;
            this.nEG.soj = cVar.nDP;
            this.nEG.sol = cVar.nDW;
            int configInfo = this.nEG.setConfigInfo(this.nEG.soc, (long) this.nEG.nDx, this.nEG.nDF, this.nEG.nDy, this.nEG.field_peerId, 1, this.nEG.soj, this.nEG.sok, this.nEG.soh, this.nEG.soi == null ? 0 : this.nEG.soi.length, this.nEG.soi, this.nEG.sol, 0, 0, this.nEG.spa, this.nEG.spb, 255, 0);
            x.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", Integer.valueOf(configInfo));
            if (configInfo == 0) {
                configInfo = this.nEG.connectToPeer();
            }
            if (configInfo < 0) {
                x.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", Integer.valueOf(configInfo));
                if (this.nEL != null) {
                    this.nEL.rp(21);
                }
            }
            this.nEI = true;
        }
    }

    public final void ru(int i) {
        if (this.nEJ) {
            x.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", Integer.valueOf(i));
            if (this.nEG.SetDTMFPayload(i) < 0) {
                x.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", Integer.valueOf(this.nEG.SetDTMFPayload(i)));
            }
        }
    }

    public final void aTU() {
        this.nEJ = false;
        this.nEI = false;
        this.nEK = false;
    }
}
