package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class f extends a {
    protected TextView iiq;
    public ArrayList<kj> kIQ;
    private ImageView kYA;
    private TextView kYB;
    private TextView kYC;
    private View kYD;
    private TextView kYE;
    private TextView kYF;
    private ImageView kYG;
    private TextView kYH;
    private View kYz;

    public f(Context context) {
        super(context);
    }

    protected final void axn() {
        this.iiq = (TextView) axm().findViewById(R.h.bSm);
        this.kYz = axm().findViewById(R.h.bPN);
        this.kYA = (ImageView) axm().findViewById(R.h.cRm);
        this.kYB = (TextView) axm().findViewById(R.h.cRl);
        this.kYC = (TextView) axm().findViewById(R.h.cRk);
        this.kYD = axm().findViewById(R.h.cRo);
        this.kYE = (TextView) axm().findViewById(R.h.cRq);
        this.kYF = (TextView) axm().findViewById(R.h.cRp);
        this.kYG = (ImageView) axm().findViewById(R.h.cRn);
        this.kYH = (TextView) axm().findViewById(R.h.cRj);
    }

    protected final void axo() {
        if (this.kIK.atB().vSk != null && !TextUtils.isEmpty(this.kIK.atB().vSk.title)) {
            this.kXX.setText(this.kIK.atB().vSk.title);
        } else if (TextUtils.isEmpty(this.kIK.atB().kLa)) {
            this.kXX.setText("");
        } else {
            this.kXX.setText(this.kIK.atB().kLa);
        }
        if (this.kIK.atB().vSk == null || TextUtils.isEmpty(this.kIK.atB().vSk.kJQ)) {
            this.iiq.setText("");
            this.iiq.setVisibility(8);
        } else {
            this.iiq.setText(this.kIK.atB().vSk.kJQ);
            this.iiq.setVisibility(0);
        }
        x.i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (bh.ov(this.kIK.atB().vRQ)) {
            m.a(this.kYA, R.g.bAv, l.wO(this.kIK.atB().hbM));
        } else {
            m.a(this.mContext, this.kYA, this.kIK.atB().vRQ, this.mContext.getResources().getDimensionPixelSize(R.f.bwG), R.g.bAv, l.wO(this.kIK.atB().hbM));
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        oq oqVar;
        if (this.kIK.atB().vRI != null && this.kIK.atB().vRI.size() >= 2) {
            x.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            oqVar = (oq) this.kIK.atB().vRI.get(0);
            oq oqVar2 = (oq) this.kIK.atB().vRI.get(1);
            stringBuilder.append(oqVar.title).append(" - ").append(oqVar2.title);
            if (!(TextUtils.isEmpty(oqVar.kJR) || TextUtils.isEmpty(oqVar2.kJR))) {
                stringBuilder2.append(oqVar.kJR).append(" ").append(oqVar.kJQ);
                stringBuilder2.append(" - ");
                stringBuilder2.append(oqVar2.kJR).append(" ").append(oqVar2.kJQ);
            }
        } else if (this.kIK.atB().vRI != null && this.kIK.atB().vRI.size() == 1) {
            x.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            oqVar = (oq) this.kIK.atB().vRI.get(0);
            stringBuilder.append(oqVar.title);
            stringBuilder2.append(oqVar.kJQ);
        }
        if (TextUtils.isEmpty(stringBuilder.toString())) {
            this.kYB.setText("");
        } else {
            this.kYB.setText(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(stringBuilder2.toString())) {
            x.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.kYC.setText(stringBuilder2.toString());
            this.kYC.setVisibility(0);
        } else if (TextUtils.isEmpty(this.kIK.atB().vRY)) {
            this.kYC.setVisibility(8);
        } else {
            x.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.kYC.setText(this.kIK.atB().vRY);
            this.kYC.setVisibility(0);
        }
        x.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.kIK.atB().vRM);
        if (this.kIK.atB().vRM <= 0) {
            this.kYD.setVisibility(8);
            this.kYH.setVisibility(8);
        } else {
            kj kjVar;
            this.kYD.setVisibility(0);
            this.kYD.setOnClickListener(this.inN);
            m.a(this.kYG, R.g.bAw, l.wO(this.kIK.atB().hbM));
            if (this.kIQ == null || this.kIQ.size() <= 0) {
                kjVar = null;
            } else {
                kjVar = (kj) this.kIQ.get(0);
            }
            if (this.kIK.atB().vRM == 1 && kjVar != null) {
                this.kYE.setText(kjVar.name);
                this.kYF.setText(this.mContext.getString(R.l.dPt, new Object[]{l.f(this.mContext, kjVar.vRw), kjVar.hxu}));
                this.kYH.setVisibility(8);
                this.kYD.setTag(kjVar.name);
            } else if (this.kIK.atB().vRM > 1 && kjVar != null) {
                this.kYE.setText(kjVar.name);
                this.kYF.setText(this.mContext.getString(R.l.dPt, new Object[]{l.f(this.mContext, kjVar.vRw), kjVar.hxu}));
                this.kYH.setVisibility(0);
                this.kYH.setOnClickListener(this.inN);
                this.kYD.setTag(kjVar.name);
            } else if (this.kIK.atB().vRM > 0) {
                this.kYE.setText(R.l.dNK);
                this.kYF.setText(this.mContext.getString(R.l.dPN, new Object[]{Integer.valueOf(this.kIK.atB().vRM)}));
                this.kYH.setVisibility(8);
                this.kYH.setOnClickListener(null);
                this.kYD.setTag(this.mContext.getString(R.l.dNK));
            }
        }
        if (this.kIK.atA()) {
            this.kYz.setVisibility(8);
        } else {
            this.kYz.setVisibility(0);
        }
    }
}
