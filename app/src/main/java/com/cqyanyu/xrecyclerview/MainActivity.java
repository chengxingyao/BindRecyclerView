package com.cqyanyu.xrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.chengxingyao.bindrecyclerview.XRecyclerView;
import cn.chengxingyao.bindrecyclerview.XRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    protected XRecyclerView mXRecyclerView;
    private XRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        adapter = mXRecyclerView.getAdapter();
        mXRecyclerView.setDelegate(this);
        adapter.bindHolder(new TestHolder());//type=0
        adapter.bindHolder(new Test2Holder());//type=1
        loadData();
    }

    private void loadData() {
        List list = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        adapter.setData(0, list);
        List list2 = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list2.add(i + "");
        }
        adapter.setData(1, list2);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        mXRecyclerView = (XRecyclerView) findViewById(R.id.mXRecyclerView);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1://添加一项数据
                adapter.addData(0, 457567453);
                break;
            case R.id.btn2://更新一组数据
                List list3 = new ArrayList();
                for (int i = 30; i < 40; i++) {
                    list3.add(i + "");
                }
                adapter.setData(1, list3);
                break;
            case R.id.btn3://删除一组
                adapter.removeGroup(1);
                break;
            case R.id.btn4://删除一条
                adapter.remove(10);
                break;
            case R.id.btn5:// 类型1中删除一条
                adapter.remove(1, 2);
                break;
            case R.id.btn6:// 添加一组数据
                List list9 = new ArrayList();
                for (int i = 60; i < 80; i++) {
                    list9.add(i + "");
                }
                adapter.addDataAll(1, list9);
        }
    }

    private Handler mHandler = new Handler() {

        public void dispatchMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    loadData();
                    mXRecyclerView.endRefreshing();
                    break;
                case 2:
                    List list9 = new ArrayList();
                    for (int i = 0; i < 10; i++) {
                        float a=(float) (Math.random()*100);
                        list9.add(a + "");
                    }
                    adapter.addDataAll(1, list9);
                    mXRecyclerView.endLoadingMore();
            }
        }
    };

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mHandler.sendMessageDelayed(mHandler.obtainMessage(1), 2000);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        mHandler.sendMessageDelayed(mHandler.obtainMessage(2), 2000);
        return true;
    }
}
