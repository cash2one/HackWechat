package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXLaunchMiniProgram$Resp extends BaseResp {
    public String extMsg;

    public WXLaunchMiniProgram$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public final boolean checkArgs() {
        return true;
    }

    public final void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.extMsg = bundle.getString("_launch_wxminiprogram_ext_msg");
    }

    public final int getType() {
        return 19;
    }

    public final void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
        bundle.putInt("_wxapi_command_type", getType());
    }
}
