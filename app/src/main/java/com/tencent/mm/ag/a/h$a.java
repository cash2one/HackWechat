package com.tencent.mm.ag.a;

public class h$a {
    private String fBK;
    private String id;

    public h$a(String str, String str2) {
        this.fBK = str;
        this.id = str2;
    }

    public boolean equals(Object obj) {
        if (obj.getClass() != h$a.class) {
            return false;
        }
        h$a com_tencent_mm_ag_a_h_a = (h$a) obj;
        if ((this.fBK != null || com_tencent_mm_ag_a_h_a.fBK != null) && (this.fBK == null || !this.fBK.equals(com_tencent_mm_ag_a_h_a.fBK))) {
            return false;
        }
        if ((this.id != null || com_tencent_mm_ag_a_h_a.id != null) && (this.id == null || !this.id.equals(com_tencent_mm_ag_a_h_a.id))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.fBK.hashCode() + this.id.hashCode();
    }
}
