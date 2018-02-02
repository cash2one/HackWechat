package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.Builder;
import com.tencent.mm.opensdk.utils.Log;

public class GetMessageFromWX$Resp extends BaseResp {
    private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
    public WXMediaMessage message;

    public GetMessageFromWX$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        if (this.message != null) {
            return this.message.checkArgs();
        }
        Log.e(TAG, "checkArgs fail, message is null");
        return false;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.message = Builder.fromBundle(bundle);
    }

    public int getType() {
        return 3;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(Builder.toBundle(this.message));
    }
}
