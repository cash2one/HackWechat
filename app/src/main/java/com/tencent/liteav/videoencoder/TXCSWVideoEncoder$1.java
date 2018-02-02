package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.d.c.a;

class TXCSWVideoEncoder$1 implements a {
    final /* synthetic */ int[] a;
    final /* synthetic */ int b;
    final /* synthetic */ TXCSWVideoEncoder c;

    TXCSWVideoEncoder$1(TXCSWVideoEncoder tXCSWVideoEncoder, int[] iArr, int i) {
        this.c = tXCSWVideoEncoder;
        this.a = iArr;
        this.b = i;
    }

    public void a(int i) {
        this.a[0] = TXCSWVideoEncoder.access$200(this.c, TXCSWVideoEncoder.access$000(this.c), this.b, this.c.mOutputWidth, this.c.mOutputHeight, TXCSWVideoEncoder.access$100(this.c));
    }
}
