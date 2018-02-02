package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class CreateChatroom$Resp extends BaseResp {
    public String extMsg;

    public CreateChatroom$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.extMsg = bundle.getString("_wxapi_create_chatroom_ext_msg");
    }

    public int getType() {
        return 14;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
    }
}
