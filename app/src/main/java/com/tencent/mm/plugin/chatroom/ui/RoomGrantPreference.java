package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference extends Preference {
    TextView lbS = null;
    String lbT = "";

    public RoomGrantPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomGrantPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
        setWidgetLayoutResource(R.i.dod);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnM, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.lbS == null) {
            this.lbS = (TextView) view.findViewById(R.h.bYS);
        }
        this.lbS.setText(this.lbT);
        super.onBindView(view);
    }
}
