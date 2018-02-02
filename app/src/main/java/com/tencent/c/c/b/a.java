package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a extends JceStruct {
    static c zSC = new c();
    static ArrayList<b> zSD = new ArrayList();
    static d zSE = new d();
    public ArrayList<b> zSA = null;
    public d zSB = null;
    public c zSz = null;

    public final JceStruct newInit() {
        return new a();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.zSz != null) {
            jceOutputStream.write(this.zSz, 0);
        }
        if (this.zSA != null) {
            jceOutputStream.write(this.zSA, 1);
        }
        if (this.zSB != null) {
            jceOutputStream.write(this.zSB, 2);
        }
    }

    static {
        zSD.add(new b());
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zSz = (c) jceInputStream.read(zSC, 0, false);
        this.zSA = (ArrayList) jceInputStream.read(zSD, 1, false);
        this.zSB = (d) jceInputStream.read(zSE, 2, false);
    }
}
