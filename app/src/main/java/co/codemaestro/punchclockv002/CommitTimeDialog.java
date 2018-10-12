package co.codemaestro.punchclockv002;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CommitTimeDialog extends AppCompatDialogFragment {
    private TextView commitTimeHeader;
    private TextView currentTime;
    private Button commitConfirm;
    private Button commitDecline;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.commit_time_dialog, null);

        builder.setView(view);
        return builder.create();
    }

    public static CommitTimeDialog newInstance() {
        return new CommitTimeDialog();
    }

}
