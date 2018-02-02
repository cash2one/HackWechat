package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class EmojiStoreV2HotBarView extends LinearLayout {
    private View kND;
    View lFX;
    private TextView lFY;
    View lFZ;
    private TextView lGa;
    private OnClickListener lGb = new 1(this);

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        init();
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.kND = ((ViewGroup) v.fv(getContext()).inflate(R.i.dfR, this)).findViewById(R.h.cIu);
        this.lFX = this.kND.findViewById(R.h.cdr);
        this.lFY = (TextView) this.kND.findViewById(R.h.cdF);
        this.lFY.setText(getResources().getText(R.l.eaC) + " ");
        this.lFZ = this.kND.findViewById(R.h.cbb);
        this.lFZ.setOnClickListener(new 2(this));
        this.lGa = (TextView) this.kND.findViewById(R.h.cAc);
        aDt();
        OnClickListener onClickListener = this.lGb;
        if (this.lFY != null) {
            this.lFY.setOnClickListener(onClickListener);
        }
    }

    public final void aDt() {
        ar.Hg();
        boolean booleanValue = ((Boolean) c.CU().get(a.xnq, Boolean.valueOf(false))).booleanValue();
        if (this.lGa != null) {
            this.lGa.setVisibility(booleanValue ? 0 : 8);
        }
    }

    public View getRootView() {
        return this.kND;
    }

    public void setVisibility(int i) {
        if (this.kND != null) {
            this.kND.setVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }
}
