package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference extends Preference {
    private MMActivity fmM;
    private TextView ihS;
    private ImageView jNs;
    private String mTitle;
    private int mkA;
    private Button mkB;
    private View mkC;
    private OnClickListener mkD;
    private String mkE;
    private String mkF;

    public FaceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fmM = (MMActivity) context;
    }

    public FaceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.mkA = 255;
        this.mkD = null;
        this.mkE = "";
        this.mkF = "";
        this.fmM = (MMActivity) context;
        setLayoutResource(g.mdJ);
    }

    public final void cv(String str, String str2) {
        this.mkE = str;
        this.mkF = str2;
        if (this.ihS == null) {
            return;
        }
        if (bh.ov(this.mkE)) {
            this.ihS.setVisibility(8);
            return;
        }
        this.ihS.setText(this.mkE);
        this.ihS.setVisibility(0);
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
        this.jNs = (ImageView) view.findViewById(e.mdb);
        this.ihS = (TextView) view.findViewById(e.mdc);
        this.mkB = (Button) view.findViewById(e.cId);
        this.mkC = view.findViewById(e.bPi);
        if (bh.ov(this.mkE)) {
            this.ihS.setVisibility(8);
        } else {
            this.ihS.setText(this.mkE);
            this.ihS.setVisibility(0);
        }
        if (this.mkB == null || this.mkD == null) {
            if (this.mkB != null) {
                this.mkB.setVisibility(8);
            }
            this.mkC.setVisibility(8);
            return;
        }
        this.mkB.setOnClickListener(this.mkD);
        this.mkB.setVisibility(0);
        this.mkC.setVisibility(0);
    }
}
