package co.codemaestro.punchclockv002;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CommitTimeDialog extends AppCompatDialogFragment {
    private TextView commitTimeHeader;
    private TextView timeToCommit;
    private Button commitConfirm;
    private Button commitDecline;
    private String timeToDisplay;
    private static final String CURRENT_TIME = "current time";

    public static CommitTimeDialog newInstance(String currentTime) {
        CommitTimeDialog fragment = new CommitTimeDialog();
        Bundle bundle = new Bundle();
        bundle.putString(CURRENT_TIME, currentTime);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.commit_time_dialog, null);
        final MainActivity main = (MainActivity) getActivity();
        final Text commitTimeHeader = view.findViewById(R.id.commit_time_header);
        final TextView timeToCommit = view.findViewById(R.id.current_time);
        final Button commitConfirm = view.findViewById(R.id.confirm_commit_time_button);
        final Button commitDecline = view.findViewById(R.id.decline_commit_time_button);



        if(getArguments().containsKey(CURRENT_TIME)) {
            timeToCommit.setText(getArguments().getString(CURRENT_TIME));
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setMessage(getArguments().getString("CURRENT_TIME"));
        alertDialogBuilder.setView(view);

//        alertDialogBuilder
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent startTimeDataBase = new Intent(this, TimeDataBase.class);
//                startTimeDataBase.putExtra("CATEGORY_NAME", category);
//                startTimeDataBase.putExtra("TIME_BANK_NAME", timeBankName);
//                savedTime = timeView.getText().toString();  // Fran added this line to get the timer value - 10/9/2018
//                startTimeDataBase.putExtra("CURRENT_TIME", savedTime); //Fran edited this line to take var "savedTime"
//                startActivity(startTimeDataBase);
//            }
//        })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });

        return alertDialogBuilder.create();
    }

    public void commitTime(View view) {
    }


}
