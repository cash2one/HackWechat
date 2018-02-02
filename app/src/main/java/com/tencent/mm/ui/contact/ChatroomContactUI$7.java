package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.tools.p.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;

class ChatroomContactUI$7 implements a {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$7(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final void Xt() {
    }

    public final void Xu() {
    }

    public final void oL(String str) {
        x.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[]{str});
        ChatroomContactUI.a(this.yRt, t.ot(str));
    }

    public final void Xr() {
    }

    public final void Xs() {
    }

    public final void ass() {
        x.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        this.yRt.aWs();
    }

    public final void ast() {
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        x.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        if (z) {
            Intent intent = new Intent(this.yRt.mController.xIM, VoiceSearchResultUI.class);
            intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
            intent.putExtra("VoiceSearchResultUI_VoiceId", j);
            intent.putExtra("VoiceSearchResultUI_ShowType", i);
            this.yRt.mController.xIM.startActivity(intent);
            return;
        }
        intent = new Intent(this.yRt.mController.xIM, VoiceSearchResultUI.class);
        intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        intent.putExtra("VoiceSearchResultUI_Error", this.yRt.mController.xIM.getString(R.l.eiE));
        intent.putExtra("VoiceSearchResultUI_VoiceId", j);
        intent.putExtra("VoiceSearchResultUI_ShowType", i);
        this.yRt.mController.xIM.startActivity(intent);
    }

    public final boolean oK(String str) {
        return false;
    }
}
