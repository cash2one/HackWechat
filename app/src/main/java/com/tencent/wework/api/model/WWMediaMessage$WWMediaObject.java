package com.tencent.wework.api.model;

import java.io.File;

public abstract class WWMediaMessage$WWMediaObject extends WWMediaMessage {
    protected static int getFileSize(String str) {
        if (!(str == null || str.length() == 0)) {
            File file = new File(str);
            if (file.exists()) {
                return (int) file.length();
            }
        }
        return 0;
    }
}
