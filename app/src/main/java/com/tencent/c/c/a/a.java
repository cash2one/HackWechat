package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a extends JceStruct {
    public int zSc = 0;
    public int zSd = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.zSc, 0);
        jceOutputStream.write(this.zSd, 1);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zSc = jceInputStream.read(this.zSc, 0, true);
        this.zSd = jceInputStream.read(this.zSd, 1, false);
    }
}
