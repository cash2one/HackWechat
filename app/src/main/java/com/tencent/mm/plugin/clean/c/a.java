package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;

public final class a {
    public String filePath;
    public long fpG;
    public String fvC;
    public long hVF;
    public long size;
    public int type;
    private String userName;

    public a(String str, String str2, int i, String str3, long j, long j2) {
        this.size = (long) e.bN(str2);
        x.v("MicroMsg.AnalyseItem", "add mst %d %d %s %s %d", new Object[]{Long.valueOf(this.size), Integer.valueOf(i), bh.fK(this.size), str3, Long.valueOf(j)});
        this.fvC = str;
        this.type = i;
        this.filePath = str2;
        this.userName = str3;
        this.fpG = j;
        this.hVF = j2;
    }

    public final String toString() {
        switch (this.type) {
            case 1:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", bh.fK(this.size), this.filePath});
            case 2:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", bh.fK(this.size), this.filePath});
            case 3:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VIDEO", bh.fK(this.size), this.filePath});
            case 4:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", bh.fK(this.size), this.filePath});
            default:
                return "";
        }
    }

    public final long axZ() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.hVF);
        return (long) (instance.get(2) + (instance.get(1) * 100));
    }
}
