package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class JoinChatroom$Resp extends BaseResp {
    public String extMsg;

    public JoinChatroom$Resp(Bundle bundle) {
        fromBundle(bundle);
    }

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.extMsg = bundle.getString("_wxapi_join_chatroom_ext_msg");
    }

    public int getType() {
        return 15;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
    }
}
