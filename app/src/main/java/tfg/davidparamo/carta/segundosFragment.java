package tfg.davidparamo.carta;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class segundosFragment extends Fragment {


    public segundosFragment() {
        // Required empty public constructor
    }


    List<Item> lista = new ArrayList<>();
    ArrayList<String> imageUrls = new ArrayList<>();
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
        for(Plato plato:GlobalSettings.platos){
            if(plato.getTipoPlato().equals("Segundo")) {
                if (plato.getImageUrl() == null || plato.getImageUrl().isEmpty())
                    imageUrls.add("http://www.51allout.co.uk/wp-content/uploads/2012/02/Image-not-found.gif");
                else imageUrls.add(plato.getImageUrl());
            }
        }
        String[] imageArray = new String[imageUrls.size()];
        imageArray = imageUrls.toArray(imageArray);
        gridView.setAdapter(new ImageListAdapter(getContext(), imageArray));


        return view;
    }

}