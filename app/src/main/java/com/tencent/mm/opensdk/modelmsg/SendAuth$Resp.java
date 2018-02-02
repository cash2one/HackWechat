package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class SendAuth$Resp extends BaseResp {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
    public String code;
    public String country;
    public String lang;
    public String state;
    public String url;

    public SendAuth$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        if (this.state == null || this.state.length() <= 1024) {
            return true;
        }
        Log.e(TAG, "checkArgs fail, state is invalid");
        return false;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.code = bundle.getString("_wxapi_sendauth_resp_token");
        this.state = bundle.getString("_wxapi_sendauth_resp_state");
        this.url = bundle.getString("_wxapi_sendauth_resp_url");
        this.lang = bundle.getString("_wxapi_sendauth_resp_lang");
        this.country = bundle.getString("_wxapi_sendauth_resp_country");
    }

    public int getType() {
        return 1;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_sendauth_resp_token", this.code);
        bundle.putString("_wxapi_sendauth_resp_state", this.state);
        bundle.putString("_wxapi_sendauth_resp_url", this.url);
        bundle.putString("_wxapi_sendauth_resp_lang", this.lang);
        bundle.putString("_wxapi_sendauth_resp_country", this.country);
    }
}
