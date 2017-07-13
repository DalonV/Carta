package tfg.davidparamo.carta;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.ViewTreeObserver;
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

    ArrayList<String> imageUrls = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.postreslayout, container, false);
        final GridView gridView = (GridView) view.findViewById(R.id.postresGrid);
        final int orientation = view.getResources().getConfiguration().orientation;
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    gridView.setNumColumns(2);
                } else {
                    gridView.setNumColumns(3);
                }
            }
        });
        Log.d("MEEEEEEEH","MEEEEEEEEEEEEEEEEEH");
        for(Plato plato:GlobalSettings.platosPostre){
                if (plato.getImageUrl() == null || plato.getImageUrl().isEmpty())
                    plato.setImageUrl("http://www.51allout.co.uk/wp-content/uploads/2012/02/Image-not-found.gif");
                imageUrls.add(plato.getImageUrl());

        }
        String[] imageArray = new String[imageUrls.size()];
        imageArray = imageUrls.toArray(imageArray);
        gridView.setAdapter(new ImageListAdapter(getContext(),getActivity(), imageArray, GlobalSettings.platosPostre));


        return view;
    }


}