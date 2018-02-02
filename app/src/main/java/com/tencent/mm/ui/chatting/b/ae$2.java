package com.tencent.mm.ui.chatting.b;

import android.view.ViewStub;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;

class ae$2 implements c {
    final /* synthetic */ ae yCJ;

    ae$2(ae aeVar) {
        this.yCJ = aeVar;
    }

    public final void g(Boolean bool) {
        if (bool.booleanValue()) {
            if (this.yCJ.yCH == null) {
                this.yCJ.yCH = ((ViewStub) this.yCJ.fhr.csq().findViewById(R.h.cWg)).inflate();
            }
            this.yCJ.yCH.setVisibility(0);
        } else if (this.yCJ.yCH != null && this.yCJ.yCH.getVisibility() == 0) {
            this.yCJ.yCH.setVisibility(8);
        }
    }
}
