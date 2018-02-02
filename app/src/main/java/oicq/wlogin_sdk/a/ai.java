package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ai extends a {
    public int AxA;
    public int AxB;
    public int Axz;

    public ai() {
        this.Axz = 0;
        this.AxA = 0;
        this.AxB = 0;
        this.Awh = 326;
    }

    public final Boolean cJR() {
        if (this.AwR < 12) {
            return Boolean.valueOf(false);
        }
        int X = util.X(this.Awb, this.AwQ + 4);
        if (this.AwR < X + 12) {
            return Boolean.valueOf(false);
        }
        this.Axz = X;
        X = util.X(this.Awb, (this.AwQ + 6) + this.Axz);
        if (this.AwR < (this.Axz + 12) + X) {
            return Boolean.valueOf(false);
        }
        this.AxA = X;
        X = util.X(this.Awb, ((this.AwQ + 10) + this.Axz) + this.AxA);
        if (this.AwR < ((this.Axz + 12) + this.AxA) + X) {
            return Boolean.valueOf(false);
        }
        this.AxB = X;
        return Boolean.valueOf(true);
    }
}
