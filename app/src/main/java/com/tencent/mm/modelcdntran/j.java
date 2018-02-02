package com.tencent.mm.modelcdntran;

public final class j extends i {
    public int concurrentCount = 1;
    public long fFo = 0;
    public String fek = "";
    public String filename;
    public String fzO;
    public int fzQ;
    public String fzW = "";
    public String host;
    public long htG;
    public String htH;
    public int htI;
    public int htJ;
    public String htK;
    public int htL;
    public int htM = 0;
    public long htN = 0;
    public int htO = 0;
    public long htP = 0;
    public a htQ;
    public String[] hto;
    public boolean isColdSnsData = false;
    public String referer;
    public String signalQuality = "";
    public String snsScene = "";
    public String url;

    public final boolean MO() {
        return this.htE == 3;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("isPlayMode: ").append(this.htJ);
        stringBuffer.append(" videoFormat: ").append(this.field_requestVideoFormat);
        stringBuffer.append(" initialDownloadLength : ").append(this.initialDownloadLength);
        stringBuffer.append(" initialDownloadOffset : ").append(this.initialDownloadOffset);
        stringBuffer.append(" videoXmlTotalLen : ").append(this.htI);
        stringBuffer.append(" videoTaskType : ").append(this.htE);
        stringBuffer.append(" filename : ").append(this.filename);
        if (MM()) {
            stringBuffer.append(" url : ").append(this.url);
            stringBuffer.append(" host : ").append(this.host);
            stringBuffer.append(" referer : ").append(this.referer);
            stringBuffer.append(" ip size : ").append(this.hto != null ? this.hto.length : 0);
            stringBuffer.append(" isColdSnsData : ").append(this.isColdSnsData);
            stringBuffer.append(" signalQuality : ").append(this.signalQuality);
            stringBuffer.append(" snsScene : ").append(this.snsScene);
            stringBuffer.append(" snsId : ").append(this.fzW);
        } else {
            stringBuffer.append(" field_mediaId : ").append(this.field_mediaId);
        }
        stringBuffer.append(" fileid : ").append(this.field_fileId);
        stringBuffer.append(" fileaeskey: ").append(this.field_aesKey);
        stringBuffer.append(" field_preloadRatio:").append(this.field_preloadRatio);
        stringBuffer.append(" newmd5: ").append(this.fek);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
