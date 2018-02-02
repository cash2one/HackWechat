package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.i;
import java.util.LinkedList;
import java.util.List;

public final class h {
    public static Dialog a(Context context, List<Bankcard> list, String str, String str2, Bankcard bankcard, a aVar) {
        List linkedList = new LinkedList();
        if ((list == null || list.size() == 0) && bh.ov(str)) {
            x.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
            return null;
        }
        int i;
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
            linkedList.add(str);
            i = 0;
        } else {
            int i2 = 0;
            i = 0;
            for (Bankcard bankcard2 : list) {
                linkedList.add(bankcard2.field_desc);
                if (bankcard != null && bankcard.equals(bankcard2)) {
                    i = i2;
                }
                i2++;
            }
            if (!bh.ov(str)) {
                linkedList.add(str);
                if (bankcard == null) {
                    i = i2;
                }
            }
        }
        return com.tencent.mm.ui.base.h.a(context, str2, linkedList, i, aVar);
    }

    public static i a(Context context, b bVar, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (bVar == null || (TextUtils.isEmpty(bVar.sKJ) && (bVar.sKK == null || bVar.sKK.isEmpty()))) {
            x.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            return null;
        }
        i.a aVar = new i.a(context);
        aVar.mi(false);
        aVar.ED(a$i.dEn).b(onClickListener2);
        if (z) {
            aVar.EC(a$i.uOS).a(onClickListener);
        } else {
            aVar.Ez(a$i.uOW);
            aVar.EC(a$i.uPa).a(onClickListener);
        }
        View inflate = View.inflate(context, a$g.uEV, null);
        if (bVar.sKK == null || bVar.sKK.isEmpty()) {
            x.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
        } else {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.bYF);
            linearLayout.removeAllViews();
            int i = 0;
            while (i < bVar.sKK.size() && i < bVar.sKK.size()) {
                View inflate2 = View.inflate(context, a$g.uEU, null);
                TextView textView = (TextView) inflate2.findViewById(f.subtitle);
                ((TextView) inflate2.findViewById(f.title)).setText(((b.b) bVar.sKK.get(i)).aAM);
                textView.setText(((b.b) bVar.sKK.get(i)).value);
                linearLayout.addView(inflate2, i);
                i++;
            }
        }
        ((TextView) inflate.findViewById(f.title)).setText(bVar.sKJ);
        if (z) {
            TextView textView2 = (TextView) inflate.findViewById(f.cRY);
            textView2.setVisibility(0);
            textView2.setText(context.getString(a$i.uOT));
        }
        aVar.dk(inflate);
        i akx = aVar.akx();
        akx.show();
        com.tencent.mm.ui.base.h.a(context, akx);
        return akx;
    }
}
