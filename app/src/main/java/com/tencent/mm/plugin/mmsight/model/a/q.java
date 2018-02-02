package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class q extends r {
    protected int ouk = -1;

    public q(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i, i2, i3, i4, i5, i6, i7, z);
    }

    public final int cN(int i, int i2) {
        this.ouk = i;
        return super.cN(i, i2);
    }

    protected final void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.ouk >= 0 && byteBuffer != null && bufferInfo != null) {
            long Wq = bh.Wq();
            SightVideoJNI.writeH264Data(this.ouk, byteBuffer, bufferInfo.size);
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s", new Object[]{Long.valueOf(bh.bA(Wq)), Integer.valueOf(bufferInfo.size)});
        }
    }

    public final void clear() {
        super.clear();
        SightVideoJNI.releaseBigSightDataBuffer(this.ouk);
    }
}
