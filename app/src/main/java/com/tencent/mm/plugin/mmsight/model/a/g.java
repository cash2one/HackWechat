package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class g extends h {
    private int ouk = -1;

    public g(int i, int i2) {
        super(i, i2);
    }

    public final int ar(int i, String str) {
        this.ouk = i;
        return super.ar(i, str);
    }

    protected final void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.ouk >= 0 && byteBuffer != null && bufferInfo != null && !this.ouA) {
            SightVideoJNI.writeAACData(this.ouk, byteBuffer, bufferInfo.size);
        }
    }

    protected final boolean baJ() {
        return true;
    }
}
