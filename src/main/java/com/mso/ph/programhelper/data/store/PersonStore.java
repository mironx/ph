package com.mso.ph.programhelper.data.store;

import com.mso.ph.programhelper.data.model.person.PersonsData;
import com.mso.ph.programhelper.json.JsonUtil;

import java.io.IOException;
import java.nio.file.Path;

public class PersonStore {
    public static void SavePerson(String filename, PersonsData data) throws IOException {
        JsonUtil.toJsonFile (Path.of(filename),data);
    }

    public static PersonsData LoadPerson(String filename) throws IOException {
        return JsonUtil.fromJsonFile(Path.of(filename), PersonsData.class);
    }
}
