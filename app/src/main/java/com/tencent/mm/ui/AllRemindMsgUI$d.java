package com.tencent.mm.ui;

import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.sdk.platformtools.bh;

class AllRemindMsgUI$d {
    String fpL;
    int fpn;
    int fqd;
    long fqm;
    long timestamp;
    String title;
    String username;
    String wer;
    final /* synthetic */ AllRemindMsgUI xDG;
    bca xDM;
    String xDN;

    AllRemindMsgUI$d(AllRemindMsgUI allRemindMsgUI) {
        this.xDG = allRemindMsgUI;
    }

    public final String toString() {
        return "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.fpL + '\'' + ", title='" + bh.VT(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.fpn + ", msgId=" + this.fqm + ", sourceType=" + this.fqd + ", sourceId='" + this.wer + '\'' + '}';
    }
}
