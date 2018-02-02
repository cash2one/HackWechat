package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public class ScannerFlashSwitcher extends LinearLayout {
    ImageView pYJ;
    TextView pYK;
    boolean pYL = false;

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        v.fv(getContext()).inflate(R.i.cJe, this, true);
        this.pYJ = (ImageView) findViewById(R.h.cik);
        this.pYK = (TextView) findViewById(R.h.cij);
        this.pYL = true;
    }

    public final void hide() {
        x.i("MicroMsg.ScannerFlashSwitcher", "hide");
        setEnabled(false);
        this.pYJ.animate().alpha(0.0f).setDuration(500);
        this.pYK.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ ScannerFlashSwitcher pYM;

            {
                this.pYM = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                this.pYM.setVisibility(8);
            }
        });
    }

    public final void bpt() {
        x.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
        this.pYJ.setImageResource(R.k.dAw);
    }
}
