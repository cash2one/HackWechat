package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.v;

@Keep
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
    private View contentView;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = v.fv(this).inflate(R.i.dbr, null);
        setContentView(this.contentView);
        this.conversationFm = new AppBrandServiceConversationFmUI();
        getSupportFragmentManager().aS().a(R.h.cws, this.conversationFm).commit();
        e.a(this, this.contentView);
    }

    public final void finish() {
        super.finish();
    }

    protected final ChattingUI$a getChattingUIFragment() {
        return new a();
    }
}
