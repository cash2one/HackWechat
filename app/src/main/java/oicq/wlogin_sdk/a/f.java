package oicq.wlogin_sdk.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;

public final class f extends a {
    int Axa;

    public f() {
        this.Axa = 0;
        this.Awh = GameJsApiLaunchApplication.CTRL_BYTE;
    }

    public final byte[] bX(byte[] bArr) {
        this.Axa = bArr.length;
        Object obj = new byte[this.Axa];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.Jn(this.Awh);
        super.U(obj, this.Axa);
        super.cJQ();
        return super.cJM();
    }
}
