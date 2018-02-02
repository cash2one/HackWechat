package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.d;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public class r$h extends d {
    public r$h(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        int i = arVar.designerUIN;
        String str = arVar.designerName;
        String str2 = arVar.designerRediretctUrl;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.crz());
            intent.putExtra("rawUrl", arVar.gjD);
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
            intent.putExtra("name", str);
            intent.putExtra("rediret_url", str2);
            intent.putExtra("extra_scence", 22);
            com.tencent.mm.bm.d.b(aVar.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
        }
    }
}
