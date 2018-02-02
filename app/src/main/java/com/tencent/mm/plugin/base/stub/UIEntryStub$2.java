package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

class UIEntryStub$2 implements a {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ UIEntryStub kuR;
    final /* synthetic */ Req kuS;

    UIEntryStub$2(UIEntryStub uIEntryStub, Bundle bundle, Req req) {
        this.kuR = uIEntryStub;
        this.fhp = bundle;
        this.kuS = req;
    }

    public final void dP(boolean z) {
        boolean isFinishing = this.kuR.isFinishing();
        x.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
        if (z && !isFinishing) {
            Intent intent = new Intent(this.kuR, SendAppMessageWrapperUI.class);
            intent.putExtras(this.fhp);
            intent.putExtra("Select_Conv_User", "weixinfile");
            intent.putExtra("SendAppMessageWrapper_Scene", this.kuS.scene);
            this.kuR.startActivity(intent);
        }
        this.kuR.finish();
    }
}
