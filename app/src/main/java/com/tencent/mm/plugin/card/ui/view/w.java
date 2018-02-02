package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.ui.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class w extends i {
    private View kWV;
    private View kWW;

    public final void initView() {
    }

    public final void update() {
        b avI = this.kWz.avI();
        g avN = this.kWz.avN();
        oq oqVar;
        if (avI.atC().vRf != null && avI.atC().vRf.size() > 1) {
            if (this.kWV == null) {
                this.kWV = ((ViewStub) findViewById(R.h.bRT)).inflate();
            }
            if (this.kWW != null) {
                this.kWW.setVisibility(8);
            }
            Context avL = this.kWz.avL();
            View view = this.kWV;
            OnClickListener avM = this.kWz.avM();
            LinkedList linkedList = avI.atC().vRf;
            int wO = l.wO(avI.atB().hbM);
            ((ViewGroup) view).removeAllViews();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                oqVar = (oq) it.next();
                View inflate = v.fv(avL).inflate(R.i.dcx, (ViewGroup) view, false);
                inflate.setId(R.h.bRU);
                inflate.setTag(Integer.valueOf(linkedList.indexOf(oqVar)));
                inflate.setOnClickListener(avM);
                if (TextUtils.isEmpty(oqVar.url)) {
                    inflate.setEnabled(false);
                }
                ((TextView) inflate.findViewById(R.h.cKn)).setText(oqVar.title);
                TextView textView = (TextView) inflate.findViewById(R.h.cKk);
                textView.setText(oqVar.kJQ);
                textView.setTextColor(wO);
                ((ViewGroup) view).addView(inflate);
                if (linkedList.indexOf(oqVar) + 1 != linkedList.size()) {
                    ((ViewGroup) view).addView(v.fv(avL).inflate(R.i.dcy, (ViewGroup) view, false));
                }
            }
            if (!(!avI.ati() || avI.atC().vRm == null || TextUtils.isEmpty(avI.atC().vRm.title))) {
                this.kWV.setBackgroundResource(R.g.bDJ);
            }
            if (!avI.ati() && avN.awJ()) {
                this.kWV.setBackgroundResource(R.g.bDJ);
            }
        } else if (avI.atC().vRf == null || avI.atC().vRf.size() != 1) {
            if (this.kWV != null) {
                this.kWV.setVisibility(8);
            }
            if (this.kWW != null) {
                this.kWW.setVisibility(8);
            }
        } else {
            if (this.kWW == null) {
                this.kWW = ((ViewStub) findViewById(R.h.bRS)).inflate();
            }
            if (this.kWV != null) {
                this.kWV.setVisibility(8);
            }
            View view2 = this.kWW;
            OnClickListener avM2 = this.kWz.avM();
            LinkedList linkedList2 = avI.atC().vRf;
            if (linkedList2.size() == 1) {
                view2.findViewById(R.h.bRV).setVisibility(0);
                oqVar = (oq) linkedList2.get(0);
                ((TextView) view2.findViewById(R.h.cKo)).setText(oqVar.title);
                ((TextView) view2.findViewById(R.h.cKl)).setText(oqVar.kJQ);
                ((TextView) view2.findViewById(R.h.cKl)).setTextColor(l.wO(avI.atB().hbM));
                view2.findViewById(R.h.bRV).setOnClickListener(avM2);
                if (TextUtils.isEmpty(oqVar.url)) {
                    view2.findViewById(R.h.bRV).setEnabled(false);
                }
            }
            if (!(!avI.ati() || avI.atC().vRm == null || TextUtils.isEmpty(avI.atC().vRm.title))) {
                this.kWW.setBackgroundResource(R.g.bDJ);
            }
            if (!avI.ati() && avN.awJ()) {
                this.kWW.setBackgroundResource(R.g.bDJ);
            }
        }
    }

    public final void awW() {
        if (this.kWV != null) {
            this.kWV.setVisibility(8);
        }
        if (this.kWW != null) {
            this.kWW.setVisibility(8);
        }
    }
}
