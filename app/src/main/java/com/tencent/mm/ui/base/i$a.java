package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.view.View;

public class i$a {
    private Context mContext;
    public c xZs = new c();

    public interface b {
        void caR();
    }

    public i$a(Context context) {
        this.mContext = context;
    }

    public final i$a YF(String str) {
        this.xZs.title = str;
        return this;
    }

    public final i$a P(CharSequence charSequence) {
        this.xZs.title = charSequence;
        return this;
    }

    public final i$a Ez(int i) {
        this.xZs.title = this.mContext.getString(i);
        return this;
    }

    public final i$a YG(String str) {
        this.xZs.xWX = str;
        return this;
    }

    public final i$a EA(int i) {
        this.xZs.xWX = this.mContext.getString(i);
        return this;
    }

    public final i$a Q(CharSequence charSequence) {
        this.xZs.xWY = charSequence;
        return this;
    }

    public final i$a mh(boolean z) {
        this.xZs.xXd = z;
        return this;
    }

    public final i$a a(String str, CharSequence charSequence, Boolean bool, b bVar) {
        this.xZs.xWM = str;
        this.xZs.xWO = charSequence;
        this.xZs.xWP = bool.booleanValue();
        this.xZs.xWR = bVar;
        return this;
    }

    public final i$a a(c cVar) {
        this.xZs.xWT = cVar;
        return this;
    }

    public final i$a a(Bitmap bitmap, boolean z, int i) {
        this.xZs.xWW = bitmap;
        this.xZs.xXe = z;
        this.xZs.xXl = i;
        return this;
    }

    public final i$a EB(int i) {
        this.xZs.xXk = i;
        return this;
    }

    public final i$a YH(String str) {
        this.xZs.xWJ = str;
        return this;
    }

    public final i$a dk(View view) {
        this.xZs.tyZ = view;
        return this;
    }

    public final i$a YI(String str) {
        this.xZs.xXa = str;
        return this;
    }

    public final i$a EC(int i) {
        this.xZs.xXa = this.mContext.getString(i);
        return this;
    }

    public final i$a a(OnClickListener onClickListener) {
        this.xZs.xXf = onClickListener;
        return this;
    }

    public final i$a a(boolean z, OnClickListener onClickListener) {
        this.xZs.xXf = onClickListener;
        this.xZs.xXn = z;
        return this;
    }

    public final i$a YJ(String str) {
        this.xZs.xXb = str;
        return this;
    }

    public final i$a ED(int i) {
        this.xZs.xXb = this.mContext.getString(i);
        return this;
    }

    public final i$a b(OnClickListener onClickListener) {
        this.xZs.xXg = onClickListener;
        return this;
    }

    public final i$a d(OnCancelListener onCancelListener) {
        this.xZs.Gj = onCancelListener;
        return this;
    }

    public final i$a a(OnDismissListener onDismissListener) {
        this.xZs.Gk = onDismissListener;
        return this;
    }

    public final i$a mi(boolean z) {
        this.xZs.qoX = z;
        return this;
    }

    public final i$a mj(boolean z) {
        this.xZs.xXc = z;
        return this;
    }

    public i akx() {
        i iVar = new i(this.mContext);
        iVar.a(this.xZs);
        return iVar;
    }
}
