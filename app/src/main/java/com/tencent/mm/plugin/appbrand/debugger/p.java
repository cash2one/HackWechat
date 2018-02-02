package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends FrameLayout {
    private g iQx;
    ViewGroup iRd;
    RemoteDebugMoveView iRe;
    private LinkedList<String> iRf = new LinkedList();
    TextView iRg;
    TextView iRh;
    TextView iRi;
    TextView iRj;
    TextView iRk;
    TextView iRl;
    TextView iRm;
    ImageView iRn;
    ImageView iRo;
    View iRp;
    boolean iRq = false;
    private a iRr;
    private i iRs;
    OnClickListener mOnClickListener = new 3(this);

    static /* synthetic */ void a(p pVar, String str) {
        pVar.iRf.add(0, str);
        while (pVar.iRf.size() > 10) {
            pVar.iRf.removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = pVar.iRf.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            stringBuilder.append("\n");
        }
        pVar.iRm.setText(stringBuilder.toString());
        if (pVar.iRq) {
            pVar.iRm.setVisibility(0);
        } else {
            pVar.iRm.setVisibility(8);
        }
    }

    static /* synthetic */ void h(p pVar) {
        if (pVar.iQx.isBusy() || !pVar.iQx.is()) {
            pVar.iRn.setImageResource(f.itf);
            pVar.iRg.setText(pVar.getContext().getString(j.iBj));
            return;
        }
        pVar.iRn.setImageResource(f.itg);
        pVar.iRg.setText(pVar.getContext().getString(j.iBk));
    }

    public p(Context context, g gVar, a aVar) {
        super(context);
        this.iQx = gVar;
        this.iRr = aVar;
        setLayoutParams(new LayoutParams(-1, -1));
        setBackgroundColor(getContext().getResources().getColor(d.transparent));
        setId(g.itC);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (acy()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void bringToFront() {
        if (this.iRd == null) {
            x.w("MicroMsg.RemoteDebugView", "bringoFront mContentView is null");
        } else {
            this.iRd.bringChildToFront(this);
        }
    }

    public final void acx() {
        ag.y(new 2(this));
    }

    private boolean acy() {
        if (!(this.iQx.acl() || this.iQx.acm())) {
            if (!(this.iQx.getStatus() == 5)) {
                return false;
            }
        }
        return true;
    }

    final void acz() {
        if (this.iRs == null || !this.iRs.isShowing()) {
            this.iRs = h.a(getContext(), getContext().getString(j.iBi), "", getContext().getString(j.dFU), getContext().getString(j.dEn), new 4(this), null);
        }
    }

    public final void acA() {
        ag.y(new 5(this));
    }

    public final void show() {
        if (this.iRq) {
            this.iRp.setVisibility(0);
            if (this.iRf.size() > 0) {
                this.iRm.setVisibility(0);
            } else {
                this.iRm.setVisibility(8);
            }
            this.iRk.setVisibility(8);
        } else {
            this.iRp.setVisibility(8);
            this.iRm.setVisibility(8);
            this.iRk.setVisibility(0);
        }
        invalidate();
    }

    public final void acB() {
        acx();
        acA();
    }

    public final void rk(String str) {
        if (!bh.ov(str)) {
            ag.y(new 9(this, str));
        }
    }
}
