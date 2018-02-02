package com.tencent.mm.plugin.n;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;

public final class a {
    public int nBA;
    public int nBB;
    public int nBC;
    public int nBD;
    public int nBE;
    public String nBx;
    public String nBy;
    public int nBz;

    public static String bQ(String str) {
        byte[] d = FileOp.d(str, 0, 6);
        if (d == null || d.length != 6) {
            return "";
        }
        String str2 = "";
        try {
            return new String(d, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:" + e);
            return str2;
        }
    }

    public static String Cy(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return str.replace(",", ";");
    }
}
