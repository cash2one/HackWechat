package com.tencent.mm.plugin.mmsight.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class a$a {
    int cOY = 2;
    int scene;

    public a$a(int i) {
        if (i == 1) {
            this.scene = 1;
        } else if (i == 2) {
            this.scene = 2;
        } else if (i == WXMediaMessage.TITLE_LENGTH_LIMIT) {
            this.cOY = 1;
            this.scene = 2;
        } else if (i == 4) {
            this.scene = 4;
        }
    }

    public final String toString() {
        return "VideoEditCountData{scene=" + this.scene + ", source=" + this.cOY + '}';
    }
}
