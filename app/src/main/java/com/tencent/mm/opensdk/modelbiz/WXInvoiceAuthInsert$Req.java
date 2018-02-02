package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class WXInvoiceAuthInsert$Req extends BaseReq {
    private static final String TAG = "MicroMsg.SDK.WXInvoiceAuthInsert.Req";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String url;

    public final boolean checkArgs() {
        if (d.a(this.url)) {
            Log.i(TAG, "url should not be empty");
            return false;
        } else if (this.url.length() <= URL_LENGTH_LIMIT) {
            return true;
        } else {
            Log.e(TAG, "url must be in 10k");
            return false;
        }
    }

    public final void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.url = bundle.getString("_wxapi_invoice_auth_insert_req_url");
    }

    public final int getType() {
        return 20;
    }

    public final void toBundle(Bundle bundle) {
        super.fromBundle(bundle);
        bundle.putString("_wxapi_invoice_auth_insert_req_url", this.url);
    }
}
