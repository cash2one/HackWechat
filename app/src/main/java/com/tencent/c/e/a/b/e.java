package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class e extends JceStruct {
    static ArrayList<g> zUD;
    public int action = 0;
    public double lat = 0.0d;
    public int zTC = 0;
    public long zUA = 0;
    public ArrayList<g> zUB = null;
    public double zUC = 0.0d;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.zUA, 0);
        jceOutputStream.write(this.zUB, 1);
        if (this.zTC != 0) {
            jceOutputStream.write(this.zTC, 2);
        }
        if (this.action != 0) {
            jceOutputStream.write(this.action, 3);
        }
        if (this.lat != 0.0d) {
            jceOutputStream.write(this.lat, 4);
        }
        if (this.zUC != 0.0d) {
            jceOutputStream.write(this.zUC, 5);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zUA = jceInputStream.read(this.zUA, 0, true);
        if (zUD == null) {
            zUD = new ArrayList();
            zUD.add(new g());
        }
        this.zUB = (ArrayList) jceInputStream.read(zUD, 1, true);
        this.zTC = jceInputStream.read(this.zTC, 2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.lat = jceInputStream.read(this.lat, 4, false);
        this.zUC = jceInputStream.read(this.zUC, 5, false);
    }
}
