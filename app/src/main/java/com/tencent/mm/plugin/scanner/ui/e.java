package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    private Context context;
    private TextView ihS;
    String mTitle;
    private View mView;
    private OnTouchListener ozr;
    private final int pVf = 5;
    private TextView pVg;
    public boolean pVh = false;
    public boolean pVi = false;
    private Boolean pVj;
    private OnGlobalLayoutListener pVk;
    a pVl;
    private TextView pjN;

    public e(Activity activity) {
        super(activity);
        setLayoutResource(R.i.dnR);
        this.context = activity;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.ihS == null) {
            this.ihS = (TextView) view.findViewById(16908310);
        }
        if (this.pjN == null) {
            this.pjN = (TextView) view.findViewById(16908304);
        }
        if (this.pVg == null) {
            this.pVg = (TextView) view.findViewById(R.h.cxg);
        }
        if (this.ozr == null) {
            this.ozr = new 1(this);
            this.pVg.setOnTouchListener(this.ozr);
        }
        if (this.pVl != null) {
            this.pVj = this.pVl.ID(this.ibD);
            if (this.pVj == null) {
                this.pVg.setVisibility(8);
                this.pjN.setMaxLines(6);
            } else if (this.pVj.booleanValue()) {
                this.pVg.setVisibility(8);
                this.pjN.setMaxLines(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
            } else {
                this.pVg.setVisibility(0);
                this.pjN.setMaxLines(5);
            }
        } else {
            this.pVg.setVisibility(8);
            this.pjN.setMaxLines(6);
        }
        if (this.pVk == null) {
            this.pVk = new 2(this);
            this.pjN.getViewTreeObserver().addOnGlobalLayoutListener(this.pVk);
        }
        if (bh.ov(this.mTitle)) {
            this.ihS.setVisibility(8);
            return;
        }
        this.ihS.setText(this.mTitle);
        this.ihS.setVisibility(0);
    }
}
