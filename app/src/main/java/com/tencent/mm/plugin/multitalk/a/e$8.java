package com.tencent.mm.plugin.multitalk.a;

import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.Comparator;

class e$8 implements Comparator<MultiTalkGroupMember> {
    final /* synthetic */ e oGz;

    e$8(e eVar) {
        this.oGz = eVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
        MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
        if (!(multiTalkGroupMember.status == 10 && multiTalkGroupMember2.status == 10)) {
            if (multiTalkGroupMember.status == 10) {
                return -1;
            }
            if (multiTalkGroupMember.status == 10) {
                return 1;
            }
        }
        return 0;
    }
}
