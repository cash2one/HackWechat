package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.talkroom.component.d.a;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private c fkb;
    private c.a flb = new c.a(this) {
        final /* synthetic */ f sau;

        {
            this.sau = r1;
        }

        public final void q(byte[] bArr, int i) {
            x.d("MicroMsg.MicRecoder", "pcm len: " + i);
            if (i <= 0) {
                x.e("MicroMsg.MicRecoder", "pcm data too low");
                return;
            }
            f.a(this.sau, bArr, i);
            int Send = this.sau.sar.Send(bArr, (short) i);
            if (Send < 0) {
                x.e("MicroMsg.MicRecoder", "send failed, ret: " + Send);
            }
        }

        public final void aK(int i, int i2) {
        }
    };
    private v2engine sar;
    private short sas;
    private short sat;

    static /* synthetic */ void a(f fVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > fVar.sas) {
                fVar.sas = s;
            }
        }
    }

    public f(v2engine com_tencent_mm_plugin_talkroom_component_v2engine) {
        this.sar = com_tencent_mm_plugin_talkroom_component_v2engine;
    }

    public final void bEx() {
        if (this.fkb != null) {
            this.fkb.vi();
            this.fkb = null;
        }
    }

    public final void bEy() {
        this.fkb = new c(com.tencent.mm.plugin.talkroom.model.a.saG, 1, 2);
        this.fkb.n(8, false);
        this.fkb.fkK = this.flb;
        this.fkb.et(20);
        this.fkb.vr();
        this.sat = (short) 0;
        this.sas = (short) 0;
    }

    public final int bEz() {
        if (this.sat < this.sas) {
            this.sat = this.sas;
        }
        if (this.sat == (short) 0) {
            return 0;
        }
        short s = (short) ((this.sas * 100) / this.sat);
        this.sas = (short) 0;
        return s;
    }

    public final void start() {
    }

    public final void release() {
        bEx();
    }
}
