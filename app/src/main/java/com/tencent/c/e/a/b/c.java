package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    public int errCode = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.errCode != 0) {
            jceOutputStream.write(this.errCode, 0);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.errCode = jceInputStream.read(this.errCode, 0, false);
    }
}
