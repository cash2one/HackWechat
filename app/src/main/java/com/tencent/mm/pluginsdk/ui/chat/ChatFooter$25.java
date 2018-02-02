package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.pluginsdk.ui.chat.i.a;
import java.util.ArrayList;

class ChatFooter$25 implements a {
    final /* synthetic */ Context val$context;
    final /* synthetic */ ChatFooter vra;

    ChatFooter$25(ChatFooter chatFooter, Context context) {
        this.vra = chatFooter;
        this.val$context = context;
    }

    public final void SB(String str) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        if (ChatFooter.e(this.vra) != null) {
            intent.putExtra("GalleryUI_FromUser", ChatFooter.e(this.vra));
        }
        if (ChatFooter.f(this.vra) != null) {
            intent.putExtra("GalleryUI_ToUser", ChatFooter.f(this.vra));
        }
        intent.putExtra("query_source_type", 3);
        intent.putExtra("preview_image", true);
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putExtra("max_select_count", 1);
        intent.addFlags(67108864);
        if (ChatFooter.g(this.vra) != null) {
            d.a(ChatFooter.g(this.vra), "gallery", ".ui.GalleryEntryUI", intent, e.CTRL_INDEX);
        } else {
            d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, e.CTRL_INDEX);
        }
    }
}
