package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.e.b.g;
import com.tencent.mm.e.c.d;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.protocal.c.bzl;
import com.tencent.mm.protocal.c.bzm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.qqpinyin.voicerecoapi.c$a;
import java.util.LinkedList;

public final class p implements e {
    public static final String tiS = (w.gZK + "tmp_wearvoicetotext.spx");
    public boolean fLH = false;
    public LinkedList<Integer> iRf = new LinkedList();
    public c tiT;
    public com.tencent.qqpinyin.voicerecoapi.c tiU;
    public d tiV;
    private int tiW = 0;
    public int tiX;
    public int tiY;

    public final void reset() {
        x.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", new Object[]{Integer.valueOf(this.tiX)});
        if (this.tiV != null) {
            this.tiV.vE();
            this.tiV = null;
            x.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.tiU != null) {
            this.tiU.stop();
            this.tiU = null;
            x.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.tiT != null) {
            this.tiT.hWy = true;
            ar.CG().b(349, this);
            ar.CG().c(this.tiT);
            this.tiT = null;
        }
        this.tiY = 0;
        this.fLH = false;
        this.tiW = 0;
        this.tiX = -1;
        this.iRf.clear();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            bzm com_tencent_mm_protocal_c_bzm;
            if (i != 0 || i2 != 0) {
                ar.CG().b(349, this);
                com_tencent_mm_protocal_c_bzm = new bzm();
                com_tencent_mm_protocal_c_bzm.wYG = cVar.talker;
                com_tencent_mm_protocal_c_bzm.weY = "";
                com_tencent_mm_protocal_c_bzm.vEe = -1;
                com_tencent_mm_protocal_c_bzm.wZk = false;
                a.bOt().thN.a(new a(this, cVar.pSO, com_tencent_mm_protocal_c_bzm));
            } else if (cVar.tiJ) {
                ar.CG().b(349, this);
                com_tencent_mm_protocal_c_bzm = new bzm();
                com_tencent_mm_protocal_c_bzm.wYG = cVar.talker;
                if (bh.ov(cVar.tiI)) {
                    com_tencent_mm_protocal_c_bzm.weY = "";
                    com_tencent_mm_protocal_c_bzm.vEe = -1;
                    com_tencent_mm_protocal_c_bzm.wZk = false;
                } else {
                    x.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", new Object[]{cVar.tiI});
                    com_tencent_mm_protocal_c_bzm.weY = cVar.tiI;
                    com_tencent_mm_protocal_c_bzm.vEe = 0;
                    com_tencent_mm_protocal_c_bzm.wZk = true;
                }
                a.bOt().thN.a(new a(this, cVar.pSO, com_tencent_mm_protocal_c_bzm));
            }
        }
    }

    public final void a(int i, bzl com_tencent_mm_protocal_c_bzl) {
        if (com_tencent_mm_protocal_c_bzl.vIA == null) {
            x.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            return;
        }
        byte[] toByteArray = com_tencent_mm_protocal_c_bzl.vIA.toByteArray();
        this.tiW += this.tiV.a(new g.a(toByteArray, com_tencent_mm_protocal_c_bzl.vZw), 0, false);
        x.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", new Object[]{Integer.valueOf(this.tiW)});
        short[] sArr = new short[(com_tencent_mm_protocal_c_bzl.vZw / 2)];
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bzl.vZw / 2; i2++) {
            sArr[i2] = (short) ((toByteArray[i2 * 2] & 255) | (toByteArray[(i2 * 2) + 1] << 8));
        }
        c$a com_tencent_qqpinyin_voicerecoapi_c_a = new c$a();
        this.tiU.a(sArr, com_tencent_mm_protocal_c_bzl.vZw / 2, com_tencent_qqpinyin_voicerecoapi_c_a);
        x.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + com_tencent_qqpinyin_voicerecoapi_c_a.zQR);
        if (com_tencent_qqpinyin_voicerecoapi_c_a.zQR == 2) {
            this.tiY = 1;
        } else if (com_tencent_qqpinyin_voicerecoapi_c_a.zQR == 3) {
            this.tiY = 2;
        }
        if (this.tiY != 0) {
            if (this.tiY < 0) {
                if (this.iRf.size() > 10) {
                    this.iRf.removeLast();
                }
                this.iRf.addFirst(Integer.valueOf(i));
            }
            if (this.tiY == 1) {
                bzm com_tencent_mm_protocal_c_bzm = new bzm();
                com_tencent_mm_protocal_c_bzm.wYG = this.tiT.talker;
                com_tencent_mm_protocal_c_bzm.weY = "";
                com_tencent_mm_protocal_c_bzm.vEe = this.tiY;
                com_tencent_mm_protocal_c_bzm.wZk = true;
                a.bOt().thN.a(new a(this, this.tiT.pSO, com_tencent_mm_protocal_c_bzm));
                this.tiY = 0;
            }
        }
        if (!this.fLH && this.tiW > 3300) {
            this.fLH = true;
            ar.CG().a(this.tiT, 0);
        }
    }
}
