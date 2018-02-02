package com.tencent.pb.common.b.a;

import com.google.a.a.a;
import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.ba;
import java.util.Arrays;

public final class a$j extends e {
    public String groupId;
    public int slB;
    public long slC;
    public ba zMQ;
    public int zMS;
    public byte[] zNc;

    public final /* synthetic */ e a(a aVar) {
        while (true) {
            int rx = aVar.rx();
            switch (rx) {
                case 0:
                    break;
                case 10:
                    this.groupId = aVar.readString();
                    continue;
                case 16:
                    this.slB = aVar.ry();
                    continue;
                case 24:
                    this.slC = aVar.rz();
                    continue;
                case 34:
                    if (this.zMQ == null) {
                        this.zMQ = new ba();
                    }
                    aVar.a(this.zMQ);
                    continue;
                case 40:
                    this.zMS = aVar.ry();
                    continue;
                case 1602:
                    this.zNc = aVar.readBytes();
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

    public a$j() {
        this.groupId = "";
        this.slB = 0;
        this.slC = 0;
        this.zMQ = null;
        this.zMS = 0;
        this.zNc = g.bfX;
        this.bfQ = -1;
    }

    public final void a(b bVar) {
        if (!this.groupId.equals("")) {
            bVar.g(1, this.groupId);
        }
        if (this.slB != 0) {
            bVar.aB(2, this.slB);
        }
        if (this.slC != 0) {
            bVar.k(3, this.slC);
        }
        if (this.zMQ != null) {
            bVar.a(4, this.zMQ);
        }
        if (this.zMS != 0) {
            bVar.aC(5, this.zMS);
        }
        if (!Arrays.equals(this.zNc, g.bfX)) {
            bVar.a(200, this.zNc);
        }
        super.a(bVar);
    }

    protected final int rL() {
        int rL = super.rL();
        if (!this.groupId.equals("")) {
            rL += b.h(1, this.groupId);
        }
        if (this.slB != 0) {
            rL += b.aD(2, this.slB);
        }
        if (this.slC != 0) {
            rL += b.m(3, this.slC);
        }
        if (this.zMQ != null) {
            rL += b.b(4, this.zMQ);
        }
        if (this.zMS != 0) {
            rL += b.aE(5, this.zMS);
        }
        if (Arrays.equals(this.zNc, g.bfX)) {
            return rL;
        }
        return rL + b.b(200, this.zNc);
    }
}
