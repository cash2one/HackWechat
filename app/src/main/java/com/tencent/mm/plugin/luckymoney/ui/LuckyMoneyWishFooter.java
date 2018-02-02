package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class LuckyMoneyWishFooter extends BasePanelKeybordLayout {
    private MMActivity fmM;
    private boolean okA = true;
    boolean okB = true;
    private TextWatcher okC = new 1(this);
    private ImageButton oku;
    private MMEditText okv;
    private Button okw;
    private ChatFooterPanel okx;
    boolean oky = false;
    public boolean okz = false;
    private int state = 0;

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.fmM, a$g.uCJ, this);
        this.okw = (Button) viewGroup.findViewById(f.upK);
        gv(false);
        this.oku = (ImageButton) viewGroup.findViewById(f.upJ);
        this.oku.setOnClickListener(new 2(this));
        this.okv = (MMEditText) viewGroup.findViewById(f.upH);
        this.okv.setOnTouchListener(new 3(this));
        if (e.vro == null) {
            this.okx = new d(this.fmM);
            return;
        }
        this.okx = e.vro.cv(getContext());
        this.okx.ej(ChatFooterPanel.vjE);
        this.okx.setVisibility(8);
        this.okx.setBackgroundResource(a.e.bzY);
        ((LinearLayout) findViewById(f.cIu)).addView(this.okx, -1, 0);
        this.okx.tj();
        this.okx.aF(false);
        this.okx.vjB = new 4(this);
    }

    public void setVisibility(int i) {
        boolean z;
        this.state = 0;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.okx != null) {
            x.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    this.fmM.showVKB();
                    this.okv.requestFocus();
                    this.okx.setVisibility(8);
                } else {
                    this.fmM.aWs();
                    this.okv.requestFocus();
                    amW();
                }
                this.okA = false;
            } else {
                this.okx.setVisibility(8);
                this.oku.setImageResource(a$h.dBb);
                this.fmM.aWs();
                requestLayout();
            }
        }
        super.setVisibility(i);
    }

    private void amW() {
        this.okx.onResume();
        this.okx.setVisibility(0);
        LayoutParams layoutParams = this.okx.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && j.aS(getContext()) && this.okA)) {
            layoutParams.height = j.aQ(getContext());
            this.okx.setLayoutParams(layoutParams);
            this.okA = false;
        }
    }

    public final void aXR() {
        this.okv.setFilters(new InputFilter[]{new LengthFilter(25)});
    }

    public final boolean a(MMEditText.a aVar) {
        if (this.okv == null) {
            return false;
        }
        this.okv.ztP = aVar;
        return true;
    }

    public final void a(a aVar) {
        this.okw.setOnClickListener(new 5(this, aVar));
    }

    protected final void qI(int i) {
        super.qI(i);
        switch (i) {
            case -3:
                this.okz = true;
                return;
            default:
                this.okz = false;
                return;
        }
    }

    public final void aXS() {
        if (this.okx != null) {
            x.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.okx.ti();
            this.okx.destroy();
        }
    }

    private void gv(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.a.bqk);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), a.a.bql);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.okw != null) {
            if (z) {
                if (this.okw.getVisibility() != 8 && this.okw.getVisibility() != 4) {
                    this.okw.startAnimation(loadAnimation2);
                    this.okw.setVisibility(8);
                }
            } else if (this.okw.getVisibility() != 0 && this.okw.getVisibility() != 0) {
                this.okw.startAnimation(loadAnimation);
                this.okw.setVisibility(0);
            }
        }
    }

    protected final List<View> aXT() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.okx);
        return arrayList;
    }
}
