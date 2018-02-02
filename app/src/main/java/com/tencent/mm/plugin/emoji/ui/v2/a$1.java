package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class a$1 extends af {
    final /* synthetic */ a lFm;

    a$1(a aVar) {
        this.lFm = aVar;
    }

    public final void handleMessage(Message message) {
        a aVar = this.lFm;
        String string;
        switch (message.what) {
            case 131074:
                if (aVar.lxL != null) {
                    aVar.lxL.notifyDataSetChanged();
                    return;
                }
                return;
            case 131075:
                if (aVar.lxL != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        aVar.lxL.bd(string, message.getData().getInt("progress"));
                        return;
                    }
                    return;
                }
                return;
            case 131076:
                if (aVar.lxL != null && message.getData() != null) {
                    string = message.getData().getString("product_id");
                    if (string != null) {
                        aVar.lxL.bc(string, message.getData().getInt(DownloadInfo.STATUS));
                        return;
                    }
                    return;
                }
                return;
            case 131077:
                if (aVar.lAq != null) {
                    aVar.lAq.aDi();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
