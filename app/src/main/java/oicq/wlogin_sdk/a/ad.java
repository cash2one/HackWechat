package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ad extends a {
    public int Axt;

    public ad() {
        this.Axt = 0;
        this.Awh = 312;
    }

    public final Boolean cJR() {
        if (this.AwR < 4) {
            return Boolean.valueOf(false);
        }
        this.Axt = util.Y(this.Awb, this.AwQ);
        if (this.AwR < (this.Axt * 10) + 4) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final int cJS() {
        for (int i = 0; i < this.Axt; i++) {
            if (util.X(this.Awb, (this.AwQ + 4) + (i * 10)) == 266) {
                return util.Y(this.Awb, ((i * 10) + (this.AwQ + 4)) + 2);
            }
        }
        return 0;
    }
}
