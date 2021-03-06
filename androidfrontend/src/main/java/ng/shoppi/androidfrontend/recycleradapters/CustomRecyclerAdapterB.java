package ng.shoppi.androidfrontend.recycleradapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

import ng.shoppi.androidfrontend.R;
import ng.shoppi.androidfrontend.listeners.OnRecyclerClickListener;


/**
 * A custom Recycler Adapter using a typical view lib_shopping_recycler_item_1.
 *
 * @author Olawale
 * @version 1.0.0
 */

public class CustomRecyclerAdapterB extends RecyclerView.Adapter<CustomRecyclerAdapterB.RecyclerViewHolder> {

    private Context context;
    private ArrayList<Map<String, String>> items;
    private OnRecyclerClickListener onRecyclerClickListener;
    private boolean loadImage;

    public static final String IMAGE_URL = "image_url";
    public static final String TITLE = "title";
    public static final String TIMES_TAMP = "times_tamp";

    /**
     * Used to initialize the custom recycler adapter
     *
     * @param context   {@link Context}
     * @param items     {@link ArrayList}  An array list of Map containing the mapping in the view lib_shopping_recycler_item_1. See sample app for usage details.
     * @param loadImage boolean Pass true if the adapter should load the image with Picasso
     */
    public CustomRecyclerAdapterB(Context context, ArrayList<Map<String, String>> items, boolean loadImage) {
        this.context = context;
        this.items = items;
        this.onRecyclerClickListener = (OnRecyclerClickListener) context;
        this.loadImage = loadImage;
    }

    @Override
    public CustomRecyclerAdapterB.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lib_shopping_recycler_item_2, parent, false);
        return new CustomRecyclerAdapterB.RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomRecyclerAdapterB.RecyclerViewHolder holder, final int position) {
        Map<String, String> item = this.items.get(position);
        if (loadImage) {
            Picasso.with(context)
                    .load(item.get(IMAGE_URL))
                    .into(holder.imageViewAvatar);
        } else {
            // holder.imageViewAvatar.setImageDrawable();
        }

        holder.textViewAlertMessage.setText(item.get(TITLE));
        holder.textViewAlertTime.setText(item.get(TIMES_TAMP));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView imageViewAvatar;
        private TextView textViewAlertMessage;
        private TextView textViewAlertTime;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            imageViewAvatar = (ImageView) itemView.findViewById(R.id.imageViewMessageIcon);
            textViewAlertMessage = (TextView) itemView.findViewById(R.id.textViewAlertMessage);
            textViewAlertTime = (TextView) itemView.findViewById(R.id.textViewAlertTime);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            imageViewAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onRecyclerClickListener.onImageClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View v) {
            onRecyclerClickListener.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            return onRecyclerClickListener.onItemLongClick(getAdapterPosition());
        }
    }
}
