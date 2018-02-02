package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

class d$4 implements Runnable {
    final /* synthetic */ d iKJ;
    final /* synthetic */ JSONArray iKK;
    final /* synthetic */ a iKL;

    d$4(d dVar, JSONArray jSONArray, a aVar) {
        this.iKJ = dVar;
        this.iKK = jSONArray;
        this.iKL = aVar;
    }

    public final void run() {
        if (this.iKJ.iKx == null) {
            this.iKJ.iKx = this.iKK;
        } else {
            for (int i = 0; i < this.iKK.length(); i++) {
                this.iKJ.iKx.put(this.iKK.opt(i));
            }
        }
        this.iKJ.iKw = true;
        if (this.iKL != null) {
            this.iKL.abp();
        }
    }
}
