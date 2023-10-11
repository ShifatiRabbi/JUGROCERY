package com.example.jugrocery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageDetailsAdapter extends RecyclerView.Adapter<ImageDetailsAdapter.ViewHolder> {
    private Context context;
    private List<ImageDetails> imageDetailsList;
    public ImageDetailsAdapter(Context context, List<ImageDetails> imageDetailsList) {
        this.context = context;
        this.imageDetailsList = imageDetailsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageDetails imageDetails = imageDetailsList.get(position);

        holder.titleTextView.setText(imageDetails.gettitle());
        holder.categoryTextView.setText(imageDetails.getcategory());
        holder.descriptionTextView.setText(imageDetails.getdescription());
        holder.amountTextView.setText(imageDetails.getamount());
        holder.avnumTextView.setText(imageDetails.getavnum());
        // Bind other details as needed
    }

    @Override
    public int getItemCount() {
        return imageDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView categoryTextView;
        TextView descriptionTextView;
        TextView amountTextView;
        TextView avnumTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.blogtitle);
            categoryTextView = itemView.findViewById(R.id.blogcategory);
            descriptionTextView = itemView.findViewById(R.id.blogdescription);
            amountTextView = itemView.findViewById(R.id.blogamount);
            avnumTextView = itemView.findViewById(R.id.blogavnum);
        }
    }
}
