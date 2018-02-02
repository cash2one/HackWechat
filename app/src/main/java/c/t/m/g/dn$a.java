package c.t.m.g;

public enum dn$a {
    NONE,
    GSM,
    CDMA,
    WCDMA,
    LTE;

    static {
        NONE = new dn$a("NONE", 0);
        GSM = new dn$a("GSM", 1);
        CDMA = new dn$a("CDMA", 2);
        WCDMA = new dn$a("WCDMA", 3);
        LTE = new dn$a("LTE", 4);
        dn$a[] c_t_m_g_dn_aArr = new dn$a[]{NONE, GSM, CDMA, WCDMA, LTE};
    }
}
