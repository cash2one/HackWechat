package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class b extends i {
    private com.tencent.mm.plugin.card.base.b kIK;
    private View kWh;
    private TextView kWi;
    private g kWj;
    private MMActivity kaY;

    public final void initView() {
        this.kaY = this.kWz.avL();
        this.kWj = this.kWz.avN();
    }

    public final void destroy() {
        super.destroy();
        this.kaY = null;
        this.kWj = null;
    }

    public final void update() {
        if (this.kWh == null) {
            this.kWh = ((ViewStub) findViewById(R.h.bPz)).inflate();
            this.kWh.findViewById(R.h.bPp).setOnClickListener(this.kWz.avM());
        }
        this.kIK = this.kWz.avI();
        this.kWj = this.kWz.avN();
        boolean awv = this.kWj.awv();
        boolean aww = this.kWj.aww();
        if (awv) {
            this.kWh.setVisibility(0);
            x.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + awv + " acceptViewEnabled:" + aww);
            Button button = (Button) this.kWh.findViewById(R.h.bPp);
            View findViewById = this.kWh.findViewById(R.h.bPy);
            findViewById.setBackgroundDrawable(null);
            findViewById.setOnClickListener(null);
            int dimensionPixelSize = this.kaY.getResources().getDimensionPixelSize(R.f.bwy);
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            if (aww) {
                if (!TextUtils.isEmpty(this.kIK.atB().vRR)) {
                    button.setText(this.kIK.atB().vRR);
                }
                Drawable d;
                Drawable ch;
                Drawable stateListDrawable;
                if (this.kIK.ati()) {
                    button.setTextColor(l.wO(this.kIK.atB().hbM));
                    d = l.d(this.kaY, l.wO(this.kIK.atB().hbM), dimensionPixelSize);
                    ch = l.ch(l.wO(this.kIK.atB().hbM), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, ch);
                    stateListDrawable.addState(new int[0], d);
                    int[] iArr = new int[]{this.kaY.getResources().getColor(R.e.white), l.wO(this.kIK.atB().hbM)};
                    int[][] iArr2 = new int[][]{new int[]{16842919, 16842910}, new int[0]};
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(new ColorStateList(iArr2, iArr));
                    layoutParams = (LayoutParams) this.kWh.getLayoutParams();
                    layoutParams.topMargin = this.kaY.getResources().getDimensionPixelSize(R.f.bwh);
                    this.kWh.setLayoutParams(layoutParams);
                    this.kWh.findViewById(R.h.cco).setVisibility(8);
                    f avQ = this.kWz.avQ();
                    CheckBox checkBox = (CheckBox) this.kWh.findViewById(R.h.bQy);
                    if (avQ.aua() == null || !avQ.aua().kKc) {
                        x.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
                        checkBox.setVisibility(8);
                    } else {
                        x.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
                        checkBox.setVisibility(0);
                        wc wcVar = this.kIK.atB().vSc;
                        if (wcVar == null || TextUtils.isEmpty(wcVar.text)) {
                            checkBox.setText(avQ.aua().title);
                        } else {
                            checkBox.setText(wcVar.text);
                        }
                        checkBox.setChecked(avQ.aua().kKd);
                        checkBox.setOnClickListener(new 1(this, avQ));
                    }
                } else if (this.kIK.atj() || this.kIK.ath() || this.kIK.atk()) {
                    d = l.ch(l.wO(this.kIK.atB().hbM), dimensionPixelSize);
                    ch = l.ch(l.ba(this.kIK.atB().hbM, ac.CTRL_BYTE), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, ch);
                    stateListDrawable.addState(new int[0], d);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.kaY.getResources().getColor(R.e.bul));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    d = l.ch(l.wO(this.kIK.atB().hbM), dimensionPixelSize);
                    ch = l.ch(l.ba(this.kIK.atB().hbM, ac.CTRL_BYTE), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, ch);
                    stateListDrawable.addState(new int[0], d);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.kaY.getResources().getColor(R.e.bul));
                }
            } else {
                this.kWh.setEnabled(false);
                findViewById.setEnabled(false);
                button.setEnabled(false);
                button.setText(this.kIK.ati() ? this.kIK.atB().vRR : this.kWj.awo());
                if (this.kIK.ati()) {
                    button.setTextColor(l.ba(this.kIK.atB().hbM, 125));
                    button.setBackgroundDrawable(l.d(this.kaY, l.ba(this.kIK.atB().hbM, 125), dimensionPixelSize));
                    layoutParams = (LayoutParams) this.kWh.getLayoutParams();
                    layoutParams.topMargin = this.kaY.getResources().getDimensionPixelSize(R.f.bwi);
                    this.kWh.setLayoutParams(layoutParams);
                    this.kWh.findViewById(R.h.cco).setVisibility(8);
                } else if (this.kIK.atj() || this.kIK.ath() || this.kIK.atk()) {
                    button.setTextColor(this.kaY.getResources().getColor(R.e.bsF));
                    button.setBackgroundDrawable(l.z(this.kaY, this.kaY.getResources().getColor(R.e.brG)));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    button.setTextColor(this.kaY.getResources().getColor(R.e.bsF));
                    button.setBackgroundDrawable(l.z(this.kaY, this.kaY.getResources().getColor(R.e.brG)));
                }
            }
            if (!this.kIK.atj() && !this.kIK.ath()) {
                if (this.kIK.atB().vSd != null && !bh.ov(this.kIK.atB().vSd.text)) {
                    if (this.kWi == null) {
                        this.kWi = (TextView) this.kWh.findViewById(R.h.bPw);
                    }
                    this.kWi.setText(this.kIK.atB().vSd.text);
                    if (!bh.ov(this.kIK.atB().vSd.url)) {
                        this.kWi.setOnClickListener(this.kWz.avM());
                        this.kWi.setTextColor(l.wO(this.kIK.atB().hbM));
                    }
                    this.kWi.setVisibility(0);
                    return;
                } else if (this.kWi != null) {
                    this.kWi.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
        this.kWh.setVisibility(8);
    }

    public final void awW() {
        this.kWh.setVisibility(8);
    }
}
