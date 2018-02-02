package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsCommentFooter extends BasePanelKeybordLayout {
    private MMActivity fmM;
    private boolean okA = true;
    boolean okB = true;
    private TextWatcher okC = new 1(this);
    private ImageButton oku;
    MMEditText okv;
    private Button okw;
    ChatFooterPanel okx;
    boolean oky = false;
    public boolean okz = false;
    bjk qTX = null;
    ImageView rBc;
    Button rBd;
    int rBe = 0;
    public boolean rBf;
    private String rBg = "";
    private boolean rBh = false;
    a rBi;
    d rBj;
    private bi rBk;
    int state = 0;

    interface a {
        void bAH();
    }

    interface c {
        void LK(String str);
    }

    interface d {
        void onShow();
    }

    static /* synthetic */ void h(SnsCommentFooter snsCommentFooter) {
        snsCommentFooter.okx.onPause();
        snsCommentFooter.okx.setVisibility(8);
    }

    public final boolean bAJ() {
        if (this.okv.getText() == null || bh.ov(this.okv.getText().toString())) {
            return true;
        }
        return false;
    }

    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
    }

    public final void bAK() {
        ViewGroup viewGroup = (ViewGroup) inflate(this.fmM, g.qHk, this);
        this.rBc = (ImageView) viewGroup.findViewById(f.qEI);
        this.okw = (Button) viewGroup.findViewById(f.qAI);
        this.rBd = (Button) viewGroup.findViewById(f.qAC);
        this.okv = (MMEditText) viewGroup.findViewById(f.qAA);
        gv(false);
        this.oku = (ImageButton) viewGroup.findViewById(f.bJQ);
        this.oku.setOnClickListener(new 3(this));
        this.okv.setHint(this.fmM.getString(j.qMD));
        this.okv.setOnTouchListener(new 4(this));
        if (e.vro == null) {
            this.okx = new com.tencent.mm.pluginsdk.ui.chat.d(this.fmM);
            return;
        }
        this.okx = e.vro.cv(getContext());
        this.okx.ej(ChatFooterPanel.SCENE_SNS);
        this.okx.setVisibility(8);
        this.okx.setBackgroundResource(i.e.bzY);
        ((LinearLayout) findViewById(f.cIu)).addView(this.okx, -1, 0);
        this.okx.tj();
        this.okx.aF(false);
        this.okx.vjB = new 5(this);
    }

    public void setVisibility(int i) {
        boolean z = false;
        this.state = 0;
        if (i == 0) {
            z = true;
        }
        iJ(z);
        super.setVisibility(i);
    }

    public final void iJ(boolean z) {
        if (this.okx != null) {
            this.rBf = z;
            x.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    bAL();
                    this.okv.requestFocus();
                    this.okx.setVisibility(8);
                } else {
                    bAM();
                    this.okv.requestFocus();
                    amW();
                }
                this.okA = false;
                return;
            }
            this.okx.setVisibility(8);
            this.oku.setImageResource(i.i.dBb);
            bAM();
            requestLayout();
        }
    }

    private void bAL() {
        if (this.fmM.mController.xJg != 1) {
            this.fmM.showVKB();
        }
    }

    private void bAM() {
        if (this.fmM.mController.xJg == 1) {
            this.fmM.aWs();
        }
    }

    private void amW() {
        this.okx.onResume();
        this.okx.setVisibility(0);
        LayoutParams layoutParams = this.okx.getLayoutParams();
        if (layoutParams != null && com.tencent.mm.compatible.util.j.aS(getContext()) && this.okA) {
            layoutParams.height = com.tencent.mm.compatible.util.j.aQ(getContext());
            this.okx.setLayoutParams(layoutParams);
            this.okA = false;
        }
        if (this.rBj != null) {
            this.rBj.onShow();
        }
    }

    public final boolean bAN() {
        return this.state == 1;
    }

    public final void bAO() {
        if (this.okv == null) {
            x.e("MicroMsg.SnsCommentFooter", "send edittext is null");
            return;
        }
        this.okv.removeTextChangedListener(this.okC);
        this.okv.addTextChangedListener(this.okC);
    }

    public final void i(List<l> list, String str) {
        this.rBg = str;
        if (this.okv != null) {
            String az;
            String str2 = "";
            for (l lVar : list) {
                if (str.equals(lVar.aAM)) {
                    list.remove(lVar);
                    az = bh.az(lVar.text, "");
                    break;
                }
            }
            az = str2;
            if (bh.ov(az)) {
                this.okv.setText("");
            } else {
                this.rBd.setVisibility(0);
                this.okw.setVisibility(8);
                this.okv.setText("");
                this.okv.aak(az);
            }
            if (!this.rBh) {
                this.okv.addTextChangedListener(new 2(this, list));
            }
            this.rBh = true;
        }
    }

    public final void a(String str, bjk com_tencent_mm_protocal_c_bjk) {
        this.rBe = 0;
        if (bh.ov(str)) {
            this.okv.setHint("");
        } else {
            this.okv.setHint(com.tencent.mm.pluginsdk.ui.d.i.a(getContext(), str + this.fmM.getString(j.qKg, new Object[]{Float.valueOf(this.okv.getTextSize())})));
        }
        this.qTX = com_tencent_mm_protocal_c_bjk;
    }

    public final void b(String str, bjk com_tencent_mm_protocal_c_bjk) {
        if (bh.ov(str)) {
            this.okv.setHint("");
        } else {
            this.okv.setHint(com.tencent.mm.pluginsdk.ui.d.i.a(getContext(), this.fmM.getString(j.qJY) + str + this.fmM.getString(j.qKg, new Object[]{Float.valueOf(this.okv.getTextSize())})));
            this.rBe = 1;
        }
        this.qTX = com_tencent_mm_protocal_c_bjk;
    }

    public final void bAP() {
        this.okv.setText("");
        this.okv.setHint("");
        this.qTX = null;
        this.rBe = 0;
        this.state = 0;
    }

    public final void LW(String str) {
        this.okv.setHint(com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), str, this.okv.getTextSize()));
    }

    public final bjk bAQ() {
        if (this.qTX == null) {
            return new bjk();
        }
        return this.qTX;
    }

    public final void a(c cVar) {
        this.rBd.setOnClickListener(new 6(this, cVar));
    }

    public final void bAR() {
        this.rBc.setVisibility(8);
    }

    protected final void qI(int i) {
        super.qI(i);
        switch (i) {
            case -3:
                this.okz = true;
                if (getVisibility() == 0 && this.rBk != null) {
                    x.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
                    this.rBk.bCk();
                    return;
                }
                return;
            default:
                this.okz = false;
                return;
        }
    }

    public final void aXS() {
        this.rBk = null;
        if (this.okx != null) {
            x.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.okx.ti();
            this.okx.destroy();
        }
    }

    private void gv(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.bqk);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.bql);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.okw != null && this.rBd != null) {
            if (z) {
                if (this.okw.getVisibility() != 8 && this.okw.getVisibility() != 4) {
                    this.rBd.startAnimation(loadAnimation);
                    this.rBd.setVisibility(0);
                    this.okw.startAnimation(loadAnimation2);
                    this.okw.setVisibility(8);
                } else {
                    return;
                }
            } else if (this.okw.getVisibility() != 0 && this.okw.getVisibility() != 0) {
                this.okw.startAnimation(loadAnimation);
                this.okw.setVisibility(0);
                this.rBd.startAnimation(loadAnimation2);
                this.rBd.setVisibility(8);
            } else {
                return;
            }
            this.rBd.getParent().requestLayout();
        }
    }

    protected final List<View> aXT() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.okx);
        return arrayList;
    }
}
