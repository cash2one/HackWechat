package com.tencent.mm.plugin.wear.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.bzl;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.qqpinyin.voicerecoapi.c;
import java.io.IOException;

class WearMessageLogic$b extends d {
    public int pSO;
    public int tio;
    public int tip;
    public byte[] tiq;
    final /* synthetic */ WearMessageLogic tir;

    private WearMessageLogic$b(WearMessageLogic wearMessageLogic) {
        this.tir = wearMessageLogic;
    }

    protected final void execute() {
        switch (this.tip) {
            case CdnLogic.kMediaLittleAppPacket /*30001*/:
                p pVar = a.bOt().thH.tia;
                int i = this.pSO;
                byte[] bArr = this.tiq;
                if (!pVar.iRf.contains(Integer.valueOf(i))) {
                    bzl com_tencent_mm_protocal_c_bzl = new bzl();
                    try {
                        com_tencent_mm_protocal_c_bzl.aF(bArr);
                    } catch (IOException e) {
                    }
                    if (pVar.tiX != i) {
                        pVar.reset();
                        pVar.tiX = i;
                        x.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[]{Integer.valueOf(pVar.tiX)});
                        b.deleteFile(p.tiS);
                        if (pVar.tiV == null) {
                            pVar.tiV = new com.tencent.mm.e.c.d();
                            pVar.tiV.cL(p.tiS);
                        }
                        if (pVar.tiU == null) {
                            pVar.tiU = new c(1500000);
                            if (pVar.tiU.start() != 0) {
                                pVar.tiY = -2;
                                return;
                            }
                        }
                        String str = com_tencent_mm_protocal_c_bzl.wYG;
                        if (pVar.tiT == null) {
                            ag.y(new p$1(pVar, str));
                        }
                        pVar.a(i, com_tencent_mm_protocal_c_bzl);
                        return;
                    } else if (com_tencent_mm_protocal_c_bzl.wZj) {
                        x.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[]{Integer.valueOf(i)});
                        pVar.reset();
                        return;
                    } else if (com_tencent_mm_protocal_c_bzl.wZi) {
                        pVar.a(i, com_tencent_mm_protocal_c_bzl);
                        if (pVar.tiV != null) {
                            pVar.tiV.vE();
                            pVar.tiV = null;
                            x.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                        }
                        if (pVar.tiU != null) {
                            pVar.tiU.stop();
                            pVar.tiU = null;
                            x.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                        }
                        if (pVar.tiT != null) {
                            pVar.tiT.hWy = true;
                            if (!pVar.fLH) {
                                ar.CG().a(pVar.tiT, 0);
                            }
                            pVar.tiT = null;
                            x.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                            return;
                        }
                        return;
                    } else {
                        pVar.a(i, com_tencent_mm_protocal_c_bzl);
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final String getName() {
        return "LongConnectTask";
    }
}
