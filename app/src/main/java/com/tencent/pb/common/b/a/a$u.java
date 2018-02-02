package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import org.xwalk.core.R$styleable;

public final class a$u extends e {
    public int pK;
    public int ret;
    public String userName;
    public int vCD;
    public int zMR;
    public int zNY;
    public int zNZ;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 18:
                    this.userName = aVar.readString();
                    continue;
                case 24:
                    this.pK = aVar.ry();
                    continue;
                case 32:
                    this.zNY = aVar.ry();
                    continue;
                case 40:
                    this.ret = aVar.ry();
                    continue;
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.zNZ = aVar.ry();
                    continue;
                case 56:
                    this.zMR = aVar.ry();
                    continue;
                case 64:
                    this.vCD = aVar.ry();
                    continue;
                default:
                    if (!g.a(aVar, rx)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public a$u() {
        this.userName = "";
        this.pK = 0;
        this.zNY = 0;
        this.ret = 0;
        this.zNZ = 0;
        this.zMR = 0;
        this.vCD = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (!this.userName.equals("")) {
            bVar.g(2, this.userName);
        }
        if (this.pK != 0) {
            bVar.aB(3, this.pK);
        }
        if (this.zNY != 0) {
            bVar.aC(4, this.zNY);
        }
        if (this.ret != 0) {
            bVar.aB(5, this.ret);
        }
        if (this.zNZ != 0) {
            bVar.aB(6, this.zNZ);
        }
        if (this.zMR != 0) {
            bVar.aC(7, this.zMR);
        }
        if (this.vCD != 0) {
            bVar.aC(8, this.vCD);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (!this.userName.equals("")) {
            rL += b.h(2, this.userName);
        }
        if (this.pK != 0) {
            rL += b.aD(3, this.pK);
        }
        if (this.zNY != 0) {
            rL += b.aE(4, this.zNY);
        }
        if (this.ret != 0) {
            rL += b.aD(5, this.ret);
        }
        if (this.zNZ != 0) {
            rL += b.aD(6, this.zNZ);
        }
        if (this.zMR != 0) {
            rL += b.aE(7, this.zMR);
        }
        if (this.vCD != 0) {
            return rL + b.aE(8, this.vCD);
        }
        return rL;
    }
}
