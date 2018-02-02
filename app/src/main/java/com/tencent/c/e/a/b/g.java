package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g extends JceStruct {
    static Map<Integer, ArrayList<f>> zUI;
    public long zUF = 0;
    public Map<Integer, ArrayList<f>> zUG = null;
    public int zUH = 0;
    public int zUl = 0;
    public int zUm = 0;
    public int zUn = 0;
    public int zUo = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.zUF, 0);
        jceOutputStream.write(this.zUG, 1);
        jceOutputStream.write(this.zUl, 2);
        jceOutputStream.write(this.zUm, 3);
        jceOutputStream.write(this.zUn, 4);
        jceOutputStream.write(this.zUo, 5);
        if (this.zUH != 0) {
            jceOutputStream.write(this.zUH, 6);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.zUF = jceInputStream.read(this.zUF, 0, true);
        if (zUI == null) {
            zUI = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f());
            zUI.put(valueOf, arrayList);
        }
        this.zUG = (Map) jceInputStream.read(zUI, 1, true);
        this.zUl = jceInputStream.read(this.zUl, 2, false);
        this.zUm = jceInputStream.read(this.zUm, 3, false);
        this.zUn = jceInputStream.read(this.zUn, 4, false);
        this.zUo = jceInputStream.read(this.zUo, 5, false);
        this.zUH = jceInputStream.read(this.zUH, 6, false);
    }
}
