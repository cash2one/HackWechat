package oicq.wlogin_sdk.a;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import oicq.wlogin_sdk.tools.util;

public final class z extends a {
    public int Axp;
    public int Axq;

    public z() {
        this.Axp = 0;
        this.Axq = 0;
        this.Awh = JsApiGetAudioState.CTRL_INDEX;
    }

    public final Boolean cJR() {
        if (this.AwR < 2) {
            return Boolean.valueOf(false);
        }
        this.Axp = util.X(this.Awb, this.AwQ);
        if (this.AwR < (this.Axp + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.Axq = util.X(this.Awb, (this.AwQ + 2) + this.Axp);
        return Boolean.valueOf(true);
    }
}
