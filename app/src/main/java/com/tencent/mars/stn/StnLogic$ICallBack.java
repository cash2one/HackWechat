package com.tencent.mars.stn;

import java.io.ByteArrayOutputStream;

public interface StnLogic$ICallBack {
    public static final int BaseNetDetectEnd = 2;
    public static final int DetectConnectFail = 1;
    public static final int DetectConnectOK = 0;
    public static final int DetectEnd = 4;
    public static final int DetectLongLinkEnd = 0;
    public static final int DetectNotStart = 3;
    public static final int DetectShortLinkEnd = 1;
    public static final int DetectTimeout = 2;

    int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2);

    int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr);

    boolean isLogoned();

    boolean makesureAuthed();

    void networkAnalysisCallBack(int i, int i2, boolean z, String str);

    boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2);

    String[] onNewDns(String str);

    void onPush(int i, byte[] bArr);

    int onTaskEnd(int i, Object obj, int i2, int i3);

    void reportConnectInfo(int i, int i2);

    boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2);

    void requestDoSync();

    String[] requestNetCheckShortLinkHosts();
}
