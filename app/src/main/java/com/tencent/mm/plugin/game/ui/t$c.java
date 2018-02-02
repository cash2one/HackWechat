package com.tencent.mm.plugin.game.ui;

public class t$c {
    public int actionType;
    String appId;
    int fFj;
    int nvk;
    int nvl;
    String nvp;
    String nvq;
    int position;
    int type;

    public t$c(String str) {
        this.actionType = 2;
        this.nvp = str;
    }

    public t$c(String str, byte b) {
        this.actionType = 2;
        this.type = 3;
        this.nvp = str;
    }

    public t$c(int i, int i2, String str, String str2) {
        this.actionType = i;
        this.type = i2;
        this.appId = str;
        if (i == 2) {
            this.nvp = str2;
        }
    }
}
