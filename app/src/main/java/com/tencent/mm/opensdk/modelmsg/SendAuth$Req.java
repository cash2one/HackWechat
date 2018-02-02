package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SendAuth$Req extends BaseReq {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
    public String scope;
    public String state;

    public SendAuth$Req(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        if (this.scope == null || this.scope.length() == 0 || this.scope.length() > 1024) {
            Log.e(TAG, "checkArgs fail, scope is invalid");
            return false;
        } else if (this.state == null || this.state.length() <= 1024) {
            return true;
        } else {
            Log.e(TAG, "checkArgs fail, state is invalid");
            return false;
        }
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.scope = bundle.getString("_wxapi_sendauth_req_scope");
        this.state = bundle.getString("_wxapi_sendauth_req_state");
    }

    public int getType() {
        return 1;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_sendauth_req_scope", this.scope);
        bundle.putString("_wxapi_sendauth_req_state", this.state);
    }
}
