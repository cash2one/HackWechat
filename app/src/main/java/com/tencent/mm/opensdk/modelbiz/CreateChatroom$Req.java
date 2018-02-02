package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.d;

public class CreateChatroom$Req extends BaseReq {
    public String chatroomName;
    public String chatroomNickName;
    public String extMsg;
    public String groupId = "";

    public boolean checkArgs() {
        return !d.a(this.groupId);
    }

    public int getType() {
        return 14;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
        bundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
        bundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
        bundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
