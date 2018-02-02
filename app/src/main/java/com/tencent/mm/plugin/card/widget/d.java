package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends a {
    private View kYi;
    private TextView kYj;
    private TextView kYk;
    private View kYl;
    private TextView kYm;
    private TextView kYn;
    private View kYo;
    private View kYp;
    private View kYq;

    public d(Context context) {
        super(context);
    }

    protected final void axn() {
        this.kYi = this.kXV.findViewById(R.h.cCo);
        this.kYj = (TextView) this.kXV.findViewById(R.h.cCq);
        this.kYk = (TextView) this.kXV.findViewById(R.h.cCp);
        this.kYl = this.kXV.findViewById(R.h.bMZ);
        this.kYm = (TextView) this.kXV.findViewById(R.h.bNb);
        this.kYn = (TextView) this.kXV.findViewById(R.h.bNa);
        this.kYp = this.kXV.findViewById(R.h.bSv);
        this.kYq = this.kXV.findViewById(R.h.bPO);
    }

    protected final void axo() {
        oq oqVar;
        if (this.kIK.atB().vRI == null || this.kIK.atB().vRI.size() <= 0) {
            x.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList linkedList = this.kIK.atB().vRI;
            oq oqVar2 = null;
            if (linkedList.size() == 1) {
                oqVar = (oq) linkedList.get(0);
            } else {
                oqVar = (oq) linkedList.get(0);
                oqVar2 = (oq) linkedList.get(1);
            }
            if (oqVar != null) {
                this.kYi.setVisibility(0);
                this.kYj.setText(oqVar.title);
                this.kYk.setText(oqVar.kJQ);
                if (!TextUtils.isEmpty(oqVar.vSN)) {
                    this.kYj.setTextColor(l.wO(oqVar.vSN));
                }
                if (!TextUtils.isEmpty(oqVar.vSO)) {
                    this.kYk.setTextColor(l.wO(oqVar.vSO));
                }
            }
            if (oqVar2 != null) {
                this.kYl.setVisibility(0);
                this.kYm.setText(oqVar2.title);
                this.kYn.setText(oqVar2.kJQ);
                if (!TextUtils.isEmpty(oqVar2.vSN)) {
                    this.kYm.setTextColor(l.wO(oqVar2.vSN));
                }
                if (!TextUtils.isEmpty(oqVar2.vSO)) {
                    this.kYn.setTextColor(l.wO(oqVar2.vSO));
                }
            }
        }
        if (this.kIK.atg() && !this.kIK.atm()) {
            x.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.kIK.atC().vRf == null || this.kIK.atC().vRf.size() <= 0) {
            if (this.kYo != null) {
                this.kYo.setVisibility(8);
            }
            this.kXV.findViewById(R.h.bPO).setVisibility(8);
        } else {
            if (this.kYo == null) {
                this.kYo = ((ViewStub) this.kXV.findViewById(R.h.bRR)).inflate();
            }
            this.kXV.findViewById(R.h.bPO).setVisibility(8);
            View view = this.kYo;
            b bVar = this.kIK;
            OnClickListener onClickListener = this.inN;
            LinkedList linkedList2 = bVar.atC().vRf;
            if (linkedList2.size() == 1) {
                view.findViewById(R.h.bRV).setVisibility(0);
                oqVar = (oq) linkedList2.get(0);
                ((TextView) view.findViewById(R.h.cKo)).setText(oqVar.title);
                ((TextView) view.findViewById(R.h.cKl)).setText(oqVar.kJQ);
                view.findViewById(R.h.bRV).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(oqVar.vSN)) {
                    ((TextView) view.findViewById(R.h.cKo)).setTextColor(l.wO(oqVar.vSN));
                }
                if (!TextUtils.isEmpty(oqVar.vSO)) {
                    ((TextView) view.findViewById(R.h.cKl)).setTextColor(l.wO(oqVar.vSO));
                }
                view.findViewById(R.h.bRW).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                oqVar = (oq) linkedList2.get(0);
                ((TextView) view.findViewById(R.h.cKo)).setText(oqVar.title);
                ((TextView) view.findViewById(R.h.cKl)).setText(oqVar.kJQ);
                if (!TextUtils.isEmpty(oqVar.vSN)) {
                    ((TextView) view.findViewById(R.h.cKo)).setTextColor(l.wO(oqVar.vSN));
                }
                if (!TextUtils.isEmpty(oqVar.vSO)) {
                    ((TextView) view.findViewById(R.h.cKl)).setTextColor(l.wO(oqVar.vSO));
                }
                oqVar = (oq) linkedList2.get(1);
                ((TextView) view.findViewById(R.h.cKp)).setText(oqVar.title);
                ((TextView) view.findViewById(R.h.cKm)).setText(oqVar.kJQ);
                if (!TextUtils.isEmpty(oqVar.vSN)) {
                    ((TextView) view.findViewById(R.h.cKp)).setTextColor(l.wO(oqVar.vSN));
                }
                if (!TextUtils.isEmpty(oqVar.vSO)) {
                    ((TextView) view.findViewById(R.h.cKm)).setTextColor(l.wO(oqVar.vSO));
                }
                view.findViewById(R.h.bRV).setOnClickListener(onClickListener);
                view.findViewById(R.h.bRW).setOnClickListener(onClickListener);
            }
        }
        if (this.kIK.atx()) {
            this.kYp.setVisibility(8);
        } else {
            this.kYp.setVisibility(0);
            TextView textView = (TextView) this.kYp.findViewById(R.h.bSe);
            if (TextUtils.isEmpty(this.kIK.atB().vSg)) {
                m.b(textView, this.kIK.atC().status);
            } else {
                textView.setText(this.kIK.atB().vSg);
            }
        }
        if (this.kIK.atC().vRo == null && this.kIK.atx()) {
            this.kYq.setVisibility(0);
        } else {
            this.kYq.setVisibility(8);
        }
    }
}
