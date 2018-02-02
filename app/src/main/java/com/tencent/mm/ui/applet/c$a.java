package com.tencent.mm.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;

public final class c$a {
    private ImageView fyg;
    private View mView;
    FrameLayout xWd;
    WindowManager xWe;
    LayoutParams xWf;
    private ViewGroup.LayoutParams xWg;

    public c$a(Context context, View view) {
        if (this.xWd == null || this.xWe == null) {
            view.findViewById(R.h.cyu).setVisibility(8);
            this.fyg = (ImageView) view.findViewById(R.h.button);
            ((ImageView) view.findViewById(R.h.caO)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c$a xWh;

                {
                    this.xWh = r1;
                }

                public final void onClick(View view) {
                    this.xWh.coE();
                }
            });
            this.xWf = new LayoutParams();
            this.xWf.height = -2;
            this.xWf.width = -2;
            this.xWe = (WindowManager) context.getSystemService("window");
            this.xWf.x = 0;
            this.xWf.y = 0;
            this.xWf.flags = 40;
            this.xWf.type = 2002;
            this.mView = view;
            this.xWf.gravity = 51;
            this.xWf.format = 1;
            this.xWd = new FrameLayout(context);
            this.xWd.setPadding(4, 4, 4, 4);
            this.xWg = new ViewGroup.LayoutParams(-2, -2);
            this.xWd.addView(this.mView, this.xWg);
            this.xWd.setOnTouchListener(new 2(this, context.getResources().getDisplayMetrics()));
        }
    }

    public final void coE() {
        try {
            if (this.xWe != null) {
                if (this.xWd != null) {
                    this.xWe.removeView(this.xWd);
                }
                this.xWe = null;
            }
            if (this.xWd != null) {
                this.xWd.removeAllViews();
                this.xWd = null;
            }
            this.mView = null;
        } catch (Exception e) {
        }
    }
}
