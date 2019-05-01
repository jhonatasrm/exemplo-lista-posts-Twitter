package com.jhonatasrm.exemplo_lista_posts_twitter.Activities.Activities.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jhonatasrm.exemplo_lista_posts_twitter.Activities.Activities.Model.Comments;
import com.jhonatasrm.exemplo_lista_posts_twitter.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommetsAdapter extends BaseAdapter {

    private final List<Comments> comments;
    private final Activity activity;
    private TextView username, name, hour, likes, retweets, textComment;
    private CircleImageView profileImage;
    private ImageButton arrow, liked, retweeted, commented, share;

    public CommetsAdapter(List<Comments> comments, Activity activity) {
        this.comments = comments;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, final View convertView, final ViewGroup parent) {
        final View view = activity.getLayoutInflater().inflate(R.layout.comments_layout, parent, false);

        final Comments comment = comments.get(position);

        name = view.findViewById(R.id.name);
        username = view.findViewById(R.id.username);
        hour = view.findViewById(R.id.hour);
        likes = view.findViewById(R.id.likes);
        retweets = view.findViewById(R.id.retweets);
        textComment = view.findViewById(R.id.textComment);
        profileImage = view.findViewById(R.id.profileImage);
        arrow = view.findViewById(R.id.arrow);
        liked = view.findViewById(R.id.liked);
        retweeted = view.findViewById(R.id.retweeted);
        commented = view.findViewById(R.id.commented);
        share = view.findViewById(R.id.share);

        name.setText(comment.getName());
        username.setText(comment.getUsername());
        hour.setText(comment.getHour());
        likes.setText(String.valueOf(comment.getLikes()));
        retweets.setText(String.valueOf(comment.getRetweets()));
        textComment.setText(comment.getTextComment());
        profileImage.setImageResource(comment.getProfileImage());

        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Likes: " + comment.getLikes(), Toast.LENGTH_SHORT).show();
            }
        });

        retweeted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Retweets: " + comment.getRetweets(), Toast.LENGTH_SHORT).show();
            }
        });

        commented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "0 " + view.getResources().getString(R.string.comment), Toast.LENGTH_SHORT).show();
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), R.string.more_options, Toast.LENGTH_SHORT).show();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), R.string.share, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
