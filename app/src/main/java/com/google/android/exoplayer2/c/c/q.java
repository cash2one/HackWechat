package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.tencent.wcdb.FileUtils;

public final class q implements u {
    private int amN;
    private final p aoH;
    private final j aoI = new j(32);
    private int aoJ;
    private boolean aoK;
    private boolean aoL;

    public q(p pVar) {
        this.aoH = pVar;
    }

    public final void a(com.google.android.exoplayer2.i.q qVar, f fVar, u$d com_google_android_exoplayer2_c_c_u_d) {
        this.aoH.a(qVar, fVar, com_google_android_exoplayer2_c_c_u_d);
        this.aoL = true;
    }

    public final void jx() {
        this.aoL = true;
    }

    public final void a(j jVar, boolean z) {
        int readUnsignedByte;
        if (z) {
            readUnsignedByte = jVar.readUnsignedByte() + jVar.position;
        } else {
            readUnsignedByte = -1;
        }
        if (this.aoL) {
            if (z) {
                this.aoL = false;
                jVar.cR(readUnsignedByte);
                this.amN = 0;
            } else {
                return;
            }
        }
        while (jVar.lF() > 0) {
            if (this.amN < 3) {
                if (this.amN == 0) {
                    readUnsignedByte = jVar.readUnsignedByte();
                    jVar.cR(jVar.position - 1);
                    if (readUnsignedByte == 255) {
                        this.aoL = true;
                        return;
                    }
                }
                readUnsignedByte = Math.min(jVar.lF(), 3 - this.amN);
                jVar.readBytes(this.aoI.data, this.amN, readUnsignedByte);
                this.amN = readUnsignedByte + this.amN;
                if (this.amN == 3) {
                    this.aoI.reset(3);
                    this.aoI.cV(1);
                    int readUnsignedByte2 = this.aoI.readUnsignedByte();
                    int readUnsignedByte3 = this.aoI.readUnsignedByte();
                    this.aoK = (readUnsignedByte2 & FileUtils.S_IWUSR) != 0;
                    this.aoJ = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                    if (this.aoI.capacity() < this.aoJ) {
                        Object obj = this.aoI.data;
                        this.aoI.reset(Math.min(4098, Math.max(this.aoJ, obj.length * 2)));
                        System.arraycopy(obj, 0, this.aoI.data, 0, 3);
                    }
                }
            } else {
                readUnsignedByte = Math.min(jVar.lF(), this.aoJ - this.amN);
                jVar.readBytes(this.aoI.data, this.amN, readUnsignedByte);
                this.amN = readUnsignedByte + this.amN;
                if (this.amN != this.aoJ) {
                    continue;
                } else {
                    if (!this.aoK) {
                        this.aoI.reset(this.aoJ);
                    } else if (t.l(this.aoI.data, this.aoJ, -1) != 0) {
                        this.aoL = true;
                        return;
                    } else {
                        this.aoI.reset(this.aoJ - 4);
                    }
                    this.aoH.b(this.aoI);
                    this.amN = 0;
                }
            }
        }
    }
}
