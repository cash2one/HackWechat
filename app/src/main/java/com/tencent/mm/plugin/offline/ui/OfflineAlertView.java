package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

public class OfflineAlertView extends LinearLayout {
    private View contentView = null;
    public int oXw = 0;
    RelativeLayout oXx = null;
    boolean oXy = true;
    a oXz = null;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int iGh = 2;
        final /* synthetic */ View oXA;
        final /* synthetic */ Runnable oXB;
        final /* synthetic */ Runnable oXC;
        final /* synthetic */ OfflineAlertView oXD;

        AnonymousClass1(OfflineAlertView offlineAlertView, View view, Runnable runnable, Runnable runnable2, int i) {
            this.oXD = offlineAlertView;
            this.oXA = view;
            this.oXB = runnable;
            this.oXC = runnable2;
        }

        public final void run() {
            OfflineAlertView.a(this.oXD, this.oXA, this.oXB, this.oXC, this.iGh);
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int iGh = 4;
        final /* synthetic */ View oXA;
        final /* synthetic */ OfflineAlertView oXD;

        AnonymousClass2(OfflineAlertView offlineAlertView, View view, int i) {
            this.oXD = offlineAlertView;
            this.oXA = view;
        }

        public final void run() {
            OfflineAlertView.a(this.oXD, this.oXA, this.iGh);
        }
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, int i) {
        offlineAlertView.oXw = i;
        offlineAlertView.setVisibility(0);
        k.bgX();
        bh.VI(k.un(196645));
        TextView textView = (TextView) offlineAlertView.contentView.findViewById(a$f.coJ);
        if (textView != null) {
            textView.setOnClickListener(new r(offlineAlertView) {
                final /* synthetic */ OfflineAlertView oXD;

                {
                    this.oXD = r1;
                }

                public final void ayX() {
                    this.oXD.dismiss();
                }
            });
            textView.setText(i.uTd);
        } else {
            x.e("MicroMsg.OfflineAlertView", "iKnowBtn is null!");
        }
        textView = (TextView) offlineAlertView.contentView.findViewById(a$f.uwL);
        if (textView != null) {
            textView.setText(i.uTe);
            textView.setOnClickListener(new 4(offlineAlertView));
        } else {
            x.e("MicroMsg.OfflineAlertView", "moreTV is null!");
        }
        x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        if (offlineAlertView.oXz != null) {
            offlineAlertView.oXz.onShow();
        }
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, Runnable runnable, Runnable runnable2, int i) {
        offlineAlertView.oXw = i;
        offlineAlertView.setVisibility(0);
        ((TextView) offlineAlertView.contentView.findViewById(a$f.coJ)).setOnClickListener(new 5(offlineAlertView, runnable));
        offlineAlertView.contentView.findViewById(a$f.uwL).setOnClickListener(new 6(offlineAlertView, runnable2));
        x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        offlineAlertView.oXy = false;
        if (offlineAlertView.oXz != null) {
            offlineAlertView.oXz.onShow();
        }
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.contentView = LayoutInflater.from(getContext()).inflate(g.uFl, this);
        this.oXx = (RelativeLayout) this.contentView.findViewById(a$f.urW);
    }

    final void a(View view, OnClickListener onClickListener, int i) {
        this.oXw = i;
        setVisibility(0);
        this.oXx.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(g.uFu, null);
        if (i == 6) {
            ((TextView) inflate.findViewById(a$f.uez)).setText(i.uMd);
        }
        this.oXx.addView(inflate);
        ((Button) this.contentView.findViewById(a$f.coJ)).setOnClickListener(onClickListener);
        this.oXy = false;
        view.post(new 7(this, view));
    }

    public final boolean isShowing() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final boolean uo(int i) {
        if (!isShowing() || i == this.oXw) {
            return true;
        }
        if (i == 2 && (this.oXw == 3 || this.oXw == 4 || this.oXw == 2 || this.oXw == 5)) {
            return true;
        }
        if ((i == 5 && this.oXw == 4) || i == 6) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (this.oXx != null) {
            this.oXx.removeAllViews();
        }
        setVisibility(8);
        if (this.oXz != null) {
            this.oXz.onClose();
        }
        this.oXy = true;
    }
}
