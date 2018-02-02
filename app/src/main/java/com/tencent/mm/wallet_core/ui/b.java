package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class b {
    public static i a(Context context, int i, String str, String str2, OnClickListener onClickListener) {
        return h.a(context, str, str2, ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null), onClickListener);
    }
}
