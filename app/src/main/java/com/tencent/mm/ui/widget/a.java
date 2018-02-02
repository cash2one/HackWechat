package com.tencent.mm.ui.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.j;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.cb.a.f;
import com.tencent.mm.cb.a.i;

public final class a extends j {
    private Context mContext;

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        super(context, i.zzE);
        this.mContext = context;
        da();
    }

    public final void setContentView(View view) {
        super.setContentView(b(0, view, null));
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(b(0, view, layoutParams));
    }

    public final void setContentView(int i) {
        super.setContentView(b(i, null, null));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    private View b(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout;
        boolean z;
        Window window = getWindow();
        if (aZW()) {
            window.setGravity(5);
            window.setWindowAnimations(i.eYT);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(i.eYJ);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (aZW()) {
            attributes.width = -2;
            attributes.height = -1;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(f.zzs, null);
        View findViewById = viewGroup.findViewById(e.bp);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, viewGroup, false);
        }
        if (aZW()) {
            frameLayout = (FrameLayout) viewGroup.findViewById(e.cvR);
        } else {
            frameLayout = (FrameLayout) viewGroup.findViewById(e.cvQ);
        }
        frameLayout.setVisibility(0);
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        if (VERSION.SDK_INT < 11) {
            z = true;
        } else {
            TypedValue typedValue = new TypedValue();
            z = getContext().getTheme().resolveAttribute(16843611, typedValue, true) ? typedValue.data != 0 : false;
        }
        if (z) {
            findViewById.setOnClickListener(new 1(this));
        }
        return viewGroup;
    }

    private boolean aZW() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
