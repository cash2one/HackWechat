package com.tencent.mm.modelmulti;

public class b$a {
    final String hEI;
    final int hEJ;
    final int hEK;
    final int hEL;
    final int hEM;

    public b$a(String str, int i, int i2, int i3, int i4) {
        this.hEI = str;
        this.hEJ = i;
        this.hEK = i2;
        this.hEL = i3;
        this.hEM = i4;
    }

    public final boolean equals(Object obj) {
        if (hashCode() == obj.hashCode()) {
            return true;
        }
        if (!(obj instanceof b$a)) {
            return false;
        }
        b$a com_tencent_mm_modelmulti_b_a = (b$a) obj;
        if (this.hEJ == com_tencent_mm_modelmulti_b_a.hEJ && this.hEK == com_tencent_mm_modelmulti_b_a.hEK && this.hEL == com_tencent_mm_modelmulti_b_a.hEL && this.hEM == com_tencent_mm_modelmulti_b_a.hEM && this.hEI.equals(com_tencent_mm_modelmulti_b_a.hEI)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "GetChatRoomMsgInfo chatroomId[" + this.hEI + "], filterSeq[" + this.hEJ + "], msgSeq[" + this.hEK + "], needCount[" + this.hEL + "], upDownFlag[" + this.hEM + "], hash[" + hashCode() + "]";
    }
}
