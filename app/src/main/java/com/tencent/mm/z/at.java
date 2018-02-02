package com.tencent.mm.z;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;

public final class at {
    public static SharedPreferences Hn() {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("auth_info_key_prefs", 4);
        if (!sharedPreferences.getBoolean("key_auth_info_prefs_created", false)) {
            d.pPH.a(148, 12, 1, true);
            s sVar = new s(w.gZK + "autoauth.cfg");
            boolean commit;
            if (sVar.xmA || sVar.get(3) == null) {
                SharedPreferences sharedPreferences2 = ac.getContext().getSharedPreferences("auto_auth_key_prefs", 4);
                Editor edit = sharedPreferences.edit();
                if (bh.ov(sharedPreferences2.getString("_auth_key", ""))) {
                    x.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", bh.cgy());
                } else {
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", sharedPreferences2.getInt("key_auth_update_version", 0));
                    edit.putInt("_auth_uin", sharedPreferences2.getInt("_auth_uin", 0));
                    edit.putString("_auth_key", sharedPreferences2.getString("_auth_key", ""));
                    edit.putString("server_id", ac.getContext().getSharedPreferences("server_id_prefs", 4).getString("server_id", ""));
                    commit = edit.commit();
                    x.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                }
            } else {
                Editor edit2 = sharedPreferences.edit();
                edit2.putBoolean("key_auth_info_prefs_created", true);
                edit2.putInt("key_auth_update_version", ((Integer) sVar.get(1)).intValue());
                edit2.putInt("_auth_uin", ((Integer) sVar.get(2)).intValue());
                edit2.putString("_auth_key", (String) sVar.get(3));
                edit2.putString("server_id", (String) sVar.get(4));
                commit = edit2.commit();
                x.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", ""), sharedPreferences.getString("server_id", ""));
                d.pPH.a(148, 51, 1, true);
                return sharedPreferences;
            }
        }
        return sharedPreferences;
    }
}
