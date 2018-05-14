package codingwithmitch.com.firestoregettingstarted;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import codingwithmitch.com.firestoregettingstarted.models.Note;

/**
 * Created by User on 5/14/2018.
 */

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "NoteRecyclerViewAdapter";

    private static final int NOTE_VIEW_ITEM = 1;
    private static final int LOADING_VIEW_ITEM = 2;

    private ArrayList<Note> mNotes = new ArrayList<>();

    public NoteRecyclerViewAdapter(ArrayList<Note> notes) {
        mNotes = notes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;
        if (viewType == NOTE_VIEW_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.layout_note_list_item, parent, false);

            holder = new ViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.layout_loading_list_item, parent, false);

            holder = new LoadingViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolder){
            ((ViewHolder)holder).title.setText(mNotes.get(position).getTitle());

            SimpleDateFormat spf = new SimpleDateFormat("MMM dd, yyyy");
            String date = spf.format(mNotes.get(position).getTimestamp());
            ((ViewHolder)holder).timestamp.setText(date);
        }
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(mNotes.get(position).getTitle().equals("")){
            return LOADING_VIEW_ITEM;
        }
        else{
            return NOTE_VIEW_ITEM;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, timestamp;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            timestamp = itemView.findViewById(R.id.timestamp);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder{

        ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

}
