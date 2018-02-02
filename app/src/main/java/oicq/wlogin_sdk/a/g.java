package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class g extends a {
    public int Axb;
    public int Axc;
    public int Axd;
    public int Axe;

    public g() {
        this.Axb = 0;
        this.Axc = 0;
        this.Axd = 0;
        this.Axe = 0;
        this.Awh = 261;
    }

    public final Boolean cJR() {
        if (this.AwR < 2) {
            return Boolean.valueOf(false);
        }
        this.Axc = util.X(this.Awb, this.AwQ);
        if (this.AwR < (this.Axc + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.Axb = util.X(this.Awb, (this.AwQ + 2) + this.Axc);
        if (this.AwR < ((this.Axc + 2) + 2) + this.Axb) {
            return Boolean.valueOf(false);
        }
        this.Axe = this.AwQ + 2;
        this.Axd = ((this.Axc + 2) + 2) + this.AwQ;
        return Boolean.valueOf(true);
    }
}
