package cn.chengxingyao.bindrecyclerview;

import java.util.ArrayList;
import java.util.List;

import cn.chengxingyao.xrecyclerview.IViewHolder;

/**
 * Holder 与 数据实体类，用于分组绑定hoder
 * Created by cheng on 2017/3/17.
 */

public class HolderDataEntity {
    private IViewHolder iViewHolder;
    private List list;

    public HolderDataEntity(IViewHolder iViewHolder, List list) {
        this.iViewHolder = iViewHolder;
        this.list = list;
    }

    public HolderDataEntity(IViewHolder iViewHolder) {
        this.iViewHolder = iViewHolder;
    }

    public void setiViewHolder(IViewHolder iViewHolder) {
        this.iViewHolder = iViewHolder;
    }

    public void setList(List list) {
        this.list = list;
    }

    public IViewHolder getiViewHolder() {
        return iViewHolder;
    }

    public List getList() {
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }


}
