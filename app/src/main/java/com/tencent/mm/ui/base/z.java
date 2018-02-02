package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bv.a;
import com.tencent.mm.ui.widget.i;

public final class z {
    public boolean fJl = true;
    TextView kO;
    Context mContext;
    public b ygM;
    public b ygN;
    c ygO = new c(this);
    public w ygP;
    Spannable ygQ;
    i ygR;
    int ygS;
    int ygT;
    private int ygU;
    int ygV;
    int ygW;
    private d ygX;
    boolean ygY;
    OnPreDrawListener ygZ;
    OnScrollChangedListener yha;
    final Runnable yhb = new 7(this);
    private int[] yhc = new int[2];

    public class c {
        public int Ww;
        public int wq;
        final /* synthetic */ z yhd;
        public String yhn;

        public c(z zVar) {
            this.yhd = zVar;
        }
    }

    static /* synthetic */ b a(z zVar, boolean z) {
        return b.b(zVar.ygM) == z ? zVar.ygM : zVar.ygN;
    }

    public z(a aVar) {
        this.kO = aVar.kO;
        this.ygR = aVar.yhe;
        this.mContext = this.kO.getContext();
        this.ygU = aVar.ygU;
        this.ygV = aVar.ygV;
        this.ygW = a.fromDPToPix(this.mContext, 24);
        this.kO.setText(this.kO.getText(), BufferType.SPANNABLE);
        this.kO.setOnLongClickListener(new 1(this));
        this.kO.setOnTouchListener(new 2(this));
        this.kO.setOnClickListener(new 3(this));
        this.kO.addOnAttachStateChangeListener(new 4(this));
        this.ygZ = new 5(this);
        this.kO.getViewTreeObserver().addOnPreDrawListener(this.ygZ);
        this.yha = new 6(this);
        this.kO.getViewTreeObserver().addOnScrollChangedListener(this.yha);
    }

    public final void cqc() {
        this.fJl = true;
        if (this.ygM != null) {
            this.ygM.yhg.dismiss();
        }
        if (this.ygN != null) {
            this.ygN.yhg.dismiss();
        }
        if (this.ygR != null) {
            this.ygR.cro();
        }
    }

    public final void cqd() {
        this.ygO.yhn = null;
        if (this.ygQ != null && this.ygX != null) {
            this.ygQ.removeSpan(this.ygX);
            this.ygX = null;
        }
    }

    public final void a(b bVar) {
        Layout layout = this.kO.getLayout();
        int i = b.b(bVar) ? this.ygO.Ww : this.ygO.wq;
        int primaryHorizontal = (int) layout.getPrimaryHorizontal(i);
        int lineBottom = layout.getLineBottom(layout.getLineForOffset(i));
        bVar.yhd.kO.getLocationInWindow(bVar.yhm);
        if (bVar.yhh) {
            i = bVar.mWidth;
        } else {
            i = 0;
        }
        if (!bVar.yhh) {
            int[] eV = bVar.eV(primaryHorizontal, lineBottom);
            primaryHorizontal = eV[0];
            lineBottom = eV[1];
        }
        bVar.yhg.showAtLocation(bVar.yhd.kO, 0, (primaryHorizontal - i) + bVar.cqh(), lineBottom + bVar.cqi());
    }

    public final void cqe() {
        int i = 16;
        if (this.ygR != null) {
            this.kO.getLocationInWindow(this.yhc);
            Layout layout = this.kO.getLayout();
            int primaryHorizontal = ((int) layout.getPrimaryHorizontal(this.ygO.Ww)) + this.yhc[0];
            int lineTop = (layout.getLineTop(layout.getLineForOffset(this.ygO.Ww)) + this.yhc[1]) - 16;
            if (primaryHorizontal <= 0) {
                primaryHorizontal = 16;
            }
            if (lineTop >= 0) {
                i = lineTop;
            }
            if (primaryHorizontal > ab.getScreenWidth(this.mContext)) {
                lineTop = ab.getScreenWidth(this.mContext) - 16;
            } else {
                lineTop = primaryHorizontal;
            }
            this.ygR.bQ(lineTop, i);
        }
    }

    public final void eU(int i, int i2) {
        if (i != -1) {
            this.ygO.Ww = i;
        }
        if (i2 != -1) {
            this.ygO.wq = i2;
        }
        if (this.ygO.Ww > this.ygO.wq) {
            int i3 = this.ygO.Ww;
            this.ygO.Ww = this.ygO.wq;
            this.ygO.wq = i3;
        }
        if (this.ygQ != null) {
            this.ygO.yhn = this.ygQ.subSequence(this.ygO.Ww, this.ygO.wq).toString();
            if (this.ygX == null) {
                this.ygX = new d(this.kO, this.mContext.getResources().getColor(this.ygU), this.ygO.Ww, this.ygO.wq);
            }
            if (this.ygX != null) {
                d dVar = this.ygX;
                int i4 = this.ygO.Ww;
                int i5 = this.ygO.wq;
                dVar.start = i4;
                dVar.end = i5;
            }
            Layout layout = this.kO.getLayout();
            this.ygQ.setSpan(this.ygX, layout.getLineStart(layout.getLineForOffset(this.ygO.Ww)), this.ygO.wq, 17);
            if (this.ygP != null) {
                this.ygP.R(this.ygO.yhn);
            }
        }
    }
}
