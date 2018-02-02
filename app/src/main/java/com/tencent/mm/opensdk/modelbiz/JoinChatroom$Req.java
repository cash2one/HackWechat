package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.d;

public class JoinChatroom$Req extends BaseReq {
    public String chatroomNickName;
    public String extMsg;
    public String groupId = "";

    public boolean checkArgs() {
        return !d.a(this.groupId);
    }

    public int getType() {
        return 15;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
        bundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
        bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
