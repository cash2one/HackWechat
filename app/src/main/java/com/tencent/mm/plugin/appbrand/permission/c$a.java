package com.tencent.mm.plugin.appbrand.permission;

public final class c$a {
    private static final c$a jGK = new c$a(2, "fail:auth canceled");
    private static final c$a jGL = new c$a(2, "fail:auth denied");
    private static final c$a jGM = new c$a(3, "");
    private static final c$a jGN = new c$a(2, "fail:access denied");
    private static final c$a jGO = new c$a(1, "");
    public final int code;
    public final String fpb;

    c$a(int i, String str) {
        this.code = i;
        this.fpb = str;
    }
}
