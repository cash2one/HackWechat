package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bc.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.BizConversationUI.a;
import java.util.Map;

class BizConversationUI$a$1 implements OnMenuItemClickListener {
    final /* synthetic */ a yWk;

    BizConversationUI$a$1(a aVar) {
        this.yWk = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (g.zM(0)) {
            Intent QM = b.QM();
            QM.putExtra("title", this.yWk.getString(R.l.ekK));
            QM.putExtra("searchbar_tips", this.yWk.getString(R.l.ekK));
            QM.putExtra("KRightBtn", true);
            QM.putExtra("ftsneedkeyboard", true);
            QM.putExtra("publishIdPrefix", "bs");
            QM.putExtra("ftsType", 2);
            QM.putExtra("ftsbizscene", 11);
            Map b = b.b(11, true, 2);
            String zH = g.zH(bh.VI((String) b.get("scene")));
            b.put("sessionId", zH);
            QM.putExtra("sessionId", zH);
            QM.putExtra("rawUrl", b.r(b));
            QM.putExtra("key_load_js_without_delay", true);
            QM.addFlags(67108864);
            d.b(ac.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QM);
        } else {
            x.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
        }
        return true;
    }
}
