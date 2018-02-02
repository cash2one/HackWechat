package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h$b;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.tools.a.c;

public final class a {
    public static i a(Context context, String str, String str2, String str3, int i, h$b com_tencent_mm_ui_base_h_b, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(context);
        aVar.mi(false);
        aVar.mj(true);
        aVar.ED(com.tencent.mm.plugin.wxpay.a.i.dEn).b(onClickListener);
        aVar.YF(str);
        View inflate = View.inflate(context, g.uEo, null);
        EditText editText = (EditText) inflate.findViewById(f.cdj);
        if (!bh.ov(str2)) {
            editText.append(str2);
        }
        TextView textView = (TextView) inflate.findViewById(f.cSe);
        if (bh.ov(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.EC(com.tencent.mm.plugin.wxpay.a.i.dFU).a(false, new 1(com_tencent_mm_ui_base_h_b, editText, context));
        if (i > 0) {
            c.d(editText).GN(i).a(null);
        }
        aVar.dk(inflate);
        Dialog akx = aVar.akx();
        akx.show();
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(akx);
        }
        if (context instanceof MMActivity) {
            inflate.post(new 2(context));
        }
        return akx;
    }
}
