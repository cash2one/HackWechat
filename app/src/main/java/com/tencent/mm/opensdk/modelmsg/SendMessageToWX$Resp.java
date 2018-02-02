package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class SendMessageToWX$Resp extends BaseResp {
    public SendMessageToWX$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
    }

    public int getType() {
        return 2;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
    }
}
