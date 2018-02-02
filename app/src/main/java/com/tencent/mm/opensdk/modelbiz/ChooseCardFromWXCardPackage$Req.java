package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class ChooseCardFromWXCardPackage$Req extends BaseReq {
    public String appId;
    public String canMultiSelect;
    public String cardId;
    public String cardSign;
    public String cardType;
    public String locationId;
    public String nonceStr;
    public String signType;
    public String timeStamp;

    public boolean checkArgs() {
        return this.appId != null && this.appId.length() > 0 && this.signType != null && this.signType.length() > 0 && this.cardSign != null && this.cardSign.length() > 0;
    }

    public int getType() {
        return 16;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
        bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
        bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
        bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
        bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
        bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
        bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
        bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
        bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
    }
}
