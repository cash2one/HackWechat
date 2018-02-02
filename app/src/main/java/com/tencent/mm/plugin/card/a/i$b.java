package com.tencent.mm.plugin.card.a;

import java.util.Arrays;

class i$b {
    String ffq;
    int ftq;
    byte[] kJr;
    String name;

    public i$b(String str, int i, String str2, byte[] bArr) {
        this.ffq = str;
        this.ftq = i;
        this.name = str2;
        this.kJr = bArr;
    }

    public final String toString() {
        return "DeviceInfo{deviceId='" + this.ffq + '\'' + ", rssi=" + this.ftq + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.kJr) + '}';
    }
}
