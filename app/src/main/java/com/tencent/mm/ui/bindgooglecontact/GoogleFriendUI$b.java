package com.tencent.mm.ui.bindgooglecontact;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GoogleFriendUI$b extends AsyncTask<Void, Void, Void> {
    private String hzj;
    private Context mContext;
    final /* synthetic */ GoogleFriendUI ykV;
    private a yld;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return aSm();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
        if (this.yld != a.ykY) {
            GoogleFriendUI.a(this.ykV, this.yld, null);
        } else if (GoogleFriendUI.e(this.ykV) == null || GoogleFriendUI.e(this.ykV).size() <= 0) {
            GoogleFriendUI.a(this.ykV, a.ykZ, null);
        } else {
            GoogleFriendUI.a(this.ykV, a.ykY, GoogleFriendUI.e(this.ykV));
        }
    }

    private GoogleFriendUI$b(GoogleFriendUI googleFriendUI, Context context, String str) {
        this.ykV = googleFriendUI;
        this.yld = a.ylb;
        this.mContext = context;
        this.hzj = str;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
        GoogleFriendUI.e(this.ykV).clear();
        GoogleFriendUI.f(this.ykV).clear();
    }

    private Void aSm() {
        x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
        int i = 0;
        int i2 = 1;
        while (true) {
            try {
                String r;
                Object obj;
                x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[]{new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i2 + "&access_token=" + this.hzj).toString()});
                HttpURLConnection httpURLConnection = (HttpURLConnection) r6.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
                int responseCode = httpURLConnection.getResponseCode();
                x.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    r = r(inputStream);
                    inputStream.close();
                } else {
                    if (responseCode == 401) {
                        x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
                    } else {
                        x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
                    }
                    httpURLConnection.disconnect();
                    r = null;
                }
                responseCode = new JSONObject(r).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                if (responseCode > 0) {
                    YT(r);
                }
                if (responseCode - i2 > 100) {
                    i2 += 100;
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null || GoogleFriendUI.g(this.ykV)) {
                    this.yld = a.ykY;
                } else {
                    i = responseCode;
                }
            } catch (IOException e) {
                this.yld = a.yla;
                x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e.getMessage());
            } catch (JSONException e2) {
                this.yld = a.ylb;
                x.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e2.getMessage());
            }
        }
        this.yld = a.ykY;
        return null;
    }

    private static String r(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[20480];
        while (true) {
            int read = inputStream.read(bArr, 0, 20480);
            if (read == -1) {
                return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private void YT(String str) {
        JSONArray jSONArray = new JSONObject(str).getJSONObject("feed").getJSONArray("entry");
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String string;
                int lastIndexOf;
                int i2;
                String string2;
                CharSequence substring;
                int i3;
                o oVar;
                String str2 = "";
                String str3 = "";
                String str4 = "";
                JSONObject optJSONObject = jSONArray.getJSONObject(i).optJSONObject(SlookAirButtonFrequentContactAdapter.ID);
                JSONObject optJSONObject2 = jSONArray.getJSONObject(i).optJSONObject("title");
                JSONArray optJSONArray = jSONArray.getJSONObject(i).optJSONArray("gd$email");
                JSONArray optJSONArray2 = jSONArray.getJSONObject(i).optJSONArray("link");
                if (optJSONObject != null) {
                    string = optJSONObject.getString("$t");
                    lastIndexOf = string.lastIndexOf("/");
                    if (lastIndexOf > 0) {
                        string = string.substring(lastIndexOf + 1);
                        if (optJSONObject2 == null) {
                            str2 = optJSONObject2.getString("$t");
                        } else {
                            str2 = str3;
                        }
                        if (optJSONArray2 != null) {
                            for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                                lastIndexOf = string2.lastIndexOf("#");
                                if (lastIndexOf > 0) {
                                    substring = string2.substring(lastIndexOf + 1);
                                    if (!TextUtils.isEmpty(substring) && SlookAirButtonFrequentContactAdapter.PHOTO.equals(substring)) {
                                        str4 = optJSONArray2.getJSONObject(i2).getString("href");
                                    }
                                }
                            }
                        }
                        str3 = str4;
                        if (optJSONArray != null) {
                            for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                                string2 = optJSONArray.getJSONObject(i3).getString("address");
                                if (!(TextUtils.isEmpty(string2) || !bh.Vt(string2) || string2.equals(GoogleFriendUI.h(this.ykV)))) {
                                    oVar = new o();
                                    oVar.field_googleid = string;
                                    oVar.field_googleitemid = string + string2;
                                    oVar.field_googlename = str2;
                                    oVar.field_googlephotourl = str3;
                                    oVar.field_googlegmail = string2;
                                    if (!GoogleFriendUI.f(this.ykV).containsKey(string2)) {
                                        GoogleFriendUI.e(this.ykV).add(oVar);
                                        GoogleFriendUI.f(this.ykV).put(string2, oVar);
                                    }
                                }
                            }
                        }
                    }
                }
                string = str2;
                if (optJSONObject2 == null) {
                    str2 = str3;
                } else {
                    str2 = optJSONObject2.getString("$t");
                }
                if (optJSONArray2 != null) {
                    for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                        lastIndexOf = string2.lastIndexOf("#");
                        if (lastIndexOf > 0) {
                            substring = string2.substring(lastIndexOf + 1);
                            str4 = optJSONArray2.getJSONObject(i2).getString("href");
                        }
                    }
                }
                str3 = str4;
                if (optJSONArray != null) {
                    for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                        string2 = optJSONArray.getJSONObject(i3).getString("address");
                        oVar = new o();
                        oVar.field_googleid = string;
                        oVar.field_googleitemid = string + string2;
                        oVar.field_googlename = str2;
                        oVar.field_googlephotourl = str3;
                        oVar.field_googlegmail = string2;
                        if (!GoogleFriendUI.f(this.ykV).containsKey(string2)) {
                            GoogleFriendUI.e(this.ykV).add(oVar);
                            GoogleFriendUI.f(this.ykV).put(string2, oVar);
                        }
                    }
                }
            }
        }
    }
}
