package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.v;

public final class f extends r implements h {
    private View contentView;
    private OnShowListener jWk;
    private OnDismissListener jWl;
    private OnCancelListener jWm;
    private boolean jWn;
    private i jWo;

    public f(Context context) {
        super(context, k.eYV, 0);
        try {
            onCreate(null);
        } catch (Exception e) {
        }
    }

    public final void a(i iVar) {
        if (this.jWk != null) {
            this.jWk.onShow(this);
        }
        this.jWo = iVar;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(int i) {
        setContentView(v.fv(getContext()).inflate(i, null));
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    public final void show() {
    }

    public final void setOnShowListener(OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.jWk = onShowListener;
    }

    public final void onCancel() {
        if (this.jWm != null) {
            this.jWm.onCancel(this);
        }
    }

    public final void dismiss() {
        if (this.jWo != null) {
            this.jWo.b(this);
            if (this.jWl != null) {
                this.jWl.onDismiss(this);
            }
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.jWl = onDismissListener;
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.jWn = z;
    }

    public final boolean amt() {
        return this.jWn;
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.jWm = onCancelListener;
    }
}
