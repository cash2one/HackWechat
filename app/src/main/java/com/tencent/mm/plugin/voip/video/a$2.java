package com.tencent.mm.plugin.voip.video;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements PreviewCallback {
    final /* synthetic */ a sto;

    a$2(a aVar) {
        this.sto = aVar;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null || bArr.length <= 0) {
            g.pQN.a(159, 0, 1, false);
            g.pQN.a(159, 3, 1, false);
            if (this.sto.stc != null) {
                this.sto.stc.bdd();
            }
        } else if (this.sto.ssV == null) {
            x.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
        } else if (this.sto.stc != null) {
            int i;
            boolean z;
            int i2;
            int i3;
            boolean z2;
            int i4;
            if (this.sto.ssL) {
                i4 = i.suT;
                if (q.gFU.gDW && q.gFU.gDV.fFy != 0) {
                    i = q.gFU.gDV.gEz;
                    z = true;
                    i2 = i4;
                }
                z = false;
                i = 1;
                i2 = i4;
            } else {
                i4 = i.suU;
                if (q.gFU.gDY && q.gFU.gDX.fFy != 0) {
                    i = q.gFU.gDX.gEz;
                    z = true;
                    i2 = i4;
                }
                z = false;
                i = 1;
                i2 = i4;
            }
            if (i2 > 0) {
                i3 = 32;
            } else {
                i3 = 0;
            }
            a aVar = this.sto;
            if (z || i2 <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            aVar.ssM = z2;
            i2 = this.sto.ssV.width;
            int i5 = this.sto.ssV.height;
            if (z) {
                if (this.sto.stf == null) {
                    this.sto.stf = new byte[(((i2 * i5) * 3) / 2)];
                    this.sto.stf[0] = (byte) 90;
                }
                m bGj = d.bGj();
                int length = bArr.length;
                int i6 = this.sto.ssW;
                byte[] bArr2 = this.sto.stf;
                int length2 = this.sto.stf.length;
                com.tencent.mm.plugin.voip.model.g gVar = bGj.smS.siL.skg;
                if (gVar.skA != com.tencent.mm.plugin.voip.model.g.skz && gVar.siL.ske.oxo && gVar.siL.bGv()) {
                    gVar.siL.ske.videoRorate90D(bArr, length, i2, i5, i6, bArr2, length2, i2, i5, i);
                }
                this.sto.stc.c(this.sto.stf, (long) this.sto.stf.length, i2, i5, this.sto.ssW + i3);
            } else {
                this.sto.stc.c(bArr, (long) bArr.length, this.sto.ssV.width, this.sto.ssV.height, this.sto.ssW + i3);
            }
            if (com.tencent.mm.plugin.voip.b.d.bIn() >= 8) {
                this.sto.ssT.addCallbackBuffer(bArr);
            }
        }
    }
}
