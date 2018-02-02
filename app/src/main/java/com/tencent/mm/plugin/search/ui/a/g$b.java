package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.b$b;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.sdk.platformtools.bh;

class g$b extends b$b {
    final /* synthetic */ g qei;

    private g$b(g gVar) {
        this.qei = gVar;
        super(gVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.diR, viewGroup, false);
        g$a com_tencent_mm_plugin_search_ui_a_g_a = this.qei.qeh;
        com_tencent_mm_plugin_search_ui_a_g_a.iir = (TextView) inflate.findViewById(R.h.caS);
        inflate.setTag(com_tencent_mm_plugin_search_ui_a_g_a);
        return inflate;
    }

    public final void a(Context context, a aVar, b bVar, Object... objArr) {
        e.a(this.qei.qef, ((g$a) aVar).iir);
    }

    public final boolean a(Context context, b bVar) {
        Intent intent = new Intent();
        intent.putExtra("query_phrase_list", bh.F(this.qei.mMb.mLC));
        intent.putExtra("go_to_chatroom_direct", true);
        intent.putExtra("scene_from", 3);
        d.a(context, ".ui.transmit.MMCreateChatroomUI", intent);
        return true;
    }
}
