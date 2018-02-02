package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage$Resp extends BaseResp {
    public String cardItemList;

    public ChooseCardFromWXCardPackage$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return (this.cardItemList == null || this.cardItemList.length() == 0) ? false : true;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
        if (string == null || string.length() <= 0) {
            Log.i("MicroMsg.ChooseCardFromWXCardPackage", "cardItemList is empty!");
        } else {
            this.cardItemList = string;
        }
    }

    public int getType() {
        return 16;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
    }
}
