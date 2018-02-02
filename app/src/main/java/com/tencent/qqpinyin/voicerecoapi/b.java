package com.tencent.qqpinyin.voicerecoapi;

import org.xwalk.core.XWalkUpdater;

public final class b extends Exception {
    private String jey = "";
    private int mErrorCode;

    public b(int i) {
        String str;
        this.mErrorCode = i;
        switch (i) {
            case -104:
                str = "null param or 0 length";
                break;
            case -103:
                str = "already init";
                break;
            case -102:
                str = "should init at first";
                break;
            case XWalkUpdater.ERROR_SET_VERNUM /*-101*/:
                str = "speex engine error";
                break;
            case -100:
                str = "out of memory";
                break;
            default:
                str = "unknown error";
                break;
        }
        this.jey = str;
        new StringBuilder("errorCode: ").append(this.mErrorCode).append("\t msg: ").append(this.jey);
    }
}
