package com.tencent.mm.ui.conversation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;

public class BizConversationUI extends BaseConversationUI {
    private View contentView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ar.Hj()) {
            this.contentView = v.fv(this).inflate(R.i.dbr, null);
            setContentView(this.contentView);
            this.conversationFm = new a();
            getSupportFragmentManager().aS().a(R.h.cws, this.conversationFm).commit();
            e.a(this, this.contentView);
            return;
        }
        x.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e.a(this, this.contentView);
    }
}
