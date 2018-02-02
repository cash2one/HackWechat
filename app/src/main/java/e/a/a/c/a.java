package e.a.a.c;

import com.tencent.mm.bq.b;
import java.io.OutputStream;
import java.util.LinkedList;

public final class a {
    public final byte[] AvE;
    private final e.a.a.b.b.a AvF;
    public final OutputStream hlF = null;

    public a(byte[] bArr) {
        this.AvE = bArr;
        this.AvF = new e.a.a.b.b.a(bArr, 0, bArr.length);
    }

    public final void al(int i, boolean z) {
        int i2 = 0;
        e.a.a.b.b.a aVar = this.AvF;
        aVar.aF(i, 0);
        if (z) {
            i2 = 1;
        }
        aVar.dW(i2);
    }

    public final void b(int i, b bVar) {
        e.a.a.b.b.a aVar = this.AvF;
        if (bVar != null) {
            aVar.aF(i, 2);
            byte[] toByteArray = bVar.toByteArray();
            aVar.dY(toByteArray.length);
            aVar.o(toByteArray);
        }
    }

    public final void b(int i, double d) {
        e.a.a.b.b.a aVar = this.AvF;
        aVar.aF(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        aVar.dW(((int) doubleToLongBits) & 255);
        aVar.dW(((int) (doubleToLongBits >> 8)) & 255);
        aVar.dW(((int) (doubleToLongBits >> 16)) & 255);
        aVar.dW(((int) (doubleToLongBits >> 24)) & 255);
        aVar.dW(((int) (doubleToLongBits >> 32)) & 255);
        aVar.dW(((int) (doubleToLongBits >> 40)) & 255);
        aVar.dW(((int) (doubleToLongBits >> 48)) & 255);
        aVar.dW(((int) (doubleToLongBits >> 56)) & 255);
    }

    public final void m(int i, float f) {
        e.a.a.b.b.a aVar = this.AvF;
        aVar.aF(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        aVar.dW(floatToIntBits & 255);
        aVar.dW((floatToIntBits >> 8) & 255);
        aVar.dW((floatToIntBits >> 16) & 255);
        aVar.dW((floatToIntBits >> 24) & 255);
    }

    public final void fU(int i, int i2) {
        e.a.a.b.b.a aVar = this.AvF;
        aVar.aF(i, 0);
        if (i2 >= 0) {
            aVar.dY(i2);
        } else {
            aVar.ad((long) i2);
        }
    }

    public final void fV(int i, int i2) {
        fU(i, i2);
    }

    public final void S(int i, long j) {
        e.a.a.b.b.a aVar = this.AvF;
        aVar.aF(i, 0);
        aVar.ad(j);
    }

    public final void g(int i, String str) {
        e.a.a.b.b.a aVar = this.AvF;
        if (str != null) {
            aVar.aF(i, 2);
            byte[] bytes = str.getBytes("UTF-8");
            aVar.dY(bytes.length);
            aVar.o(bytes);
        }
    }

    public final void fW(int i, int i2) {
        e.a.a.b.b.a aVar = this.AvF;
        aVar.aF(i, 2);
        aVar.dY(i2);
    }

    public final void d(int i, int i2, LinkedList<?> linkedList) {
        if (linkedList != null) {
            int i3;
            switch (i2) {
                case 1:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        g(i, (String) linkedList.get(i3));
                    }
                    return;
                case 2:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        fU(i, ((Integer) linkedList.get(i3)).intValue());
                    }
                    return;
                case 3:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        S(i, ((Long) linkedList.get(i3)).longValue());
                    }
                    return;
                case 4:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        b(i, ((Double) linkedList.get(i3)).doubleValue());
                    }
                    return;
                case 5:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        m(i, ((Float) linkedList.get(i3)).floatValue());
                    }
                    return;
                case 6:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        b(i, (b) linkedList.get(i3));
                    }
                    return;
                case 7:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        al(i, ((Boolean) linkedList.get(i3)).booleanValue());
                    }
                    return;
                case 8:
                    for (i3 = 0; i3 < linkedList.size(); i3++) {
                        com.tencent.mm.bq.a aVar = (com.tencent.mm.bq.a) linkedList.get(i3);
                        fW(i, aVar.bke());
                        aVar.a(this);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("The data type was not found, the id used was " + i2);
            }
        }
    }

    public final void c(int i, LinkedList<?> linkedList) {
        int i2 = 0;
        if (linkedList != null && linkedList.size() > 0) {
            int i3;
            this.AvF.aF(i, 2);
            e.a.a.b.b.a aVar = this.AvF;
            if (linkedList == null || linkedList.size() <= 0) {
                i3 = 0;
            } else {
                i3 = 0;
                int i4 = 0;
                while (i4 < linkedList.size()) {
                    int dZ = e.a.a.b.b.a.dZ(((Integer) linkedList.get(i4)).intValue()) + i3;
                    i4++;
                    i3 = dZ;
                }
            }
            aVar.dY(i3);
            while (i2 < linkedList.size()) {
                this.AvF.dY(((Integer) linkedList.get(i2)).intValue());
                i2++;
            }
        }
    }
}
