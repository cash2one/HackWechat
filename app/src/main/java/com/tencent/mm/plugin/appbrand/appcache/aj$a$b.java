package com.tencent.mm.plugin.appbrand.appcache;

public enum aj$a$b {
    OK(0),
    FAILED(101),
    LOCAL_FILE_NOT_FOUND(102),
    PKG_INTEGRITY_FAILED(104),
    PKG_INVALID(105),
    SEVER_FILE_NOT_FOUND(106),
    DISK_FULL(110),
    ENV_ERR(200);
    
    public final int code;

    private aj$a$b(int i) {
        this.code = i;
    }
}
