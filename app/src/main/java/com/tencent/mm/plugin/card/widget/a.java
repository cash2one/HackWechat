package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements g {
    protected LayoutInflater DF;
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected OnClickListener inN;
    protected b kIK;
    protected View kXV;
    protected ImageView kXW;
    protected TextView kXX;
    protected Context mContext;

    protected abstract void axn();

    protected abstract void axo();

    public a(Context context) {
        this.mContext = context;
    }

    public final void k(b bVar) {
        this.kIK = bVar;
    }

    public final View axl() {
        if (this.kIK == null || this.kIK.atB() == null) {
            x.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        int i;
        this.DF = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.DF;
        if (!this.kIK.atj()) {
            if (this.kIK.atk()) {
                i = R.i.dcK;
            } else if (this.kIK.ati()) {
                i = R.i.dcq;
            } else if (this.kIK.atl()) {
                i = R.i.dbX;
            } else if (this.kIK.atm()) {
                i = R.i.dci;
            }
            this.kXV = layoutInflater.inflate(i, null);
            this.kXW = (ImageView) this.kXV.findViewById(R.h.bKB);
            this.kXX = (TextView) this.kXV.findViewById(R.h.app_name);
            axn();
            amg();
            return this.kXV;
        }
        i = R.i.dbT;
        this.kXV = layoutInflater.inflate(i, null);
        this.kXW = (ImageView) this.kXV.findViewById(R.h.bKB);
        this.kXX = (TextView) this.kXV.findViewById(R.h.app_name);
        axn();
        amg();
        return this.kXV;
    }

    private void amg() {
        if (this.kIK == null || this.kIK.atB() == null) {
            x.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return;
        }
        if (!bh.ov(this.kIK.atB().kJP)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwm);
            if (this.kIK.atg() && this.kIK.atj()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwk);
            } else if (this.kIK.atg() && this.kIK.ati()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwA);
            } else if (this.kIK.atg() && this.kIK.atk()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwG);
            } else if (this.kIK.atm()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                m.a(this.kXW, this.kIK.atB().kJP, dimensionPixelSize, R.g.bDT, true);
            }
        }
        if (!bh.ov(this.kIK.atB().kLa)) {
            this.kXX.setText(this.kIK.atB().kLa);
        }
        axo();
    }

    protected final View axm() {
        return this.kXV;
    }

    public final void release() {
        this.inN = null;
        this.mContext = null;
    }

    public void ob(int i) {
    }

    public void ef(boolean z) {
    }

    public final void f(b bVar) {
        this.kIK = bVar;
        amg();
    }

    public void a(ShapeDrawable shapeDrawable) {
    }

    public void eg(boolean z) {
    }

    public void r(boolean z, boolean z2) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.inN = onClickListener;
    }
}
