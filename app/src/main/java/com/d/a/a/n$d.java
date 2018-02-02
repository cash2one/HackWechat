package com.d.a.a;

class n$d {
    private String bjn;
    private long bjo;
    private String bjp;
    private long bjq;

    private n$d() {
    }

    final synchronized String a(String str, long j, boolean z) {
        String str2;
        if (z) {
            if (this.bjn != null && g(j, this.bjo)) {
                str = new StringBuilder(String.valueOf(str)).append(this.bjn).toString();
                this.bjn = null;
            }
            str2 = str;
            if (this.bjp != null && g(j, this.bjq)) {
                str2 = new StringBuilder(String.valueOf(str2)).append(this.bjp).toString();
                this.bjp = null;
            }
        } else {
            if (this.bjn != null && g(j, this.bjo)) {
                str = new StringBuilder(String.valueOf(str)).append(v.bx(this.bjn)).toString();
                this.bjn = null;
            }
            str2 = str;
            if (this.bjp != null && g(j, this.bjq)) {
                str2 = new StringBuilder(String.valueOf(str2)).append(v.bw(this.bjp)).toString();
                this.bjp = null;
            }
        }
        return str2;
    }

    final synchronized void d(String str, long j) {
        this.bjn = str;
        this.bjo = j;
    }

    final synchronized void e(String str, long j) {
        this.bjp = str;
        this.bjq = j;
    }

    final synchronized void reset() {
        this.bjn = null;
        this.bjp = null;
        this.bjo = 0;
        this.bjq = 0;
    }

    static boolean g(long j, long j2) {
        return Math.abs(j - j2) <= 10000;
    }
}
