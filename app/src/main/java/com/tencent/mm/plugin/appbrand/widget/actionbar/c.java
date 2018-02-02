package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.page.a.a;

public interface c {
    void a(OnClickListener onClickListener);

    void a(OnLongClickListener onLongClickListener);

    CharSequence amk();

    double aml();

    void amm();

    void amp();

    void b(OnClickListener onClickListener);

    void b(a aVar);

    void c(OnClickListener onClickListener);

    void d(OnClickListener onClickListener);

    void do(boolean z);

    void dp(boolean z);

    void dq(boolean z);

    void e(OnClickListener onClickListener);

    View getActionView();

    int getBackgroundColor();

    int getForegroundColor();

    LayoutParams getLayoutParams();

    ViewParent getParent();

    void k(double d);

    void lS(int i);

    void setBackgroundColor(int i);

    void setLayoutParams(LayoutParams layoutParams);

    void uT(String str);

    void uU(String str);

    void uV(String str);
}
