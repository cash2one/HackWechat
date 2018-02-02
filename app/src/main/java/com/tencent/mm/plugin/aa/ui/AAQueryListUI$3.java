package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class AAQueryListUI$3 implements OnItemClickListener {
    final /* synthetic */ AAQueryListUI iih;

    AAQueryListUI$3(AAQueryListUI aAQueryListUI) {
        this.iih = aAQueryListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (AAQueryListUI.f(this.iih) != null) {
            if (i < 0 || i >= AAQueryListUI.f(this.iih).getCount()) {
                x.i("MicroMsg.AAQueryListUI", "click out of bound! %s", Integer.valueOf(i));
                return;
            }
            int top = view.getTop();
            k kVar = (k) AAQueryListUI.f(this.iih).getItem(i);
            if (kVar != null) {
                if (!bh.ov(kVar.vDi)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", kVar.vDi);
                    d.b(this.iih, "webview", ".ui.tools.WebViewUI", intent);
                } else if (!bh.ov(kVar.vCW)) {
                    String str = null;
                    if (kVar.vDh == 2) {
                        str = q.FS();
                    }
                    Intent intent2 = new Intent(this.iih, PaylistAAUI.class);
                    intent2.putExtra("bill_no", kVar.vCW);
                    intent2.putExtra("launcher_user_name", str);
                    intent2.putExtra("enter_scene", 4);
                    intent2.putExtra("chatroom", kVar.vCX);
                    intent2.putExtra("item_position", i);
                    intent2.putExtra("item_offset", top);
                    this.iih.startActivityForResult(intent2, 1);
                }
            }
        }
        g.pQN.h(13721, Integer.valueOf(5), Integer.valueOf(3));
    }
}
