package com.tencent.wecall.talkroom.model;

import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;

public final class d {
    av Ane;
    private aw Anf;
    private String rJY;

    public d(av avVar) {
        a(avVar);
    }

    public d(av avVar, aw awVar) {
        a(avVar);
        if (awVar == null) {
            c.m("tagorewang:TalkRoomMember", new Object[]{"set null profile"});
            return;
        }
        this.Anf = awVar;
    }

    public final void a(av avVar) {
        if (avVar == null) {
            c.m("tagorewang:TalkRoomMember", new Object[]{"set null info"});
            return;
        }
        this.Ane = avVar;
    }

    public final String cHJ() {
        if (this.Ane != null) {
            return this.Ane.zOC;
        }
        return "";
    }

    public final String getDisplayName() {
        try {
            String str = this.rJY;
            if (str == null || str.trim().length() == 0) {
                return str;
            }
            char[] toCharArray = str.trim().toCharArray();
            int i = 0;
            for (char c : toCharArray) {
                i = c >= '¡' ? i + 2 : i + 1;
            }
            if (i <= 10) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                i = toCharArray[i2] >= '¡' ? i + 2 : i + 1;
                if (i + 1 > 10) {
                    break;
                }
                stringBuilder.append(toCharArray[i2]);
            }
            stringBuilder.append('…');
            return stringBuilder.toString();
        } catch (Exception e) {
            c.m("tagorewang:TalkRoomMember", new Object[]{"getDisplayName err: ", e});
            return this.rJY;
        }
    }

    public final int getState() {
        if (this.Ane == null) {
            return 0;
        }
        return this.Ane.status;
    }

    public final int cHK() {
        if (this.Ane == null) {
            return -1;
        }
        return this.Ane.nEd;
    }

    public final String toString() {
        int i = 0;
        if (this.Ane != null) {
            i = this.Ane.vCD;
        } else if (this.Anf != null) {
            i = this.Anf.vCD;
        }
        if (this.Ane == null || this.Anf == null) {
            return "invlaid TalkRoomMember which uuid is " + i;
        }
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        av avVar = this.Ane;
        if (avVar == null) {
            str = "null";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("VoiceGroupMem");
            stringBuilder.append(" uuid:").append(avVar.vCD);
            stringBuilder.append(" openClientId:").append(avVar.zPy);
            stringBuilder.append(" invite uuid: ").append(avVar.zPu);
            stringBuilder.append(" member id:").append(avVar.nEd);
            stringBuilder.append(" status: ").append(avVar.status);
            stringBuilder.append(" reason: ").append(avVar.aAk);
            str = stringBuilder.toString();
        }
        stringBuilder = stringBuilder2.append(str).append(" ");
        aw awVar = this.Anf;
        if (awVar == null) {
            str = "null";
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("VoiceGroupUsrProfile");
            stringBuilder3.append(" uuid: ").append(awVar.vCD);
            stringBuilder3.append(" user name: ").append(awVar.username);
            stringBuilder3.append(" head url: ").append(awVar.pDh);
            str = stringBuilder3.toString();
        }
        stringBuilder.append(str);
        return stringBuilder2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        return g.equals(cHJ(), ((d) obj).cHJ());
    }

    public final int hashCode() {
        String cHJ = cHJ();
        return cHJ == null ? 0 : cHJ.hashCode();
    }

    public final boolean cHL() {
        return g.equals(a.cCV(), cHJ());
    }
}
