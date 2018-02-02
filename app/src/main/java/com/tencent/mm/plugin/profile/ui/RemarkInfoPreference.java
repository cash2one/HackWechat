package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class RemarkInfoPreference extends Preference {
    private MMActivity fmM;
    private TextView ihS;
    private ImageView jNs;
    private String niP;
    private TextView pjN;
    private boolean pkY = false;
    private String title;

    public final /* synthetic */ CharSequence getSummary() {
        return this.pjN.getText().toString();
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
    }

    public RemarkInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
        setWidgetLayoutResource(R.i.dod);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnL, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ihS = (TextView) view.findViewById(R.h.title);
        this.pjN = (TextView) view.findViewById(R.h.summary);
        this.jNs = (ImageView) view.findViewById(R.h.cpk);
        if (this.pkY) {
            this.jNs.setVisibility(0);
        } else {
            this.jNs.setVisibility(8);
        }
        if (this.ihS != null) {
            this.ihS.setText(this.title);
        }
        if (this.pjN != null) {
            this.pjN.setText(this.niP);
        }
        super.onBindView(view);
    }
}
