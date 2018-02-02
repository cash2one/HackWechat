package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d extends JceStruct {
    static b zUz;
    public int errorCode = 0;
    public b zUy = null;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.errorCode, 0);
        if (this.zUy != null) {
            jceOutputStream.write(this.zUy, 1);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.errorCode = jceInputStream.read(this.errorCode, 0, true);
        if (zUz == null) {
            zUz = new b();
        }
        this.zUy = (b) jceInputStream.read(zUz, 1, false);
    }
}
