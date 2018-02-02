package com.tencent.mm.ipcinvoker.d;

import junit.framework.Assert;

public class d {
    public String fok;
    public com.tencent.mm.ipcinvoker.d gMV;
    private String process;

    public <T extends b> d(String str, Class<T> cls) {
        Assert.assertNotNull(str);
        Assert.assertNotNull(cls);
        this.process = str;
        this.fok = cls.getName();
        this.gMV = new com.tencent.mm.ipcinvoker.d(str);
    }
}
