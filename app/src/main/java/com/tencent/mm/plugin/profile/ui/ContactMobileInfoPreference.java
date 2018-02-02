package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMobileInfoPreference extends Preference {
    private TextView jJn;
    private String mTitle;
    private TextView phP;
    private String phQ;

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactMobileInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnE, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.jJn = (TextView) view.findViewById(R.h.title);
        this.phP = (TextView) view.findViewById(R.h.cwt);
        if (this.jJn != null) {
            this.jJn.setText(this.mTitle);
        }
        if (this.phP != null) {
            this.phP.setText(this.phQ);
        }
        super.onBindView(view);
    }
}
