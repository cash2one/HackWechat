package com.tencent.mm.plugin.multitalk.a;

import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Comparator;

class e$1 implements Comparator<MultiTalkGroupMember> {
    final /* synthetic */ e oGz;

    e$1(e eVar) {
        this.oGz = eVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return -((MultiTalkGroupMember) obj).zQv.compareTo(((MultiTalkGroupMember) obj2).zQv);
    }
}
