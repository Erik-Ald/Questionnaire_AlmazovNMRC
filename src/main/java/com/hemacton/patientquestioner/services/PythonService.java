package com.hemacton.patientquestioner.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class PythonService {

    public String sentToPython(String type,String id) {

        String[] cmd = new String[]{"python3", "Processors/"+type + "/main.py", id};

        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                return s;
            }
            while ((s = stdError.readLine()) != null) {
                return s;
            }
            stdError.close();
            stdInput.close();
        } catch (IOException e) {
            return e.toString();
        }
        return "successful";
    }

}
