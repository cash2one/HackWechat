package e.a.a.a;

import e.a.a.a.a.b;
import java.util.LinkedList;

public final class a {
    public final e.a.a.b.a.a Avy;
    public int Avz = 0;
    private final b unknownTagHandler;

    public a(byte[] bArr, b bVar) {
        this.Avy = new e.a.a.b.a.a(bArr, bArr.length);
        this.unknownTagHandler = bVar;
    }

    public final int cJz() {
        return this.Avy.ry();
    }

    public final LinkedList<Integer> cJA() {
        e.a.a.b.a.a aVar = this.Avy;
        LinkedList<Integer> linkedList = new LinkedList();
        while (aVar.bfJ < aVar.bufferSize) {
            linkedList.add(Integer.valueOf(aVar.ry()));
        }
        return linkedList;
    }

    public final String cJB() {
        return this.Avy.readString();
    }

    public final boolean cJC() {
        return this.Avy.ry() != 0;
    }

    public final com.tencent.mm.bq.b cJD() {
        e.a.a.b.a.a aVar = this.Avy;
        int ry = aVar.ry();
        if (ry >= aVar.bufferSize - aVar.bfJ || ry <= 0) {
            return com.tencent.mm.bq.b.bc(aVar.dT(ry));
        }
        com.tencent.mm.bq.b s = com.tencent.mm.bq.b.s(aVar.buffer, aVar.bfJ, ry);
        aVar.bfJ = ry + aVar.bfJ;
        return s;
    }

    public final void cJE() {
        int ea = e.a.a.b.a.ea(this.Avz);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(e.a.a.b.a.eb(this.Avz)).append(" - ");
        switch (ea) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.Avy.rz());
                return;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(this.Avy.readDouble()));
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.Avy.readString());
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(this.Avy.readFloat()));
                return;
            default:
                return;
        }
    }

    public final LinkedList<byte[]> Jl(int i) {
        return this.Avy.Jl(i);
    }
}
