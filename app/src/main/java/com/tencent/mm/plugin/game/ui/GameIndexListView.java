package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.mm.R;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.game.c.bk;
import com.tencent.mm.plugin.game.c.bl;
import com.tencent.mm.sdk.platformtools.x;

public class GameIndexListView extends LoadMoreRecyclerView {
    private static boolean nmC = true;
    private static boolean nmG;
    private static int nmI = 0;
    private static int nqL = 0;
    private static int nri = 0;
    private View Lr;
    private Context mContext;
    private float nmD;
    private int nmE;
    private boolean nmH;
    private ImageView nmJ;
    private ImageView nmK;
    private b nrf;
    private bl nrg;
    private boolean nrh = true;
    private Scroller yJ;

    public static void qO(int i) {
        nqL = i;
    }

    public static int aRA() {
        return nqL;
    }

    public GameIndexListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.d("MicroMsg.GameIndexListView", "onFinishInflate");
        this.nmE = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.yJ = new Scroller(this.mContext);
        getContext();
        a(new LinearLayoutManager());
        this.nrf = new b(this);
        a(this.nrf);
        a(new a(this, getResources(), R.e.bsr));
        mu(R.i.dkk);
        this.kge = new 1(this);
        dB(true);
        aRB();
    }

    private void aRB() {
        a aVar = new a();
        com.tencent.mm.bq.a bkVar = new bk();
        bkVar.niu = this.nrg != null ? this.nrg.niw : null;
        aVar.hmj = bkVar;
        aVar.hmk = new bl();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
        aVar.hmi = 2943;
        aVar.hml = 0;
        aVar.hmm = 0;
        u.a(aVar.JZ(), new 2(this));
    }

    public static void fG(boolean z) {
        nmG = z;
    }

    public static void qS(int i) {
        nmI = i;
    }

    public static void qX(int i) {
        nri = i;
        nmC = true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.GameIndexListView", "onLayout, changed = " + z);
        super.onLayout(z, i, i2, i3, i4);
        if (nmC || this.Lr == null || this.nmK == null || this.nmJ == null) {
            this.Lr = getChildAt(0);
            if (this.Lr != null) {
                this.Lr.setPadding(0, nri, 0, 0);
                this.nmK = (ImageView) this.Lr.findViewById(R.h.cOM);
                this.nmJ = (ImageView) this.Lr.findViewById(R.h.bMX);
            }
            nmC = false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!nmG || this.Lr == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nmH = false;
                this.nmD = motionEvent.getRawY();
                break;
            case 2:
                boolean z;
                if (((LinearLayoutManager) this.TV).eZ() == 0 && this.Lr != null && this.Lr.getTop() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (this.nmH) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.nmD);
                    if (this.Lr.getPaddingTop() <= nmI + this.nmE) {
                        if (rawY > 0 && Math.abs(rawY) >= this.nmE) {
                            this.nmH = true;
                            this.yJ.startScroll(0, this.Lr.getPaddingTop(), 0, -this.Lr.getPaddingTop(), 500);
                            this.nmJ.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                    } else if (this.Lr.getPaddingTop() >= (-this.nmE) && rawY < 0 && Math.abs(rawY) >= this.nmE) {
                        this.nmH = true;
                        this.yJ.startScroll(0, 0, 0, nmI, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.Lr != null && this.yJ.computeScrollOffset()) {
            int currY = this.yJ.getCurrY();
            x.d("MicroMsg.GameIndexListView", "computeScroll, currY = " + currY);
            this.Lr.setPadding(0, currY, 0, 0);
            float f = (((float) (nmI - currY)) / ((float) nmI)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.nmK.setAlpha(i);
            this.nmJ.setAlpha(currY);
            invalidate();
        }
    }
}
