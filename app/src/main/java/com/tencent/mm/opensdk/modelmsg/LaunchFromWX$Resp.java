package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class LaunchFromWX$Resp extends BaseResp {
    public LaunchFromWX$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public int getType() {
        return 6;
    }
}
