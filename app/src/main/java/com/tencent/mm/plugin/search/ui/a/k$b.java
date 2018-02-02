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
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.ui.FTSConvMessageUI;
import com.tencent.mm.sdk.platformtools.bh;

public class k$b extends b {
    final /* synthetic */ k qeD;

    public k$b(k kVar) {
        this.qeD = kVar;
        super(kVar);
    }

    public View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.djg, viewGroup, false);
        k$a com_tencent_mm_plugin_search_ui_a_k_a = this.qeD.qeC;
        com_tencent_mm_plugin_search_ui_a_k_a.iip = (ImageView) inflate.findViewById(R.h.bLL);
        com_tencent_mm_plugin_search_ui_a_k_a.kBH = (TextView) inflate.findViewById(R.h.cAn);
        com_tencent_mm_plugin_search_ui_a_k_a.ldJ = (TextView) inflate.findViewById(R.h.cxH);
        com_tencent_mm_plugin_search_ui_a_k_a.ldK = (TextView) inflate.findViewById(R.h.cRs);
        com_tencent_mm_plugin_search_ui_a_k_a.contentView = inflate.findViewById(R.h.cJK);
        inflate.setTag(com_tencent_mm_plugin_search_ui_a_k_a);
        return inflate;
    }

    public void a(Context context, a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        k kVar = (k) bVar;
        k$a com_tencent_mm_plugin_search_ui_a_k_a = (k$a) aVar;
        cm(com_tencent_mm_plugin_search_ui_a_k_a.contentView);
        com.tencent.mm.pluginsdk.ui.a.b.a(com_tencent_mm_plugin_search_ui_a_k_a.iip, kVar.username);
        e.a(kVar.iil, com_tencent_mm_plugin_search_ui_a_k_a.kBH);
        e.a(kVar.iim, com_tencent_mm_plugin_search_ui_a_k_a.ldJ);
        e.a(kVar.qeA, com_tencent_mm_plugin_search_ui_a_k_a.ldK);
    }

    public boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        String str = null;
        k kVar = (k) bVar;
        Intent intent;
        d jS;
        Intent intent2;
        if (this.qeD.qez < 2) {
            if (f.jX(kVar.username)) {
                com.tencent.mm.plugin.search.a.ifs.d(new Intent().putExtra("Contact_User", kVar.username), context);
            } else if (f.eE(kVar.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", kVar.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                com.tencent.mm.bm.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.jY(kVar.username)) {
                jS = f.jS(kVar.username);
                if (jS != null) {
                    str = jS.Li();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", kVar.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                com.tencent.mm.plugin.search.a.ifs.e(new Intent().putExtra("Chat_User", kVar.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", kVar.iVU.mMf).putExtra("highlight_keyword_list", bh.F(this.qeD.mMb.mLC)), context);
            }
        } else if (f.eE(kVar.username)) {
            intent = new Intent();
            intent.putExtra("Contact_User", kVar.username);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 5);
            com.tencent.mm.bm.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.jY(kVar.username)) {
            jS = f.jS(kVar.username);
            if (jS != null) {
                str = jS.Li();
            }
            if (str == null) {
                str = "";
            }
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", kVar.username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            context.startActivity(new Intent(context, FTSConvMessageUI.class).putExtra("Search_Scene", this.qeD.mOz).putExtra("key_conv", kVar.username).putExtra("key_query", kVar.mMb.mLA).putExtra("key_count", kVar.qez));
        }
        return true;
    }
}
