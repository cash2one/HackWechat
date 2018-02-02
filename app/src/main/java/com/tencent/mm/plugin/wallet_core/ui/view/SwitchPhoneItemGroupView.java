package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> sXr = new ArrayList();
    public a sXs;
    private OnClickListener sXt = new 1(this);

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(SwitchPhoneItemView switchPhoneItemView, int i) {
        addView(switchPhoneItemView, i);
        this.sXr.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.sXt);
    }
}
