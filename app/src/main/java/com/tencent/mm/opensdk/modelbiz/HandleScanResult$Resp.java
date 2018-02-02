package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class HandleScanResult$Resp extends BaseResp {
    public HandleScanResult$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
    }

    public int getType() {
        return 17;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
    }
}
