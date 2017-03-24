package cn.chengxingyao.xrecyclerview.example;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.chengxingyao.bindrecyclerview.IViewHolder;
import cn.chengxingyao.bindrecyclerview.XViewHolder;


/**
 * Created by cheng on 2017/3/17.
 */

public class TestHolder extends IViewHolder {
    @Override
    protected XViewHolder create(View view, RecyclerView.Adapter adapter) {
        return new Holder(view, adapter);
    }

    @Override
    public int getLayout() {
        return R.layout.test;
    }

    class Holder extends XViewHolder<Integer> {
        protected TextView tvName;

        public Holder(View itemView, RecyclerView.Adapter adapter) {
            super(itemView, adapter);
        }

        @Override
        public void onClick(View v) {
        }

        @Override
        protected void initView(View rootView) {
            tvName = (TextView) rootView.findViewById(R.id.tv_name);

        }

        @Override
        protected void onBindData(Integer itemData) {
            tvName.setText("aaaa" + itemData);
        }
    }
}
