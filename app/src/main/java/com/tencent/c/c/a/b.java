package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b extends JceStruct {
    public int zSe = 0;
    public int zSf = 0;
    public int zSg = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.zSe, 1);
        jceOutputStream.write(this.zSf, 2);
        jceOutputStream.write(this.zSg, 3);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zSe = jceInputStream.read(this.zSe, 1, true);
        this.zSf = jceInputStream.read(this.zSf, 2, true);
        this.zSg = jceInputStream.read(this.zSg, 3, true);
    }
}
