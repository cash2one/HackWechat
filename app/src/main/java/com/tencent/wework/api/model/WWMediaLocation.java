package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaLocation extends WWMediaMessage$WWMediaObject {
    public double ApC;
    public String hxu;
    public double latitude;
    public double longitude;

    public final boolean checkArgs() {
        if (super.checkArgs() && this.hxu != null && this.hxu.length() != 0 && this.hxu.length() <= 10240) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        bundle.putString("_wwlocobject_address", this.hxu);
        bundle.putDouble("_wwlocobject_longitude", this.longitude);
        bundle.putDouble("_wwlocobject_latitude", this.latitude);
        bundle.putDouble("_wwlocobject_zoom", this.ApC);
        super.toBundle(bundle);
    }
}
