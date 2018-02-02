package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class LanguagePreference extends Preference {
    public a xOk;

    public LanguagePreference(Context context) {
        this(context, null);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
    }

    public final void a(a aVar) {
        if (aVar == null || bh.ov(aVar.xOn)) {
            x.e("MicroMsg.LanguagePreference", "setInfo info error");
            return;
        }
        this.xOk = aVar;
        setKey(aVar.xOn);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnD, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        int i = 1;
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.csv);
        CheckBox checkBox = (CheckBox) view.findViewById(R.h.cPj);
        int i2 = textView != null ? 1 : 0;
        if (checkBox == null) {
            i = 0;
        }
        if ((i & i2) != 0) {
            textView.setText(this.xOk.xOl);
            checkBox.setChecked(this.xOk.nuE);
        }
    }
}
