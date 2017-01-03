package netease.murphy.study.animator;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by murphy on 2016/12/27.
 */
public class MySimpleAnimator extends SimpleItemAnimator {
    private static final String TAG = "MySimpleAnimator";

    /**
     * 保存需要做Add动画的Viewholder
     */
    private List<RecyclerView.ViewHolder> pendingAddViewHolderList;

    /**
     * 正在执行动画的ViewHolder
     */
    private List<RecyclerView.ViewHolder> addingViewHolderList;

    public MySimpleAnimator() {
        addingViewHolderList = new ArrayList<>();
        pendingAddViewHolderList = new ArrayList<>();
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        return false;
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        pendingAddViewHolderList.add(holder);
        return false;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
        return false;
    }

    @Override
    public void runPendingAnimations() {

    }

    @Override
    public void endAnimation(RecyclerView.ViewHolder item) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
