package com.tencent.mm.plugin.wenote.model.a;

import java.io.Serializable;

public final class p implements Serializable {
    public boolean tRS = false;
    public long tRT = -1;
    public long tRU = -1;
    public boolean tRV = false;
    public String tRW = "";
    public String tRX = "";
    public int tRY = 0;
    public int tRZ = 0;

    public final String bVU() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("topIsOpenFromSession=").append(this.tRS).append(" topLocalId=").append(this.tRT).append(" topMsgId=").append(this.tRU).append(" topTitle=").append(this.tRW).append(" topNoteXml=").append(this.tRX).append(" topLastPosition=").append(this.tRY).append(" topLastOffset=").append(this.tRZ);
        return stringBuilder.toString();
    }
}
