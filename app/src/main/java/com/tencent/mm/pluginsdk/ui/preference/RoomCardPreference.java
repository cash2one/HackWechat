package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference extends Preference {
    public boolean fpa = false;
    public CharSequence iVW;
    private LinearLayout jNu;
    private TextView vua;
    public CharSequence vub;

    public RoomCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomCardPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, R.i.dob, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.h.content).findViewById(R.h.cGh);
        if (this.jNu == null) {
            this.jNu = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.vua == null) {
            this.vua = (TextView) viewGroup.findViewById(R.h.cIl);
        }
        if (this.fpa) {
            this.jNu.setVisibility(0);
            this.vua.setVisibility(0);
        } else {
            this.jNu.setVisibility(8);
            this.vua.setVisibility(8);
        }
        if (this.vub != null) {
            this.vua.setText(this.vub);
        }
    }
}
