package lt.mindstorm.gif;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView list;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        list = (RecyclerView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        list.setLayoutManager(mLayoutManager);
        String[] myDataset = new String[]
                {"https://media.giphy.com/media/63cx21uYEl3aM/giphy.gif",
                "https://media.giphy.com/media/IgdZpQHUR7sbe/giphy.gif",
                        "https://media.giphy.com/media/8oTjltulq40BG/giphy.gif",
                "https://media.giphy.com/media/l46CAeMR1XVgrpY5O/giphy.gif",
                        "https://media.giphy.com/media/l46Cr6nhtezksI2dO/giphy.gif",
                "https://media.giphy.com/media/l41Yy14JIoB8ipUTS/giphy.gif",
                "https://media.giphy.com/media/xT8qB8YvduMuybqHSw/giphy.gif",
                "https://media.giphy.com/media/3o72F3lOmSJjJZLZW8/giphy.gif"};

        MyAdapter mAdapter = new MyAdapter(myDataset);
        list.setAdapter(mAdapter);
    }
}
