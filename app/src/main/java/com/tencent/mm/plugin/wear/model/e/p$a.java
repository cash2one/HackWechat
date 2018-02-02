package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.f.c;
import com.tencent.mm.protocal.c.bzm;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

class p$a extends c {
    public int pSO;
    final /* synthetic */ p tiZ;
    public int tio = 2;
    public int tip;
    public bzm tja;

    public p$a(p pVar, int i, bzm com_tencent_mm_protocal_c_bzm) {
        this.tiZ = pVar;
        this.pSO = i;
        this.tip = CdnLogic.kMediaLittleAppPacket;
        this.tja = com_tencent_mm_protocal_c_bzm;
    }

    protected final void send() {
        try {
            byte[] aX = a.bOt().thH.aX(this.tja.toByteArray());
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this.tio);
                dataOutputStream.writeInt(this.pSO);
                dataOutputStream.writeInt(this.tip);
                if (aX == null || aX.length <= 0) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(aX.length);
                    dataOutputStream.write(aX);
                }
                aX = byteArrayOutputStream.toByteArray();
                x.i("MicroMsg.Wear.VoiceToTextServer", "send data funId=%d length=%d", Integer.valueOf(this.tip), Integer.valueOf(aX.length));
                a.bOt().thH.aV(byteArrayOutputStream.toByteArray());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(this.tio), Integer.valueOf(this.pSO), Integer.valueOf(this.tip));
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e2, "", new Object[0]);
        }
    }

    public final String getName() {
        return "WearVoiceToTextTask";
    }
}
