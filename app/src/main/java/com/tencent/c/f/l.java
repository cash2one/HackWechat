package com.tencent.c.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class l {
    static HashMap<String, byte[]> zUU = null;
    protected String zUQ;
    protected RequestPacket zUR;
    protected HashMap<String, byte[]> zUS;
    private HashMap<String, Object> zUT;

    public l() {
        this.zUQ = "UTF-8";
        this.zUR = new RequestPacket();
        this.zUS = new HashMap();
        this.zUT = new HashMap();
        this.zUR.iVersion = (short) 3;
    }

    public final void aaY(String str) {
        this.zUQ = str;
    }

    public final void aaZ(String str) {
        this.zUR.sServantName = str;
    }

    public final void aba(String str) {
        this.zUR.sFuncName = str;
    }

    public final void cDM() {
        this.zUR.iRequestId = 3;
    }

    public final <T> void put(String str, T t) {
        if (str.startsWith(".") || t == null || (t instanceof Set)) {
            throw new IllegalArgumentException("wup put err");
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(this.zUQ);
        jceOutputStream.write(t, 0);
        this.zUS.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
    }

    public final byte[] tq() {
        if (this.zUR.sServantName == null) {
            this.zUR.sServantName = "";
        }
        if (this.zUR.sFuncName == null) {
            this.zUR.sFuncName = "";
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.zUQ);
        jceOutputStream.write(this.zUS, 0);
        this.zUR.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.zUQ);
        this.zUR.writeTo(jceOutputStream);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        int length = jceBufArray.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(jceBufArray).flip();
        return allocate.array();
    }
}
