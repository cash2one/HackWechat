package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

class SetTextSizeUI$a extends Preference {
    private float qhL;
    final /* synthetic */ SetTextSizeUI qhN;

    public SetTextSizeUI$a(SetTextSizeUI setTextSizeUI, Context context, float f) {
        this.qhN = setTextSizeUI;
        super(context);
        this.qhL = f;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setTextSize(1, SetTextSizeUI.ao(this.qhL));
        }
    }
}
