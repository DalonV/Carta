package tfg.davidparamo.carta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class postresFragment extends Fragment {


    public postresFragment() {
        // Required empty public constructor
    }

    List<Item> lista = new ArrayList<>();

    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.postreslayout, container, false);
        lista.add(new Item(R.drawable.amazon,"http://amazon.es/"));
        lista.add(new Item(R.drawable.facebook,"http://www.facebook.com/"));
        lista.add(new Item(R.drawable.instagram,"http://www.instagram.com"));
        lista.add(new Item(R.drawable.google,"http://plus.google.com"));
        ItemAdapter adaptador = new ItemAdapter(getContext(),lista);
        GridView gridView = (GridView) view.findViewById(R.id.postresGrid);
        Log.d("MEEEEEEEH","MEEEEEEEEEEEEEEEEEH");
        gridView.setAdapter(new ImageListAdapter(getContext(), eatFoodyImages));


        return view;
    }


}