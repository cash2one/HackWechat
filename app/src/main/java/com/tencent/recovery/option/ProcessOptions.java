package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions {
    public int gKi;
    private Express zRJ;

    public static final class Builder {
        private int gKi;
        public Express zRJ;

        public final Builder cDn() {
            this.gKi = 10000;
            return this;
        }

        public final ProcessOptions cDo() {
            ProcessOptions processOptions = new ProcessOptions();
            processOptions.gKi = this.gKi;
            processOptions.zRJ = this.zRJ;
            return processOptions;
        }
    }
}
