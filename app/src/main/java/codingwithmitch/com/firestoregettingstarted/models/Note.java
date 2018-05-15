package codingwithmitch.com.firestoregettingstarted.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

/**
 * Created by User on 5/14/2018.
 */

@IgnoreExtraProperties
public class Note implements Parcelable{

    private String title;
    private String content;
    private @ServerTimestamp Date timestamp;
    private String note_id;
    private String user_id;

    public Note(String title, String content, Date timestamp, String note_id, String user_id) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.note_id = note_id;
        this.user_id = user_id;
    }

    public Note() {

    }

    protected Note(Parcel in) {
        title = in.readString();
        content = in.readString();
        note_id = in.readString();
        user_id = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getNote_id() {
        return note_id;
    }

    public void setNote_id(String note_id) {
        this.note_id = note_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(note_id);
        parcel.writeString(user_id);
    }
}
