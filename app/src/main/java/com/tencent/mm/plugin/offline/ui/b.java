package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;

public final class b {
    public static void b(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(a$i.uXa);
        }
        h.a(activity, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
}
