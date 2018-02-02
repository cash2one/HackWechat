package com.tencent.mm.ui.widget.celltextview.e;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.widget.celltextview.CellTextView;
import com.tencent.mm.ui.widget.celltextview.c.b;
import java.util.List;

public final class a implements OnTouchListener {
    private static int vuX = ViewConfiguration.getLongPressTimeout();
    private static Handler zxQ = new Handler(Looper.getMainLooper());
    private boolean vuW = false;
    private b zxL;
    private CellTextView zxR;
    private a zxS = new a(this);

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view instanceof CellTextView) {
            this.zxR = (CellTextView) view;
            List<b> czj = this.zxR.czg().czj();
            if (czj != null && czj.size() > 0) {
                int x = ((int) motionEvent.getX()) - this.zxR.getPaddingRight();
                int y = ((int) motionEvent.getY()) - this.zxR.getPaddingTop();
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.zxL = null;
                        for (b bVar : czj) {
                            if (bVar.fo(x, y)) {
                                this.zxL = bVar;
                                this.zxR.czg().a(bVar);
                                this.zxR.invalidate();
                            }
                        }
                        if (this.zxR != null) {
                            zxQ.postDelayed(this.zxS, (long) vuX);
                            break;
                        }
                        break;
                    case 1:
                        if (!(this.vuW || this.zxL == null || !this.zxL.fo(x, y))) {
                            this.zxL.zxg.onClick(this.zxR.getView());
                        }
                        czt();
                        if (this.zxL != null) {
                            this.zxR.czg().a(null);
                            this.zxR.invalidate();
                        }
                        this.zxL = null;
                        break;
                    case 2:
                        if (!(this.zxL == null || this.zxL.fo(x, y))) {
                            this.zxL = null;
                            this.zxR.czg().a(null);
                            this.zxR.invalidate();
                            break;
                        }
                    case 3:
                        czt();
                        if (this.zxL != null) {
                            this.zxR.czg().a(null);
                            this.zxR.invalidate();
                        }
                        this.zxL = null;
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    private void czt() {
        this.vuW = false;
        zxQ.removeCallbacks(this.zxS);
    }
}
