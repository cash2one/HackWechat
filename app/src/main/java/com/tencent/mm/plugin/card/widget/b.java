package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class b extends a {
    private final String TAG = "MicroMsg.CardWidgetCommon";
    protected TextView jpW;
    private boolean kVW = false;
    protected TextView kXY;
    protected TextView kXZ;
    protected Button kYa;
    protected LinearLayout kYb;
    protected TextView kYc;
    protected ImageView kYd;
    protected View kYe;
    protected ImageView kYf;

    public b(Context context) {
        super(context);
    }

    protected final void axn() {
        this.jpW = (TextView) this.kXV.findViewById(R.h.bSm);
        this.kXY = (TextView) this.kXV.findViewById(R.h.bSg);
        this.kXZ = (TextView) this.kXV.findViewById(R.h.bPH);
        this.kYa = (Button) this.kXV.findViewById(R.h.bQh);
        this.kYb = (LinearLayout) this.kXV.findViewById(R.h.cZG);
        this.kYd = (ImageView) this.kYb.findViewById(R.h.bKJ);
        this.kYe = this.kXV.findViewById(R.h.bPN);
        this.kYf = (ImageView) this.kXV.findViewById(R.h.bQc);
        this.kYc = (TextView) this.kXV.findViewById(R.h.bRA);
    }

    protected final void axo() {
        if (this.kIK.atB().vRI != null && this.kIK.atB().vRI.size() > 0) {
            oq oqVar = (oq) this.kIK.atB().vRI.get(0);
            if (!bh.ov(oqVar.title)) {
                this.jpW.setText(oqVar.title);
            }
            if (bh.ov(oqVar.kJQ)) {
                this.kXY.setVisibility(8);
            } else {
                this.kXY.setText(oqVar.kJQ);
                this.kXY.setVisibility(0);
            }
            LayoutParams layoutParams = (LayoutParams) this.kXY.getLayoutParams();
            if (bh.ov(oqVar.kJR)) {
                this.kXZ.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bvw);
            } else {
                this.kXZ.setText(oqVar.kJR);
                this.kXZ.setVisibility(0);
                layoutParams.bottomMargin = 0;
            }
            this.kXY.setLayoutParams(layoutParams);
            this.kXY.invalidate();
        }
        if (this.kYa == null || this.kYf == null) {
            x.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.kIK.atC() == null) {
            x.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.kYa.setVisibility(8);
            this.kYf.setVisibility(8);
        } else {
            if (this.kIK.atC().vRm != null) {
                x.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.kIK.atC().vRm.title);
                x.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.kIK.atC().vRm.url);
                x.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.kIK.atC().vRm.kJR);
            }
            oq oqVar2 = this.kIK.atC().vRn;
            if (oqVar2 != null) {
                x.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + oqVar2.title);
                x.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + oqVar2.vSM);
                x.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + oqVar2.kJR);
            }
            bri com_tencent_mm_protocal_c_bri = this.kIK.atB().vSb;
            LinearLayout linearLayout = (LinearLayout) this.kYb.findViewById(R.h.bQq);
            if (com_tencent_mm_protocal_c_bri == null || bh.cA(com_tencent_mm_protocal_c_bri.wSP)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator it = com_tencent_mm_protocal_c_bri.wSP.iterator();
                while (it.hasNext()) {
                    oq oqVar3 = (oq) it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dbV, null);
                    TextView textView = (TextView) inflate.findViewById(R.h.bQp);
                    ((TextView) inflate.findViewById(R.h.bQt)).setText(oqVar3.title);
                    textView.setText(oqVar3.kJQ);
                    linearLayout.addView(inflate);
                }
            }
            if (oqVar2 != null && !TextUtils.isEmpty(oqVar2.title) && oqVar2.vSM != 0 && this.kIK.atx()) {
                this.kYa.setClickable(false);
                this.kYa.setVisibility(0);
                this.kYa.setTextColor(this.mContext.getResources().getColor(R.e.bul));
                this.kYa.setText(oqVar2.title);
                if (oqVar2 == null || TextUtils.isEmpty(oqVar2.kJQ)) {
                    this.kYc.setVisibility(8);
                } else {
                    this.kYc.setText(oqVar2.kJQ);
                    this.kYc.setVisibility(0);
                }
                this.kYf.setVisibility(8);
                if ((oqVar2.vSM & 2) > 0) {
                    this.kYa.setBackgroundDrawable(l.z(this.mContext, l.ba(this.kIK.atB().hbM, 150)));
                    this.kYc.setTextColor(l.wO(this.kIK.atB().hbM));
                } else if ((oqVar2.vSM & 4) > 0) {
                    this.kYa.setBackgroundDrawable(l.z(this.mContext, this.mContext.getResources().getColor(R.e.bsZ)));
                    this.kYc.setTextColor(this.mContext.getResources().getColor(R.e.bts));
                } else {
                    this.kYa.setBackgroundDrawable(l.z(this.mContext, l.wO(this.kIK.atB().hbM)));
                    this.kYc.setTextColor(this.mContext.getResources().getColor(R.e.bts));
                }
            } else if (this.kIK.atC().vRm != null && !TextUtils.isEmpty(this.kIK.atC().vRm.title) && !TextUtils.isEmpty(this.kIK.atC().vRm.url) && this.kIK.atx()) {
                this.kYa.setClickable(true);
                this.kYa.setVisibility(0);
                this.kYa.setBackgroundDrawable(l.z(this.mContext, l.wO(this.kIK.atB().hbM)));
                this.kYa.setTextColor(this.mContext.getResources().getColorStateList(R.e.bul));
                this.kYa.setText(this.kIK.atC().vRm.title);
                if (this.kIK.atC().vRm == null || TextUtils.isEmpty(this.kIK.atC().vRm.kJR)) {
                    this.kYc.setVisibility(8);
                } else {
                    this.kYc.setTextColor(this.mContext.getResources().getColor(R.e.bts));
                    this.kYc.setText(this.kIK.atC().vRm.kJR);
                    this.kYc.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.kIK.atC().code)) {
                    this.kYf.setVisibility(8);
                } else {
                    this.kYf.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(this.kIK.atC().code) && this.kIK.atx()) {
                x.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.kYf.setVisibility(8);
                this.kYc.setVisibility(8);
                this.kYa.setClickable(true);
                this.kYa.setVisibility(0);
                this.kYa.setBackgroundDrawable(l.z(this.mContext, l.wO(this.kIK.atB().hbM)));
                this.kYa.setTextColor(this.mContext.getResources().getColorStateList(R.e.bul));
                this.kYa.setText(R.l.dPC);
            } else if (this.kIK.atx()) {
                x.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.kYa.setVisibility(8);
                this.kYc.setVisibility(8);
                this.kYf.setVisibility(8);
            } else {
                x.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.kIK.atC().status);
                this.kYf.setVisibility(8);
                this.kYc.setVisibility(8);
                this.kYa.setClickable(true);
                this.kYa.setVisibility(0);
                this.kYa.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
                this.kYa.setBackgroundDrawable(l.z(this.mContext, this.mContext.getResources().getColor(R.e.brG)));
                if (TextUtils.isEmpty(this.kIK.atB().vSg)) {
                    m.b(this.kYa, this.kIK.atC().status);
                } else {
                    this.kYa.setText(this.kIK.atB().vSg);
                }
            }
        }
        axp();
        this.kYb.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bAB));
        axq();
        this.kXV.invalidate();
    }

    private void axp() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kYb.getLayoutParams();
        if (this.kIK.atg()) {
            this.kXW.setVisibility(0);
            this.kYd.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bwj);
        } else if (this.kIK.ath() && this.kVW) {
            this.kXW.setVisibility(8);
            this.kYd.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.kIK.ath()) {
            this.kXW.setVisibility(0);
            this.kYd.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bwj);
        }
        this.kYb.setLayoutParams(layoutParams);
    }

    public final void ob(int i) {
        RelativeLayout.LayoutParams layoutParams;
        this.kYb.setBackgroundResource(i);
        this.kYd.setVisibility(8);
        if (i == 0) {
            layoutParams = (RelativeLayout.LayoutParams) this.kYb.getLayoutParams();
            if (this.kIK.atg()) {
                this.kXW.setVisibility(8);
                layoutParams.topMargin = 0;
                this.kYd.setVisibility(0);
                m.a(this.kYd, this.kIK.atB().kJP, this.mContext.getResources().getDimensionPixelSize(R.f.bwf), R.g.bDT, false);
            } else if (this.kIK.ath() && this.kVW) {
                this.kXW.setVisibility(8);
                layoutParams.topMargin = 0;
            }
            this.kYb.setLayoutParams(layoutParams);
            this.kYb.invalidate();
        } else {
            axp();
        }
        axq();
        layoutParams = (RelativeLayout.LayoutParams) this.kYe.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.f.buv);
            layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.f.buv);
        }
        this.kYe.setLayoutParams(layoutParams);
        this.kYe.invalidate();
        this.kXV.invalidate();
    }

    private void axq() {
        LayoutParams layoutParams = (LayoutParams) this.kYa.getLayoutParams();
        if (this.kIK.atC().vRm != null && !TextUtils.isEmpty(this.kIK.atC().vRm.kJR)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvJ);
        } else if (this.kIK.atC().vRn != null && !TextUtils.isEmpty(this.kIK.atC().vRn.kJQ)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvJ);
        } else if (this.kIK.atB().vRI == null || this.kIK.atB().vRI.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvw);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvJ);
        }
        this.kYa.setLayoutParams(layoutParams);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (this.kYa != null) {
            this.kYa.setOnClickListener(onClickListener);
        }
        if (this.kYf != null) {
            this.kYf.setOnClickListener(onClickListener);
        }
    }

    public final void r(boolean z, boolean z2) {
        if (this.kYa != null) {
            oq oqVar = this.kIK.atC().vRn;
            if (oqVar != null && !TextUtils.isEmpty(oqVar.title) && oqVar.vSM != 0 && this.kIK.atx()) {
                this.kYa.setClickable(false);
                this.kYa.setVisibility(0);
                this.kYf.setVisibility(8);
            } else if (this.kIK.atC().vRm != null && !TextUtils.isEmpty(this.kIK.atC().vRm.title) && !TextUtils.isEmpty(this.kIK.atC().vRm.url) && this.kIK.atx()) {
                this.kYa.setVisibility(0);
                this.kYa.setEnabled(true);
                if (TextUtils.isEmpty(this.kIK.atC().code) || this.kIK.atC().vRe == 0) {
                    this.kYf.setVisibility(8);
                } else {
                    this.kYf.setVisibility(0);
                }
            } else if (z && !TextUtils.isEmpty(this.kIK.atC().code) && this.kIK.atx()) {
                this.kYa.setVisibility(0);
                this.kYa.setEnabled(z2);
                this.kYf.setVisibility(8);
            } else if (!z || this.kIK.atx()) {
                this.kYa.setVisibility(8);
                this.kYf.setVisibility(8);
            } else {
                this.kYa.setVisibility(0);
                this.kYa.setEnabled(false);
                this.kYf.setVisibility(8);
            }
        }
    }

    public final void axr() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kYb.getLayoutParams();
        if (this.kIK.ath()) {
            this.kXW.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bwj);
        }
        this.kYb.setLayoutParams(layoutParams);
        this.kYb.invalidate();
    }

    public final void eg(boolean z) {
        this.kVW = z;
        if (z) {
            this.kYe.setVisibility(0);
        } else {
            this.kYe.setVisibility(8);
        }
    }
}
