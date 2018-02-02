package com.tencent.mm.plugin.backup.a;

public class f$b implements Cloneable, Comparable<f$b> {
    public String kiP;
    public long kiQ = 0;
    public long kiR = 0;
    public long kiS = -1;
    public long kiT = -1;

    public final /* synthetic */ Object clone() {
        return aou();
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        f$b com_tencent_mm_plugin_backup_a_f_b = (f$b) obj;
        if (this.kiS < com_tencent_mm_plugin_backup_a_f_b.kiS) {
            return 1;
        }
        return this.kiS > com_tencent_mm_plugin_backup_a_f_b.kiS ? -1 : 0;
    }

    public final f$b aou() {
        f$b com_tencent_mm_plugin_backup_a_f_b = new f$b();
        com_tencent_mm_plugin_backup_a_f_b.kiP = this.kiP;
        com_tencent_mm_plugin_backup_a_f_b.kiQ = this.kiQ;
        com_tencent_mm_plugin_backup_a_f_b.kiR = this.kiR;
        com_tencent_mm_plugin_backup_a_f_b.kiS = this.kiS;
        com_tencent_mm_plugin_backup_a_f_b.kiT = this.kiT;
        return com_tencent_mm_plugin_backup_a_f_b;
    }
}
