package com.tencent.mm.bg;

import com.tencent.mm.ae.k;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.qqpinyin.voicerecoapi.c$a;

public final class e implements com.tencent.mm.ae.e {
    public static int fmh = 100;
    private static final String hYm = (w.gZK + "tmp_voiceaddr.spx");
    private static final String hYn = (w.gZK + "tmp_voiceaddr.amr");
    private a fkK = new a(this) {
        final /* synthetic */ e hYx;

        {
            this.hYx = r1;
        }

        public final void q(byte[] bArr, int i) {
            int i2;
            x.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", new Object[]{Integer.valueOf(i)});
            c$a com_tencent_qqpinyin_voicerecoapi_c_a = new c$a();
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            if (this.hYx.hYv != null) {
                this.hYx.hYv.a(sArr, i / 2, com_tencent_qqpinyin_voicerecoapi_c_a);
            }
            e.a(this.hYx, sArr, i / 2);
            if (this.hYx.hYu != null) {
                i2 = this.hYx.hYu.a(new g.a(bArr, i), 0);
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                this.hYx.finish();
                x.e("MicroMsg.SceneVoiceAddr", "write to file failed");
                return;
            }
            e eVar = this.hYx;
            eVar.hYp = i2 + eVar.hYp;
            if (this.hYx.hYp > 3300 && !this.hYx.hYq) {
                x.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
                this.hYx.handler.sendEmptyMessage(0);
                this.hYx.hYq = true;
            }
            if (com_tencent_qqpinyin_voicerecoapi_c_a.zQR == 2 || com_tencent_qqpinyin_voicerecoapi_c_a.zQR == 3) {
                x.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + com_tencent_qqpinyin_voicerecoapi_c_a.zQR);
                this.hYx.finish();
            }
        }

        public final void aK(int i, int i2) {
        }
    };
    c fkb;
    public int hYh = 1;
    public int hYo = 0;
    int hYp = 0;
    boolean hYq = false;
    private int hYr = 500000;
    public boolean hYs = false;
    b hYt = null;
    com.tencent.mm.e.c.a hYu;
    com.tencent.qqpinyin.voicerecoapi.c hYv = null;
    private a hYw = null;
    af handler = new 2(this);

    static /* synthetic */ void a(e eVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > eVar.hYo) {
                eVar.hYo = s;
            }
        }
    }

    static /* synthetic */ String d(e eVar) {
        return !eVar.hYs ? hYm : hYn;
    }

    public e(b bVar, int i) {
        int i2 = 500000;
        this.hYt = bVar;
        this.hYh = i;
        if (this.hYh != 1) {
            i2 = 1500000;
        }
        this.hYr = i2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.hYh == 0) {
            x.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            com.tencent.mm.kernel.g.CG().b(349, this);
        } else {
            com.tencent.mm.kernel.g.CG().b(b.CTRL_INDEX, this);
        }
        String[] UM = ((a) kVar).UM();
        long UN = ((a) kVar).UN();
        String str2 = "MicroMsg.SceneVoiceAddr";
        String str3 = "onSceneEnd errType:%d errCode:%d list:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(UM == null ? -1 : UM.length);
        x.i(str2, str3, objArr);
        if (this.hYt == null) {
            return;
        }
        if (i2 == 0 && i == 0) {
            this.hYt.a(UM, UN);
            return;
        }
        this.hYt.US();
        cancel();
    }

    private void finish() {
        x.i("MicroMsg.SceneVoiceAddr", "finish");
        x.k("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.hYw != null) {
            this.hYw.UL();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.hYq) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
    }

    public final void cancel() {
        this.hYt = null;
        finish();
    }

    private void reset() {
        x.i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            if (this.fkb != null) {
                this.fkb.vi();
                this.fkb = null;
            }
            if (this.hYu != null) {
                this.hYu.vE();
                this.hYu = null;
            }
            if (this.hYv != null) {
                this.hYv.stop();
            }
            this.hYv = null;
            if (this.hYw != null) {
                this.hYw.UL();
                this.hYw = null;
            }
            this.hYp = 0;
            this.hYq = false;
        }
    }
}
