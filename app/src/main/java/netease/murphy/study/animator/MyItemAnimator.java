package netease.murphy.study.animator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

/**
 * Created by murphy on 2016/12/27.
 */
public class MyItemAnimator extends RecyclerView.ItemAnimator {
    private static final String TAG = "MyItemAnimator";

    /**
     * @param viewHolder     RecyclerView传入的ViewHolder
     * @param preLayoutInfo  动画开始前的布局信息
     * @param postLayoutInfo 动画开始后的布局信息
     * @return 是否需要执行消失动画
     */
    @Override
    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @Nullable ItemHolderInfo postLayoutInfo) {
        return false;
    }

    /**
     * @param viewHolder     RecyclerView传入的ViewHolder
     * @param preLayoutInfo  动画开始前的布局信息
     * @param postLayoutInfo 动画开始后的布局信息
     * @return 是否需要执行插入动画
     */
    @Override
    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
        return false;
    }

    /**
     * @param viewHolder     RecyclerView传入的ViewHolder
     * @param preLayoutInfo  动画开始前的布局信息
     * @param postLayoutInfo 动画开始后的布局信息
     * @return 是否需要执行保留的Item的移动动画
     */
    @Override
    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
        return false;
    }

    /**
     * @param oldHolder      数据变化前的viewHolder
     * @param newHolder      数据变化后的ViewHolder
     * @param preLayoutInfo  动画开始前的布局信息
     * @param postLayoutInfo 动画开始后的布局信息
     * @return 是否需要执行数据变化所造成的Item的变化的动画
     */
    @Override
    public boolean animateChange(@NonNull RecyclerView.ViewHolder oldHolder, @NonNull RecyclerView.ViewHolder newHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
        return false;
    }

    /**
     * 动画执行时回调此方法
     */
    @Override
    public void runPendingAnimations() {

    }

    /**
     * @param item 需要结束动画的item
     *             item动画结束时回调此方法
     */
    @Override
    public void endAnimation(RecyclerView.ViewHolder item) {

    }

    /**
     * 所有动画执行结束时回调此方法
     */
    @Override
    public void endAnimations() {

    }

    /**
     * @return 动画是否在执行
     */
    @Override
    public boolean isRunning() {
        return false;
    }
}
