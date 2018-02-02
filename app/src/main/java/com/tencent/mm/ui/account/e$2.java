package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;

class e$2 implements d {
    final /* synthetic */ Context val$context;
    final /* synthetic */ String xOh = null;
    final /* synthetic */ String xOi = null;
    final /* synthetic */ String xOj = null;

    e$2(Context context, String str, String str2, String str3) {
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str;
        switch (menuItem.getItemId()) {
            case 1:
                b.oH("F100_100_QQ");
                b.b(true, ar.CB() + "," + this.val$context.getClass().getName() + ",F100_100_QQ," + ar.fH("F100_100_QQ") + ",1");
                e.bo(this.val$context, this.val$context.getString(R.l.eSm));
                return;
            case 2:
                b.oH("F100_100_Email");
                b.b(true, ar.CB() + "," + this.val$context.getClass().getName() + ",F100_100_Email," + ar.fH("F100_100_Email") + ",1");
                e.bo(this.val$context, this.val$context.getString(R.l.etx));
                return;
            case 4:
                Context context = this.val$context;
                String str2 = this.xOh;
                str = this.xOi;
                String str3 = this.xOj;
                b.oH("F100_100_phone");
                b.b(true, ar.CB() + "," + context.getClass().getName() + ",F100_100_phone," + ar.fH("F100_100_phone") + ",1");
                if (com.tencent.mm.protocal.d.vAC) {
                    Toast.makeText(context, context.getString(R.l.dDF), 0).show();
                    return;
                }
                Intent intent = new Intent(context, MobileInputUI.class);
                if (str != null) {
                    int indexOf = str.indexOf("+");
                    if (indexOf != -1 && str.length() > 0) {
                        str = str.substring(indexOf + 1);
                    }
                    intent.putExtra("couttry_code", str);
                }
                if (str2 != null) {
                    intent.putExtra("country_name", str2);
                }
                if (str3 != null) {
                    intent.putExtra("bindmcontact_shortmobile", str3);
                }
                intent.putExtra("mobile_input_purpose", 1);
                context.startActivity(intent);
                return;
            case 8:
                str = this.val$context.getString(R.l.eXC);
                if (w.cfi().equals("zh_CN")) {
                    str = str + "zh_CN";
                } else {
                    str = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                }
                e.bo(this.val$context, str);
                return;
            default:
                return;
        }
    }
}
