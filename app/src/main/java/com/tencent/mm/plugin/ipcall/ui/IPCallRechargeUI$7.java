package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

class IPCallRechargeUI$7 extends ClickableSpan {
    final /* synthetic */ IPCallRechargeUI nLL;

    IPCallRechargeUI$7(IPCallRechargeUI iPCallRechargeUI) {
        this.nLL = iPCallRechargeUI;
    }

    public final void onClick(View view) {
        ((TextView) view).setHighlightColor(this.nLL.getResources().getColor(R.e.transparent));
        Intent intent = new Intent();
        String str = this.nLL.getString(R.l.erc) + "&usedcc=";
        List aTm = c.aTj().aTm();
        if (aTm.size() > 0) {
            int size = aTm.size();
            if (size > 5) {
                size = 5;
            }
            int i = 0;
            while (i < size) {
                String Dd = a.Dd(((Integer) aTm.get(i)).toString());
                if (bh.ov(Dd)) {
                    Dd = str;
                } else {
                    Dd = str + Dd + "|";
                }
                i++;
                str = Dd;
            }
            if (str.endsWith("|")) {
                str = str.substring(0, str.length() - 1);
            }
        } else {
            str = str + a.Dd(com.tencent.mm.plugin.ipcall.b.c.aUO());
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this.nLL, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.nLL.getResources().getColor(R.e.btd));
        textPaint.setUnderlineText(false);
    }
}
