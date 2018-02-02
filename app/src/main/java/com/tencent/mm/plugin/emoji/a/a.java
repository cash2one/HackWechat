package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a {
    private final String TAG;
    protected TextView jJn;
    protected FrameLayout ltA;
    protected View ltB;
    private View ltf;
    private final int ltg;
    private final int lth;
    private final int lti;
    private int[] ltj;
    private int ltk;
    public f ltl;
    protected View ltm;
    protected ImageView ltn;
    protected ImageView lto;
    protected TextView ltp;
    protected TextView ltq;
    protected ProgressBar ltr;
    protected ViewGroup lts;
    protected View ltt;
    protected TextView ltu;
    protected ImageView ltv;
    protected View ltw;
    protected ProgressBar ltx;
    protected TextView lty;
    protected TextView ltz;
    Context mContext;
    private LayoutInflater mLayoutInflater;
    public int mPosition;

    protected abstract void aAn();

    protected abstract int[] aAo();

    protected abstract int aAp();

    protected abstract boolean aAw();

    public a(Context context, View view) {
        this(context, view, a.ltF);
    }

    private a(Context context, View view, int i) {
        this.TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
        this.ltg = R.i.dfE;
        this.lth = R.i.dfP;
        this.lti = R.i.dfQ;
        this.ltj = new int[]{-1, -1};
        this.ltk = -1;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        if (view == null) {
            switch (2.ltE[i - 1]) {
                case 1:
                    view = oy(this.ltg);
                    break;
                case 2:
                    view = oy(this.lti);
                    break;
                case 3:
                    view = oy(this.lth);
                    break;
                default:
                    view = oy(this.ltg);
                    break;
            }
        }
        this.ltB = view;
        if (view != null) {
            this.ltf = view;
            this.ltm = this.ltf.findViewById(R.h.crr);
            this.lto = (ImageView) this.ltf.findViewById(R.h.crS);
            this.ltn = (ImageView) this.ltf.findViewById(R.h.cry);
            this.jJn = (TextView) this.ltf.findViewById(R.h.crF);
            this.ltp = (TextView) this.ltf.findViewById(R.h.crt);
            this.ltq = (TextView) this.ltf.findViewById(R.h.crA);
            this.ltr = (ProgressBar) this.ltf.findViewById(R.h.cDr);
            this.ltt = this.ltf.findViewById(R.h.crH);
            this.lts = (ViewGroup) this.ltf.findViewById(R.h.crJ);
            this.ltu = (TextView) this.ltf.findViewById(R.h.crO);
            this.ltv = (ImageView) this.ltf.findViewById(R.h.crP);
            this.ltw = this.ltf.findViewById(R.h.crI);
            this.ltx = (ProgressBar) this.ltf.findViewById(R.h.crv);
            this.lty = (TextView) this.ltf.findViewById(R.h.crq);
            this.ltz = (TextView) this.ltf.findViewById(R.h.crG);
            this.ltA = (FrameLayout) this.ltf.findViewById(R.h.crD);
        }
        aAn();
        if (i == a.ltF) {
            int[] aAo = aAo();
            if (this.ltn != null && aAo[0] >= 0 && aAo[1] >= 0 && !(aAo[0] == this.ltj[0] && aAo[1] == this.ltj[1])) {
                LayoutParams layoutParams = this.ltn.getLayoutParams();
                layoutParams.width = aAo[0];
                layoutParams.height = aAo[1];
                this.ltn.setLayoutParams(layoutParams);
                this.ltj = aAo;
            }
            int aAp = aAp();
            if (!(this.ltf == null || aAp < 0 || this.ltk == aAp)) {
                this.ltf.setMinimumHeight(aAp);
                if (this.ltm != null) {
                    this.ltm.setMinimumHeight(aAp);
                }
            }
        }
        view.setTag(this);
    }

    private View oy(int i) {
        if (this.mLayoutInflater == null || i <= 0) {
            return null;
        }
        return this.mLayoutInflater.inflate(i, null);
    }

    public final void setTitle(String str) {
        this.jJn.setText(str);
    }

    public final void setTitle(int i) {
        this.jJn.setText(i);
    }

    public final ImageView aAq() {
        return this.ltn;
    }

    public final void oz(int i) {
        this.ltn.setImageResource(i);
    }

    public final ImageView aAr() {
        return this.lto;
    }

    public final void oA(int i) {
        this.lto.setVisibility(i);
    }

    public final void oB(int i) {
        this.lto.setImageResource(i);
    }

    public final void oC(int i) {
        this.ltt.setVisibility(i);
    }

    public final void aAs() {
        this.ltp.setVisibility(8);
        this.ltq.setVisibility(8);
    }

    public final void xR(String str) {
        this.ltp.setText(str);
    }

    public final void xS(String str) {
        if (bh.ov(str)) {
            this.ltq.setVisibility(8);
            return;
        }
        this.ltq.setVisibility(0);
        this.ltq.setText(str);
    }

    public final void a(com.tencent.mm.plugin.emoji.model.h.a aVar) {
        if (this.ltt != null) {
            this.ltt.setOnClickListener(new 1(this, aVar));
        }
    }

    protected boolean a(com.tencent.mm.plugin.emoji.model.h.a aVar, View view) {
        return true;
    }

    protected void b(com.tencent.mm.plugin.emoji.model.h.a aVar, View view) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final String aAt() {
        return (this.ltl == null || this.ltl.luN == null) ? null : this.ltl.luN.vIR;
    }

    public final int aAu() {
        return (this.ltl == null ? null : Integer.valueOf(this.ltl.mStatus)).intValue();
    }

    public final String aAv() {
        return (this.ltl == null || this.ltl.luN == null) ? null : this.ltl.luN.wau;
    }

    public final int getProgress() {
        return this.ltl == null ? 0 : this.ltl.sm;
    }

    protected final void aAx() {
        this.ltr.setVisibility(8);
        this.lts.setVisibility(8);
        this.ltt.setEnabled(false);
        this.ltv.setVisibility(8);
        this.ltx.setVisibility(0);
        this.ltx.setProgress(getProgress());
        if (this.ltw == null) {
            this.ltx.setVisibility(0);
        } else {
            this.ltw.setVisibility(0);
        }
    }

    private void aAy() {
        this.ltr.setVisibility(8);
        this.lts.setBackgroundResource(R.g.bAb);
        this.lts.setVisibility(0);
        this.ltt.setEnabled(true);
        this.ltu.setText("");
        if (this.ltw == null) {
            this.ltx.setVisibility(4);
        } else {
            this.ltw.setVisibility(4);
        }
        this.ltu.setVisibility(0);
        this.ltu.setText(R.l.eas);
        this.ltu.setTextColor(this.mContext.getResources().getColorStateList(R.e.bul));
        this.ltv.setVisibility(8);
    }

    public void aAz() {
        if (this.ltl != null && aAw()) {
            this.ltu.setVisibility(8);
            this.ltu.setTextColor(this.mContext.getResources().getColorStateList(R.e.brz));
            switch (aAu()) {
                case 0:
                    aAy();
                    return;
                case 3:
                    aAy();
                    return;
                case 4:
                case 12:
                    this.ltr.setVisibility(8);
                    this.lts.setBackgroundResource(R.g.bAe);
                    this.lts.setVisibility(0);
                    if (this.ltw == null) {
                        this.ltx.setVisibility(4);
                    } else {
                        this.ltw.setVisibility(4);
                    }
                    this.ltt.setEnabled(true);
                    this.ltv.setVisibility(4);
                    this.ltu.setVisibility(0);
                    if (this.ltl.luN != null) {
                        this.ltu.setText(this.ltl.luN.wau);
                        return;
                    }
                    return;
                case 6:
                    aAx();
                    return;
                case 7:
                    if (this.ltl.luR) {
                        x.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
                        this.ltr.setVisibility(8);
                        this.lts.setBackgroundResource(R.g.bAb);
                        this.lts.setVisibility(0);
                        this.lts.setTag(aAt());
                        this.ltt.setEnabled(true);
                        this.ltu.setVisibility(0);
                        this.ltu.setText(R.l.ebg);
                        this.ltu.setTextColor(this.mContext.getResources().getColorStateList(R.e.bul));
                        this.ltv.setVisibility(4);
                        if (this.ltw == null) {
                            this.ltx.setVisibility(4);
                            return;
                        } else {
                            this.ltw.setVisibility(4);
                            return;
                        }
                    } else if (this.ltl.luT && e.co(this.ltl.luN.waw, 64)) {
                        this.lts.setVisibility(0);
                        this.lts.setBackgroundResource(R.g.bAd);
                        this.ltu.setVisibility(0);
                        this.ltu.setText(R.l.eaJ);
                        this.ltu.setTextColor(this.mContext.getResources().getColorStateList(R.e.bul));
                        this.ltv.setVisibility(4);
                        this.ltt.setEnabled(true);
                        if (this.ltw == null) {
                            this.ltx.setVisibility(4);
                            return;
                        } else {
                            this.ltw.setVisibility(4);
                            return;
                        }
                    } else {
                        this.ltr.setVisibility(8);
                        this.lts.setVisibility(0);
                        this.lts.setBackgroundResource(R.g.bAe);
                        this.ltu.setVisibility(0);
                        this.ltu.setText(R.l.eau);
                        this.ltu.setTextColor(this.mContext.getResources().getColorStateList(R.e.bry));
                        this.ltv.setVisibility(4);
                        this.ltt.setEnabled(false);
                        if (this.ltw == null) {
                            this.ltx.setVisibility(4);
                            return;
                        } else {
                            this.ltw.setVisibility(4);
                            return;
                        }
                    }
                case 8:
                    this.ltr.setVisibility(8);
                    this.lts.setBackgroundDrawable(null);
                    this.lts.setVisibility(0);
                    this.ltt.setEnabled(false);
                    this.ltu.setVisibility(0);
                    this.ltu.setText(R.l.eav);
                    this.ltv.setVisibility(4);
                    if (this.ltw == null) {
                        this.ltx.setVisibility(4);
                        return;
                    } else {
                        this.ltw.setVisibility(4);
                        return;
                    }
                case 10:
                    this.ltr.setVisibility(8);
                    this.lts.setBackgroundResource(R.g.bAe);
                    this.lts.setVisibility(0);
                    this.ltu.setVisibility(0);
                    this.ltu.setText(R.l.eaE);
                    this.ltv.setVisibility(4);
                    this.ltt.setEnabled(true);
                    if (this.ltw == null) {
                        this.ltx.setVisibility(4);
                        return;
                    } else {
                        this.ltw.setVisibility(4);
                        return;
                    }
                case 11:
                    this.ltr.setVisibility(0);
                    this.lts.setBackgroundResource(R.g.bAe);
                    this.lts.setVisibility(0);
                    this.ltu.setVisibility(0);
                    this.ltu.setText("");
                    this.ltt.setEnabled(false);
                    this.ltv.setVisibility(4);
                    if (this.ltw == null) {
                        this.ltx.setVisibility(4);
                        return;
                    } else {
                        this.ltw.setVisibility(4);
                        return;
                    }
                default:
                    x.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[]{Integer.valueOf(aAu())});
                    return;
            }
        }
    }

    public final View aAA() {
        return this.ltB;
    }
}
