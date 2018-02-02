package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public final class u extends Toast {
    private final Context context;
    public long duration;
    public final ak fhK = new ak(new 1(this), true);
    private View jqe;
    public int kUH;
    private int level;
    private final TextView nJm;

    public u(Context context) {
        super(context);
        this.context = context;
        reset();
        this.jqe = View.inflate(context, h.gYi, null);
        setView(this.jqe);
        setGravity(55, 0, b.b(context, 40.0f));
        setDuration(0);
        this.nJm = (TextView) this.jqe.findViewById(g.gWT);
        switch (this.level) {
            case 1:
                this.nJm.setTextColor(-1);
                return;
            case 2:
                this.nJm.setTextColor(this.context.getResources().getColor(d.gUJ));
                return;
            default:
                return;
        }
    }

    public final void setText(CharSequence charSequence) {
        this.nJm.setText(charSequence);
    }

    public final void setText(int i) {
        this.nJm.setText(i);
    }

    public final void reset() {
        this.level = 1;
        this.duration = 2000;
        this.kUH = ((int) (this.duration / 70)) + 1;
    }

    public static q a(Activity activity, String str, long j) {
        View inflate = View.inflate(activity, h.gYi, null);
        ((TextView) inflate.findViewById(g.gWT)).setText(str);
        q qVar = new q(inflate);
        qVar.setWidth(-1);
        qVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        qVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + ci(activity));
        new 4(qVar).sendEmptyMessageDelayed(0, j);
        return qVar;
    }

    private static int ci(Context context) {
        int dimensionPixelSize;
        if (!(context instanceof ActionBarActivity) || ((ActionBarActivity) context).getSupportActionBar() == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(e.buF);
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(e.buG);
            }
        } else {
            dimensionPixelSize = ((ActionBarActivity) context).getSupportActionBar().getHeight();
        }
        if (dimensionPixelSize == 0) {
            return context.getResources().getDimensionPixelSize(e.buG);
        }
        return dimensionPixelSize;
    }

    public static q a(Activity activity, int i, String str) {
        View inflate = View.inflate(activity, h.gXn, null);
        TextView textView = (TextView) inflate.findViewById(g.cte);
        textView.setText(str);
        textView.setOnClickListener(null);
        ImageView imageView = (ImageView) inflate.findViewById(g.ctd);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
        q qVar = new q(inflate);
        qVar.setWidth(-1);
        qVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int ci = ci(activity);
        if (i2 == 0) {
            i2 = ai(activity, 25);
        }
        ag.y(new 7(qVar, activity, i2 + ci));
        ag.h(new 2(qVar), 2000);
        ImageButton imageButton = (ImageButton) inflate.findViewById(g.ctc);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new 3(qVar));
        return qVar;
    }

    public static q a(Activity activity, int i, int i2, String str, int i3, OnClickListener onClickListener) {
        View inflate = View.inflate(activity, h.gYg, null);
        ((LinearLayout) inflate.findViewById(g.gWB)).setBackgroundColor(activity.getResources().getColor(i));
        TextView textView = (TextView) inflate.findViewById(g.gWE);
        textView.setText(str);
        textView.setOnClickListener(null);
        if (i == d.gUI || i == d.gUH) {
            textView.setTextColor(activity.getResources().getColor(d.gUv));
        }
        ImageView imageView = (ImageView) inflate.findViewById(g.gWC);
        if (i2 == 0) {
            imageView.setVisibility(8);
            int fromDPToPix = a.fromDPToPix(activity, 16);
            textView.setPadding(fromDPToPix, 0, fromDPToPix, 0);
        } else {
            imageView.setImageResource(i2);
        }
        q qVar = new q(inflate);
        qVar.setWidth(-1);
        qVar.setHeight(-2);
        Rect rect = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        int ci = ci(activity);
        if (i4 == 0) {
            i4 = ai(activity, 25);
        }
        i4 += ci;
        if (window.getDecorView() != null) {
            window.getDecorView().post(new 5(qVar, window, i4));
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(g.gWD);
        if (i3 == 0) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setImageResource(i3);
        }
        imageView2.setOnClickListener(new 6(qVar, onClickListener));
        return qVar;
    }

    public static void fI(Context context) {
        if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted_ro")) {
            a.aj(context, 3);
        } else {
            a.aj(context, 1);
        }
    }

    public static void fJ(Context context) {
        a.aj(context, 2);
    }

    public static int fK(Context context) {
        return ai(context, 25);
    }

    public static int ai(Context context, int i) {
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(bh.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMToast", e, "", new Object[0]);
        }
        return i;
    }
}
