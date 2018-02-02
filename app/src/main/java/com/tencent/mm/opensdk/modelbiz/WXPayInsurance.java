package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXPayInsurance {

    public static final class Resp extends BaseResp {
        public String wxOrderId;

        public final boolean checkArgs() {
            return true;
        }

        public final void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.wxOrderId = bundle.getString("_wxapi_pay_insourance_order_id");
        }

        public final int getType() {
            return 22;
        }

        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_order_id", this.wxOrderId);
        }
    }

    public static final class Req extends BaseReq {
        private static final String TAG = "MicroMsg.SDK.WXPayInsurance.Req";
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
            this.url = bundle.getString("_wxapi_pay_insourance_req_url");
        }

        public final int getType() {
            return 22;
        }

        public final void toBundle(Bundle bundle) {
            super.fromBundle(bundle);
            bundle.putString("_wxapi_pay_insourance_req_url", this.url);
        }
    }
}
