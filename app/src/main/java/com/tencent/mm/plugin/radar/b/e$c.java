package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.protocal.c.bao;

public final class e$c {
    public final bao pxx;
    public final c$e pxy;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e$c) {
                e$c com_tencent_mm_plugin_radar_b_e_c = (e$c) obj;
                if (e.h(this.pxx, com_tencent_mm_plugin_radar_b_e_c.pxx)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        bao com_tencent_mm_protocal_c_bao = this.pxx;
        int hashCode = (com_tencent_mm_protocal_c_bao != null ? com_tencent_mm_protocal_c_bao.hashCode() : 0) * 31;
        c$e com_tencent_mm_plugin_radar_b_c_e = this.pxy;
        if (com_tencent_mm_plugin_radar_b_c_e != null) {
            i = com_tencent_mm_plugin_radar_b_c_e.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "LatestChangeStat(member=" + this.pxx + ", state=" + this.pxy + ")";
    }

    public e$c(bao com_tencent_mm_protocal_c_bao, c$e com_tencent_mm_plugin_radar_b_c_e) {
        e.i(com_tencent_mm_protocal_c_bao, "member");
        e.i(com_tencent_mm_plugin_radar_b_c_e, "state");
        this.pxx = com_tencent_mm_protocal_c_bao;
        this.pxy = com_tencent_mm_plugin_radar_b_c_e;
    }
}
