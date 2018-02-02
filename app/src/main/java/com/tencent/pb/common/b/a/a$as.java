package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import org.xwalk.core.R$styleable;

public final class a$as extends e {
    public int huk;
    public int hul;
    public int zON;
    public int zOO;
    public int zOP;
    public int zOQ;
    public int zOR;
    public int zOS;
    public int zOT;
    public int zOU;
    public int zOV;
    public int zOW;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 8:
                    this.zON = aVar.ry();
                    continue;
                case 16:
                    this.huk = aVar.ry();
                    continue;
                case 24:
                    this.hul = aVar.ry();
                    continue;
                case 32:
                    this.zOO = aVar.ry();
                    continue;
                case 40:
                    this.zOP = aVar.ry();
                    continue;
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.zOQ = aVar.ry();
                    continue;
                case 56:
                    this.zOR = aVar.ry();
                    continue;
                case 64:
                    this.zOS = aVar.ry();
                    continue;
                case 72:
                    this.zOT = aVar.ry();
                    continue;
                case 80:
                    this.zOU = aVar.ry();
                    continue;
                case R$styleable.AppCompatTheme_colorButtonNormal /*88*/:
                    this.zOV = aVar.ry();
                    continue;
                case 96:
                    this.zOW = aVar.ry();
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

    public a$as() {
        this.zON = 0;
        this.huk = 0;
        this.hul = 0;
        this.zOO = 0;
        this.zOP = 0;
        this.zOQ = 0;
        this.zOR = 0;
        this.zOS = 0;
        this.zOT = 0;
        this.zOU = 0;
        this.zOV = 0;
        this.zOW = 0;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (this.zON != 0) {
            bVar.aB(1, this.zON);
        }
        if (this.huk != 0) {
            bVar.aB(2, this.huk);
        }
        if (this.hul != 0) {
            bVar.aB(3, this.hul);
        }
        if (this.zOO != 0) {
            bVar.aB(4, this.zOO);
        }
        if (this.zOP != 0) {
            bVar.aB(5, this.zOP);
        }
        if (this.zOQ != 0) {
            bVar.aB(6, this.zOQ);
        }
        if (this.zOR != 0) {
            bVar.aB(7, this.zOR);
        }
        if (this.zOS != 0) {
            bVar.aB(8, this.zOS);
        }
        if (this.zOT != 0) {
            bVar.aB(9, this.zOT);
        }
        if (this.zOU != 0) {
            bVar.aB(10, this.zOU);
        }
        if (this.zOV != 0) {
            bVar.aB(11, this.zOV);
        }
        if (this.zOW != 0) {
            bVar.aB(12, this.zOW);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (this.zON != 0) {
            rL += b.aD(1, this.zON);
        }
        if (this.huk != 0) {
            rL += b.aD(2, this.huk);
        }
        if (this.hul != 0) {
            rL += b.aD(3, this.hul);
        }
        if (this.zOO != 0) {
            rL += b.aD(4, this.zOO);
        }
        if (this.zOP != 0) {
            rL += b.aD(5, this.zOP);
        }
        if (this.zOQ != 0) {
            rL += b.aD(6, this.zOQ);
        }
        if (this.zOR != 0) {
            rL += b.aD(7, this.zOR);
        }
        if (this.zOS != 0) {
            rL += b.aD(8, this.zOS);
        }
        if (this.zOT != 0) {
            rL += b.aD(9, this.zOT);
        }
        if (this.zOU != 0) {
            rL += b.aD(10, this.zOU);
        }
        if (this.zOV != 0) {
            rL += b.aD(11, this.zOV);
        }
        if (this.zOW != 0) {
            return rL + b.aD(12, this.zOW);
        }
        return rL;
    }
}
