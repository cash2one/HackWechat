package com.tencent.mm.modelfriend;

import android.content.ContentValues;

public final class k {
    int fDt = -1;
    public int fWf = 0;
    public int fWo = 0;
    public String fWp = "";
    public String fWq = "";
    public String signature = "";
    public String username = "";

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("sex", Integer.valueOf(this.fWf));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.fWo));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("province", this.fWp == null ? "" : this.fWp);
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("city", this.fWq == null ? "" : this.fWq);
        }
        if ((this.fDt & 32) != 0) {
            String str;
            String str2 = "signature";
            if (this.signature == null) {
                str = "";
            } else {
                str = this.signature;
            }
            contentValues.put(str2, str);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
