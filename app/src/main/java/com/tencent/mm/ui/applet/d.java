package com.tencent.mm.ui.applet;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ca.d.b;
import com.tencent.mm.sdk.platformtools.af;
import java.lang.ref.WeakReference;

public final class d {
    private static int xWw = 0;

    public static final class a {
        Context context;
        ImageView fyg;
        ProgressBar fyi;
        View mView;
        TextView nou;
        int xWA = 0;
        af xWB = new af(this) {
            final /* synthetic */ a xWC;

            {
                this.xWC = r1;
            }

            public final void handleMessage(Message message) {
                if (this.xWC.nou.getVisibility() != 0) {
                    this.xWC.xWA = 0;
                    return;
                }
                a aVar = this.xWC;
                aVar.xWA++;
                this.xWC.coH();
                super.handleMessage(message);
            }
        };
        FrameLayout xWd;
        WindowManager xWe;
        LayoutParams xWf;
        private ViewGroup.LayoutParams xWg;
        boolean xWx = false;
        b xWy = new 1(this);
        com.tencent.mm.ca.d.a xWz;

        public a(Context context, View view) {
            if (this.xWd == null || this.xWe == null) {
                com.tencent.mm.ca.d.clq().xDi = new WeakReference(this.xWy);
                this.nou = (TextView) view.findViewById(R.h.time);
                this.fyg = (ImageView) view.findViewById(R.h.button);
                ((ImageView) view.findViewById(R.h.caO)).setOnClickListener(new 2(this));
                this.fyi = (ProgressBar) view.findViewById(R.h.cyu);
                this.fyi.setVisibility(8);
                this.context = context;
                this.xWf = new LayoutParams();
                this.xWf.height = -2;
                this.xWf.width = -2;
                this.xWe = (WindowManager) context.getSystemService("window");
                this.xWf.x = 0;
                this.xWf.y = 0;
                this.xWf.flags = 40;
                this.xWf.type = 2002;
                this.mView = view;
                this.nou.setVisibility(8);
                this.xWf.gravity = 51;
                this.xWf.format = 1;
                this.xWd = new FrameLayout(context);
                this.xWd.setPadding(4, 4, 4, 4);
                this.xWg = new ViewGroup.LayoutParams(-2, -2);
                this.xWd.addView(this.mView, this.xWg);
                this.xWd.setOnTouchListener(new 3(this, context.getResources().getDisplayMetrics()));
            }
        }

        final void fD(Context context) {
            boolean z = false;
            this.fyg.setVisibility(0);
            this.fyi.setVisibility(4);
            if (!this.xWx) {
                z = true;
            }
            this.xWx = z;
            this.fyg.setBackgroundDrawable(context.getResources().getDrawable(R.g.bGX));
            this.nou.setVisibility(8);
        }

        final void coH() {
            this.nou.setText(this.xWA);
            this.xWB.sendEmptyMessageDelayed(0, 1000);
        }
    }

    static /* synthetic */ int coG() {
        int i = xWw;
        xWw = i - 1;
        return i;
    }

    public static void fC(Context context) {
        if (xWw <= 0) {
            a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.dtg, null));
            aVar.xWe.addView(aVar.xWd, aVar.xWf);
            xWw++;
        }
    }
}
