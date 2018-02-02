package c.t.m.g;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dm implements Cloneable {
    public long a;
    private int b;
    private int c;
    private String d;
    private int e;

    public final String toString() {
        return "Beacon [major=" + this.b + ",uuid=" + null + ", minor=" + this.c + ", bluetoothAddress=" + this.d + ", rssi=" + this.e + ", time=" + this.a + "]";
    }

    public static String a(List<dm> list) {
        if (list == null || list.size() == 0) {
            return "[]";
        }
        JSONArray jSONArray = new JSONArray();
        for (dm dmVar : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mac", dmVar.d);
                jSONObject.put("major", dmVar.b);
                jSONObject.put("minor", dmVar.c);
                jSONObject.put("rssi", dmVar.e);
                jSONObject.put("time", dmVar.a / 1000);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        return jSONArray.toString();
    }

    @SuppressLint({"NewApi"})
    public static dm a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bluetoothDevice == null) {
            return null;
        }
        Object obj = null;
        int i2 = 2;
        while (i2 <= 5) {
            if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                obj = 1;
                break;
            }
            i2++;
        }
        if (obj == null) {
            return null;
        }
        dm dmVar = new dm();
        dmVar.b = ((bArr[i2 + 20] & 255) << 8) + (bArr[i2 + 21] & 255);
        dmVar.c = ((bArr[i2 + 22] & 255) << 8) + (bArr[i2 + 23] & 255);
        dmVar.e = i;
        dmVar.d = bluetoothDevice.getAddress().toUpperCase();
        bluetoothDevice.getName();
        dmVar.a = System.currentTimeMillis();
        return dmVar;
    }

    protected final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
