package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXNontaxPay$Resp extends BaseResp {
    public String wxOrderId;

    public final boolean checkArgs() {
        return true;
    }

    public final void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.wxOrderId = bundle.getString("_wxapi_nontax_pay_order_id");
    }

    public final int getType() {
        return 21;
    }

    public final void toBundle(Bundle bundle) {
        super.fromBundle(bundle);
        bundle.putString("_wxapi_nontax_pay_order_id", this.wxOrderId);
    }
}
