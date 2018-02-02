package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference extends Preference {
    private MMActivity fmM;
    private TextView ihS;
    private TextView imP;
    private ImageView jNs;
    private String mTitle;
    private int mkA;
    private Button mkB;
    private View mkC;
    private OnClickListener mkD;
    private String mkE;
    private String mkF;

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fmM = (MMActivity) context;
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.mkA = 255;
        this.mkD = null;
        this.mkE = "";
        this.mkF = "";
        this.fmM = (MMActivity) context;
        setLayoutResource(R.i.dtE);
    }

    public final void cv(String str, String str2) {
        this.mkE = str;
        this.mkF = str2;
        if (this.ihS != null) {
            if (bh.ov(this.mkE)) {
                this.ihS.setVisibility(8);
            } else {
                this.ihS.setText(this.mkE);
                this.ihS.setVisibility(0);
            }
        }
        if (this.imP == null) {
            return;
        }
        if (bh.ov(this.mkF)) {
            this.imP.setVisibility(8);
            return;
        }
        this.imP.setText(this.mkF);
        this.imP.setVisibility(0);
    }

    public final void f(OnClickListener onClickListener) {
        this.mkD = onClickListener;
        if (this.mkB != null && this.mkC != null) {
            if (this.mkB == null || this.mkD == null) {
                this.mkB.setVisibility(8);
                this.mkC.setVisibility(8);
                return;
            }
            this.mkB.setOnClickListener(onClickListener);
            this.mkB.setVisibility(0);
            this.mkC.setVisibility(0);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jNs = (ImageView) view.findViewById(R.h.cWD);
        this.ihS = (TextView) view.findViewById(R.h.cWE);
        this.imP = (TextView) view.findViewById(R.h.cWG);
        this.mkB = (Button) view.findViewById(R.h.cId);
        this.mkC = view.findViewById(R.h.bPi);
        if (bh.ov(this.mkE)) {
            this.ihS.setVisibility(8);
        } else {
            this.ihS.setText(this.mkE);
            this.ihS.setVisibility(0);
        }
        if (bh.ov(this.mkF)) {
            this.imP.setVisibility(8);
        } else {
            this.imP.setText(this.mkF);
            this.imP.setVisibility(0);
        }
        if (this.mkB == null || this.mkD == null) {
            this.mkB.setVisibility(8);
            this.mkC.setVisibility(8);
            return;
        }
        this.mkB.setOnClickListener(this.mkD);
        this.mkB.setVisibility(0);
        this.mkC.setVisibility(0);
    }
}
