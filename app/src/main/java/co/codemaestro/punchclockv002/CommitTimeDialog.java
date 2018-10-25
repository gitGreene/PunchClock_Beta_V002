package co.codemaestro.punchclockv002;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CommitTimeDialog extends AppCompatDialogFragment {
    private static final String CURRENT_TIME = "current time";
    CommitTimeFragmentListener mListener;

    //Interface for Interaction with MainActivity
    interface CommitTimeFragmentListener {
        void onChoice(boolean choice);
    }

    // New Instance Method for CommitTimeDialog
    public static CommitTimeDialog newInstance(String currentTime) {
        CommitTimeDialog fragment = new CommitTimeDialog();
        Bundle bundle = new Bundle();
        bundle.putString(CURRENT_TIME, currentTime);
        fragment.setArguments(bundle);

        return fragment;
    }

    // Needed to CommitFragmentListener Interface
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof CommitTimeFragmentListener) {
            mListener = (CommitTimeFragmentListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + getResources().getString(R.string.exception_message));
        }
    }


    // onCreateDialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate Dialog
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.commit_time_dialog, null);

        // Create Local Variable to timeToCommit
        final TextView timeToCommit = view.findViewById(R.id.current_time);

        // If time was passed, put it in the title
        if(getArguments().containsKey(CURRENT_TIME)) {
            timeToCommit.setText(getArguments().getString(CURRENT_TIME));
        }

        // Build the Dialog
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setMessage(getArguments().getString("CURRENT_TIME"));
        alertDialogBuilder.setView(view);

        // Set positive and negative Buttons
        alertDialogBuilder
                .setPositiveButton(R.string.commit_time_confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Use interface to communicate with MainActivity
                mListener.onChoice(true);
            }
        })
                .setNegativeButton(R.string.commit_time_decline_resume_timer, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Use interface to communicate with MainActivity
                mListener.onChoice(false);
                dialog.cancel();
            }
        });

        return alertDialogBuilder.create();
    }

    // May need this to format custom Positive/Negative Buttons
    @Override
    public void onStart() {
        super.onStart();
    }



}
