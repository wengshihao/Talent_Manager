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


    ///////////////////??????///////////////////////////////////


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
        //????????????
        if(chatDao.getchatcounts()==0) {
            Chat chat1 = new Chat("??????????????????", "????????????", "?????????29", "????????????????????? java web??????????????????,?????????????????????????????????,???????????????????????????,??????????????? ????????????????????????????????????" +
                    " "
                    , "AL??????????????????", "?????????java??????????????????",
                    "?????????9000", "?????????????????????,??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
            Chat chat2 = new Chat("??????????????????", "????????????", "?????????23", "???????????????Sketch???Adobe Photoshop???????????????????????????????????? ???", "TX??????????????????", "?????????UI?????????", "8000",
                    "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
            Chat chat3 = new Chat("??????????????????", "????????????", "?????????42", "???????????????????????????????????????????????????????????????????????????????????????????????????", "MT??????????????????", "???????????????", "7000",
                    "???????????????????????????????????????????????????????????????????????????");
            chatViewModel.insertChats(chat1, chat2,chat3);
        }




        hiretv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.chatHireFragment);
                fabutv.setTextColor(getResources().getColor(R.color.btnfalsecolor));
                hiretv.setTextColor(getResources().getColor(R.color.btncolor));
//                Chat chat1=new Chat("?????????","???","29","??????Android","?????????????????????");
//                Chat chat2=new Chat("?????????","???","23","??????AI","jinmubiao");
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