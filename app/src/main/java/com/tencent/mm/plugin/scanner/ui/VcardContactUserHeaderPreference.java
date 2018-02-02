package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference extends Preference {
    String bgo;
    private final Context context;
    private TextView nuh;
    String pTC;
    private ImageView pZu;
    private TextView pZv;
    private TextView pZw;
    private TextView pZx;
    String pZy;
    String title;

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        x.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.pZu = (ImageView) view.findViewById(R.h.cUs);
        this.nuh = (TextView) view.findViewById(R.h.cUt);
        if (this.pZy != null) {
            this.nuh.setText(this.pZy);
        }
        this.pZv = (TextView) view.findViewById(R.h.cUu);
        if (this.bgo != null) {
            this.pZv.setText(this.context.getString(R.l.eSv, new Object[]{this.bgo}));
            this.pZv.setVisibility(0);
        }
        this.pZw = (TextView) view.findViewById(R.h.cUv);
        if (this.pTC != null) {
            this.pZw.setText(this.context.getString(R.l.eSx, new Object[]{this.pTC}));
            this.pZw.setVisibility(0);
        }
        this.pZx = (TextView) view.findViewById(R.h.cUw);
        if (this.title != null) {
            this.pZx.setText(this.context.getString(R.l.eSy, new Object[]{this.title}));
            this.pZx.setVisibility(0);
        }
    }
}
