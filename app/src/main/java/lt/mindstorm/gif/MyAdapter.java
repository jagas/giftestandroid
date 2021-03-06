package lt.mindstorm.gif;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        //public ImageView gif;
        public SimpleDraweeView gif;

        public ViewHolder(View v) {
            super(v);
           // gif = (ImageView) v.findViewById(gif);
            gif = (SimpleDraweeView) v.findViewById(R.id.gif);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fresco_gif, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.gif.setImageURI(Uri.parse(mDataset[position]));
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(mDataset[position])
                .setAutoPlayAnimations(true)
        .build();
       holder.gif.setController(controller);
//        Glide.clear(holder.gif);
//        Glide.with(holder.gif.getContext()).load(mDataset[position]).asGif().centerCrop().listener(new RequestListener<String, GifDrawable>() {
//            @Override
//            public boolean onException(Exception e, String model, Target<GifDrawable> target, boolean isFirstResource) {
//                Log.e("Exception", e.toString() + " " + model);
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GifDrawable resource, String model, Target<GifDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                Log.e("onResourceReady", isFromMemoryCache + " " + model);
//                return false;
//            }
//        }).into(holder.gif);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}