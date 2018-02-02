package com.tencent.mm.z;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.x;

public class bh$a {
    private int hhr;
    private int hhs;
    private int hht;
    private int id;

    public final bh$a gY(int i) {
        this.hhr = i;
        return this;
    }

    public final bh$a gZ(int i) {
        this.hhs = i;
        return this;
    }

    public final bh$a ha(int i) {
        this.hht = i;
        return this;
    }

    public final boolean commit() {
        Editor edit = bh.a(bh.HO()).edit();
        if (this.id > 0) {
            edit.putInt("MicroMsg.RegStyleStoragestyle_id", this.id);
        } else {
            edit.remove("MicroMsg.RegStyleStoragestyle_id");
        }
        if (this.hhr > 0) {
            edit.putInt("MicroMsg.RegStyleStoragenew_flow", this.hhr);
        } else {
            edit.putInt("MicroMsg.RegStyleStoragenew_flow", 0);
        }
        if (this.hhs > 0) {
            edit.putInt("MicroMsg.RegStyleStoragehas_password", this.hhs);
        } else {
            edit.remove("MicroMsg.RegStyleStoragehas_password");
        }
        if (this.hht > 0) {
            edit.putInt("MicroMsg.RegStyleStoragehas_AVATAR", this.hht);
        } else {
            edit.remove("MicroMsg.RegStyleStoragehas_AVATAR");
        }
        x.i("MicroMsg.RegStyleStorage", "id: " + this.id + " newFlow: " + this.hhr + "hasPassword:" + this.hhs + "hasAvatar:" + this.hht);
        return edit.commit();
    }
}
