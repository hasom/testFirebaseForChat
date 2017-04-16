package com.hasom.testfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hasom.testfirebase.adapter.ChatAdapter;
import com.hasom.testfirebase.domain.ChatData;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    RecyclerView listView;
    LinearLayoutManager mLayoutManager;
    ChatAdapter mAdapter;

    @BindView(R.id.btnSend)
    Button btnSend;

    @BindView(R.id.etText)
    EditText etText;

    /**
     * User ID
     */
    private String userName;


    /**
     * Firebase
     */
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        // 랜덤한 유저 이름 설정 ex) user1234
        userName = "user" + new Random().nextInt(10000);

        mAdapter = new ChatAdapter(this);
        mLayoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(mLayoutManager);
        listView.setAdapter(mAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 유저 이름과 메세지로 chatData 만들기
                ChatData chatData = new ChatData(userName, etText.getText().toString());

                // 기본 database 하위 message라는 child에 chatData를 list로 만들기
                databaseReference.child("message").push().setValue(chatData);

                etText.setText("");
            }
        });

        // message는 child의 이벤트를 수신합니다.
        databaseReference.child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // chatData를 가져오고
                ChatData chatData = dataSnapshot.getValue(ChatData.class);

                // adapter에 추가합니다.
                mAdapter.addListItem(chatData.getUserName() + "\n" + chatData.getMessage());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }
}
