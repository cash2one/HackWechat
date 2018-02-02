package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a implements Serializable {
    public String Ait;
    public String Aiu;
    public boolean fsH;
    public long jHU;
    public Throwable zRu;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        stringBuffer.append("isSuccess:" + this.fsH + "\n");
        stringBuffer.append("rawPatchFilePath:" + this.Ait + "\n");
        stringBuffer.append("costTime:" + this.jHU + "\n");
        if (this.Aiu != null) {
            stringBuffer.append("patchVersion:" + this.Aiu + "\n");
        }
        if (this.zRu != null) {
            stringBuffer.append("Throwable:" + this.zRu.getMessage() + "\n");
        }
        return stringBuffer.toString();
    }
}
