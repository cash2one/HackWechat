package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class i {
    public String filePath;
    public long fpG;
    public String fvC;
    public long hVF;
    public List<a> lfI = new ArrayList();
    public long size;
    public int type;
    public String userName;

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
