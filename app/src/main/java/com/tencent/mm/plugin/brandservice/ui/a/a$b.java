package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.brandservice.ui.a.a.a;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.z.r;

public class a$b extends b$b {
    final /* synthetic */ a kHy;

    public a$b(a aVar) {
        this.kHy = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.diL, viewGroup, false);
        a aVar = this.kHy.kHx;
        aVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
        aVar.iiq = (TextView) inflate.findViewById(R.h.cSu);
        aVar.iir = (TextView) inflate.findViewById(R.h.caS);
        aVar.contentView = inflate.findViewById(R.h.cJK);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, b.a aVar, b bVar, Object... objArr) {
        a aVar2 = (a) bVar;
        a aVar3 = (a) aVar;
        cm(aVar3.contentView);
        e.a(context, aVar3.iip, aVar2.iconUrl, null, R.g.bzZ);
        e.a(aVar2.kHu, aVar3.iiq);
        e.a(aVar2.kHv, aVar3.iir);
    }

    public final boolean a(Context context, b bVar) {
        a aVar = (a) bVar;
        b$b.a(this.kHy.mMb.mLA, aVar.iVU);
        Intent intent;
        if (f.jX(aVar.username)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", aVar.username);
            intent.putExtra("enterprise_biz_display_name", r.gu(aVar.username));
            intent.putExtra("enterprise_from_scene", 3);
            d.a(context, ".ui.conversation.EnterpriseConversationUI", intent);
        } else if (f.eE(aVar.username)) {
            intent = new Intent();
            intent.putExtra("Contact_User", aVar.username);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 5);
            d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.jY(aVar.username)) {
            com.tencent.mm.ag.d jS = f.jS(aVar.username);
            String Li = jS == null ? null : jS.Li();
            if (Li == null) {
                Li = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", Li);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", aVar.username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", aVar.username);
            intent.putExtra("finish_direct", true);
            d.a(context, ".ui.chatting.ChattingUI", intent);
        }
        com.tencent.mm.bc.d.lT(aVar.username);
        return true;
    }
}
