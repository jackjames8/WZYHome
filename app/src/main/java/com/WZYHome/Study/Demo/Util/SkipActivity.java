package com.WZYHome.Study.Demo.Util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;


/**
 * @author: Unique
 * CreatedTime 2017/11/2 on 14:11
 * function:
 */
public class SkipActivity {

    private static SkipActivity saveData;

    private SkipActivity() {
    }

    public static void init(Context context) {
        if (saveData == null) {
            synchronized (SkipActivity.class) {
                if (saveData == null) {
                    saveData = new SkipActivity();
                }
            }
        }
    }

    public static SkipActivity getInstance() {
        if (saveData == null) {
            return null;
        }
        return saveData;
    }





    public void startActivity(AppCompatActivity activity, Class clazz) {
        Intent intent = new Intent(activity, clazz);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }

    public void startActivity(AppCompatActivity activity, Class clazz, int code) {
        Intent intent = new Intent(activity, clazz);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivityForResult(intent, code);
    }



    public Intent skipPhone(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        return intent;
    }

    public Intent skipSMS(String phone) {
        return skipSMS(phone, "您好!我是千城共配");
    }

    public Intent skipSMS(String phone, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone));
        if (body.isEmpty()) {
            body = "您好!我是千城共配";
        }
        intent.putExtra("sms_body", body);
        return intent;
    }

   /* private void startSendEmailIntent(FragmentActivity activity) {
        Intent data = new Intent(Intent.ACTION_SENDTO);
        data.setData(Uri.parse("mailto:"));
        data.putExtra(Intent.EXTRA_SUBJECT, "这是标题");
        data.putExtra(Intent.EXTRA_TEXT, "这是内容");
        activity.startActivity(data);
    }*/

    public void showWebView(AppCompatActivity activity, String url) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        activity.startActivity(intent);
    }

    public void startShipperEvaluate(AppCompatActivity activity) {
        startModel(activity, "com.qcgp56.qcgp.app.comment.ShipperEvaluateActivity");
    }

    public void startShipperAppraiseShow(FragmentActivity activity) {
        startModel(activity, "com.qcgp56.qcgp.app.comment.ShipperAppraiseShowActivity");
    }

    public void startDriverEvaluate(FragmentActivity activity) {
        startModel(activity, "com.qcgp56.qcgp.app.comment.DriverEvaluateActivity");
    }

    public void startDriverAppraiseShow(FragmentActivity activity) {
        startModel(activity, "com.qcgp56.qcgp.app.comment.DriverAppraiseShowActivity");
    }

    public void startPersonInfo(FragmentActivity activity) {
        startModel(activity, "com.qcgp56.qcgp.app.ui.PersonInfoActivity");
    }

    public void startEail(FragmentActivity activity) {
        startModel(activity, "com.qcgp56.qcgp.app.ui.EailActivity");
    }

    public void startMyMoneyBankCard(FragmentActivity activity) {
        startModel(activity, "com.qcgp56.qcgp.app.ui.MyMoneyBankCardActivity");
    }

    public void startAgentInfoUpdate(FragmentActivity activity, String data) {
        startModel(activity, "com.qcgp56.qcgp.app.ui.agent.AgentInfoUpdateActivity", data);
    }

    public void startModel(FragmentActivity activity, String pag) {
        try {
            Class clazz = Class.forName(pag);
            Intent intent = new Intent(activity, clazz);
            activity.startActivity(intent);
        } catch (Exception e) {
            System.out.println(" err " + pag);
        }
    }

    public void startModel(FragmentActivity activity, String pag, String data) {
        try {
            Class clazz = Class.forName(pag);
            Intent intent = new Intent(activity, clazz);
            intent.putExtra("Data", data);
            activity.startActivity(intent);
        } catch (Exception e) {
            System.out.println(" err " + pag);
        }
    }
}
