package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    protected TextView iiq;
    private LinearLayout kOb;
    private RelativeLayout kYr;
    private TextView kYs;
    private View kYt;
    private ImageView kYu;
    private ImageView kYv;
    private ImageView kYw;
    private ImageView kYx;
    private ImageView kYy;

    public e(Context context) {
        super(context);
    }

    protected final void axn() {
        this.iiq = (TextView) axm().findViewById(R.h.bSm);
        this.kYr = (RelativeLayout) axm().findViewById(R.h.bRu);
        this.kOb = (LinearLayout) axm().findViewById(R.h.bQd);
        this.kYs = (TextView) axm().findViewById(R.h.bWC);
        this.kYt = axm().findViewById(R.h.bQb);
        this.kYu = (ImageView) axm().findViewById(R.h.bQc);
        this.kYv = (ImageView) this.kXV.findViewById(R.h.cvL);
        this.kYw = (ImageView) this.kXV.findViewById(R.h.cvK);
        this.kYx = (ImageView) this.kXV.findViewById(R.h.bRr);
        this.kYy = (ImageView) this.kXV.findViewById(R.h.bRt);
    }

    protected final void axo() {
        if (this.kXX != null) {
            this.kXX.setText(this.kIK.atB().kLa);
        }
        if (this.kIK.atB().vRI != null && this.kIK.atB().vRI.size() > 0) {
            oq oqVar = (oq) this.kIK.atB().vRI.get(0);
            if (TextUtils.isEmpty(oqVar.title)) {
                this.iiq.setText("");
            } else {
                this.iiq.setText(oqVar.title);
            }
        }
        if (this.kIK.atx()) {
            ef(true);
            this.kYx.setAlpha(255);
            if (this.kYx.getBackground() != null) {
                this.kYx.getBackground().setAlpha(255);
            }
            String str = this.kIK.atC().code;
            if (!TextUtils.isEmpty(str)) {
                this.kYt.setOnClickListener(this.inN);
                this.kYu.setOnClickListener(this.inN);
                this.kYs.setOnClickListener(this.inN);
                switch (this.kIK.atC().vRe) {
                    case 0:
                        if (str.length() > 40) {
                            this.kYs.setText("");
                            break;
                        } else {
                            this.kYs.setText(m.wW(str));
                            break;
                        }
                    case 1:
                    case 2:
                        if (str.length() <= 40) {
                            if (!this.kIK.atq()) {
                                this.kYs.setText("");
                                break;
                            } else {
                                this.kYs.setText(m.wW(str));
                                break;
                            }
                        }
                        this.kYs.setText("");
                        break;
                    default:
                        break;
                }
            }
            x.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
            ef(false);
        } else {
            this.kYs.setText("");
            this.kYu.setVisibility(8);
            this.kYt.setVisibility(8);
            this.kYx.setAlpha(90);
            if (this.kYx.getBackground() != null) {
                this.kYx.getBackground().setAlpha(90);
            }
        }
        LayoutParams layoutParams = this.kYr.getLayoutParams();
        layoutParams.height = ((this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mContext.getResources().getDimensionPixelSize(R.f.bvw) * 2)) * 3) / 5;
        x.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3)});
        this.kYr.setLayoutParams(layoutParams);
    }

    public final void r(boolean z, boolean z2) {
    }

    public final void ef(boolean z) {
        if (TextUtils.isEmpty(this.kIK.atC().code) || !z || this.kIK.atC().vRe == 0 || this.kIK.atB().vSq) {
            this.kYu.setVisibility(8);
            this.kYt.setVisibility(8);
            return;
        }
        this.kYu.setVisibility(0);
        this.kYt.setVisibility(0);
    }

    public final void ob(int i) {
        if (!TextUtils.isEmpty(this.kIK.atC().vRp)) {
            this.kYx.setBackgroundDrawable(null);
            this.kYy.setVisibility(0);
            axs();
        } else if (this.kXV != null) {
            this.kYx.setBackgroundResource(i);
            this.kYy.setVisibility(8);
        }
    }

    public final void a(ShapeDrawable shapeDrawable) {
        if (!TextUtils.isEmpty(this.kIK.atC().vRp)) {
            this.kYx.setBackgroundDrawable(null);
            this.kYy.setVisibility(0);
            axs();
        } else if (this.kXV != null) {
            this.kYx.setBackgroundDrawable(shapeDrawable);
            this.kYy.setVisibility(8);
        }
    }

    public final void eg(boolean z) {
        if (TextUtils.isEmpty(this.kIK.atC().vRp)) {
            this.kYw.setVisibility(0);
            this.kYv.setVisibility(0);
            return;
        }
        this.kYw.setVisibility(8);
        this.kYv.setVisibility(8);
    }

    private void axs() {
        a aVar = new a();
        aVar.hDD = com.tencent.mm.compatible.util.e.bnF;
        o.PB();
        aVar.hDW = null;
        aVar.hDC = com.tencent.mm.plugin.card.model.m.wk(this.kIK.atC().vRp);
        aVar.hDA = true;
        aVar.hDY = true;
        aVar.hDZ = (float) this.mContext.getResources().getDimensionPixelSize(R.f.bwx);
        aVar.hEa = true;
        aVar.hDy = true;
        aVar.hDP = R.g.bAC;
        aVar.hDH = com.tencent.mm.bv.a.aa(this.mContext, R.f.bwz);
        aVar.hDG = com.tencent.mm.bv.a.eA(this.mContext);
        o.PA().a(this.kIK.atC().vRp, this.kYx, aVar.PK());
        x.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.kIK.atC().vRp);
    }
}
