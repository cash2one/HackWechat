package oicq.wlogin_sdk.a;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import oicq.wlogin_sdk.tools.util;

public final class y extends a {
    int Axo;

    public y() {
        this.Axo = 0;
        this.Awh = JsApiSetAudioState.CTRL_INDEX;
    }

    private static int V(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int V = V(bArr, 16);
        int V2 = V(bArr2, 16);
        int V3 = V(bArr3, 16);
        int V4 = V(bArr4, 32);
        int V5 = V(bArr5, 16);
        this.Axo = (((((((((V + 2) + 2) + V2) + 2) + 2) + V3) + 2) + V4) + 2) + V5;
        Object obj = new byte[this.Axo];
        util.A(obj, 0, V);
        System.arraycopy(bArr, 0, obj, 2, V);
        V += 2;
        util.A(obj, V, V2);
        V += 2;
        System.arraycopy(bArr2, 0, obj, V, V2);
        V += V2;
        util.A(obj, V, i);
        V += 2;
        util.A(obj, V, V3);
        V += 2;
        System.arraycopy(bArr3, 0, obj, V, V3);
        V += V3;
        util.A(obj, V, V4);
        V += 2;
        System.arraycopy(bArr4, 0, obj, V, V4);
        V += V4;
        util.A(obj, V, V5);
        System.arraycopy(bArr5, 0, obj, V + 2, V5);
        super.Jn(this.Awh);
        super.U(obj, this.Axo);
        super.cJQ();
        return super.cJM();
    }
}
