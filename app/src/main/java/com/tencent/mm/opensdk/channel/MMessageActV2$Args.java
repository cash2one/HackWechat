package com.tencent.mm.opensdk.channel;

import android.os.Bundle;

public class MMessageActV2$Args {
    public static final int INVALID_FLAGS = -1;
    public Bundle bundle;
    public String content;
    public int flags = -1;
    public String targetClassName;
    public String targetPkgName;

    public String toString() {
        return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
    }
}
