package cn.chengxingyao.bindrecyclerview;
/**
 * Created by fml on 2015/12/3 0003.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import cn.chengxingyao.xrecyclerview.R;

/**
 * Created by fml on 2015/10/9 0009.
 * 创建时间:15/10/9 13:16
 * 描述:慕课网下拉刷新风格
 */
public class DefineBAGRefreshWithLoadView extends BGARefreshViewHolder {
    private TextView mHeaderStatusTv;
    private String mPullDownRefreshText = "下拉刷新";
    private String mReleaseRefreshText = "释放更新";
    private String mRefreshingText = "加载中...";
    private boolean isRefreshEnabled = true;
    /** 判断是否使用上拉加载 */
    private boolean mIsLoadingMoreEnabled = true;
    public DefineBAGRefreshWithLoadView(Context context, boolean isLoadingMoreEnabled, boolean isRefreshEnabled) {
        super(context, isLoadingMoreEnabled);
        this.mIsLoadingMoreEnabled = isLoadingMoreEnabled;
        this.isRefreshEnabled = isRefreshEnabled;
    }
    /** 设置下拉显示文字 */
    public void setPullDownRefreshText(String pullDownRefreshText) {
        this.mPullDownRefreshText = pullDownRefreshText;
    }
    /** 设置释放显示文字 */
    public void setReleaseRefreshText(String releaseRefreshText) {
        this.mReleaseRefreshText = releaseRefreshText;
    }
    /** 设置正在刷新显示文字 */
    public void setRefreshingText(String refreshingText) {
        this.mRefreshingText = refreshingText;
    }
    /**
     * 定义刷新
     * */
    public View getRefreshHeaderView() {
        if(this.mRefreshHeaderView == null) {
            this.mRefreshHeaderView = View.inflate(this.mContext, R.layout.header_bga_dodo, (ViewGroup)null);
            this.mRefreshHeaderView.setBackgroundColor(0);
            if(this.mRefreshViewBackgroundColorRes != -1) {
                this.mRefreshHeaderView.setBackgroundResource(this.mRefreshViewBackgroundColorRes);
            }
            if(this.mRefreshViewBackgroundDrawableRes != -1) {
                this.mRefreshHeaderView.setBackgroundResource(this.mRefreshViewBackgroundDrawableRes);
            }
            this.mHeaderStatusTv = (TextView)this.mRefreshHeaderView.findViewById(R.id.tv_normal_refresh_header_status);
            this.mHeaderStatusTv.setText(this.mPullDownRefreshText);
        }
        //刷新不可用
        if(!isRefreshEnabled){
            return null;
        }
        return this.mRefreshHeaderView;
    }
    //已经开始刷新
    public void changeToRefreshing() {
        this.mHeaderStatusTv.setText(this.mRefreshingText);
    }
    //开始下拉
    public void changeToPullDown() {
        this.mHeaderStatusTv.setText(this.mPullDownRefreshText);
    }
    //下拉到一定程度，可以刷新
    public void changeToReleaseRefresh() {
        this.mHeaderStatusTv.setText(this.mReleaseRefreshText);
    }
    //结束刷新
    public void onEndRefreshing() {
        this.mHeaderStatusTv.setText(this.mPullDownRefreshText);
    }
    @Override
    public void handleScale(float scale, int moveYDistance) {
    }

    @Override
    public void changeToIdle() {
    }


    /** 设置加载 */
    public void updateLoadingMoreText(String text){
        this.mFooterStatusTv.setText(text);
    }
    /** 隐藏加载更多图片 */
    public void hideLoadingMoreImg(){
        this.mFooterChrysanthemumIv.setVisibility(View.GONE);
    }
    /** 显示加载更多图片 */
    public void showLoadingMoreImg(){
        this.mFooterChrysanthemumIv.setVisibility(View.VISIBLE);
    }

}