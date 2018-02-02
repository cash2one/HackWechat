package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class d {

    public interface b {
        void atf();

        void awa();
    }

    public static void a(MMActivity mMActivity, String str, String str2, b bVar) {
        String string;
        if (TextUtils.isEmpty(str2)) {
            string = mMActivity.getString(R.l.dEx);
        } else {
            string = str2;
        }
        h.a(mMActivity, true, string, mMActivity.getString(R.l.dGO), mMActivity.getString(R.l.dFU), mMActivity.getString(R.l.dEn), new 1(bVar, str), new 3());
    }

    public static void a(MMActivity mMActivity, b bVar) {
        h.a(mMActivity, true, mMActivity.getString(R.l.dNN), "", mMActivity.getString(R.l.dFU), mMActivity.getString(R.l.dEn), new 4(bVar), new 5());
    }

    public static void b(MMActivity mMActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(R.l.dPR);
        }
        a(mMActivity, str, false);
    }

    public static void b(MMActivity mMActivity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = "errcode = " + i;
        }
        a(mMActivity, str, false);
    }

    public static void a(MMActivity mMActivity, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = mMActivity.getString(R.l.dPR);
        }
        h.a(mMActivity, str, null, false, new 6(z, mMActivity));
    }

    public static void c(final Context context, int i, int i2, String str) {
        if (i != -1) {
            i a;
            String string;
            TextView textView;
            if (i == R.i.dcG) {
                string = context.getResources().getString(i2);
                String string2 = context.getResources().getString(R.l.eHQ);
                OnClickListener anonymousClass9 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                };
                View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
                if (i == R.i.dcF) {
                    textView = (TextView) inflate.findViewById(R.h.bSb);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(R.l.dbT);
                    }
                    textView.setText(context.getResources().getString(R.l.dNC, new Object[]{str}));
                } else if (i == R.i.dcE) {
                    textView = (TextView) inflate.findViewById(R.h.bSb);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(R.l.dbT);
                    }
                    textView.setText(context.getResources().getString(R.l.dNB, new Object[]{str}));
                }
                a = h.a(context, string, string2, inflate, anonymousClass9);
            } else {
                string = context.getResources().getString(i2);
                String string3 = context.getResources().getString(R.l.dOu);
                String string4 = context.getResources().getString(R.l.eHQ);
                OnClickListener anonymousClass10 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent();
                        intent.putExtra("key_from_scene", 22);
                        intent.putExtra("key_home_page_from_scene", 1);
                        com.tencent.mm.bm.d.b(context, "card", ".ui.CardHomePageUI", intent);
                        x.i("MicroMsg.CardDialogHelper", "enter to cardhome");
                    }
                };
                OnClickListener anonymousClass2 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                };
                View inflate2 = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
                if (i == R.i.dcF) {
                    textView = (TextView) inflate2.findViewById(R.h.bSb);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(R.l.dbT);
                    }
                    textView.setText(context.getResources().getString(R.l.dNC, new Object[]{str}));
                } else if (i == R.i.dcE) {
                    textView = (TextView) inflate2.findViewById(R.h.bSb);
                    if (TextUtils.isEmpty(str)) {
                        str = context.getResources().getString(R.l.dbT);
                    }
                    textView.setText(context.getResources().getString(R.l.dNB, new Object[]{str}));
                }
                a = h.a(context, string, inflate2, string3, string4, anonymousClass10, anonymousClass2);
            }
            if (a != null) {
                a.show();
            }
        }
    }
}
