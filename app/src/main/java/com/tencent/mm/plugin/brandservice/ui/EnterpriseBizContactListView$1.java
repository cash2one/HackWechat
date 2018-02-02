package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class EnterpriseBizContactListView$1 implements OnItemClickListener {
    final /* synthetic */ EnterpriseBizContactListView kGr;

    EnterpriseBizContactListView$1(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.kGr = enterpriseBizContactListView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof c)) {
            c cVar = (c) tag;
            if (!bh.ov(cVar.username)) {
                boolean jY = f.jY(cVar.username);
                boolean eE = f.eE(cVar.username);
                d jS = f.jS(cVar.username);
                String Li = jS == null ? null : jS.Li();
                if (Li == null) {
                    Li = "";
                }
                if (jY) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", Li);
                    intent.putExtra("useJs", true);
                    intent.putExtra("srcUsername", cVar.username);
                    intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent.addFlags(67108864);
                    com.tencent.mm.bm.d.b(this.kGr.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    EnterpriseBizContactListView.a(this.kGr, jS, 2);
                } else if (eE) {
                    r1 = new Intent();
                    r1.putExtra("Contact_User", cVar.username);
                    r1.addFlags(67108864);
                    r1.putExtra("biz_chat_from_scene", 3);
                    com.tencent.mm.bm.d.a(this.kGr.getContext(), ".ui.bizchat.BizChatConversationUI", r1);
                } else {
                    r1 = new Intent();
                    r1.addFlags(67108864);
                    r1.putExtra("finish_direct", true);
                    r1.putExtra("Chat_User", cVar.username);
                    r1.putExtra("chat_from_scene", 2);
                    Context context = this.kGr.getContext();
                    x.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                    a.ifs.e(r1, context);
                    EnterpriseBizContactListView.a(this.kGr, jS, 1);
                }
            }
        }
    }
}
