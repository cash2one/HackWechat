package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class AppHeaderPreference extends Preference {
    boolean fJL = false;
    private ImageView ihQ;
    private TextView ihV;
    private TextView iny;
    private TextView pjY;
    private boolean pka = false;
    a rXC;

    public AppHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.ihQ = (ImageView) view.findViewById(R.h.bXn);
        this.ihV = (TextView) view.findViewById(R.h.bYa);
        this.pjY = (TextView) view.findViewById(R.h.bXK);
        this.iny = (TextView) view.findViewById(R.h.bXx);
        this.pka = true;
        if (!this.pka || this.rXC == null) {
            x.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.pka);
        } else {
            Bitmap bEf = this.rXC.bEf();
            if (!(this.ihQ == null || bEf == null || bEf.isRecycled())) {
                this.ihQ.setImageBitmap(bEf);
            }
            CharSequence bEe = this.rXC.bEe();
            if (!(this.pjY == null || bEe == null || bEe.length() <= 0)) {
                this.pjY.setText(bEe);
            }
            bEe = this.rXC.getHint();
            if (bEe != null) {
                this.iny.setText(bEe);
                this.iny.setVisibility(0);
            } else {
                this.iny.setVisibility(8);
            }
            boolean z = this.fJL;
            if (this.ihV != null) {
                CharSequence iS = this.rXC.iS(z);
                if (z) {
                    if (iS == null || iS.length() <= 0) {
                        this.ihV.setVisibility(8);
                    } else {
                        this.ihV.setTextColor(r.gb(this.mContext));
                        this.ihV.setText(iS);
                        this.ihV.setCompoundDrawablesWithIntrinsicBounds(R.g.bGx, 0, 0, 0);
                    }
                } else if (iS == null || iS.length() <= 0) {
                    this.ihV.setVisibility(8);
                } else {
                    this.ihV.setTextColor(r.gc(this.mContext));
                    this.ihV.setText(iS);
                    this.ihV.setCompoundDrawablesWithIntrinsicBounds(R.g.bGw, 0, 0, 0);
                }
            }
        }
        super.onBindView(view);
    }
}
