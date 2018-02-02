package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference extends Preference {
    private TextView ihS;
    private MMSingelLinePanel phN;
    private ArrayList<String> phO;
    private String title;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.phO = new ArrayList();
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnC, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.ihS = (TextView) view.findViewById(R.h.title);
        this.phN = (MMSingelLinePanel) view.findViewById(R.h.bYk);
        this.phN.cpw();
        this.phN.ydA = false;
        this.phN.ms(false);
        if (this.ihS != null) {
            this.ihS.setText(this.title);
        }
        if (!(this.phN == null || this.phO == null || this.phO.size() <= 0)) {
            this.phN.a(this.phO, this.phO);
        }
        super.onBindView(view);
    }
}
