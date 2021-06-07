package com.example.talent_manager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
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
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }


    ///////////////////开始///////////////////////////////////


    ChatViewModel chatViewModel;
    RecyclerView recyclerView;
    chat_adapter chatAdapter;

    TextView hiretv;
    TextView fabutv;
    private ChatDao chatDao;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        chatViewModel=ViewModelProviders.of(this).get(ChatViewModel.class);

        hiretv=getActivity().findViewById(R.id.hiretv);
        fabutv=getActivity().findViewById(R.id.fabutv);

        NavController navController=Navigation.findNavController(getActivity(), R.id.fragment4);


       // chatViewModel.deleteAllChats();
        hiretv.setTextColor(getResources().getColor(R.color.btncolor));

        ChatDatabase chatDatabase= ChatDatabase.getDatabase(getContext());
        chatDao=chatDatabase.getChatDao();
        //插入数据
        if(chatDao.getchatcounts()==0) {
            Chat chat1 = new Chat("姓名：王先生", "性别：男", "年龄：29", "技能：网站开发 java web网站业务开发,并能很好的使用缓存技术,对重构有实际的经验,并对面向对 象开发有全面的实战经验。" +
                    " "
                    , "AL技术有限公司", "岗位：java大数据工程师",
                    "薪资：9000", "评价：为人性格,诚实谦虚，勤奋，能吃苦耐劳，有耐心，有团队意识，能和同学和谐相处，能虚心接受别人的建议的人。");
            Chat chat2 = new Chat("姓名：刘小姐", "性别：女", "年龄：23", "技能：擅长Sketch和Adobe Photoshop，重视概念设计，风格定位 。", "TX科技有限公司", "岗位：UI设计师", "8000",
                    "评价：能够了解如何在日程安排和设计项目中保持控制，以及能够确定其分配工作的优先级。在繁忙的设计环境中，能够跟踪工作并使用可提高工作效率的工具。");
            Chat chat3 = new Chat("姓名：张先生", "性别：男", "年龄：42", "技能：具备敏锐的市场观察能力，在这瞬息万变的市场中去捕捉所需信息。", "MT科技有限公司", "岗位：销售", "7000",
                    "评价：拥有敏锐的观察能力，与许多大客户的交流很多。");
            chatViewModel.insertChats(chat1, chat2,chat3);
        }




        hiretv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.chatHireFragment);
                fabutv.setTextColor(getResources().getColor(R.color.btnfalsecolor));
                hiretv.setTextColor(getResources().getColor(R.color.btncolor));
//                Chat chat1=new Chat("刘先生","男","29","擅长Android","今目标有限公司");
//                Chat chat2=new Chat("王女士","女","23","擅长AI","jinmubiao");
//                chatViewModel.insertChats(chat1,chat2);
            }
        });
        fabutv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.chatPlusFragment);
                hiretv.setTextColor(getResources().getColor(R.color.btnfalsecolor));
                fabutv.setTextColor(getResources().getColor(R.color.btncolor));
//                chatViewModel.deleteAllChats();
            }
        });
    }

}