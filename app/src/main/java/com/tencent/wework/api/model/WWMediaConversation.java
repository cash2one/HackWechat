package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaConversation extends WWMediaObject {
    public byte[] ApA;
    public WWMediaObject ApB;
    public long date;
    public String moS;
    public String name;

    public final boolean checkArgs() {
        if (!super.checkArgs()) {
            return false;
        }
        if (this.ApA != null && this.ApA.length > 10485760) {
            return false;
        }
        if (this.moS != null && this.moS.length() > 10240) {
            return false;
        }
        if ((this.moS == null || getFileSize(this.moS) <= 10485760) && this.ApB != null && this.ApB.checkArgs()) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wwconvobject_name", this.name);
        bundle.putLong("_wwconvobject_date", this.date);
        bundle.putByteArray("_wwconvobject_avatarData", this.ApA);
        bundle.putString("_wwconvobject_avatarPath", this.moS);
        bundle.putBundle("_wwconvobject_message", BaseMessage.b(this.ApB));
    }
}
