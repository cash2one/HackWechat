package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;

public final class c {
    private final int jGb;
    private volatile RandomAccessFile jGc;
    private volatile RandomAccessFile jGd;
    private long jGe;
    private long jGf;
    private long jGg;

    public c(int i) {
        this.jGb = i;
    }

    public final double aju() {
        double max;
        Object e;
        try {
            if (this.jGd == null) {
                this.jGd = new RandomAccessFile("/proc/" + this.jGb + "/stat", "r");
            }
            this.jGd.seek(0);
            String readLine = this.jGd.readLine();
            if (bh.ov(readLine)) {
                return 0.0d;
            }
            String[] split = readLine.split(" ");
            if (split.length < 17) {
                return 0.0d;
            }
            long j;
            long parseLong;
            if (this.jGc == null) {
                this.jGc = new RandomAccessFile("/proc/stat", "r");
            }
            this.jGc.seek(0);
            readLine = this.jGc.readLine();
            if (bh.ov(readLine)) {
                j = 0;
            } else {
                String[] split2 = readLine.split(" ");
                if (split2.length < 9) {
                    j = 0;
                } else {
                    j = Long.parseLong(split2[2]);
                    parseLong = Long.parseLong(split2[3]);
                    long parseLong2 = Long.parseLong(split2[4]);
                    long parseLong3 = Long.parseLong(split2[5]);
                    long parseLong4 = Long.parseLong(split2[6]);
                    long parseLong5 = Long.parseLong(split2[7]);
                    j = Long.parseLong(split2[9]) + ((((((j + parseLong) + parseLong2) + parseLong3) + parseLong4) + parseLong5) + Long.parseLong(split2[8]));
                }
            }
            parseLong = Long.parseLong(split[13]);
            long parseLong6 = Long.parseLong(split[14]);
            if (this.jGe != 0) {
                max = Math.max(0.0d, ((double) ((parseLong - this.jGf) * 100)) / ((double) (j - this.jGe))) + Math.max(0.0d, ((double) ((parseLong6 - this.jGg) * 100)) / ((double) (j - this.jGe)));
            } else {
                max = 0.0d;
            }
            try {
                this.jGe = j;
                this.jGf = parseLong;
                this.jGg = parseLong6;
                return max;
            } catch (Exception e2) {
                e = e2;
                x.e(" MicroMsg.CpuSampler", "read pid stat file error: " + e);
                return max;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            max = 0.0d;
            Exception exception2 = exception;
            x.e(" MicroMsg.CpuSampler", "read pid stat file error: " + e);
            return max;
        }
    }
}
