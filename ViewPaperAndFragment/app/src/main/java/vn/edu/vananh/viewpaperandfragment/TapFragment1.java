package vn.edu.vananh.viewpaperandfragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TapFragment1 extends android.support.v4.app.Fragment {

    private TextView txtProfile;
    private TextView txtHerLove;

    public TapFragment1() {
        // Required empty public constructor
    }

    public interface ChuyenTap{
        public void chuyenTap(int tap);
    }

    ChuyenTap mCallBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView1 = inflater.inflate(R.layout.tap_fragment_1, container, false);

        txtProfile = rootView1.findViewById(R.id.txtProfile);
        txtHerLove = rootView1.findViewById(R.id.txtHerLove);

        txtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.chuyenTap(1);
            }
        });

        txtHerLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.chuyenTap(2);
            }
        });

        return rootView1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallBack = (ChuyenTap)getActivity();
    }
}
