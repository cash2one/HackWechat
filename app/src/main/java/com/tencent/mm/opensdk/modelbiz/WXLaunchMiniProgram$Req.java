package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class WXLaunchMiniProgram$Req extends BaseReq {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgram.Req";
    public int miniprogramType = 0;
    public String path = "";
    public String userName;

    public final boolean checkArgs() {
        if (d.a(this.userName)) {
            Log.e(TAG, "userName is null");
            return false;
        } else if (this.miniprogramType >= 0 && this.miniprogramType <= 2) {
            return true;
        } else {
            Log.e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
            return false;
        }
    }

    public final int getType() {
        return 19;
    }

    public final void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_launch_wxminiprogram_username", this.userName);
        bundle.putString("_launch_wxminiprogram_path", this.path);
        bundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
    }
}
