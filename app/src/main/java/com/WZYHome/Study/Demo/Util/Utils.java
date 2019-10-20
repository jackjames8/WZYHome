package com.WZYHome.Study.Demo.Util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;



import com.WZYHome.Study.Demo.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



/**
 * @author: Unique
 * CreatedTime 2017/11/2on 14:11
 * function:
 */
public class Utils {

    private static Context context;

    private Utils() {
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context;
//        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        return context;
    }

    public static File getAppRootPath(Context context) {
        if (sdCardIsAvailable()) {
            return Environment.getExternalStorageDirectory();
        } else {
            return context.getFilesDir();
        }
    }

    public static boolean sdCardIsAvailable() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return Environment.getExternalStorageDirectory().canWrite();
        } else
            return false;
    }

    public static String phoneEncryption(String phone) {
        if (phone.length() != 11) {
            return phone;
        }
        return phone.substring(0, 3) + "****" + phone.substring(7, 11);
    }

    public static boolean isPhone(String phone) {
        if (phone.length() == 11 && "1".equals(phone.substring(0, 1))) {
            return false;
        }
        return true;
    }

    public static boolean isIDCard(String iDCard) {
        return !(iDCard.length() == 18);
    }

    public static String getSha1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length() - 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getInfo(String info) {
        if (info.isEmpty()) {
            return "";
        }
        int length = info.length();
        info = info.substring(1, length - 1);
        info = info.replaceAll("\"", "");
        return info;
    }

    /**
     * 格式化时间转成long
     *
     * @param time
     * @return
     */
    public static long getTimes(String time) {
        if (time.isEmpty()) {
            return 0;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = sdf1.parse(time);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return d.getTime();
    }

    /**
     * 时间格式化 2000-01-01 15:30:00
     *
     * @param date
     * @return
     */
    public static String getString(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = new Date(date);
        sdf.format(dt);
        return sdf.format(dt).toString();
    }

    public static String getSingString(String date) {
        long l = getTimes(date) - 3600000l;
        return getString(l);
    }



    /**
     * 时间格式化 2000-01-01 15:30
     *
     * @param date
     * @return
     */
    public static String getTimeString(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dt = new Date(date);
        sdf.format(dt);
        return sdf.format(dt);
    }

    /**
     * 时间格式化 顺风车需要时间格式
     *
     * @param date
     * @return
     */
    public static String getNearbyTimeString(String date) {
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date dt = new Date(time);
        String format = sdf.format(dt);
        if (date.compareTo(format) > 0) {
            return getTimeString() + " " + date + ":00";
        } else {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            Date dt2 = new Date(time + 24 * 60 * 60 * 1000);
            return sdf2.format(dt2) + " " + date + ":00";
        }
    }

    /**
     * 时间格式化 2000-01-01
     *
     * @param
     * @return
     */
    public static String getTimeString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date(System.currentTimeMillis());
        sdf.format(dt);
        return sdf.format(dt);
    }


    /**
     * 格式化时间转成long
     *
     * @param time
     * @return
     */
    public static long getAddOrderReserveTime(String time) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d = null;
        try {
            d = sdf1.parse(time);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return d.getTime();
    }

    public static boolean isSelectTimeState(String startTime, String endTime) {
        return getAddOrderReserveTime(startTime) > (getAddOrderReserveTime(endTime) - 1000);
    }

    // 判断文件是否存在
    public static void judeFileExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("file exists");

        } else {
            System.out.println("file not exists, create it ...");
            try {
                file.createNewFile();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // 判断文件夹是否存在
    public static void judeDirExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("dir exists");
            } else {
                System.out.println("the same name file exists, can not create dir");
            }
        } else {
            System.out.println("dir not exists, create it ...");
            file.mkdir();
        }
    }
    /*
    public static void notification(Context context) {
        notificationModel(context, "车主订单", "订单60000", 1, "com.qcgp56.qcgp.library.ui.driver.NewDriverOrderActivity");
    }*/

    public static void notificationModel(Context context, String title, String text, int id, String activity) {
        Intent it = new Intent();
        it.setClassName("com.qcgp56.qcgp", activity);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, it, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification //设置小图标
                .setSmallIcon(R.drawable.app_logo_notification)
                //设置震动
                .setDefaults(Notification.DEFAULT_SOUND)
                //设置状态点击时消失
                .setAutoCancel(true)
                //设置通知标题
                .setContentTitle(title)
                //设置通知描述
                .setContentText(text)
                //设置低版本状态栏滚动文字
                .setTicker(text)
                //设置时间
                .setWhen(System.currentTimeMillis())
                //设置目标界面
                .setContentIntent(contentIntent);
        //显示通知
        manager.notify(id, notification.build());
    }

  /*  public static int getNetworkType(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return 0;
        } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            return 1;
        } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            return 2;
        } else {
            return 0;
        }
    }*/

    private static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();
        }
        return sdDir == null ? "" : sdDir.getAbsolutePath();
    }

    //基础路径
    private static String getBasePath() {
        return getSDPath() + "/Android/data/com.qcgp56.qcgp";
    }

    //更新包文件夹
    public static String getUpdateDownloadDir() {
        return getSDPath() + "/Android/data/com.WZYHome.Study.Demo/apk";
    }
    //更新包文件夹
    public static String getVideoDownloadDir() {
        return getSDPath() + "/Android/data/com.WZYHome.Study.Demo/video";
    }

    //更新包文件夹
    public static String getImgPath() {
        return getSDPath() + "/Android/data/com.WZYHome.Study.Demo/img";
    }

    /**
     * 保存图片
     *
     * @param bmp 待保存图片
     * @return 保存地址
     */
    public static String saveImage(Bitmap bmp) {
        File appDir = new File(getImgPath());
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = "Share.jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            return "";
        }
        return file.getPath();
    }

    public static Drawable getResourcesBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        Bitmap bm = BitmapFactory.decodeStream(is, null, opt);
        return new BitmapDrawable(context.getResources(), bm);
    }

    public static int calculateDistance(double sLongitude, double sLatitude, double eLongitude, double eLatitude) {
        if (sLatitude == 0) {
            return 1001;
        }
        final double NF_pi = 0.01745329251994329; // 弧度 PI/180
        sLongitude *= NF_pi;
        sLatitude *= NF_pi;
        eLongitude *= NF_pi;
        eLatitude *= NF_pi;
        double sinx1 = Math.sin(sLongitude);
        double siny1 = Math.sin(sLatitude);
        double cosx1 = Math.cos(sLongitude);
        double cosy1 = Math.cos(sLatitude);
        double sinx2 = Math.sin(eLongitude);
        double siny2 = Math.sin(eLatitude);
        double cosx2 = Math.cos(eLongitude);
        double cosy2 = Math.cos(eLatitude);
        double[] v1 = new double[3];
        v1[0] = cosy1 * cosx1 - cosy2 * cosx2;
        v1[1] = cosy1 * sinx1 - cosy2 * sinx2;
        v1[2] = siny1 - siny2;
        double dist = Math.sqrt(v1[0] * v1[0] + v1[1] * v1[1] + v1[2] * v1[2]);
        return (int) (Math.asin(dist / 2) * 12742001.5798544);
    }
    /**
     * 合并图片
     *
     * @param firstBitmap  背景图
     * @param url 推广图
     * @return 合并图
     * <p>
     * public Bitmap mergeBitmap(Bitmap firstBitmap, Bitmap secondBitmap) {
     * float height = ((firstBitmap.getHeight() - secondBitmap.getHeight()) / 2);
     * float width = ((firstBitmap.getWidth() - secondBitmap.getWidth()) / 2);
     * Bitmap bitmap = Bitmap.createBitmap(firstBitmap.getWidth(), firstBitmap.getHeight(), firstBitmap.getConfig());
     * Canvas canvas = new Canvas(bitmap);
     * canvas.drawBitmap(firstBitmap, new Matrix(), null);
     * canvas.drawBitmap(secondBitmap, width, height, null);
     * return bitmap;
     * }

    public String saveImgPath(Bitmap firstBitmap, String url) {
    Bitmap secondBitmap = ViewFactory.getInstance().getBitmap(url);
    if(secondBitmap==null){
    return "";
    }
    float height = ((firstBitmap.getHeight() - secondBitmap.getHeight()) / 2);
    float width = ((firstBitmap.getWidth() - secondBitmap.getWidth()) / 2);
    Bitmap bitmap = Bitmap.createBitmap(firstBitmap.getWidth(), firstBitmap.getHeight(), firstBitmap.getConfig());
    Canvas canvas = new Canvas(bitmap);
    canvas.drawBitmap(firstBitmap, new Matrix(), null);
    canvas.drawBitmap(secondBitmap, width, height, null);
    return saveImage(bitmap);
    }*/

}
