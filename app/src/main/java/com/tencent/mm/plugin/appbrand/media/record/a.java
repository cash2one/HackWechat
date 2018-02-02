package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public int aef = 0;
    public c fkb = null;
    public int fky = -1;
    public RecordParam jAq;
    public long jAr = 0;
    public a jAs;
    public com.tencent.mm.e.b.c.a jAt = new com.tencent.mm.e.b.c.a(this) {
        final /* synthetic */ a jAu;

        {
            this.jAu = r1;
        }

        public final void q(byte[] bArr, int i) {
            x.i("MicroMsg.AppBrandRecorder", "onRecPcmDataReady()");
            if (this.jAu.jAs != null) {
                this.jAu.jAs.q(bArr, i);
            }
        }

        public final void aK(int i, int i2) {
            x.e("MicroMsg.AppBrandRecorder", "state:%d, detailState:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.jAu.jAs != null) {
                this.jAu.jAs.aK(i, i2);
            }
        }
    };
    public int sampleRate = 0;

    public interface a {
        void aK(int i, int i2);

        void q(byte[] bArr, int i);
    }

    public a(RecordParam recordParam) {
        if (recordParam == null) {
            recordParam = new RecordParam();
        }
        this.sampleRate = recordParam.sampleRate;
        this.aef = recordParam.jAv;
        this.fky = recordParam.scene;
        this.jAq = recordParam;
    }

    public final boolean vi() {
        boolean vi;
        x.i("MicroMsg.AppBrandRecorder", JsApiStopRecordVoice.NAME);
        if (this.fkb != null) {
            vi = this.fkb.vi();
        } else {
            vi = false;
        }
        this.jAr -= System.currentTimeMillis();
        x.i("MicroMsg.AppBrandRecorder", "stop time ticket:%d, costTimeInMs:%d", new Object[]{Long.valueOf(r2), Long.valueOf(this.jAr)});
        return vi;
    }
}
