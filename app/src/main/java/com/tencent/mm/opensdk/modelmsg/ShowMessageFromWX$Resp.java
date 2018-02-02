package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class ShowMessageFromWX$Resp extends BaseResp {
    public ShowMessageFromWX$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public int getType() {
        return 4;
    }
}
