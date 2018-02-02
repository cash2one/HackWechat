package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class t extends a {
    public int Axn;

    public t() {
        this.Axn = 0;
        this.Awh = 282;
    }

    public final Boolean cJR() {
        if (this.AwR < 5) {
            return Boolean.valueOf(false);
        }
        int W = util.W(this.Awb, ((this.AwQ + 2) + 1) + 1);
        if (this.AwR < W + 5) {
            return Boolean.valueOf(false);
        }
        this.Axn = W;
        return Boolean.valueOf(true);
    }
}
