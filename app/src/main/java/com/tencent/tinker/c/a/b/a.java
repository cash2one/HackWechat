package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a {
    public static final byte[] kiV = new byte[]{(byte) 68, (byte) 88, (byte) 68, (byte) 73, (byte) 70, (byte) 70};
    public int AhA;
    public int AhB;
    public int AhC;
    public byte[] AhD;
    public final com.tencent.tinker.a.a.a.a Ahi;
    private short Ahj;
    public int Ahk;
    private int Ahl;
    public int Ahm;
    public int Ahn;
    public int Aho;
    public int Ahp;
    public int Ahq;
    public int Ahr;
    public int Ahs;
    public int Aht;
    public int Ahu;
    public int Ahv;
    public int Ahw;
    public int Ahx;
    public int Ahy;
    public int Ahz;

    public a(InputStream inputStream) {
        this.Ahi = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.i(inputStream)));
        byte[] Ii = this.Ahi.Ii(kiV.length);
        if (c.m(Ii, kiV) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(Ii));
        }
        this.Ahj = this.Ahi.aif.getShort();
        if (c.a(this.Ahj, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + this.Ahj + ", expected: 2");
        }
        this.Ahk = this.Ahi.aif.getInt();
        this.Ahl = this.Ahi.aif.getInt();
        this.Ahm = this.Ahi.aif.getInt();
        this.Ahn = this.Ahi.aif.getInt();
        this.Aho = this.Ahi.aif.getInt();
        this.Ahp = this.Ahi.aif.getInt();
        this.Ahq = this.Ahi.aif.getInt();
        this.Ahr = this.Ahi.aif.getInt();
        this.Ahs = this.Ahi.aif.getInt();
        this.Aht = this.Ahi.aif.getInt();
        this.Ahu = this.Ahi.aif.getInt();
        this.Ahv = this.Ahi.aif.getInt();
        this.Ahw = this.Ahi.aif.getInt();
        this.Ahx = this.Ahi.aif.getInt();
        this.Ahy = this.Ahi.aif.getInt();
        this.Ahz = this.Ahi.aif.getInt();
        this.AhA = this.Ahi.aif.getInt();
        this.AhB = this.Ahi.aif.getInt();
        this.AhC = this.Ahi.aif.getInt();
        this.AhD = this.Ahi.Ii(20);
        com.tencent.tinker.a.a.a.a aVar = this.Ahi;
        aVar.aif.position(this.Ahl);
    }
}
