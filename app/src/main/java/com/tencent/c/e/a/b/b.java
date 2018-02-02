package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b extends JceStruct {
    public String ffq = "";
    public String zUq = "";
    public int zUw = 0;
    public float zUx = 0.0f;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.zUq, 0);
        jceOutputStream.write(this.zUw, 1);
        jceOutputStream.write(this.zUx, 2);
        if (this.ffq != null) {
            jceOutputStream.write(this.ffq, 3);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zUq = jceInputStream.readString(0, true);
        this.zUw = jceInputStream.read(this.zUw, 1, true);
        this.zUx = jceInputStream.read(this.zUx, 2, true);
        this.ffq = jceInputStream.readString(3, false);
    }
}
