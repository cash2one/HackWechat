package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.q.e;

public final class d extends PopupWindow {
    private WindowManager jWb;
    private View jWc;
    public FrameLayout jWd;
    private Context mContext = null;

    public d(Context context) {
        super(context);
        this.mContext = context;
        this.jWb = (WindowManager) context.getSystemService("window");
        this.jWd = new FrameLayout(this.mContext);
    }

    public final void showAsDropDown(View view) {
        IBinder windowToken = view.getWindowToken();
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.token = windowToken;
        this.jWc = new View(this.mContext);
        this.jWc.setBackgroundColor(2130706432);
        this.jWc.setFitsSystemWindows(false);
        this.jWc.setOnTouchListener(new 1(this));
        this.jWc.setOnKeyListener(new 2(this));
        this.jWb.addView(this.jWc, layoutParams);
        super.showAsDropDown(view);
    }

    public final void dismiss() {
        if (this.jWc != null) {
            this.jWb.removeViewImmediate(this.jWc);
            this.jWc = null;
        }
        super.dismiss();
    }

    public final void setContentView(View view) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.topMargin = a.ab(this.mContext, e.isG);
        layoutParams.rightMargin = a.ab(this.mContext, e.isF);
        layoutParams.leftMargin = a.ab(this.mContext, e.isF);
        this.jWd.addView(view, layoutParams);
        super.setContentView(this.jWd);
    }
}
