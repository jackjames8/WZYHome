package com.WZYHome.Study.Demo.Unit13_NetWork.okhttp;

/**
 * Created by Administrator on 2017/12/7.
 */

public interface ProgressListener {
    public void onProgress(int progress);
    public void onDone(long totalSize);
}
