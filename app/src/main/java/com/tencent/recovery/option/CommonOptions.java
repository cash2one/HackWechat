package com.tencent.recovery.option;

public class CommonOptions {
    public String clientVersion;
    public String ned;
    public String zRD;
    public String zRE;
    private boolean zRF;
    public long zRG;
    public long zRH;
    public String zRz;

    public static final class Builder {
        public String clientVersion;
        public String ned;
        public String zRD;
        public String zRE;
        public boolean zRF;
        public long zRG;
        public long zRH;
        public String zRz;

        public final CommonOptions cDm() {
            CommonOptions commonOptions = new CommonOptions();
            commonOptions.zRD = this.zRD;
            commonOptions.zRE = this.zRE;
            commonOptions.clientVersion = this.clientVersion;
            commonOptions.zRz = this.zRz;
            commonOptions.ned = this.ned;
            commonOptions.zRF = this.zRF;
            commonOptions.zRG = this.zRG;
            commonOptions.zRH = this.zRH;
            return commonOptions;
        }
    }

    private CommonOptions() {
    }
}
