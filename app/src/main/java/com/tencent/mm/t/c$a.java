package com.tencent.mm.t;

import android.graphics.PointF;
import java.util.List;

class c$a {
    public float[] gNQ = new float[this.gNS];
    public float[] gNR = new float[this.gNS];
    public int gNS;
    final /* synthetic */ c gNT;

    public c$a(c cVar, List<PointF> list) {
        this.gNT = cVar;
        this.gNS = list.size();
        for (int i = 0; i < this.gNS; i++) {
            this.gNQ[i] = ((PointF) list.get(i)).x;
            this.gNR[i] = ((PointF) list.get(i)).y;
        }
        new StringBuilder("lasso size:").append(this.gNS);
    }
}
