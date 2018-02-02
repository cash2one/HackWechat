package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.v;

public class b extends i implements h {
    private View contentView;
    private OnShowListener jWk;
    private OnDismissListener jWl;
    private OnCancelListener jWm;
    private boolean jWn;
    private i jWo;

    public b(Context context) {
        super(context);
        setContentView(super.getContentView());
    }

    public b(Context context, byte b) {
        super(context);
    }

    public final void a(i iVar) {
        if (this.jWk != null) {
            this.jWk.onShow(this);
        }
        this.jWo = iVar;
    }

    public final View getContentView() {
        if (this.contentView != null) {
            return this.contentView;
        }
        return super.getContentView();
    }

    public void setContentView(int i) {
        setContentView(v.fv(getContext()).inflate(i, null));
    }

    public void setContentView(View view) {
        if (!(view instanceof a)) {
            view = new a(view.getContext(), view);
        }
        this.contentView = view;
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    public void show() {
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.jWk = onShowListener;
    }

    public final void onCancel() {
        if (this.jWm != null) {
            this.jWm.onCancel(this);
        }
    }

    public void dismiss() {
        if (this.jWo != null) {
            this.jWo.b(this);
            if (this.jWl != null) {
                this.jWl.onDismiss(this);
            }
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.jWl = onDismissListener;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.jWn = z;
    }

    public final boolean amt() {
        return this.jWn;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.jWm = onCancelListener;
    }
}
