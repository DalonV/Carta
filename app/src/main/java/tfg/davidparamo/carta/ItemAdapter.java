package tfg.davidparamo.carta;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by david on 23/03/2017.
 */

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private List<Item> items;
    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView res = (ImageView) convertView;
        if (convertView == null) {
            res = new ImageView(context);
            res.setLayoutParams(new GridView.LayoutParams(500,500));
        }

        res.setImageResource(items.get(position).getImage());
        return res;
    }
}

