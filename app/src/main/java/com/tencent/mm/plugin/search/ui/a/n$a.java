package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.plugin.search.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.search.ui.a.k.a;
import com.tencent.mm.plugin.search.ui.a.k.b;
import com.tencent.mm.sdk.platformtools.bh;

public class n$a extends b {
    final /* synthetic */ n qeL;

    public n$a(n nVar) {
        this.qeL = nVar;
        super(nVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.djg, viewGroup, false);
        a aVar = this.qeL.qeC;
        aVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
        aVar.kBH = (TextView) inflate.findViewById(R.h.cAn);
        aVar.ldJ = (TextView) inflate.findViewById(R.h.cxH);
        aVar.contentView = inflate.findViewById(R.h.cJK);
        aVar.ldK = (TextView) inflate.findViewById(R.h.cRs);
        aVar.iip.getLayoutParams().width = com.tencent.mm.bv.a.aa(context, R.f.bvP);
        aVar.iip.getLayoutParams().height = com.tencent.mm.bv.a.aa(context, R.f.bvP);
        inflate.setTag(aVar);
        return inflate;
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        String str = null;
        k kVar = (k) bVar;
        String str2 = kVar.iVU.mLs;
        Intent intent;
        d jS;
        Intent intent2;
        if (this.qeL.qez <= 1) {
            if (f.jX(str2)) {
                com.tencent.mm.plugin.search.a.ifs.d(new Intent().putExtra("Contact_User", str2), context);
            } else if (f.eE(str2)) {
                intent = new Intent();
                intent.putExtra("Contact_User", str2);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                com.tencent.mm.bm.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.jY(str2)) {
                jS = f.jS(str2);
                if (jS != null) {
                    str = jS.Li();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", str2);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                com.tencent.mm.plugin.search.a.ifs.e(new Intent().putExtra("Chat_User", str2).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", kVar.iVU.mMf).putExtra("highlight_keyword_list", bh.F(this.qeL.mMb.mLC)), context);
            }
        } else if (f.eE(str2)) {
            intent = new Intent();
            intent.putExtra("Contact_User", str2);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 5);
            com.tencent.mm.bm.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.jY(str2)) {
            jS = f.jS(str2);
            if (jS != null) {
                str = jS.Li();
            }
            if (str == null) {
                str = "";
            }
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", str2);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            context.startActivity(new Intent(context, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", this.qeL.mOz).putExtra("key_talker_query", this.qeL.qdU.mMb.mLA).putExtra("key_talker", this.qeL.qdU.mLs).putExtra("key_conv", kVar.username).putExtra("key_query", kVar.mMb.mLA).putExtra("detail_type", this.qeL.showType));
        }
        return true;
    }
}
