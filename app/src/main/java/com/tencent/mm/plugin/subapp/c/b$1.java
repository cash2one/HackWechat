package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b rWh;

    b$1(b bVar) {
        this.rWh = bVar;
    }

    public final boolean uF() {
        g Mk = h.Mk(this.rWh.fileName);
        if (Mk == null || !Mk.UH()) {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.rWh.fileName);
            this.rWh.retCode = g.getLine() + 10000;
            this.rWh.gJT.a(3, -1, "doScene failed", this.rWh);
            return false;
        }
        if (!(3 == Mk.field_status || 8 == Mk.field_status)) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis / 1000) - Mk.field_lastmodifytime > 30) {
                x.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + this.rWh.fileName);
                this.rWh.retCode = g.getLine() + 10000;
                this.rWh.gJT.a(3, -1, "doScene failed", this.rWh);
                return false;
            } else if (currentTimeMillis - this.rWh.hWD < 2000) {
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + this.rWh.fileName + " but last send time:" + (currentTimeMillis - this.rWh.hWD));
                return true;
            } else {
                c.a yf = h.Ml(this.rWh.fileName).yf(Mk.field_offset);
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + this.rWh.fileName + " readByte:" + yf.flp + " stat:" + Mk.field_status);
                if (yf.flp < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    return true;
                }
            }
        }
        if (this.rWh.a(this.rWh.hmA, this.rWh.gJT) != -1) {
            return false;
        }
        this.rWh.retCode = g.getLine() + 10000;
        this.rWh.gJT.a(3, -1, "doScene failed", this.rWh);
        return false;
    }
}
