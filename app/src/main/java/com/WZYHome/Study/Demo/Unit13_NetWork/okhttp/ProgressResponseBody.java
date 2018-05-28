package com.WZYHome.Study.Demo.Unit13_NetWork.okhttp;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by Administrator on 2017/12/6.
 */

public class ProgressResponseBody extends ResponseBody {
    private ResponseBody mResponseBody;
    private  BufferedSource mBufferedSource;
    private ProgressListener progressListener;

    public ProgressResponseBody(ResponseBody mResponseBody,ProgressListener progressListener) {
        this.mResponseBody = mResponseBody;
        this.progressListener=progressListener;
    }

    @Override
    public MediaType contentType() {
        return mResponseBody.contentType();
    }

    @Override
    public long contentLength() {
        return mResponseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if(mBufferedSource==null)
            mBufferedSource=Okio.buffer(getsourse(mResponseBody.source()));
        return mBufferedSource;
    }
    private Source getsourse(Source source){
        return  new ForwardingSource(source) {
            long totalSize=0;
            long Sum=0;
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                if(totalSize==0){
                    totalSize=contentLength();
                }
                long len=super.read(sink, byteCount);
                Sum+=(len==-1?0:len);
                int progress= (int) ((Sum*1.0f/totalSize)*100);
                if(len==-1){
                    progressListener.onDone(totalSize);
                }else
                progressListener.onProgress(progress);
                return len;
            }
        };

    }

}
