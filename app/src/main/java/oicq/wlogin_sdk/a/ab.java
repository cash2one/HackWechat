package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ab extends a {
    public int Axs;

    public ab() {
        this.Axs = 0;
        this.Awh = 306;
    }

    public final Boolean cJR() {
        if (this.AwR < 2) {
            return Boolean.valueOf(false);
        }
        this.Axs = util.X(this.Awb, this.AwQ);
        if (this.Axs + 2 > this.AwR) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }
}
