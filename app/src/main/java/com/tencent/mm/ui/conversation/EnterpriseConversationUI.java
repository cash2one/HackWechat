package com.tencent.mm.ui.conversation;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.ui.v;

public class EnterpriseConversationUI extends BaseConversationUI {
    private View contentView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = v.fv(this).inflate(R.i.dbr, null);
        setContentView(this.contentView);
        this.conversationFm = new a();
        getSupportFragmentManager().aS().a(R.h.cws, this.conversationFm).commit();
        e.a(this, this.contentView);
    }

    public void finish() {
        if (this.conversationFm != null && (this.conversationFm instanceof a)) {
            ((a) this.conversationFm).hQr = System.currentTimeMillis() / 1000;
        }
        super.finish();
    }
}
