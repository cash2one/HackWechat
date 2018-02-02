package com.tencent.mm.bq;

import e.a.a.a.a.b;

public class a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    public static b unknownTagHandler = new e.a.a.a.a.a();

    public byte[] toByteArray() {
        bkf();
        byte[] bArr = new byte[bke()];
        e.a.a.c.a aVar = new e.a.a.c.a(bArr);
        a(aVar);
        if (aVar.hlF != null) {
            aVar.hlF.write(aVar.AvE);
            aVar.hlF.flush();
        }
        return bArr;
    }

    public static int a(e.a.a.a.a aVar) {
        int i = 0;
        e.a.a.b.a.a aVar2 = aVar.Avy;
        if (aVar2.bfJ != aVar2.bufferSize || aVar2.of(false)) {
            aVar2.bfK = aVar2.ry();
            if (aVar2.bfK == 0) {
                throw e.a.a.b.a.b.cJI();
            }
            i = aVar2.bfK;
        } else {
            aVar2.bfK = 0;
        }
        aVar.Avz = i;
        return e.a.a.b.a.eb(aVar.Avz);
    }

    public a bkf() {
        return this;
    }

    public int a(int i, Object... objArr) {
        throw new Error("Cannot use this method");
    }

    public void a(e.a.a.c.a aVar) {
        a(0, aVar);
    }

    public int bke() {
        int i = 0;
        try {
            i = a(1, new Object[0]);
        } catch (Exception e) {
        }
        return i;
    }

    public a aF(byte[] bArr) {
        a(2, bArr);
        return this;
    }

    public boolean a(e.a.a.a.a aVar, a aVar2, int i) {
        return a(3, aVar, aVar2, Integer.valueOf(i)) == 0;
    }
}
