package com.WZYHome.Study.Demo.Unit2_View.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       int sizeWidth=MeasureSpec.getSize(widthMeasureSpec);
       int modeWidth=MeasureSpec.getMode(widthMeasureSpec);
       int sizeHeight=MeasureSpec.getSize(heightMeasureSpec);
       int modeHeight=MeasureSpec.getMode(heightMeasureSpec);
       //wrap_content
        int width=0;
        int height=0;
        //记录每一行的宽度与高度
        int lineWidth=0;
        int lineHeight=0;
        //得到内部元素的个数
        int cCount=getChildCount();
        for(int i=0;i<cCount;i++){
            View child=getChildAt(i) ;
            //测量子View的宽和高
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            //得到LayoutParams
            MarginLayoutParams lp= (MarginLayoutParams) child.getLayoutParams();
            //子View占据的宽度
            int childWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
            //子View占据的高度
            int childHeight=child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
            //换行
            if(lineWidth+childWidth>sizeWidth){
                //对比得到最大的宽度
                width=Math.max(width,lineWidth);
                //重置lineWidth
                lineWidth=childWidth;
                //记录行高
                height+=lineHeight;
                lineHeight=childHeight;
            }else//未换行　
                {
                    //叠加行宽
                lineWidth+=childWidth;
                //得到当前最大子控件作为行高
                lineHeight=Math.max(lineHeight,childHeight);
            }
            //最后一个控件
            if(i==cCount-1){
             width=Math.max(lineWidth,width);
             height+=lineHeight;
            }


        }
        Log.e("TAG,","sizeWidth="+sizeWidth);
        Log.e("TAG,","sizeHeight="+sizeHeight);
    setMeasuredDimension(modeWidth==MeasureSpec.EXACTLY?sizeWidth: width,
            modeHeight==MeasureSpec.EXACTLY?sizeHeight:height
    );
    }

    /**
     *
     * @param attrs 与当前ViewGroup对应的LayoutParams
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    //存储所有的View
    private List<List<View>> mAllViews=new ArrayList<List<View>>();
    /**
     * 每一行的高度
     */
    private  List<Integer> mLineHeight=new ArrayList<Integer>();
    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        mAllViews.clear();
        mLineHeight.clear();
        //当前ViewGroup的宽度
        int width=getWidth();
        int lineWidth=0;
        int lineHeight=0;
        List<View> lineViews=new ArrayList<View>();
        int cCount=getChildCount();
        for(int j=0;j<cCount;j++)
        {
            View child=getChildAt(j);
           MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
           int childWidth=child.getMeasuredWidth();
           int childHeight=child.getMeasuredHeight();
           //如果需要换行
           if(childWidth+lineWidth+lp.leftMargin+lp.rightMargin>width)
           {
               //记录LineHeight
              mLineHeight.add(lineHeight);
              //记录当前行的Views
               mAllViews.add(lineViews);
               //重置我们的行宽和行高
               lineWidth=0;
               lineHeight=childHeight+lp.topMargin+lp.bottomMargin;
               //重置我们的View集合
               lineViews=new ArrayList<View>();
           }
           lineWidth+=childWidth+lp.leftMargin+lp.rightMargin;
           lineHeight=Math.max(lineHeight,childHeight+lp.topMargin+lp.bottomMargin);
           lineViews.add(child);
        }//for end
        //处理最后一行
        mLineHeight.add(lineHeight);
        mAllViews.add(lineViews);
        //设置子View的位置
        int left=0;
        int top=0;
        //行数
        int lineNum=mAllViews.size();
        for(int k=0;k<lineNum;k++){
            //当前行的所有的View
           lineViews=mAllViews.get(k);
           lineHeight=mLineHeight.get(k);
           for(int p=0;p<lineViews.size();p++)
           {
               View child=lineViews.get(p);
               if(child.getVisibility()==View.GONE){
                   continue;
               }
               MarginLayoutParams lp= (MarginLayoutParams) child.getLayoutParams();
               int lc=left+lp.leftMargin;
               int tc=top+lp.topMargin;
               int rc=lc+child.getMeasuredWidth();
               int bc=tc+child.getMeasuredHeight();
               //为子View进行布局
               child.layout(lc,tc,rc,bc);
               left+=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
           }
           left=0;
           top+=lineHeight;

        }


    }

}
