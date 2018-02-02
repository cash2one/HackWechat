package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference extends Preference {
    a nuA;

    public static class a {
        public String fWv;
        public boolean isDefault;
        public String nuB;
        public String nuC;
        public String nuD;
        public boolean nuE;
    }

    public GameRegionPreference(Context context) {
        this(context, null);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dle, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.cHw);
        CheckBox checkBox = (CheckBox) view.findViewById(R.h.cPj);
        if (textView != null && checkBox != null && this.nuA != null) {
            textView.setText(g.a(this.nuA));
            checkBox.setChecked(this.nuA.nuE);
        }
    }
}
