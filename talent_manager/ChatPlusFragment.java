package com.example.talent_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatPlusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatPlusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatPlusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatPlusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatPlusFragment newInstance(String param1, String param2) {
        ChatPlusFragment fragment = new ChatPlusFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_plus, container, false);
    }

    ChatViewModel chatViewModel;
    public String flag;
    TextView hiretv;
    TextView fabutv;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        chatViewModel= ViewModelProviders.of(this).get(ChatViewModel.class);

        EditText nameet=getActivity().findViewById(R.id.nameedps);
        String sex="";
        CheckBox male=getActivity().findViewById(R.id.malecb);
        CheckBox female=getActivity().findViewById(R.id.femalecb);
        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) flag="男";
            }
        });
        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)flag="女";
            }
        });

        EditText ageet=getActivity().findViewById(R.id.ageedps);
        EditText gangweiet=getActivity().findViewById(R.id.gangweiedps);
        EditText xinziet=getActivity().findViewById(R.id.xinziedps);
        EditText pingjiaet=getActivity().findViewById(R.id.pingjiaedps);
        EditText skillet=getActivity().findViewById(R.id.skilledps);

        Button button=getActivity().findViewById(R.id.chatfabubtn);
        NavController navController= Navigation.findNavController(getActivity(), R.id.fragment4);

        hiretv=getActivity().findViewById(R.id.hiretv);
        fabutv=getActivity().findViewById(R.id.fabutv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chat chat=new Chat(nameet.getText().toString(),
                        flag,ageet.getText().toString(),skillet.getText().toString(),
                        "今目标有限公司",gangweiet.getText().toString(),
                        xinziet.getText().toString(),pingjiaet.getText().toString());
                chatViewModel.insertChats(chat);
                navController.navigate(R.id.chatHireFragment);
                fabutv.setTextColor(getResources().getColor(R.color.btnfalsecolor));
                hiretv.setTextColor(getResources().getColor(R.color.btncolor));
                Toast.makeText(getContext(),"发布成功",Toast.LENGTH_SHORT).show();
            }
        });

    }
}