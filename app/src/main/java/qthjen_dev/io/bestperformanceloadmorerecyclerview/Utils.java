package qthjen_dev.io.bestperformanceloadmorerecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.ArrayList;

public class Utils extends DiffUtil.Callback {

    ArrayList<MModel> newList;
    ArrayList<MModel> oldList;

    public Utils(ArrayList<MModel> newList, ArrayList<MModel> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        if (result == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        MModel newModel = newList.get(newItemPosition);
        MModel oldModel = oldList.get(oldItemPosition);

        Bundle diff = new Bundle();
        if (!newModel.getName().equals(oldModel.getName())) {
            diff.putString("name", newModel.getName());
        }

        if (!newModel.getNumber().equals(oldModel.getNumber())) {
            diff.putString("number", newModel.getNumber());
        }

        if (diff.size() == 0) {
            return null;
        }

        return diff;
    }
}
