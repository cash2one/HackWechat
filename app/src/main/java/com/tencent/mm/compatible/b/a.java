package com.tencent.mm.compatible.b;

import java.util.concurrent.locks.Lock;

public final class a {
    public int gBP = 0;
    public int gBQ = 0;
    public byte[] gBR = null;
    public int gBS = 0;
    public int gBT = 0;
    public boolean gBU = false;
    public Lock gBV = null;

    public final int xE() {
        if (this.gBU) {
            this.gBV.lock();
        }
        if (this.gBS == this.gBT) {
            return 0;
        }
        if (this.gBS < this.gBT) {
            this.gBQ = this.gBT - this.gBS;
        } else if (this.gBS > this.gBT) {
            this.gBQ = (this.gBT + this.gBP) - this.gBS;
        }
        if (this.gBU) {
            this.gBV.unlock();
        }
        return this.gBQ;
    }
}
