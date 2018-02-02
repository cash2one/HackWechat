package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class WWMediaMessage extends WWBaseMessage {
    public String description;
    public byte[] thumbData;
    public String title;

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wwobject_title", this.title);
        bundle.putString("_wwobject_description", this.description);
        bundle.putByteArray("_wwobject_thumbdata", this.thumbData);
    }

    public boolean checkArgs() {
        if (this.thumbData != null && this.thumbData.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
            return false;
        }
        if (this.title != null && this.title.length() > WXMediaMessage.TITLE_LENGTH_LIMIT) {
            return false;
        }
        if (this.description == null || this.description.length() <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            return true;
        }
        return false;
    }
}
