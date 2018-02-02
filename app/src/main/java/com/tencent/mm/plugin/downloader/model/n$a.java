package com.tencent.mm.plugin.downloader.model;

import java.util.Arrays;
import java.util.Properties;

class n$a {
    Properties lsT;
    byte[] lsU;

    private n$a() {
        this.lsT = new Properties();
    }

    public final String toString() {
        return "ApkExternalInfo [p=" + this.lsT + ", otherData=" + Arrays.toString(this.lsU) + "]";
    }
}
