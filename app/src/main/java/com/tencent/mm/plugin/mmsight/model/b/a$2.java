package com.tencent.mm.plugin.mmsight.model.b;

import com.tencent.mm.plugin.mmsight.model.b.d.a;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import java.nio.ByteBuffer;

class a$2 implements a {
    final /* synthetic */ a owI;

    a$2(a aVar) {
        this.owI = aVar;
    }

    public final void a(int i, ByteBuffer byteBuffer, int i2) {
        MP4MuxerJNI.writeH264Data(i, byteBuffer, i2);
    }
}
