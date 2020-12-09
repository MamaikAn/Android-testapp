package com.example.testhtc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {
    @NonNull
    public AlertDialogFragment newInstance(@NonNull String message) {
        AlertDialogFragment frag = new AlertDialogFragment();
        Bundle args = new Bundle();

        args.putString("message", message);
        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Error");
        builder.setMessage(getArguments().getString("message"));

        return builder.create();
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        getActivity().finishAffinity();
    }
}
