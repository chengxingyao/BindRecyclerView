package cn.chengxingyao.bindrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * 自定义RecyclerView
 */
public class XRecyclerView extends BGARefreshLayout {
    protected RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layout;
    protected XRecyclerViewAdapter mXRecyclerViewAdapter;
    /**
     * 设置刷新和加载
     */
    private DefineBAGRefreshWithLoadView mDefineBAGRefreshWithLoadView = null;

    public XRecyclerView(Context context) {
        super(context);
        init();
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setBgaRefreshLayout();
//        setIsShowLoadingMoreView(false);
        mRecyclerView = new RecyclerView(getContext());
        addView(mRecyclerView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layout = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layout);
        mXRecyclerViewAdapter = new XRecyclerViewAdapter();
        mRecyclerView.setAdapter(mXRecyclerViewAdapter);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        layoutParams.weight = 1;
        mRecyclerView.setLayoutParams(layoutParams);
    }

    /**
     * 设置 BGARefreshLayout刷新和加载
     */
    private void setBgaRefreshLayout() {
        mDefineBAGRefreshWithLoadView = new DefineBAGRefreshWithLoadView(getContext(), true, true);
        //设置刷新样式
        setRefreshViewHolder(mDefineBAGRefreshWithLoadView);

    }

    public DefineBAGRefreshWithLoadView getRefreshViewHolder() {
        return mDefineBAGRefreshWithLoadView;
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return false;
    }


    public void setLayout(RecyclerView.LayoutManager layout) {
        this.layout = layout;
    }

    public RecyclerView.LayoutManager getLayout() {
        return layout;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public XRecyclerViewAdapter getAdapter() {
        return (XRecyclerViewAdapter) mRecyclerView.getAdapter();
    }

}
