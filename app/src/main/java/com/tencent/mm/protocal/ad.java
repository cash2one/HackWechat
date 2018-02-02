package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.protocal.c.bmy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class ad {
    public static byte[] g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0) {
            x.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            x.e("MicroMsg.SyncKeyUtil", "newKey is null");
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    return pByteArray.value;
                }
                x.e("MicroMsg.SyncKeyUtil", "merge key failed");
                return null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Crash", e, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e));
            }
        }
    }

    private static Map<Integer, Long> bh(byte[] bArr) {
        if (bh.bw(bArr)) {
            return null;
        }
        try {
            bmy com_tencent_mm_protocal_c_bmy = (bmy) new bmy().aF(bArr);
            if (com_tencent_mm_protocal_c_bmy == null) {
                return null;
            }
            x.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + com_tencent_mm_protocal_c_bmy.wLX);
            LinkedList linkedList = com_tencent_mm_protocal_c_bmy.wLY;
            if (linkedList.size() != com_tencent_mm_protocal_c_bmy.wLX) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            for (int i = 0; i < com_tencent_mm_protocal_c_bmy.wLX; i++) {
                hashMap.put(Integer.valueOf(((ans) linkedList.get(i)).pQj), Long.valueOf(4294967295L & ((long) ((ans) linkedList.get(i)).wuF)));
            }
            if (hashMap.size() != com_tencent_mm_protocal_c_bmy.wLX) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    public static String bi(byte[] bArr) {
        if (bh.bw(bArr)) {
            return "";
        }
        Map bh = bh(bArr);
        if (bh == null || bh.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" MsgKey:" + bh.get(Integer.valueOf(2)));
        stringBuffer.append(" profile:" + bh.get(Integer.valueOf(1)));
        stringBuffer.append(" contact:" + bh.get(Integer.valueOf(3)));
        stringBuffer.append(" chatroom:" + bh.get(Integer.valueOf(11)));
        stringBuffer.append(" Bottle:" + bh.get(Integer.valueOf(7)));
        stringBuffer.append(" QContact:" + bh.get(Integer.valueOf(5)));
        return stringBuffer.toString();
    }

    public static boolean h(byte[] bArr, byte[] bArr2) {
        Map bh = bh(bArr);
        if (bh == null) {
            x.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            return true;
        }
        Map bh2 = bh(bArr2);
        if (bh2 == null) {
            x.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            return false;
        }
        for (Integer num : bh2.keySet()) {
            Long l = (Long) bh.get(num);
            Long l2 = (Long) bh2.get(num);
            if (l == null) {
                x.d("MicroMsg.SyncKeyUtil", "dkpush local key null :" + num);
                return true;
            }
            x.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                return true;
            }
        }
        x.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        return false;
    }
}
