package com.tencent.mm.ae;

import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bir;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bh;

public final class b extends i {
    public int fJZ;
    public b hmg;
    public c hmh;
    public int hmi;
    public String uri;

    public static class a {
        public int hmi = 113;
        public com.tencent.mm.bq.a hmj;
        public com.tencent.mm.bq.a hmk;
        public int hml = 35;
        public int hmm = 1000000035;
        public boolean hmn = true;
        public String uri;

        public final void a(com.tencent.mm.bq.a aVar) {
            this.hmj = aVar;
        }

        public final void b(com.tencent.mm.bq.a aVar) {
            this.hmk = aVar;
        }

        public final void jo(String str) {
            this.uri = str;
        }

        public final void hh(int i) {
            this.hmi = x.CTRL_INDEX;
        }

        public final void hi(int i) {
            this.hml = com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX;
        }

        public final void hj(int i) {
            this.hmm = 1000000209;
        }

        public final b JZ() {
            if (this.hmj != null && this.hmk != null && !bh.ov(this.uri) && this.hmi > 0 && this.hml != Integer.MIN_VALUE && this.hmm != Integer.MIN_VALUE) {
                return new b(this.hmj, this.hmk, this.uri, this.hmi, this.hml, this.hmm, this.hmn);
            }
            throw new IllegalArgumentException();
        }
    }

    public static final class b extends d implements com.tencent.mm.protocal.k.b {
        public int cmdId;
        private int hmi;
        public com.tencent.mm.bq.a hmo;
        private boolean hmp;

        public b(com.tencent.mm.bq.a aVar, int i, int i2, boolean z) {
            this.hmo = aVar;
            this.hmi = i;
            this.cmdId = i2;
            this.hmp = z;
        }

        public final int getCmdId() {
            return this.cmdId;
        }

        public final int Hr() {
            return this.hmi;
        }

        public final byte[] Hq() {
            if (this.hmo instanceof bcv) {
                ((bcv) this.hmo).wIV = k.a(this);
            }
            return this.hmo.toByteArray();
        }
    }

    public static final class c extends e implements com.tencent.mm.protocal.k.c {
        public int cmdId;
        public com.tencent.mm.bq.a hmo = null;
        private boolean hmp;

        public c(com.tencent.mm.bq.a aVar, int i, boolean z) {
            this.hmo = aVar;
            this.cmdId = i;
            this.hmp = z;
        }

        public final int E(byte[] bArr) {
            this.hmo = this.hmo.aF(bArr);
            if (this.hmo instanceof bir) {
                return ((bir) this.hmo).getRet();
            }
            k.a(this, ((bdf) this.hmo).wJr);
            return ((bdf) this.hmo).wJr.vJU;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    protected final /* bridge */ /* synthetic */ d Ho() {
        return this.hmg;
    }

    public final /* bridge */ /* synthetic */ e Hp() {
        return this.hmh;
    }

    private b(com.tencent.mm.bq.a aVar, com.tencent.mm.bq.a aVar2, String str, int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        this.hmg = null;
        this.hmh = null;
        this.fJZ = 0;
        if (z && (aVar instanceof bcv)) {
            z2 = true;
        }
        this.hmg = new b(aVar, i, i2, z2);
        this.hmh = new c(aVar2, i3, z);
        this.uri = str;
        this.hmi = i;
    }

    public final com.tencent.mm.bq.a JW() {
        return this.hmg.hmo;
    }

    public final com.tencent.mm.bq.a JX() {
        return this.hmh.hmo;
    }

    public final int getType() {
        return this.hmi;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void a(ac acVar) {
        this.hmg.vBn = acVar;
    }

    public final int JY() {
        return this.fJZ;
    }
}
