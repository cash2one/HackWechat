package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import java.util.Stack;

public final class f implements c {
    public String gOP;
    public a iKO;
    public a iKP;
    public Stack<a> iKQ;
    public Stack<a> iKR;
    public Paint iKS = new Paint();
    public Paint iKT;
    public g iKU;
    private c iKV;

    public f(c cVar) {
        this.iKV = cVar;
        this.iKO = new a();
        this.iKP = new a();
        this.iKO.setStyle(Style.STROKE);
        this.iKP.setStyle(Style.FILL);
        this.iKO.setAntiAlias(true);
        this.iKP.setAntiAlias(true);
        this.iKO.setStrokeWidth((float) com.tencent.mm.plugin.appbrand.p.f.lI(1));
        this.iKP.setStrokeWidth((float) com.tencent.mm.plugin.appbrand.p.f.lI(1));
        this.iKQ = new Stack();
        this.iKR = new Stack();
        this.iKS.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }

    public final void invalidate() {
        this.iKV.invalidate();
    }
}
