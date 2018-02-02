package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.network.ab;
import com.tencent.mm.pluginsdk.ui.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr.14;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class t$a {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(Context context, int i, int i2, String str, int i3) {
        switch (i) {
            case 1:
                if ((i3 & 2) != 0 && ar.CG().Kn()) {
                    ar.CG().getNetworkServerIp();
                    new StringBuilder().append(i2);
                } else if (!((i3 & 1) != 0 && ab.bC(context) && k.eo(context))) {
                    if ((i3 & 4) != 0 && an.isWap(context)) {
                        boolean z;
                        if (!ar.Hj()) {
                            z = false;
                            break;
                        }
                        ar.Hg();
                        if (!bh.c((Boolean) c.CU().get(61, null))) {
                            if (!ae.Vc("show_wap_adviser")) {
                                z = false;
                                break;
                            }
                            View inflate = View.inflate(context, R.i.doW, null);
                            ((TextView) inflate.findViewById(R.h.czk)).setText(R.l.exO);
                            CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.czj);
                            checkBox.setText(context.getString(R.l.eAZ));
                            checkBox.setOnCheckedChangeListener(new MMAppMgr$12());
                            checkBox.setVisibility(0);
                            a aVar = new a(context);
                            aVar.Ez(R.l.dGO);
                            aVar.dk(inflate);
                            aVar.EC(R.l.eBb).a(new MMAppMgr$13(context));
                            aVar.mi(false);
                            aVar.ED(R.l.eBa);
                            aVar.a(new 14());
                            aVar.akx().show();
                            z = true;
                            break;
                        }
                        z = false;
                        break;
                    }
                    Toast.makeText(context, context.getString(R.l.eiD, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                return true;
            case 2:
                Toast.makeText(context, context.getString(R.l.eiE, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                return true;
            case 3:
                return true;
            case 4:
                com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    OnClickListener onClickListener;
                    x.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(eA.showType), eA.url, eA.desc});
                    if (bh.ov(eA.url)) {
                        onClickListener = null;
                    } else {
                        onClickListener = new 1(eA, context);
                    }
                    if (eA.a(context, onClickListener, null)) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }
}
