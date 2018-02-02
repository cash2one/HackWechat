package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXInvoiceAuthInsert$Resp extends BaseResp {
    public String wxOrderId;

    public final boolean checkArgs() {
        return true;
    }

    public final void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.wxOrderId = bundle.getString("_wxapi_invoice_auth_insert_order_id");
    }

    public final int getType() {
        return 20;
    }

    public final void toBundle(Bundle bundle) {
        super.fromBundle(bundle);
        bundle.putString("_wxapi_invoice_auth_insert_order_id", this.wxOrderId);
    }
}
