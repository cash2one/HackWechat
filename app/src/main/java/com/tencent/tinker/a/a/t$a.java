package com.tencent.tinker.a.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class t$a implements Comparable<t$a> {
    public final short AfL;
    public boolean AfM;
    public int AfN = 0;
    public int dzw = -1;
    public int size = 0;

    public final /* synthetic */ int compareTo(Object obj) {
        t$a com_tencent_tinker_a_a_t_a = (t$a) obj;
        if (this.dzw != com_tencent_tinker_a_a_t_a.dzw) {
            return this.dzw < com_tencent_tinker_a_a_t_a.dzw ? -1 : 1;
        } else {
            int Ig = Ig(this.AfL);
            int Ig2 = Ig(com_tencent_tinker_a_a_t_a.AfL);
            if (Ig != Ig2) {
                return Ig >= Ig2 ? 1 : -1;
            } else {
                return 0;
            }
        }
    }

    public t$a(int i, boolean z) {
        this.AfL = (short) i;
        this.AfM = z;
        if (i == 0) {
            this.dzw = 0;
            this.size = 1;
            this.AfN = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        } else if (i == Downloads.RECV_BUFFER_SIZE) {
            this.size = 1;
        }
    }

    public final boolean exists() {
        return this.size > 0;
    }

    private static int Ig(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                return 17;
            case 4097:
                return 8;
            case 4098:
                return 11;
            case 4099:
                return 10;
            case 8192:
                return 15;
            case 8193:
                return 14;
            case 8194:
                return 7;
            case 8195:
                return 13;
            case 8196:
                return 9;
            case 8197:
                return 16;
            case 8198:
                return 12;
            default:
                throw new IllegalArgumentException("unknown section type: " + i);
        }
    }

    public final String toString() {
        return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.AfL), Integer.valueOf(this.dzw), Integer.valueOf(this.size)});
    }
}
