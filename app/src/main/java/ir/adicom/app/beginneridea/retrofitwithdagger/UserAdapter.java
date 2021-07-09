package ir.adicom.app.beginneridea.retrofitwithdagger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.adicom.app.beginneridea.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapderViewHolder> {
    private List<CustomUser> customUsers;

    public UserAdapter(List<CustomUser> customUsers) {
        this.customUsers = customUsers;
    }

    @NonNull
    @Override
    public UserAdapderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserAdapderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapderViewHolder holder, int position) {
        CustomUser customUser = customUsers.get(position);
        StringBuilder builder = new StringBuilder();
        builder.append(customUser.name).append("\n")
                .append(customUser.email).append("\n")
                .append(customUser.phone).append("\n")
                .append(customUser.username).append("\n")
                .append(customUser.website);

        holder.tvUser.setText(builder.toString());
    }

    @Override
    public int getItemCount() {
        return customUsers.size();
    }

    public class UserAdapderViewHolder extends RecyclerView.ViewHolder {
        public TextView tvUser;

        public UserAdapderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tv_user);
        }
    }
}
