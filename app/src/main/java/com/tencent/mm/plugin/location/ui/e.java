package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends ImageView {
    private static int nSY;
    private final String TAG = "MicroMsg.MyPoiPoint";
    private boolean bgH;
    private double bhG;
    public a gyF = new 1(this);
    private Activity mActivity;
    private a nSP;
    private Bitmap nSQ;
    private boolean nSR;
    private double nSS;
    private double nST;
    public c nSU;
    private d nSV;
    private boolean nSW = false;
    private final int nSX = 689208551;
    private boolean nSZ = false;

    public e(Activity activity, int i, d dVar) {
        super(activity);
        this.nSV = dVar;
        this.nSP = null;
        this.mActivity = activity;
        this.nSQ = com.tencent.mm.sdk.platformtools.d.CZ(i);
        this.bgH = false;
        this.nSR = false;
        this.nSU = c.OP();
        nSY = b.b((Context) activity, 80.0f);
        setImageResource(i);
        setScaleType(ScaleType.FIT_CENTER);
        x.d("MicroMsg.MyPoiPoint", "enableLocation");
        this.bgH = true;
        this.nSU.a(this.gyF);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x.d("MicroMsg.MyPoiPoint", "onDraw");
    }
}
