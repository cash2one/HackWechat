package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;

public class GameMenuImageButton extends LinearLayout {
    private ImageView fvf;
    public boolean tFM;

    public GameMenuImageButton(Context context) {
        super(context);
        cd(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cd(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cd(context);
    }

    private void cd(Context context) {
        this.fvf = new ImageView(context);
        this.fvf.setLayoutParams(new LayoutParams(a.ab(context, R.f.bxw), a.ab(context, R.f.bxw)));
        this.fvf.setScaleType(ScaleType.FIT_CENTER);
        this.fvf.setImageResource(R.g.bCF);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, a.ab(context, R.f.bxv), a.ab(context, R.f.bxv), 0);
        addView(this.fvf, layoutParams);
    }

    public final void a(FrameLayout frameLayout, final a aVar) {
        if (getParent() == null && frameLayout != null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            frameLayout.addView(this, layoutParams);
        }
        if (this.fvf != null) {
            this.fvf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ GameMenuImageButton tFO;

                public final void onClick(View view) {
                    if (aVar != null) {
                        aVar.aPy();
                    }
                }
            });
        }
        this.tFM = true;
    }
}
