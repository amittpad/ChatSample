package com.amittpad.chatsample;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends BaseAdapter {
    List<ChatMessage> chatMessages = new ArrayList<ChatMessage>();
    Context context;


    public MessageAdapter(Context context) {
        this.context = context;
    }

    public void add(ChatMessage chatMessage) {
        this.chatMessages.add(chatMessage);
        notifyDataSetChanged(); // to render the list we need to notify
    }


    @Override
    public int getCount() {
        return chatMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return chatMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageViewHolder holder = new MessageViewHolder();
        LayoutInflater messageInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ChatMessage chatMessage = chatMessages.get(position);

//        if (chatMessage.isBelongsToCurrentUser()) { // this chatMessage was sent by us so let's create a basic chat bubble on the right
//            convertView = messageInflater.inflate(R.layout.my_message, null);
//            holder.messageBody = (TextView) convertView.findViewById(R.id.message_body);
//            convertView.setTag(holder);
//            holder.messageBody.setText(chatMessage.getText());
//        } else { // this chatMessage was sent by someone else so let's create an advanced chat bubble on the left
//            convertView = messageInflater.inflate(R.layout.their_message, null);
//            holder.avatar = (View) convertView.findViewById(R.id.avatar);
//            holder.name = (TextView) convertView.findViewById(R.id.name);
//            holder.messageBody = (TextView) convertView.findViewById(R.id.message_body);
//            convertView.setTag(holder);
//
//            holder.name.setText(chatMessage.getData());
//            holder.messageBody.setText(chatMessage.getText());
//            GradientDrawable drawable = (GradientDrawable) holder.avatar.getBackground();
//            //drawable.setColor(Color.parseColor(chatMessage.getData().getColor()));
//        }

        return convertView;
    }


    class MessageViewHolder {
        public View avatar;
        public TextView name;
        public TextView messageBody;
    }
}
