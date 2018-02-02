package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public interface e {

    public static class b {
        public byte[] buffer;
        public int cmdId;
        public int fDt = -1;
        public long hyu;
        public int id;
        public int opa;
        public long opb;
        public String opc;
        public String opd;
        public com.tencent.mm.bq.a ope;

        public b(int i) {
            this.cmdId = i;
        }

        public int getCmdId() {
            return this.cmdId;
        }

        public final byte[] getBuffer() {
            if (this.buffer == null && this.ope != null) {
                try {
                    this.buffer = this.ope.toByteArray();
                } catch (IOException e) {
                    x.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + e.getMessage());
                }
            }
            return this.buffer;
        }
    }

    public static class a extends b {
        private int cmdId;

        public a(int i, com.tencent.mm.bq.a aVar) {
            super(i);
            this.cmdId = i;
            this.ope = aVar;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }
}
