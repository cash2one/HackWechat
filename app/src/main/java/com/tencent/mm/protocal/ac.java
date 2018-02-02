package com.tencent.mm.protocal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ac {
    public String vBY;
    public String vBZ;
    public int ver;

    public static void F(String str, String str2, int i) {
        x.d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", Integer.valueOf(i), str, str2);
        Editor edit = com.tencent.mm.sdk.platformtools.ac.getContext().getSharedPreferences("rsa_public_key_prefs", 4).edit();
        edit.putString("keye", str);
        edit.putString("keyn", str2);
        edit.putInt("version", i);
        edit.putInt("client_version", d.vAz);
        edit.commit();
    }

    public static ac cdL() {
        SharedPreferences sharedPreferences = com.tencent.mm.sdk.platformtools.ac.getContext().getSharedPreferences("rsa_public_key_prefs", 4);
        ac acVar = new ac(sharedPreferences.getString("keye", ""), sharedPreferences.getString("keyn", ""), sharedPreferences.getInt("version", 0));
        int i = sharedPreferences.getInt("client_version", 0);
        if (!acVar.cdO()) {
            if (i > 637665843) {
                return acVar;
            }
            boolean commit = sharedPreferences.edit().clear().commit();
            d.pPH.a(148, 38, 1, false);
            x.i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", Integer.valueOf(i), Integer.valueOf(d.vAz), Boolean.valueOf(commit));
        }
        d.pPH.a(148, 39, 1, false);
        x.d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", "010001", "994B7DB5D0A2C31D8F68D63224EEC9EB5866B665B03656B357EACCA065257A9B8360E647F91E770B0B52B8015CEBF06CCEE57164021661F1DAF533284C12FAB4EB6D7B808F62E6AD3975BD138693ADCA93A147BC81843A9ED177D504A3D157CC8DD99ADA3DC2A348E498939507A70A6C20880B070D030CDEC304B3C3248F9D2D352B8932D865BFDAD64CF74F98A073043CB43A51A3F582AF36E2523FC56A8224DD2056EDF8790ABE32724F205A949A31E2FFD055823F9D249081482672EAC75BE0755E0EE9DF3FBCA3F50004CFC17B84590FA963DA07765B983EDC39673CCE269CACB6CBAFCA62C13FCBF1461F7C07E8FFA5B6E3EB4D54DEC6872AC8B26585EF".substring(0, 4) + "_" + "994B7DB5D0A2C31D8F68D63224EEC9EB5866B665B03656B357EACCA065257A9B8360E647F91E770B0B52B8015CEBF06CCEE57164021661F1DAF533284C12FAB4EB6D7B808F62E6AD3975BD138693ADCA93A147BC81843A9ED177D504A3D157CC8DD99ADA3DC2A348E498939507A70A6C20880B070D030CDEC304B3C3248F9D2D352B8932D865BFDAD64CF74F98A073043CB43A51A3F582AF36E2523FC56A8224DD2056EDF8790ABE32724F205A949A31E2FFD055823F9D249081482672EAC75BE0755E0EE9DF3FBCA3F50004CFC17B84590FA963DA07765B983EDC39673CCE269CACB6CBAFCA62C13FCBF1461F7C07E8FFA5B6E3EB4D54DEC6872AC8B26585EF".substring(507, 511), Integer.valueOf(170));
        return new ac("010001", "994B7DB5D0A2C31D8F68D63224EEC9EB5866B665B03656B357EACCA065257A9B8360E647F91E770B0B52B8015CEBF06CCEE57164021661F1DAF533284C12FAB4EB6D7B808F62E6AD3975BD138693ADCA93A147BC81843A9ED177D504A3D157CC8DD99ADA3DC2A348E498939507A70A6C20880B070D030CDEC304B3C3248F9D2D352B8932D865BFDAD64CF74F98A073043CB43A51A3F582AF36E2523FC56A8224DD2056EDF8790ABE32724F205A949A31E2FFD055823F9D249081482672EAC75BE0755E0EE9DF3FBCA3F50004CFC17B84590FA963DA07765B983EDC39673CCE269CACB6CBAFCA62C13FCBF1461F7C07E8FFA5B6E3EB4D54DEC6872AC8B26585EF", 170);
    }

    public static ac cdM() {
        return new ac("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
    }

    public static ac cdN() {
        x.d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", "010001", "C8B29DB2928FF09CBF561E20E0BDCB9700BF14E02E8291F45811C41569153644267C7C74060BD9D35B6D831F532D3552C8D453682C624F935DFF256E9ACA6735DBB7F9578CF87B0223A8C59CF1740CBA1C34A531D3C0AFED9A076781DCB9611448B3384DF377AF1FF3FD3663756ED675F663F3CCA0B1C7C800644721ECC0823730EC77F8159C2D48BFE0493035914655D24E77940F31C770DD661D7512342CC67C13D1FFBDA1EF32961F5DEA5D94F176FA7A338338D9E039EC194F90637C324B1C627CBBE9DC4004843B37FE7854C6D8A99A5E288EC525E0847618BD0196A87218060ADF0C8D82D8AF07BF718BDDA54D0140DF8293EE76FFC93D3DCFD20F8883".substring(0, 4) + "_" + "C8B29DB2928FF09CBF561E20E0BDCB9700BF14E02E8291F45811C41569153644267C7C74060BD9D35B6D831F532D3552C8D453682C624F935DFF256E9ACA6735DBB7F9578CF87B0223A8C59CF1740CBA1C34A531D3C0AFED9A076781DCB9611448B3384DF377AF1FF3FD3663756ED675F663F3CCA0B1C7C800644721ECC0823730EC77F8159C2D48BFE0493035914655D24E77940F31C770DD661D7512342CC67C13D1FFBDA1EF32961F5DEA5D94F176FA7A338338D9E039EC194F90637C324B1C627CBBE9DC4004843B37FE7854C6D8A99A5E288EC525E0847618BD0196A87218060ADF0C8D82D8AF07BF718BDDA54D0140DF8293EE76FFC93D3DCFD20F8883".substring(507, 511), Integer.valueOf(y.CTRL_INDEX));
        return new ac("010001", "C8B29DB2928FF09CBF561E20E0BDCB9700BF14E02E8291F45811C41569153644267C7C74060BD9D35B6D831F532D3552C8D453682C624F935DFF256E9ACA6735DBB7F9578CF87B0223A8C59CF1740CBA1C34A531D3C0AFED9A076781DCB9611448B3384DF377AF1FF3FD3663756ED675F663F3CCA0B1C7C800644721ECC0823730EC77F8159C2D48BFE0493035914655D24E77940F31C770DD661D7512342CC67C13D1FFBDA1EF32961F5DEA5D94F176FA7A338338D9E039EC194F90637C324B1C627CBBE9DC4004843B37FE7854C6D8A99A5E288EC525E0847618BD0196A87218060ADF0C8D82D8AF07BF718BDDA54D0140DF8293EE76FFC93D3DCFD20F8883", y.CTRL_INDEX);
    }

    public final boolean cdO() {
        return this.ver == 0 || bh.ov(this.vBY) || bh.ov(this.vBZ);
    }

    ac(String str, String str2, int i) {
        this.vBY = str;
        this.vBZ = str2;
        this.ver = i;
    }

    public static boolean cdP() {
        FileWriter fileWriter;
        Throwable e;
        Throwable th;
        boolean z = false;
        try {
            fileWriter = new FileWriter(e.bnF + "DefaultRSA.java");
            try {
                fileWriter.write("package com.tencent.mm.protocal;\n\n");
                fileWriter.write("/**\n *\n * @ClientVersion: " + com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION + "\n");
                fileWriter.write(" * @DumpTime: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " \n */\n");
                fileWriter.write("public final class DefaultRSA {\n");
                fileWriter.write("\n\tpublic final static int BASE_RSA_PUBLIC_VERSION = 169;");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYN = \"C8B29DB2928FF09CBF561E20E0BDCB9700BF14E02E8291F45811C41569153644267C7C74060BD9D35B6D831F532D3552C8D453682C624F935DFF256E9ACA6735DBB7F9578CF87B0223A8C59CF1740CBA1C34A531D3C0AFED9A076781DCB9611448B3384DF377AF1FF3FD3663756ED675F663F3CCA0B1C7C800644721ECC0823730EC77F8159C2D48BFE0493035914655D24E77940F31C770DD661D7512342CC67C13D1FFBDA1EF32961F5DEA5D94F176FA7A338338D9E039EC194F90637C324B1C627CBBE9DC4004843B37FE7854C6D8A99A5E288EC525E0847618BD0196A87218060ADF0C8D82D8AF07BF718BDDA54D0140DF8293EE76FFC93D3DCFD20F8883\";");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYE = \"010001\";\n");
                fileWriter.write("\n\tpublic final static int REQ_RSA_PUBLIC_VERSION = 170;");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYN = \"994B7DB5D0A2C31D8F68D63224EEC9EB5866B665B03656B357EACCA065257A9B8360E647F91E770B0B52B8015CEBF06CCEE57164021661F1DAF533284C12FAB4EB6D7B808F62E6AD3975BD138693ADCA93A147BC81843A9ED177D504A3D157CC8DD99ADA3DC2A348E498939507A70A6C20880B070D030CDEC304B3C3248F9D2D352B8932D865BFDAD64CF74F98A073043CB43A51A3F582AF36E2523FC56A8224DD2056EDF8790ABE32724F205A949A31E2FFD055823F9D249081482672EAC75BE0755E0EE9DF3FBCA3F50004CFC17B84590FA963DA07765B983EDC39673CCE269CACB6CBAFCA62C13FCBF1461F7C07E8FFA5B6E3EB4D54DEC6872AC8B26585EF\";");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYE = \"010001\";\n\n}\n");
                z = true;
                try {
                    fileWriter.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e4) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileWriter = null;
            x.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
            if (fileWriter != null) {
                fileWriter.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw th;
        }
        return z;
    }
}
