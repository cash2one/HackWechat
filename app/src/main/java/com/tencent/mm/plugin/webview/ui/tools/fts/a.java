package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import java.lang.reflect.Array;

public class a {
    protected boolean isAnimating;
    protected View kDn;
    protected int oHY;
    protected int tEh;
    protected int tEi;
    protected int tEj;
    protected int tEk;
    protected View tEl;
    protected View tEm;
    protected View tEn;
    protected View tEo;
    protected View tEp;
    protected View tEq;
    protected View tEr;
    protected View tEs;
    protected float[][] tEt;
    protected int tEu = b.tEE;
    protected a tEv;
    protected AnimatorUpdateListener tEw = new 3(this);
    protected AnimatorUpdateListener tEx = new 4(this);
    protected AnimatorUpdateListener tEy = new 5(this);
    protected AnimatorUpdateListener tEz = new 6(this);

    public enum b {
        ;

        public static int[] bTY() {
            return (int[]) tEG.clone();
        }

        static {
            tEE = 1;
            tEF = 2;
            tEG = new int[]{tEE, tEF};
        }
    }

    public a(Context context, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9) {
        this.tEh = com.tencent.mm.bv.a.fromDPToPix(context, 48) / 2;
        this.oHY = (int) context.getResources().getDimension(R.f.byc);
        this.tEt = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
        this.tEl = view;
        this.tEm = view2;
        this.tEn = view3;
        this.tEo = view4;
        this.tEp = view5;
        this.kDn = view6;
        this.tEq = view7;
        this.tEr = view8;
        this.tEs = view9;
        this.tEl.post(new 1(this, view));
        this.tEr.post(new 2(this, view8));
    }

    public final void AT(int i) {
        this.tEt[0][0] = (float) i;
    }

    public final void AU(int i) {
        this.tEu = i;
    }

    public void AV(int i) {
        if (i != this.tEu) {
            switch (7.tED[i - 1]) {
                case 1:
                    bTV();
                    break;
                case 2:
                    bTW();
                    break;
            }
            this.tEu = i;
        }
    }

    protected void bTV() {
    }

    protected void bTW() {
    }

    public final void a(a aVar) {
        this.tEv = aVar;
    }

    protected boolean bTX() {
        return true;
    }
}
