package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import org.json.JSONArray;

class d$3 implements Runnable {
    final /* synthetic */ d iKJ;
    final /* synthetic */ JSONArray iKK;
    final /* synthetic */ a iKL;

    d$3(d dVar, JSONArray jSONArray, a aVar) {
        this.iKJ = dVar;
        this.iKK = jSONArray;
        this.iKL = aVar;
    }

    public final void run() {
        this.iKJ.iKx = this.iKK;
        this.iKJ.iKw = true;
        if (this.iKL != null) {
            this.iKL.abp();
        }
    }
}
