package com.tencent.mm.modelstat;

import android.database.Cursor;

public final class k {
    private static final String hSf;
    int fDt = -2;
    public int hRC = 0;
    public int hRD = 0;
    public int hRE = 0;
    public int hRF = 0;
    public int hRG = 0;
    public int hRH = 0;
    public int hRI = 0;
    public int hRJ = 0;
    public int hRK = 0;
    public int hRL = 0;
    public int hRM = 0;
    public int hRN = 0;
    public int hRO = 0;
    public int hRP = 0;
    public int hRQ = 0;
    public int hRR = 0;
    public int hRS = 0;
    public int hRT = 0;
    public int hRU = 0;
    public int hRV = 0;
    public int hRW = 0;
    public int hRX = 0;
    public int hRY = 0;
    public int hRZ = 0;
    public int hSa = 0;
    public int hSb = 0;
    public int hSc = 0;
    public int hSd = 0;
    public int hSe = 0;
    public int id = 0;

    public final void b(Cursor cursor) {
        this.id = cursor.getInt(0);
        this.hRC = cursor.getInt(1);
        this.hRD = cursor.getInt(2);
        this.hRE = cursor.getInt(3);
        this.hRF = cursor.getInt(4);
        this.hRG = cursor.getInt(5);
        this.hRH = cursor.getInt(6);
        this.hRI = cursor.getInt(7);
        this.hRJ = cursor.getInt(8);
        this.hRK = cursor.getInt(9);
        this.hRL = cursor.getInt(10);
        this.hRM = cursor.getInt(11);
        this.hRN = cursor.getInt(12);
        this.hRO = cursor.getInt(13);
        this.hRP = cursor.getInt(14);
        this.hRQ = cursor.getInt(15);
        this.hRR = cursor.getInt(16);
        this.hRS = cursor.getInt(17);
        this.hRT = cursor.getInt(18);
        this.hRU = cursor.getInt(19);
        this.hRV = cursor.getInt(20);
        this.hRW = cursor.getInt(21);
        this.hRX = cursor.getInt(22);
        this.hRY = cursor.getInt(23);
        this.hRZ = cursor.getInt(24);
        this.hSa = cursor.getInt(25);
        this.hSb = cursor.getInt(26);
        this.hSc = cursor.getInt(27);
        this.hSd = cursor.getInt(28);
        this.hSe = cursor.getInt(29);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetStatInfo:");
        stringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
        hSf = stringBuilder.toString();
    }

    public final String toString() {
        return String.format(hSf, new Object[]{Integer.valueOf(this.hRL), Integer.valueOf(this.hSb), Integer.valueOf(this.hRN), Integer.valueOf(this.hRX), Integer.valueOf(this.hSd), Integer.valueOf(this.hRZ), Integer.valueOf(this.hRM), Integer.valueOf(this.hSc), Integer.valueOf(this.hRO), Integer.valueOf(this.hRY), Integer.valueOf(this.hSe), Integer.valueOf(this.hSa), Integer.valueOf(this.hRD), Integer.valueOf(this.hRE), Integer.valueOf(this.hRP), Integer.valueOf(this.hRQ), Integer.valueOf(this.hRF), Integer.valueOf(this.hRG), Integer.valueOf(this.hRR), Integer.valueOf(this.hRS), Integer.valueOf(this.hRH), Integer.valueOf(this.hRI), Integer.valueOf(this.hRT), Integer.valueOf(this.hRU), Integer.valueOf(this.hRJ), Integer.valueOf(this.hRK), Integer.valueOf(this.hRV), Integer.valueOf(this.hRW)});
    }
}
