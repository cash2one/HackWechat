package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.mm.protocal.d;

class b$a {
    public String fpb;
    public final String platform = (d.DEVICE_TYPE + "_" + d.vAz + "_" + Build.CPU_ABI);
    public String tag;
    public long timestamp;
    public String username;
    public boolean xbS;

    public b$a(String str, String str2, long j, String str3, boolean z) {
        this.username = str;
        this.tag = str2;
        this.timestamp = j;
        this.fpb = str3;
        this.xbS = false;
        this.xbS = z;
    }

    public final String toString() {
        return this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.fpb;
    }
}
